package com.makeathone.outliers.booking.services;

import com.makeathone.outliers.booking.entity.BookingContent;
import com.makeathone.outliers.booking.repositories.BookingContentRepository;
import com.makeathone.outliers.booking.repositories.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingContentService {

    private final BookingContentRepository bookingContentRepository;

    public Integer createBookingContent(BookingContent bookingContent){
        return bookingContentRepository.save(bookingContent).getId();
    }
    public void updateBookingContent(BookingContent bookingContent){
        BookingContent bookingContentEntity = bookingContentRepository.findById(bookingContent.getId()).orElse(null);
        if(bookingContentEntity!=null){
            bookingContentEntity.setContent(bookingContent.getContent());
            bookingContentEntity.setStartDate(bookingContent.getStartDate());
            bookingContentEntity.setStartTime(bookingContent.getStartTime());
            bookingContentEntity.setEndDate(bookingContent.getEndDate());
            bookingContentEntity.setEndTime(bookingContent.getEndTime());
            bookingContentRepository.save(bookingContentEntity);
        }
    }

    public BookingContent getBookingContent(Integer id){
        return bookingContentRepository.findById(id).orElse(null);
    }

}
