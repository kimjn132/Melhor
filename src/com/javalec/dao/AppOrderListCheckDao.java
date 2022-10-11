package com.javalec.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.dto.AppCartDto;
import com.javalec.dto.AppOrderListCheckDto;
import com.javalec.util.DBConnect;
import com.javalec.util.Static_CustomerId;

public class AppOrderListCheckDao {
	int cart_id;
	int cart_product_quantity;
	
	int product_id;
	String product_name;
	FileInputStream product_image;
	int product_price;
	String product_explain;
	
	int order_id;
	int order_quantity;
	int order_saleprice;
	String order_payment;
	
	String customer_id;
	
	int shop_number;
	
	
	
	public AppOrderListCheckDao() {
		// TODO Auto-generated constructor stub
	}

	public AppOrderListCheckDao(int order_id, String product_name, int order_quantity, int order_saleprice) {
		super();
		this.order_id = order_id;
		this.product_name = product_name;
		this.order_quantity = order_quantity;
		this.order_saleprice = order_saleprice;
	}
	
	
	
	public AppOrderListCheckDao(int cart_id, int cart_product_quantity, int product_price, String product_name) {
		super();
		this.cart_id = cart_id;
		this.cart_product_quantity = cart_product_quantity;
		this.product_price = product_price;
		this.product_name = product_name;
	}

	// method
	// 해당 고객 아이디의 장바구니 리스트  Db에서 가져오기 그리고 주문 리스트에 출력 
		public ArrayList<AppOrderListCheckDto> cartList() {
			// 연결
			ArrayList<AppOrderListCheckDto> dtoList = new ArrayList<AppOrderListCheckDto>(); // 3. 담은 데이터 arraylist 형식으로 가져와서
																			// 저장(매개체>>Main class로 보냄)
			// query문
			String whereStatement = "select c.cart_id, p.product_name, p.product_price, c.cart_product_quantity from product p, cart c, customer u ";
			String whereStatement1 = "where c.customer_id = '" + Static_CustomerId.customer_id + "' and p.product_id = c.product_id and c.customer_id = u.customer_id order by c.customer_id ";

			// 검색 포맷
			try { // error확인
					// connection
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
						DBConnect.pw_mysql); // database에 접근을 하겠다. (선언자, 아직 실행 단계 x)
				Statement stmt_mysql = conn_mysql.createStatement();

				ResultSet rs = stmt_mysql.executeQuery(whereStatement+whereStatement1);
				// 1. 데이터값 가져오기
				while (rs.next()) { // 다음 값이null 이면 false로 되어서 while문이 끝난다.

					int wkcartId = rs.getInt(1); // column 이름 or column 번호 쓰면 됨
					String wkproductName = rs.getString(2); // column 이름 or column 번호 쓰면 됨
					int wkproductPrice = rs.getInt(3);
					int wkproductQuantity = rs.getInt(4);

					// 2. instance에서 연결하고 데이터를 dto에 저장한다.
					AppOrderListCheckDto dto = new AppOrderListCheckDto(wkcartId, wkproductName, wkproductPrice, wkproductQuantity); // 가져온
																													// 데이터
																					// 역할
					dtoList.add(dto); // 2. 입력된 데이터 dtoList에도 저장
				}

				conn_mysql.close(); // close 해야 다른 사람의 DB도 들어올 수 있다.

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return dtoList;

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
				String query = "insert into orders (product_id, customer_id, shop_number, order_id, order_time, order_saleprice, order_quantity, order_payment) "; // relation)

				String query1 = "values (?,?,?,?,now(),?,?,?) ";

				// 위의 쿼리 문장대로 순서대로 쓴다.
				ps = conn_mysql.prepareStatement(query + query1);

				ps.setInt(1, product_id);
				ps.setString(2, customer_id);
				ps.setInt(3, shop_number);
				ps.setInt(4, order_id);
				ps.setInt(5, order_saleprice);
				ps.setInt(6, order_quantity);
				ps.setString(7, order_payment);

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
