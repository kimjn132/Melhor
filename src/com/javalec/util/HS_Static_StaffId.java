package com.javalec.util;

public class HS_Static_StaffId {

	public HS_Static_StaffId() {
		// TODO Auto-generated constructor stub
	}

	public static int staff_Id;// 이게 sql 상에서는 employeeId 입니다
	
	public static String attend_date;//입사일 저장

	public static int shop_number;//어떤 지점인지 저장
	
	
	
	
	
	
	

	public static String getAttend_date() {
		return attend_date;
	}

	public static void setAttend_date(String attend_date) {
		HS_Static_StaffId.attend_date = attend_date;
	}

	public static int getShop_number() {
		return shop_number;
	}

	public static void setShop_number(int shop_number) {
		HS_Static_StaffId.shop_number = shop_number;
	}

	public static int getStaff_Id() {
		return staff_Id;
	}

	public static void setStaff_Id(int staff_Id) {
		HS_Static_StaffId.staff_Id = staff_Id;
	}

}
