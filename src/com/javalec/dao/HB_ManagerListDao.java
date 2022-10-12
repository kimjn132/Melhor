package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.dto.HB_ManagerListDto;
import com.javalec.util.DBConnect;

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

		String whereStatement = "select e.employee_name, s.shop_name, s.shop_address, e.employee_id, e.employee_telno, e.employee_in_date from employee e, shop s ";
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

				HB_ManagerListDto dto = new HB_ManagerListDto(employee_name, shop_name, shop_address, employee_id, employee_telno, employee_int_date);
				staffList.add(dto);

			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return staffList;
	}
	
	
	
	
}
