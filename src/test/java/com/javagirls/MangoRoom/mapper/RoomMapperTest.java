package com.javagirls.MangoRoom.mapper;

import com.javagirls.MangoRoom.dto.RoomDto;
import com.javagirls.MangoRoom.entity.Room;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.javagirls.MangoRoom.mock.RoomMock.getBasicRoom;
import static com.javagirls.MangoRoom.mock.RoomDtoMock.getBasicRoomDto;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RoomMapperTest {
    @Autowired
    RoomMapper mapper;

    @Test
    void convertRoomForRoomDto_returnTrue() {
        Room room = getBasicRoom();
        RoomDto map = mapper.map(room, RoomDto.class);
        assertEquals(room.getRoomNumber(), map.getRoomNumber());
        assertEquals(room.getBeds(), map.getBeds());
        assertEquals(room.getPrice(), map.getPrice());
    }

    @Test
    void convertRoomDtoForRoom_returnTrue() {
        RoomDto roomDto = getBasicRoomDto();
        Room map = mapper.map(roomDto, Room.class);
        assertEquals(roomDto.getRoomNumber(), map.getRoomNumber());
        assertEquals(roomDto.getBeds(), map.getBeds());
        assertEquals(roomDto.getPrice(), map.getPrice());
    }
}