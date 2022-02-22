<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 2/6/2022
  Time: 12:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Add New Course</title>
</head>
<body>
<h1>Courses in System are :</h1>

<c:set var="idarr" value="${courses}"/>
<c:set var="arr"  value="${allCourses}"/>
<c:forEach varStatus="loop" begin="0" end="${num}" step="1"  >
    <c:out value="${arr[loop.count-1]}"/>
    <br/>
</c:forEach>

<h1>Add new course</h1>

<form method="post" action="AddCourse">
    Course name :
    <input type="text" name="courseName">
    <br/>
    Teacher name :
            <select name="name">
                <c:forEach items="${teachers}" var="teacher">
                    <option value="${teacher}">${teacher}</option>
                </c:forEach>
            </select>    <br/>
    Maximum student number
    <input type="text" name="maxStd">
    <br/>
    <input type="submit" value="add course">
</form>
${msg}
</body>
</html>
