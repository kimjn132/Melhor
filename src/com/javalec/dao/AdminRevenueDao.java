package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.dto.AdminRevenueDetailDto;
import com.javalec.dto.AdminRevenueDto;
import com.javalec.util.DBConnect;
import com.javalec.util.StaticClass;

public class AdminRevenueDao {

	// fields
	int number;
	String categoryColumn;
	int periodColumn;
	String tfSearch;

	// constructor
	public AdminRevenueDao() {
		// TODO Auto-generated constructor stub
	}

	public AdminRevenueDao(String categoryColumn, int periodColumn, String tfSearch) {
		super();
		this.categoryColumn = categoryColumn;
		this.periodColumn = periodColumn;
		this.tfSearch = tfSearch;
	}

	// method
	// 조건 검색 =======================================================
	public ArrayList<AdminRevenueDto> monthDayAvg() {

		ArrayList<AdminRevenueDto> dtoList = new ArrayList<AdminRevenueDto>();
		// 3. 담은 데이터 arraylist 형식으로 가져와서 연결(매개체>>Main class로 보냄)

		String query1 = "select p.product_id, product_name, product_category, ";
		String query2 = "sum(order_quantity)/30, sum(order_saleprice*order_quantity)/30, ";
		String query3 = "sum(order_quantity), sum(order_saleprice*order_quantity) ";
		String query4 = "from orders o, product p, shop s where o.product_id = p.product_id and o.shop_number = s.shop_number and o.order_stamp is not null  ";
		String query5 = "and order_time > (now() - interval 1 month) and o.shop_number = " +StaticClass.shop_number+ "  ";
		String query6 = "group by o.product_id order by sum(order_quantity)/30 desc ";

		// 검색 포맷
		try { // error확인
				// connection
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql); // database에 접근을 하겠다. (선언자, 아직 실행 단계 x)
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(query1 + query2 + query3 + query4 + query5 + query6);
			// 1. 데이터값 입력
			while (rs.next()) { // 다음 값이 null이면(row가 없으면) false로 되어서 while문이 끝난다.

				int wkId = rs.getInt(1); // 데이터 하나씩 한줄로 가져오기
				String wkName = rs.getString(2); // column 이름 or column 번호 쓰면 됨
				String wkCategory = rs.getString(3);
				double wkAvgQuantity = rs.getDouble(4);
				double wkAvgSales = rs.getDouble(5);
				double wkAvgMonthQuantity = rs.getDouble(6);
				double wkAvgMonthSales = rs.getDouble(7);
				
				// 2. 입력된 데이터 DTO클래스에 저장
				AdminRevenueDto dto = new AdminRevenueDto(wkId, wkName, wkCategory, wkAvgQuantity, wkAvgSales, wkAvgMonthQuantity, wkAvgMonthSales);
				// 가져온 데이터 묶는 역할
				// rs.next()로 포인터를 1씩 옮길 때마다 instance를 생성하고 밑의 dtoList에 하나씩 저장

				dtoList.add(dto); // 2. 입력된 데이터 dtoList에도 저장
			}

			conn_mysql.close(); // close 해야 다른 사람의 DB도 들어올 수 있다.

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dtoList;

	}
	
	// 콤보박스 조건 검색 ----------------------------
	public ArrayList<AdminRevenueDto> conditionList() {

		ArrayList<AdminRevenueDto> dtoList = new ArrayList<AdminRevenueDto>();

		String whereStatement = "select o.product_id, product_name, product_category, sum(order_quantity)/(30*" +periodColumn+ "), sum(order_saleprice*order_quantity)/(30*" +periodColumn+ "), sum(order_quantity)/(1*" +periodColumn+ "), sum(order_saleprice*order_quantity)/(1*" +periodColumn+ ") " ;
		String whereStatement2 = "from orders o, product p, shop s where o.product_id = p.product_id and o.shop_number = s.shop_number  and o.order_stamp is not null ";
		String whereStatement3 = "and " +categoryColumn+ " like '%" +tfSearch+ "%' and order_time > (now() - interval " +periodColumn+ " month) and o.shop_number = " +StaticClass.shop_number+ " group by o.product_id order by sum(order_quantity)/30 desc ";
		
		// 검색 포맷
		try { // error확인
			// connection
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,DBConnect.pw_mysql); // database에 접근을 하겠다. (선언자, 아직 실행 단계 x)
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2 + whereStatement3);
			// next(): true/false,
			
			
			while (rs.next()) { // 다음 값이null 이면 false로 되어서 while문이 끝난다.
				
				int wkId = rs.getInt(1); // 데이터 하나씩 한줄로 가져오기
				String wkName = rs.getString(2); // column 이름 or column 번호 쓰면 됨
				String wkCategory = rs.getString(3);
				double wkAvgQuantity = rs.getDouble(4);
				double wkAvgSales = rs.getDouble(5);
				double wkAvgMonthQuantity = rs.getDouble(6);
				double wkAvgMonthSales = rs.getDouble(7);
				
				System.out.println("wkM: " +wkAvgMonthQuantity);
				
				AdminRevenueDto dto = new AdminRevenueDto(wkId, wkName, wkCategory, wkAvgQuantity, wkAvgSales, wkAvgMonthQuantity, wkAvgMonthSales); // 가져온 데이터 묶는 역할
				dtoList.add(dto);
			}
			
			conn_mysql.close(); // close 해야 다른 사람의 DB도 들어올 수 있다.

			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}//END
