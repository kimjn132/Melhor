package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.dto.AdminRegisterStaffManagementDto;
import com.javalec.util.DBConnect;

public class AdminRegisterStaffManagementDao {
	
	//fields
	int id;
	
	//constructor
	public AdminRegisterStaffManagementDao() {
		// TODO Auto-generated constructor stub
	}
	
	public AdminRegisterStaffManagementDao(int id) {
		super();
		this.id = id;
	}


	//method
	public ArrayList<AdminRegisterStaffManagementDto> selectList() {

		ArrayList<AdminRegisterStaffManagementDto> dtoList = new ArrayList<AdminRegisterStaffManagementDto>(); 
		// 3. 담은 데이터 arraylist 형식으로 가져와서 연결(매개체>>Main class로 보냄)

		String whereStatement = "select employee_id, employee_name, employee_in_date from employee where employee_role = 2 and employee_out_date is null"; // statement

		// 검색 포맷
		try { // error확인
			// connection
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql); // database에 접근을 하겠다. (선언자, 아직 실행 단계 x)
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement);
			// 1. 데이터값 입력
			while (rs.next()) { // 다음 값이 null이면(row가 없으면) false로 되어서 while문이 끝난다.

				int wkId = rs.getInt(1); // 데이터 하나씩 한줄로 가져오기
				String wkName = rs.getString(2); // column 이름 or column 번호 쓰면 됨
				String wkInDate = rs.getString(3);

				// 2. 입력된 데이터 DTO클래스에 저장
				AdminRegisterStaffManagementDto dto = new AdminRegisterStaffManagementDto(wkId, wkName, wkInDate); 
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
	

}//END
