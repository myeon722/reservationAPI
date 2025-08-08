package com.example.reservation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class PaymentProviderEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long prId;
	
	private String prName; //결제사명
	private String endPoint; //api엔드포인트
	private String authIInfo; //인증정보
	
	/*
	 * @Enumerated(EnumType.STRING) private PayProviderTypeEnum payType; //결제사타입
	 */}
