package com.dtecimax.spring.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;
import org.springframework.security.web.csrf.InvalidCsrfTokenException;
import org.springframework.security.web.csrf.MissingCsrfTokenException;

public class CustomAccessDeniedHandler extends AccessDeniedHandlerImpl {

    @Override
    public void handle(HttpServletRequest request,
            HttpServletResponse response,
            AccessDeniedException accessDeniedException)
            throws IOException, ServletException {
        System.out.println("CustomAccessDeniedHandler");
        System.out.println("accessDeniedException="+accessDeniedException.getClass().toString());
        if (accessDeniedException instanceof MissingCsrfTokenException
                || accessDeniedException instanceof InvalidCsrfTokenException) {
            System.out.println("if  true");
            System.out.println("Request:"+request.getRequestURI().toString());
                System.out.println("timeout");
                response.sendRedirect(request.getContextPath() + "/timeout.xhtml");
        }
        //System.out.println("");
        super.handle(request, response, accessDeniedException);
    }
}

