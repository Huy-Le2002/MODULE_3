package com.example.End_Module3.dao;

import com.example.End_Module3.model.Category;
import com.example.End_Module3.model.Product;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO{
    final String url = "jdbc:mysql://localhost:3306/module3";
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

    final String INSERT_PRODUCT_SQL = "insert into product(name,price,quantity,color,category) values (?,?,?,?,?);";
    @Override
    public void insertProduct(Product product) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT_SQL);) {
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setFloat(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setInt(5, product.getCateGory());
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

    final String SELECT_PRODUCT_BY_ID = "select name,price,quantity,color,category from product where id = ?";
    @Override
    public Product selectProduct(int id) {
        Product product = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID);) {
            preparedStatement.setInt(1,id);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                String name = result.getString("name");
                float price = result.getFloat("price");
                int quantity = result.getInt("quantity");
                String color = result.getString("color");
                int category = result.getInt("category");
                product = new Product(name,price,quantity,color,category);
                product.setId(id);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return product;
    }

    final String SELECT_ALL_PRODUCT = "SELECT p.id,p.name,p.price,p.quantity,p.color,c.name as category \n" +
            "from product p left join category c on p.category=c.id";
    @Override
    public List<Product> selectAllProduct() {
        List<Product> list = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT);) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                float price = resultSet.getFloat("price");
                int quantity = resultSet.getInt("quantity");
                String color = resultSet.getString("color");
                String category = resultSet.getString("category");
                Product product = new Product(id,name,price,quantity,color,category);
                list.add(product);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }

    final String SELECT_ALL_CATEGORY = "select * from category";
    @Override
    public List<Category> selectAllCategory() {
        List<Category> list = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CATEGORY);) {
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Category category = new Category(id,name);
                list.add(category);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }


    final String DELETE_PRODUCT_SQL="delete from product where id=?";
    @Override
    public boolean deleteProduct(int id) throws SQLException {
        boolean rowDelete;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT_SQL);) {
            preparedStatement.setInt(1,id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        }
        return rowDelete;
    }

    final String UPDATE_PRODUCT_SQL= "update product set name=?,price=?,quantity=?,color=?,des=?,category=? where id=?";
    @Override
    public boolean updateProduct(Product product) throws SQLException {
        boolean rowUpdate;
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT_SQL);) {
            preparedStatement.setString(1,product.getProductName());
            preparedStatement.setFloat(2,product.getPrice());
            preparedStatement.setInt(3,product.getQuantity());
            preparedStatement.setString(4,product.getColor());
            preparedStatement.setString(5,product.getDes());
            preparedStatement.setInt(6,product.getCateGory());
            preparedStatement.setInt(7,product.getId());
            rowUpdate = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdate;
    }

    final String SEARCH = "SELECT p.id,p.name,p.price,p.quantity,p.color,c.name as category from product p left join category c on p.category=c.id\n" +
            "where p.name like ?;";
    @Override
    public List<Product> findData(String keyWord) {
        List<Product> list = new ArrayList<>();
        String key = "%" + keyWord + "%";
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH);) {
            preparedStatement.setString(1,key);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                float price = resultSet.getFloat("price");
                int quantity = resultSet.getInt("quantity");
                String color = resultSet.getString("color");
                String category = resultSet.getString("category");
                Product product = new Product(id,name,price,quantity,color,category);
                list.add(product);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }
}
