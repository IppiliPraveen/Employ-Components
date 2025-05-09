<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<link href="style\tableStyles.css" rel="stylesheet" type="text/css">
<body style="background-color: #EBEFEE;">
	<div align="center" class="headerStyle">
		<h1 class="h1">Employ Result</h1>
	</div>
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
				<f:form action="closeEmpResults" method="post">
					<table align="right" class="actionButton">
						<tr>
							<td><button class="button" type="submit" name="Close">Close</button></td>

						</tr>
					</table>
				</f:form>
			</tr>
			<tr>
				<f:form action="addemploy" method="get">
					<table align="right" class="actionButton">
						<tr>
							<td><button class="button" type="submit">Add Employ</button></td>

						</tr>
					</table>
				</f:form>
			</tr>
		</table>
	</div>
	<div>
		<table align="center" class="tbl">
			<tr class="th1">
				<th>Employ ID</th>
				<th>Employ Name</th>
				<th>Gender</th>
				<th>Department</th>
				<th>Designation</th>
				<th>salary</th>
			</tr>
			<c:forEach var="employ" items="${listEmploy}">
				<tr class="tr">
					<td><a href="editemploy?empId=${employ.empId}">${employ.empId}</a>
					</td>
					<td>${employ.name}</td>
					<td>${employ.gender}</td>
					<td>${employ.dept}</td>
					<td>${employ.desig}</td>
					<td>${employ.salary}</td>
				</tr>
			</c:forEach>
			<tr class="button">
				<td>
				<a href="result?page=${previous}"> << </a> 
				<a href="result?page">${page} </a> 
				<a href="result?page">2</a> 
				<a href="result?page">3 </a> 
				<a href="result?page"> >></a>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>
