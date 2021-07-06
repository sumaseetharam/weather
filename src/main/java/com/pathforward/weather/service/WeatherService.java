package com.pathforward.weather.service;



import java.util.*;
import com.pathforward.weather.repository.*;
import java.util.ArrayList;
import java.util.List;  
import org.springframework.stereotype.Service;
import com.pathforward.weather.entity.*;
import com.pathforward.weather.exception.*;
@Service  
public class WeatherService implements IWeatherService

{  
	
	 private WeatherRepository repository = new WeatherRepository();
	 

public ArrayList<Weather> findAll()  
{  
 
	
	return repository.getWeather();
}  



public ArrayList<Weather>  findWeatherByDate(Date date)  
{  
	 ArrayList<Weather>  weatherlist = repository.getWeatherFromDate(date);
		
	return weatherlist;

}  

public Weather addWeather( Weather weather )
{
	Weather existingweather = repository.getWeather(weather.getId());
	
	if(existingweather!=null) 
		throw new WeatherAlreadyExists ("Exception");
	
   return repository.addWeather( weather );
}

public void deleteWeather()  
{  

	 repository.deleteWeather();
}  


}