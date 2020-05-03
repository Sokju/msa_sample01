package com.msa_sample01.svc.member.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class InspectHeaderFilter implements Filter {
   
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {


//        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
//        log.debug("I AM HITTING THE AUTH SERVER: " + httpServletRequest.getHeader("Authorization"));
//        
//        Enumeration<String> headerNames = httpServletRequest.getHeaderNames();
//
//        while (headerNames.hasMoreElements()) {
//            String headerName = headerNames.nextElement();
//            
//            log.debug(headerName + " : " + httpServletRequest.getHeader(headerName));
//        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void destroy() {}
}