<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>   
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register page</title>
    <link href="style/style.css" rel="stylesheet" type="text/css">
    <style>
        .button:disabled {
            color: #717d7e; /* Change text color if needed */
            cursor: not-allowed; /* Change cursor to indicate it's not clickable */
        }
    </style>
    <script>
        function validatePasswords() {
            const password = document.getElementById("password").value;
            const user = document.getElementById("user").value;
            const confirmPassword = document.getElementById("confirmPassword").value;
            const errorMessage = document.getElementById("errorMessage");
            const registerButton = document.getElementById("registerButton");

			if (user === "" || user === null) {
							errorMessage.textContent = "User Id Should not be Empty!";
			                registerButton.disabled = true;
			}else if (password !== confirmPassword) {
                errorMessage.textContent = "Passwords do not match!";
                registerButton.disabled = true;
            } else if (password === "" || password === null) {
                errorMessage.textContent = "Passwords Should not be Empty!";
                registerButton.disabled = true;
            } else {
                errorMessage.textContent = "";
                registerButton.disabled = false;
            }
        }

    </script>
</head>
<body style="background-color: #EBEFEE;">
    <div align="center" class="headerStyle">
        <h1 class="h1">Register</h1>
    </div>
    <div align="right">
        <table align="right">
            <tr>
                <f:form action="logout" method="post">
                    <table align="right" class="actionButton">
                        <tr>
                            <td><button class="button" type="submit" name="Close">Close</button></td>
                        </tr>
                    </table>
                </f:form>
            </tr>
        </table>
    </div>
    <div align="center" class="box-shadow">
        <f:form action="userRegister" method="post" modelAttribute="login">
            <table class="table">
                <tr class="tr">
                    <td class="td"><img src="images/userID.png"></td>
                    <td class="td"><f:input id="user" style="text-align: center" path="userId" placeholder="User  Id" /></td>
                </tr>
                <tr class="td">
                    <td class="td"><img src="images/locked.png"></td>
                    <td class="td">
                        <f:input type="password" id="password" style="text-align: center" path="password" placeholder="Password" onkeyup="validatePasswords()" />
                    </td>
                </tr>
                <tr class="td">
                    <td class="td"><img src="images/locked.png"></td>
                    <td class="td">
                        <f:input type="password" id="confirmPassword" style="text-align: center" path="password" placeholder="Re-type Password" onkeyup="validatePasswords()" />
                    </td>
                </tr>
            </table>
            <br />
            <div id="errorMessage" style="color: red;"></div>
            <table class="actionButton">
                <tr class="tr">
                    <td class="td" colspan="2" align="center">
                        <button class="button" id="registerButton" type="submit" name="register" disabled>Register</button>
                    </td>
                </tr>
            </table>
        </f:form>
    </div>
</body>
</html>