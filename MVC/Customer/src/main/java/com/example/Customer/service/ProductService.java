package com.example.Customer.service;

import com.example.Customer.model.Customer;
import com.example.Customer.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> list();
    void save(Product product);
    void update(int id, Product product);
    void delete(int id);
    Product findById(int id);
}
