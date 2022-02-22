<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 2/11/2022
  Time: 2:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Remove Course</title>
</head>
<body>

<form action="RemoveCourseServlet" method="post">
    <label>Choose course to remove:</label>

    <select name="course">
        <c:forEach items="${myCourses}" var="course">
            <option value="${course}">${course}</option>
        </c:forEach>
    </select>
    <input type="submit" value="remove course">
</form>
<br/><br/>
${toRemove}
</body>
</html>
