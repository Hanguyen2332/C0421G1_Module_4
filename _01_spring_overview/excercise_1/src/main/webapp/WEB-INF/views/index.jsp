<<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>Convert Currency</title>
  <style>
    p {
      color: blue;
      font-size: 20px;
    }
    #result {
      color: blue;
      font-size: 20px;
    }
  </style>
</head>
<body>
<form action="/converter" method="post">
  <fieldset>
    <legend>Convert USD to VND</legend>
    <p><input type="text" name="rate" placeholder="Enter rate" value="${rate}"></p>
    <p><input type="text" name="amount" placeholder="Enter amount (USD)" value="${amount}"></p>
    <p><input type="submit" value="Convert"></p

    <c:if test="${vnd != null}">
      <p><input type="text" name="vnd" value="${vnd}" id="result"></p>
    </c:if>

  </fieldset>
</form>
</body>
</html>