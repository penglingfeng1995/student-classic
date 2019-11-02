package com.plf.student.dao.impl;

import com.plf.student.dao.StudentDao;
import com.plf.student.model.Student;
import com.plf.student.util.JdbcUtils;

import java.util.List;

public class StudentDaoImpl implements StudentDao {

    @Override
    public List<Student> selectStudentList() {
        String sql = "select * from t_student;";
        return JdbcUtils.queryObjectList(sql, Student.class);
    }

    @Override
    public Student selectStudentById(Long id) {
        String sql = "select * from t_student where id = ?;";
        return JdbcUtils.queryObject(sql, Student.class, id);
    }

    @Override
    public int addStudent(Student student) {
        String sql = "insert into t_student(id,studentName,studentAge,studentEmail) values(?,?,?,?);";
        return JdbcUtils.execute(sql, student.getId(), student.getStudentName(), student.getStudentAge(), student.getStudentEmail());
    }

    @Override
    public int deleteStudentById(Long id) {
        String sql = "delete from t_student where id=?;";
        return JdbcUtils.execute(sql, id);
    }

    @Override
    public int updateStudent(Student student) {
        String sql = "update t_student\n" +
                "set studentName=?,\n" +
                "    studentAge=?,\n" +
                "    studentEmail=?\n" +
                "where id = ?;";
        return JdbcUtils.execute(sql,
                student.getStudentName(),
                student.getStudentAge(),
                student.getStudentEmail(),
                student.getId());
    }
}
