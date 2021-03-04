package com.javagirls.MangoRoom.controller;

import java.util.List;

import com.javagirls.MangoRoom.dto.ReservationDto;
import com.javagirls.MangoRoom.entity.Reservation;
import com.javagirls.MangoRoom.enumeration.Status;
import com.javagirls.MangoRoom.service.ReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private ReservationService service;

    public ReservationController(ReservationService service) {
        this.service = service;
    }

    @PostMapping(produces = "application/json")
    public Reservation addReservation(@RequestBody ReservationDto reservation) {
        return service.saveReservation(reservation);
    }

    @GetMapping
    public List<ReservationDto> getAllReservations() {
        return service.getAllReservations();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> changeReservationStatus(@PathVariable Long id, @RequestParam Status status) {
        String message = "Reservation status updated successfully!";
        service.changeReservationStatus(id, status);
        return ResponseEntity.ok(message);
    }


}
