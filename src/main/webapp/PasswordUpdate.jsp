<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 2/6/2022
  Time: 12:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Password Update</title>
</head>
<body>
<form action="PasswordUpdate" method="post">
    Enter new password:
    <input type="password" name="pass">
    <br/>
    <input type="submit" value="update">
</form>
${msg}
</body>
</html>
