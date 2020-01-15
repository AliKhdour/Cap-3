package com.techelevator.npgeek.Models.Surveys;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcSurveyDao implements SurveyDao{
JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcSurveyDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public void saveSurvey(Survey survey) {
		String SQLSave = "INSERT INTO survey_result (parkcode, emailaddress, state, activitylevel) VALUES (?,?,?,?);"	;
		jdbcTemplate.update(SQLSave, survey.getParkcode(), 
									 survey.getEmailaddress(), 
									 survey.getState(), 
									 survey.getActivitylevel());
	}

	@Override
	public List<FavoritePark> getFavoriteParks() {
		List<FavoritePark> aPark = new ArrayList<FavoritePark>();
		
		String SQLFavPark = "SELECT park.parkcode as code, park.parkname as name, count(surveyid) as count from park join survey_result on park.parkcode = survey_result.parkcode group by 1,2 order by 3 desc;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(SQLFavPark);
		
		while (results.next()) {
			FavoritePark newPark = mapRowToFavoritePark(results);
			aPark.add(newPark);
	
		}
		
		return aPark;
	}

	private FavoritePark mapRowToFavoritePark(SqlRowSet results) {
		FavoritePark newpark = new FavoritePark();
		newpark.setParkCode(results.getString("code"));
		newpark.setParkName(results.getString("name"));
		newpark.setSurveyCount(results.getInt("count"));
		return newpark;
	}
	
	
	
	
	
}
