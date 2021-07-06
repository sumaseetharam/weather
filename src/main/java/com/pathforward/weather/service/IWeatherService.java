package com.pathforward.weather.service;
import com.pathforward.weather.entity.*;
import java.util.*;
public interface IWeatherService {  
	ArrayList<Weather> findAll();  
	ArrayList<Weather>  findWeatherByDate(Date date);  

	}  
