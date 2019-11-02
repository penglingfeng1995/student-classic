package com.plf.student.service.impl;

import com.plf.student.dao.StudentDao;
import com.plf.student.dao.impl.StudentDaoImpl;
import com.plf.student.model.Student;
import com.plf.student.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao = new StudentDaoImpl();

    @Override
    public List<Student> selectStudentList() {
        return studentDao.selectStudentList();
    }

    @Override
    public Student selectStudentById(Long id) {
        return studentDao.selectStudentById(id);
    }

    @Override
    public int addStudent(Student student) {
        return studentDao.addStudent(student);
    }

    @Override
    public int deleteStudentById(Long id) {
        return studentDao.deleteStudentById(id);
    }

    @Override
    public int updateStudent(Student student) {
        return studentDao.updateStudent(student);
    }
}
