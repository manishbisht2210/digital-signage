package com.makeathone.outliers.booking.services;

import com.makeathone.outliers.booking.entity.Booking;
import com.makeathone.outliers.booking.repositories.BookingContentRepository;
import com.makeathone.outliers.booking.repositories.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final BookingContentRepository bookingContentRepository;

    public Integer createBooking(Booking booking) {
//        booking.getBookingContents().forEach(b -> bookingContentRepository.save(b));
        return bookingRepository.save(booking).getId();
    }

    public void updateBooking(Booking booking) {
        Booking bookingEntity = bookingRepository.findById(booking.getId()).orElse(null);
        if (bookingEntity != null) {
            bookingEntity.setScreen(booking.getScreen());
            bookingEntity.setStartDate(booking.getStartDate());
            bookingEntity.setStartTime(booking.getStartTime());
            bookingEntity.setEndDate(booking.getEndDate());
            bookingEntity.setEndTime(booking.getEndTime());
            bookingRepository.save(bookingEntity);
        }
    }

    public Booking getBooking(Integer id) {
        System.out.println(bookingRepository.findById(id));
        return bookingRepository.findById(id).orElse(null);
    }

}
