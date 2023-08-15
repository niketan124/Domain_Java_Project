<%@page import="java.util.ArrayList"%>
<%@page import="com.anime.model.Anime"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.anime.db.DbConnection"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Anime Home</title>
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
	integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<%
ResultSet rs;
List<Anime> animeList = new ArrayList<Anime>();
try {
	Class.forName("com.mysql.cj.jdbc.Driver");
} catch (Exception e) {
	// TODO: handle exception
	e.printStackTrace();
}
try {
	Connection con = DbConnection.openConnection();
	PreparedStatement ps = con.prepareStatement("select * from anime");
	rs = ps.executeQuery();
	while (rs.next()) {
		String name = rs.getString("animeName");
		String image = rs.getString("image");
		String genre = rs.getString("genre");
		Integer rating = rs.getInt("rating");
		String description = rs.getString("description");
		Anime anime = new Anime(name, image, genre, rating, description);
		System.out.println(anime.toString());
		animeList.add(anime);
		System.out.println(rs.getString("image"));
	}
	request.setAttribute("aList", animeList);
	for (Anime anime : animeList) {
		System.out.println(anime.getAnimeName());
		System.out.println(anime.getImage());
		System.out.println(anime.getGenre());
	}
} catch (Exception e) {
	System.out.print("help");
}
%>
<body>
	<div class="container">
		<div class="main">
			<div class="top">
				<div>
					<h1 style="margin-left: 20px">
						<a href="index.jsp"><i class="fa-solid fa-dragon"></i> Anime</a>
					</h1>
				</div>

				<img width="300px" height="100px" alt="" src="images/op.png">

				<div>
					<h1 style="margin-right: 20px">
						<a href="admin.jsp"><i class="fa-solid fa-right-to-bracket"></i>
							Admin</a>
					</h1>
				</div>
			</div>
			<div class="img">
				<div class="text">
					<h1>Search</h1>
					<br>
					<h1>your favourite anime!</h1>
					<form action="AnimeSearch">
						<input name="animename" class="sanime" type="search"
							placeholder="search anime here...">
					</form>
				</div>
				<img class="one" alt="one_piece" src="images/one.jpg">
			</div>
			<br>
		</div>
		<br>
		<div style="position: relative; top: 24rem;">
			<h1 style="text-align: center;">Top Airing Animes's</h1>
			<hr class="hr">
		</div>
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
	</div>
</body>
</html>