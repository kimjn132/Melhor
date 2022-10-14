package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.dto.HS_OrderManageDto;
import com.javalec.dto.HS_OrderManagePastDto;
import com.javalec.util.DBConnect;
import com.javalec.util.HS_Static_StaffId;

public class HS_OrderManagePastDao {
	

	
	public HS_OrderManagePastDao() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public ArrayList<HS_OrderManagePastDto> orderPastConditionList() {

		ArrayList<HS_OrderManagePastDto> orderPastList = new ArrayList<HS_OrderManagePastDto>();
		String whereStatement = "select o.order_id, c.customer_id, p.product_name, o.order_quantity, o.order_time from orders o, customer c, product p ,attend a, shop s, employee e ";
		String whereStatement2 = "where  o.product_id = p.product_id and o.customer_id = c.customer_id and s.shop_number = a.shop_number and s.shop_number = o.shop_number and a.employee_id = e.employee_id ";
		String whereStatement3 = "and o.shop_number = " + HS_Static_StaffId.shop_number +  " and o.order_stamp = 1 group by o.order_time order by o.order_time desc";
											//order의 shop_number가 로그인한사람과 일치하고 stamp가 1인 것 출력
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2+ whereStatement3);

			while (rs.next()) {

				int order_id = rs.getInt(1);
				String customer_id = rs.getString(2);
				String product_name = rs.getString(3);
				int order_quantity = rs.getInt(4);
				String order_time = rs.getString(5);

				HS_OrderManagePastDto dto = new HS_OrderManagePastDto(order_id, customer_id, product_name, order_quantity, order_time);
				orderPastList.add(dto);

			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return orderPastList;
	}

}//end
