package com.javagirls.MangoRoom.service;

import com.javagirls.MangoRoom.repository.RoomRepository;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

    private RoomRepository repository;

    public RoomService(RoomRepository repository) {
        this.repository = repository;
    }
}
