package com.javalec.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.javalec.util.DBConnect;

public class HS_StaffSignupDao {
	
	int staff_id;
	String staff_pw;
	String staff_name;
	String staff_telno;
	String staff_email;
	FileInputStream file;
	
	
	
	
	
	
	public HS_StaffSignupDao() {
		// TODO Auto-generated constructor stub
	}






	public HS_StaffSignupDao(int staff_id) {
		super();
		this.staff_id = staff_id;
	}






	public HS_StaffSignupDao(int staff_id, String staff_pw, String staff_name, String staff_telno, String staff_email,
			FileInputStream file) {
		super();
		this.staff_id = staff_id;
		this.staff_pw = staff_pw;
		this.staff_name = staff_name;
		this.staff_telno = staff_telno;
		this.staff_email = staff_email;
		this.file = file;
	}

	
	
	public int staffIdCheck() {
		int check = 0; 

		String query = "select count(*) from employee where employee_id = " + staff_id;

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
			return check;
		}
		return check; 

	}
	
	
	
public int staffSignUp() {
		
		int count = 0;
		
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			String query1 = "insert into employee (employee_id, employee_name, employee_pw, employee_telno, employee_email, employee_in_date, employee_image";
			String query2 = ") values (?,?,?,?,?,curdate(),?)";

			ps = conn_mysql.prepareStatement(query1 + query2);
			ps.setInt(1, staff_id);
			ps.setString(2, staff_name.trim());
			ps.setString(3, staff_pw.trim());
			ps.setString(4, staff_telno.trim());
			ps.setString(5, staff_email.trim());
			ps.setBinaryStream(6, file);

			ps.executeUpdate();

			conn_mysql.close();
			count++;
			
		} catch (Exception e) {
			e.printStackTrace();
			return count;
		}
		return count;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
