package com.javalec.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.javalec.base.HS_StaffMypage;
import com.javalec.dto.HS_StaffMypageDto;
import com.javalec.util.DBConnect;
import com.javalec.util.HS_Static_StaffId;

public class HS_StaffMypageDao { // 수정 버튼 눌렀을때 그 정보로 update 해준다

	public HS_StaffMypageDao() {
		// TODO Auto-generated constructor stub
	}

	String tfNameupdate;
	String tfTelnoupdate;
	String tfEmailupdate;
	String tfEmailupdate2;
	String tfPwupdate;
	String cbEmailupdate;
	String panelimage;
	
	
	
	

	public HS_StaffMypageDao(String tfNameupdate, String tfTelnoupdate, String tfEmailupdate, String tfEmailupdate2,
			String tfPwupdate, String panelimage) {
		super();
		this.tfNameupdate = tfNameupdate;
		this.tfTelnoupdate = tfTelnoupdate;
		this.tfEmailupdate = tfEmailupdate;
		this.tfEmailupdate2 = tfEmailupdate2;
		this.tfPwupdate = tfPwupdate;
		this.panelimage = panelimage;
	}



	public Boolean updateAction() {

		PreparedStatement ps = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql); // database에 접근을 하겠다. (선언자, 아직 실행 단계 x)

			String query = "update employee set employee_name = ?, employee_telno = ?, employee_email = ?, employee_pw = ?, employee_image = ? ";

			String query2 = "where employee_id = ? ";

			// 위의 쿼리 문장대로 순서대로 쓴다.
			ps = conn_mysql.prepareStatement(query + query2);// insert(), value()

			ps.setString(1, tfNameupdate);
			ps.setString(2, tfTelnoupdate);
			ps.setString(3, tfEmailupdate + '@' + tfEmailupdate2);
			ps.setString(4, tfPwupdate);
			ps.setString(5, panelimage);//이미지 추가
			ps.setInt(6, HS_Static_StaffId.staff_Id);

			ps.executeUpdate();

			conn_mysql.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		return true;

	}
	
	
	
	
	
	
	
	
	

	public HS_StaffMypageDto staffInfoSave() {// HS_StaffMypageDto에 employee의 정보를 저장합니다.

		HS_StaffMypageDto dto = null;
		
		String whereStatement = "select employee_name, employee_telno, employee_email, employee_pw from employee ";
		String whereStatement2 = "where employee_id = " + HS_Static_StaffId.staff_Id;

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

			while (rs.next()) {
				String tfNameupdate = rs.getString(1);
				String tfTelnoupdate = rs.getString(2);
				String tfemailupdate = rs.getString(3);
				String tfpwupdate = rs.getString(4);
				
				
				
				

				dto = new HS_StaffMypageDto(tfNameupdate, tfTelnoupdate, tfemailupdate, tfpwupdate);

			}

			conn_mysql.close(); // close 해야 다른 사람의 DB도 들어올 수 있다.

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dto;
	}
	
	

	
	
	
	
	
	
	

}//end
