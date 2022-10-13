package com.javalec.dto;

import java.io.FileInputStream;

public class AppOrderListCheckDto {

	int cart_id;
	int cart_product_quantity;

	int product_id;
	String product_name;
	FileInputStream product_image;
	int product_price;
	String product_explain;

	int order_id;
	int order_quantity;
	int order_saleprice;
	String order_payment;
	int order_stamp;

	String customer_id;

	int shop_number;

	public AppOrderListCheckDto() {
		// TODO Auto-generated constructor stub
	}

	public AppOrderListCheckDto(int cart_id, String product_name, int product_price, int cart_product_quantity) {
		super();
		this.cart_id = cart_id;
		this.product_name = product_name;
		this.product_price = product_price;
		this.cart_product_quantity = cart_product_quantity;

	}

	public AppOrderListCheckDto(int product_id, String customer_id, int shop_number, int order_id, int order_saleprice, String order_payment, int order_stamp) {
		super();
		this.product_id = product_id;
		this.customer_id = customer_id;
		this.shop_number = shop_number;
		this.order_id = order_id;
		this.order_saleprice = order_saleprice;
		this.order_payment = order_payment;
		this.order_stamp = order_stamp;
	}

	public AppOrderListCheckDto(String customer_id, int shop_number) {
		super();
		this.customer_id = customer_id;
		this.shop_number = shop_number;
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

	public FileInputStream getProduct_image() {
		return product_image;
	}

	public void setProduct_image(FileInputStream product_image) {
		this.product_image = product_image;
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

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getOrder_quantity() {
		return order_quantity;
	}

	public void setOrder_quantity(int order_quantity) {
		this.order_quantity = order_quantity;
	}

	public int getOrder_saleprice() {
		return order_saleprice;
	}

	public void setOrder_saleprice(int order_saleprice) {
		this.order_saleprice = order_saleprice;
	}

	public String getOrder_payment() {
		return order_payment;
	}

	public void setOrder_payment(String order_payment) {
		this.order_payment = order_payment;
	}

	public int getOrder_stamp() {
		return order_stamp;
	}

	public void setOrder_stamp(int order_stamp) {
		this.order_stamp = order_stamp;
	}

	public String getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}

	public int getShop_number() {
		return shop_number;
	}

	public void setShop_number(int shop_number) {
		this.shop_number = shop_number;
	}

}
