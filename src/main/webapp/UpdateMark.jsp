<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 2/10/2022
  Time: 5:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Mark</title>
</head>
<body>
<form action="UpdateMark" method="post">
    Enter course name:
    <input type="text" name="courseName">
    <br/>
    Enter student id :
    <input type="text" name="stdId">
    <br/>
    Enter mark :
    <input type="text" name="mark">
    <br/>
    <input type="submit" value="update mark">
    <br/>

</form>

</body>
</html>
