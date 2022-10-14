package com.javalec.dto;

public class HB_staffManageListDto {

	String employee_name;
	int employee_id;
	String employee_telno;
	String employee_in_date;
	String employee_email;
	int manufact_quantity;
	
	public HB_staffManageListDto() {
		// TODO Auto-generated constructor stub
	}
	
	

	public HB_staffManageListDto(String employee_name, int manufact_quantity) {
		super();
		this.employee_name = employee_name;
		this.manufact_quantity = manufact_quantity;
	}



	public HB_staffManageListDto(String employee_name, int employee_id, String employee_telno, String employee_in_date) {
		super();
		this.employee_name = employee_name;
		this.employee_id = employee_id;
		this.employee_telno = employee_telno;
		this.employee_in_date = employee_in_date;
	}
	
	
	public HB_staffManageListDto(String employee_name, int employee_id, String employee_telno, String employee_in_date,
			int manufact_quantity) {
		super();
		this.employee_name = employee_name;
		this.employee_id = employee_id;
		this.employee_telno = employee_telno;
		this.employee_in_date = employee_in_date;
		this.manufact_quantity = manufact_quantity;
	}

	public HB_staffManageListDto(int manufact_quantity) {
		super();
		this.manufact_quantity = manufact_quantity;
	}
	
	public HB_staffManageListDto(int employee_id, String employee_name, String employee_telno, String employee_in_date, String employee_email) {
		super();
		this.employee_id = employee_id;
		this.employee_name = employee_name;
		this.employee_telno = employee_telno;
		this.employee_in_date = employee_in_date;
		this.employee_email = employee_email;
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
	public String getEmployee_telno() {
		return employee_telno;
	}
	public void setEmployee_telno(String employee_telno) {
		this.employee_telno = employee_telno;
	}
	public String getEmployee_in_date() {
		return employee_in_date;
	}
	public void setEmployee_in_date(String employee_in_date) {
		this.employee_in_date = employee_in_date;
	}
	public int getManufact_quantity() {
		return manufact_quantity;
	}
	public void setManufact_quantity(int manufact_quantity) {
		this.manufact_quantity = manufact_quantity;
	}
	public String getEmployee_email() {
		return employee_email;
	}
	public void setEmployee_email(String employee_email) {
		this.employee_email = employee_email;
	}
	
	
	
	
	
	
	
	
}
