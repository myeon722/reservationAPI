package com.example.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.reservation.entity.PaymentEntity;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {

}
