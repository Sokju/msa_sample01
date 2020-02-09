package com.msa_sample01.svc.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableFeignClients
@EnableCircuitBreaker
@EnableEurekaClient
@SpringBootApplication
public class MemberServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(MemberServiceApplication.class, args);
	}
	
	@LoadBalanced //adding this line solved the issue
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
