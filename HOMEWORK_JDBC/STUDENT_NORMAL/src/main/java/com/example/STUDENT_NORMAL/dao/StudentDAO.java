package com.example.STUDENT_NORMAL.dao;

import com.example.STUDENT_NORMAL.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO implements IStudentDAO{
    final String url = "jdbc:mysql://localhost:3306/student_normal";
    final String user = "root";
    final String password = "1234";



    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }


    final String INSERT_STUDENT = "insert into student(name,age,specialized) values (?,?,?)";
    @Override
    public void insertStudent(Student student) throws SQLException {
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT);) {
            preparedStatement.setString(1,student.getName());
            preparedStatement.setInt(2,student.getAge());
            preparedStatement.setString(3,student.getSpecialized());
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
            printSQLException(e);
        }
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    final String LIST_STUDENT = "select * from student";
    @Override
    public List<Student> selectAllStudent() {
        List<Student> list = new ArrayList<>();
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(LIST_STUDENT)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String spe = resultSet.getString("specialized");
                Student student = new Student(id,name,age,spe);
                list.add(student);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    final String DELETE_PRODUCT = "delete from student where id = ?";
    @Override
    public boolean deleteStudent(int id) throws SQLException {
        boolean rowDelete;
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT);) {
            preparedStatement.setInt(1,id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        }
        return rowDelete;
    }

    final String UPDATE_STUDENT = "update student set name=?,age=?,specialized=? where id = ?";
    @Override
    public boolean updateStudent(Student student) throws SQLException {
        boolean rowUpdate;
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STUDENT);){
            preparedStatement.setString(1,student.getName());
            preparedStatement.setInt(2,student.getAge());
            preparedStatement.setString(3,student.getSpecialized());
            preparedStatement.setInt(4,student.getId());
            rowUpdate = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdate;
    }

    final String SELECT_STUDENT = "select * from student where id = ?";
    @Override
    public Student selectStudent(int id) {
        Student student = null;
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENT)) {
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String spe = resultSet.getString("specialized");
                student = new Student(id,name,age,spe);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return student;
    }
}
