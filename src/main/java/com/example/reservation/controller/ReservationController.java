package com.example.reservation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.reservation.dto.ReservationRequestDto;
import com.example.reservation.entity.ReservationEntity;
import com.example.reservation.service.ReservationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "예약 관리", description = "회의실 예약 관련 API")
@RestController
@RequestMapping("/reservations")
public class ReservationController {
	private final ReservationService reservationService;
	
	public ReservationController(ReservationService reservationService) {
		this.reservationService = reservationService;
	}
	
	/**
	 * 예약생성
	 * @param requestDto
	 * @return
	 */
	@Operation(summary = "예약생성", description = "회의실 예약 API")
	@PostMapping
	public ResponseEntity<ReservationEntity> createReservation(@RequestBody ReservationRequestDto requestDto) {
		return ResponseEntity.ok(reservationService.createReservation(requestDto));
	}
	
	/**
	 * 예약조회
	 * @param meetingroomId
	 * @return
	 */
	@Operation(summary = "예약조회", description = "예약된 회의실 조회 API")
	@GetMapping("/{meetingroomId}")
	public ResponseEntity<ReservationEntity> getReservation(@PathVariable Long meetingroomId) {
		return ResponseEntity.of(reservationService.getReservation(meetingroomId));
	}
	
	/**
	 * 예약취소
	 * @param meetingroomId
	 * @return
	 */
	@Operation(summary = "예약취소", description = "회의실 예약취소 API")
	@PutMapping("/{meetingroomId}/cancle")
	public ResponseEntity<ReservationEntity> cancleReservation(@PathVariable Long meetingroomId) {
		ReservationEntity reservationEntity = reservationService.cancelReservation(meetingroomId);
		
		return ResponseEntity.ok(reservationEntity);
	}
}
