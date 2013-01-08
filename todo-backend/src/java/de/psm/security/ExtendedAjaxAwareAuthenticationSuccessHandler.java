package de.psm.security;

import org.codehaus.groovy.grails.plugins.springsecurity.AjaxAwareAuthenticationSuccessHandler;
import org.codehaus.groovy.grails.plugins.springsecurity.SpringSecurityUtils;
import org.springframework.security.core.Authentication;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Peter Schneider-Manzell
 */
public class ExtendedAjaxAwareAuthenticationSuccessHandler extends AjaxAwareAuthenticationSuccessHandler {
    /**
     * {@inheritDoc}
     * @see org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler#onAuthenticationSuccess(
     * 	javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse,
     * 	org.springframework.security.core.Authentication)
     */
    @Override
    public void onAuthenticationSuccess(final HttpServletRequest request, final HttpServletResponse response, final Authentication authentication) throws ServletException, IOException {
        if(SpringSecurityUtils.isAjax(request)){
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().write("Logged in");
            response.getWriter().flush();
            return;
        }
        super.onAuthenticationSuccess(request,response,authentication);
    }
}
