package com.example.reservation.dto;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "회의실 예약")
public class ReservationRequestDto {
	@Schema(description = "회의실 ID", example="1")
	private Long meetingroomId;
	@Schema(description = "예약자 이름", example = "홍길동")
	private String userName;
	@Schema(description = "예약자 휴대폰번호", example = "01012345678")
	private String userPhonNum;
	@Schema(description = "시작 시간", example = "2025-08-08 11:00:00")
	private LocalDateTime startDt;
	@Schema(description = "종료 시간", example = "2025-08-08 11:30:00")
	private LocalDateTime endDt;
	
	public ReservationRequestDto() {}
	
	public Long getMeetingroomId() {
		return meetingroomId;
	}

	public void setMeetingroomId(Long meetingroomId) {
		this.meetingroomId = meetingroomId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserPhonNum() {
		return userPhonNum;
	}

	public void setUserPhoneNum(String userPhonNum) {
		this.userPhonNum = userPhonNum;
	}

	public LocalDateTime getStartDt() {
		return startDt;
	}

	public void setStartDt(LocalDateTime startDt) {
		this.startDt = startDt;
	}

	public LocalDateTime getEndDt() {
		return endDt;
	}

	public void setEndDt(LocalDateTime endDt) {
		this.endDt = endDt;
	}
}
