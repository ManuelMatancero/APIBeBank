package com.manuelsarante.ApiBeBank.security;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.util.matcher.RequestMatcher;
/*
 * Copyright (c) Manuel Antonio Sarante Sanchez 2023
 * All rights reserved.
 */
public class CustomEndpointRequestMatcher implements RequestMatcher {
    private final String endpoint;

    public CustomEndpointRequestMatcher(String endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    public boolean matches(HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        // Customize the condition based on your endpoint path
        return requestURI.equals(endpoint);
    }
}
