package com.firstProject.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.firstProject.model.Customer;
import com.firstProject.model.Item;

import java.util.List;

public interface CustomerRepository {
    Long createCustomer(Customer customer)throws Exception;
    void updateCustomer(Customer customer);
    void deleteCustomerById(Long id);
    Customer getCustomerById(Long id) throws JsonProcessingException;
    List<Customer> getAllCustomer() throws JsonProcessingException;
    Customer findUserByUsername(String username);
    }
