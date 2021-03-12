package com.javagirls.MangoRoom.controller;

import com.javagirls.MangoRoom.entity.Guest;
import com.javagirls.MangoRoom.service.GuestService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/guests")
public class GuestController {

    private final GuestService guestService;

    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @PostMapping
    public Guest add(@Valid @RequestBody Guest guest) {
        return guestService.add(guest);
    }

    @GetMapping
    public List<Guest> getAll() {
        return guestService.getAll();
    }

    @GetMapping("/{id}")
    public Guest findById(@PathVariable Long id) {
        return guestService.findById(id);
    }

    @GetMapping("/findByIdCard")
    public Guest findByIdCardNumber(@RequestParam String idCardNumber) {
        return guestService.findByIdCardNumber(idCardNumber);
    }

    @GetMapping("/findByFirstNameAndLastName")
    public List<Guest> findByFirstNameAndLastName(@RequestParam String firstName, @RequestParam String lastName) {
        return guestService.findByFirstNameAndLastName(firstName, lastName);
    }

    //TODO
    @PutMapping
    public Guest update(@RequestParam Long id, @RequestParam String fieldToUpdate, @RequestParam String updatedValue) {
        return guestService.update(id, fieldToUpdate, updatedValue);
    }

    @DeleteMapping
    public void delete(@RequestParam Long id) {
        guestService.remove(id);
    }
}
