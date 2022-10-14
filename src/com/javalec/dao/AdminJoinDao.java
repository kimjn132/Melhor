package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.javalec.util.DBConnect;
import com.javalec.util.StaticClass;

public class AdminJoinDao {
	
	//fields
	String id;
	String pw;

	//constructor
	public AdminJoinDao() {
		// TODO Auto-generated constructor stub
	}
	
	public AdminJoinDao(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}

	//mehtod
	public Boolean updateAction() {
		PreparedStatement ps = null;

		try { // error확인

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql); // database에 접근을 하겠다. (선언자, 아직 실행 단계 x)
			// Statement stmt_mysql = conn_mysql.createStatement();

			// 쿼리 문장 만들기 (preparestatement)
			String query = "update employee set employee_pw = ? where employee_id = ? ";

			// 위의 쿼리 문장대로 순서대로 쓴다.
			ps = conn_mysql.prepareStatement(query);// insert(), value()
			
			ps.setString(1, pw); // 1번 >> name = ?
			ps.setString(2, id);

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

}
