package com.javalec.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.javalec.util.DBConnect;
import com.javalec.util.StaticClass;

public class AdminStaffInsertDao {

	// fields
	String name;
	String telno;
	String email;
	FileInputStream product_image;
	String fileName;
	

	// constructor
	public AdminStaffInsertDao() {
		// TODO Auto-generated constructor stub
	}

	
	
	public AdminStaffInsertDao(String name, String telno, String email, FileInputStream product_image,
			String fileName) {
		super();
		this.name = name;
		this.telno = telno;
		this.email = email;
		this.product_image = product_image;
		this.fileName = fileName;
	}



	public AdminStaffInsertDao(String name, String telno, String email) {
		super();
		this.name = name;
		this.telno = telno;
		this.email = email;
	}

	// method============================================================================
	
	//-------------insertAction()-------------------------
	public boolean insertAction() {
		PreparedStatement ps = null;
		try { // error확인

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql); // database에 접근을 하겠다. (선언자, 아직 실행 단계 x)
			
			@SuppressWarnings("unused")
			Statement stmt_mysql = conn_mysql.createStatement();

			// 쿼리 문장 만들기 (preparestatement)
			String query = "insert into employee (employee_name, employee_telno, employee_email, employee_role, employee_in_date, employee_shop_number) ";
			String query2 = " values (?,?,?,?,curdate(), ?) ";

			// 위의 쿼리 문장대로 순서대로 쓴다.
			ps = conn_mysql.prepareStatement(query + query2);// insert(), value()

			ps.setString(1, name); // 1번 >> name
			ps.setString(2, telno);
			ps.setString(3, email);
			ps.setInt(4, 2);
			ps.setInt(5, StaticClass.shop_number);

			ps.executeUpdate(); // 입력이 되서 여기서 check값에 1값이 담긴다.>>맨 아래 return check로 넘어간다.

			conn_mysql.close(); // close 해야 다른 사람의 DB도 들어올 수 있다.

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// 스태프 아이디 가져오는 메소드
	public int staffId() {
		String query1 = "select employee_id from employee ";
		String query2 = "where employee_name = '" +name+ "' and employee_telno = '" +telno+ "' and employee_role = 2";
		System.out.println("name: " +name+ "telno: " +telno);
		
		int idRs = 0;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(query1 + query2);
			while (rs.next()) {
				idRs = rs.getInt(1);
			}
			
			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
			return idRs;
		}
		System.out.println(idRs);
		return idRs;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}//END
