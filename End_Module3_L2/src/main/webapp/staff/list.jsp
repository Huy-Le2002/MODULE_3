<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 6/4/2021
  Time: 7:08 AM
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
    <h1>Staff Management</h1>
    <h2>
        <a href="/staff?action=create">Add New Staff</a>
    </h2>
    <h3>Tìm kiếm theo mã nhân viên và tên nhân viên</h3>
    <form action="" method="get">
        <input type="hidden" name="action" value="find" />
        <%--        vì khi này nó chưa hiểu đường dẫn đang nằm ở đâu, nhưng th edit nó vẫn ở địa chỉ /user?action=edit nên nó sẽ tự hiểu là trỏ đến edit--%>
        <input type="search" name="key" />
        <input type="submit">
    </form>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Staff</h2></caption>
        <tr>
            <th>Mã nhân viên</th>
            <th>Nhóm nhân viên</th>
            <th>Họ tên</th>
            <th>Số điện thoại</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="staff" items="${list}">
            <tr>
                <td><c:out value="${staff.id}"/></td>
                <td><c:out value="${staff.groupstaff}"/></td>
                <td><c:out value="${staff.name}"/></td>
                <td><c:out value="${staff.phonenumber}"/></td>
                <td>
                    <a href="/staff?action=edit&id=${staff.id}">Edit</a>
                    <a href="/staff?action=delete&id=${staff.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>

    </table>
</div>
</body>
</html>

