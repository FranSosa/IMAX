package com.dtecimax.spring.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.web.authentication.WebAuthenticationDetails;


public class MyAuthenticationDetailsSource  implements AuthenticationDetailsSource<HttpServletRequest, WebAuthenticationDetails> {

    /**
     * returns the {@link WebAuthenticationDetails} according to LuxFact rule
     *
     * @param context
     */
    @Override
    public WebAuthenticationDetails buildDetails(final HttpServletRequest context) {
    	System.out.println("Comienza MyAuthenticationDetailsSource buildDetails");
        return new MyAuthenticationDetails(context);
    }

}
