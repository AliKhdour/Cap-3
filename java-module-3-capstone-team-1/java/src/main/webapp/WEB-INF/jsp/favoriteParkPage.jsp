<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:import url="/WEB-INF/jsp/common/header.jsp" />
<table>
	<c:forEach items="${favorites}" var="park">
		<tr>
			<td><img src="img/parks/${park.parkCode.toLowerCase()}.jpg" />
			</td>
			<td><h2>
					 ${park.parkName}
				</h2>
				<p>${park.surveyCount}</p></td>
		</tr>
	</c:forEach>
</table>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />