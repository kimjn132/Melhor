package com.javalec.dto;

public class HB_shopListDto {

	int shop_number;
	String shop_name;
	String shop_address;
	String shop_telno;
	int employee_id;
	int order_salePrice;
	
	
	
	public HB_shopListDto() {
		// TODO Auto-generated constructor stub
	}
	



	public HB_shopListDto(String shop_name, int order_salePrice) {
		super();
		this.shop_name = shop_name;
		this.order_salePrice = order_salePrice;
	}




	public HB_shopListDto(int shop_number, int employee_id, String shop_name, String shop_address, String shop_telno) {
		super();
		this.shop_number = shop_number;
		this.employee_id = employee_id;
		this.shop_name = shop_name;
		this.shop_address = shop_address;
		this.shop_telno = shop_telno;
	}








	public HB_shopListDto(String shop_name, String shop_address, String shop_telno, int order_salePrice, int shop_number) {
		super();
		this.shop_number = shop_number;
		this.shop_name = shop_name;
		this.shop_address = shop_address;
		this.order_salePrice = order_salePrice;
		this.shop_telno = shop_telno;
	}




	public int getShop_number() {
		return shop_number;
	}
	public void setShop_number(int shop_number) {
		this.shop_number = shop_number;
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
	public String getShop_telno() {
		return shop_telno;
	}
	public void setShop_telno(String shop_telno) {
		this.shop_telno = shop_telno;
	}
	public int getOrder_saleprice() {
		return order_salePrice;
	}
	public void setOrder_saleprice(int order_salePrice) {
		this.order_salePrice = order_salePrice;
	}
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	
	
	
}
