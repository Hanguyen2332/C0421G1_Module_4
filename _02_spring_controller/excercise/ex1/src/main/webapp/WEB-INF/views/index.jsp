<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Choose Condiment </title>
</head>
<body>

<h2>Sandwich Condiments</h2>

<form action="/save_condiment" method="get">
    <div>
        <c:forEach var="condiment" items="${condimentList}">
            <input type="checkbox" name="selectedCon" value="${condiment}">  ${condiment}
        </c:forEach>
    </div>
    <hr>
    <div>
        <input type="submit" value="Save">
    </div>
</form>

</body>
</html>