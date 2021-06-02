<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="index.css">
</head>
<body>
<div>
    <h1>Simple Calculator</h1>
    <form action="ResultServlet" method="get">
        <fieldset>
            <legend>Calculator</legend>
            <label>First operand:
                <input type="text" id="input1" name="input1">
            </label>
            <br>
            <label for="cal">Operator</label>
            <select name="choose" id="cal">
                <option value="+">plus</option>
                <option value="-">minus</option>
                <option value="*">multiply</option>
                <option value="/">share</option>
            </select>
            <br>
            <label>Second operand:
                <input type="text" name="input2">
            </label>
            <br>
            <input type="submit" id="submit" value="Calculate">
        </fieldset>
    </form>
</div>


</body>
</html>