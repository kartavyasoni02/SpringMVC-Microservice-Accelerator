<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="font-family: Arial; font-size: smaller;">
<%@ include file="header.jsp" %>
<center>
<h5 align="left"><a href='../users'>Back</a></h5>
Welcome to Micro Webservice World
	<c:if test="${!empty listUsers}">

		<table style="border-collapse: collapse;" border="1"
   bordercolor="#006699" width="500">
			<c:forEach items="${listUsers}" var="user">
				<tr >
					<td width="80" bgcolor="lightblue">User ID</td>
					<td>${user.id}</td>
				</tr>
				<tr>
					<td width="120" bgcolor="lightblue">First Name</td>
					<td>${user.firstName}</td>
				<tr>
					<td width="120" bgcolor="lightblue">Last Name</td>
					<td>${user.lastName}</td>
				</tr>
				<tr>
					<td width="120" bgcolor="lightblue">Email Id</td>
					<td>${user.email}</td>
				</tr>
				<tr>
					<td width="120" bgcolor="lightblue">User Name</td>
					<td>${user.userName}</td>
				</tr>
			</c:forEach>

		</table>
	</c:if>
	</center>
</body>
</html>