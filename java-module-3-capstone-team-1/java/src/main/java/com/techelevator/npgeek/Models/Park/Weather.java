package com.techelevator.npgeek.Models.Park;

public class Weather {
	
	private String parkCode;
	private int day;
	private int low;
	private int high;
	private String forecast;
	
	
	public String getParkCode() {
		return parkCode;
	}
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getLow() {
		return low;
	}
	public void setLow(int low) {
		this.low = low;
	}
	public int getHigh() {
		return high;
	}
	public void setHigh(int high) {
		this.high = high;
	}
	public String getForecast() {
		if (forecast.equals("partly cloudy")) {
			
			 forecast ="partlyCloudy";
			 return forecast;
		}
		else {
			return forecast;
		}
	}
	public void setForecast(String forecast) {
		this.forecast = forecast;
	}

	

	@Override
	public String toString() {
		return "Weather [parkCode=" + parkCode + ", day=" + day + ", low=" + low + ", high=" + high + ", forecast="
				+ forecast + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + day;
		result = prime * result + ((forecast == null) ? 0 : forecast.hashCode());
		result = prime * result + high;
		result = prime * result + low;
		result = prime * result + ((parkCode == null) ? 0 : parkCode.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Weather other = (Weather) obj;
		if (day != other.day)
			return false;
		if (forecast == null) {
			if (other.forecast != null)
				return false;
		} else if (!forecast.equals(other.forecast))
			return false;
		if (high != other.high)
			return false;
		if (low != other.low)
			return false;
		if (parkCode == null) {
			if (other.parkCode != null)
				return false;
		} else if (!parkCode.equals(other.parkCode))
			return false;
		return true;
	}





}
