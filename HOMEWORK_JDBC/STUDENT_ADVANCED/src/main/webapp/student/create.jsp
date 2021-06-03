<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 6/3/2021
  Time: 11:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="student">List All Users</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New User</h2>
            </caption>
            <tr>
                <th>User Name:</th>
                <td>
                    <input type="text" name="name" id="name" size="45"/>
                </td>
            </tr>
            <tr>
                <th>User Age:</th>
                <td>
                    <input type="text" name="age" id="age" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Spe:</th>
                <td>
                    <select name="specialized_id">
                        <c:forEach var="specialized" items='${requestScope["data"]}'>
                            <option value="${specialized.id}">${specialized.getName()}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
