package com.msa_sample01.auth.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    
    @Override
    @Bean
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return super.userDetailsServiceBean();
    }

    @Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/actuator/health").permitAll();
	}
    
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

    	PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    	
    	auth.inMemoryAuthentication()
	    	.passwordEncoder(encoder)
	        .withUser("john").password(encoder.encode("john1")).roles("USER")
	        .and()
	        .withUser("james").password(encoder.encode("james1")).roles("USER", "ADMIN");
    }

}