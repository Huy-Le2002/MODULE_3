<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>CurrencyConverter</title>
    <link rel="stylesheet" href="css/currency_converter.css">
</head>
<body>
<h2>Currency Converter</h2>
<form method="get" action="CurrencyConverterServlet">
    <label>Rate: </label><br/>
    <label>
        <input type="text" name="rate" placeholder="RATE"/>
    </label><br/>
    <label>USD: </label><br/>
    <label>
        <input type="text" name="usd" placeholder="USD"/>
    </label><br/>
    <input type = "submit" id = "submit" value = "Converter"/>
</form>
</body>
</html>