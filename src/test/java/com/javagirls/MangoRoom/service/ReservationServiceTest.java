package com.javagirls.MangoRoom.service;

import com.javagirls.MangoRoom.dto.ReservationDto;
import com.javagirls.MangoRoom.entity.Reservation;
import com.javagirls.MangoRoom.enumeration.PaymentCurrency;
import com.javagirls.MangoRoom.enumeration.Status;
import com.javagirls.MangoRoom.mock.RoomMock;
import com.javagirls.MangoRoom.repository.ReservationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ReservationServiceTest {
    @MockBean
    private ReservationRepository repository;
    @Autowired
    private ReservationService service;

    @Test
    void findAllWithTime_past() {
        Reservation reservationDto1 = new Reservation(1L, LocalDateTime.now(), LocalDateTime.now().plusDays(2),
                5, PaymentCurrency.PLN, true, true, Status.FINISHED_PAID,
                RoomMock.getBasicRoom());
        Reservation reservationDto2 = new Reservation(2L, LocalDateTime.now(), LocalDateTime.now().plusDays(5),
                5, PaymentCurrency.PLN, true, false, Status.FINISHED_NOT_PAID,
                RoomMock.getBasicRoom());
        Reservation reservationDto3 = new Reservation(3L, LocalDateTime.now().minusDays(3),
                LocalDateTime.now().minusDays(2), 5, PaymentCurrency.PLN, true,
                false, Status.FINISHED_NOT_PAID, RoomMock.getBasicRoom());
        Reservation reservationDto4 = new Reservation(4L, LocalDateTime.now().plusDays(3),
                LocalDateTime.now().plusDays(7), 2, PaymentCurrency.EUR, false,
                false, Status.FINISHED_NOT_PAID, RoomMock.getBasicRoom());
        Reservation reservationDto5 = new Reservation(5L, LocalDateTime.now().plusDays(5),
                LocalDateTime.now().plusDays(7), 5, PaymentCurrency.PLN, false,
                false, Status.FINISHED_NOT_PAID, RoomMock.getBasicRoom());
        List<Reservation> reservationList = List.of(reservationDto1, reservationDto2, reservationDto3,
                reservationDto4, reservationDto5);

        when(repository.findAll()).thenReturn(reservationList);
        String time = "past";
        List<ReservationDto> allWithTime = service.findAllWithTime(time);

        assertEquals(repository.findAll().size(), 5);
        assertNotNull(allWithTime);
        assertEquals(allWithTime.size(), 1);
    }
}