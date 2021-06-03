<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 6/3/2021
  Time: 10:44 AM
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
    <h1>Product Management</h1>
    <h2>
        <a href="/product?action=create">Add New User</a>
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
            <th>Id</th>
            <th>Product Name</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Color</th>
            <th>Category</th>
            <th>Action</th>
        </tr>
        <c:forEach var="product" items="${list}">
            <tr>
                <td><c:out value="${product.id}"/></td>
                <td><c:out value="${product.productName}"/></td>
                <td><c:out value="${product.price}"/></td>
                <td><c:out value="${product.quantity}"/></td>
                <td><c:out value="${product.color}"/></td>
                <td><c:out value="${product.cateGoryName}"/></td>
                <td>
                    <a href="/product?action=edit&id=${product.id}">Edit</a>
                    <a href="/product?action=delete&id=${product.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>

    </table>
</div>
</body>
</html>
