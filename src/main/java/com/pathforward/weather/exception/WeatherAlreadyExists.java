package com.pathforward.weather.exception;

import org.springframework.web.bind.annotation.ResponseStatus;  
import org.springframework.http.HttpStatus;
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class WeatherAlreadyExists extends RuntimeException {

	
	  public WeatherAlreadyExists(String exception) {
	    super(exception);
	  }

	}


