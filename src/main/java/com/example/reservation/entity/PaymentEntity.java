package com.example.reservation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class PaymentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pId;
	
	@OneToOne
	@JoinColumn(name="reservation_id")
	private ReservationEntity reservation;
	
	private String paymentType; //결제사타입
	private int total; //결제금액
	private String exPaymentId; //외부결제Id
	
	/*
	 * @Enumerated(EnumType.STRING) private PaymentStatusEnum paymentStatus; //결제상태
	 */
}
