package com.javagirls.MangoRoom.service;

import com.javagirls.MangoRoom.dto.RoomDTO;
import com.javagirls.MangoRoom.entity.Room;
import com.javagirls.MangoRoom.repository.RoomRepository;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
class RoomServiceTest {


    @MockBean
    private RoomRepository repository;
    @Autowired
    private RoomService service;


    @Before
    public void setUp() {
        Room room = new Room();
        room.setRoomNumber(23);
        room.setRoomStatus(true);
        room.setPrice(new BigDecimal(200.00));
repository.save(room);

    }

    @Test
    void changeRoomStatus() {
        int id = 23;
        RoomDTO roomDTO = service.changeRoomStatus(id);
        Assertions.assertThat(roomDTO.isRoomStatus()).isEqualTo(false);
    }
}