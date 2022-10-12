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
import com.javalec.util.Static_StoreLocation;

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
	int order_stamp;

	String customer_id;

	int shop_number;

	public AppOrderListCheckDao() {
		// TODO Auto-generated constructor stub
	}

	public AppOrderListCheckDao(int cart_id, String product_name, int product_price, int cart_product_quantity) {
		super();
		this.cart_id = cart_id;
		this.product_name = product_name;
		this.product_price = product_price;
		this.cart_product_quantity = cart_product_quantity;
	}

	public AppOrderListCheckDao(int product_id, String customer_id, int shop_number, int order_id, String order_payment, int order_stamp) {
		super();
		this.product_id = product_id;
		this.customer_id = customer_id;
		this.shop_number = shop_number;
		this.order_id = order_id;
		this.order_payment = order_payment;
		this.order_stamp = order_stamp;

	}

	public AppOrderListCheckDao(String customer_id, int shop_number) {
		super();
		this.customer_id = customer_id;
		this.shop_number = shop_number;
	}

	// method
	// 해당 고객 아이디의 장바구니 리스트 Db에서 가져오기 그리고 주문 리스트에 출력
	public ArrayList<AppOrderListCheckDto> cartList() {
		// 연결
		ArrayList<AppOrderListCheckDto> dtoList = new ArrayList<AppOrderListCheckDto>(); // 3. 담은 데이터 arraylist 형식으로
																							// 가져와서
		// 저장(매개체>>Main class로 보냄)
		// query문
		String whereStatement = "select c.cart_id, p.product_name, p.product_price, c.cart_product_quantity from product p, cart c, customer u ";
		String whereStatement1 = "where c.customer_id = '" + Static_CustomerId.customer_id
				+ "' and p.product_id = c.product_id and c.customer_id = u.customer_id order by c.customer_id ";

		// 검색 포맷
		try { // error확인
				// connection
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql); // database에 접근을 하겠다. (선언자, 아직 실행 단계 x)
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement1);
			// 1. 데이터값 가져오기
			while (rs.next()) { // 다음 값이null 이면 false로 되어서 while문이 끝난다.

				int wkcartId = rs.getInt(1); // column 이름 or column 번호 쓰면 됨
				String wkproductName = rs.getString(2); // column 이름 or column 번호 쓰면 됨
				int wkproductPrice = rs.getInt(3);
				int wkproductQuantity = rs.getInt(4);

				// 2. instance에서 연결하고 데이터를 dto에 저장한다.
				AppOrderListCheckDto dto = new AppOrderListCheckDto(wkcartId, wkproductName, wkproductPrice,
						wkproductQuantity); // 가져온
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

	
//	// 결제하기 버튼 클릭시 (상품 구매) orders 테이블에 데이터 입력
//	public int insertOrder() {
//		PreparedStatement ps = null;
//		int check = 0;
//
//		try { // error확인
//
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
//					DBConnect.pw_mysql); // database에 접근을 하겠다. (선언자, 실행 x)
//			Statement stmt_mysql = conn_mysql.createStatement(); // Connection conn_mysql 인스턴스를 이용해서 Statement 객체 생성
//
//			// 쿼리 문장 만들기 (preparestatement)
//			String query1 = "insert into orders (product_id, customer_id, shop_number, order_id, order_time, order_saleprice, order_quantity, order_payment, order_stamp) ";
//			String query2 = "select '" + Static_CustomerId.product_id + "', '" + Static_CustomerId.customer_id + "' , '"
//					+ Static_StoreLocation.shop_number 
//					+ "' , ?, now(), p.product_price, c.cart_product_quantity, ?, ? ";
//			String query3 = "from product p, cart c, customer u, shop s ";
//			String query4 = "where p.product_id = c.product_id and c.customer_id = u.customer_id and s.shop_number = c.shop_number and c.customer_id = '"
//					+ Static_CustomerId.customer_id + " ' ";
//
//			// 위의 쿼리 문장대로 순서대로 쓴다.
//			ps = conn_mysql.prepareStatement(query1 + query2 + query3 + query4);
//
//			ps.setInt(1, product_id);
//			ps.setString(2, customer_id);
//			ps.setInt(3, shop_number);
//			ps.setInt(4, order_id);
//			ps.setString(5, order_payment);
//			ps.setInt(6, order_stamp);
//
//			check = ps.executeUpdate(); // insert update method 이거 하나밖에 없다
//
//			conn_mysql.close(); // close 해야 다른 사람의 DB도 들어올 수 있다.
//
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			return check;
//
//		}
//		return check;
//	}

	
	// 삭제
	public Boolean deleteAction() {
		PreparedStatement ps = null; // 입력 수정 삭제

		try { // error확인

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql); // database에 접근을 하겠다. (선언자, 아직 실행 단계 x)

			// 쿼리 문장 만들기 (preparestatement)
			String query = "delete from cart where customer_id = ? and shop_number = ? "; // relation) 여기 띄어쓰기 있어야지 에러
																							// 안걸림

			// 바로 위 쿼리 문장을 실행하기 위함
			ps = conn_mysql.prepareStatement(query);// insert(), value()
			ps.setString(1, customer_id); // trim 필요 없음, editable이 안됨,, integer.parseInt 문자열로바꿔
			ps.setInt(2, shop_number);

			ps.executeUpdate(); // insert update, delete method 이거 하나밖에 없다 (셋 중에 하나 실행하는 메소드)

			conn_mysql.close(); // close 해야 다른 사람의 DB도 들어올 수 있다.

//						JOptionPane.showMessageDialog(null, tfName.getText() + "님의 정보가 삭제되었습니다.");>>address class에 있어야 됨 

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
