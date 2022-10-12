package com.javalec.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.dto.AppTodayMenuDto;
import com.javalec.util.DBConnect;

public class AppTodayMenuDao {

	int sum;
	
	public AppTodayMenuDao() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public AppTodayMenuDao(int sum) {
		super();
		this.sum = sum;
	}


	public ArrayList<AppTodayMenuDto> bestProductConditionList() {
		
		ArrayList<AppTodayMenuDto> bestProduct = new ArrayList<AppTodayMenuDto>();

		String whereStatement = "select sum(o.order_quantity) from orders o, product p ";
		String whereStatement2 = "where p.product_id = o.product_id group by o.product_id order by sum(o.order_quantity) desc;";

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2);

			while (rs.next()) {

				int todayMenu = rs.getInt(1);

				AppTodayMenuDto dto = new AppTodayMenuDto(todayMenu);
				
				bestProduct.add(dto);

			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return bestProduct;
	}
	
	public AppTodayMenuDto todayMenuSearch() {
		
		AppTodayMenuDto dto = null;
		
		String whereStatement = "select p.product_price, p.product_explain, p.product_image from product p, orders o ";
		String whereStatement2 = "where p.product_id = o.product_id group by p.product_id having sum(o.order_quantity) = " + sum;
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2);

			if (rs.next()) {

				int price = rs.getInt(1);
                String explain = rs.getString(2);
				
				// 이미지 불러오기
				DBConnect.filename = DBConnect.filename + 1;
            	File file = new File(Integer.toString(DBConnect.filename));
            	FileOutputStream output = new FileOutputStream(file);
            	InputStream employee_image = rs.getBinaryStream(3);
                byte[] buffer = new byte[1024];
                while (employee_image.read(buffer) > 0) {
                    output.write(buffer);
                }
                // 이미지 불러오기
                
				dto = new AppTodayMenuDto(price, explain);
			}

			conn_mysql.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}

		return dto;
	}
	
}
