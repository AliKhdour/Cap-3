<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>National Park Geek</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<c:url value="/css/npgeek.css" var="cssHref" />
<link rel="stylesheet" href="${cssHref}">
</head>

<body>
	<div>
		<header>
			<c:url value="/" var="homePageHref" />
			<c:url value="/img/logo.png" var="logoSrc" />
			<a href="${homePageHref}"> <img src="${logoSrc}"
				alt="National Park Geek logo" class="header-img" />
			</a>
		</header>
		<nav>
			<div class="nav-bar">
				<c:url value="/home" var="home" />
				<a href="${home}" class="nav-button">Home</a>
				<c:url value="/surveyPage" var="survey" />
				<a href="${survey}" class="nav-button">Survey</a>
				
				<div class="navbar-right">
					<c:if test="${empty appCurrentUser}">
						<c:url value="/login" var="login" />
						<a href="${login}" class="nav-button">Login</a>
					</c:if>
					<c:if test="${not empty appCurrentUser}">
						<a href="#" class="nav-button">${appCurrentUser.username }</a>
						<c:url value="/logout" var="logoutURL" />
						<a href="${logoutURL}" class="nav-button">Log Out</a>
					</c:if>
				</div>
			</div>
		</nav>
	</div>