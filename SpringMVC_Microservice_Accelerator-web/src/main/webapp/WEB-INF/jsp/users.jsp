<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%-- <%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>  --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
 
<body>
<%@ include file="header.jsp" %>
<center>
<a href="<c:url value='registration' />">Registration of employee</a>
	<h3>Users List</h3>
	<c:if test="${!empty listUsers}">
		<table style="border-collapse: collapse;" border="1"
   bordercolor="#006699" width="500">
			<tr bgcolor="lightblue">
				<th width="80">User ID</th>
				<th width="120">First Name</th>
				<th width="120">Last Name</th>
				<th width="120">Email Id</th>
				<th width="120">User Name</th>
				<th width="120">view</th>
			</tr>
			<c:forEach items="${listUsers}" var="user">
				<tr>
					<td>${user.id}</td>
					<td>${user.firstName}</td>
					<td>${user.lastName}</td>
					<td>${user.email}</td>
					<td>${user.userName}</td>
					<td><a href="<c:url value='view/${user.id}' />">View</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	</center>
</body>
</html>