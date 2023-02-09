package com.userLoginApplication.service;

import com.userLoginApplication.security.model.AuthenticationRequest;
import com.userLoginApplication.security.model.AuthenticationResponse;

public interface AuthenticationService {
    AuthenticationResponse createAuthenticationToken(AuthenticationRequest authenticationRequest) throws Exception;
}
