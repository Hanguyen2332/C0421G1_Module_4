<%--
  Created by IntelliJ IDEA.
  User: This PC
  Date: 8/20/2021
  Time: 10:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Translate</title>
  </head>
  <body>
  <form action="/translate" method="post">
    <input type="text" name="english" placeholder="Enter word" value="${english}">
    <input type="submit" value="search">
<c:if test="${vietnamese != null}">
  <h4 style="color: blue">Result: ${vietnamese}</h4>
</c:if>
  </form>
  </body>
</html>
