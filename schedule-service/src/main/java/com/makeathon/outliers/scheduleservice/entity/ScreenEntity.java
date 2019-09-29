package com.makeathon.outliers.scheduleservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "screen")
public class ScreenEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer screenId;
  private String state;
  private String city;
  private String locality;
  private String longitude;
  private String latitude;
  @ToString.Exclude
  @ManyToOne
  private PartnerEntity partner;
}
