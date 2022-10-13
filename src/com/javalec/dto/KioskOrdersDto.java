package com.javalec.dto;

public class KioskOrdersDto {
	

	//Field
	String product_name;
	
	int product_quantity;
	
	
	
	//Constructor
	
	public KioskOrdersDto(String product_name) {
		super();
		this.product_name = product_name;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getProduct_quantity() {
		return product_quantity;
	}

	public void setProduct_quantity(int product_quantity) {
		this.product_quantity = product_quantity;
	}

	
	

	
	
	
	
	
	
	
}//End
