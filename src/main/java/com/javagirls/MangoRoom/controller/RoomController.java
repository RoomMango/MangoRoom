package com.javagirls.MangoRoom.controller;

import com.javagirls.MangoRoom.dto.RoomDto;
import com.javagirls.MangoRoom.entity.Room;
import com.javagirls.MangoRoom.service.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoomController {

    private RoomService service;

    public RoomController(RoomService service) {
        this.service = service;
    }

    @GetMapping("/rooms")
    public List<Room> getAllRooms() {
       return service.findAllRooms();
    }

    @PostMapping("/room")
    public void addRoom(RoomDto room) {
       service.saveRoom(room);
    }

    @PutMapping("/room")
    public RoomDto exclusionRoomFromBooking(RoomDto room) {
        return service.changeRoomStatus(room.getRoomNumber());
    }

}
