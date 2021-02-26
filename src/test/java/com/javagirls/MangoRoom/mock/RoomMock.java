package com.javagirls.MangoRoom.mock;


import com.javagirls.MangoRoom.entity.Room;


import java.math.BigDecimal;

public class RoomMock {

    public RoomMock() {
    }

    public static Room getBasicRoom() {
        Room room = new Room();
        room.setRoomNumber(1);
        room.setPrice(new BigDecimal(300));
        room.setClean(true);
        room.setBeds(5);
        return room;
    }
}
