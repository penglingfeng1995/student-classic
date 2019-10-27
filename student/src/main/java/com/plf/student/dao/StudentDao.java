package com.plf.student.dao;

import com.plf.student.model.Student;

import java.util.List;

public interface StudentDao {
    List<Student> selectStudentList();
}
