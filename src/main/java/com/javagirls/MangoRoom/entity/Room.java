package com.javagirls.MangoRoom.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue
    private String id;
    private int number;
    private int beds;
    private BigDecimal price;
    @OneToOne
    private Reservation reservation;

    private Balcony balcony;
    private View view;

    public static enum Balcony{
        YES, NO;
    }
    public static enum View{
        STREET, GARDEN
    }
}
