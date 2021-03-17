package com.javagirls.MangoRoom.service;

import com.javagirls.MangoRoom.dto.ReservationDto;
import com.javagirls.MangoRoom.dto.RoomDto;
import com.javagirls.MangoRoom.entity.Reservation;
import com.javagirls.MangoRoom.entity.Room;
import com.javagirls.MangoRoom.exceptions.RoomNotFoundException;
import com.javagirls.MangoRoom.mapper.RoomMapper;
import com.javagirls.MangoRoom.repository.RoomRepository;
import lombok.AllArgsConstructor;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RoomService {

    private RoomRepository roomRepository;
    private RoomMapper mapper;
    private ReservationService reservationService;

    @Transactional
    public List<RoomDto> findAllRooms() {
        List<Room> roomsEntity = roomRepository.findAll();
        return roomsEntity.stream()
                .map((room) -> mapper.map(room, RoomDto.class)).collect(Collectors.toList());
    }

    @Transactional
    public Room saveRoom(RoomDto roomDto) {
        Room room = mapper.map(roomDto, Room.class);
        return roomRepository.save(room);

    }

    public RoomDto changeRoomStatus(int id) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("This room is not found"));
        room.setAvailableForBooking(!room.isAvailableForBooking());
        roomRepository.save(room);
        return mapper.map(room, RoomDto.class);
    }

    private Room findById (int roomNumber) {
        return roomRepository.findById(roomNumber).orElseThrow(() -> {
            throw new RoomNotFoundException();
        });
    }

    public List<ReservationDto> getReservations(int roomNumber) {
        return reservationService.getRoomReservations(findById(roomNumber)).stream()
                .filter((reservationDto) -> reservationDto.getCheckOut().compareTo(LocalDateTime.now()) > 0)
                .collect(Collectors.toList());
    }

    public List<RoomDto> findFreeRooms(String start, String end) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime startDate = LocalDateTime.parse(start + " 10:00:00", formatter);
        LocalDateTime endDate = LocalDateTime.parse(end + " 10:00:00", formatter);

        List<Integer> reserved = reservationService.findAllReservationsDto().stream()
                .filter(reservationDto -> (reservationDto.getCheckOut().truncatedTo(ChronoUnit.DAYS)
                        .isAfter(startDate.truncatedTo(ChronoUnit.DAYS))
                        && (reservationDto.getCheckIn().truncatedTo(ChronoUnit.DAYS)
                        .isBefore(endDate.truncatedTo(ChronoUnit.DAYS)))))
                .map(reservationDto -> reservationDto.getRoom().getRoomNumber())
                .collect(Collectors.toList());

        List<RoomDto> allRooms = findAllRooms();

        allRooms.removeIf(room -> (reserved.contains(room.getRoomNumber())));

        return allRooms;
    }

}
