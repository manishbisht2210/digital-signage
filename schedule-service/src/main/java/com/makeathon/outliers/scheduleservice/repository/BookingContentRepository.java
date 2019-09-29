package com.makeathon.outliers.scheduleservice.repository;


import com.makeathon.outliers.scheduleservice.entity.BookingContent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingContentRepository extends JpaRepository<BookingContent, Integer> {
}
