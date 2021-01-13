package com.javagirls.MangoRoom.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "quest")
public class Quest {
    @Id
    @GeneratedValue
    private String id;
    private String firstName;
    private String lastName;
    private String idNumber;
    private String phoneNumber;
    private String streetName;
    private int addressNumber;
    private String zip;
    private String city;
    private String country;

    public int getAddressNumber() {
        return addressNumber;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCountry() {
        return country;
    }
}
