<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/adminHome.css">
</head>
<body>
	<div class="container">
		<div class="main">
			<h1 class="title">
				Welcome: <span style="color: #FC5185"> <%=request.getAttribute("email")%></span>
			</h1>
		</div>
		<div class="form-main">
			<form action="AnimeAdd" method="post" enctype="multipart/form-data">
				<input name="animename" required="required" type="text"
					placeholder="enter anime name"> <input class="imfile"
					name="image" required="required" type="file"> <input
					name="genre" placeholder="enter genre" type="text"> <input
					name="rating" type="number" placeholder="enter rating"> <input
					name="description" placeholder="enter description" type="text">
				<button type="submit">Add Anime</button>
			</form>
		</div>
	</div>
</body>
</html>