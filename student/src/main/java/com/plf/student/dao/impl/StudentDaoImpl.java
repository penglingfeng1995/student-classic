package com.plf.student.dao.impl;

import com.plf.student.dao.StudentDao;
import com.plf.student.model.Student;
import com.plf.student.util.JdbcUtils;

import java.util.List;

public class StudentDaoImpl implements StudentDao {

    @Override
    public List<Student> selectStudentList() {
        String sql = "select * from t_student;";
        return JdbcUtils.queryObject(sql, Student.class);
    }
}
