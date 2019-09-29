package com.infosys.outliers.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
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
	@ManyToOne
	private PartnerEntity partner;
}
