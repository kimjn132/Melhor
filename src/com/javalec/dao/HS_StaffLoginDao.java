package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.dto.HS_StaffLoginDto;
import com.javalec.dto.HS_StaffMypageDto;
import com.javalec.util.DBConnect;
import com.javalec.util.HS_Static_StaffId;
import com.javalec.util.Static_CustomerId;

public class HS_StaffLoginDao {

	String staffId;
	String staffPw;

	String shop_name;

	public HS_StaffLoginDao(String shop_name) {
		super();
		this.shop_name = shop_name;
	}

	public HS_StaffLoginDao() {
		// TODO Auto-generated constructor stub
	}

	public HS_StaffLoginDao(String staffId, String staffPw) {
		super();
		this.staffId = staffId;
		this.staffPw = staffPw;
	}

	public int staffLoginCheck() {

		int check = 0;

		String query1 = "select count(*) from employee ";
		String query2 = "where employee_shop_number = " + HS_Static_StaffId.getShop_number() + " and employee_id = "
				+ staffId + "  and employee_pw = '" + staffPw + "'";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);

			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(query1 + query2);

			while (rs.next()) {

				check = rs.getInt(1);

			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
			return check;
		}
		return check;

	}

	private void staffVisibleAction() {

		String whereStatement = "select employee_name, employee_telno, employee_email, employee_pw from employee ";
		String whereStatement2 = "where employee_id = " + HS_Static_StaffId.staff_Id;

		try { // error확인

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql); // database에 접근을 하겠다. (선언자, 실행 x)
			Statement stmt_mysql = conn_mysql.createStatement(); // Connection conn_mysql 인스턴스를 이용해서 Statement 객체 생성

			/*
			 * ResultSet - 결과값을 저장할 수 있다 - 저장된 값을 한 행 단위로 불러올 수 있다 - 한 행에서 값을 가져올 때는 타입을 지정해
			 * 불러올 수 있다.
			 */
			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2);

			String tfNameupdate = rs.getString(1);
			String tfTelnoupdate = rs.getString(2);
			String tfemailupdate = rs.getString(3);
			String tfpwupdate = rs.getString(4);

			HS_StaffMypageDto hs_staffmypagedto = new HS_StaffMypageDto(tfNameupdate, tfTelnoupdate, tfemailupdate,
					tfpwupdate);

			conn_mysql.close(); // close 해야 다른 사람의 DB도 들어올 수 있다.

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	// 콤보박스에 가게 이름 추가해주는 메소드

	public ArrayList<HS_StaffLoginDto> cbInsertShopname() {

		ArrayList<HS_StaffLoginDto> dtoList = new ArrayList<HS_StaffLoginDto>();

		String whereStatement = "select shop_name from shop;";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement);

			while (rs.next()) {

				String wkshop_name = rs.getString(1);

				HS_StaffLoginDto dto = new HS_StaffLoginDto(wkshop_name);

				dtoList.add(dto);
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dtoList;
	}

	public void gotshopNumber() {

		String whereStatement = "select shop_number from shop where shop_name = '" + shop_name + "'";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement);

			while (rs.next()) {

				HS_Static_StaffId.setShop_number(rs.getInt(1));
			}
			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}// end
