package com.plf.student.test;

import com.plf.student.dao.StudentDao;
import com.plf.student.dao.impl.StudentDaoImpl;
import org.junit.Test;

import java.sql.SQLException;

public class JDBCTest {

    @Test
    public void test1() {
        System.out.println("hello world");
    }

    @Test
    public void test2() throws SQLException {
        StudentDao studentDao = new StudentDaoImpl();
        studentDao.selectStudentList().forEach(System.out::println);
    }
}
