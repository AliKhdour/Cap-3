package com.techelevator.npgeek.Models.Surveys;

import java.util.List;

public interface SurveyDao {
	
	public void saveSurvey(Survey survey);
	
	public List<FavoritePark> getFavoriteParks();

}
