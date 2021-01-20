package com.javagirls.MangoRoom.controller;

import com.javagirls.MangoRoom.service.RoomService;
import org.springframework.stereotype.Controller;

@Controller
public class RoomController {

    private RoomService service;

    public RoomController(RoomService service) {
        this.service = service;
    }
}
