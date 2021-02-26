package com.javagirls.MangoRoom.mapper;

import com.javagirls.MangoRoom.dto.RoomDto;
import com.javagirls.MangoRoom.entity.Room;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

@Component
public class RoomMapper extends ConfigurableMapper {

    protected void configure(MapperFactory factory) {
        factory.classMap(Room.class, RoomDto.class)
                .byDefault()
                .register();
        factory.classMap(RoomDto.class, Room.class)
                .byDefault()
                .register();
    }

}
