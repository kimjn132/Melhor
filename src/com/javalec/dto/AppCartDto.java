package com.javalec.dto;

public class AppCartDto {

	int cart_id;
	String product_name;
	int product_price;
	int cart_product_quantity;

	public AppCartDto() {
		// TODO Auto-generated constructor stub
	}
	
	

	public AppCartDto(int cart_id, String product_name, int product_price, int cart_product_quantity) {
		super();
		this.cart_id = cart_id;
		this.product_name = product_name;
		this.product_price = product_price;
		this.cart_product_quantity = cart_product_quantity;
	}

	public int getCart_id() {
		return cart_id;
	}

	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
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

	public int getCart_product_quantity() {
		return cart_product_quantity;
	}

	public void setCart_product_quantity(int cart_product_quantity) {
		this.cart_product_quantity = cart_product_quantity;
	}

}
