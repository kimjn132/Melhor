package com.javalec.dto;

public class AdminStaffDetailDto {
	
	//fields
	int wkId;
	String wkName;
	String wkInDate;
	String wkTelno;
	String wkEmail;
	
	//constructor
	public AdminStaffDetailDto() {
		// TODO Auto-generated constructor stub
	}

	public AdminStaffDetailDto(int wkId, String wkName, String wkInDate, String wkTelno, String wkEmail) {
		super();
		this.wkId = wkId;
		this.wkName = wkName;
		this.wkInDate = wkInDate;
		this.wkTelno = wkTelno;
		this.wkEmail = wkEmail;
	}

	//getter&setter
	public int getWkId() {
		return wkId;
	}

	public void setWkId(int wkId) {
		this.wkId = wkId;
	}

	public String getWkName() {
		return wkName;
	}

	public void setWkName(String wkName) {
		this.wkName = wkName;
	}

	public String getWkInDate() {
		return wkInDate;
	}

	public void setWkInDate(String wkInDate) {
		this.wkInDate = wkInDate;
	}

	public String getWkTelno() {
		return wkTelno;
	}

	public void setWkTelno(String wkTelno) {
		this.wkTelno = wkTelno;
	}

	public String getWkEmail() {
		return wkEmail;
	}

	public void setWkEmail(String wkEmail) {
		this.wkEmail = wkEmail;
	}
	
	

}
