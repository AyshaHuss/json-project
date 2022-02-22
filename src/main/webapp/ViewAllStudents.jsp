<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 2/12/2022
  Time: 3:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>View All Students</title>
</head>
<body>
<h1>Students are : </h1>
<br/>
<c:set var="arr"  value="${allStds}"/>
<c:forEach varStatus="loop" begin="0" end="${num}" step="1"  >
    <c:out value="${arr[loop.count-1]}"/>

    <br/>
</c:forEach>
</body>
</html>
