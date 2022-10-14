package com.javalec.dto;

public class HS_OrderManagePastDto {

	
	
	
	int order_id ;
	String customer_id ;
	String product_name ;
	int order_quantity;
	String order_time;
	
	public HS_OrderManagePastDto(int order_id, String customer_id, String product_name, int order_quantity, String order_time) {
		super();
		this.order_id = order_id;
		this.customer_id = customer_id;
		this.product_name = product_name;
		this.order_quantity = order_quantity;
		this.order_time = order_time;
	}


	public String getOrder_time() {
		return order_time;
	}


	public void setOrder_time(String order_time) {
		this.order_time = order_time;
	}


	public int getOrder_id() {
		return order_id;
	}


	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}


	public String getCustomer_id() {
		return customer_id;
	}


	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}


	public String getProduct_name() {
		return product_name;
	}


	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}


	public int getOrder_quantity() {
		return order_quantity;
	}


	public void setOrder_quantity(int order_quantity) {
		this.order_quantity = order_quantity;
	}
	
	
	
	
	
	
	
}
