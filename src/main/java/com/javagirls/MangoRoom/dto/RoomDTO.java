package com.javagirls.MangoRoom.dto;

import com.javagirls.MangoRoom.enumeration.RoomType;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

public class RoomDTO {

    private Integer room;
    private int beds;
    private boolean extraBedAvailable;

    @NotBlank
    private BigDecimal price;
    private boolean balcony;
    private RoomType roomType;

}
