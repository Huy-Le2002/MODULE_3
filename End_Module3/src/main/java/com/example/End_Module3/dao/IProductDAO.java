package com.example.End_Module3.dao;

import com.example.End_Module3.model.Category;
import com.example.End_Module3.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductDAO {
    public void insertProduct(Product product) throws SQLException;
    public Product selectProduct(int id);
    public List<Product> selectAllProduct();
    public List<Category> selectAllCategory();
    public boolean deleteProduct(int id) throws SQLException;
    public boolean updateProduct(Product product) throws SQLException;
    public List<Product> findData(String keyWord);
}
