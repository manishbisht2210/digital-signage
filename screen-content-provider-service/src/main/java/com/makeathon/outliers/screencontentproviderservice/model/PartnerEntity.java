package com.makeathon.outliers.screencontentproviderservice.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartnerEntity {
	

	private Integer partnerId;
	
	private String password;
	
	private String name;


	private List<Screen> screens;
}
