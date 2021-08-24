<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Choose Condiment </title>
</head>
<body>

<h2>Sandwich Condiments</h2>

<form action="/calculate" method="post">
<div>
    <input type="text" name="a" value="${a}">
    <input type="text" name="b" value="${b}">
</div>
<%--    submit--%>
<div style="margin-top: 10px">
    <button type="submit" value="Addition" name="operand">Addition(+)</button>
    <button type="submit" value="Subtraction" name="operand">Subtraction(-)</button>
    <button type="submit" value="Multiplication" name="operand">Multiplication(*)</button>
    <button type="submit" value="Division" name="operand">Division(/)</button>
</div>
</form>
<%--hien thi result: --%>
<%--<c:if test="${message != null}">--%>
<%--    <div style="color: red">${message}</div>--%>
<%--</c:if>--%>
<c:if test="${result != null}">
    <h3 style="color: blue">Result ${operand}: ${result}</h3>
</c:if>



<%--</form>--%>

</body>
</html>