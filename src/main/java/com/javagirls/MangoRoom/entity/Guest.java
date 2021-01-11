package com.javagirls.MangoRoom.entity;


import lombok.Data;

import javax.persistence.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

@Data
@Entity
@Table(name = "guest")
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Column(name = "first_name")
    String firstName;

    @NotBlank
    @Column(name = "last_name")
    String lastName;

    @NotBlank
    @Size(min = 5)
    @Column(name = "id_card_number")
    String idCardNumber;

    @NotBlank
    @Size(min = 9)
    @Column(name = "phone_number")
    String phoneNumber;

    @NotBlank
    @Column(name = "street")
    String street;

    @Column(name = "number")
    Integer number;

    @NotBlank
    @Size(min = 2)
    @Column(name = "postal_code")
    String postalCode;

    @NotBlank
    @Column(name = "city")
    String city;

    @NotBlank
    @Column(name = "country")
    String country;

}
