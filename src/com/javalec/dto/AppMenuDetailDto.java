package com.javalec.dto;

import com.mysql.cj.jdbc.Blob;

public class AppMenuDetailDto {

	int product_id;
	String product_name;
	int product_price;
	String product_explain;
	int cart_id;
	String customer_id;

	public AppMenuDetailDto() {
		// TODO Auto-generated constructor stub
	}

//	public AppMenuDetailDto(int product_id, String product_name, int cart_id, String customer_id) {
//		super();
//		this.product_id = product_id;
//		this.product_name = product_name;
//		this.cart_id = cart_id;
//		this.customer_id = customer_id;
//	}
	
	

	public AppMenuDetailDto(int product_id, String product_name, int product_price, String product_explain) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_price = product_price;
		this.product_explain = product_explain;
	}

	public AppMenuDetailDto(String product_name, int product_price, String product_explain) {
		super();
		this.product_name = product_name;
		this.product_price = product_price;
		this.product_explain = product_explain;
	}
	
	

	public int getProduct_price() {
		return product_price;
	}

	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}

	public String getProduct_explain() {
		return product_explain;
	}

	public void setProduct_explain(String product_explain) {
		this.product_explain = product_explain;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getCart_id() {
		return cart_id;
	}

	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}

	public String getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}

}
