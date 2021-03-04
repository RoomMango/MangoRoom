package com.javagirls.MangoRoom.service;

import com.javagirls.MangoRoom.dto.RoomDto;
import com.javagirls.MangoRoom.entity.Room;
import com.javagirls.MangoRoom.mapper.RoomMapper;
import com.javagirls.MangoRoom.mock.RoomDtoMock;
import com.javagirls.MangoRoom.mock.RoomMock;
import com.javagirls.MangoRoom.repository.RoomRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

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
        RoomDto roomDTO = service.changeRoomStatus(room.getRoomNumber());
        assertThat(roomDTO.isAvailableForBooking()).isEqualTo(false);
    }

    @Test
    void changeRoomStatus_fromFalseToTrue() {
        Room room = new Room();
        room.setRoomNumber(23);
        room.setAvailableForBooking(false);
        room.setPrice(new BigDecimal(200.00));
        when(repository.findById(room.getRoomNumber())).thenReturn(java.util.Optional.of(room));
        RoomDto roomDTO = service.changeRoomStatus(room.getRoomNumber());
        assertThat(roomDTO.isAvailableForBooking()).isEqualTo(true);
    }

    @Test
    void findAllRooms_should_return_roomDto_list() {
        // given
        Room room1 = RoomMock.getBasicRoom();
        Room room2 = RoomMock.getBasicRoom();
        List<Room> roomsMock = Arrays.asList(room1, room2);

        when(repository.findAll()).thenReturn(roomsMock);

        // when
        List<RoomDto> roomDtos =  service.findAllRooms();

        // then
        assertNotNull(roomDtos);
        assertEquals(roomsMock.size(), roomDtos.size());
    }
}
