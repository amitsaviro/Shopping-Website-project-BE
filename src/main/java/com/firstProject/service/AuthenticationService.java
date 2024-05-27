package com.firstProject.service;

import com.firstProject.security.model.AuthenticationRequest;
import com.firstProject.security.model.AuthenticationResponse;

public interface AuthenticationService {
    AuthenticationResponse createAuthenticationToken(AuthenticationRequest authenticationRequest) throws Exception;
}
