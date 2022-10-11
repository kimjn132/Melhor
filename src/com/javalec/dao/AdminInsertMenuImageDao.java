package com.javalec.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import com.javalec.util.DBConnect;

public class AdminInsertMenuImageDao {

	//fields
	FileInputStream file;
	String fileName;
	
	//constructor
	public AdminInsertMenuImageDao() {
		// TODO Auto-generated constructor stub
	}
	
	public AdminInsertMenuImageDao(FileInputStream file, String fileName) {
		super();
		this.file = file;
		this.fileName = fileName;
	}

	//method
	public boolean UpdateAction() {
	      PreparedStatement ps = null;
	      try{
	          Class.forName("com.mysql.cj.jdbc.Driver");
	          Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql,DBConnect.id_mysql,DBConnect.pw_mysql);
	          @SuppressWarnings("unused")
				Statement stmt_mysql = conn_mysql.createStatement();
	
	          String A = "update product set product_image = ?, product_image_filename = ? where product_id = 10";
	
	          ps = conn_mysql.prepareStatement(A);
	          
	          ps.setBinaryStream(1, file);
	          ps.setString(2, fileName);
	          ps.executeUpdate();
	
	          conn_mysql.close();
	      } catch (Exception e){
	          e.printStackTrace();
	          return false;
	      }
	      return true;
	}
	
}
