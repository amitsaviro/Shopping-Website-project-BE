package com.firstProject.security.model;

import java.io.Serializable;

import com.firstProject.model.Customer;

public class AuthenticationResponse implements Serializable {

    private final String jwt;
    private final Customer customer;

    public AuthenticationResponse(String jwt, Customer customer) {
        this.jwt = jwt;
        this.customer = customer;
    }

    public String getJwt() {
        return jwt;
    }

    public Customer getCustomer() {
        return customer;
    }
}
