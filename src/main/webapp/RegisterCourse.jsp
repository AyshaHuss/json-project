<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 2/9/2022
  Time: 1:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Register Course</title>
</head>
<body>
<h1>courses are </h1>

<c:set var="idarr" value="${courses}"/>
<c:set var="arr"  value="${allCourses}"/>
<c:forEach varStatus="loop" begin="0" end="${num}" step="1"  >
    <c:out value="${arr[loop.count-1]}"/>

    <br/>
</c:forEach>
<br/>
<form action="RegisterCourse" method="post">

<select name="course">
    <c:forEach items="${coursesNames}" var="course">
        <option value="${course}">${course}</option>
    </c:forEach>
</select>
    <input type="submit" value="add course">
</form>
${msg}
</body>
</html>
