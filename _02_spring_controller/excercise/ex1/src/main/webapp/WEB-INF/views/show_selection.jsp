<%--
  Created by IntelliJ IDEA.
  User: This PC
  Date: 8/23/2021
  Time: 10:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Show Selected Condiments</title>
</head>
<body>
<h3 style="color: blue">Your Selected Condiments:</h3>
<c:forEach var="condiment" items="${selectedCon}" varStatus="num">
    <p>${num.count}. ${condiment}</p>
</c:forEach>

</body>
</html>
