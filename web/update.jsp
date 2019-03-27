<%--
  Created by IntelliJ IDEA.
  User: csing
  Date: 3/27/2019
  Time: 6:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update your info</title>
</head>
<body>
<form action="emailList" method="post">
    <input type="hidden" name="action" value="update">

    <label>Id: </label>
    <input type="text" name="id"><br>

    <label>Email: </label>
    <input type="email" name="email" required><br>

    <label>First Name:</label>
    <input type="text" name="firstName" required><br>

    <label>Last name: </label>
    <input type="text" name="lastName" required><br>

    <label>&nbsp</label>
    <input type="submit" value="Update Info" id="submit">
</form>
</body>
</html>
