package com.example.STUDENT_ADVANCED.dao;

import com.example.STUDENT_ADVANCED.model.Specialized;
import com.example.STUDENT_ADVANCED.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO implements IStudentDAO {
    final String url = "jdbc:mysql://localhost:3306/student_advanced";
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


    final String INSERT = "INSERT INTO student(name,age,specialized_id) VALUES(?,?,?);";

    @Override
    public void insertStudent(Student student) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT);) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getAge());
            preparedStatement.setInt(3, student.getSpecialized_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
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

    final String SELECT_STUDENT = "select * from student where id = ?";

    @Override
    public Student selectStudent(int id) {
        Student student = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENT);) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                int specialized_id = rs.getInt("specialized_id");
                student = new Student(id, name, age, specialized_id);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return student;
    }

    final String SELECT_ALL = "SELECT s.id,s.name,s.age, sp.name as specialized_name FROM student s LEFT JOIN specialized sp ON s.specialized_id = sp.id";

    @Override
    public List<Student> selectAllStudent() {
        List<Student> list = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String specialized_name = rs.getString("specialized_name");

                // tạo đối tượng User:
                Student student = new Student(id, name, age, specialized_name);

                // bỏ user vào list
                list.add(student);
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    final String DELETE = "delete from student where id =?;";
    @Override
    public boolean deleteStudent(int id) throws SQLException {
        boolean rowDelete;
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);) {
            preparedStatement.setInt(1,id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        }
        return rowDelete;
    }

    final String UPDATE_USERS_SQL = "update student set name=?,age=?,specialized_id=? where id=?;";
    @Override
    public boolean updateStudent(Student student) throws SQLException {
        boolean rowUpdate;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL);) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getAge());
            preparedStatement.setInt(3,student.getSpecialized_id());
            preparedStatement.setInt(4,student.getId());
            rowUpdate = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdate;
    }


//    @Override
//    public List<Student> sortStudent() {
//        List<Student> userList = new ArrayList<>();
//
//        try (Connection connection = getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(ODER_BY_USERS_SQL);){
//            System.out.println(preparedStatement);
//            ResultSet rs = preparedStatement.executeQuery();
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                String name = rs.getString("name");
//                String email = rs.getString("email");
//                String country = rs.getString("country_name");
//                userList.add(new User(id,name,email,country));
//            }
//
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return userList;
//    }

    final String FIND = "SELECT s.id,s.name,s.age, sp.name as specialized_name FROM student s LEFT JOIN specialized sp ON s.specialized_id = sp.id\n" +
            "where s.name like ? or sp.name like ?";
    @Override
    public List<Student> searchLikeStudent(String keyWord) {
        List<Student> list = new ArrayList<>();
        String key = "%" + keyWord + "%";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND);) {
            preparedStatement.setString(1,key);
            preparedStatement.setString(2,key);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String specialized_name = rs.getString("specialized_name");
                Student student = new Student(id, name, age, specialized_name);
                list.add(student);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    final String SELECT = "select * from specialized";
    @Override
    public List<Specialized> list() {
        List<Specialized> list = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT);) {
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Specialized specialized = new Specialized(id,name);
                list.add(specialized);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }
}

