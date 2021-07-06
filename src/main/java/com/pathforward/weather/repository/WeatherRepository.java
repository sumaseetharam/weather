package com.pathforward.weather.repository;
import java.text.DateFormat;
import com.pathforward.weather.entity.*;
import com.pathforward.weather.db.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Date;
import com.pathforward.weather.db.*;

public class WeatherRepository {
	   private MockDatabase mockDatabase = com.pathforward.weather.db.MockDatabase.getInstance();

	   public WeatherRepository()
	   {
	      System.out.println( "Weather repository called" );
	   }

	   public ArrayList<Weather> getWeather()
	   {
		   ArrayList<Weather> weatherList = null;
	      Map<Integer, Weather> weatherdata = mockDatabase.getWeather();
	      if ( weatherdata != null )
	      {
	    	  weatherList = new ArrayList<Weather>( weatherdata.values() );
	      }
	      //Sorting weather data based on the id.
	      Collections.sort(weatherList,(a,b)->a.getId()-b.getId());
	      return weatherList;
	   }
	   public Weather addWeather( Weather weather )
	   {
	      return mockDatabase.addWeather( weather );
	   }
	   
	   public Weather getWeather( int id )
	   {
	      return mockDatabase.getWeather( id );
	   }
	   
	   //Get weather information for a specific date
	   public  ArrayList<Weather> getWeatherFromDate(Date date)
	   {   
		   java.text.SimpleDateFormat sdformat = new java.text.SimpleDateFormat("yyyy-MM-dd");
		   sdformat.setTimeZone(java.util.TimeZone.getTimeZone("GMT"));
		   ArrayList<Weather> result = new ArrayList<Weather>();
		   Map<Integer, Weather> weatherdata = mockDatabase.getWeather();
		      if ( weatherdata != null )
		      {
		    	  ArrayList<Weather> weatherList = new ArrayList<Weather>( weatherdata.values() );
		    	  for(Weather weather:weatherList) {
		    			if(sdformat.format(weather.getDate()).compareTo(sdformat.format(date))==0) result.add(weather);
		    	}
		      }
		      
	      return result;
	   }
	   public void deleteWeather()
	   {
	       mockDatabase.deleteWeather();
	   }


}
