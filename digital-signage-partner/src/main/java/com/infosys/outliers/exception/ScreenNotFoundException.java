package com.infosys.outliers.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ScreenNotFoundException extends RuntimeException {
	public ScreenNotFoundException(String message){
		super(message);
	}
}
