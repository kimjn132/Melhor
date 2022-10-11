package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.dto.AdminRevenueDetailDto;
import com.javalec.util.DBConnect;
import com.javalec.util.StaticClass;

public class AdminRevenueDetailDao {

	// fields

	// constructor
	public AdminRevenueDetailDao() {
		// TODO Auto-generated constructor stub
	}

	// method===============================================================
	// 제품 상세 정보 select 
	public AdminRevenueDetailDto productDetail() {

		AdminRevenueDetailDto dto = null; 

		String whereStatement = "select product_id, product_name, product_category, product_price ";
		String whereStatement2 = "from product where product_id = " +StaticClass.product_id;

		// 검색 포맷
		try { // error확인
				// connection
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql); // database에 접근을 하겠다. (선언자, 아직 실행 단계 x)

			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2);

			while (rs.next()) {

				int wkId = rs.getInt(1);
				String wkName = rs.getString(2);
				String wkCategory = rs.getString(3);
				int wkPrice = rs.getInt(4);

				dto = new AdminRevenueDetailDto(wkId, wkName, wkCategory, wkPrice);

			}

			conn_mysql.close(); // close 해야 다른 사람의 DB도 들어올 수 있다.

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dto;
	}
	
	// 제품 일 평균 수량
	public AdminRevenueDetailDto dayQuatityAvg() {
		
		AdminRevenueDetailDto dto = null; 
		
		String whereStatement = "select sum(order_quantity)/datediff(curdate(), '" +StaticClass.shop_open_date+ "') from orders o, product p, shop s ";
		String whereStatement2 = "where o.product_id = p.product_id and o.shop_number = s.shop_number ";
		String whereStatement3 = "and o.shop_number = " +StaticClass.shop_number+ " and o.product_id = " +StaticClass.product_id+ " and order_time > " +StaticClass.shop_open_date;
		
		// 검색 포맷
		try { // error확인
			// connection
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql); // database에 접근을 하겠다. (선언자, 아직 실행 단계 x)
			
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2 + whereStatement3);
			
			while (rs.next()) {
				
				double wkDayQuantity = rs.getInt(1);
				
				
				dto = new AdminRevenueDetailDto(wkDayQuantity);
				
			}
			
			conn_mysql.close(); // close 해야 다른 사람의 DB도 들어올 수 있다.
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dto;
	}
	
	// 월 평균 수량
	
	public ArrayList<AdminRevenueDetailDto> selectList() {

		ArrayList<AdminRevenueDetailDto> dtoList = new ArrayList<AdminRevenueDetailDto>(); 
		// 3. 담은 데이터 arraylist 형식으로 가져와서 연결(매개체>>Main class로 보냄)

		String whereStatement = "select avg(order_quantity) from orders o, product p, shop s "; // statement
		String whereStatement1 = "where o.product_id = p.product_id and o.shop_number = s.shop_number ";
		String whereStatement2 = "and o.shop_number = " +StaticClass.shop_number+ " and o.product_id = " +StaticClass.product_id+ " and o.order_stamp is not null group by Month(o.order_time)";
		
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

				int wkAvg = rs.getInt(1); // 데이터 하나씩 한줄로 가져오기

				// 2. 입력된 데이터 DTO클래스에 저장
				AdminRevenueDetailDto dto = new AdminRevenueDetailDto(wkAvg); 
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

	
	
	

}// END
