package com.makeathone.outliers.booking.controllers;

import com.makeathone.outliers.booking.entity.BookingContent;
import com.makeathone.outliers.booking.services.BookingContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/booking-content")
@RequiredArgsConstructor
public class BookingContentController {

    private final BookingContentService bookingContentService;

    @PostMapping(value = "/create", produces = "application/json")
    public Integer createBookingContent(@RequestBody BookingContent booking) {
        return bookingContentService.createBookingContent(booking);
    }

    @PutMapping(value = "/update")
    public void upadateBookingContent(@RequestBody BookingContent booking) {
        bookingContentService.updateBookingContent(booking);
    }

    @GetMapping(value = "/get/{bookingId}", produces = "application/json")
    public BookingContent getBookingContent(@PathVariable("bookingId") Integer bookingid) {
        return bookingContentService.getBookingContent(bookingid);
    }

}
