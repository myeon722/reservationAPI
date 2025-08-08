package com.example.reservation.entity;

import java.math.BigDecimal;

import jakarta.persistence.*;

/**
 * 회의실정보 entity
 *
 */
@Entity
@Table(name="TB_MEETINGROOMINFO")
public class MeetingRoomEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "meetingroom_id")
	private Long id;
	
	@Column(nullable = false)
	private String roomName; //회의실 이름
	@Column(nullable = false)
	private int capacity; //수용인원
	@Column(nullable = false)
	private BigDecimal hourlyRate; //시간당 요금
	
	protected MeetingRoomEntity() {}//jpa 기본 생성자
	
	public Long getId() {
		return id;
	}
	public String getRoomName() {
		return roomName;
	}
	public int getCapacity() {
		return capacity;
	}
	public BigDecimal getHourlyRate() {
		return hourlyRate;
	}
	
	public MeetingRoomEntity(String roomName, int capacity, BigDecimal hourlyRate) {
		this.roomName = roomName;
		this.capacity = capacity;
		this.hourlyRate = hourlyRate;
	}
}
