package com.javagirls.MangoRoom.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "reservation")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue
    private String id;

    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
    private Currency currency;

    @OneToMany
    private List<Room> rooms;

    public static enum Currency {
        PLN, EUR
    }
}
