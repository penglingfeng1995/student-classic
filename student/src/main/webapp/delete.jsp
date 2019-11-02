<%@ page import="com.plf.student.service.StudentService" %>
<%@ page import="com.plf.student.service.impl.StudentServiceImpl" %>
<%@ page import="com.plf.student.model.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>删除学生</title>
</head>
<body>
<%
    StudentService studentService = new StudentServiceImpl();
    Long id = Long.parseLong(request.getParameter("id"));
    Student student = studentService.selectStudentById(id);
    pageContext.setAttribute("student", student);

    String baseUrl = request.getContextPath();
%>
<h2>确认删除,学号:${student.id} ,姓名:${student.studentName} 吗?</h2>
<h4>
    <a href="<%=baseUrl%>/student/delete?id=${student.id}">是</a>
    <span>,</span>
    <a href="index.jsp">否</a></h4>
</body>
</html>
