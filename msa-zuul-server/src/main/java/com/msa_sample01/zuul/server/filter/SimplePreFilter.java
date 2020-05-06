package com.msa_sample01.zuul.server.filter;

import static org.springframework.util.ReflectionUtils.rethrowRuntimeException;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.CharStreams;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class SimplePreFilter extends ZuulFilter {

	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
    public Object run() {
		
		/*
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
 
        log.debug("Request Method : " + request.getMethod());
        log.debug("Request URL : " + request.getRequestURL().toString());
 
        String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (!validateToken(authorizationHeader)) {
            ctx.setSendZuulResponse(false);
            ctx.setResponseBody("API key not authorized");
            ctx.getResponse().setHeader("Content-Type", "text/plain;charset=UTF-8");
            ctx.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
        }
        */
        
        RequestContext 		ctx 	=	RequestContext.getCurrentContext();
        HttpServletRequest 	request = 	ctx.getRequest();
        String jsonData	=	null;
        String logType 	= 	"Q";	//	Request 로그
        String reqMethod= 	null;
        String reqURL 	= 	null;
        String keyWord 	= 	"name"; // 전문상 GUID 등이 필드 검색 Key
        		
        try {
        	
        	/*
            InputStream in = (InputStream) ctx.get(REQUEST_ENTITY_KEY);
            if (in == null) {
                in = request.getInputStream();
            }
            json	=	StreamUtils.copyToString(in, Charset.forName("UTF-8"));
            log.info("TYPE1 : "+json);

            if (in != null) in.close();

            */
        	
        	reqMethod 	= 	request.getMethod();
        	reqURL   	=	request.getRequestURL().toString();
        	MDC.put("SVC", reqURL);
        	MDC.put("API", reqMethod);
        	
            if (request.getContentLength() > 0 ) {
            	jsonData = CharStreams.toString(request.getReader());
            }
            
            if (jsonData == null) {
            	log.debug(String.format("[%s][%-6s]%s|Message is null", logType, reqMethod, reqURL));
                return null;
            }
            
            if (jsonData.length() == 0) {
            	log.debug(String.format("[%s][%-6s]%s|Message length is 0", logType, reqMethod, reqURL));
                return null;
            }
            
            log.debug(String.format("[%s][%-6s]%s|%s", logType, reqMethod, reqURL, jsonData));
	        

        }catch (IOException e) {
            rethrowRuntimeException(e);
        }
		
        return null;
    }
    
    private boolean validateToken(String tokenHeader) {
        // do something to validate the token
        return true;
    }
}