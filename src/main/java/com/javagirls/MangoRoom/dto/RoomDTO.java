package com.javagirls.MangoRoom.dto;

import com.javagirls.MangoRoom.enumeration.RoomType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoomDTO {

    private Integer roomNumber;
    private int beds;
    private boolean extraBedAvailable;

    @NotBlank
    private BigDecimal price;
    private boolean balcony;
    private RoomType roomType;
    private boolean roomStatus;
}
