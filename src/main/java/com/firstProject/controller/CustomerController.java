package com.firstProject.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.firstProject.model.Customer;
import com.firstProject.model.Item;
import com.firstProject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http:localhost:3000")

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/create")
    public void createCustomer(@RequestBody Customer customer) throws Exception {
        customerService.createCustomer(customer);
    }

    @PutMapping("/update")
    public void updateCustomer(@RequestBody Customer customer) {
        customerService.updateCustomer(customer);
    }

    @DeleteMapping("/delete/{customerId}")
    public void deleteCustomerById(@PathVariable Long customerId) {
        customerService.deleteCustomerById(customerId);
    }

    @GetMapping("get/{customerId}")
    public Customer getCustomerById(@PathVariable Long customerId) throws JsonProcessingException {
        return customerService.getCustomerById(customerId);
    }

    @GetMapping("/getAllCustomer")
    public List<Customer> getAllCustomer() throws JsonProcessingException {
        return customerService.getAllCustomer();
    }

    @GetMapping("/getUserName/{username}")
    public Customer findUserByUsername(@PathVariable String username) throws JsonProcessingException {
        return customerService.findUserByUsername(username);
    }
}
