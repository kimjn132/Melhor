package com.javalec.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.dto.AppTodayMenuDto;
import com.javalec.dto.HB_ExcutiveSignDto;
import com.javalec.util.DBConnect;

public class HB_ExcutiveSignDao {

	int employee_id;
	String employee_pw;
	String employee_name;
	String employee_telno;
	String employee_email;
	FileInputStream file;

	// image update
	public HB_ExcutiveSignDao(FileInputStream file) {
		super();
		this.file = file;
	}

	public void update() {
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			String A = "update employee set employee_image = ? ";
			String B = " where employee_id = 13 ";

			ps = conn_mysql.prepareStatement(A + B);

			ps.setBinaryStream(1, file);

			ps.executeUpdate();

			conn_mysql.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	// image update

	public HB_ExcutiveSignDao() {
		// TODO Auto-generated constructor stub
	}

	public HB_ExcutiveSignDao(int employee_id, String employee_pw, String employee_name, String employee_telno,
			String employee_email, FileInputStream file) {
		super();
		this.employee_id = employee_id;
		this.employee_pw = employee_pw;
		this.employee_name = employee_name;
		this.employee_telno = employee_telno;
		this.employee_email = employee_email;
		this.file = file;
	}

	public HB_ExcutiveSignDao(String employee_email) {
		super();
		this.employee_email = employee_email;
	}

	public int excutiveEmailCheck() {
		int check = 0; // count, employee_role 두개의 값을 배열로 저장

		String query1 = "select count(*) from employee where employee_email = " + employee_email;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			ResultSet rs = stmt_mysql.executeQuery(query1);

			while (rs.next()) {

				check = rs.getInt(1);

			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
			return check;
		}
		return check; // check 배열 return

	}

	public int employeeSignUp() {

		int count = 0;

		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			String query1 = "insert into employee (employee_id, employee_name, employee_pw, employee_telno, employee_email, employee_in_date, employee_image, employee_role";
			String query2 = ") values (?,?,?,?,?,curdate(),?,0)";

			ps = conn_mysql.prepareStatement(query1 + query2);
			ps.setInt(1, employee_id);
			ps.setString(2, employee_name.trim());
			ps.setString(3, employee_pw.trim());
			ps.setString(4, employee_telno.trim());
			ps.setString(5, employee_email.trim());
			ps.setBinaryStream(6, file);

			ps.executeUpdate();

			conn_mysql.close();
			count++;

		} catch (Exception e) {
			e.printStackTrace();
			return count;
		}
		return count;
	}

	public ArrayList<HB_ExcutiveSignDto> getEmployeeId() {
		
		ArrayList<HB_ExcutiveSignDto> dtoList = new ArrayList<HB_ExcutiveSignDto>();
		
		String query1 = "select employee_id from employee ";
		String query2 = "order by employee_id desc";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(query1 + query2);

			while (rs.next()) {

				int employeeId = rs.getInt(1); // check 0번째에 count값,
				
				HB_ExcutiveSignDto dto = new HB_ExcutiveSignDto(employeeId);

				dtoList.add(dto);
				
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
			return dtoList;
		}
		return dtoList; // check 배열 return

	}

}
