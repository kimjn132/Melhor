package com.javalec.dto;

public class KioskDto {

	// Orders Table
	//Orders Table attribute end 

	int order_id;
	int product_id;
	String customer_id;
	int shop_number;

	String product_name;


	int order_seqno;
	String order_time;
	int order_saleprice;
	int order_quantity;
	String order_delete_time;
	String order_stamp;
	int TotalPrice;
	int product_price;
	int order_price;
	int cart_id;
	String shop_name;
	int getQuantityNum;
	



	public int getGetQuantityNum() {
		return getQuantityNum;
	}
	public void setGetQuantityNum(int getQuantityNum) {
		this.getQuantityNum = getQuantityNum;
	}
	public KioskDto(String product_name, int cart_id, int getQuantityNum, int wkTotalPrice) {
		super();
		this.product_name = product_name;
		this.cart_id = cart_id;
		this.getQuantityNum = getQuantityNum;
		this.product_price=wkTotalPrice;
	}
	public KioskDto(String product_name, int cart_id) {
		super();
		this.product_name = product_name;
		this.cart_id = cart_id;
	}
	public KioskDto(int product_id) {
		super();
		this.product_id = product_id;
	}
	public KioskDto(String product_name) {
		super();
		this.product_name = product_name;
	}
	
	public KioskDto(int product_id, String product_name) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
	}
	public KioskDto(int product_id, String product_name, int product_price) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_price = product_price;
	}
//
//	public KioskDto(String wkName, int wkCart_id, int wkQuanT) {
//		// TODO Auto-generated constructor stub
//	}
	public String getShop_name() {
		return shop_name;
	}

	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}

	public int getCart_id() {
		return cart_id;
	}

	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}


	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}


	public int getProduct_price() {
		return product_price;
	}


	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}



	public int getOrder_id() {
		return product_id;
	}



	public void setOrder_id(int order_id) {
		this.product_id = order_id;
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



	public int getOrder_price() {
		return order_price;
	}



	public void setOrder_price(int order_price) {
		this.order_price = order_price;
	}
	
	
	
	
	
}// dto class end


