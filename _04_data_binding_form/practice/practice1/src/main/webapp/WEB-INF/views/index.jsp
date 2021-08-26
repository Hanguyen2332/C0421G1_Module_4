<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Choose Condiment </title>
</head>
<body>
<c:if test="${message!=null}">
    <h4 style="color: red">${message}</h4>
</c:if>
<table BORDER="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Phone Number</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="employeeObj" items="${employeeList}">
        <tr>
            <td>${employeeObj.id}</td>
            <td>${employeeObj.name}</td>
            <td>${employeeObj.contactNumber}</td>
            <td><button><a href="/create">Create</a></button></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>