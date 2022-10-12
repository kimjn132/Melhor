package com.javalec.dto;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class AdminRegisterMenuManagementDto {
	
	//fields
	String wkFilename;
	int wkId;
	String wkCategory;
	String wkName;
	int wkPrice;
	
	
	//constructor
	public AdminRegisterMenuManagementDto() {
		// TODO Auto-generated constructor stub
	}
	
	public AdminRegisterMenuManagementDto(String wkFilename, int wkId, String wkCategory, String wkName, int wkPrice) {
		super();
		this.wkFilename = wkFilename;
		this.wkId = wkId;
		this.wkCategory = wkCategory;
		this.wkName = wkName;
		this.wkPrice = wkPrice;
	}
	
	
	
	//getter&setter
	public String getWkFilename() {
		return wkFilename;
	}


	public void setWkFilename(String wkFilename) {
		this.wkFilename = wkFilename;
	}

	public int getWkId() {
		return wkId;
	}

	public void setWkId(int wkId) {
		this.wkId = wkId;
	}

	public String getWkCategory() {
		return wkCategory;
	}

	public void setWkCategory(String wkCategory) {
		this.wkCategory = wkCategory;
	}

	public String getWkName() {
		return wkName;
	}

	public void setWkName(String wkName) {
		this.wkName = wkName;
	}

	public int getWkPrice() {
		return wkPrice;
	}

	public void setWkPrice(int wkPrice) {
		this.wkPrice = wkPrice;
	}
	
	
	
}//END
