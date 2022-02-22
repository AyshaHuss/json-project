<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<h1>User Registration</h1>
<form action="Registration" method="post">
    Enter first name  :
    <input type="text" name="fName">
    <br/>
    Enter your last name :
    <input type="text" name="lName">
    <br/>
    Enter your email :
    <input type="text" name="email">
    <br/>
    Enter your type :
    <select name="userType">
        <option value="student">Student</option>
        <option value="teacher">Teacher</option>
        <option value="admin">Admin</option>
    </select>
    <br/>
    <br/>
    <input type="submit" value="Add User">


</form>
</body>
</html>