<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<c:url var="loginURL" value="/login"/>
<form action="${loginURL}" method="POST">
	<div>
		<label for="username">Username</label>
		<input type="text" id="username" name="username" placeholder="Username" />
	</div>
	<div>
		<label for="password">Password</label>
		<input type="password" id="password" name="password" />
	</div>
	<button type="submit" class="button" >Login</button>
	
</form>



<c:import url="/WEB-INF/jsp/common/footer.jsp" />