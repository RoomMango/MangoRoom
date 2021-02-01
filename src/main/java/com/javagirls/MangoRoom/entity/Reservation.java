package com.javagirls.MangoRoom.entity;

import com.javagirls.MangoRoom.enumeration.PaymentCurrency;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "reservation")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @NotBlank
    @Column
    private LocalDateTime checkIn;

    @NotBlank
    @Column
    private LocalDateTime checkOut;

    @NotBlank
    @Column
    private Integer numberOfPeople;

    @Enumerated(EnumType.ORDINAL)
    @NotBlank
    private PaymentCurrency paymentCurrency;

    @NotBlank
    @Column
    private Boolean businessTrip;

    @NotBlank
    @Column
    private Boolean paid;

    @OneToMany
    private List<Room> rooms;


}
