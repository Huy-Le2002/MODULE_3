<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 5/25/2021
  Time: 12:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CurrencyConverter</title>
</head>
<body>
<%
    float rate = Float.parseFloat(request.getParameter("rate"));
    float usd = Float.parseFloat(request.getParameter("usd"));
    float rs = rate*usd;
%>
<h2>Rate: <%= rate %></h2>
<h2>USD: <%= usd %></h2>
<h2>Result: <%= rs %></h2>

</body>
</html>
