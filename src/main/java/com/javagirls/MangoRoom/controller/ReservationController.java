package com.javagirls.MangoRoom.controller;

import javax.validation.Valid;
import java.util.List;

import com.javagirls.MangoRoom.dto.ReservationDto;
import com.javagirls.MangoRoom.enumeration.Status;
import com.javagirls.MangoRoom.service.ReservationService;
import com.javagirls.MangoRoom.validation.ReservationValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.DataBinder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/reservations")
public class ReservationController {

	private final ReservationService service;

	private final ReservationValidator validator;

//	@InitBinder
//	public void initPetBinder(DataBinder dataBinder) {
//		dataBinder.addValidators(validator);
//	}

	public ReservationController(ReservationService service,
			ReservationValidator validator) {
		this.service = service;
		this.validator = validator;
	}

	@PostMapping(produces = "application/json")
	public ResponseEntity<Long> addReservation(/*@Valid*/ @RequestBody ReservationDto reservation) {
		return ResponseEntity.ok(service.saveReservation(reservation));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Status> changeReservationStatus(@PathVariable Long id, @RequestParam Status status) {
		return ResponseEntity.ok(service.changeReservationStatus(id, status));
	}

	public List<ReservationDto> allReservations(@RequestParam(required = false) String time) {
		return service.findAllWithTime(time);
	}

}
