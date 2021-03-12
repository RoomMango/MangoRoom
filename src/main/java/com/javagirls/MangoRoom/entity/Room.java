package com.javagirls.MangoRoom.entity;

import com.javagirls.MangoRoom.enumeration.RoomType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "room")
public class Room {

    @Id
    private int roomNumber;
    private int beds;

    @Column(name = "extra_bed_available")
    private boolean extraBedAvailable;
    private BigDecimal price;

    private boolean balcony;

    @Column(name = "is_clean")
    private boolean isClean;

    @Column(name = "room_type")
    private RoomType roomType;

    @OneToMany (mappedBy = "room")
    private List<Reservation> reservations = new ArrayList<>();

    private boolean isAvailableForBooking;
}
