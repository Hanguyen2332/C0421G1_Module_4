<%--
  Created by IntelliJ IDEA.
  User: This PC
  Date: 8/24/2021
  Time: 11:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Create New Employee</title>
</head>
<body>
<form:form action="/create" method="post" modelAttribute="newEmployee">
   <table>
       <tr>
           <td>ID:</td>
           <td><form:input path="id"/></td>
       </tr>
       <tr>
           <td>Name:</td>
           <td><form:input path="name"/></td>
       </tr>
       <tr>
           <td>Phone Number:</td>
           <td><form:input path="contactNumber"/></td>
       </tr>
       <tr>
           <td colspan="2"><input type="submit" value="Create Employee"></td>
       </tr>
   </table>
</form:form>
</body>
</html>
