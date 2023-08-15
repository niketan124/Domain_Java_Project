<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Page</title>
<link rel="stylesheet" href="css/admin.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
	integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
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
		</div>
		<div class="form-main">
			<form action="admin-login">
				<input name="email" required="required" type="email"
					placeholder="enter emial address"> <input name="password"
					required="required" type="password" placeholder="enter password">
				<button type="submit">Login</button>
			</form>
		</div>
	</div>
</body>
</html>