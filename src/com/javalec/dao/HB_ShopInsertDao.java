package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.javalec.util.DBConnect;

public class HB_ShopInsertDao {

	int employee_id;
	String shop_name;
	String shop_address;
	String shop_telno;
	
	
	public HB_ShopInsertDao() {
		// TODO Auto-generated constructor stub
	}

	
	// employeeIdCheck()
	public HB_ShopInsertDao(int employee_id) {
		super();
		this.employee_id = employee_id;
	}

	// shopDataCheck()
	public HB_ShopInsertDao(String shop_name, String shop_address, String shop_telno) {
		super();
		this.shop_name = shop_name;
		this.shop_address = shop_address;
		this.shop_telno = shop_telno;
	}
	
	// shopInsert()
	public HB_ShopInsertDao(int employee_id, String shop_name, String shop_address, String shop_telno) {
		super();
		this.employee_id = employee_id;
		this.shop_name = shop_name;
		this.shop_address = shop_address;
		this.shop_telno = shop_telno;
	}
	
	
	
	public int employeeIdCheck() {

		int check = 0;
		// 전달 받은 값으로 count 출력 1 또는 0
		String query = "select count(*) from employee where employee_role = 1 and employee_id = " + employee_id;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			ResultSet rs = stmt_mysql.executeQuery(query);

			while (rs.next()) {
				check = rs.getInt(1);
			}
			
			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
			return check; // insert 실패하면 0 return
		}
		return check; // insert 성공하면 1 return

	}


	public int shopDataCheck() {
		
		int check = 0;
		// where문에서 3개의 조건이 전부 등록이 되어있지 않으면 count는 0을 return 
		// 하나라도 등록되어 있으면 1이상의 값을 return
		String query1 = "select count(*) from shop where shop_name = '" + shop_name + "' || shop_address = '" + shop_address + "' || shop_telno = '" + shop_telno + "'";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			ResultSet rs = stmt_mysql.executeQuery(query1);
			
			while (rs.next()) {
				
				check = rs.getInt(1);
				
			}
			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
			return check;
		}
		return check;

	}
	
	public int shopInsert() {
		PreparedStatement ps = null;
		int check = 0;
		
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			String query = "insert into shop (shop_employee_id, shop_name, shop_address, shop_telno) ";
			String query1 = "values (?,?,?,?)";

			ps = conn_mysql.prepareStatement(query + query1);
			ps.setInt(1, employee_id);
			ps.setString(2, shop_name);
			ps.setString(3, shop_address);
			ps.setString(4, shop_telno);

			check = ps.executeUpdate();

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
			return check;
		}
		return check;
	
	}
	
}
