package com.msa_sample01.auth.server.domain;

public enum UserType {
	
	ADMIN("1", "Administrator"),
	TESTER("2", "Tester"),
	USER("3", "Developer");
	
	private String code;
	
	private String desc;
	
	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}


	UserType(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}
}
