<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>   
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%> 

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search Employ</title>
</head>
<script type="text/javascript">
function setClickedButton(buttonName) {
    document.getElementById('clickedButton').value = buttonName;
}
</script>
<link href="style\style.css" rel="stylesheet" type="text/css">
<body style="background-color:#F8F8F8;">
	<div align="center" class="headerStyle">
		<h1 class="h1">Search Employ</h1>
	</div>
	<p class="errorMsg">${messages.msg}</p>
	<div align="right">
		<table align="right">
			<tr>
				<f:form action="logout" method="post">
					<table align="right" class="actionButton">
						<tr>
							<td><button class="button" type="submit" name="Logout">Logout</button></td>

						</tr>
					</table>
				</f:form>
			</tr>
			<tr>
				<f:form action="addemploy" method="get">
					<table align="right" class="actionButton">
						<tr>
							<td><button class="button" type="submit">Add
									Employ</button></td>

						</tr>
					</table>
				</f:form>
			</tr>
		</table>
	</div>
	<div align="center" class="box-shadow">
		<f:form action="result" method="post" modelAttribute="employ">
			<table align="center" class="table">
				<tr class="tr">
					<td class="td"><img src="images/employees.png"></td>
					<td class="td"><f:input type="text" name="empId" placeholder="Enter Employ Id" path="empId" /></td>
					<td class="td">
						<button type="submit" name="Search">
							<img src="images\search.png" alt="Submit">
						</button>
					</td>
					<td class="td"><input type="hidden" id="clickedButton" name="clickedButton" value="">
						<button type="submit" name="Reset" onclick="setClickedButton('Reset')">
							<img src="images/refresh-arrow.png" alt="Reset">
						</button>
					</td>
				</tr>
			</table>
		</f:form>
	</div>
</body>
</html>