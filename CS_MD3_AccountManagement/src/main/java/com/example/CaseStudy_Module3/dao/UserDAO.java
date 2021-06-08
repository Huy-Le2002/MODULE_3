package com.example.CaseStudy_Module3.dao;

import com.example.CaseStudy_Module3.model.Country;
import com.example.CaseStudy_Module3.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO {
    final String url = "jdbc:mysql://localhost:3306/demo?useSSL=false&allowPublicKeyRetrieval=true";
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

    final String INSERT_USERS_SQL = "INSERT INTO users" + "(name,email,id_country) VALUES" + "(?,?,?);";
    @Override
    public void insertUser(User user) throws SQLException {
        //hiển thị dưới màn hình console ra dòng lệnh insert
        System.out.println(INSERT_USERS_SQL);
        try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setInt(3, user.getId_country());
            //in ra toàn bộ dl khi truyền vào
            System.out.println("---------------");
            System.out.println(preparedStatement);
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

    final String FIND_DATA = "select users.id,users.name,users.email, country.name as country_name " +
            "from users inner join country on users.id_country = country.id " +
            "where users.name like ? or users.email like ? or country.name like ? ;";
    @Override
    public List<User> searchLikeUser(String keyWord) {
        List<User> list = new ArrayList<>();
        String key = "%" + keyWord + "%";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_DATA);) {
            preparedStatement.setString(1,key);
            preparedStatement.setString(2,key);
            preparedStatement.setString(3,key);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String countryName = rs.getString("country_name");
                User user = new User(id, name, email, countryName);
                list.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }


    final String SELECT_USER_BY_ID = "select id,name,email,id_country from users where id =?";
    @Override
    public User selectUser(int id) {
        User user = null; //vì nó chỉ trả về 1 th nên nó kiểu User, còn ko thì sẽ hiện kiểu List
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // thực thi câu lệnh
            ResultSet rs = preparedStatement.executeQuery();

            // truy xuất tới dòng và lấy từng giá trị
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                int id_country = rs.getInt("id_country");
                user = new User(name, email, id_country);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }

    final String SELECT_ALL_USER = "SELECT users.id,users.name,users.email, country.name as country_name FROM users LEFT JOIN country ON users.id_country = country.id";
//final String SELECT_ALL_USER = "select * from users";
    @Override
    public List<User> selectAllUser() {
        // tạo danh sách
        List<User> userList = new ArrayList<>();

        try {
            // tạo kế nối đến db
            Connection connection = getConnection();
            // gói lại câu lệnh sql
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USER);
            System.out.println(preparedStatement);

            // thực thi câu lệnh sql
            ResultSet rs = preparedStatement.executeQuery();

            // trỏ tới từng dòng của bảng kết quả
            while (rs.next()) {
                // tại mỗi hàng thực hiện:

                // lấy dữ liệu cần thiết(muốn lấy)
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country_name = rs.getString("country_name");

                // tạo đối tượng User:
                User user = new User(id,name,email,country_name);

                // bỏ user vào list
                userList.add(user);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userList;
    }

    final String ODER_BY_USERS_SQL = "select users.id,users.name,users.email, country.name as country_name \n" +
            "from users inner join country on users.id_country = country.id \n" +
            "order by name;";

    @Override
    public List<User> sortUser() {
        List<User> userList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ODER_BY_USERS_SQL);){
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country_name");
                userList.add(new User(id,name,email,country));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userList;
    }



    final String DELETE_USERS_SQL = "delete from users where id =?;";
    @Override
    public boolean deleteUser(int id) throws SQLException {
        boolean rowDelete;
        try(Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERS_SQL);) {
            preparedStatement.setInt(1,id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        }
        return rowDelete;
    }

    final String UPDATE_USERS_SQL = "update users set name=?,email=?,id_country=? where id=?;";
    @Override
    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdate;
        try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL);) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setInt(3,user.getId_country());
            preparedStatement.setInt(4,user.getId());
            rowUpdate = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdate;
    }

    final String GET_COUNTRY_SQL = "select * from country";
    @Override
    public List<Country> list() {
        List<Country> list = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_COUNTRY_SQL);) {
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Country country = new Country(id,name);
                list.add(country);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }



}
