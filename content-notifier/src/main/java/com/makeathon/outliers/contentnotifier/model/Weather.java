package com.makeathon.outliers.contentnotifier.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Weather {
  private String temprature;
  private String humidity;
  private String windSpeed;
}
