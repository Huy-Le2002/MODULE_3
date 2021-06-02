package com.example.Customer.service;

import com.example.Customer.model.Customer;
import com.example.Customer.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService{
    public static Map<Integer,Product> productMap;
    static {
        productMap = new HashMap<>();
        productMap.put(1,new Product(1,"Iphone X",10000000,"Phone","USA"));
        productMap.put(2,new Product(2,"MacPro",40000000,"Computer","USA"));
        productMap.put(3,new Product(3,"Samsung Note 10",15000000,"Phone","Korean"));
    }
    @Override
    public List<Product> list() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public void update(int id, Product product) {
        productMap.put(id,product);
    }

    @Override
    public void delete(int id) {
        productMap.remove(id);
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

}
