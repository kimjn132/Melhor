package com.javalec.dto;

import java.io.FileInputStream;

public class AppTodayMenuDto {

	int todayMenu;
	int price;
	String name;
	String explain;

	int product_id;
	String customer_id;
	int shop_number;
	String cart_date;
	int cart_product_quantity;

	public AppTodayMenuDto() {
		// TODO Auto-generated constructor stub
	}

	public AppTodayMenuDto(int todayMenu) {
		super();
		this.todayMenu = todayMenu;
	}

	public AppTodayMenuDto(int price, String name, String explain) {
		super();
		this.price = price;
		this.name = name;
		this.explain = explain;

	}

	public AppTodayMenuDto(int price, String name, String explain, int product_id) {
		super();
		this.price = price;
		this.name = name;
		this.explain = explain;
		this.product_id = product_id;

	}

	public AppTodayMenuDto(String customer_id, int shop_number, int cart_product_quantity, int product_id) {
		super();
		this.cart_product_quantity = cart_product_quantity;
		this.customer_id = customer_id;
		this.shop_number = shop_number;
		this.product_id = product_id;

	}

	public int getTodayMenu() {
		return todayMenu;
	}

	public void setTodayMenu(int todayMenu) {
		this.todayMenu = todayMenu;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExplain() {
		return explain;
	}

	public void setExplain(String explain) {
		this.explain = explain;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
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

	public String getCart_date() {
		return cart_date;
	}

	public void setCart_date(String cart_date) {
		this.cart_date = cart_date;
	}

	public int getCart_product_quantity() {
		return cart_product_quantity;
	}

	public void setCart_product_quantity(int cart_product_quantity) {
		this.cart_product_quantity = cart_product_quantity;
	}

}
