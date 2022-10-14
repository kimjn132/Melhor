package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.javalec.dto.HS_StaffMypageDto;
import com.javalec.util.DBConnect;
import com.javalec.util.HS_Static_StaffId;

public class HS_StaffLoginDao {

	
	public HS_StaffLoginDao() {
		// TODO Auto-generated constructor stub
	}
	
	String staffId;
	String staffPw;
	public HS_StaffLoginDao(String staffId, String staffPw) {
		super();
		this.staffId = staffId;
		this.staffPw = staffPw;
	}
	
	
	
	
	public int staffLoginCheck() {
		
		int check = 0;
		
		String query1 = "select count(*) from employee ";
		String query2 = "where employee_id = '" + staffId + "'  and employee_pw = '" + staffPw + "'";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(query1 + query2);

			while (rs.next()) {
				if(Integer.parseInt(rs.getString(1)) == 1) {
					check++;
					
				}
				
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
		String whereStatement2 = "where employee_id = "+ HS_Static_StaffId.staff_Id ;

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
				
				
				
				
				HS_StaffMypageDto hs_staffmypagedto = new HS_StaffMypageDto(tfNameupdate, tfTelnoupdate, tfemailupdate, tfpwupdate);
				
				
			

			conn_mysql.close(); // close 해야 다른 사람의 DB도 들어올 수 있다.

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
}
