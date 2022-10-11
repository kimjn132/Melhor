package com.javalec.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.javalec.dto.AdminMenuDetailDto;
import com.javalec.util.DBConnect;
import com.javalec.util.StaticClass;

public class AdminMenuDetailDao {

	// fields
	int product_id;

	// constructor
	public AdminMenuDetailDao() {
		// TODO Auto-generated constructor stub
	}

	public AdminMenuDetailDao(int product_id) {
		super();
		this.product_id = product_id;
	}

	// method

	public AdminMenuDetailDto settingInfo() {
		AdminMenuDetailDto dto = null; // 왜????

		String whereStatement = "select product_id, product_name, product_category, product_price, product_recipe, product_explain, product_image ";
		String whereStatement2 = "from product where product_id = " + product_id;
		
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
					String wkCategory = rs.getString(3);
					int wkPrice = rs.getInt(4);
					String wkRecipe = rs.getString(5);
					String wkExplain = rs.getString(6);
					
					//file
					StaticClass.filename = StaticClass.filename + 1;
	            	File file = new File(Integer.toString(StaticClass.filename));
	            	FileOutputStream output = new FileOutputStream(file);
	            	InputStream input = rs.getBinaryStream(7);
	                byte[] buffer = new byte[1024];
	                while (input.read(buffer) > 0) {
	                    output.write(buffer);
	                }

					dto = new AdminMenuDetailDto(wkId, wkName, wkCategory, wkPrice, wkRecipe, wkExplain);

				}
				
				conn_mysql.close(); // close 해야 다른 사람의 DB도 들어올 수 있다.

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return dto;
	}

	public int insertRegister() {
		int check = 0;
		PreparedStatement ps = null;
		try { // error확인

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql); // database에 접근을 하겠다. (선언자, 아직 실행 단계 x)
			// Statement stmt_mysql = conn_mysql.createStatement();

			// 쿼리 문장 만들기 (preparestatement)
			String query = "insert into register (employee_id, product_id, register_in_date))"; // relation) 여기 띄어쓰기 있어야지
			String query2 = " values (?,?,curdate())";

			// 위의 쿼리 문장대로 순서대로 쓴다.
			ps = conn_mysql.prepareStatement(query + query2);// insert(), value()

			ps.setInt(1, StaticClass.employee_id); // 1번 >> name
			ps.setString(2, Integer.toString(StaticClass.product_id));

			conn_mysql.close(); // close 해야 다른 사람의 DB도 들어올 수 있다.

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			check++;
		}
		return check;
	}

	// 입력이 되서 에러가 안나면 check값이 1이 되고, 입력이 안되면 check값이 0이 되어 catch가 잡아준다.
	// 1이 되었을 때 check로 넘어가고 매개변수로 넘어가서 실행 시켜 주고 if문에서 실행 값이 1이면 입력이 되고, 0 이면 오류 메시지가
	// 뜬다.

	// End

}// END
