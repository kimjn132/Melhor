package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.javalec.util.DBConnect;

public class AppJoinDao {

	// ------------------ field ----------------------
	String customer_nickname;
	String customer_id;
	String customer_pw;
	String customer_telno;
//	String customer_insert_date;
//	String customer_birthday;

	// ------------------ constructor ----------------------
	public AppJoinDao() {
		// TODO Auto-generated constructor stub
	}


	public AppJoinDao(String customer_nickname, String customer_id, String customer_pw, String customer_telno) {
		super();
		this.customer_nickname = customer_nickname;
		this.customer_id = customer_id;
		this.customer_pw = customer_pw;
		this.customer_telno = customer_telno;
//		this.customer_insert_date = customer_insert_date;
//		this.customer_birthday = customer_birthday;
	}



	public AppJoinDao(String customer_id) {
		super();
		this.customer_id = customer_id;
	}
	



	// ------------------ method ----------------------
	public int insertAction() {
		PreparedStatement ps = null;
		int check = 0;
		try { // error확인

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql); // database에 접근을 하겠다. (선언자, 아직 실행 단계 x)

			// 쿼리 문장 만들기 (preparestatement)
			String query = " insert into customer (customer_nickname, customer_id, customer_pw, customer_telno, customer_insert_date) ";

			String query2 = " values (?,?,?,?,now()) ";

			// 위의 쿼리 문장대로 순서대로 쓴다.
			ps = conn_mysql.prepareStatement(query + query2);

			ps.setString(1, customer_nickname);
			ps.setString(2, customer_id);
			ps.setString(3, customer_pw);
			ps.setString(4, customer_telno);
//			ps.setString(5, customer_insert_date);
//			ps.setString(6, customer_birthday);
	

			check = ps.executeUpdate();

			conn_mysql.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return check;
		}
		System.out.println(check);
		return check;
	}

	// 아이디 중복 체크
	public int customer_idCheck(String customer_id) {
		int check = 0;
		String query1 = "select count(*) from customer ";
		String query2 = "where customer_id = '" + customer_id + "'";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			ResultSet rs = stmt_mysql.executeQuery(query1 + query2);

			while (rs.next()) {
				// 1일 나오면 중복되는 값이 있다는 뜻
				check = rs.getInt(1);
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
			return check;
		}
		return check;
	}

	// 패스워드 일치 여부 체크
	public int customer_pwCheck(String customer_pwCheck) {
		int check = 0;
		String query1 = "select count(*) from customer ";
		String query2 = "where customer_pw = '" + customer_pw + "'";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			ResultSet rs = stmt_mysql.executeQuery(query1 + query2);

			while (rs.next()) {
				// 1일 나오면 중복되는 값이 있다는 뜻
				check = rs.getInt(1);
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
			return check;
		}
		return check;
	}

}
