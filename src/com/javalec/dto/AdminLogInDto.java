package com.javalec.dto;

public class AdminLogInDto {
	
	//fields
	String adminId;
	String adminPw;
	
	//constructor
	public AdminLogInDto() {
		// TODO Auto-generated constructor stub
	}

	public AdminLogInDto(String adminId, String adminPw) {
		super();
		this.adminId = adminId;
		this.adminPw = adminPw;
	}

	
	
	//getter&setter
	public String getAdminId() {
		return adminId;
	}
	
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	
	public String getAdminPw() {
		return adminPw;
	}
	
	public void setAdminPw(String adminPw) {
		this.adminPw = adminPw;
	}
	
	
	
}
