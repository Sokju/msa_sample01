package com.msa_sample01.auth.server.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "members")
public class Member {

	@Id
	private String email;
	
	private String name;

	private String password;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Member() {
		super();
	}
	
	public Member(String name, String password, String email) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
	}
}
