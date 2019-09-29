package com.makeathon.outliers.screencontentproviderservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Screen {
	private Integer screenId;
	private String state;
	private String city;
	private String locality;
	private String longitude;
	private String latitude;
	private PartnerEntity partner;
}
