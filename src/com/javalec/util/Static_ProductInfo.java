package com.javalec.util;

public class Static_ProductInfo {

	
	public static int product_id;
	public static String product_name;
//	public static int product_price;
	public static String product_recipe;
	public static String product_explain;
	public static int cart_id;
	public static boolean InOut;
//	public static String shop_name; -> Static StoreLocation Dto

	//public static String time;
	// 매장,포장 버튼을 클릭했던 시간을 저장한 뒤, 결재하기 버튼을 누를 때 그때부터 지금까지 시간 사이에 
	// 제품 정보를 불러와서 결제하기때 써먹을 수 있지 않겠냐 는 아이디어가 있어서 써먹어 보려고 해봤던거 
	
	public Static_ProductInfo() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public static int getCart_id() {
		return cart_id;
	}


	public static void setCart_id(int cart_id) {
		Static_ProductInfo.cart_id = cart_id;
	}


	public static int getProduct_id() {
		return product_id;
	}
	
	public static void setProduct_id(int product_id) {
		Static_ProductInfo.product_id = product_id;
	}


	public static String getProduct_name() {
		return product_name;
	}



	public static void setProduct_name(String product_name) {
		Static_ProductInfo.product_name = product_name;
	}

	public static String getProduct_recipe() {
		return product_recipe;
	}



	public static void setProduct_recipe(String product_recipe) {
		Static_ProductInfo.product_recipe = product_recipe;
	}



	public static String getProduct_explain() {
		return product_explain;
	}



	public static void setProduct_explain(String product_explain) {
		Static_ProductInfo.product_explain = product_explain;
	}











	public static boolean isInOut() {
		return InOut;
	}






	public static void setInOut(boolean inOut) {
		InOut = inOut;
	}



	
	
	
	
	
	
	
	
	
	
	
	
	
}//End
