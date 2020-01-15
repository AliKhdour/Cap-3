package com.techelevator.npgeek.Models.Park;

public class Park {

	private String parkCode;
	private String parkName;
	private String state;
	private int acreage;
	private int elevationFt;
	private double milesOfTrail;
	private int numberOfCampsites;
	private String climate;
	private int yearFounded;
	private int annualVisitorCount;
	private String quote;
	private String quoteSource;
	private String description;
	private int entryFee;
	private int numberOfAnimalSpecies;
	
	
	
	
	
	public String getParkCode() {
		return parkCode;
	}
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	public String getParkName() {
		return parkName;
	}
	public void setParkName(String parkName) {
		this.parkName = parkName;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getAcreage() {
		return acreage;
	}
	public void setAcreage(int acreage) {
		this.acreage = acreage;
	}
	public int getElevationFt() {
		return elevationFt;
	}
	public void setElevationFt(int elevationFt) {
		this.elevationFt = elevationFt;
	}
	public double getMilesOfTrail() {
		return milesOfTrail;
	}
	public void setMilesOfTrail(double milesOfTrail) {
		this.milesOfTrail = milesOfTrail;
	}
	public int getNumberOfCampsites() {
		return numberOfCampsites;
	}
	public void setNumberOfCampsites(int numberOfCampsites) {
		this.numberOfCampsites = numberOfCampsites;
	}
	public String getClimate() {
		return climate;
	}
	public void setClimate(String climate) {
		this.climate = climate;
	}
	public int getYearFounded() {
		return yearFounded;
	}
	public void setYearFounded(int yearFounded) {
		this.yearFounded = yearFounded;
	}
	public int getAnnualVisitorCount() {
		return annualVisitorCount;
	}
	public void setAnnualVisitorCount(int annualVisitorCount) {
		this.annualVisitorCount = annualVisitorCount;
	}
	public String getQuote() {
		return quote;
	}
	public void setQuote(String quote) {
		this.quote = quote;
	}
	public String getQuoteSource() {
		return quoteSource;
	}
	public void setQuoteSource(String quoteSource) {
		this.quoteSource = quoteSource;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getEntryFee() {
		return entryFee;
	}
	public void setEntryFee(int entryFee) {
		this.entryFee = entryFee;
	}
	public int getNumberOfAnimalSpecies() {
		return numberOfAnimalSpecies;
	}
	public void setNumberOfAnimalSpecies(int numberOfAnimalSpecies) {
		this.numberOfAnimalSpecies = numberOfAnimalSpecies;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + acreage;
		result = prime * result + annualVisitorCount;
		result = prime * result + ((climate == null) ? 0 : climate.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + elevationFt;
		result = prime * result + entryFee;
		long temp;
		temp = Double.doubleToLongBits(milesOfTrail);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + numberOfAnimalSpecies;
		result = prime * result + numberOfCampsites;
		result = prime * result + ((parkCode == null) ? 0 : parkCode.hashCode());
		result = prime * result + ((parkName == null) ? 0 : parkName.hashCode());
		result = prime * result + ((quote == null) ? 0 : quote.hashCode());
		result = prime * result + ((quoteSource == null) ? 0 : quoteSource.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + yearFounded;
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
		Park other = (Park) obj;
		if (acreage != other.acreage)
			return false;
		if (annualVisitorCount != other.annualVisitorCount)
			return false;
		if (climate == null) {
			if (other.climate != null)
				return false;
		} else if (!climate.equals(other.climate))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (elevationFt != other.elevationFt)
			return false;
		if (entryFee != other.entryFee)
			return false;
		if (Double.doubleToLongBits(milesOfTrail) != Double.doubleToLongBits(other.milesOfTrail))
			return false;
		if (numberOfAnimalSpecies != other.numberOfAnimalSpecies)
			return false;
		if (numberOfCampsites != other.numberOfCampsites)
			return false;
		if (parkCode == null) {
			if (other.parkCode != null)
				return false;
		} else if (!parkCode.equals(other.parkCode))
			return false;
		if (parkName == null) {
			if (other.parkName != null)
				return false;
		} else if (!parkName.equals(other.parkName))
			return false;
		if (quote == null) {
			if (other.quote != null)
				return false;
		} else if (!quote.equals(other.quote))
			return false;
		if (quoteSource == null) {
			if (other.quoteSource != null)
				return false;
		} else if (!quoteSource.equals(other.quoteSource))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (yearFounded != other.yearFounded)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Park [parkCode=" + parkCode + ", parkName=" + parkName + ", state=" + state + ", acreage=" + acreage
				+ ", elevationFt=" + elevationFt + ", milesOfTrail=" + milesOfTrail + ", numberOfCampsites="
				+ numberOfCampsites + ", climate=" + climate + ", yearFounded=" + yearFounded + ", annualVisitorCount="
				+ annualVisitorCount + ", quote=" + quote + ", quoteSource=" + quoteSource + ", description="
				+ description + ", entryFee=" + entryFee + ", numberOfAnimalSpecies=" + numberOfAnimalSpecies + "]";
	}



	










	
	
	
	
}
