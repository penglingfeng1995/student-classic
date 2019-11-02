<%@ page import="com.plf.student.service.StudentService" %>
<%@ page import="com.plf.student.service.impl.StudentServiceImpl" %>
<%@ page import="com.plf.student.model.Student" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>学生系统</title>
</head>
<body>
<%
    StudentService studentService = new StudentServiceImpl();
    List<Student> students = studentService.selectStudentList();
    pageContext.setAttribute("students", students);

    String baseUrl = request.getContextPath();
    String msg = request.getParameter("msg");
    pageContext.setAttribute("msg", msg);
%>
<h1>学生系统</h1>
<h3>${msg}</h3>
<a href="add.jsp">添加</a>
<table border="1">
    <thead>
    <tr>
        <td>学号</td>
        <td>姓名</td>
        <td>年龄</td>
        <td>邮箱</td>
        <td>操作</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="stu" items="${students}">
        <tr>
            <td>${stu.id}</td>
            <td>${stu.studentName}</td>
            <td>${stu.studentAge}</td>
            <td>${stu.studentEmail}</td>
            <td>
                <a href="update.jsp?id=${stu.id}">修改</a>
                <span>or</span>
                <a href="delete.jsp?id=${stu.id}">删除</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
