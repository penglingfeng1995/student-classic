<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加学生</title>
</head>
<%
    String baseUrl = request.getContextPath();
%>
<body>
<form action="<%=baseUrl%>/student/add" method="post">
    <input name="id" />学号<br>
    <input name="studentName"/>姓名<br>
    <input name="studentAge"/>年龄<br>
    <input name="studentEmail"/>邮箱<br>
    <button type="submit">添加</button>
</form>
</body>
</html>
