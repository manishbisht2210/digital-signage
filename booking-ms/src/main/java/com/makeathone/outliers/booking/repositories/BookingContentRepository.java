package com.makeathone.outliers.booking.repositories;

import com.makeathone.outliers.booking.entity.BookingContent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingContentRepository extends JpaRepository<BookingContent, Integer> {
}
