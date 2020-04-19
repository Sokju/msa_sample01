package com.msa_sample01.svc.member.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


//@Document(collection = "members")
@Entity
@Table(name="members")
public class Member {


	@Id
	private String email;
	
	private String name;

	private String comment;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

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
			
	public Member(String email, String name, String comment) {
		this.email = email;
		this.name = name;
		this.comment = comment;
	}
	
	@Override
	public String toString() {
		return String.format("Members [email=%s, name=%s, comment=%s", email, name, comment);
	}
}
