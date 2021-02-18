package com.javagirls.MangoRoom.service;

import com.javagirls.MangoRoom.dto.RoomDTO;
import com.javagirls.MangoRoom.entity.Room;
import com.javagirls.MangoRoom.repository.RoomRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class RoomServiceTest {


    @MockBean
    private RoomRepository repository;
    @Autowired
    private RoomService service;

    @Test
    void changeRoomStatus_fromTrueToFalse() {
        Room room = new Room();
        room.setRoomNumber(23);
        room.setAvailableForBooking(true);
        room.setPrice(new BigDecimal(200.00));
        when(repository.findById(room.getRoomNumber())).thenReturn(java.util.Optional.of(room));
        RoomDTO roomDTO = service.changeRoomStatus(room.getRoomNumber());
        Assertions.assertThat(roomDTO.isAvailableForBooking()).isEqualTo(false);
    }

    @Test
    void changeRoomStatus_fromFalseToTrue() {
        Room room = new Room();
        room.setRoomNumber(23);
        room.setAvailableForBooking(false);
        room.setPrice(new BigDecimal(200.00));
        when(repository.findById(room.getRoomNumber())).thenReturn(java.util.Optional.of(room));
        RoomDTO roomDTO = service.changeRoomStatus(room.getRoomNumber());
        Assertions.assertThat(roomDTO.isAvailableForBooking()).isEqualTo(true);
    }
}