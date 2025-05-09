<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>   
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<link href="style\style.css" rel="stylesheet" type="text/css">
<body style="background-color: #EBEFEE;">
	<div align="center" class="headerStyle">
		<h1 class="h1">Welcome to Spring Boot Appilication</h1>
	</div>
	</br>
	</br>
	</br>
	</br>
	<div align="center">
	<b style="color: #3D89F6">This Applicaton is to perfrom several operation on "Employ Data Base". </b>
	</br>
	<b style="color: #3D89F6">This is a Crud Application made with Spring Boot </b>
	</br>
	</br>
	<p style="color: #3D89F6">Please Login into Application to Access</p>
	<table align="center" class="actionButton">
		<tr>
			<td><a href="login"><button class="button" type="submit"
						name="login">LOG IN</button></a></td>
		</tr>
	</table>
	</div>
</body>
</html>