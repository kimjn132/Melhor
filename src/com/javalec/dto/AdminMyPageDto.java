package com.javalec.dto;

public class AdminMyPageDto {
	
	//fields
	String employeeName;
	String employeeTelno;
	String employeeEmail;
	
	//constructor
	public AdminMyPageDto() {
		// TODO Auto-generated constructor stub
	}

	public AdminMyPageDto(String employeeName, String employeeTelno, String employeeEmail) {
		super();
		this.employeeName = employeeName;
		this.employeeTelno = employeeTelno;
		this.employeeEmail = employeeEmail;
	}

	//getter&setter
	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeTelno() {
		return employeeTelno;
	}

	public void setEmployeeTelno(String employeeTelno) {
		this.employeeTelno = employeeTelno;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}


}
