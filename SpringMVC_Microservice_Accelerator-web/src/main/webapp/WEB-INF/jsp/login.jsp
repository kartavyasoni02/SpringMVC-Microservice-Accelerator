<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ include file="/WEB-INF/jsp/include.jsp"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Login.</title>
         <style>
    .error
    {
        color: #ff0000;
        font-weight: bold;
    }
    </style>
    </head>
    <body>
     <div style="color:red" >${error}</div>
    
       <form:form action="signin" modelAttribute="employee" method="post">
          
            <table align="center"><tr>
           <th>  <a href="<c:url value='registration'/>">Signup</a></th>
       <th> <h4>User Login.</h4></th>
            </tr>
             
                <tr>
                <td>User Name :</td>
                <td><form:input path="userName" /></td>
                 <td><form:errors path="userName" cssClass="error" /></td>
                </tr>
                <tr>
                <td>Password :</td>
                
                <td><form:password path="password" /></td>
                 <td><form:errors path="password" cssClass="error" /></td>
                </tr>
                
                <tr><td colspan="2" align="right"><input type="submit" value="Submit"></td></tr>
            </table>
          
        </form:form>
 
    </body>
</html>