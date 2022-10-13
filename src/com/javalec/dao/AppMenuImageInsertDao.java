package com.javalec.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import com.javalec.util.DBConnect;

public class AppMenuImageInsertDao {

	String product_name;
	FileInputStream product_image;
	int product_price;
	String product_category;
	String product_recipe;
	String product_explain;

	public AppMenuImageInsertDao() {
		// TODO Auto-generated constructor stub
	}

	public AppMenuImageInsertDao(String product_name, FileInputStream product_image, int product_price,
			String product_recipe, String product_explain, String product_category) {
		super();
		this.product_name = product_name;
		this.product_image = product_image;
		this.product_price = product_price;
		this.product_recipe = product_recipe;
		this.product_explain = product_explain;
		this.product_category = product_category;
	}

	public boolean insertImage() {
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			@SuppressWarnings("unused")
			Statement stmt_mysql = conn_mysql.createStatement();

			String A = "insert into product (product_name, product_image, product_price, product_recipe, product_explain, product_category) ";
			String B = "value (?, ?, ?, ?, ?, ?) ";

			ps = conn_mysql.prepareStatement(A + B);
			ps.setString(1, product_name.trim());
			ps.setBinaryStream(2, product_image);
			ps.setInt(3, product_price);
			ps.setString(4, product_recipe);
			ps.setString(5, product_explain);
			ps.setString(6, product_category);

			ps.executeUpdate();

			conn_mysql.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
