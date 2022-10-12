package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.dto.AdminMenuInsertDto;
import com.javalec.util.DBConnect;
import com.javalec.util.StaticClass;

public class AdminMenuInsertDao {
	
	//fields
	int product_id;
	String conname;
	String condata;
	
	//constructor
	public AdminMenuInsertDao() {
		// TODO Auto-generated constructor stub
	}
	
	public AdminMenuInsertDao(String conname, String condata) {
		super();
		this.conname = conname;
		this.condata = condata;
	}

	public AdminMenuInsertDao(int product_id) {
		super();
		this.product_id = product_id;
	}

	//-------------------------method--------------------------

	//1. selectList()
	public ArrayList<AdminMenuInsertDto> selectList() {

		ArrayList<AdminMenuInsertDto> dtoList = new ArrayList<AdminMenuInsertDto>(); 
		// 3. 담은 데이터 arraylist 형식으로 가져와서 연결(매개체>>Main class로 보냄)

		String whereStatement = "select product_id, product_category, product_name, product_price from product"; // statement

		// 검색 포맷
		try { // error확인
			
			// connection
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql); 
		
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement);
			// 1. 데이터값 입력
			while (rs.next()) { // 다음 값이null 이면 false로 되어서 while문이 끝난다.

				int wkProductId = rs.getInt(1); // 데이터 하나씩 한줄로 가져오기
				String wkProductCategory = rs.getString(2); // column 이름 or column 번호 쓰면 됨
				String wkProductName = rs.getString(3);
				int wkProductPrice = rs.getInt(4);

				// 2. 입력된 데이터 DTO클래스에 저장
				AdminMenuInsertDto adminMenuInsertDto = new AdminMenuInsertDto(wkProductId, wkProductCategory, wkProductName, wkProductPrice); 
				// 가져온 데이터 묶는 역할
				//rs.next()로 포인터를 1씩 옮길 때마다 instance를 생성하고 밑의 dtoList에 하나씩 저장 
				
				dtoList.add(adminMenuInsertDto); // 2. 입력된 데이터 dtoList에도 저장
			}

			conn_mysql.close(); // close 해야 다른 사람의 DB도 들어올 수 있다.

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dtoList;

	}
	
	//3. conditionList 일부 글자 검색--------------------------
	public ArrayList<AdminMenuInsertDto> conditionList() {

		ArrayList<AdminMenuInsertDto> dtoList = new ArrayList<AdminMenuInsertDto>();

		String whereStatement = "select product_id, product_category, product_name, product_price from product "; // statement
		String whereStatement2 = "where " + conname + " like '%" + condata + "%'"; // statement spacebar 제발..
		
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

				int wkProductId = rs.getInt(1); // 데이터 하나씩 한줄로 가져오기
				String wkProductCategory = rs.getString(2); // column 이름 or column 번호 쓰면 됨
				String wkProductName = rs.getString(3);
				int wkProductPrice = rs.getInt(4);

				AdminMenuInsertDto adminMenuInsertDto = new AdminMenuInsertDto(wkProductId, wkProductCategory, wkProductName, wkProductPrice); // 가져온 데이터 묶는 역할
				dtoList.add(adminMenuInsertDto);
			}

			conn_mysql.close(); // close 해야 다른 사람의 DB도 들어올 수 있다.

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dtoList;

	}
	
	// 4. product_id 가져오기 
	public void productPk() {
		StaticClass.product_id = product_id;
	}
	
	public ArrayList<AdminMenuInsertDto> ascendingBest() {

		ArrayList<AdminMenuInsertDto> dtoList = new ArrayList<AdminMenuInsertDto>(); 
		// 3. 담은 데이터 arraylist 형식으로 가져와서 연결(매개체>>Main class로 보냄)

		String whereStatement = "select p.product_id, product_category, product_name, product_price, sum(order_quantity) from product p, orders o "; // statement
		String whereStatement1 = "where o.product_id = p.product_id group by product_id order by sum(order_quantity) desc ";
		
		// 검색 포맷
		try { // error확인
			// connection
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql); // database에 접근을 하겠다. (선언자, 아직 실행 단계 x)
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement1);
			// 1. 데이터값 입력
			while (rs.next()) { // 다음 값이 null이면(row가 없으면) false로 되어서 while문이 끝난다.

				int wkId = rs.getInt(1); // 데이터 하나씩 한줄로 가져오기
				String wkCategory = rs.getString(2); // column 이름 or column 번호 쓰면 됨
				String wkName = rs.getString(3);
				int wkPrice = rs.getInt(4);

				// 2. 입력된 데이터 DTO클래스에 저장
				AdminMenuInsertDto dto = new AdminMenuInsertDto(wkId, wkCategory, wkName, wkPrice); 
				// 가져온 데이터 묶는 역할
				//rs.next()로 포인터를 1씩 옮길 때마다 instance를 생성하고 밑의 dtoList에 하나씩 저장 
				
				dtoList.add(dto); // 2. 입력된 데이터 dtoList에도 저장
			}

			conn_mysql.close(); // close 해야 다른 사람의 DB도 들어올 수 있다.

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dtoList;

	}
	public ArrayList<AdminMenuInsertDto> monthBestAscending() {
		
		ArrayList<AdminMenuInsertDto> dtoList = new ArrayList<AdminMenuInsertDto>(); 
		// 3. 담은 데이터 arraylist 형식으로 가져와서 연결(매개체>>Main class로 보냄)
		
		String whereStatement = "select p.product_id, product_category, product_name, product_price, sum(order_quantity) from product p, orders o "; // statement
		String whereStatement1 = "where o.product_id = p.product_id and o.order_stamp is not null and order_time > (now() - interval 1 month) ";
		String whereStatement2 = "group by product_id order by sum(order_quantity) desc ";
		
		// 검색 포맷
		try { // error확인
			// connection
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql); // database에 접근을 하겠다. (선언자, 아직 실행 단계 x)
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement1 + whereStatement2);
			// 1. 데이터값 입력
			while (rs.next()) { // 다음 값이 null이면(row가 없으면) false로 되어서 while문이 끝난다.
				
				int wkId = rs.getInt(1); // 데이터 하나씩 한줄로 가져오기
				String wkCategory = rs.getString(2); // column 이름 or column 번호 쓰면 됨
				String wkName = rs.getString(3);
				int wkPrice = rs.getInt(4);
				
				// 2. 입력된 데이터 DTO클래스에 저장
				AdminMenuInsertDto dto = new AdminMenuInsertDto(wkId, wkCategory, wkName, wkPrice); 
				// 가져온 데이터 묶는 역할
				//rs.next()로 포인터를 1씩 옮길 때마다 instance를 생성하고 밑의 dtoList에 하나씩 저장 
				
				dtoList.add(dto); // 2. 입력된 데이터 dtoList에도 저장
			}
			
			conn_mysql.close(); // close 해야 다른 사람의 DB도 들어올 수 있다.
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dtoList;
		
	}
	
}//END
