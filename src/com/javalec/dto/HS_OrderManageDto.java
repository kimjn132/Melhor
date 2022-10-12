package com.javalec.dto;

public class HS_OrderManageDto {
	
	
	public HS_OrderManageDto() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	int order_id ;
	int customer_id ;
	String product_name ;
	int order_quantity;
	
	public HS_OrderManageDto(int order_id, int customer_id, String product_name, int order_quantity) {
		super();
		this.order_id = order_id;
		this.customer_id = customer_id;
		this.product_name = product_name;
		this.order_quantity = order_quantity;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
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
