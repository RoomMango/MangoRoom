package com.javagirls.MangoRoom.service;

import com.javagirls.MangoRoom.dto.ReservationDto;
import com.javagirls.MangoRoom.dto.RoomDto;
import com.javagirls.MangoRoom.entity.Room;
import com.javagirls.MangoRoom.exceptions.RoomNotFoundException;
import com.javagirls.MangoRoom.mapper.RoomMapper;
import com.javagirls.MangoRoom.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

    public Room findById (int roomNumber) {
        return roomRepository.findById(roomNumber).orElseThrow(() -> {
            throw new RoomNotFoundException(roomNumber);
        });
    }

    public List<ReservationDto> getReservations(int roomNumber) {
        return reservationService.getRoomReservations(findById(roomNumber)).stream()
                .filter((reservationDto) -> reservationDto.getCheckOut().compareTo(LocalDateTime.now()) > 0)
                .collect(Collectors.toList());
    }

    public void removeRoom(int roomNumber) {
        Room room = findById(roomNumber);
        roomRepository.delete(room);
    }

}
