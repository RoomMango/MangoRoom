package com.javagirls.MangoRoom.service;

import com.javagirls.MangoRoom.entity.Reservation;
import com.javagirls.MangoRoom.entity.Room;
import com.javagirls.MangoRoom.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

    private RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository repository) {
        this.roomRepository = repository;
    }

    public void save(Room room) {
        roomRepository.save(room);
    }
}
