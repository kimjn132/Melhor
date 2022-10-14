package com.javalec.dto;

import java.io.FileInputStream;

public class AppMenuImageDto {

	String product_name;
	FileInputStream product_image;
	int product_price;
	String product_category;
	String product_recipe;
	String product_explain;
	public AppMenuImageDto(String product_name, FileInputStream product_image, int product_price,
			String product_category, String product_recipe, String product_explain) {
		super();
		this.product_name = product_name;
		this.product_image = product_image;
		this.product_price = product_price;
		this.product_category = product_category;
		this.product_recipe = product_recipe;
		this.product_explain = product_explain;
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
	public String getProduct_category() {
		return product_category;
	}
	public void setProduct_category(String product_category) {
		this.product_category = product_category;
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
