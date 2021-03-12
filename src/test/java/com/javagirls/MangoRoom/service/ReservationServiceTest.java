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
        List<Reservation> reservationList = getReservationList();
        when(repository.findAll()).thenReturn(reservationList);
        String time = "past";
        List<ReservationDto> allWithTime = service.findAllWithTime(time);

        assertEquals(repository.findAll().size(), 6);
        assertNotNull(allWithTime);
        assertEquals(allWithTime.size(), 1);
    }
    @Test
    void findAllWithTime_future() {
        List<Reservation> reservationList = getReservationList();
        when(repository.findAll()).thenReturn(reservationList);
        String time = "future";
        List<ReservationDto> allWithTime = service.findAllWithTime(time);

        assertEquals(repository.findAll().size(), 6);
        assertNotNull(allWithTime);
        assertEquals(allWithTime.size(), 3);
    }

    @Test
    void findAllWithTime_now() {
        List<Reservation> reservationList = getReservationList();
        when(repository.findAll()).thenReturn(reservationList);
        String time = "now";
        List<ReservationDto> allWithTime = service.findAllWithTime(time);

        assertEquals(repository.findAll().size(), 6);
        assertNotNull(allWithTime);
        assertEquals(allWithTime.size(), 2);
    }

    @Test
    void findAllWithTime_default() {
        List<Reservation> reservationList = getReservationList();
        when(repository.findAll()).thenReturn(reservationList);
        String time = "";
        List<ReservationDto> allWithTime = service.findAllWithTime(time);

        assertEquals(repository.findAll().size(), 6);
        assertNotNull(allWithTime);
        assertEquals(allWithTime.size(), 5);
    }

    private List<Reservation> getReservationList() {
        Reservation reservation1 = new Reservation(1L, LocalDateTime.now(), LocalDateTime.now().plusDays(2),
                5, PaymentCurrency.PLN, true, true, Status.FINISHED_PAID,
                RoomMock.getBasicRoom());
        Reservation reservation2 = new Reservation(2L, LocalDateTime.now(), LocalDateTime.now().plusDays(5),
                5, PaymentCurrency.PLN, true, false, Status.FINISHED_NOT_PAID,
                RoomMock.getBasicRoom());
        Reservation reservation3 = new Reservation(3L, LocalDateTime.now().minusDays(3),
                LocalDateTime.now().minusDays(2), 5, PaymentCurrency.PLN, true,
                false, Status.FINISHED_NOT_PAID, RoomMock.getBasicRoom());
        Reservation reservation4= new Reservation(4L, LocalDateTime.now().plusDays(3),
                LocalDateTime.now().plusDays(7), 2, PaymentCurrency.EUR, false,
                false, Status.FINISHED_NOT_PAID, RoomMock.getBasicRoom());
        Reservation reservation5 = new Reservation(5L, LocalDateTime.now().plusDays(5),
                LocalDateTime.now().plusDays(7), 5, PaymentCurrency.PLN, false,
                false, Status.FINISHED_NOT_PAID, RoomMock.getBasicRoom());
        Reservation reservation6 = new Reservation(6L, LocalDateTime.now().plusDays(4),
                LocalDateTime.now().plusDays(7), 3, PaymentCurrency.PLN, false,
                false, Status.FINISHED_NOT_PAID, RoomMock.getBasicRoom());
        return List.of(reservation1, reservation2, reservation3,
                reservation4, reservation5, reservation6);
    }
}