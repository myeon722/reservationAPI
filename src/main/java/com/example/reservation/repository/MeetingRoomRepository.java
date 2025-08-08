package com.example.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.reservation.entity.MeetingRoomEntity;

public interface MeetingRoomRepository extends JpaRepository<MeetingRoomEntity, Long> {

}
