<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

		<meta name="viewport" content="width=device-width, initial-scale=1"/>
		<link rel="stylesheet" href = "librerias/css/login.css" type = "text/css">
	<head>
		<title>Login</title>
	<body>
	<form action="servletLogin" method="POST">
  <h1>Login Trabajadores</h1>
  <div class="inset">
  <p>
    <label for="user">Usuario</label>
    <input type="text" name="username" id="user">
  </p>
  <p>
    <label for="password">Password</label>
    <input type="password" name="userpass" id="password">
  </p>
  </div>
  <p class="p-container">
    <span>¿Has olvidado tu Password?</span>
    <input type="submit" name="login" value="login">
  </p>
</form>
	</body>
</html>
