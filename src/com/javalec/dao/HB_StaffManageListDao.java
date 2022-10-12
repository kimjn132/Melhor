package com.javalec.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.dto.HB_staffManageListDto;
import com.javalec.util.DBConnect;
import com.javalec.util.HB_Static;

public class HB_StaffManageListDao {

	int employee_id;
	
	String result;
	String staffText;
	
	
	
	public HB_StaffManageListDao() {
		super();
	}

	
	
	public HB_StaffManageListDao(String result, String staffText) {
		super();
		this.result = result;
		this.staffText = staffText;
	}


	public ArrayList<HB_staffManageListDto> employeeStaffList() {
		
		ArrayList<HB_staffManageListDto> staffList = new ArrayList<HB_staffManageListDto>();
		
		
		String whereStatement = "select e.employee_name, e.employee_id, e.employee_telno, e.employee_in_date from employee e ";	
		String whereStatement2 = "where " + result + " like '%" + staffText + "%' and e.employee_role = 2";	
			
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2);
			
			while(rs.next()) {
				
				String employee_name = rs.getString(1);
				int employee_id = rs.getInt(2);
				String employee_telno = rs.getString(3);
				String employee_int_date = rs.getString(4);
				
				HB_staffManageListDto dto = new HB_staffManageListDto(employee_name, employee_id, employee_telno, employee_int_date);
				staffList.add(dto);
				
			}
			
			conn_mysql.close();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	
		return staffList;
	}
	

	// 총 직원 리스트 출력 
	public ArrayList<HB_staffManageListDto> staffConditionList() {
		
		ArrayList<HB_staffManageListDto> staffList = new ArrayList<HB_staffManageListDto>();
		
		String whereStatement = "";
		String whereStatement2 = "";
		
		// 조건 검색 테이블이 다르기 때문에 sql문을 두개로 분리함
		
		if(result == "e.employee_name") {			
			whereStatement = "select e.employee_name, e.employee_id, e.employee_telno, e.employee_in_date, sum(m.manufact_quantity) from employee e, manufact m ";
			whereStatement2 = "where " + result + " like '%" + staffText + "%' and e.employee_role = '2' and e.employee_id = m.employee_id and DATE(m.manufact_time) = DATE(NOW())"
					+ " group by e.employee_id";	
						    // WHERE절의 like 조건으로 검색기능 추가				 employee_role이 알바생인 것만 출력
			
		} else if(result == "m.manufact_quantity") {
			whereStatement = "select e.employee_name, e.employee_id, e.employee_telno, e.employee_in_date, sum(m.manufact_quantity) from employee e, manufact m ";
			whereStatement2 = "where e.employee_id = m.employee_id  and DATE(m.manufact_time) = DATE(NOW()) "
					+ "group by e.employee_id having sum(m.manufact_quantity)" + staffText;	
			
		}
							  
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2);
			
			while(rs.next()) {
				
				String employee_name = rs.getString(1);
				int employee_id = rs.getInt(2);
				String employee_telno = rs.getString(3);
				String employee_int_date = rs.getString(4);
				int manufact_quantity = rs.getInt(5);
				
				HB_staffManageListDto dto = new HB_staffManageListDto(employee_name, employee_id, employee_telno, employee_int_date, manufact_quantity);
				staffList.add(dto);
				
			}
			
			conn_mysql.close();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	
		return staffList;
	}
	
	// Inner_Table의 데이터를 클릭 하였을 경우
	public HB_staffManageListDto tableClick() {
		
		HB_staffManageListDto dto = null;
		
		// 전달 받은 id값에 해당하는 데이터를 select로 출력 후 해당 화면에서 보여줌
		String whereStatement = "select e.employee_id, e.employee_name, e.employee_telno, e.employee_in_date, e.employee_email, e.employee_image "
				+ "from employee e where e.employee_id = " + HB_Static.getEmployee_id();
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(whereStatement); 
			
			if(rs.next()) {

				int employee_id = rs.getInt(1);
				String employee_name = rs.getString(2);
				String employee_telno = rs.getString(3);
				String employee_in_date = rs.getString(4);
				String employee_email = rs.getString(5);
//				int manufact_quantity = rs.getInt(6);
				
				// 이미지 불러오기
				DBConnect.filename = DBConnect.filename + 1;
            	File file = new File(Integer.toString(DBConnect.filename));
            	FileOutputStream output = new FileOutputStream(file);
            	InputStream employee_image = rs.getBinaryStream(6);
                byte[] buffer = new byte[1024];
                while (employee_image.read(buffer) > 0) {
                    output.write(buffer);
                }
                // 이미지 불러오기
                
				dto = new HB_staffManageListDto(employee_id, employee_name, employee_telno, employee_in_date, employee_email);
			}
			
			conn_mysql.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dto;
	}
	
	
	
	// Inner_Table의 데이터를 클릭 하였을 경우
	public HB_staffManageListDto manufactQuantity(String[] monthCalc) {

		HB_staffManageListDto dto = null;

		// 전달 받은 id값에 해당하는 데이터를 select로 출력 후 해당 화면에서 보여줌
		String whereStatement = "select sum(m.manufact_quantity) from employee e, manufact m where e.employee_id = " + HB_Static.getEmployee_id();
		String whereStatement2 = " and e.employee_id = m.employee_id";
		String whereStatement3 = " and m.manufact_time BETWEEN '" + monthCalc[0] + "' AND '" + monthCalc[1] + "'";
		
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2 + whereStatement3);

			if (rs.next()) {

				int employee_id = rs.getInt(1);


				dto = new HB_staffManageListDto(employee_id);
			}

			conn_mysql.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dto;
	}	
	
	
	
	
	public String[] monthCalc() {
		
		String[] monthCalc = new String[2];
		
		String whereStatement = "SELECT LAST_DAY(NOW() - interval 1 month) + interval 1 DAY, LAST_DAY(NOW())";
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(whereStatement); 
			
			while(rs.next()) {
				
				for(int i = 0; i < monthCalc.length; i++) {
					monthCalc[i] = rs.getString(i + 1); // 0번째 첫날, 1번째 마지막날
				}
				
			}
			
			conn_mysql.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return monthCalc;
	}
	
	
	// Inner_Table의 데이터를 클릭 하였을 경우
	public int staffPaymentManage(String[] monthCalc) {

		int staffWage = 0;

		// 전달 받은 id값에 해당하는 데이터를 select로 출력 후 해당 화면에서 보여줌
		String whereStatement = "select truncate(truncate(sum(attend_off - attend_on) / 10000, 2) * 10000, 0) from attend a ";
		String whereStatement2 = "where a.employee_id = " + HB_Static.getEmployee_id() + " and a.attend_date BETWEEN '" + monthCalc[0] + "' AND '" + monthCalc[1] + "'";
//		String whereStatement3 = " and a.attend_date BETWEEN '" + monthCalc[0] + "' AND '" + monthCalc[1] + "'";
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2);

			while (rs.next()) {

				staffWage = rs.getInt(1);

			}

			conn_mysql.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return staffWage;
	}
		
		
		
		
	
	
}
