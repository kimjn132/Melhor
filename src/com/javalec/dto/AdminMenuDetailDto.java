package com.javalec.dto;

public class AdminMenuDetailDto {
	
	//fields
	public int product_id;
	public String product_name;
	public int product_price;
	public String product_recipe;
	public String product_explain;
	public String product_category;
	public int getProduct_id() {
		return product_id;
	}
	
	//constructor
	public AdminMenuDetailDto() {
		// TODO Auto-generated constructor stub
	}
	public AdminMenuDetailDto(int product_id, String product_name, String product_category, int product_price, String product_recipe,
			String product_explain) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_price = product_price;
		this.product_recipe = product_recipe;
		this.product_explain = product_explain;
		this.product_category = product_category;
	}
	public AdminMenuDetailDto(String product_category) {
		super();
		this.product_category = product_category;
	}

	//getter&setter
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
	public String getProduct_recipe() {
		return product_recipe;
	}
	public void setProduct_recipe(String product_recipe) {
		this.product_recipe = product_recipe;
	}
	public String getProduct_explain() {
		return product_explain;
	}
	public void setProduct_explain(String product_explain) {
		this.product_explain = product_explain;
	}
	public String getProduct_category() {
		return product_category;
	}
	public void setProduct_category(String product_category) {
		this.product_category = product_category;
	}
	
}
