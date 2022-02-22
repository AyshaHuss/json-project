<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 2/12/2022
  Time: 6:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>


<form action="ViewMyStds" method="post">
    <br/>
    Your courses are :
    <select name="name">
        <c:forEach items="${myCourses}" var="course">
            <option value="${course}">${course}</option>
        </c:forEach>
    </select>
    <br/>
    <label>Choose student status:</label>
    <select name="action" >
        <option value="allStd">All students</option>
        <option value="passStd">Passed students</option>
        <option value="failStd">Failed students</option>
    </select>
    <br/>
    <input type="submit" value="View">
</form>
<c:set var="arr"  value="${stdNames}"/>
<c:forEach varStatus="loop" begin="0" end="${num}" step="1"  >
    <c:out value="${arr[loop.count-1]}"/>
</c:forEach>

<c:forEach items="${allStd}" var="entry">
    Name : <c:out value="${entry.key}"/>,    Mark: <c:out value="${entry.value}"/> <br />
</c:forEach>

<c:forEach items="${passStd}" var="entry">
    Name : <c:out value="${entry.key}"/>,    Mark: <c:out value="${entry.value}"/> <br />
</c:forEach>


<c:forEach items="${failStd}" var="entry">
    Name : <c:out value="${entry.key}"/>,    Mark: <c:out value="${entry.value}"/> <br />
</c:forEach>



</body>
</html>
