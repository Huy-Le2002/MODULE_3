<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 6/4/2021
  Time: 12:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<center>
    <h1>Student Management</h1>
    <h2>
        <a href="student?action=student">List All Users</a>
    </h2>
    <p>
        ${message}
    </p>
</center>
<div align="center">
    <form action="" method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit Student
                </h2>
            </caption>
            <c:if test="${data_student != null}">
                <input type="hidden" name="id" value="<c:out value='${data_student.id}' />"/>
            </c:if>
            <tr>
                <th>User Name:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${data_student.name}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>User Age:</th>
                <td>
                    <input type="text" name="age" size="45"
                           value="<c:out value='${data_student.age}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Spe:</th>
                <td>
                    <select name="specialized_id">
                        <c:forEach var="student" items="${data_spe}">
                            <c:choose>
                                <c:when test="${data_student.specialized_id == student.id}">
                                    <option value="${student.id}" selected>${student.getName()}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${student.id}">${student.getName()}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
