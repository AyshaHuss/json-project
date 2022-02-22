<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 2/10/2022
  Time: 11:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>My Courses</title>
</head>
<body>
<h1>Your courses are : ${myCoursesNum}</h1>


<br/>
<c:set var="idarr" value="${courses}"/>
<c:set var="arr"  value="${myCourses}"/>
<c:forEach varStatus="loop" begin="0" end="${myCoursesNum}" step="1"  >
    <c:out value="${arr[loop.count-1]}"/>

    <br/>
</c:forEach>

</body>
</html>
