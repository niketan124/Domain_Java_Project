<%@page import="com.anime.model.Anime"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% Anime anime = (Anime) request.getAttribute("anime");
	String imageName = (String) request.getAttribute("image");
%>
<div>
<img width="500px" height="500px" alt="one" src="dbImages/<%= imageName %>">
</div>
</body>
</html>