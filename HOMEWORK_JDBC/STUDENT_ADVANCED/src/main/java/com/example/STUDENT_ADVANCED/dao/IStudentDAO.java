package com.example.STUDENT_ADVANCED.dao;

import com.example.STUDENT_ADVANCED.model.Specialized;
import com.example.STUDENT_ADVANCED.model.Student;

import java.sql.SQLException;
import java.util.List;

public interface IStudentDAO {
    public void insertStudent(Student student) throws SQLException;
    public Student selectStudent(int id);
    public List<Student> selectAllStudent();
    public boolean deleteStudent(int id) throws SQLException;
    public boolean updateStudent(Student student) throws SQLException;
//    public List<Student> sortStudent();
    public List<Student> searchLikeStudent(String keyWord);
    public List<Specialized> list();
}
