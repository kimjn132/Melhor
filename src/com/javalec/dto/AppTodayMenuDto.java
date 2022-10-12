package com.javalec.dto;

public class AppTodayMenuDto {

	int todayMenu;
	int price;
	String explain;
	
	public AppTodayMenuDto() {
		// TODO Auto-generated constructor stub
	}

	
	
	public AppTodayMenuDto(int todayMenu) {
		super();
		this.todayMenu = todayMenu;
	}


	public AppTodayMenuDto(int price, String explain) {
		super();
		this.price = price;
		this.explain = explain;
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
	public String getExplain() {
		return explain;
	}
	public void setExplain(String explain) {
		this.explain = explain;
	}
	
	
}
