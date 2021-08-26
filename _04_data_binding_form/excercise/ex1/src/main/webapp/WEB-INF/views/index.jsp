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
<h3 style="color:blue;">Configuration of Email</h3>
<table border="1">
    <tr>
        <td>Language</td>
        <td>${emailConfig.language}</td>
    </tr>
    <tr>
        <td>Page Size</td>
        <td>${emailConfig.pageSize}</td>
    </tr>
    <tr>
        <td>Spam filter</td>
        <td>
            <c:if test="${emailConfig.spamFilter==true}">Enable spam filter</c:if>
            <c:if test="${emailConfig.spamFilter==false}">Unable spam filter</c:if>
        </td>
    </tr>
    <tr>
        <td>Signature</td>
        <td>${emailConfig.signature}</td>
    </tr>
    <tr>
        <td colspan="2" style="padding-left: 30px">
            <button><a href="/update">Update</a></button>
        </td>
    </tr>
</table>

</body>
</html>