package com.plf.student.service;

import com.plf.student.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> selectStudentList();

    Student selectStudentById(Long id);

    int addStudent(Student student);

    int deleteStudentById(Long id);

    int updateStudent(Student student);
}
