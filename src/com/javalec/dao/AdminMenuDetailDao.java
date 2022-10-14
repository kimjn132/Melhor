package com.javalec.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.javalec.dto.AdminMenuDetailDto;
import com.javalec.util.DBConnect;
import com.javalec.util.StaticClass;

public class AdminMenuDetailDao {

	// fields

	// constructor
	public AdminMenuDetailDao() {
		// TODO Auto-generated constructor stub
	}

	public AdminMenuDetailDao(int product_id) {
		super();
	}

	// method

	// 화면 키면 정보 세팅 -------------------------------
	public AdminMenuDetailDto settingInfo() {
		AdminMenuDetailDto dto = null; // 왜????

		String whereStatement = "select product_id, product_name, product_category, product_price, product_recipe, product_explain, product_image ";
		String whereStatement2 = "from product where product_id = " + StaticClass.product_id;
		
		// 검색 포맷
			try { // error확인
				// connection
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
						DBConnect.pw_mysql); // database에 접근을 하겠다. (선언자, 아직 실행 단계 x)

				//
				Statement stmt_mysql = conn_mysql.createStatement();

				ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2);

				while (rs.next()) {

					int wkId = rs.getInt(1);
					String wkName = rs.getString(2);
					String wkCategory = rs.getString(3);
					int wkPrice = rs.getInt(4);
					String wkRecipe = rs.getString(5);
					String wkExplain = rs.getString(6);
					
					//file
					StaticClass.filename = StaticClass.filename + 1;
	            	File file = new File(Integer.toString(StaticClass.filename));
	            	FileOutputStream output = new FileOutputStream(file);
	            	InputStream input = rs.getBinaryStream(7);
	                byte[] buffer = new byte[1024];
	                while (input.read(buffer) > 0) {
	                    output.write(buffer);
	                }

					dto = new AdminMenuDetailDto(wkId, wkName, wkCategory, wkPrice, wkRecipe, wkExplain);

				}
				
				conn_mysql.close(); // close 해야 다른 사람의 DB도 들어올 수 있다.

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return dto;
	}
	
	// 등록된 메뉴인지 카운트로 확인 (0이면 아니고 1이면 맞음)
	public AdminMenuDetailDto menuRegisterCheck() {
		AdminMenuDetailDto dto = null; // 왜????

		String whereStatement = "select count(*) from register where product_id = " +StaticClass.product_id+ " and shop_number = " +StaticClass.shop_number+ " ";
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

				int wkCount = 0;
				
				while (rs.next()) {

					wkCount = rs.getInt(1);
					
					dto = new AdminMenuDetailDto(wkCount);

				}
				
				conn_mysql.close(); // close 해야 다른 사람의 DB도 들어올 수 있다.

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return dto;
	}

	// 메뉴 등록 -----------------------------------------------
	
	// 등록된 메뉴 개수 select -------------------------
	public AdminMenuDetailDto menuCount() {
		AdminMenuDetailDto dto = null; // 왜????

		String whereStatement = "select count(*) from register where register_out_date is null";
		
		// 검색 포맷
			try { // error확인
				// connection
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
						DBConnect.pw_mysql); // database에 접근을 하겠다. (선언자, 아직 실행 단계 x)

				Statement stmt_mysql = conn_mysql.createStatement();

				ResultSet rs = stmt_mysql.executeQuery(whereStatement);

				while (rs.next()) {

					int wkCount = rs.getInt(1);
					
					dto = new AdminMenuDetailDto(wkCount);

				}
				
				conn_mysql.close(); // close 해야 다른 사람의 DB도 들어올 수 있다.

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return dto;
	}
	
	// update delete date
	
	
	
	
	public Boolean updateDelDate() {
		PreparedStatement ps = null;

		try { // error확인

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql); // database에 접근을 하겠다. (선언자, 아직 실행 단계 x)
			// Statement stmt_mysql = conn_mysql.createStatement();

			// 쿼리 문장 만들기 (preparestatement)
			String query = "update register set register_out_date = curdate() where register_id = " +StaticClass.register_id+ " ";

			// 위의 쿼리 문장대로 순서대로 쓴다.
			ps = conn_mysql.prepareStatement(query);// insert(), value()

			ps.executeUpdate(); // insert update method 이거 하나밖에 없다

			conn_mysql.close(); // close 해야 다른 사람의 DB도 들어올 수 있다.

			// JOptionPane.showMessageDialog(null, name + "님의 정보가 수정되었습니다.");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		return true;

	}
	
	
	
	public int insertRegister() {
		int check = 0;
		PreparedStatement ps = null;
		try { // error확인
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql); // database에 접근을 하겠다. (선언자, 아직 실행 단계 x)
			// Statement stmt_mysql = conn_mysql.createStatement();
			
			// 쿼리 문장 만들기 (preparestatement)
			String query = "insert into register (employee_id, product_id, shop_number, register_in_date) ";
			String query2 = "values (?, ?, ?, curdate()) ";
			
			// 위의 쿼리 문장대로 순서대로 쓴다.
			ps = conn_mysql.prepareStatement(query + query2);// insert(), value()
			
			ps.setInt(1, StaticClass.employee_id); // 1번 >> name
			ps.setString(2, Integer.toString(StaticClass.product_id));
			ps.setString(3, Integer.toString(StaticClass.shop_number));
			
			check =  ps.executeUpdate();
			
			conn_mysql.close(); // close 해야 다른 사람의 DB도 들어올 수 있다.
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			check++;
		}
		return check;
	}
	
	
	
	
	

}// END
