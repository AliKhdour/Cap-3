package com.techelevator.npgeek.Models.Surveys;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class Survey {

	
	
	private int surveyid;
	private String parkcode;
	
	@Email(message="Email must be a valid email address")
	@NotBlank(message="field is required")
	private String emailaddress;
	
	@NotBlank(message="field is required")
	private String state;
	
	@NotBlank(message="Please choose an activity level")
	private String activitylevel;
	
	public int getSurveyid() {
		return surveyid;
	}
	public void setSurveyid(int surveyid) {
		this.surveyid = surveyid;
	}
	public String getParkcode() {
		return parkcode;
	}
	public void setParkcode(String parkcode) {
		this.parkcode = parkcode;
	}
	public String getEmailaddress() {
		return emailaddress;
	}
	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getActivitylevel() {
		return activitylevel;
	}
	public void setActivitylevel(String activitylevel) {
		this.activitylevel = activitylevel;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((activitylevel == null) ? 0 : activitylevel.hashCode());
		result = prime * result + ((emailaddress == null) ? 0 : emailaddress.hashCode());
		result = prime * result + ((parkcode == null) ? 0 : parkcode.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + surveyid;
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
		Survey other = (Survey) obj;
		if (activitylevel == null) {
			if (other.activitylevel != null)
				return false;
		} else if (!activitylevel.equals(other.activitylevel))
			return false;
		if (emailaddress == null) {
			if (other.emailaddress != null)
				return false;
		} else if (!emailaddress.equals(other.emailaddress))
			return false;
		if (parkcode == null) {
			if (other.parkcode != null)
				return false;
		} else if (!parkcode.equals(other.parkcode))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (surveyid != other.surveyid)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Survey [surveyid=" + surveyid + ", parkcode=" + parkcode + ", emailaddress=" + emailaddress + ", state="
				+ state + ", activitylevel=" + activitylevel + "]";
	}
}
