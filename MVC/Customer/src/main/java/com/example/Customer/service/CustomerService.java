package com.example.Customer.service;

import com.example.Customer.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    void update(int id,Customer customer);
    void remove(int id);
    void save(Customer customer);
    Customer findById(int id);
}
