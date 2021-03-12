package com.javagirls.MangoRoom.controller;

import com.javagirls.MangoRoom.dto.ReservationDto;

import com.javagirls.MangoRoom.enumeration.Status;
import com.javagirls.MangoRoom.service.ReservationService;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private ReservationService service;

    public ReservationController(ReservationService service) {
        this.service = service;
    }

    @PostMapping(produces = "application/json")
    public Long addReservation(@RequestBody ReservationDto reservation) {
        return service.saveReservation(reservation);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Status> changeReservationStatus(@PathVariable Long id, @RequestParam Status status) {
        return ResponseEntity.ok(service.changeReservationStatus(id, status));
    }

    @GetMapping()
    public List<ReservationDto> allReservations(@RequestParam(required = false) String time) {
        return service.findAllWithTime(time);
    }

}
