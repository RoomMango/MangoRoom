package com.javagirls.MangoRoom.mock;

import com.javagirls.MangoRoom.dto.RoomDto;

import java.math.BigDecimal;

public class RoomDtoMock {

    public RoomDtoMock() {
    }

    public static RoomDto getBasicRoomDto() {
        RoomDto roomDto = new RoomDto();
        roomDto.setRoomNumber(1);
        roomDto.setPrice(new BigDecimal(300));
        roomDto.setBeds(5);
        return roomDto;
    }
}
