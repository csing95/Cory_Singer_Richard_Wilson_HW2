<%--
  Created by IntelliJ IDEA.
  User: csing
  Date: 4/1/2019
  Time: 10:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>
<html>
<head>
    <title>Select</title>
</head>
<body>
<form action="emailList" method="post">

    <form action="emailList" method="post">
        <input type="hidden" name="action" value="select">

        <label>Email: </label>
        <input type="email" name="email" required><br>

        <label>First Name:</label>
        <input type="text" name="firstName" required><br>

        <label>Last name: </label>
        <input type="text" name="lastName" required><br>

        <label>&nbsp</label>
        <input type="submit" value="Check Info" id="submit">

    </form>

    <table>
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th></th>

        </tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <td><input type="text" name="id" value="<c:out value="${user.id}"/>"></td>
                <td><input type="text" name="firstname" value="<c:out value="${user.firstName}"/>"></td>
                <td><input type="text" name="lastname" value="<c:out value="${user.lastName}"/>"></td>
                <td><input type="text" name="email" value="<c:out value="${user.email}"/>"></td>
            </tr>

        </c:forEach>
    </table>

</form>
</body>
</html>
