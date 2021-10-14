<%--
  Created by IntelliJ IDEA.
  User: ankush.gupta
  Date: 13-10-2021
  Time: 10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Registration</title>
    <style>
        .error {
            color: red;
        }

    </style>
</head>
<body>
<h1>Registration</h1>
<form:form modelAttribute="registration">
    <form:errors cssClass="error" path="*" element="div"></form:errors>
    <table>
        <tr>
            <td>
                <spring:message code="name" />:
            </td>
            <td>
                <form:input path="name" />
            </td>
            <td>
                <form:errors cssClass="error" path="name" element="div"></form:errors>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value= <spring:message code="save.changes"/>>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
