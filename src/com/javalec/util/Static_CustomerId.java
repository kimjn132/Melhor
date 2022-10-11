package com.javalec.util;

import com.javalec.dto.AppMenuListDto;

public class Static_CustomerId {

	public static String customer_id;
	public static String customer_nickname;
	public static int product_id;	
	public static String product_name;	
	public static int product_price;	
	public static String product_explain;	
	
	public static int shop_number;


	public Static_CustomerId() {
		// TODO Auto-generated constructor stub
	}


	public static String getCustomer_id() {
		return customer_id;
	}


	public static void setCustomer_id(String customer_id) {
		Static_CustomerId.customer_id = customer_id;
	}


	public static String getCustomer_nickname() {
		return customer_nickname;
	}


	public static void setCustomer_nickname(String customer_nickname) {
		Static_CustomerId.customer_nickname = customer_nickname;
	}


	public static int getProduct_id() {
		return product_id;
	}


	public static void setProduct_id(int product_id) {
		Static_CustomerId.product_id = product_id;
	}


	public static int getShop_number() {
		return shop_number;
	}


	public static void setShop_number(int shop_number) {
		Static_CustomerId.shop_number = shop_number;
	}


	public static String getProduct_name() {
		return product_name;
	}


	public static void setProduct_name(String product_name) {
		Static_CustomerId.product_name = product_name;
	}


	public static int getProduct_price() {
		return product_price;
	}


	public static void setProduct_price(int product_price) {
		Static_CustomerId.product_price = product_price;
	}


	public static String getProduct_explain() {
		return product_explain;
	}


	public static void setProduct_explain(String product_explain) {
		Static_CustomerId.product_explain = product_explain;
	}


	

	
}
