package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.dto.AppMenuDetailDto;
import com.javalec.dto.AppMenuListDto;
import com.javalec.dto.AppStoreLocationDto;
import com.javalec.util.DBConnect;

public class AppMenuListDao {

	int product_id;
	String product_name;
	String product_explain;
	int product_price;

	public AppMenuListDao() {
		// TODO Auto-generated constructor stub
	}

	public AppMenuListDao(int product_id, String product_name, int product_price) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_price = product_price;
	}

	public AppMenuListDao(String product_name, String product_explain, int product_price) {
		super();
		this.product_name = product_name;
		this.product_explain = product_explain;
		this.product_price = product_price;
	}
//
//	public AppMenuListDao(int product_id) {
//		super();
//		this.product_id = product_id;
//	}

	public AppMenuListDao(String product_name) {
		super();
		this.product_name = product_name;
	}

	public AppMenuListDao(int product_price) {
		super();
		this.product_price = product_price;
	}

	// 제품 Db에서 가져오기
	public ArrayList<AppMenuListDto> menuList() {
		// 연결
		ArrayList<AppMenuListDto> dtoList = new ArrayList<AppMenuListDto>(); // 3. 담은 데이터 arraylist 형식으로 가져와서
																				// 저장(매개체>>Main class로 보냄)
		// query문
		String whereStatement = "select product_id, product_name, product_price from product ";

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

				int wkproductId = rs.getInt(1); // column 이름 or column 번호 쓰면 됨
				String wkproductName = rs.getString(2); // column 이름 or column 번호 쓰면 됨
				int wkproductPrice = rs.getInt(3);

				// 2. instance에서 연결하고 데이터를 dto에 저장한다.
				AppMenuListDto dto = new AppMenuListDto(wkproductId, wkproductName, wkproductPrice);

				dtoList.add(dto); // 2. 입력된 데이터 dtoList에도 저장
			}

			conn_mysql.close(); // close 해야 다른 사람의 DB도 들어올 수 있다.

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return dtoList;

	}

}
