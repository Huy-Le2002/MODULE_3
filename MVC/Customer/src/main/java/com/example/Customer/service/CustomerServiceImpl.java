package com.example.Customer.service;

import com.example.Customer.model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImpl implements CustomerService {
    public static Map<Integer,Customer> customerMap;
    static {
        customerMap = new HashMap<>();
        customerMap.put(1,new Customer(1,"Huy","huy@gmail.com","Huế"));
        customerMap.put(2,new Customer(2,"Dương","duong@gmail.com","QB"));
        customerMap.put(3,new Customer(3,"Phong","phong@gmail.com","QB"));
        customerMap.put(4,new Customer(4,"Khánh","khanh@gmail.com","Huế"));
        customerMap.put(5,new Customer(5,"Quang","quang@gmail.com","Huế"));
    }
    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customerMap.values());
    }

    @Override
    public void update(int id, Customer customer) {
        customerMap.put(id,customer);
    }

    @Override
    public void remove(int id) {
        customerMap.remove(id);
    }

    @Override
    public void save(Customer customer) {
        customerMap.put(customer.getId(),customer);
    }

    @Override
    public Customer findById(int id) {
        return customerMap.get(id);
    }
}
