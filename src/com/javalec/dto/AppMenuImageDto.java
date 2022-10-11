package com.javalec.dto;

import java.io.FileInputStream;

public class AppMenuImageDto {

	String product_name;
	int product_price;
	String product_recipe;
	String product_explain;

	public AppMenuImageDto() {
		// TODO Auto-generated constructor stub
	}

	public AppMenuImageDto(String product_name, int product_price, String product_recipe, String product_explain) {
		super();
		this.product_name = product_name;
		this.product_price = product_price;
		this.product_recipe = product_recipe;
		this.product_explain = product_explain;
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

}
