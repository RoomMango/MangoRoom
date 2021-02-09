package com.javagirls.MangoRoom.service;

import com.javagirls.MangoRoom.dto.RoomDTO;
import com.javagirls.MangoRoom.entity.Room;
import com.javagirls.MangoRoom.mapper.RoomMapper;
import com.javagirls.MangoRoom.repository.RoomRepository;
import org.springframework.stereotype.Service;


@Service
public class RoomService {

    private RoomRepository roomRepository;
    private RoomMapper mapper;

    public RoomService(RoomRepository roomRepository, RoomMapper mapper) {
        this.roomRepository = roomRepository;
        this.mapper = mapper;
    }

    public void save(Room room) {
        roomRepository.save(room);
    }

    public RoomDTO changeRoomStatus(int id) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("This room is not found"));
        room.setRoomStatus(!room.isRoomStatus());
        Room save = roomRepository.save(room);
       return mapper.map(save, RoomDTO.class);
    }
}
