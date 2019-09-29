package com.makeathone.outliers.booking.repositories;

import com.makeathone.outliers.booking.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
