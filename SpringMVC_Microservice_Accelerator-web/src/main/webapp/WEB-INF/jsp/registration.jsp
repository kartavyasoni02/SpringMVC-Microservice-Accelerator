<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Registration Form</title>
<style type="text/css">
<%--
<%@
include file ="resources /css/style.css "%> --%> .error {
	color: #ff0000;
}
</style>

</head>

<body>
	


	<div align="center">
	
		<form:form action="signup" method="POST"
			modelAttribute="employee">
			<table>
			<tr>
					<td><label for="userName">User Name: </label></td>
					<td><form:input  path="userName" /></td>
					<td><form:errors path="userName" cssClass="error" /></td>
				</tr>
				<tr>
					<td><label for="password">Password: </label></td>
					<td><form:password path="password" /></td>
					<td><form:errors path="password" cssClass="error" /></td>
				</tr>
				<tr>
					<td><label for="firstName">first Name: </label></td>
					<td><form:input path="firstName" /></td>
					<td><form:errors path="firstName" cssClass="error" /></td>
				</tr>

				<tr>
					<td><label for="lastName">last Name: </label></td>
					<td><form:input path="lastName" /></td>
					<td><form:errors path="lastName" cssClass="error" /></td>
				</tr>

				<tr>
					<td><label for="email">Email: </label></td>
					<td><form:input path="email" /></td>
					<td><form:errors path="email" cssClass="error" /></td>
				</tr>
				<tr>
					<td colspan="1"><input type="submit" class="btn btn-info"
						value="add" /></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>