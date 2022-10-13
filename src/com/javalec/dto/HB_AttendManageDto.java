package com.javalec.dto;

public class HB_AttendManageDto {

	String employee_name;
	int employee_id;
	String shop_name;
	int ateend_count;
	
	public HB_AttendManageDto() {
		// TODO Auto-generated constructor stub
	}

	
	
	public HB_AttendManageDto(String employee_name, int employee_id, String shop_name, int ateend_count) {
		super();
		this.employee_name = employee_name;
		this.employee_id = employee_id;
		this.shop_name = shop_name;
		this.ateend_count = ateend_count;
	}



	public String getEmployee_name() {
		return employee_name;
	}
	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public String getShop_name() {
		return shop_name;
	}
	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}
	public int getAteend_count() {
		return ateend_count;
	}
	public void setAteend_count(int ateend_count) {
		this.ateend_count = ateend_count;
	}
	
	
	
}
