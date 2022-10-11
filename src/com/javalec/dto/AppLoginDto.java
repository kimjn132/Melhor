package com.javalec.dto;

public class AppLoginDto {

	// field
	String customer_id;
	String customer_pw;
	String customer_nickname;
	

	// constructor
	public String getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}

	public String getCustomer_pw() {
		return customer_pw;
	}

	public void setCustomer_pw(String customer_pw) {
		this.customer_pw = customer_pw;
	}

	public String getCustomer_nickname() {
		return customer_nickname;
	}

	public void setCustomer_nickname(String customer_nickname) {
		this.customer_nickname = customer_nickname;
	}
	

}