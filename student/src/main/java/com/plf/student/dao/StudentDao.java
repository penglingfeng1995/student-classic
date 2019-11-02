package com.plf.student.dao;

import com.plf.student.model.Student;

import java.util.List;

public interface StudentDao {
    List<Student> selectStudentList();

    Student selectStudentById(Long id);

    int addStudent(Student student);

    int deleteStudentById(Long id);

    int updateStudent(Student student);
}
