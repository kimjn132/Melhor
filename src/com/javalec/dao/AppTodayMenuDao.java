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

import com.javalec.dto.AppTodayMenuDto;
import com.javalec.util.DBConnect;

public class AppTodayMenuDao {
	int sum;
	int todayMenu;
	int price;
	String name;
	String explain;

	int product_id;
	String customer_id;
	int shop_number;
	String cart_date;
	int cart_product_quantity;

	public AppTodayMenuDao() {
		// TODO Auto-generated constructor stub
	}

	public AppTodayMenuDao(int sum) {
		super();
		this.sum = sum;
	}

	public AppTodayMenuDao(int product_id, String customer_id, int shop_number, int cart_product_quantity) {
		super();
		this.product_id = product_id;
		this.cart_product_quantity = cart_product_quantity;
		this.customer_id = customer_id;
		this.shop_number = shop_number;
	}

	public AppTodayMenuDao(String customer_id, int shop_number, int cart_product_quantity, int product_id) {
		super();
		this.cart_product_quantity = cart_product_quantity;
		this.customer_id = customer_id;
		this.shop_number = shop_number;
		this.product_id = product_id;
	}
	
	
	public AppTodayMenuDao(int price, String name, String explain, int product_id) {
		super();
		this.price = price;
		this.name = name;
		this.explain = explain;
		this.product_id = product_id;
	}

	public ArrayList<AppTodayMenuDto> bestProductConditionList() {

		ArrayList<AppTodayMenuDto> bestProduct = new ArrayList<AppTodayMenuDto>();

		String whereStatement = "select sum(o.order_quantity) from orders o, product p ";
		String whereStatement2 = "where p.product_id = o.product_id group by o.product_id order by sum(o.order_quantity) desc;";

//		String wStatement1 = "select s.shop_name, p.product_name, sum(o.order_quantity) from orders o, product p, shop s ";
//		String wStatement2 = "where p.product_id = o.product_id and s.shop_number = o.shop_number ";
//		String wStatement3 = "group by o.product_id, s.shop_name ";
//		String wStatement4 = "order by s.shop_name, sum(o.order_quantity) desc";

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2);

			while (rs.next()) {

				int todayMenu = rs.getInt(1);

				AppTodayMenuDto dto = new AppTodayMenuDto(todayMenu);

				bestProduct.add(dto);

			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return bestProduct;
	}

	public AppTodayMenuDto todayMenuSearch() {

		AppTodayMenuDto dto = null;

		String wStatement1 = "select p.product_price, p.product_name, p.product_explain, p.product_image, p.product_id ";
		String wStatement2 = "from product p, orders o ";
		String wStatement3 = "where p.product_id = o.product_id group by p.product_id having max(o.order_quantity) limit 1 ";

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(wStatement1 + wStatement2 + wStatement3);

			if (rs.next()) {

				int price = rs.getInt(1);
				String name = rs.getString(2);
				String explain = rs.getString(3);
				

				// ????????? ????????????
				DBConnect.filename = DBConnect.filename + 1;
				File file = new File(Integer.toString(DBConnect.filename));
				FileOutputStream output = new FileOutputStream(file);
				InputStream customer_image = rs.getBinaryStream(4);
				byte[] buffer = new byte[1024];
				while (customer_image.read(buffer) > 0) {
					output.write(buffer);
					
				}
				// ????????? ????????????

				int product_id = rs.getInt(5);
				
				
				dto = new AppTodayMenuDto(price, name, explain, product_id);
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();

		}

		return dto;
	}

////???????????? ?????? ????????? (?????? ??????) cart  ???????????? ????????? ??????
	public int insertCart() {
		PreparedStatement ps = null;
		int check = 0;

		try { // error??????

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql); // database??? ????????? ?????????. (?????????, ?????? x)
			Statement stmt_mysql = conn_mysql.createStatement(); // Connection conn_mysql ??????????????? ???????????? Statement ?????? ??????

			// ?????? ?????? ????????? (preparestatement)
			String query = "insert into cart (product_id, customer_id, shop_number, cart_date, cart_product_quantity) "; // relation)

			String query1 = "values (?,?,?,now(),?) ";

			// ?????? ?????? ???????????? ???????????? ??????.
			ps = conn_mysql.prepareStatement(query + query1);

			ps.setInt(1, product_id);

			ps.setString(2, customer_id);
			ps.setInt(3, shop_number);
			ps.setInt(4, cart_product_quantity);

			check = ps.executeUpdate(); // insert update method ?????? ???????????? ??????

			conn_mysql.close(); // close ?????? ?????? ????????? DB??? ????????? ??? ??????.

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

			return check;
		}
		return check;

	}

}
