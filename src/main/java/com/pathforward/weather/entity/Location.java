package com.pathforward.weather.entity;

public class Location{
    public Location(double lat, double lon, String city, String state) {
		super();
		this.lat = lat;
		this.lon = lon;
		this.city = city;
		this.state = state;
	}
	public double lat;
    public double lon;
    public String city;
    public String state;
    
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLon() {
		return lon;
	}
	public void setLon(double lon) {
		this.lon = lon;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
}