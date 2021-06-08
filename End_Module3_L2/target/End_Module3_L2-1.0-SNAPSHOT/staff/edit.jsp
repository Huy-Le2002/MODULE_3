<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 6/4/2021
  Time: 7:09 AM
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
    <h1>User Management</h1>
    <h2>
        <a href="staff?action=staff">List All Users</a>
    </h2>
    <h3>
        ${message}
    </h3>
</center>
<div align="center">
    <form action="" method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit Staff
                </h2>
            </caption>
            <c:if test="${data_staff != null}">
                <input type="hidden" name="id" value="<c:out value='${data_staff.id}' />"/>
            </c:if>
            <th>groupstaff:</th>
            <td>
                <select name="groupstaff">
                    <c:forEach items="${groupStaff}" var="staff">
                        <c:choose>
                            <c:when test="${data_staff.groupstaff == staff}">
                                <option value="${staff}" selected>${staff}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${staff}">${staff}</option>
                            </c:otherwise>
                        </c:choose>
                </c:forEach>
                </select>
            </td>
            <tr>
                <th>Staff Name:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${data_staff.name}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Staff dob:</th>
                <td>
                    <input type="text" name="dob" size="45"
                           value="<c:out value='${data_staff.dob}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Staff phonenumber:</th>
                <td>
                    <input type="text" name="phonenumber" size="45"  pattern="[0]{1}[0-9]{9}" required
                           value="<c:out value='${data_staff.phonenumber}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Staff cmnd:</th>
                <td>
                    <input type="text" name="cmnd" size="45"
                           value="<c:out value='${data_staff.cmnd}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Staff email:</th>
                <td>
                    <input type="email" name="email" size="45"
                           value="<c:out value='${data_staff.email}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Staff address:</th>
                <td>
                    <input type="text" name="address" size="45"
                           value="<c:out value='${data_staff.address}' />"
                    />
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
