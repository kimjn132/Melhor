package com.javalec.dto;

public class HB_ManagerListDto {

	
	String employee_name;
	String shop_name;
	String shop_address;
	int employee_id;
	String employee_telno;
	String employee_in_date;
	int employee_shop_number;
	int order_salePrice;
	
	
	public HB_ManagerListDto() {
		// TODO Auto-generated constructor stub
	}

	
	
	public HB_ManagerListDto(int order_salePrice) {
		super();
		this.order_salePrice = order_salePrice;
	}



	public HB_ManagerListDto(String employee_name, String shop_name, String shop_address, int employee_id, String employee_telno, String employee_in_date
			,int employee_shop_number) {
		super();
		this.employee_name = employee_name;
		this.shop_name = shop_name;
		this.shop_address = shop_address;
		this.employee_id = employee_id;
		this.employee_telno = employee_telno;
		this.employee_in_date = employee_in_date;
		this.employee_shop_number = employee_shop_number;
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
	public String getShop_name() {
		return shop_name;
	}
	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}
	public String getShop_address() {
		return shop_address;
	}
	public void setShop_address(String shop_address) {
		this.shop_address = shop_address;
	}
	public int getEmployee_shop_number() {
		return employee_shop_number;
	}
	public void setEmployee_shop_number(int employee_shop_number) {
		this.employee_shop_number = employee_shop_number;
	}
	public int getOrder_salePrice() {
		return order_salePrice;
	}
	public void setOrder_salePrice(int order_salePrice) {
		this.order_salePrice = order_salePrice;
	}
	
	
	
}
