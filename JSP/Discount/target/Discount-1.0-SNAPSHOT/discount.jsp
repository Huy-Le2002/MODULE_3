<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 5/25/2021
  Time: 2:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Discount</title>
</head>
<body>
<%
    float discount = Float.parseFloat(request.getParameter("discount"));
    double price = Double.parseDouble(request.getParameter("price"));
    double amount = price*discount*0.01;
    double rs = price - amount;
%>
<h2>Product Price: <%= price %></h2>
<h2>Discount: <%= discount %></h2>
<h2>Total price: <%= rs %></h2>
</body>
</html>
