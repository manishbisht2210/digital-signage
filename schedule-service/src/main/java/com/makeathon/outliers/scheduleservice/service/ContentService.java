package com.makeathon.outliers.scheduleservice.service;

import com.makeathon.outliers.scheduleservice.dto.Content;
import com.makeathon.outliers.scheduleservice.entity.Booking;
import com.makeathon.outliers.scheduleservice.repository.BookingRepository;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
@Slf4j
public class ContentService {

  private final BookingRepository bookingRepository;

  public Flux<Content> streamFluxContent() {

    Date nowDate = new Date();
    return Flux.fromIterable(bookingRepository
        .findByStartDateAndStartTimeEndTimeBetween(nowDate, nowDate, nowDate, nowDate)
        .stream()
        .map(booking -> buildContent(booking))
        .collect(Collectors.toList())
    );
  }

  private Content buildContent(Booking booking) {
    return Content.builder()
        .id(booking.getId().toString())
        .screenId(booking.getScreen().getScreenId().toString())
        .header("Gluten-free Bicycle")
        .body("Gluten-free Bicycle")
        .colour("RED")
        .img(booking.getBookingContents().get(0).getContent().getLocation())
        .build();
  }


}
