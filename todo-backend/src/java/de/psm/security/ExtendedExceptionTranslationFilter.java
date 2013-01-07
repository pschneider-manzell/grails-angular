package de.psm.security;

import org.codehaus.groovy.grails.plugins.springsecurity.SpringSecurityUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.ExceptionTranslationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Peter Schneider-Manzell
 */
public class ExtendedExceptionTranslationFilter extends ExceptionTranslationFilter {

    protected void sendStartAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
                                           AuthenticationException reason) throws ServletException, IOException {
        if(SpringSecurityUtils.isAjax(request)){
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, reason.getMessage());
            return;
        }
        super.sendStartAuthentication(request,response,chain,reason);
    }
}
