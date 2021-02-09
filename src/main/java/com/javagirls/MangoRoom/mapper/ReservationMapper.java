package com.javagirls.MangoRoom.mapper;

import com.javagirls.MangoRoom.dto.ReservationDto;
import com.javagirls.MangoRoom.entity.Reservation;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

@Component
public class ReservationMapper extends ConfigurableMapper {

    protected void configure(MapperFactory factory){
        factory.classMap(Reservation.class, ReservationDto.class)
                .byDefault()
                .register();
    }
}
