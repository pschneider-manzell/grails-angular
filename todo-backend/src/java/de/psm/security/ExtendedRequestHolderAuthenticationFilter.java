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
import java.util.HashMap;
import java.util.Map;

/**
 * @author Peter Schneider-Manzell
 */
public class ExtendedRequestHolderAuthenticationFilter extends RequestHolderAuthenticationFilter {
    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse)response;
        if(req.getMethod().equals("OPTIONS")){
            logger.error("Detected OPTIONS!");
            //Map<String,String> headers = new HashMap();
            //headers.put("Access-Control-Allow-Credentials", "true");
            //headers.put("Access-Control-Allow-Headers", "origin, authorization, accept, content-type, x-requested-with");
            //headers.put("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS");
            //headers.put("Access-Control-Max-Age", "3600");
            //headers.put("Access-Control-Allow-Origin", "http://localhost:7070");
            //for(Map.Entry<String,String> entry:headers.entrySet()){
            //    resp.addHeader(entry.getKey(), entry.getValue());
            //}




            resp.setStatus(HttpServletResponse.SC_OK);
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
