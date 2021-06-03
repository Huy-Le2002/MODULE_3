<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 6/3/2021
  Time: 11:58 PM
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
    <h1>Student Management</h1>
    <h2>
        <a href="student">List All Users</a>
    </h2>
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
