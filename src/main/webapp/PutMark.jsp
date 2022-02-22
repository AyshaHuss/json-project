<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 2/10/2022
  Time: 12:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Put Mark</title>
</head>
<body>


<form action="ViewStds" method="post">
    <br/>
     Your courses are :
    <select name="name">
        <c:forEach items="${myCourses}" var="course">
            <option value="${course}">${course}</option>
        </c:forEach>
    </select>
    <input type="submit" value="show students">
</form>
<br/>
<br/>


<br/>
<h1>${msg} </h1>
<br/>

<form method="post" action="PutMark">
choose student :


    <select name="stdName">
        <c:forEach items="${stdNames}" var="course">
            <option value="${course}">${course}</option>
        </c:forEach>
    </select>
    <br/>
    <br/>
    Enter mark :
    <input type="text" name="mark">
    <input type="submit" value="update mark">

</form>
<br/>

</body>
</html>
