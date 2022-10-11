package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.dto.AdminMyPageDto;
import com.javalec.util.DBConnect;
import com.javalec.util.StaticClass;

public class AdminMyPageDao {
	
	//fields
	String name;
	String telno;
	String email;
	String pw;
	
	//constructor
	public AdminMyPageDao() {
		// TODO Auto-generated constructor stub
	}
	
	public AdminMyPageDao(String name, String telno, String email, String pw) {
		super();
		this.name = name;
		this.telno = telno;
		this.email = email;
		this.pw = pw;
	}
	
	//method
	public ArrayList<AdminMyPageDto> selectList() {

		ArrayList<AdminMyPageDto> dtoList = new ArrayList<AdminMyPageDto>(); 
		// 3. 담은 데이터 arraylist 형식으로 가져와서 연결(매개체>>Main class로 보냄)

		String whereStatement = "select employee_name, employee_telno, employee_email ";
		String whereStatement1 = "from employee where employee_id = " +StaticClass.employee_id;
		

		// 검색 포맷
		try { // error확인
			// connection
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql); // database에 접근을 하겠다. (선언자, 아직 실행 단계 x)
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement1);
			// 1. 데이터값 입력
			while (rs.next()) { // 다음 값이 null이면(row가 없으면) false로 되어서 while문이 끝난다.

				String wkName = rs.getString(1); // column 이름 or column 번호 쓰면 됨
				String wkTelno = rs.getString(2);
				String wkEmail = rs.getString(3);

				// 2. 입력된 데이터 DTO클래스에 저장
				AdminMyPageDto dto = new AdminMyPageDto(wkName, wkTelno, wkEmail); 
				// 가져온 데이터 묶는 역할
				//rs.next()로 포인터를 1씩 옮길 때마다 instance를 생성하고 밑의 dtoList에 하나씩 저장 
				
				dtoList.add(dto); // 2. 입력된 데이터 dtoList에도 저장
			}

			conn_mysql.close(); // close 해야 다른 사람의 DB도 들어올 수 있다.

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dtoList;

	}
	
	// ---------------------update------------------------
	
	public Boolean updateAction() {
		PreparedStatement ps = null;

		try { // error확인

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql); // database에 접근을 하겠다. (선언자, 아직 실행 단계 x)
			// Statement stmt_mysql = conn_mysql.createStatement();

			// 쿼리 문장 만들기 (preparestatement)
			String query = "update employee set employee_name = ?, employee_telno = ?, employee_email = ?, employee_pw = ? "; // relation)
			String query2 = " where employee_id = " + StaticClass.employee_id ;

			// 위의 쿼리 문장대로 순서대로 쓴다.
			ps = conn_mysql.prepareStatement(query + query2);// insert(), value()
			ps.setString(1, name); // 1번 >> name = ?
			ps.setString(2, telno);
			ps.setString(3, email);
			ps.setString(4, pw);

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

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}//END
