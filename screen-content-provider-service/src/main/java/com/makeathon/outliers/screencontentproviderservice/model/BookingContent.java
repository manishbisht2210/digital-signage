package com.makeathon.outliers.screencontentproviderservice.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookingContent {

    private Integer id;


    private Content content;

    private Date startDate;


    private Date startTime;


    private Date endDate;


    private Date endTime;
}
