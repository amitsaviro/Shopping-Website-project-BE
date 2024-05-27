package com.firstProject.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.firstProject.model.Customer;
import com.firstProject.model.Item;
import com.firstProject.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Long createCustomer(Customer customer) throws Exception {
        Customer existingCustomUser = customerRepository.findUserByUsername(customer.getUserName());
        if(existingCustomUser != null){
            throw new Exception("Username " + customer.getUserName() + " is already taken");
        }
            return customerRepository.createCustomer(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
            customerRepository.updateCustomer(customer);
    }

    @Override
    public void deleteCustomerById(Long id) {
        customerRepository.deleteCustomerById(id);
    }

    @Override
    public Customer getCustomerById(Long id) throws JsonProcessingException {
        return customerRepository.getCustomerById(id);
    }
    @Override
    public List<Customer> getAllCustomer() throws JsonProcessingException{
        return customerRepository.getAllCustomer();
    }
    @Override
    public Customer findUserByUsername(String username){
        return customerRepository.findUserByUsername(username);
    }

}
