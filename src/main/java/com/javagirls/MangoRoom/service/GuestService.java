package com.javagirls.MangoRoom.service;

import com.javagirls.MangoRoom.entity.Guest;
import com.javagirls.MangoRoom.errors.GuestExistException;
import com.javagirls.MangoRoom.errors.NoGuestFoundException;
import com.javagirls.MangoRoom.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GuestService {

    private final GuestRepository guestRepository;

    @Autowired
    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    public Guest add(Guest guest) {

        guestRepository.findAll().stream()
                .filter((Guest g) -> g.getIdCardNumber().equals(guest.getIdCardNumber()))
                .findAny()
                .ifPresent((Guest g) -> {
                    throw new GuestExistException();
                });
        return guestRepository.save(guest);
    }

    public List<Guest> getAll() {
        return guestRepository.findAll();
    }

    public Guest findById(Long id) {
        return guestRepository.findById(id)
                .orElseThrow(() -> {
                    throw new NoGuestFoundException();
                });
    }

    public List<Guest> findByFirstNameAndLastName (String firstName, String lastName) {
        return guestRepository.findAllByFirstNameAndLastName(firstName, lastName);
    }

    public Guest findByIdCardNumber (String idCardNumber) {
        return guestRepository.findAllByIdCardNumber(idCardNumber);
    }

}
