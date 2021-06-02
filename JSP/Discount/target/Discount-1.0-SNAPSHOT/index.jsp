<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Discount</title>
</head>
<body>
<div class="container">
    <h2>Product Discount Calculator</h2>
    <div class="container-form">
        <form action="discount.jsp" method="get">
            <label>
                <input type="text" name="describe" placeholder="Product Description">
            </label>
            <label>
                <input type="text" name="price" placeholder="List Price">
            </label>
            <label>
                <input type="text" name="discount" placeholder="Discount Percent">
            </label>

            <input type="submit" id="submit" value="Enter">
        </form>
    </div>
</div>
</body>
</html>