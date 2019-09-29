package com.makeathon.outliers.scheduleservice.model;

import com.makeathon.outliers.scheduleservice.entity.Booking;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
public class BookingEntries {

  @ToString.Exclude
  private List<Booking> bookingList;
}
