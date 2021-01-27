package com.javagirls.MangoRoom.controller;

import com.javagirls.MangoRoom.service.ReservationService;
import org.springframework.stereotype.Controller;

@Controller
public class ReservationController {

    private ReservationService service;

    public ReservationController(ReservationService service) {
        this.service = service;
    }
}
