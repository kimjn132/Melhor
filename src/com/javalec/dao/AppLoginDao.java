package com.javalec.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.javalec.util.DBConnect;

public class AppLoginDao {

	// ----------------------fields-----------------------------

	String custId;
	String custPw;
	String customer_nickname;

	// -----------------------constructor------------------------
	public AppLoginDao() {
		// TODO Auto-generated constructor stub
	}

	public AppLoginDao(String custId, String custPw) {
		super();
		this.custId = custId;
		this.custPw = custPw;
	}


	public AppLoginDao(String customer_nickname) {
		super();
		this.customer_nickname = customer_nickname;
	}

	// --------------------------method--------------------------
	public int loginCheck() {
		int check = 1;
		String query1 = "select count(*) from customer ";
		String query2 = "where customer_id = '" + custId + "'  and customer_pw = '" + custPw + "'";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			ResultSet rs = stmt_mysql.executeQuery(query1 + query2);

			while (rs.next()) {
				check = Integer.parseInt(rs.getString(1));
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
			return check = 0;
		}
		return check;

	}
	
	public String bringNickname() {
		String check = null;
		String query1 = "select customer_nickname from customer ";
		String query2 = "where customer_id = '" + custId + "' " ;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			ResultSet rs = stmt_mysql.executeQuery(query1 + query2);

			while (rs.next()) {
				check = rs.getString(1);
			
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return check;
	}
	
	

}
