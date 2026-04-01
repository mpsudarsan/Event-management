package com.example.eventmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.eventmanagement.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}