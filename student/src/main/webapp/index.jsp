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
        StudentService studentService=new StudentServiceImpl();
        List<Student> students = studentService.selectStudentList();
        pageContext.setAttribute("students",students);
    %>
    <h1> hello student </h1>
    <table border="1">
        <thead>
            <tr>
                <td>学号</td>
                <td>姓名</td>
                <td>年龄</td>
                <td>邮箱</td>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="stu" items="${students}">
                <tr>
                    <td>${stu.id}</td>
                    <td>${stu.studentName}</td>
                    <td>${stu.studentAge}</td>
                    <td>${stu.studentEmail}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>


</body>
</html>
