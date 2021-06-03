<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 6/3/2021
  Time: 11:54 AM
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
        <a href="product">List All Users</a>
    </h2>
    <p>
        ${message}
    </p>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit Product
                </h2>
            </caption>
            <c:if test="${data_product!= null}">
                <input type="hidden" name="id" value="<c:out value='${data_product.id}'/>"/>
            </c:if>
            <tr>
                <th>Product Name:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="${data_product.productName}"
                    />
                </td>
            </tr>
            <tr>
                <th>Product Price:</th>
                <td>
                    <input type="text" name="price" size="45"
                           value="${data_product.price}"
                    />
                </td>
            </tr>
            <tr>
                <th>Product Quantity:</th>
                <td>
                    <input type="text" name="quantity" size="45"
                           value="${data_product.quantity}"
                    />
                </td>
            </tr>
            <tr>
                <th>Product Color:</th>
                <td>
                    <input type="text" name="color" size="45"
                           value="${data_product.color}"
                    />
                </td>
            </tr>
            <tr>
                <th>Product Des:</th>
                <td>
                    <input type="text" name="des" size="45"
                           value="${data_product.des}"
                    />
                </td>
            </tr>
            <tr>
                <th>Category:</th>
                <td>
                    <select name="category">
                        <c:forEach var="category" items="${data_category}">
                            <c:choose>
                                <c:when test="${data_product.cateGory == category.id}">
                                    <option value="${category.id}" selected>${category.getName()}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${category.id}">${category.getName()}</option>
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