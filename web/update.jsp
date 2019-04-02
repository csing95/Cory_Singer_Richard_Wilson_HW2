<%--
  Created by IntelliJ IDEA.
  User: csing
  Date: 3/27/2019
  Time: 6:14 PM
  To change this template use File | Settings | File Templates.

  TODO: Ask a user to input their email into textbox and press a select button.
  TODO: Once select button is pressed, user is redirected to an select page that appears as a confimation with email being passed in.
  TODO: Once confirm button is pressed, user is redirected to update page with id autofilled into text box allowing update based off of id.

  TODO: Or use JSTL to read id out of database and then update based off of id. Yeah, do that. LINK: https://www.tutorialspoint.com/jsp/jstl_sql_query_tag.htm

--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
    <link rel="stylesheet" href="css/main.css">
</head>
<body>
<h1> Update Your Info</h1>
<p>To update your information, enter your user ID in the field and then the info you wish to change.</p>
<p>If you are unsure what your id is, please press the Check Info button.</p>

<form action="emailList" method="post">
    <input type="hidden" name="action" value="update">

    <a href="select.html"><input type="button" value="Look up ID"></a>
    <a href="index.html"><input type="button" value="Homepage"></a><br>

    <label>Id: </label>
    <input type="text" name="id" required><br>

    <label>Email: </label>
    <input type="email" name="email" required><br>

    <label>First Name:</label>
    <input type="text" name="firstName" required><br>

    <label>Last name: </label>
    <input type="text" name="lastName" required><br>

    <label>&nbsp</label>
    <input type="submit" value="Update Info" id="submit">

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
                <td><input type="text" name="id"  readonly value="<c:out value="${user.id}"/>"></td>
                <td><input type="text" name="firstname" readonly value="<c:out value="${user.firstName}"/>"></td>
                <td><input type="text" name="lastname" readonly value="<c:out value="${user.lastName}"/>"></td>
                <td><input type="text" name="email" readonly value="<c:out value="${user.email}"/>"></td>
            </tr>

        </c:forEach>
    </table>

</form>
</body>
</html>
