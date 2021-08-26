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
    <title>Update Email Configuration</title>
    <style>
       th{
            width: 150px;
        }
       td {
           width: 300px;
       }
    </style>
</head>
<body>
<h3 style="color: blue"></h3>
<form:form action="/update" method="post" modelAttribute="updateEmail">
    <fieldset>
        <legend>Update email</legend>
        <table>
            <tr>
                <th>Language:</th>
                <td>
                    <form:select path="language">
                        <form:options items="${languageList}"/>
                    </form:select>
                </td>
            </tr>
            <tr>
                <th>Page Size:</th>
                <td> Show
                    <form:select path="pageSize">
                        <form:options items="${pageSizeList}"/> <%--   Value?   itemValue="${updateEmail.language}"      itemValue="${updateEmail.pageSize}"     --%>
                    </form:select> Email per page
                </td>
            </tr>
            <tr>
                <th>Spam filter:</th>
                <td>
                    <form:checkbox path="spamFilter" value="${updateEmail.spamFilter}"/> Enable spam filter
                </td>
            </tr>
            <tr>
                <th>Signature:</th>
                <td>
                    <form:textarea path="signature" cols="15" rows="3"/>
                </td>
            </tr>
            <tr>
                <th></th>
                <td>
                    <input type="submit" value="Update" style="background-color: dodgerblue">
                    <button type="button" value=""><a href="/config">Cancel</a></button>>
                </td>
            </tr>
        </table>
    </fieldset>
</form:form>
</body>
</html>
