<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Employ</title>
</head>
<script type="text/javascript">

	function clickSave() {
		document.getElementById("MVCSAVE0001").click();
		
	}
	
</script>
<link href="style\tableStyles.css" rel="stylesheet" type="text/css">
<body style="background-color: #EBEFEE;">
	<div align="center" class="headerStyle">
		<h1 class="h1">Add Employ</h1>
	</div>
	<div>
		<p class="errorMsg">${messages}</p>
	</div>
<body>
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
				<f:form for="newEmploy" method="get">
					<table align="right" class="actionButton">
						<tr>
							<td><button class="button" type="button"
									onclick="clickSave()">Save</button></td>

						</tr>
					</table>
				</f:form>
			</tr>
		</table>
	</div>
	<div align="center">
		<f:form id="newEmploy" action="newEmploy" method="post" modelAttribute="employ">
			<table class="tbl">
				<tr class="tr">
					<td class="td"><b class="errorMsg">*</b>Employ No</td>
					<td class="td"><f:input path="empId" value="${employ.empId}" /></td>
					<td></td>
				</tr>
				<tr>
					<td><b class="errorMsg">*</b>Name:</td>
					<td><f:input path="name" /><br><output class="errorMsg">${name}</output></td>
				</tr>
				<tr>
					<td><b class="errorMsg">*</b>Gender</td>
					<td><f:select class="select" path="gender">
							<f:option value="MALE" label="Male" />
							<f:option value="FEMALE" label="Female" />
						</f:select></td>
						
				</tr>
				<tr>
					<td><b class="errorMsg">*</b>Department:</td>
					<td><f:input path="dept" /><br><output class="errorMsg">${dpt}</output></td>
					
				</tr>
				<tr>
					<td><b class="errorMsg">*</b>Designation:</td>
					<td><f:input path="desig" /><br><output class="errorMsg">${dsg}</output>  </td>
				</tr>
				<tr>
					<td><b class="errorMsg">*</b>Basic:</td>
					<td><f:input path="salary" /><br><output class="errorMsg">${sal}</output>  </td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<button class="button" id="MVCSAVE0001" type="submit" name="Save">Save</button>
					</td>

				</tr>
			</table>
		</f:form>
	</div>
</body>
</html>