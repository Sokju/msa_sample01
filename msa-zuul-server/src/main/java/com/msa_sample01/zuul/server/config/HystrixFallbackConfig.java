package com.msa_sample01.zuul.server.config;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;

import com.netflix.hystrix.exception.HystrixTimeoutException;

@Configuration
public class HystrixFallbackConfig implements FallbackProvider {
    @Override
    public String getRoute() {
        return "*";
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, final Throwable cause) {
        if (cause instanceof HystrixTimeoutException) {
            return defaultResponse(HttpStatus.GATEWAY_TIMEOUT);
        } else {
            return defaultResponse(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ClientHttpResponse defaultResponse(final HttpStatus status) {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return status; // HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return status.value(); //200;
            }

            @Override
            public String getStatusText() throws IOException {
                return status.getReasonPhrase(); //"OK";
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
//                return new ByteArrayInputStream("default fallback".getBytes());
                return new ByteArrayInputStream("Service is Down".getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                return headers;
            }
        };
    }
}