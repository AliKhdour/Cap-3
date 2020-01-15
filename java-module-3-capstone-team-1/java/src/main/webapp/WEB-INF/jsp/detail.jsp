<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />
<c:url value="/detail" var="detailURL" />
<div class="row">
	<div class="col-sm-6">
		<h3>${park.parkName}
			<span class=" h4 text-muted">${park.state}</span>
		</h3>
		<h5>
			<em>${park.quote}</em>
		</h5>
		<h5>- ${park.quoteSource}</h5>
		${park.description}
	</div>
	
	<div class="col-sm-6">
		<img src="img/parks/${park.parkCode.toLowerCase()}.jpg"
			class="detail-img img-thumbnail" />
	</div>
</div>



<div class="row">
<div class="col-sm-3">
	<c:if test="${park.entryFee > 0}">Daily visitor fee: $${park.entryFee}.00 per vehicle</c:if>
	<c:if test="${park.entryFee == 0}">Daily visitor fee: Free</c:if>
	</div>
	<div class="col-sm-3">
	Hiking: ${park.milesOfTrail } miles of trail
	</div>
	<div class="col-sm-3">Camping: ${park.numberOfCampsites} camp sites available</div>
	<div class="col-sm-3"></div>
</div>

<div class="row">
	<div class="col-sm-3">
		Park spans ${park.acreage } total acres
	</div>
	<div class="col-sm-3">${park.elevationFt}' elevation</div>
		<div class="col-sm-3">Founded in ${park.yearFounded}</div>
		<div class="col-sm-3"></div>
</div>

<div class="row">
	<div class="col-sm-3">Visitors per year:
		${park.annualVisitorCount}</div>
	<div class="col-sm-3">Climate: ${park.climate}</div>
	<div class="col-sm-3">Home to ${park.numberOfAnimalSpecies}
		species of animals</div>
	<div class="col-sm-3"></div>
</div>

<div class="detail-weather row">
	<c:forEach items="${weather}" var="weather">
		<c:set var="imageName" value="" />
		<c:if test="${weather.forecast.equals('partly cloudy') }">
			<c:set var="imageName" value="partlyCloudy" />
		</c:if>
		<c:if test="${weather.forecast.equals('partly cloudy') }">
			<c:set var="imageName" value="${weather.forecast }" />
		</c:if>

		<c:if test="${weather.day == 1}">
			<div class="col-m-2">
				<h4>Upcoming Weather:</h4>
				<a href="detail?parkCode=${park.parkCode}&temp=F"><input
					class="btn btn-outline-primary" type="submit" value="Fahrenheit" /></a>
				<a href="detail?parkCode=${park.parkCode}&temp=C"><input
					class="btn btn-outline-primary" type="submit" value="Celsius" /></a>
			</div>
			<div class="col-m-2">
				<img src="img/weather/${weather.forecast}.png"
					class="img-circle img-thumbnail" />
				<table class="table table-borderless">
					<thead>
						<tr>
							<th scope="col">High</th>
							<th scope="col">Low</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th scope="row">${weather.high}</th>
							<th scope="row">${weather.low}</th>
						</tr>
						<tr>
							<th scope="row"><span class="alert-warning">${weatherMessage}</span></th>
						</tr>
						<c:forEach items="${weatherAlerts}" var="alert">
						<tr>
							<th scope="row"><span class="alert-danger">	${alert}</span></th>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</c:if>
		<c:if test="${weather.day > 1}">
			<div class=" col-m-2">
				<img src="img/weather/${weather.forecast}.png"
					class="img-thumbnail" />
				<table class="table">
					<thead>
						<tr>
							<th scope="col">High</th>
							<th scope="col">Low</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th scope="row">${weather.high}</th>
							<th scope="row">${weather.low}</th>
						</tr>
					</tbody>
				</table>
			</div>
		</c:if>
	</c:forEach>
</div>





<c:import url="/WEB-INF/jsp/common/footer.jsp" />