package com.javagirls.MangoRoom.controller;

import com.javagirls.MangoRoom.dto.ReservationDto;
import com.javagirls.MangoRoom.dto.RoomDto;
import com.javagirls.MangoRoom.entity.Room;
import com.javagirls.MangoRoom.service.RoomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    private RoomService service;

    public RoomController(RoomService service) {
        this.service = service;
    }

    @GetMapping
    public List<RoomDto> getAllRooms() {
       return service.findAllRooms();
    }

    @PostMapping
    public Room addRoom(@RequestBody RoomDto room) {
       return service.saveRoom(room);
    }

    @PutMapping("/{id}")
    public RoomDto exclusionRoomFromBooking(@PathVariable int id) {
        return service.changeRoomStatus(id);
    }

    @GetMapping("/{id}/reservations")
    public List<ReservationDto> getRoomReservationPlan(@PathVariable int id) {
        return service.getReservations(id);
    }

    @DeleteMapping("/{id}")
    public void removeRoom(@PathVariable int id) {
        service.removeRoom(id);
    }

}
