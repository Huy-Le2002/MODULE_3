<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Currency Converter</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<h2>Currency Converter</h2>
<form action="CurrencyConverter.jsp" method="get">
    <label>Rate:
        <input type="text" name="rate" placeholder="RATE"/>
    </label><br/>
    <label>USD:
        <input type="text" name="usd" placeholder="USD"/>
    </label><br/>
    <input type = "submit" id = "submit" value = "Converter"/>
</form>
</body>
</html>