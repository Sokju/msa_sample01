package com.msa_sample01.auth.server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.msa_sample01.auth.server.service.MemberService;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Autowired
	private MemberService userDetailService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	 auth.authenticationProvider(authenticationProvider());
	}

   /**
     * 데이터베이스 인증용 Provider
     * @return
     */
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }
    
    
/*
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
    	web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/lib/**");
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
    	
//    	http.authorizeRequests()
//        // 페이지 권한 설정
//	        .antMatchers("/admin/**").hasRole("ADMIN")
//	        .antMatchers("/user/myinfo").hasRole("MEMBER")
//	        .antMatchers("/**").permitAll()
//	    .and() // 로그인 설정
//	        .formLogin()
//	        .loginPage("/user/login")
//	        .defaultSuccessUrl("/user/login/result")
//	        .permitAll()
//	    .and() // 로그아웃 설정
//	        .logout()
//	        .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
//	        .logoutSuccessUrl("/user/logout/result")
//	        .invalidateHttpSession(true)
//	    .and()
//	        // 403 예외처리 핸들링
//	        .exceptionHandling().accessDeniedPage("/user/denied");
	}
    
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	
    	
//    	auth.userDetailsService(memberService).passwordEncoder(passwordEncoder());
    	
    	PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    	
    	auth.inMemoryAuthentication()
	    	.passwordEncoder(encoder)
	        .withUser("john").password(encoder.encode("password")).roles("USER")
	        .and()
	        .withUser("james").password(encoder.encode("password")).roles("USER", "ADMIN");
    }
    
*/    

}