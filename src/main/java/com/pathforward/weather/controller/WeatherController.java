package com.pathforward.weather.controller;

import java.util.*;  


import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;

import org.springframework.web.bind.annotation.GetMapping;  
import org.springframework.web.bind.annotation.RestController;  
import org.springframework.web.bind.annotation.RequestParam;  
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.format.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.pathforward.weather.service.*;
import com.pathforward.weather.entity.*;


@RestController  
public class WeatherController {

	@Autowired  
	private WeatherService weatherService;  
	

	//mapping the getAllWeather() method to /weather  
	@GetMapping("/weather")
	public ResponseEntity < List < Weather >> getWeather(@RequestParam(value = "date", defaultValue = "")  @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) 
	{  
		
		ArrayList<Weather>  weather=null;
		if(date!=null ) 
			 weather = weatherService.findWeatherByDate(date);
			
		else
			//finds all weather  
			weather= weatherService.findAll();  
		
			return new ResponseEntity<>(weather, HttpStatus.OK);

	}  
	
	//Adding new weather information
	@RequestMapping(value = "/weather", method = RequestMethod.POST ,consumes = "application/json") 
	public ResponseEntity<Void> addWeather(
			 @RequestBody Weather newWeather) {

		
		Weather weather = weatherService.addWeather( newWeather);
		 URI location= ServletUriComponentsBuilder.fromCurrentRequest().path(
					"/{id}").buildAndExpand(weather.getId()).toUri();
	

		return ResponseEntity.created(location).build();
	}
	
	//Deleting all weather information
	@DeleteMapping(value = "/erase")
	  void deleteWeather() {
		weatherService.deleteWeather();
	  }
	

		
}
