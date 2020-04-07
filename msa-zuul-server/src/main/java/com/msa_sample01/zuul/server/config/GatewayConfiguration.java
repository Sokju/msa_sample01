package com.msa_sample01.zuul.server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class GatewayConfiguration extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(final HttpSecurity http) throws Exception {
      http
      .authorizeRequests()
      .antMatchers("/v1/member/api-docs/**").permitAll()
      .antMatchers("/v1/order/api-docs/**").permitAll()
      .antMatchers("/v1/member/**").hasRole("ADMIN")
      .antMatchers("/v1/order/**").hasRole("USER")
      .anyRequest().permitAll()	
      ;
      
//      http.cors();
    }
}