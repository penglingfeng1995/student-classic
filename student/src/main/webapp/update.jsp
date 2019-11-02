<%@ page import="com.plf.student.model.Student" %>
<%@ page import="com.plf.student.service.StudentService" %>
<%@ page import="com.plf.student.service.impl.StudentServiceImpl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改学生</title>
</head>
<%
    StudentService studentService = new StudentServiceImpl();
    Long id = Long.parseLong(request.getParameter("id"));
    Student student = studentService.selectStudentById(id);
    pageContext.setAttribute("student", student);

    String baseUrl = request.getContextPath();
%>
<body>
    <form action="<%=baseUrl%>/student/update" method="post">
        <input name="id" value="${student.id}" readonly/>学号<br>
        <input name="studentName" value="${student.studentName}"/>姓名<br>
        <input name="studentAge" value="${student.studentAge}"/>年龄<br>
        <input name="studentEmail" value="${student.studentEmail}"/>邮箱<br>
        <button type="submit">修改</button>
    </form>
</body>
</html>
