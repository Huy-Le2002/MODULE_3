package com.example.End_Module3_L2.dao;

import com.example.End_Module3_L2.model.Staff;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StaffDAO implements IStaffDAO {
    final String url = "jdbc:mysql://localhost:3306/module3_l2";
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


    final String INSERT = "INSERT INTO staff(groupstaff,name,dob,phonenumber,cmnd,email,address) VALUES(?,?,?,?,?,?,?);";
    @Override
    public void insertStaff(Staff staff) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {
            preparedStatement.setString(1, staff.getGroupstaff());
            preparedStatement.setString(2, staff.getName());
            preparedStatement.setString(3, staff.getDob());
            preparedStatement.setString(4, staff.getPhonenumber());
            preparedStatement.setString(5, staff.getCmnd());
            preparedStatement.setString(6, staff.getEmail());
            preparedStatement.setString(7, staff.getAddress());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    final String SELECT = "SELECT * FROM staff WHERE id =?";
    @Override
    public Staff selectStaff(int id) {
        Staff staff = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String groupstaff = rs.getString("groupstaff");
                String name = rs.getString("name");
                String dob = rs.getString("dob");
                String phonenumber = rs.getString("phonenumber");
                String cmnd = rs.getString("cmnd");
                String email = rs.getString("email");
                String address = rs.getString("address");

                staff = new Staff(id,groupstaff,name,dob,phonenumber,cmnd, email, address);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return staff;
    }

    final String SELECT_ALL = "SELECT * FROM staff";
    @Override
    public List<Staff> selectAllStaff() {
        List<Staff> staffList = new ArrayList<>();

        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String groupstaff = rs.getString("groupstaff");
                String name = rs.getString("name");
                String dob = rs.getString("dob");
                String phonenumber = rs.getString("phonenumber");
                String cmnd = rs.getString("cmnd");
                String email = rs.getString("email");
                String address = rs.getString("address");
                Staff staff = new Staff(id,groupstaff,name,dob,phonenumber,cmnd,email,address);

                staffList.add(staff);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return staffList;
    }

    final String SELECT_GROUP = "SELECT groupstaff FROM staff";
    @Override
    public List<String> selectgroupstaff() {
        List<String> staffList = new ArrayList<>();

        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_GROUP);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                staffList.add(rs.getString("groupstaff"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return staffList;
    }


    final String DELETE = "DELETE FROM staff WHERE id =?;";
    @Override
    public boolean deleteStaff(int id) throws SQLException {
        boolean rowDelete;
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);) {
            preparedStatement.setInt(1,id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        }
        return rowDelete;
    }

    final String UPDATE = "UPDATE staff SET groupstaff=?,name=?,dob=?,phonenumber=?,cmnd=?,email=?,address=? WHERE id=?;";
    @Override
    public boolean updateStaff(Staff staff) throws SQLException {
        boolean rowUpdate;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);) {
            preparedStatement.setString(1, staff.getGroupstaff());
            preparedStatement.setString(2, staff.getName());
            preparedStatement.setString(3, staff.getDob());
            preparedStatement.setString(4, staff.getPhonenumber());
            preparedStatement.setString(5, staff.getCmnd());
            preparedStatement.setString(6, staff.getEmail());
            preparedStatement.setString(7, staff.getAddress());
            preparedStatement.setInt(8,staff.getId());
            rowUpdate = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdate;
    }

    final String FIND_DATA = "SELECT * FROM staff WHERE id LIKE ? or name LIKE ?";
    @Override
    public List<Staff> searchLikeStaff(String keyWord) {
        List<Staff> list = new ArrayList<>();
        String key = "%" + keyWord + "%";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_DATA);) {
            preparedStatement.setString(1, key);
            preparedStatement.setString(2,key);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String groupstaff = rs.getString("groupstaff");
                String name = rs.getString("name");
                String dob = rs.getString("dob");
                String phonenumber = rs.getString("phonenumber");
                String cmnd = rs.getString("cmnd");
                String email = rs.getString("email");
                String address = rs.getString("address");
                Staff staff = new Staff(id,groupstaff, name,dob,phonenumber,cmnd,email, address);
                list.add(staff);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}
