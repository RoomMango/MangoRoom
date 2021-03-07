package com.javagirls.MangoRoom.service;

import com.javagirls.MangoRoom.dto.ReservationDto;
import com.javagirls.MangoRoom.enumeration.PaymentCurrency;
import com.javagirls.MangoRoom.enumeration.Status;
import com.javagirls.MangoRoom.mock.ReservationDtoMock;
import com.javagirls.MangoRoom.repository.ReservationRepository;
import com.javagirls.MangoRoom.repository.RoomRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ReservationServiceTest {
    @MockBean
    private ReservationRepository repository;
    @Autowired
    private ReservationService service;

    @Test
    void findAllWithTime_now() {
        ReservationDto reservationDto1 = new ReservationDto(LocalDateTime.now(), LocalDateTime.now().plusDays(2),
                5, PaymentCurrency.PLN, true, true, Status.FINISHED_PAID );
        ReservationDto reservationDto2 = new ReservationDto(LocalDateTime.now(), LocalDateTime.now().plusDays(5),
                5, PaymentCurrency.PLN, true, false, Status.FINISHED_NOT_PAID );
        ReservationDto reservationDto3 = new ReservationDto(LocalDateTime.now().minusDays(3),
                LocalDateTime.now().minusDays(2), 5, PaymentCurrency.PLN, true,
                false, Status.FINISHED_NOT_PAID );
        ReservationDto reservationDto4 = new ReservationDto(LocalDateTime.now().plusDays(3),
                LocalDateTime.now().plusDays(7), 2, PaymentCurrency.EUR, false,
                false, Status.FINISHED_NOT_PAID );
    }
}