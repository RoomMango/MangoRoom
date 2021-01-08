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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Guest guest = (Guest) o;
        return Objects.equals(id, guest.id) &&
                Objects.equals(firstName, guest.firstName) &&
                Objects.equals(lastName, guest.lastName) &&
                Objects.equals(idCardNumber, guest.idCardNumber) &&
                Objects.equals(phoneNumber, guest.phoneNumber) &&
                Objects.equals(street, guest.street) &&
                Objects.equals(number, guest.number) &&
                Objects.equals(postalCode, guest.postalCode) &&
                Objects.equals(city, guest.city) &&
                Objects.equals(country, guest.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, idCardNumber, phoneNumber, street, number, postalCode, city, country);
    }

    @Override
    public String toString() {
        return "Guest{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", idCardNumber='" + idCardNumber + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", street='" + street + '\'' +
                ", number=" + number +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
