package com.javagirls.MangoRoom.entity;

import com.javagirls.MangoRoom.enumeration.RoomType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
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
    @UniqueElements
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
