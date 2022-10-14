package com.javalec.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.dto.HB_ManagerListDto;
import com.javalec.dto.HB_staffManageListDto;
import com.javalec.util.DBConnect;
import com.javalec.util.HB_Static;

public class HB_ManagerListDao {

	String result;
	String managerText;
	
	
	public HB_ManagerListDao() {
		// TODO Auto-generated constructor stub
	}

	
	public HB_ManagerListDao(String result, String managerText) {
		super();
		this.result = result;
		this.managerText = managerText;
	}
	
	
	// 점원 리스트 출력
	public ArrayList<HB_ManagerListDto> managerConditionList() {
		
		ArrayList<HB_ManagerListDto> staffList = new ArrayList<HB_ManagerListDto>();

		String whereStatement = "select e.employee_name, s.shop_name, s.shop_address, e.employee_id, e.employee_telno, e.employee_in_date, e.employee_shop_number from employee e, shop s ";
		String whereStatement2 = "where " + result + " like '%" + managerText + "%' and e.employee_role = 1 and s.shop_employee_id = e.employee_id group by e.employee_id";
		                         // WHERE절의 like 조건으로 검색기능 추가                    employee_role이 점장인 것만 출력
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2);

			while (rs.next()) {

				String employee_name = rs.getString(1);
				String shop_name = rs.getString(2);
				String shop_address = rs.getString(3);
				int employee_id = rs.getInt(4);
				String employee_telno = rs.getString(5);
				String employee_int_date = rs.getString(6);
				int employee_shop_number = rs.getInt(7);

				HB_ManagerListDto dto = new HB_ManagerListDto(employee_name, shop_name, shop_address, employee_id, employee_telno, employee_int_date, employee_shop_number);
				staffList.add(dto);

			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return staffList;
	}
	
	public String[] monthCalc() {

		String[] monthCalc = new String[2];

		String whereStatement = "SELECT LAST_DAY(NOW() - interval 1 month) + interval 1 DAY, LAST_DAY(NOW())";

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement);

			while (rs.next()) {

				for (int i = 0; i < monthCalc.length; i++) {
					monthCalc[i] = rs.getString(i + 1); // 0번째 첫날, 1번째 마지막날
				}

			}

			conn_mysql.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return monthCalc;
	}
	
	
	// Inner_Table의 데이터를 클릭 하였을 경우
	public HB_staffManageListDto tableClick() {

		HB_staffManageListDto dto = null;

		// 전달 받은 id값에 해당하는 데이터를 select로 출력 후 해당 화면에서 보여줌
		String whereStatement = "select e.employee_id, e.employee_name, e.employee_telno, e.employee_in_date, e.employee_email, e.employee_image "
				+ "from employee e where e.employee_id = " + HB_Static.getEmployee_id();

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement);

			if (rs.next()) {

				int employee_id = rs.getInt(1);
				String employee_name = rs.getString(2);
				String employee_telno = rs.getString(3);
				String employee_in_date = rs.getString(4);
				String employee_email = rs.getString(5);
//					int manufact_quantity = rs.getInt(6);

				// 이미지 불러오기
				DBConnect.filename = DBConnect.filename + 1;
				File file = new File(Integer.toString(DBConnect.filename));
				FileOutputStream output = new FileOutputStream(file);
				InputStream employee_image = rs.getBinaryStream(6);
				byte[] buffer = new byte[1024];
				while (employee_image.read(buffer) > 0) {
					output.write(buffer);
				}
				// 이미지 불러오기

				dto = new HB_staffManageListDto(employee_id, employee_name, employee_telno, employee_in_date,
						employee_email);
			}

			conn_mysql.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dto;
	}
	
	
	// Inner_Table의 데이터를 클릭 하였을 경우
	public int staffPaymentManage(String[] monthCalc) {

		int staffWage = 0;

		// 전달 받은 id값에 해당하는 데이터를 select로 출력 후 해당 화면에서 보여줌
		String whereStatement = "select truncate(truncate(sum(attend_off - attend_on) / 10000, 2) * 10000, 0) from attend a ";
		String whereStatement2 = "where a.employee_id = " + HB_Static.getEmployee_id() + " and a.attend_date BETWEEN '"
				+ monthCalc[0] + "' AND '" + monthCalc[1] + "'";
//			String whereStatement3 = " and a.attend_date BETWEEN '" + monthCalc[0] + "' AND '" + monthCalc[1] + "'";
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2);

			while (rs.next()) {

				staffWage = rs.getInt(1);

			}

			conn_mysql.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return staffWage;
	}
	
	
	public ArrayList<HB_ManagerListDto> managerMonthSalesStatus1() {
		ArrayList<HB_ManagerListDto> staffList = new ArrayList<HB_ManagerListDto>();

		String whereStatement = "";
		String whereStatement2 = "";
		
		for(int i = 1; i <= 6; i++) {
			whereStatement = "SELECT sum(o.order_saleprice) from orders o where DATE(o.order_time) BETWEEN ";
			whereStatement2 = "LAST_DAY(NOW() - interval (month(now()) - " + (i - 1) + ") month) + interval 1 DAY and LAST_DAY(NOW() - interval (month(now()) - " + i + ") month) and o.shop_number = " + HB_Static.getShop_number();
			
			try {

				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
						DBConnect.pw_mysql);
				Statement stmt_mysql = conn_mysql.createStatement();

				ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2);

				while (rs.next()) {

					int order_saleprice = rs.getInt(1);

					System.out.println("dao: " + order_saleprice);
					
					HB_ManagerListDto dto = new HB_ManagerListDto(order_saleprice);
					staffList.add(dto);

				}

				conn_mysql.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return staffList;
	}
	
	
	
	public ArrayList<HB_ManagerListDto> managerMonthSalesStatus2() {
		ArrayList<HB_ManagerListDto> staffList = new ArrayList<HB_ManagerListDto>();

		String whereStatement = "";
		String whereStatement2 = "";
		
		for(int i = 7; i <= 12; i++) {
			whereStatement = "SELECT sum(o.order_saleprice) from orders o where DATE(o.order_time) BETWEEN ";
			whereStatement2 = "LAST_DAY(NOW() - interval (month(now()) - " + (i - 1) + ") month) + interval 1 DAY and LAST_DAY(NOW() - interval (month(now()) - " + i + ") month) and o.shop_number = " + HB_Static.getShop_number();
			
			try {

				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
						DBConnect.pw_mysql);
				Statement stmt_mysql = conn_mysql.createStatement();

				ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2);

				while (rs.next()) {

					int order_saleprice = rs.getInt(1);

					System.out.println("dao: " + order_saleprice);
					
					HB_ManagerListDto dto = new HB_ManagerListDto(order_saleprice);
					staffList.add(dto);

				}

				conn_mysql.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return staffList;
	}
	
	
}
