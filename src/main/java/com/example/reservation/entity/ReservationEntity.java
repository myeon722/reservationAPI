package com.example.reservation.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * 예약정보 entity
 *
 */
@Entity
@Table(name="TB_RESERVATIONINFO")
public class ReservationEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long reservationId;
	
	@ManyToOne
	@JoinColumn(name="meetingroom_id")
	private MeetingRoomEntity meetingRoom; //회의실정보
	
	@Column(nullable = false)
	private String userNm; //사용자정보
	@Column(nullable = false)
	private String userPhonNum; //사용자휴대폰번호
	@Column(nullable = false)
	private LocalDateTime startDt; //예약시작시간
	@Column(nullable = false)
	private LocalDateTime endDt; //예약마감시간
	@Column(nullable = false)
	private BigDecimal totalPay; //총결제금액
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private ReservationStatausEnum reservationStatus; //예약상태
	
	protected ReservationEntity() {}
	
	public Long getReservationId() {
		return reservationId;
	}
	public MeetingRoomEntity getMeetingRoom() {
		return meetingRoom;
	}
	public String getUserNm() {
		return userNm;
	}
	public String getUserPhonNum() {
		return userPhonNum;
	}
	public LocalDateTime getStartDt() {
		return startDt;
	}
	public LocalDateTime getEndDt() {
		return endDt;
	}
	public BigDecimal getTotalPay() {
		return totalPay;
	}
	public ReservationStatausEnum getReservationStatus() {
		return reservationStatus;
	}
	
	public ReservationEntity(MeetingRoomEntity  meetingRoom, String userNm, String userPhonNum, LocalDateTime startDt, LocalDateTime endtDt, BigDecimal totalPay) {
		this.meetingRoom = meetingRoom;
		this.userNm = userNm;
		this.userPhonNum = userPhonNum;
		this.startDt = startDt;
		this.endDt = endtDt;
		this.totalPay = totalPay;
		this.reservationStatus = ReservationStatausEnum.RESERVE;
	}
	
	public void ReservationCnacle() {
		if(this.reservationStatus != ReservationStatausEnum.CANCLE) {
			this.reservationStatus = ReservationStatausEnum.CANCLE;
		}
	}
	
	public enum ReservationStatausEnum {
		PENDIG, RESERVE, CANCLE
	}
}
