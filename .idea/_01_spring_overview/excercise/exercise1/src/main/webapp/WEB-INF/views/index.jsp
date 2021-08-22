<%--
  Created by IntelliJ IDEA.
  User: This PC
  Date: 8/21/2021
  Time: 5:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
      <p>Rate <input type="text" name="rate" placeholder="Enter rate" value="${rate}"></p>
      <p>USD <input type="text" name="amount" placeholder="Enter amount (USD)" value="${amount}"></p>
      <p><input type="submit" value="Convert"></p>
      <c:if test="${vnd != null}">
        <p> Result: <input type="text" name="vnd" value="${vnd}" id="result"></p>
      </c:if>
    </fieldset>
  </form>

  </body>
</html>
