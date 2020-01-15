package com.techelevator.npgeek.Models.Park;

import java.util.List;

public interface ParkDao {
	
	public List<Park> getAllParks();
	
	public Park getParkByParkCode(String parkCode);
	
	public List<Weather> getWeatherByParkCode(String parkCode);

}
