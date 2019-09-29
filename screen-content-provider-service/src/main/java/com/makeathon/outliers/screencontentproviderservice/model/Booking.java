package com.makeathon.outliers.screencontentproviderservice.model;

import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Booking {


    private Integer id;


    private Advertiser advertiser;


    private Screen screen;


    private Date startDate;


    private Date startTime;


    private Date endDate;


    private Date endTime;


    private List<BookingContent> bookingContents;
}
