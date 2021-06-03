<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 6/3/2021
  Time: 11:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="/student?action=create">Add New User</a>
    </h2>
    <h2>
        <a href="/student?action=sort">Sort Name</a>
    </h2>
    <h3>Tìm kiếm</h3>
    <form action="" method="get">
        <input type="hidden" name="action" value="find" />
        <%--        vì khi này nó chưa hiểu đường dẫn đang nằm ở đâu, nhưng th edit nó vẫn ở địa chỉ /user?action=edit nên nó sẽ tự hiểu là trỏ đến edit--%>
        <input type="search" name="key" />
        <input type="submit">
    </form>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Users</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Age</th>
            <th>Pre</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="student" items="${list}">
            <tr>
                <td><c:out value="${student.id}"/></td>
                <td><c:out value="${student.name}"/></td>
                <td><c:out value="${student.age}"/></td>
                <td><c:out value="${student.specialized_name}"/></td>
                <td>
                    <a href="/student?action=edit&id=${student.id}">Edit</a>
                    <a href="/student?action=delete&id=${student.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>

    </table>
</div>
</body>
</html>

