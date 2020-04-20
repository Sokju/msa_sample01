package com.msa_sample01.auth.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
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
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**");
    }
    
    @Override
	protected void configure(HttpSecurity http) throws Exception {
    	http
    		.authorizeRequests()
    		.antMatchers("/").permitAll()
    		.antMatchers("/v1/member/**").hasAnyRole("USER", "ADMIN")
    		.antMatchers("/v1/order/**").hasAnyRole("USER", "ADMIN")
    		.anyRequest().authenticated()
    	.and()
    		.formLogin()
    		.permitAll()
    	.and()
    		.logout().permitAll();
    	
    	http.csrf().disable();
    	
		//http.httpBasic();
	}
    
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

    	PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    	
    	auth.inMemoryAuthentication()
	    	.passwordEncoder(encoder)
	        .withUser("developer@sample01.com").password(encoder.encode("abcd1234")).roles("USER")
	        .and()
	        .withUser("admin@sample01.com").password(encoder.encode("abcd1234")).roles("USER", "ADMIN");
    }

}