<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 2/11/2022
  Time: 11:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Courses</title>
</head>
<body>
<form action="CoursesServ" method="post">
    <label>Choose action:</label>
    <select name="action" >
            <option value="myCourses">View My Courses</option>
            <option value="allCourses">View All Courses</option>
            <option value="newCourse">Add New Course</option>
            <option value="remove">Remove Course</option>
    </select>
    <input type="submit" value="submit">
</form>
</body>
</html>
