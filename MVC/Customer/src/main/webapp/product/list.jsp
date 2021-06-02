<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 5/26/2021
  Time: 2:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Product List</title>
</head>
<body>
<h1>Product</h1>
<p>
    <a href="/product?action=create">Create new customer</a>
</p>
<table border="1">
    <tr>
        <td>Name</td>
        <td>Price</td>
        <td>Des</td>
        <td>Producer</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach items='${requestScope["data"]}' var="product">
    <tr>
        <td><a href="/product?action=view&id=${product.getId()}">${product.getName()}</a></td>
        <td>${product.getPrice()}</td>
        <td>${product.getDes()}</td>
        <td>${product.getProducer()}</td>
        <td><a href="/product?action=edit&id=${product.getId()}">edit</a></td>
        <td><a href="/product?action=delete&id=${product.getId()}">delete</a></td>
    </tr>
    </c:forEach>
</body>
</html>
