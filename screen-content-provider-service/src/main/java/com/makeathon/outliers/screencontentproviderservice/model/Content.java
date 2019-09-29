package com.makeathon.outliers.screencontentproviderservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Content {


    private Integer id;


    private String location;


    private String contentType;


    private Advertiser advertiser;

}
