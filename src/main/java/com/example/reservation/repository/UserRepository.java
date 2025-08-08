package com.example.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.reservation.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
