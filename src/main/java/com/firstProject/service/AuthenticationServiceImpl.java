package com.firstProject.service;

import com.firstProject.model.Customer;
import com.firstProject.security.CustomerDetailsService;
import com.firstProject.security.model.AuthenticationRequest;
import com.firstProject.security.model.AuthenticationResponse;
import com.firstProject.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    private CustomerDetailsService customerDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public AuthenticationResponse createAuthenticationToken(AuthenticationRequest authenticationRequest) throws Exception {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
        );

        final UserDetails userDetails = customerDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);

        // Fetch the customer details from the CustomerDetailsService
        Customer customer = customerDetailsService.getCustomerByUsername(authenticationRequest.getUsername());

        // Return the response with the full customer object
        return new AuthenticationResponse(jwt, customer);
    }
}




