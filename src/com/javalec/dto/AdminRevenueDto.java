package com.javalec.dto;

public class AdminRevenueDto {
	
	//fields
	int id;
	String name;
	String category;
	int price;
	int quantity;
	int sales;
	double wkAvgQuantity;
	double wkAvgSales;
	
	//constructor
	public AdminRevenueDto() {
		// TODO Auto-generated constructor stub
	}

	public AdminRevenueDto(int id, String name, int price, int quantity, int sales) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.sales = sales;
	}
	
	public AdminRevenueDto(int id, String name, int price, double wkAvgQuantity, double wkAvgSales) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.wkAvgQuantity = wkAvgQuantity;
		this.wkAvgSales = wkAvgSales;
	}
	
	

	public AdminRevenueDto(int id, String name, String category, double wkAvgQuantity, double wkAvgSales) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.wkAvgQuantity = wkAvgQuantity;
		this.wkAvgSales = wkAvgSales;
	}

	//getter&setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getSales() {
		return sales;
	}

	public void setSales(int sales) {
		this.sales = sales;
	}

	public double getWkAvgQuantity() {
		return wkAvgQuantity;
	}

	public void setWkAvgQuantity(double wkAvgQuantity) {
		this.wkAvgQuantity = wkAvgQuantity;
	}

	public double getWkAvgSales() {
		return wkAvgSales;
	}

	public void setWkAvgSales(double wkAvgSales) {
		this.wkAvgSales = wkAvgSales;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	
	
	

}
