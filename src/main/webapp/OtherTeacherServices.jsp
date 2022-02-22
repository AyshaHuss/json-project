<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 2/12/2022
  Time: 3:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Teacher Services</title>
</head>
<body>
<form action="OtherTeacherServices" method="post">
  <label>Choose action:</label>
  <select name="action" >
    <option value="putMark">Put Mark</option>
    <option value="allCourses">View All Courses</option>
    <option value="myCourses">View My Courses</option>
    <option value="myStudents">View My Students</option>

  </select>
  <input type="submit" value="select">
</form>
</body>
</html>
