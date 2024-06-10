package com.firstProject.security;

import com.firstProject.model.Customer;
import com.firstProject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerDetailsService implements UserDetailsService {

    @Autowired
    private CustomerService customerService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = customerService.findUserByUsername(username);

        if (customer == null) {
            throw new UsernameNotFoundException("The provided username can't be found");
        }

        return User.withDefaultPasswordEncoder()
                .username(customer.getUserName())
                .password(customer.getPassword())
                .roles() // Add roles if necessary
                .build();
    }

    public Customer getCustomerByUsername(String username) {
        return customerService.findUserByUsername(username);
    }
}
