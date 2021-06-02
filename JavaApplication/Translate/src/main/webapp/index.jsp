<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>TranslateServlet</title>
    <link rel="stylesheet" href="">
</head>
<body>
<div class="container">
    <h2>Vietnamese Dictionary</h2>
    <div class="container-form">
        <form action="TranslateServlet" method="get">
            <label>
                <input type="text" name="txtSearch" placeholder="Enter your word: ">
            </label>
            <input type="submit" id="submit" value="Search">
        </form>
    </div>
</div>
</body>
</html>