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
		<h1 class="h1">Log In</h1>
	</div>
	<div>
	</div>
	<div align="center" class="box-shadow">
		<f:form action="loginDetails" method="post" modelAttribute="login">
		<p style="color: #3D89F6">For Admin Login Use Admin Credentials it will redirect you to Admin Operations Page</p>
			<table class="table">
				<tr class="tr">
					<td class="td"><img src="images/userID.png"></td>
					<td class="td"><f:input style="text-align: center" path="userId"
							placeholder="User Id" /></td>
				</tr>
				<tr class="td">
					<td class="td"><img src="images/locked.png"></td>
					<td class="td"><f:input type="password"
							style="text-align: center" path="password" placeholder="Password" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><output class="errorMsg">${errMsg}</output></td>
				</tr>
			</table>
			</br>
			<table class="actionButton">
				<tr class="tr">
					<td class="td" colspan="2" align="center"><button
							type="submit">
							<img src="images/Log.png" alt="Log In">
						</button></td>
				</tr>

			</table>
		</f:form>
		<p style="color: #3D89F6">Not Have An Account ?</p>
		<table align="center" class="actionButton">
			<tr>
				<td><a href="register"><button class="button" type="submit"
							name="register">register</button></a></td>

			</tr>
		</table>
	</div>
</body>
</html>