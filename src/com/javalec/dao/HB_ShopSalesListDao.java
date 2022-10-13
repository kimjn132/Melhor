package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.dto.HB_shopListDto;
import com.javalec.util.DBConnect;
import com.javalec.util.HB_Static;

public class HB_ShopSalesListDao {

	String result;
	String ShopText;
	
	int shop_number;
	int shop_employee_id;
	String shop_name;
	String shop_address;
	String shop_telno;
	
	public HB_ShopSalesListDao() {
		// TODO Auto-generated constructor stub
	}
	
	
	// shopDetailListUpdate()
	public HB_ShopSalesListDao(int shop_number, int shop_employee_id, String shop_name, String shop_address,
			String shop_telno) {
		super();
		this.shop_number = shop_number;
		this.shop_employee_id = shop_employee_id;
		this.shop_name = shop_name;
		this.shop_address = shop_address;
		this.shop_telno = shop_telno;
	}



	public HB_ShopSalesListDao(int shop_number) {
		super();
		this.shop_number = shop_number;
	}



	// 콤보박스와 텍스트 값
	public HB_ShopSalesListDao(String result, String ShopText) {
		super();
		this.result = result;
		this.ShopText = ShopText;
	}

	
	public ArrayList<HB_shopListDto> shopConditionList() {

		ArrayList<HB_shopListDto> shopList = new ArrayList<HB_shopListDto>();
		String whereStatement = "select shop_number, shop_employee_id, shop_name, shop_address, shop_telno from shop";
		String whereStatement2 = " where " + result + " like '%" + ShopText + "%' order by shop_number asc";
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2);

			while (rs.next()) {

				int shop_number = rs.getInt(1);
				int shop_employee_id = rs.getInt(2);
				String shop_name = rs.getString(3);
				String shop_address = rs.getString(4);
				String shop_telno = rs.getString(5);

				HB_shopListDto dto = new HB_shopListDto(shop_number, shop_employee_id, shop_name, shop_address, shop_telno);
				shopList.add(dto);

			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return shopList;
	}


	
	// 지점 상세정보
	public HB_shopListDto shopDetailList() {

		HB_shopListDto dto = null;
		String whereStatement = "select shop_number, shop_employee_id, shop_name, shop_address, shop_telno from shop ";
		String whereStatement2 = "where shop_number = " + shop_number;
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2);

			if (rs.next()) {

				int shop_number = rs.getInt(1);
				int shop_employee_id = rs.getInt(2);
				String shop_name = rs.getString(3);
				String shop_address = rs.getString(4);
				String shop_telno = rs.getString(5);

				dto = new HB_shopListDto(shop_number, shop_employee_id, shop_name, shop_address, shop_telno);
			}

			conn_mysql.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dto;
	}
	
	// 지점 일 매출
	public int shopDaySales(int day) {
		int sales = 0;
		
		String whereStatement = "select sum(o.order_saleprice) from shop s, orders o ";
		String whereStatement2 = "where s.shop_number = o.shop_number and s.shop_number = " + shop_number + " and "
				+ "DATE(o.order_time) = DATE(now() - interval (DAY(now()) - " + day + ") day) "
				+ "and o.order_stamp is not null";	

		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2);
			
			while(rs.next()) {

				sales = rs.getInt(1);
				
			}
			
			conn_mysql.close();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	
		return sales;
	}
	
	// 지점 이번 달 매출
	public int shopMonthSales(int month) {

		int sales = 0;

		String whereStatement = "select sum(o.order_saleprice) from shop s, orders o ";
		String whereStatement2 = "where s.shop_number = o.shop_number and s.shop_number = " + shop_number + " and "
				+ "DATE(o.order_time) BETWEEN "
				+ "LAST_DAY(NOW() - interval (month(now()) - " + (month - 1) + ") month) + interval 1 DAY and LAST_DAY(NOW() - interval (month(now()) - " + month + ") month) "
				+ "and o.order_stamp is not null";

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2);

			while (rs.next()) {

				sales = rs.getInt(1);

			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return sales;
	}

	// 선택한 월, 일 매출액 출력
	public int shopMonthDaySales(int month, int day) {

		int sales = 0;

		String whereStatement = "select sum(o.order_saleprice) from shop s, orders o ";
		String whereStatement2 = "where s.shop_number = o.shop_number and s.shop_number = " + shop_number + " and "
				 + "date(o.order_time) = DATE(now() - interval (month(now()) - " + month + ") month - interval (day(now()) - " + day + ") day) "
				 + "and o.order_stamp is not null";

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2);

			while (rs.next()) {

				sales = rs.getInt(1);

			}
			
			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return sales;
	}
	
	// 지점 총 매출
	public int shopTotalSales() {

		int sales = 0;

		String whereStatement = "select sum(o.order_saleprice) from shop s, orders o ";
		String whereStatement2 = "where s.shop_number = o.shop_number and s.shop_number = " + shop_number + " and o.order_stamp is not null";

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2);

			while (rs.next()) {

				sales = rs.getInt(1);

			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return sales;
	}
	
	
	// 지점 상세정보 수정
	public boolean shopDetailListUpdate() {
		PreparedStatement ps = null;
		  try{
			  Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw_mysql);
				Statement stmt_mysql = conn_mysql.createStatement();
		
		      String whereStatement = "update shop set shop_employee_id = ?, shop_name = ?, shop_address = ?, shop_telno = ? ";
		      String whereStatement2 = " where shop_number = ? ";
		
		      ps = conn_mysql.prepareStatement(whereStatement + whereStatement2);
		      
		      ps.setInt(1, shop_employee_id);
		      ps.setString(2, shop_name);
		      ps.setString(3, shop_address);
		      ps.setString(4, shop_telno);
		      ps.setInt(5, shop_number);
		      
		      ps.executeUpdate();
		
		      conn_mysql.close();
		  } catch (Exception e){
		      e.printStackTrace();
		      return false;
		  }
		
		  return true;
	}
	

	
	
	public HB_shopListDto allShopTotalSales() {
		
		HB_shopListDto dto = null;
		String whereStatement = "select s.shop_name, sum(o.order_saleprice) from orders o, shop s where o.shop_number = s.shop_number and o.order_stamp is not null ";
		String whereStatement2 = "group by s.shop_number order by o.order_saleprice asc";
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2);

			if (rs.next()) {

				String shop_name = rs.getString(1);
				int order_price = rs.getInt(2);

				dto = new HB_shopListDto(shop_name, order_price);
			}

			conn_mysql.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dto;
	}
	
	
	
	public HB_shopListDto allShopTodaySales() {
		
		HB_shopListDto dto = null;
		String whereStatement = "select s.shop_name, sum(o.order_saleprice) from orders o, shop s where o.shop_number = s.shop_number and o.order_stamp is not null ";
		String whereStatement2 = "and DATE(o.order_time) = curdate() group by s.shop_number order by o.order_saleprice desc";
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2);
			
			if (rs.next()) {
				
				String shop_name = rs.getString(1);
				int order_price = rs.getInt(2);
				
				dto = new HB_shopListDto(shop_name, order_price);
			}
			
			conn_mysql.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dto;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
} // End Line
