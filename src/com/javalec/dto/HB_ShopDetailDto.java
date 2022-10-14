package com.javalec.dto;

public class HB_ShopDetailDto {

	String shop_name;
	String product_name;
	int order_quantity;
	
	public HB_ShopDetailDto() {
		// TODO Auto-generated constructor stub
	}

	
	
	public HB_ShopDetailDto(String shop_name, String product_name, int order_quantity) {
		super();
		this.shop_name = shop_name;
		this.product_name = product_name;
		this.order_quantity = order_quantity;
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



	public String getShop_name() {
		return shop_name;
	}



	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}
	
	
	
}
