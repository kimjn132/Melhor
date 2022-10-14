package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.dto.HS_OrderManageDto;
import com.javalec.util.DBConnect;
import com.javalec.util.HS_Static_StaffId;

public class HS_OrderManageDao {
	
	
	
	int order_id;
	int order_quantity;
	
	
	

	public HS_OrderManageDao(int order_id) {
		super();
		this.order_id = order_id;
	}






	public HS_OrderManageDao(int order_id, int order_quantity) {
		super();
		this.order_id = order_id;
		this.order_quantity = order_quantity;
	}






	public HS_OrderManageDao() {
		// TODO Auto-generated constructor stub
	}

	



	public ArrayList<HS_OrderManageDto> orderConditionList() {

		ArrayList<HS_OrderManageDto> orderList = new ArrayList<HS_OrderManageDto>();
		String whereStatement = "select o.order_id, c.customer_id, p.product_name, o.order_quantity, o.order_time from orders o, customer c, product p ,attend a, shop s, employee e ";
		String whereStatement2 = "where  o.product_id = p.product_id and o.customer_id = c.customer_id and s.shop_number = a.shop_number and s.shop_number = o.shop_number and a.employee_id = e.employee_id ";
		String whereStatement3 = "and o.shop_number = " + HS_Static_StaffId.shop_number +  " and o.order_stamp = 0 group by o.order_time order by o.order_time asc";
											//shop_number가 로그인한 사람과 일치하고 o.order_stamp가 0인거 출력
											
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2+ whereStatement3);

			while (rs.next()) {

				int order_id = rs.getInt(1);
				int customer_id = rs.getInt(2);
				String product_name = rs.getString(3);
				int order_quantity = rs.getInt(4);

				HS_OrderManageDto dto = new HS_OrderManageDto(order_id, customer_id, product_name, order_quantity);
				orderList.add(dto);

			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return orderList;
	}

	
	




	public void orderManufact() {
		
	int count = 0;
		
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			String query1 = "insert into manufact (employee_id, order_id, manufact_quantity, manufact_time) ";
			String query2 = "values (?, ?, ?, now())";

			ps = conn_mysql.prepareStatement(query1 + query2);
			ps.setInt(1, HS_Static_StaffId.getStaff_Id());
			ps.setInt(2, order_id);
			ps.setInt(3, order_quantity);

			ps.executeUpdate();

			conn_mysql.close();
			count++;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
		
	
	public void removeOrderlist(int order_id) {

		PreparedStatement ps = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql); // database에 접근을 하겠다. (선언자, 아직 실행 단계 x)

			String query = "update orders set order_stamp = 1 where order_id = ? ";
			
			ps = conn_mysql.prepareStatement(query);
			
			ps.setString(1, Integer.toString(order_id));

			ps.executeUpdate();
			conn_mysql.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
	
		
	
	
	
	
}// end
