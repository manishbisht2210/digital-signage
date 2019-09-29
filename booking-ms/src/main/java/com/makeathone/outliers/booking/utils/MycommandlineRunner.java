package com.makeathone.outliers.booking.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.makeathone.outliers.booking.entity.Booking;
import com.makeathone.outliers.booking.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Date;

@Component
public class MycommandlineRunner implements CommandLineRunner {

    @Autowired
    private BookingService bookingService;

    @Override
    public void run(String... args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);


        Date date = new Date();

        for (int i = 0; i < 10; i++) {
            Booking booking = objectMapper.readValue(new File(this.getClass().getClassLoader().getResource("data.json").getFile()), Booking.class);
            booking.setStartDate(date);
            booking.setStartTime(date);
            booking.setEndDate(new Date(date.getTime()+3600000));
            booking.setEndTime(new Date(date.getTime()+3600000));
            System.out.println("Publishing booking : " + booking);
//            bookingService.createBooking(booking);
            date = new Date(date.getTime() + 10000);
        }

    }
}
