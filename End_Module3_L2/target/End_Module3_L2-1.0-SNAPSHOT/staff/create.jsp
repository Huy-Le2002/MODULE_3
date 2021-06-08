<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 6/4/2021
  Time: 7:09 AM
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
    <h1>Staff Management</h1>
    <h2>
        <a href="staff">List All Staff</a>
    </h2>
    <h3>
        ${message}
    </h3>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New Staff</h2>
            </caption>
            <tr>
                <th>groupstaff:</th>
                <td>
                    <select name="groupstaff">
                    <c:forEach items="${groupData}" var="staff">
                        <option value="${staff}">${staff}</option>
                    </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Staff name:</th>
                <td>
                    <input type="text" name="name" size="45" required/>
                </td>
            </tr>
            <tr>
                <th>Staff dob:</th>
                <td>
                    <input type="text" name="dob" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Staff phonenumber:</th>
                <td>
                    <input type="tel" name="phonenumber" size="45" pattern="[0]{1}[0-9]{9}" required/>
                </td>
            </tr>
            <tr>
                <th>Staff cmnd:</th>
                <td>
                    <input type="text" name="cmnd" size="45" required/>
                </td>
            </tr>
            <tr>
                <th>Staff email:</th>
                <td>
                    <input type="email" name="email" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Staff address:</th>
                <td>
                    <input type="text" name="address" size="45"/>
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
