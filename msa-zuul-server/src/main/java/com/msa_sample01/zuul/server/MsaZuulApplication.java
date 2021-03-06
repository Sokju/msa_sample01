package com.msa_sample01.zuul.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.msa_sample01.zuul.server.filter.SimpleErrorFilter;
import com.msa_sample01.zuul.server.filter.SimplePostFilter;
import com.msa_sample01.zuul.server.filter.SimplePreFilter;
import com.msa_sample01.zuul.server.filter.SimpleRouteFilter;

@EnableZuulProxy
@EnableEurekaClient
@EnableHystrix
@SpringBootApplication
public class MsaZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsaZuulApplication.class, args);
	}

	@Bean
    public SimplePreFilter preFilter() {
        return new SimplePreFilter();
    }
    
    @Bean
    public SimplePostFilter postFilter() {
        return new SimplePostFilter();
    }
    
    @Bean
    public SimpleErrorFilter errorFilter() {
        return new SimpleErrorFilter();
    }
    
    @Bean
    public SimpleRouteFilter routeFilter() {
        return new SimpleRouteFilter();
    }
    
}
