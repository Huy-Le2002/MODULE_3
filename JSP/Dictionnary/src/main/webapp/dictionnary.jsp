<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 5/25/2021
  Time: 2:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dictionary</title>
</head>
<body>
<%
    Map<String,String> map = new HashMap<>();
    map.put("hello","xin chào");
    map.put("good bye","tạm biệt");
    map.put("sorry","xin lỗi");
    map.put("love you","yêu bạn");
    PrintWriter out1 = response.getWriter();
    String search = request.getParameter("txtSearch");
    String rs = map.get(search);
    if (rs != null) {
        out1.println("Word: " + search);
        out1.println("Result: " + rs);
    }
%>

</body>
</html>
