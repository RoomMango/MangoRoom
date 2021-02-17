package com.javagirls.MangoRoom.dto;

import com.javagirls.MangoRoom.enumeration.RoomType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoomDTO {

    private int roomNumber;
    @Min(1)
    @Max(5)
    private int beds;
    private boolean extraBedAvailable;
    @NotBlank
    private BigDecimal price;
    private boolean balcony;
    private RoomType roomType;
    private boolean isAvailableForBooking;
}
