package com.javagirls.MangoRoom.controller;

import com.javagirls.MangoRoom.dto.RoomDTO;
import com.javagirls.MangoRoom.service.RoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RoomController {

    private RoomService service;

    public RoomController(RoomService service) {
        this.service = service;
    }

    @PostMapping("/room")
    public RoomDTO exclusionRoomFromBooking(RoomDTO room) {
       return service.changeRoomStatus(room.getRoomNumber());

    }

}
