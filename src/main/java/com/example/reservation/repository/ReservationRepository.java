package com.example.reservation.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.reservation.entity.ReservationEntity;

public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {
	/*
	 * @Query("SELECT COUNT(r) FROM ReservationEntity r WHERE r.meetingroomId = :meetingroomId AND r.startDt < :endDt AND r.endDt > :startDt"
	 * ) long checkReservation(@Param("meetingroomId") Long meetingroomId,
	 * 
	 * @Param("startDt") LocalDateTime startDt,
	 * 
	 * @Param("endDt") LocalDateTime endDt);
	 */
	
	boolean existsByMeetingRoomIdAndStartDtLessThanAndEndDtGreaterThan(
			Long meetingRoomId, LocalDateTime startDt, LocalDateTime endtDt);
}
