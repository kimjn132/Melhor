package com.javalec.dto;

public class AppMenuListDto {

	int product_id;
	String product_name;
	int product_price;
	String product_explain;

	public AppMenuListDto() {
		// TODO Auto-generated constructor stub
	}

	public AppMenuListDto(int product_id, String product_name, int product_price, String product_explain) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_price = product_price;
		this.product_explain = product_explain;
	}

	public AppMenuListDto(String productName, int productPrice, String productExplain) {
		super();
		this.product_name = productName;
		this.product_price = productPrice;
		this.product_explain = productExplain;
	}

	public AppMenuListDto(int product_id, String product_name, int product_price) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_price = product_price;
	}

	public AppMenuListDto(int product_id) {
		super();
		this.product_id = product_id;
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

}
