package com.plf.student.servlet;

import com.plf.student.model.Student;
import com.plf.student.service.StudentService;
import com.plf.student.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StudentServlet extends HttpServlet {

    private StudentService studentService = new StudentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String requestURI = req.getRequestURI();
        switch (requestURI) {
            case "/student/student/add":
                add(req, resp);
                break;
            case "/student/student/delete":
                delete(req, resp);
                break;
            case "/student/student/update":
                update(req, resp);
                break;
        }
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Student student = buildStudent(req);
        int i = studentService.updateStudent(student);
        if (i == 1) {
            resp.sendRedirect("/student/index.jsp?msg=updateSuccess");
        } else {
            resp.sendRedirect("/student/index.jsp?msg=updateFailed");
        }
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        long id = Long.parseLong(req.getParameter("id"));
        int i = studentService.deleteStudentById(id);
        if (i == 1) {
            resp.sendRedirect("/student/index.jsp?msg=deleteSuccess");
        } else {
            resp.sendRedirect("/student/index.jsp?msg=deleteFailed");
        }
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Student student = buildStudent(req);
        int i = studentService.addStudent(student);
        if (i == 1) {
            resp.sendRedirect("/student/index.jsp?msg=addSuccess");
        } else {
            resp.sendRedirect("/student/index.jsp?msg=addFailed");
        }
    }

    private Student buildStudent(HttpServletRequest req) {
        long id = Long.parseLong(req.getParameter("id"));
        String studentName = req.getParameter("studentName");
        int studentAge = Integer.parseInt(req.getParameter("studentAge"));
        String studentEmail = req.getParameter("studentEmail");
        Student student = new Student();
        student.setId(id);
        student.setStudentName(studentName);
        student.setStudentAge(studentAge);
        student.setStudentEmail(studentEmail);
        return student;
    }

}
