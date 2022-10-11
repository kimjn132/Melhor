package com.javalec.dto;

public class AdminRegisterStaffManagementDto {
	
	//fields
	int id;
	String name;
	String inDate;
	
	//constructor
	public AdminRegisterStaffManagementDto(int id, String name, String inDate) {
		super();
		this.id = id;
		this.name = name;
		this.inDate = inDate;
	}

	//getter&setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInDate() {
		return inDate;
	}

	public void setInDate(String inDate) {
		this.inDate = inDate;
	}
	
	

}
