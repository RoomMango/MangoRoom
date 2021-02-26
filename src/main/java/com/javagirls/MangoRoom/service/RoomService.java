package com.javagirls.MangoRoom.service;

import com.javagirls.MangoRoom.dto.RoomDto;
import com.javagirls.MangoRoom.entity.Room;
import com.javagirls.MangoRoom.mapper.RoomMapper;
import com.javagirls.MangoRoom.repository.RoomRepository;
import lombok.AllArgsConstructor;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@AllArgsConstructor
public class RoomService {

    private RoomRepository roomRepository;
    private RoomMapper mapper;

    public List<Room> findAllRooms() {
        return roomRepository.findAll();
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
}
