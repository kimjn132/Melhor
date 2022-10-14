package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.javalec.dto.HS_StaffMypageDto;
import com.javalec.util.DBConnect;
import com.javalec.util.HS_Static_StaffId;

public class HS_StaffMenuDao {

	public HS_StaffMenuDao() {
		// TODO Auto-generated constructor stub
	}

	String attend_off;
	String attend_date;

	public HS_StaffMenuDao(String attend_off, String attend_date) {
		super();
		this.attend_off = attend_off;
		this.attend_date = attend_date;
	}

	public void inworkAction() {// 출근시간이 입력되는 메소드

		PreparedStatement ps = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql); // database에 접근을 하겠다. (선언자, 아직 실행 단계 x)

			String query = "INSERT INTO attend (employee_id, shop_number, attend_on ) select ? ,? ,now() ";
			String query2 = "where not exists (select * from attend where employee_id = ? and  attend_off is null)";

			HS_Static_StaffId hs_Static_StaffId = new HS_Static_StaffId();

			ps = conn_mysql.prepareStatement(query + query2);

			ps.setInt(1, hs_Static_StaffId.staff_Id); // HS_Static_StaffId 에 저장해 놨던 staff_Id를 불러온다

			ps.setInt(2, hs_Static_StaffId.shop_number); // HS_Static_StaffId 에 저장해 놨던 shop_number를 불러온다

//		ps.setString(3, attend_off); // 처음에는 null 값 주고 나갈때 update해야함
//									//NotNull로 되어있어서 null로 변경했음
//		
			ps.setInt(3, HS_Static_StaffId.getStaff_Id());

			ps.executeUpdate(); // insert update method 이거 하나밖에 없다

			conn_mysql.close(); // close 해야 다른 사람의 DB도 들어올 수 있다.

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}// end
