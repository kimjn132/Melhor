package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.dto.HB_ShopDetailDto;
import com.javalec.util.DBConnect;
import com.javalec.util.HB_Static;

public class HB_ShopDetailDao {

	String cbbox;
	String shopText;
	
	public HB_ShopDetailDao() {
		// TODO Auto-generated constructor stub
	}

	public HB_ShopDetailDao(String cbbox, String shopText) {
		super();
		this.cbbox = cbbox;
		this.shopText = shopText;
	}
	
	public ArrayList<HB_ShopDetailDto> shopDetailConditionList() {
		ArrayList<HB_ShopDetailDto> shopList = new ArrayList<HB_ShopDetailDto>();
		String whereStatement = "select s.shop_name, p.product_name, o.order_quantity from register r, shop s, product p, orders o ";
		String whereStatement2 = "where s.shop_number = r.shop_number and s.shop_number = " + HB_Static.shop_number + " and o.shop_number = s.shop_number and o.product_id = p.product_id ";	
		String whereStatement3 = "group by p.product_name order by r.register_id asc";
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2 + whereStatement3);
			
			while(rs.next()) {
				
				String shop_name = rs.getString(1);
				String product_name = rs.getString(2);
				int order_quantity = rs.getInt(3);
				
				HB_ShopDetailDto dto = new HB_ShopDetailDto(shop_name, product_name, order_quantity);
				shopList.add(dto);
				
			}
			
			conn_mysql.close();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	
		return shopList;
	}
	
}
