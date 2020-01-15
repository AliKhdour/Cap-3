<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:import url="/WEB-INF/jsp/common/header.jsp" />

<c:url value="/surveyPage" var="surveyPage" />

<div class="row">
	<div class="col-sm-2"></div>
	<div class="col-sm-8 h3">
	Please cast your vote for your favorite National Park, using the table below.<br>
	Thank you for taking our survey!
	</div>
	<div class="col-sm-2"></div>
</div>

<form:form action="${surveyPage}" method="POST" modelAttribute="Survey">
<div class="row"> 
	<div class="col-sm-2"></div>
	<div class="col">
	<label for="NationalPark">Which National Park is your favorite?</label> 
		<select name="parkcode"	id="NationalPark">
		<c:forEach items="${parks}" var="park" >
			<option value="${park.parkCode}">${park.parkName}</option>
		</c:forEach>
			</select>
	</div>
	<div class="col-sm-2"></div>
	
</div>

<div class="row">
	<div class="col-sm-2"></div>
	<div class="col">
		<label for="emailaddress">What is your email? (will probably be sold)</label>
		<form:input path="emailaddress" />
		<form:errors path="emailaddress" cssClass="error" />
	</div>
	<div class="col-sm-2"></div>
</div>

	
<div class="row" >
<div class="col-sm-2"></div>
	<div class="col">
	<label for="state">What is your state of residence?</label> 
		<select name="state"	id="state">
			<option value="Alabama">Alabama</option>
			<option value="Alaska">Alaska</option>
			<option value="Arizona">Arizona</option>
			<option value="Arkansas">Arkansas</option>
			<option value="California">California</option>
			<option value="Colorado">Colorado</option>
			<option value="Connecticut">Connecticut</option>
			<option value="Delaware">Delaware</option>
			<option value="District of Columbia">District of Columbia</option>
			<option value="Florida">Florida</option>
			<option value="Georgia">Georgia</option>
			<option value="Hawaii">Hawaii</option>
			<option value="Idaho">Idaho</option>
			<option value="Illinois">Illinois</option>
			<option value="Indiana">Indiana</option>
			<option value="Iowa">Iowa</option>
			<option value="Kansas">Kansas</option>
			<option value="Kentucky">Kentucky</option>
			<option value="Louisiana">Louisiana</option>
			<option value="	Maine">Maine</option>
			<option value="Maryland">Maryland</option>
			<option value="Massachusetts">Massachusetts</option>
			<option value="Michigan">Michigan</option>
			<option value="Minnesota">Minnesota</option>
			<option value="Mississippi">Mississippi</option>
			<option value="Missouri">Missouri</option>
			<option value="Montana">Montana</option>
			<option value="Nebraska">Nebraska</option>
			<option value="Nevada">Nevada</option>
			<option value="New Hampshire</">New Hampshire</option>
			<option value="New Jersey">New Jersey</option>
			<option value="New Mexico">New Mexico</option>
			<option value="New York">New York</option>
			<option value="North Carolina">North Carolina</option>
			<option value="North Dakota">North Dakota</option>
			<option value="Ohio">OHIO</option>
			<option value="Oklahoma">Oklahoma</option>
			<option value="Oregon">	Oregon</option>
			<option value="Pennsylvania">	Pennsylvania</option>
			<option value="Rhode Island">	Rhode Island</option>
			<option value="South Carolina">	South Carolina</option>
			<option value="South Dakota">South Dakota</option>
			<option value="Tennessee">Tennessee</option>
			<option value="Texas">	Texas</option>
			<option value="Utah">	Utah</option>
			<option value="Vermont">	Vermont</option>
			<option value="Virginia">	Virginia</option>
			<option value="Washington">	Washington</option>
			<option value="West Virginia">	West Virginia</option>
			<option value="Wisconsin">Wisconsin</option>
			<option value="Wyoming">Wyoming</option>
		</select>
	</div>
	<div class="col-sm-2"></div>
</div>
	
<div class="row">
<div class="col-sm-2"></div>
	<div class="form-check col">
	<label>What is your activity level?</label>
	<input class="form-check-input" type="radio" name="activitylevel" id="inactive" value="Inactive" />
	<label class="form-check-label" for="inactive" >Inactive</label>
	<input class="form-check-input" type="radio" name="activitylevel" id="sedentary" value="Sedentary" />
	<label class="form-check-label" for="sedentary" >Sedentary</label>
	<input class="form-check-input" type="radio" name="activitylevel" id="active" value="Active" />
	<label class="form-check-label" for="active" >Active</label>
	<input class="form-check-input" type="radio" name="activitylevel" id="extremely active" value="Extremely Active" />
	<label class="form-check-label" for="extremely active" >Extremely Active</label>
	</div>
	<div class="col-sm-2"></div>
</div>

<div class="row">
	<div class="col-sm-2"></div>
	<div class="col">
	<input type="submit" value="Cast your vote" />
	</div>
	<div class="col-sm-2"></div>
</div>
</form:form>



<c:import url="/WEB-INF/jsp/common/footer.jsp" />