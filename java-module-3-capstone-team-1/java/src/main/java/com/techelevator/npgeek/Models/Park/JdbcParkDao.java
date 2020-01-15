package com.techelevator.npgeek.Models.Park;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcParkDao implements ParkDao{
	
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcParkDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	//Create
	public void addPark(Park park) {
		String sqlAddPark = "INSERT INTO park (parkcode, parkname, state, acreage, elevationinfeet, milesoftrail, numberofcampsites, climate, yearfouned, annualvisitorcount, inspirationalquote, inspirationalquotesource, parkdescription, entryfee, numberofanmialspecies) "
						  + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		jdbcTemplate.update(sqlAddPark, 
							park.getParkCode(),
							park.getParkName(),
							park.getState(),
							park.getAcreage(),
							park.getElevationFt(),
							park.getMilesOfTrail(),
							park.getNumberOfCampsites(),
							park.getClimate(),
							park.getYearFounded(),
							park.getAnnualVisitorCount(),
							park.getQuote(),
							park.getQuoteSource(),
							park.getDescription(),
							park.getEntryFee(),
							park.getNumberOfAnimalSpecies());
	}
	
	//Create
	public void addWeather(Weather weather) {
		String sqlAddWeather= "INSERT INTO weather (parkcode, fivedayforecastvalue, low, high, forecast)"
							+ " VALUES (?, ?, ?, ?, ?);";
		jdbcTemplate.update(sqlAddWeather, weather.getParkCode(),
										   weather.getDay(),
										   weather.getLow(),
										   weather.getHigh(),
										   weather.getForecast());
	}
	

	@Override
	public List<Park> getAllParks() {
		List<Park> allParks = new ArrayList<Park>();
		
		String sqlGetAllParks = "SELECT * FROM park";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllParks);
		while (results.next()) {
			Park newPark = mapRowToPark(results);
			allParks.add(newPark);
		}
		return allParks;
	}

	@Override
	public Park getParkByParkCode(String parkCode) {
		Park parkByCode = new Park();
		String sqlGetParksByCode = "SELECT * from park where parkcode = ? ;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetParksByCode, parkCode);
		while (results.next()) {
		parkByCode = mapRowToPark(results);
		}
		return parkByCode;
	}

	@Override
	public List<Weather> getWeatherByParkCode(String parkCode) {
		List<Weather> weatherByParkCode = new ArrayList<Weather>();
		String sqlWeatherByPark = "SELECT * FROM weather where parkcode = ?; ";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlWeatherByPark, parkCode);
		
		while (results.next()) {
			Weather newWeather = mapRowToWeather(results);
			weatherByParkCode.add(newWeather);
		}
		return weatherByParkCode;
	}
	
	public List<Weather> getWeatherByParkCode(String parkCode, char temp) {
		List<Weather> weatherByParkCode = new ArrayList<Weather>();
		String sqlWeatherByPark = "SELECT * FROM weather where parkcode = ?; ";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlWeatherByPark, parkCode);
		
		while (results.next()) {
			Weather newWeather = mapRowToWeather(results);
			weatherByParkCode.add(newWeather);
		}
		if (temp == 'C') {
			for (Weather entry : weatherByParkCode) {
				entry.setHigh(((entry.getHigh() -32) * 100) * 5 / 9 / 100);
				entry.setLow(((entry.getLow() - 32) * 100) * 5 / 9 / 100);
			}
		}
		return weatherByParkCode;
	}
	
	public String getWeatherMessageFromForecast(String forecast) {
		if (forecast.equals("partly cloudy")) {
			return "Enjoy your trip!";
		}
		else if(forecast.equals("sunny")) {
			return "Remember to pack sunscreen.";
		}
		else if(forecast.equals("rain")) {
			return "Due to rain, we advise packing rain gear and water-proof footwear.";
		}
		return null;
	}
	
	public String getDayOneForecast(List<Weather> weathers) {
		String forecast="";
		for(Weather entry : weathers) {
			if (entry.getDay() == 1) {
				forecast += entry.getForecast();
			}
		}
		return forecast;
	}
	
	public List<String> getWeatherAlerts(List<Weather> weathers) {
		List<String> alerts = new ArrayList<String>();
		for (Weather entry : weathers) {
			if (entry.getDay() == 1) {
				if (entry.getHigh() > 75) {
					String newAlert = "ADVISORY: Due to heat, pack an extra gallon of water per person.";
					alerts.add(newAlert);
				}
				if (entry.getLow() < 20) {
					String newAlert = "ADVISORY: Exposure to frigid temperatures can cause hypothermia. Wear layers and cover exposed skin.";
					alerts.add(newAlert);
				}
				if (entry.getHigh() - entry.getLow() > 20) {
					String newAlert = "ADVISORY: Wide temperature changes are expected, please wear breathable layers.";
					alerts.add(newAlert);
				}
				if(entry.getForecast().equals("thunderstorms")) {
					String newAlert = "ADVISORY: In case of storms, seek shelter and avoid hiking on exposed ridges.";
					alerts.add(newAlert);
				}}
		}
		return alerts;
	}
	
	public String getImageNameFromForecast(String forecast) {
		if (forecast.equals("partly cloudy")) {
			return "partlyCloudy";
		}
		else {
			return forecast;
		}
	}
	
	private Park mapRowToPark(SqlRowSet results) {
		Park newPark = new Park();
		newPark.setAcreage(results.getInt("acreage"));
		newPark.setParkCode(results.getString("parkcode"));
		newPark.setParkName(results.getString("parkname"));
		newPark.setState(results.getString("state"));
		newPark.setElevationFt(results.getInt("elevationinfeet"));
		newPark.setMilesOfTrail(results.getDouble("milesoftrail"));
		newPark.setNumberOfCampsites(results.getInt("numberofcampsites"));
		newPark.setClimate(results.getString("climate"));
		newPark.setYearFounded(results.getInt("yearfounded"));
		newPark.setAnnualVisitorCount(results.getInt("annualvisitorcount"));
		newPark.setQuote(results.getString("inspirationalquote"));
		newPark.setQuoteSource(results.getString("inspirationalquotesource"));
		newPark.setDescription(results.getString("parkdescription"));
		newPark.setEntryFee(results.getInt("entryfee"));
		newPark.setNumberOfAnimalSpecies(results.getInt("numberofanimalspecies"));
		return newPark;
	}
	
	private Weather mapRowToWeather(SqlRowSet results) {
		Weather newWeather = new Weather();
		newWeather.setParkCode(results.getString("parkcode"));
		newWeather.setDay(results.getInt("fivedayforecastvalue"));
		newWeather.setLow(results.getInt("low"));
		newWeather.setHigh(results.getInt("high"));
		newWeather.setForecast(results.getString("forecast"));
		return newWeather;
	}

}
