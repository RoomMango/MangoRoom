package com.javagirls.MangoRoom.controller;

import com.javagirls.MangoRoom.dto.RoomDto;
import com.javagirls.MangoRoom.service.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RoomController {

    private RoomService service;

    public RoomController(RoomService service) {
        this.service = service;
    }

    @PostMapping("/room")
    public void addRoom(RoomDto room) {
        service.saveRoom(room);
    }

    @PostMapping("/room")
    public RoomDto exclusionRoomFromBooking(RoomDto room) {
        return service.changeRoomStatus(room.getRoomNumber());
    }

}
