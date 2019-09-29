package com.makeathon.outliers.scheduleservice.service;

import com.makeathon.outliers.scheduleservice.entity.Booking;
import com.makeathon.outliers.scheduleservice.model.BookingEntries;
import com.makeathon.outliers.scheduleservice.repository.BookingRepository;
import java.util.Date;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class ScheduleService {

  private final BookingRepository bookingRepository;
  private final BookingPublisher bookingPublisher;

  @Scheduled(fixedRate = 10000, initialDelay = 5000)
  public void readTimeFromRepo() {

    Date nowDate = new Date();
    List<Booking> bookings = bookingRepository.findByStartDateAndStartTimeEndTimeBetween(nowDate, nowDate, nowDate, nowDate);

    if(bookings.size() > 0) {
    	log.info(" Booking entries - " + bookings.size());
      bookingPublisher.publishMessage(buildBookingEntries(bookings));
    } else {
      System.out.println("No Boooking Found !!");
    }
  }

  private BookingEntries buildBookingEntries(List<Booking> bookings) {
    return BookingEntries.builder()
        .bookingList(bookings)
        .build();
  }
}
