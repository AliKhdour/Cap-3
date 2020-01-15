package com.techelevator;

import static org.junit.Assert.assertEquals;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.npgeek.Models.Park.JdbcParkDao;
import com.techelevator.npgeek.Models.Park.Park;
import com.techelevator.npgeek.Models.Park.ParkDao;
import com.techelevator.npgeek.Models.Park.Weather;
import com.techelevator.npgeek.Models.Surveys.JdbcSurveyDao;
import com.techelevator.npgeek.Models.Surveys.Survey;

public class DAOIntegrationTest {

	/*
	 * Using this particular implementation of DataSource so that every database
	 * interaction is part of the same database session and hence the same database
	 * transaction
	 */
	private static SingleConnectionDataSource dataSource;
	private JdbcParkDao parkDao;
	private JdbcSurveyDao surveyDao;

	private Weather newWeather;
	private Park newPark;
	private Survey newSurvey;

	/*
	 * Before any tests are run, this method initializes the datasource for testing.
	 */
	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/npgeek");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		/*
		 * The following line disables autocommit for connections returned by this
		 * DataSource. This allows us to rollback any changes after each test
		 */
		dataSource.setAutoCommit(false);
	}

	/*
	 * After all tests have finished running, this method will close the DataSource
	 */
	@AfterClass
	public static void closeDataSource() throws SQLException {
		dataSource.destroy();
	}

	/*
	 * After each test, we rollback any changes that were made to the database so
	 * that everything is clean for the next test
	 */
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}

	/*
	 * This method provides access to the DataSource for subclasses so that they can
	 * instantiate a DAO for testing
	 */
	public DataSource getDataSource() {
		return dataSource;
	}

	@Before
	public void setup() {
		parkDao = new JdbcParkDao(dataSource);
		surveyDao = new JdbcSurveyDao(dataSource);

		String sqlDeleteWeather = "DELETE FROM weather;";
		String sqlDeleteSurvey = "DELETE FROM survey_result;";
		String sqlDeleteParks = "DELETE FROM park;";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sqlDeleteWeather);
		jdbcTemplate.update(sqlDeleteParks);
		jdbcTemplate.update(sqlDeleteSurvey);

		newPark.setParkCode("PROP");
		newPark.setParkName("Hank Hill Park");
		newPark.setState("Texas");
		newPark.setAcreage(50);
		newPark.setElevationFt(1200);
		newPark.setMilesOfTrail(4000);
		newPark.setNumberOfCampsites(100);
		newPark.setClimate("Woodland");
		newPark.setYearFounded(1997);
		newPark.setAnnualVisitorCount(10000);
		newPark.setQuote("what nobody understands is something someone understands");
		newPark.setQuoteSource("Jake Hawk");
		newPark.setDescription("I sell propain and propain parts");
		newPark.setEntryFee(90);
		newPark.setNumberOfAnimalSpecies(10);

		newSurvey.setParkcode("PROP");
		newSurvey.setEmailaddress("HankHill@hill.com");
		newSurvey.setState("Texas");
		newSurvey.setActivitylevel("active");

		newWeather.setParkCode("PROP");
		newWeather.setDay(1);
		newWeather.setLow(20);
		newWeather.setHigh(90);
		newWeather.setForecast("rain");

		parkDao.addPark(newPark);
		parkDao.addWeather(newWeather);
		surveyDao.saveSurvey(newSurvey);

	}

	@Test
	public void test_get_all_parks() {
		List<Park> allParks = parkDao.getAllParks();
		Park onePark = allParks.get(0);
		assertEquals(50, onePark.getAcreage());

	}

	@Test
	public void getParkByParkCode(){
//		Park thePark = new Park();
//
//		parkDao.addPark(thePark);
//		List<Park> results = parkDao.getParkByParkCode(parkCode);
//
//		assertNotNull(results);
//		assertEquals(1, results.size());
//		Park savedPark = results.get(0);
//		assertPrksAreEqual(thePark, savedPark);
	}

	@Test
	public void getWeatherByParkCode() {

	}

	@Test
	public void getWeatherAlerts() {

	}

	@Test
	public void getDayOneForecast() {

	}

	@Test
	public void getWeatherMessageFromForecast() {

	}

	@Test
	public void getImageNameFromForecast() {

	}

	@Test
	public void getFavoriteParks() {

	}

	@Test
	public void getValidUserWithPassword() {

	}

	@Test
	public void getAllUsers() {

	}

	@SuppressWarnings("unused")
	private Park getPark(String parkname, String state, int acreage, int elevationinfeet, double milesoftrail,
			int numberofcampsites, String climate, int yearfounded, int annualvisitorcount, String inspirationalquote,
			String inspirationalquotesource, String parkdescription, int entryfee, int numberofanimalspecies) {
		
		Park thePark = new Park();
		thePark.setParkName(parkname);
		thePark.setState(state);
		thePark.setAcreage(acreage);
		thePark.setElevationFt(elevationinfeet);
		thePark.setMilesOfTrail(milesoftrail);
		thePark.setNumberOfCampsites(numberofcampsites);
		thePark.setClimate(climate);
		thePark.setYearFounded(yearfounded);
		thePark.setAnnualVisitorCount(annualvisitorcount);
		thePark.setQuote(inspirationalquote);
		thePark.setQuoteSource(inspirationalquotesource);
		thePark.setDescription(parkdescription);
		thePark.setEntryFee(entryfee);
		thePark.setNumberOfAnimalSpecies(numberofanimalspecies);
		

		return thePark;
	}

	@SuppressWarnings("unused")
	private Weather getWeather(String parkCode, int day, int low, int high, String forecast)
	{Weather newWeather = new Weather();
	newWeather.setParkCode(parkCode);
	newWeather.setDay(day);
	newWeather.setLow(low);
	newWeather.setHigh(high);
	newWeather.setForecast(forecast);
		return newWeather;

	}
	@SuppressWarnings("unused")
	private Survey getSurvey(String parkcode,String emailaddress,String state,String activitylevel)
	{Survey newSurvey = new Survey();
	newSurvey.setParkcode(parkcode);
	newSurvey.setEmailaddress(emailaddress);
	newSurvey.setState(state);
	newSurvey.setActivitylevel(activitylevel);
		return newSurvey;

	}
	@SuppressWarnings("deprecation")
	private void assertPrksAreEqual(Park expected, Park actual) {
		assertEquals(expected.getParkName(), actual.getParkName());
		assertEquals(expected.getState(), actual.getState());
		assertEquals(expected.getAcreage(), actual.getAcreage());
		assertEquals(expected.getElevationFt(), actual.getElevationFt());
		assertEquals(expected.getMilesOfTrail(), actual.getMilesOfTrail());
		assertEquals(expected.getNumberOfCampsites(), actual.getNumberOfCampsites());
		assertEquals(expected.getClimate(), actual.getClimate());
		assertEquals(expected.getYearFounded(), actual.getYearFounded());
		assertEquals(expected.getAnnualVisitorCount(), actual.getAnnualVisitorCount());
		assertEquals(expected.getQuote(), actual.getQuote());
		assertEquals(expected.getQuoteSource(), actual.getQuoteSource());
		assertEquals(expected.getDescription(), actual.getDescription());
		assertEquals(expected.getEntryFee(), actual.getEntryFee());




		
	}
	private void assertWeatherAreEqual(Weather expected, Weather actual) {
		assertEquals(expected.getParkCode(), actual.getParkCode());
		assertEquals(expected.getDay(), actual.getDay());
		assertEquals(expected.getLow(), actual.getLow());
		assertEquals(expected.getHigh(), actual.getHigh());
		assertEquals(expected.getForecast(), actual.getForecast());


	}
	private void assertSurveyAreEqual(Survey expected, Survey actual) {
		assertEquals(expected.getParkcode(), actual);
		assertEquals(expected.getState(), actual.getState());
		assertEquals(expected.getEmailaddress(), actual.getEmailaddress());
		assertEquals(expected.getActivitylevel(), actual.getActivitylevel());

	}

}
