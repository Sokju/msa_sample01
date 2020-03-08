package com.msa_sample01.zuul.server.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class SimpleErrorFilter extends ZuulFilter {
	 
	private final Logger log = LoggerFactory.getLogger(getClass());
	
    @Override
    public String filterType() {
        return "error";
    }
 
    @Override
    public int filterOrder() {
        return 0;
    }
 
    @Override
    public boolean shouldFilter() {
        return RequestContext.getCurrentContext().getThrowable() != null;
    }
 
    @Override
    public Object run() {
        Throwable throwable = RequestContext.getCurrentContext().getThrowable();
        log.error("Exception was thrown in filters: ", throwable);
        return null;
    }
}