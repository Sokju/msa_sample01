package com.msa_sample01.auth.server.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class LoginUser implements UserDetails {
	
	private static final long serialVersionUID = 6396079419309274853L;
	private Long id;
	private String username;
	private String password;
	private String userType;
	private List<String> roles;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public LoginUser() {		
	}
	
	public LoginUser(Member user) {
		this.id = user.getId();
		this.username =  user.getEmail();
		this.password = user.getPassword();
		this.userType = user.getUserType();		
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
	}
	@Override
	public boolean isAccountNonExpired() {		
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {		
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {		
		return true;
	}
	@Override
	public boolean isEnabled() {		
		return true;
	}
	
	
	
}
