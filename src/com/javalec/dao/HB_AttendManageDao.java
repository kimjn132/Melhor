package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.dto.HB_AttendManageDto;
import com.javalec.util.DBConnect;
import com.javalec.util.HB_Static;

public class HB_AttendManageDao {

	String result;
	String search;
	
	public HB_AttendManageDao() {
		// TODO Auto-generated constructor stub
	}

	public HB_AttendManageDao(String result, String search) {
		super();
		this.result = result;
		this.search = search;
	}
	
	public ArrayList<HB_AttendManageDto> attendManageList(int rbEmployee) {
		ArrayList<HB_AttendManageDto> dtoList = new ArrayList<HB_AttendManageDto>();

		String whereStatement = "select e.employee_name, e.employee_id, s.shop_name, count(a.attend_on) from employee e, shop s, attend a ";
		String whereStatement2 = "where " + result + " like '%" + search + "%' and e.employee_role = " + rbEmployee + " and a.employee_id = e.employee_id and s.shop_number = a.shop_number and ";
		String whereStatement3 = "DATE(a.attend_on) BETWEEN LAST_DAY(NOW() - interval (month(now()) - " + (HB_Static.getMonth() - 1) + ") month) + interval 1 DAY and LAST_DAY(NOW() - interval (month(now()) - " + HB_Static.getMonth() + ") month) ";
		String whereStatement4 = "group by e.employee_name ";

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2 + whereStatement3 + whereStatement4);

			while (rs.next()) {

				String employee_name = rs.getString(1);
				int employee_id = rs.getInt(2);
				String shop_name = rs.getString(3);
				int attend_count = rs.getInt(4);

				HB_AttendManageDto dto = new HB_AttendManageDto(employee_name, employee_id, shop_name, attend_count);
				dtoList.add(dto);

			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dtoList;
	}
	
}
