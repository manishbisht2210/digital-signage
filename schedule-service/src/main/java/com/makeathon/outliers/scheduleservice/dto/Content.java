package com.makeathon.outliers.scheduleservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class Content {
    private String id;
    private String screenId;
    private String header;
    private String body;
    private String colour;
    private String img;
}
