<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="d" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>c:out example</title></head>
<body>
<d:set var = "salary" scope = "session" value = "${2000*2}"/>
<d:out value = "${salary}"/>
<form action="">
    <input type="text" value="${salary}">
</form>
</body>
</html>