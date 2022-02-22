<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 2/8/2022
  Time: 11:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Courses</title>
</head>
<body>

<h1>All Courses are : </h1>
<br/>

<c:set var="idarr" value="${courses}"/>
<c:set var="arr"  value="${allCourses}"/>
<c:forEach varStatus="loop" begin="0" end="${num}" step="1"  >
    <c:out value="${arr[loop.count-1]}"/>

    <br/>
</c:forEach>


<br/>
</body>
</html>
