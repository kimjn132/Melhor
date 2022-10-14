package com.javalec.util;

public class Static_OrdersInfo {

	public static int QuantityNum = 1;
	public static int product_price = 0;
	public static String product_name = null;
	public static String cartNproduct_FinalResultPrice  ;

	public static String getCartNproduct_FinalResultPrice() {
		return cartNproduct_FinalResultPrice;
	}

	public static void setCartNproduct_FinalResultPrice(String cartNproduct_FinalResultPrice) {
		Static_OrdersInfo.cartNproduct_FinalResultPrice = cartNproduct_FinalResultPrice;
	}

	public static int getQuantityNum() {
		return QuantityNum;
	}

	public static String getProduct_name() {
		return product_name;
	}

	public static void setProduct_name(String product_name) {
		Static_OrdersInfo.product_name = product_name;
	}

	public static void setQuantityNum(int quantityNum) {
		QuantityNum = quantityNum;
	}
	
	

	public static String QuantityNum() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Static_OrdersInfo() {
		// TODO Auto-generated constructor stub
	}

	public static int getProduct_price() {
		return product_price;
	}

	public static void setProduct_price(int product_price) {
		Static_OrdersInfo.product_price = product_price;
	}
	
	
	
	
}//End
