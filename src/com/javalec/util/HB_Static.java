package com.javalec.util;

public class HB_Static {

	public static int employee_id;
	public static int shop_number;
	public static int signUpEmailCheck;
	public static int day;
	public static int month;
	
	public static int incentive = 50;
	
	public HB_Static() {
		// TODO Auto-generated constructor stub
	}
	

	public static int getEmployee_id() {
		return employee_id;
	}
	public static void setEmployee_id(int employee_id) {
		HB_Static.employee_id = employee_id;
	}
	public static int getShop_number() {
		return shop_number;
	}
	public static void setShop_number(int shop_number) {
		HB_Static.shop_number = shop_number;
	}
	public static int signUpEmailCheck() {
		return signUpEmailCheck;
	}
	public static void setSignUpIdCheck(int signUpEmailCheck) {
		HB_Static.signUpEmailCheck = signUpEmailCheck;
	}
	public static int getDay() {
		return day;
	}
	public static void setDay(int day) {
		HB_Static.day = day;
	}
	public static int getMonth() {
		return month;
	}
	public static void setMonth(int month) {
		HB_Static.month = month;
	}
	
	
	
}
