<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 2/12/2022
  Time: 1:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Services</title>
</head>
<body>
<form action="OtherAdminServices" method="post">
    <label>Choose action:</label>
    <select name="action" >
        <option value="addUser">Add new user</option>
        <option value="allCourses">View all courses</option>
        <option value="allStudents">View all students</option>
        <option value="allTeachers">View all teachers</option>
        <option value="newCourse">Add new course</option>

    </select>
    <input type="submit" value="select">
</form>
</body>
</html>
