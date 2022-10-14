package com.javalec.dto;


public class HB_BestProductListDto {

	String product_name;
	int product_price;
	int order_quantity;
	
	String image;
	
	public HB_BestProductListDto() {
		// TODO Auto-generated constructor stub
	}

	
	
	public HB_BestProductListDto(String image, String product_name, int product_price, int order_quantity) {
		super();
		this.image = image;
		this.product_name = product_name;
		this.product_price = product_price;
		this.order_quantity = order_quantity;
	}






	public String getImage() {
		return image;
	}



	public void setImage(String image) {
		this.image = image;
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
	public int getOrder_quantity() {
		return order_quantity;
	}
	public void setOrder_quantity(int order_quantity) {
		this.order_quantity = order_quantity;
	}
	
}
