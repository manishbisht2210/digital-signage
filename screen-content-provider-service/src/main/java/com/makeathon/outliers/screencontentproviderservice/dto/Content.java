package com.makeathon.outliers.screencontentproviderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Content {
    private String id;
    private String screenId;
    private String header;
    private String body;
    private String colour;
    private String img;
}
