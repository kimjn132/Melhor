package com.javalec.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import com.javalec.util.DBConnect;

public class HB_ManagerAppointDao {

	String name;
	String telno;
	String email;
	FileInputStream file;
	
	public HB_ManagerAppointDao() {
		// TODO Auto-generated constructor stub
	}

	public HB_ManagerAppointDao(String name, String telno, String email, FileInputStream file) {
		super();
		this.name = name;
		this.telno = telno;
		this.email = email;
		this.file = file;
	}
	

	public int managerAppointment() {
		int count = 0;

		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			String query1 = "insert into employee (employee_name, employee_telno, employee_email, employee_image, employee_role, employee_in_date";
			String query2 = ") values (?,?,?,?,1,now())";

			ps = conn_mysql.prepareStatement(query1 + query2);
			ps.setString(1, name.trim());
			ps.setString(2, telno.trim());
			ps.setString(3, email.trim());
			ps.setBinaryStream(4, file);

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
