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

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "room")
public class Room {

    @Id
    private Integer number;

    @Min(1)
    @Max(5)
    private int beds;

    @Column(name = "extra_bed_available")
    private boolean extraBedAvailable;

    @NotBlank
    private BigDecimal price;

    @OneToOne
    private Reservation reservation;

    private boolean balcony;

    @Column(name = "is_clean")
    private boolean isClean;

    @Column(name = "room_type")
    private RoomType roomType;
}
