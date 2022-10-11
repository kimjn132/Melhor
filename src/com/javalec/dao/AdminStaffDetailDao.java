package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.javalec.dto.AdminStaffDetailDto;
import com.javalec.util.DBConnect;
import com.javalec.util.StaticClass;

public class AdminStaffDetailDao {

	// fields
	String name;
	String telno;
	String address;

	// constructor
	public AdminStaffDetailDao() {
		// TODO Auto-generated constructor stub
	}

	public AdminStaffDetailDao(String name, String telno, String address) {
		super();
		this.name = name;
		this.telno = telno;
		this.address = address;
	}
	

	// method

	public AdminStaffDetailDto tableClick() {

		AdminStaffDetailDto dto = null; // 왜????

		String whereStatement = "select employee_id, employee_name, employee_in_date, employee_telno, employee_email "; // statement,
		String whereStatement2 = "from employee where employee_id =  " +StaticClass.staff_id;

		// 검색 포맷
		try { // error확인
				// connection
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql); // database에 접근을 하겠다. (선언자, 아직 실행 단계 x)

			//
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2);

			while (rs.next()) {

				int wkId = rs.getInt(1);
				String wkName = rs.getString(2);
				String wkInDate = rs.getString(3);
				String wkTelno = rs.getString(4);
				String wkEmail = rs.getString(5);

				dto = new AdminStaffDetailDto(wkId, wkName, wkInDate, wkTelno, wkEmail);

			}

			conn_mysql.close(); // close 해야 다른 사람의 DB도 들어올 수 있다.

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dto;
	}

	// 스태프 등록 해제 (delete date)
	public Boolean staffUnRegister() {
		
		PreparedStatement ps = null;

		try { // error확인

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql); // database에 접근을 하겠다. (선언자, 아직 실행 단계 x)
			// Statement stmt_mysql = conn_mysql.createStatement();

			// 쿼리 문장 만들기 (preparestatement)
			String query = "update employee set employee_out_date = curdate() ";
			String query2 = "where employee_id = " + StaticClass.staff_id;

			// 위의 쿼리 문장대로 순서대로 쓴다.
			ps = conn_mysql.prepareStatement(query + query2);// insert(), value()
			

			ps.executeUpdate(); // insert update method 이거 하나밖에 없다

			conn_mysql.close(); // close 해야 다른 사람의 DB도 들어올 수 있다.

			// JOptionPane.showMessageDialog(null, name + "님의 정보가 수정되었습니다.");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		return true;

	}
	
	// 스태프 정보 수정
	public Boolean updateAction() {
		PreparedStatement ps = null;

		try { // error확인

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql); // database에 접근을 하겠다. (선언자, 아직 실행 단계 x)
			// Statement stmt_mysql = conn_mysql.createStatement();

			// 쿼리 문장 만들기 (preparestatement)
			String query = "update employee set employee_name = ?, employee_telno = ?, employee_address = ? ";
			String query2 = "where employee_id = " +StaticClass.staff_id;

			// 위의 쿼리 문장대로 순서대로 쓴다.
			ps = conn_mysql.prepareStatement(query + query2);// insert(), value()
			
			ps.setString(1, name); // 1번 >> name = ?
			ps.setString(2, telno);
			ps.setString(3, address);

			ps.executeUpdate(); // insert update method 이거 하나밖에 없다

			conn_mysql.close(); // close 해야 다른 사람의 DB도 들어올 수 있다.

			// JOptionPane.showMessageDialog(null, name + "님의 정보가 수정되었습니다.");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		return true;

	}
	
	
	
	
	
	
	
	
	
	
	

}// END
