package com.javagirls.MangoRoom.mock;


import com.javagirls.MangoRoom.entity.Reservation;
import com.javagirls.MangoRoom.entity.Room;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RoomMock {

    public RoomMock() {
    }

    public static Room getBasicRoom() {
        Room room = new Room();
        Random random = new Random();
        int number = random.nextInt();
        room.setRoomNumber(number);
        room.setPrice(new BigDecimal(300));
        room.setClean(true);
        room.setBeds(5);
        return room;
    }

    public static Room getReservedRoom(){

        Reservation reservation = ReservationMock.getBasicReservation();
        List<Reservation> basicReservations = new ArrayList<>();
        basicReservations.add(reservation);

        Room room = new Room();
        Random random = new Random();
        int number = random.nextInt();
        room.setRoomNumber(number);
        room.setPrice(new BigDecimal(300));
        room.setClean(true);
        room.setBeds(5);
        room.setReservations(basicReservations);
        return room;
    }
}
