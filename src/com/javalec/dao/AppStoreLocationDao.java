package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.dto.AppStoreLocationDto;
import com.javalec.util.DBConnect;

public class AppStoreLocationDao {

	// Field
	int shop_number;
	String shop_name;
	String shop_address;
	String shop_telno;

	// Constructor
	public AppStoreLocationDao() {
		// TODO Auto-generated constructor stub
	}

	public AppStoreLocationDao(int shop_number, String shop_name, String shop_address, String shop_telno) {
		super();
		this.shop_number = shop_number;
		this.shop_name = shop_name;
		this.shop_address = shop_address;
		this.shop_telno = shop_telno;
	}
	
	public AppStoreLocationDao(String shop_name) {
		super();
		this.shop_name = shop_name;
	}
	
	

	public AppStoreLocationDao(int shop_number) {
		super();
		this.shop_number = shop_number;
	}
	
	

	public AppStoreLocationDao(int shop_number, String shop_name) {
		super();
		this.shop_number = shop_number;
		this.shop_name = shop_name;
	}

	// method-----------------
	

	// 지점 리스트 Db에서 가져오기 
	public ArrayList<AppStoreLocationDto> shopList() {
		// 연결
		ArrayList<AppStoreLocationDto> dtoList = new ArrayList<AppStoreLocationDto>(); // 3. 담은 데이터 arraylist 형식으로 가져와서
																						// 저장(매개체>>Main class로 보냄)
		// query문
		String whereStatement = "select shop_number, shop_name, shop_address, shop_telno from shop ";

		// 검색 포맷
		try { // error확인
				// connection
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql); // database에 접근을 하겠다. (선언자, 아직 실행 단계 x)
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement);
			// 1. 데이터값 가져오기
			while (rs.next()) { // 다음 값이null 이면 false로 되어서 while문이 끝난다.

				int wkshopNumber = rs.getInt(1); // column 이름 or column 번호 쓰면 됨
				String wkshopName = rs.getString(2); // column 이름 or column 번호 쓰면 됨
				String wkshopaddress = rs.getString(3);
				String wkshoptelno = rs.getString(4);

				// 2. instance에서 연결하고 데이터를 dto에 저장한다.
				AppStoreLocationDto dto = new AppStoreLocationDto(wkshopNumber, wkshopName, wkshopaddress, wkshoptelno); // 가져온
																															// 데이터
																															// 묶는
																															// 역할
				dtoList.add(dto); // 2. 입력된 데이터 dtoList에도 저장
			}

			conn_mysql.close(); // close 해야 다른 사람의 DB도 들어올 수 있다.

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dtoList;

	}
	
	
	//선택한 지점
	public AppStoreLocationDto tableClick() {

		AppStoreLocationDto dto = null; // dto 변수 선언

		String whereStatement = "select shop_name, shop_number from shop "; // statement, 스페이스
																										// 바 잊지 말
		String whereStatement2 = "where shop_number = " + shop_number;

		// 검색 포맷
		try { // error확인
			// connection
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql); // database에 접근을 하겠다. (선언자, 아직 실행 단계 x)
			Statement stmt_mysql = conn_mysql.createStatement();
			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2);

			while (rs.next()) { // 0: true, 1: false>> 0일때 데이터값이 있어서 데이터를 보여줄 수 잇다
			
				String wkShopName  = rs.getString(1);
			
				int wkShopNumber = rs.getInt(2);
				

				dto = new AppStoreLocationDto(wkShopName, wkShopNumber);

			}

			conn_mysql.close(); // close 해야 다른 사람의 DB도 들어올 수 있다.

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return dto; // while문 안에 있는 dto 변수에 들어간 데이터를 밖으로 갖고 오기 > Address class로 보내기
	}

}
