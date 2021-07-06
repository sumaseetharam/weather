package com.pathforward.weather.db;


import com.pathforward.weather.entity.*;
import java.util.HashMap;
import java.util.Map;



public class MockDatabase
{

	public static HashMap<Integer,Weather> weatherdata = new HashMap<Integer,Weather>();
	 
	 

   private static MockDatabase         mockDatabase;

   static
   {
      mockDatabase = new MockDatabase();
   }

   private MockDatabase()
   {

   }

   public static MockDatabase getInstance()
   {
      System.out.println( "Getting db instance..." );
      return mockDatabase;
   }

   public HashMap<Integer,Weather>  getWeather()
   {
      return weatherdata;
   }
  

   public Weather getWeather( int id )
   {
      return weatherdata.get( id );

   }

   public Weather addWeather( Weather weather )
   {
     
    
      weatherdata.put( weather.getId(), weather );
      return weather;
   }

   public void deleteWeather()
   {
	 weatherdata.clear();

   }

   
}
