<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 2/5/2022
  Time: 3:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login form</title>
</head>
<body>
${msg}
<form action="Login" method="post">
    username :
    <input type="text" name="username">
    <br/>
    password :
    <input type="password" name="pass">
    <br/>
    <input type="submit" value="Login">
</form>
</body>
</html>
