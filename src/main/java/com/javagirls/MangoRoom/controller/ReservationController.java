package com.javagirls.MangoRoom.controller;

import com.javagirls.MangoRoom.dto.ReservationDto;
import com.javagirls.MangoRoom.entity.Reservation;
import com.javagirls.MangoRoom.enumeration.Status;
import com.javagirls.MangoRoom.service.ReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservationController {

    private ReservationService service;

    public ReservationController(ReservationService service) {
        this.service = service;
    }

    @PostMapping("/reservation")
    public Reservation addReservation(@RequestBody ReservationDto reservation) {
        return service.saveReservation(reservation);
    }

    @PutMapping("/reservation/{id}")
    public ResponseEntity<String> changeReservationStatus(@PathVariable Long id, @RequestParam Status status) {
        String message = "Reservation status updated successfully!";
        service.changeReservationStatus(id, status);
        return ResponseEntity.ok(message);
    }


    @GetMapping("/reservations")
    public List<ReservationDto> allReservations(@RequestParam(required = false) String time) {

        return service.findAllWithTime(time);
    }

}
