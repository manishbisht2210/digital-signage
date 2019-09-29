package com.infosys.outliers.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@JsonInclude(Include.NON_NULL)
public class Screen {
	private Integer screenId;
	private String state;
	private String city;
	private String locality;
	private String longitude;
	private String latitude;
	private Integer partnerId;
}
