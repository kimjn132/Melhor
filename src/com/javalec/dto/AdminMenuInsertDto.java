package com.javalec.dto;

public class AdminMenuInsertDto {
	
	//fields
	public int product_id;
	public String product_category;
	public String product_name;
	public int product_price;
	
	//constructor
	public AdminMenuInsertDto() {
		// TODO Auto-generated constructor stub
	}

	public AdminMenuInsertDto(int product_id, String product_category, String product_name, int product_price) {
		super();
		this.product_id = product_id;
		this.product_category = product_category;
		this.product_name = product_name;
		this.product_price = product_price;
	}

	//getter&setter
	
	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct_category() {
		return product_category;
	}

	public void setProduct_category(String product_category) {
		this.product_category = product_category;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getProduct_price() {
		return product_price;
	}

	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}
	
	
	

}
