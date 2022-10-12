package com.javalec.dto;

public class AdminRevenueDetailDto {
	
	//fields
	int wkId;
	String wkName;
	String wkCategory;
	int wkPrice;
	double wkAvg;
	
	//constructor
	public AdminRevenueDetailDto() {
		// TODO Auto-generated constructor stub
	}

	public AdminRevenueDetailDto(int wkId, String wkName, String wkCategory, int wkPrice) {
		super();
		this.wkId = wkId;
		this.wkName = wkName;
		this.wkCategory = wkCategory;
		this.wkPrice = wkPrice;
	}



	public AdminRevenueDetailDto(double wkAvg) {
		super();
		this.wkAvg = wkAvg;
	}

	//getter&setter
	public int getWkId() {
		return wkId;
	}

	public void setWkId(int wkId) {
		this.wkId = wkId;
	}

	public String getWkName() {
		return wkName;
	}

	public void setWkName(String wkName) {
		this.wkName = wkName;
	}

	public String getWkCategory() {
		return wkCategory;
	}

	public void setWkCategory(String wkCategory) {
		this.wkCategory = wkCategory;
	}

	public double getWkAvg() {
		return wkAvg;
	}

	public void setWkAvg(double wkAvg) {
		this.wkAvg = wkAvg;
	}

	public int getWkPrice() {
		return wkPrice;
	}

	public void setWkPrice(int wkPrice) {
		this.wkPrice = wkPrice;
	}

	
}
