package com.msa_sample01.svc.member.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "members")
public class Member {

	@Id
	private String name;

	private String comment;
	
	private String email;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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
	
	public Member(String name, String comment, String email) {
		super();
		this.name = name;
		this.comment = comment;
		this.email = email;
	}
}
