package com.infosys.outliers.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@JsonInclude(Include.NON_NULL)
public class GenericResponse {
	
	private Integer code;
	
	private String message;
	
	private String error;
	
	public GenericResponse() {
		
	}

	public GenericResponse(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
}
