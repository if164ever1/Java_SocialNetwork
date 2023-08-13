package com.example.demo.security;

import com.example.demo.payload.response.ErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JWTAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        // Set the response status code to unauthorized (401)
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        // Customize the response body
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.UNAUTHORIZED.value(),
                "Unauthorized",
                authException.getMessage(),
                request.getRequestURI());

        // Convert the errorResponse to JSON and write it to the response
        ObjectMapper objectMapper = new ObjectMapper();
        response.setContentType(SecurityConstants.CONTENT_TYPE);
        response.getWriter().write(objectMapper.writeValueAsString(errorResponse));
    }
}