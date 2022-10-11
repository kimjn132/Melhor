package com.javalec.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.javalec.dto.AppMenuDetailDto;
import com.javalec.dto.AppMenuListDto;
import com.javalec.util.DBConnect;
import com.javalec.util.Static_CustomerId;
import com.mysql.cj.jdbc.Blob;

public class AppMenuDetailDao {
	int product_id;
	String product_name;
	FileInputStream product_image;
	int product_price;
	String product_explain;

	int cart_id;
	int cart_product_quantity;

	String customer_id;
	
	int shop_number;
	
	int order_id;
	int order_saleprice;
	int order_quantity;
	String order_payment;

	public AppMenuDetailDao() {
		// TODO Auto-generated constructor stub
	}

	public AppMenuDetailDao(int product_id) {
		super();
		this.product_id = product_id;
	}

	public AppMenuDetailDao(int product_id, String product_name, FileInputStream product_image, int product_price,
			String product_explain) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_image = product_image;
		this.product_price = product_price;
		this.product_explain = product_explain;

	}

	public AppMenuDetailDao(int product_id, String product_name, int product_price, String product_explain) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_price = product_price;
		this.product_explain = product_explain;
	}


	
	
	

	public AppMenuDetailDao(int product_id, String customer_id, int shop_number, int cart_product_quantity) {
		super();
		this.product_id = product_id;
		this.cart_product_quantity = cart_product_quantity;
		this.customer_id = customer_id;
		this.shop_number = shop_number;
	}

	public AppMenuDetailDao(int product_id, String customer_id, int shop_number, int order_id, int order_saleprice,
			int order_quantity, String order_payment) {
		super();
		this.product_id = product_id;
		this.customer_id = customer_id;
		this.shop_number = shop_number;
		this.order_id = order_id;
		this.order_saleprice = order_saleprice;
		this.order_quantity = order_quantity;
		this.order_payment = order_payment;
	}

	// method ------

	public AppMenuDetailDto tableClick() {

		AppMenuDetailDto dto = null;

		String whereStatement = " select product_name, product_price, product_explain, product_image from product ";
		String whereStatement2 = " where product_id =  " + Static_CustomerId.product_id  ;

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

			while (rs.next()) { // next를 통해 다른 행들을 선택할 수 있다.

				String product_name = rs.getString(1);
				int product_price = rs.getInt(2);
				String product_explain = rs.getString(3);

				// File
            	DBConnect.filename = DBConnect.filename + 1;
            	File file = new File(Integer.toString(DBConnect.filename));
            	FileOutputStream output = new FileOutputStream(file);
            	InputStream input = rs.getBinaryStream(4);
                byte[] buffer = new byte[1024];
                while (input.read(buffer) > 0) {
                    output.write(buffer);
				
                }
				
				dto = new AppMenuDetailDto(product_name, product_price, product_explain);
			}

			conn_mysql.close(); // close 해야 다른 사람의 DB도 들어올 수 있다.

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dto;

	}

////장바구니 버튼 클릭시 (상품 구매) cart  테이블에 데이터 입력
	public int insertCart() {
		PreparedStatement ps = null;
		int check = 0;

		try { // error확인

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql); // database에 접근을 하겠다. (선언자, 실행 x)
			Statement stmt_mysql = conn_mysql.createStatement(); // Connection conn_mysql 인스턴스를 이용해서 Statement 객체 생성

			// 쿼리 문장 만들기 (preparestatement)
			String query = "insert into cart (product_id, customer_id, shop_number, cart_date, cart_product_quantity) "; // relation)

			String query1 = "values (?,?,?,now(),?) ";

			// 위의 쿼리 문장대로 순서대로 쓴다.
			ps = conn_mysql.prepareStatement(query + query1);

			ps.setInt(1, product_id);
			ps.setString(2, customer_id);
			ps.setInt(3, shop_number);
			ps.setInt(4, cart_product_quantity);
			
			

			check = ps.executeUpdate(); // insert update method 이거 하나밖에 없다

			conn_mysql.close(); // close 해야 다른 사람의 DB도 들어올 수 있다.

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return check;

		}
		return check;
	}

}