package de.psm.security;

import org.codehaus.groovy.grails.plugins.springsecurity.RequestHolderAuthenticationFilter;
import org.codehaus.groovy.grails.plugins.springsecurity.SecurityRequestHolder;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Peter Schneider-Manzell
 */
public class ExtendedRequestHolderAuthenticationFilter extends RequestHolderAuthenticationFilter {
    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        if(req.getMethod().equals("OPTIONS")){
            return;
        }
        else {
            try {
                super.doFilter(request, response, chain);
            }
            finally {
                SecurityRequestHolder.reset();
            }
        }

    }
}
