package com.takuba.comics.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PaqueteNotFoundException extends RuntimeException {
	public PaqueteNotFoundException(String arg){
		super(arg);
	}
}
