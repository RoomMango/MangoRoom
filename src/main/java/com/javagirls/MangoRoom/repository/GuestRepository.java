package com.javagirls.MangoRoom.repository;

import com.javagirls.MangoRoom.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GuestRepository extends JpaRepository<Guest, Long> {

    List<Guest> findAllByFirstNameAndLastName (String firstName, String lastName);
    Guest findByIdCardNumber(String idCardNumber);

}
