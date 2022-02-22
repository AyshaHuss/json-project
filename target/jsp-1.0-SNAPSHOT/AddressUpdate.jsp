<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 2/5/2022
  Time: 11:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Address Update</title>
</head>
<body>
<form method="post" action="AddressUpdate">
    Enter city:
    <input type="text" name="city">
    <br/>
    Enter street name:
    <input type="text" name="street">
    <br/>
    Enter building number:
    <input type="text" name="buildingNum">
    <br/>
    <input type="submit" value="update">
</form>
${msg}
</body>
</html>
