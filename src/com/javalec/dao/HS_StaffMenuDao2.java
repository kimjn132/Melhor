package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.javalec.util.DBConnect;
import com.javalec.util.HS_Static_StaffId;

public class HS_StaffMenuDao2 {
	
	public HS_StaffMenuDao2() {
		// TODO Auto-generated constructor stub
	}
	
	String attend_off;
	String attend_date;
	public HS_StaffMenuDao2(String attend_off, String attend_date) {
		super();
		this.attend_off = attend_off;
		this.attend_date = attend_date;
	}

	
	//퇴근할때 시간이 입력되는 메소드-------------------------------------------------------
	
	public void outworkAction() {
		
		
		PreparedStatement ps = null;

		try { 

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw_mysql); // database에 접근을 하겠다. (선언자, 아직 실행 단계 x)

			String query = "update attend set attend_off = now() ";
					

			String query2 =  "where employee_id = ? and attend_off is null";//Staff_Id가 sql에서는 employee_id 입니다
			
			HS_Static_StaffId hs_Static_StaffId = new HS_Static_StaffId();

			
			ps = conn_mysql.prepareStatement(query + query2);

			ps.setInt(1,hs_Static_StaffId.staff_Id ); //HS_Static_StaffId 에 저장해 놨던 staff_Id를 불러온다
		

			ps.executeUpdate(); // insert update method 이거 하나밖에 없다

			conn_mysql.close(); // close 해야 다른 사람의 DB도 들어올 수 있다.
			

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		
	}
	
	//----------------------------------------------------------------
	
	
	
	
	

}//end
