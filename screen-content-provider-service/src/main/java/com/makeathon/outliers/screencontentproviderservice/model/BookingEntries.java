package com.makeathon.outliers.screencontentproviderservice.model;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookingEntries {
  private List<Booking> bookingList;
}
