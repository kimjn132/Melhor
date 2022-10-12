package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.javalec.util.DBConnect;

public class HB_ExcutiveLoginDao {

	String excutiveId;
	String excutivePw;
	
	
	public HB_ExcutiveLoginDao() {
		// TODO Auto-generated constructor stub
	}
	
	
	// 로그인 id,pw 체크
	public HB_ExcutiveLoginDao(String excutiveId, String excutivePw) {
		super();
		this.excutiveId = excutiveId;
		this.excutivePw = excutivePw;
	}
	
	
	public int[] excutiveLoginCheck() {
		
		int[] check = new int[2]; // count, employee_role 두개의 값을 배열로 저장
		
		String query1 = "select count(*), employee_role from employee ";
		String query2 = "where employee_id = " + excutiveId + " and employee_pw = '" + excutivePw + "'";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			ResultSet rs = stmt_mysql.executeQuery(query1 + query2);

			while (rs.next()) {
				
				for(int i = 0; i < check.length; i++) { // check의 길이 만큼 반복
					check[i] = rs.getInt(i + 1); // check 0번째에 count값,
												//        1번째에 employee_role값 저장
				}
			}
			
			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
			return check;
		}
		return check; // check 배열 return

	}
	
	
}
