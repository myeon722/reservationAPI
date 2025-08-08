package com.example.reservation.service;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.reservation.dto.ReservationRequestDto;
import com.example.reservation.entity.MeetingRoomEntity;
import com.example.reservation.entity.ReservationEntity;
import com.example.reservation.repository.MeetingRoomRepository;
import com.example.reservation.repository.ReservationRepository;

import jakarta.transaction.Transactional;

@Service
public class ReservationService {
	private ReservationRepository reservationRepository;
	private MeetingRoomRepository meetingroomRepository;
	
	public ReservationService(ReservationRepository reservationRepository, MeetingRoomRepository meetingroomRepository) {
		this.reservationRepository = reservationRepository;
		this.meetingroomRepository = meetingroomRepository;
	}
	
	/**
	 * 회의실 예약 생성
	 * @param resrvationDto
	 * @return
	 */
	@Transactional
	public ReservationEntity createReservation(ReservationRequestDto resrvationDto) {
		Long meetingRoomId = resrvationDto.getMeetingroomId(); //미팅룸번호
		String userNm = resrvationDto.getUserName(); //사용자이름
		String userPhonNum = resrvationDto.getUserPhonNum(); //사용자휴대폰번호
		LocalDateTime startDt = resrvationDto.getStartDt(); //예약시작시간
		LocalDateTime endDt = resrvationDto.getEndDt(); //예약종료시간
		
		//파라미터 유효성 검사
		if(meetingRoomId==null || userNm==null || userPhonNum==null || startDt==null || endDt==null) {
			throw new IllegalArgumentException("미팅룸번호, 시작시간, 종료시간 중의 필수값이 존재하지않습니다.");
		}
		
		//회의실 존재 여부
		MeetingRoomEntity meetingroom = meetingroomRepository.findById(meetingRoomId).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회의실입니다."));
		
		//예약 시간 유효성 확인(시작시간 < 종료시간)
		if(startDt.isAfter(endDt)) {
			throw new IllegalArgumentException("예약 시작 시간은 종료 시간보다 이전이여야 합니다.");
		}
		
		//예약시간 00분/30분 확인
		if(!reservationTimeCheck(startDt) || !reservationTimeCheck(endDt)) {
			throw new IllegalArgumentException("예약시간은 정각이거나 30분 단위만 가능합니다.");
		}
		
		//예약 중복 검사
		/*
		 * long checkCnt = reservationRepository.checkReservation(meetingRoomId,
		 * startDt, endDt); if(Math.toIntExact(checkCnt) > 0) { throw new
		 * IllegalArgumentException("해당 시간에 예약이 존재합니다."); }
		 */
		if(reservationRepository.existsByMeetingRoomIdAndStartDtLessThanAndEndDtGreaterThan(meetingRoomId, startDt, endDt)) {
			throw new IllegalArgumentException("해당 시간에 예약이 존재합니다.");
		}
		
		BigDecimal totalPay = calculateTotalPay(meetingroom, resrvationDto);
		
		ReservationEntity reservationEntity = new ReservationEntity(
				meetingroom,
				resrvationDto.getUserName(),
				resrvationDto.getUserPhonNum(),
				resrvationDto.getStartDt(),
				resrvationDto.getEndDt(),
				totalPay
		);
		
		return reservationRepository.save(reservationEntity);
	}
	
	/**
	 * 회의실 예약 조회
	 * @param meetingroomId
	 * @return
	 */
	public Optional<ReservationEntity> getReservation(Long meetingroomId) {
		return reservationRepository.findById(meetingroomId);
	}
	
	/**
	 * 회의실 예약 취소
	 * @param meetingroomId
	 * @return
	 */
	public ReservationEntity cancelReservation(Long meetingroomId) {
		ReservationEntity reservationEntity = reservationRepository.findById(meetingroomId)
												.orElseThrow(() -> new IllegalArgumentException("예약이 존재하지않습니다."));
		reservationEntity.ReservationCnacle();
		
		return reservationRepository.save(reservationEntity);
	}

	private boolean reservationTimeCheck(LocalDateTime checkTime) {
		int checkM = checkTime.getMinute();
		if(checkM != 0 && checkM != 30) {
			return false;
		}
		
		return true;
	}
	
	private BigDecimal calculateTotalPay(MeetingRoomEntity meetingroom, ReservationRequestDto resrvationDto) {
		long hours = Duration.between(resrvationDto.getStartDt(), resrvationDto.getEndDt()).toHours();
		return meetingroom.getHourlyRate().multiply(BigDecimal.valueOf(hours));
	}
}