<%@page import="com.anime.model.Anime"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/searchResult.css">
</head>
<body>
	<%
	List<Anime> animeList = (List) request.getAttribute("aList");
	for (Anime anime : animeList) {
		out.println(anime.getAnimeName());
		out.println(anime.getImage());
		out.println(anime.getGenre());
		out.println(anime.getRating());
		out.println(anime.getDescription());
	}
	%>
	<h1 style="margin-left: 50px; text-align: center;">${message}</h1>
	<hr class="hr">
	<div class="main2">
		<div>
			<c:forEach items="${aList}" varStatus="status" var="obj">
				<div class="content">
					<img class="db-image" height="300px" width="900px" alt="image"
						src="dbImages/${obj.image}">
					<h1 style="color: #fff">
						<span>Anime name: </span>
						<c:out value="${obj.animeName }"></c:out>
					</h1>
					<h1 style="color: #fff">
						<span>Genre: </span>
						<c:out value="${obj.genre }"></c:out>
					</h1>
					<h1 style="color: #fff">
						<span>Rating: </span>
						<c:out value="${obj.rating }"></c:out>
					</h1>
					<h1 style="color: #fff">
						<span>Description: </span>
						<c:out value="${obj.description }"></c:out>
					</h1>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>