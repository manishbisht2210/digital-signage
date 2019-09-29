package com.infosys.outliers.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class UserIdNotPresentException extends RuntimeException {
	public UserIdNotPresentException(String message){
		super(message);
	}
}
