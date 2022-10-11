package com.javalec.dto;

public class AppOrderListCheckDto {

	int cart_id;
	int cart_product_quantity;
	int product_price;
	int order_id;
	String product_name;
	String order_quantity;
	String order_saleprice;

	public AppOrderListCheckDto() {
		// TODO Auto-generated constructor stub
	}

	public AppOrderListCheckDto(int order_id, String product_name, String order_quantity, String order_saleprice) {
		super();
		this.order_id = order_id;
		this.product_name = product_name;
		this.order_quantity = order_quantity;
		this.order_saleprice = order_saleprice;
	}

	public AppOrderListCheckDto(int cart_id, String product_name, int product_price, int cart_product_quantity) {
		super();
		this.cart_id = cart_id;
		this.cart_product_quantity = cart_product_quantity;
		this.product_price = product_price;
		this.product_name = product_name;
	}

	public int getCart_id() {
		return cart_id;
	}

	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}

	public int getCart_product_quantity() {
		return cart_product_quantity;
	}

	public void setCart_product_quantity(int cart_product_quantity) {
		this.cart_product_quantity = cart_product_quantity;
	}

	public int getProduct_price() {
		return product_price;
	}

	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getOrder_quantity() {
		return order_quantity;
	}

	public void setOrder_quantity(String order_quantity) {
		this.order_quantity = order_quantity;
	}

	public String getOrder_saleprice() {
		return order_saleprice;
	}

	public void setOrder_saleprice(String order_saleprice) {
		this.order_saleprice = order_saleprice;
	}

}
