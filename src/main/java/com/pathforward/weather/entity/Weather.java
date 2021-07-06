package com.pathforward.weather.entity;

import java.util.*;

public class Weather {
	public Weather(int id, Date date, Location location, List<Double> temperature) {
		super();
		this.id = id;
		this.date = date;
		this.location = location;
		this.temperature = temperature;
	}
	

	    public int id;
	    public Date date;
	    public Location location;
	    public List<Double> temperature;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date = date;
		}
		public Location getLocation() {
			return location;
		}
		public void setLocation(Location location) {
			this.location = location;
		}
		public List<Double> getTemperature() {
			return temperature;
		}
		public void setTemperature(List<Double> temperature) {
			this.temperature = temperature;
		}
		
		
	
	
	
}
