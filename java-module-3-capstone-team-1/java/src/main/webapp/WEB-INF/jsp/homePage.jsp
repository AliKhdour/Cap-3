<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />
	<c:url value="/detail" var="detailURL" />
	<c:forEach items="${parks}" var="park">
		<div class="park-listing row" >
			<div class="col-sm-6">
			<h2><a href="${detailURL}?parkCode=${park.parkCode}&temp=F">${park.parkName}</a></h2>
			<p>${park.description}</p>
			</div>
			<div class="col-sm-6">
			<a href="${detailURL}?parkCode=${park.parkCode}&temp=F"> 							
			<img class="img-thumbnail" src="img/parks/${park.parkCode.toLowerCase()}.jpg" />
			</a>
			</div>
		</div>
	</c:forEach>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />