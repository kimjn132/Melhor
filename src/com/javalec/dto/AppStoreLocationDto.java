package com.javalec.dto;

public class AppStoreLocationDto {
	// field

	int shop_number;
	String shop_name;
	String shop_address;
	String shop_telno;

	// constructor

	public AppStoreLocationDto() {
		// TODO Auto-generated constructor stub
	}
	
	



	public AppStoreLocationDto(int shop_number, String shop_name, String shop_address, String shop_telno) {
		super();
		this.shop_number = shop_number;
		this.shop_name = shop_name;
		this.shop_address = shop_address;
		this.shop_telno = shop_telno;
	}





	public AppStoreLocationDto(String shop_name, int shop_number) {
		super();
		this.shop_number = shop_number;
		this.shop_name = shop_name;
	}

	




	public AppStoreLocationDto(String shop_name) {
		super();
		this.shop_name = shop_name;
	}





	public AppStoreLocationDto(int shop_number) {
		super();
		this.shop_number = shop_number;
	}





	public int getShop_number() {
		return shop_number;
	}

	public void setShop_number(int shop_number) {
		this.shop_number = shop_number;
	}

	public String getShop_name() {
		return shop_name;
	}

	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}

	public String getShop_address() {
		return shop_address;
	}

	public void setShop_address(String shop_address) {
		this.shop_address = shop_address;
	}

	public String getShop_telno() {
		return shop_telno;
	}

	public void setShop_telno(String shop_telno) {
		this.shop_telno = shop_telno;
	}

}
