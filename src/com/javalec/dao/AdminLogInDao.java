package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import com.javalec.util.DBConnect;
import com.javalec.util.StaticClass;


public class AdminLogInDao {
	
	//fields
	int employee_id;
	String employee_pw;
	
	//construct
	public AdminLogInDao() {
		// TODO Auto-generated constructor stub
	}

	public AdminLogInDao(int employee_id, String employee_pw) {
		super();
		this.employee_id = employee_id;
		this.employee_pw = employee_pw;
	}
	
	//method

	// 로그인 체크 메소드
	public int loginCheck() {
		int check = 0;
		String query1 = "select count(*) from employee ";
		String query2 = "where employee_id = '" + employee_id + "'  and employee_pw = '" + employee_pw + "' and employee_role = 1";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			ResultSet rs = stmt_mysql.executeQuery(query1 + query2);

			while (rs.next()) {
				if(Integer.parseInt(rs.getString(1)) == 1) {
					check++;
				}
			}
			
			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
			return check;
		}
		return check;
	}
	
	// 스태틱에 employee 이름
	public String emName() {
		String query1 = "select employee_name from employee ";
		String query2 = "where employee_id = '" +employee_id+ "'";
		String nameRs = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(query1 + query2);
			while (rs.next()) {
				nameRs = rs.getString(1);
			}
			
			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
			return nameRs;
		}
		return nameRs;
	}
	
	// employee_id로 shop_name 가져와서 static에 넣어주기
	public String shopName() {
		String query1 = "select shop_name from shop ";
		String query2 = "where shop_employee_id = " + StaticClass.employee_id;
		String rsShopName = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(query1 + query2);
			while (rs.next()) {
				rsShopName = rs.getString(1);
			}
			
			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
			return rsShopName;
		}
		return rsShopName;
		
	}
	
	// static에 shopnum 추가
	public String shopNum() {
		String query1 = "select shop_number from shop ";
		String query2 = "where shop_employee_id = " + StaticClass.employee_id;
		String rsShopNumber = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(query1 + query2);
			while (rs.next()) {
				rsShopNumber = rs.getString(1);
			}
			
			conn_mysql.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			return rsShopNumber;
		}
		return rsShopNumber;
		
	}
	
	// static에 개업일 넣어주기 
	
	public String shopOpenDate() {
		String query1 = "select manage_shop_open_date from manage m, shop s ";
		String query2 = "where m.shop_number = s.shop_number and s.shop_number = " + StaticClass.shop_number;
		String rsShopNumber = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(query1 + query2);
			while (rs.next()) {
				rsShopNumber = rs.getString(1);
			}
			
			conn_mysql.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			return rsShopNumber;
		}
		return rsShopNumber;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}//END
