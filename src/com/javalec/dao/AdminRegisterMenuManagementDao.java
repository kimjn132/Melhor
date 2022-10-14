package com.javalec.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTextField;

import com.javalec.dto.AdminMenuDetailDto;
import com.javalec.dto.AdminRegisterMenuManagementDto;
import com.javalec.util.DBConnect;
import com.javalec.util.StaticClass;

public class AdminRegisterMenuManagementDao {

	// fields
	String column;
	String tfSearch;

	// constructor
	public AdminRegisterMenuManagementDao() {
		// TODO Auto-generated constructor stub
	}

	public AdminRegisterMenuManagementDao(String column, String tfSearch) {
		super();
		this.column = column;
		this.tfSearch = tfSearch;
	}

	// method

	public ArrayList<AdminRegisterMenuManagementDto> SelectList() {

		ArrayList<AdminRegisterMenuManagementDto> BeanList = new ArrayList<AdminRegisterMenuManagementDto>();
		String whereStatement = "select p.product_image_filename, p.product_id, p.product_category, p.product_name, p.product_price, p.product_image from product p, register r, shop s ";
		String whereStatement1 = "where r.product_id = p.product_id and r.shop_number = s.shop_number and r.shop_number = " +StaticClass.shop_number+ " ";
		String whereStatement2 = "and register_in_date is not null and register_out_date is null order by product_id ";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement1 + whereStatement2);

			while (rs.next()) {

				String wkFilename = rs.getString(1);
				int wkId = rs.getInt(2);
				String wkCategory = rs.getString(3);
				String wkName = rs.getString(4);
				int wkPrice = rs.getInt(5);

				// File
				File file = new File("./" + wkFilename);
				FileOutputStream output = new FileOutputStream(file);
				InputStream input = rs.getBinaryStream(6);
				byte[] buffer = new byte[1024];
				while (input.read(buffer) > 0) {
					output.write(buffer);
				}

				AdminRegisterMenuManagementDto dto = new AdminRegisterMenuManagementDto(wkFilename, wkId, wkCategory,
						wkName, wkPrice);
				BeanList.add(dto);
			}

			conn_mysql.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return BeanList;
	}

	public ArrayList<AdminRegisterMenuManagementDto> conditionList() {

		ArrayList<AdminRegisterMenuManagementDto> dtoList = new ArrayList<AdminRegisterMenuManagementDto>();

		String whereStatement = "select product_image_filename, product_id, product_category, product_name, product_price, product_image ";
		String whereStatement2 = "from product where " + column + " like '%" + tfSearch + "%'"; // statement spacebar 제발..

		// 검색 포맷
		try { // error확인
				// connection
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql); // database에 접근을 하겠다. (선언자, 아직 실행 단계 x)
			//
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2);
			// next(): true/false,
			while (rs.next()) { // 다음 값이null 이면 false로 되어서 while문이 끝난다.

				String wkFilename = rs.getString(1);
				int wkId = rs.getInt(2);
				String wkCategory = rs.getString(3);
				String wkName = rs.getString(4);
				int wkPrice = rs.getInt(5);

				// File
				File file = new File("./" + wkFilename);
				FileOutputStream output = new FileOutputStream(file);
				InputStream input = rs.getBinaryStream(6);
				byte[] buffer = new byte[1024];
				while (input.read(buffer) > 0) {
					output.write(buffer);
				}

				AdminRegisterMenuManagementDto dto = new AdminRegisterMenuManagementDto(wkFilename, wkId, wkCategory,
						wkName, wkPrice);
				dtoList.add(dto);
			}

			conn_mysql.close(); // close 해야 다른 사람의 DB도 들어올 수 있다.

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dtoList;

	}
	
	// 등록된 메뉴 개수 구하는 메소드
	public AdminRegisterMenuManagementDto menuCount() {
		AdminRegisterMenuManagementDto dto = null; // 왜????

		String whereStatement = "select count(*) from register r, shop s where register_out_date is null ";
		String whereStatement1 = "and r.shop_number = s.shop_number and s.shop_number = " +StaticClass.shop_number+ " ";
		
		// 검색 포맷
			try { // error확인
				// connection
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
						DBConnect.pw_mysql); // database에 접근을 하겠다. (선언자, 아직 실행 단계 x)

				//
				Statement stmt_mysql = conn_mysql.createStatement();

				ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement1);

				while (rs.next()) {

					int wkCount = rs.getInt(1);
					
					dto = new AdminRegisterMenuManagementDto(wkCount);

				}
				
				conn_mysql.close(); // close 해야 다른 사람의 DB도 들어올 수 있다.

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return dto;
	}
	
	
	public AdminRegisterMenuManagementDto registerId() {
		AdminRegisterMenuManagementDto dto = null; // 왜????
		
		String whereStatement = "select register_id from register where product_id = " +StaticClass.product_id+ " ";
		String whereStatement1 = "and register_in_date is not null and register_out_date is null ";
		
		// 검색 포맷
		try { // error확인
			// connection
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql); // database에 접근을 하겠다. (선언자, 아직 실행 단계 x)
			
			//
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement1);
			
			while (rs.next()) {
				
				int wkCount = rs.getInt(1);
				
				dto = new AdminRegisterMenuManagementDto(wkCount);
				
			}
			
			conn_mysql.close(); // close 해야 다른 사람의 DB도 들어올 수 있다.
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dto;
	}
	
	
	
	
	
	
	
	

}// END
