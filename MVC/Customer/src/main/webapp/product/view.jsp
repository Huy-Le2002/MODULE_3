<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 5/26/2021
  Time: 2:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View customer</title>
</head>
<body>
<h1>Customer details</h1>
<p>
    <a href="/product">Back to product list</a>
</p>
<table>
    <tr>
        <td>Name: </td>
        <td>${requestScope["data"].getName()}</td>
    </tr>
    <tr>
        <td>Price: </td>
        <td>${requestScope["data"].getPrice()}</td>
    </tr>
    <tr>
        <td>Des: </td>
        <td>${requestScope["data"].getDes()}</td>
    </tr>
    <tr>
        <td>Producer: </td>
        <td>${requestScope["data"].getProducer()}</td>
    </tr>
</table>
</body>
</html>
