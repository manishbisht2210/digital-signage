package com.makeathone.outliers.booking.controllers;

import com.makeathone.outliers.booking.entity.Booking;
import com.makeathone.outliers.booking.repositories.BookingRepository;
import com.makeathone.outliers.booking.services.AmazonClient;
import com.makeathone.outliers.booking.services.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/booking")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;
    private final AmazonClient amazonClient;

    @PostMapping(value = "/create",produces = "application/json")
    public Integer createBooking(@RequestBody Booking booking){
        return bookingService.createBooking(booking);
    }

    @PutMapping(value = "/update")
    public void upadateBooking(@RequestBody Booking booking){
        bookingService.updateBooking(booking);
    }

    @GetMapping(value = "/get/{bookingId}",produces = "application/json")
    public Booking getBooking(@PathVariable("bookingId") Integer bookingid){
        return bookingService.getBooking(bookingid);
    }
    @PostMapping("/uploadFile")
    public String uploadFile(@RequestParam("fileName") String fileName, @RequestPart(value = "file") MultipartFile file) {
        return this.amazonClient.uploadFile(fileName,file);
    }


}
