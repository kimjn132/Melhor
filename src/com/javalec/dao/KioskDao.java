package com.javalec.dao;

//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.base.KioskOrdersOption;
import com.javalec.dto.KioskDto;
import com.javalec.dto.KioskRealFinalLastResultSum;
import com.javalec.util.DBConnect;
import com.javalec.util.Static_OrdersInfo;
import com.javalec.util.Static_ProductInfo;
import com.javalec.util.Static_StoreLocation;

public class KioskDao {

	//Field
//	FileInputStream file;

	
	int product_id;
	String product_name;
	int cart_id;
	
	
	
	
	//Constructor
	
	public KioskDao(int product_id) {
		super();
		this.product_id = product_id;
	}

	public KioskDao() {
		// TODO Auto-generated constructor stub
	}
	
//	
//	public KioskDao(FileInputStream file) {
//		super();
//		this.file = file;
//	}
	
	
	
	public KioskDao(String product_name) {
		super();
		this.product_name = product_name;
	}
	
	
	
	
	// Method
	
	

	public ArrayList<KioskDto> SelectList() { // 상품리스트 출력, 

		ArrayList<KioskDto> kioskdtoList = new ArrayList<KioskDto>(); 
		//Dto에 있는 Constructor 형식으로 kiosktoList이름으로 ArrayList new로 생성 

		//String whereStatement = "select product_id, product_name, product_price from product ";
		String whereStatement = "select p.product_id, p.product_name, p.product_price from register r, product p where p.product_id = r.product_id and register_out_date IS NULL;";
					//제품이름을 불러올껀데, 관리자가 판매하려고 등록한 제품중 판매기간이 끝난 날자가 null값인=판매하는중인 제품이름으로 불러올꺼임 
		try { 
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,DBConnect.pw_mysql);// DB linkStart 
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement);// + whereStatement2);
			
			while (rs.next()) { 
				int seqno = rs.getInt(1);
				String wkName = rs.getString(2); // 나중에 이미지도 같이 불러와서 키오스크처럼 보이게끔 할꺼에요 
				int wkPrice = rs.getInt(3);
				
				KioskDto KioskOrderDto = new KioskDto(seqno, wkName,wkPrice); // KioskOrderDto이름으로 제품 이름만 받아와서 kisosktoLis에 반복해서 추가 
				
				kioskdtoList.add(KioskOrderDto); 
			}
			conn_mysql.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return kioskdtoList;

	}//SelectList End

	
	
	
	

	public int cartInsert() { // 상품 클릭시 장바구니에 상품 담기
		
		PreparedStatement ps = null;
		int count = 0;
		
		try { // error확인

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw_mysql); // database에 접근을 하겠다. (선언자, 실행 x)
			Statement stmt_mysql = conn_mysql.createStatement(); // Connection conn_mysql 인스턴스를 이용해서 Statement 객체 생성
			System.out.println("SQL cartInsert shop_number = "+ Static_StoreLocation.getShop_number());
			// 쿼리 문장 만들기 (preparestatement)
	//		String query = "insert into cart (product_id, customer_id, cart_date, cart_product_quantity) "; // relation) 여기 띄어쓰기 있어야지 에러 안걸림
			String query = "insert into cart (product_id, customer_id, shop_number, cart_date, cart_product_quantity) "; // relation) 여기 띄어쓰기 있어야지 에러 안걸림
				//한별씨꺼에 shop_id가 빠져있었음 
			String query1 = "values (?,?, 0, now(), ?)";
			// 위의 쿼리 문장대로 순서대로 쓴다.
			ps = conn_mysql.prepareStatement(query + query1);
			ps.setInt(1, Static_ProductInfo.getProduct_id());
				//System.out.println("SQL cartInsert Static_product_id = "+ Static_ProductInfo.getProduct_id());	
			ps.setInt(2, Static_StoreLocation.shop_number);
				//System.out.println("SQL cartInsert shop_number = "+ Static_StoreLocation.getShop_number());
			ps.setInt(3, Static_OrdersInfo.QuantityNum);
				//System.out.println("SQL cartInsert QuantityNum = " + Static_OrdersInfo.getQuantityNum() );
					
					//라벨 텍스트 가져오
					
			count = ps.executeUpdate(); // insert update method 이거 하나밖에 없다

			conn_mysql.close(); // close 해야 다른 사람의 DB도 들어올 수 있다.

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return count=0;
			
		}
		return count=1;
	}
	
	
	
	
	public ArrayList<KioskDto> cartSelectList() { // 메뉴 선택 시 장바구니 추가 
		
		ArrayList<KioskDto> dtoList = new ArrayList<KioskDto>(); 
		
		String whereStatement = "select p.product_name, c.cart_id, c.cart_product_quantity, p.product_price from product p, cart c where p.product_id = c.product_id ;";
	//	String whereStatement = "select p.product_name, c.cart_id , c.cart_product_quantity from product p, cart c where p.product_id = c.product_id ;";
		int wkTotalPrice = 0;
		try { 
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,DBConnect.pw_mysql);// DB linkStart 
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(whereStatement);
			
			while (rs.next()) { 
				
				String wkName = rs.getString(1); // 나중에 이미지도 같이 불러와서 키오스크처럼 보이게끔 할꺼에요 
				int wkCart_id = rs.getInt(2);
				int wkQuanT = rs.getInt(3);
				wkTotalPrice = rs.getInt(4);
 				KioskDto KioskOrderDto = new KioskDto(wkName,wkCart_id,wkQuanT,wkTotalPrice); // KioskOrderDto이름으로 제품 이름만 받아와서 kisosktoLis에 반복해서 추가 
				
				dtoList.add(KioskOrderDto); 
			}
			conn_mysql.close();
			System.out.println("KioskDto에서 불러온 wkTotalPrice = "+wkTotalPrice);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dtoList;
		
	}//SelectList End
	
	
	
	public boolean deleteCart() { // 장바구니 상품에 delete date insert 하기
	
		PreparedStatement ps = null;
		try { // error확인

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw_mysql); // database에 접근을 하겠다. (선언자, 실행 x)
			Statement stmt_mysql = conn_mysql.createStatement(); // Connection conn_mysql 인스턴스를 이용해서 Statement 객체 생성

			String query = "delete cart from cart where cart_id = ? ;";

			// 위의 쿼리 문장대로 순서대로 쓴다.
			ps = conn_mysql.prepareStatement(query);
			ps.setInt(1, Static_ProductInfo.getCart_id());

			ps.executeUpdate(); // insert update method 이거 하나밖에 없다

				
			conn_mysql.close(); // close 해야 다른 사람의 DB도 들어올 수 있다.

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
			
		}
		return true;
	} //장바구니 상품 delete End
	
	
	
	
	
	// 결제하기 누르면 order table로 db 넘어감 
//
//
//	public ArrayList<KioskDto>  cometomyproductname() {
//		ArrayList<KioskDto> dtoList = new ArrayList<KioskDto>(); 
//		
//		String whereStatement = "select product_id from product where product_name = '"  + product_name + "' ";
//
//		try { 
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,DBConnect.pw_mysql);// DB linkStart 
//			Statement stmt_mysql = conn_mysql.createStatement();
//			
//			ResultSet rs = stmt_mysql.executeQuery(whereStatement);
//			
//			while (rs.next()) { 
//				
//				int wkProduct_id = rs.getInt(1);
//				
//				KioskDto KioskOrderDto = new KioskDto(wkProduct_id); // KioskOrderDto이름으로 제품 이름만 받아와서 kisosktoLis에 반복해서 추가 
//				
//				dtoList.add(KioskOrderDto); 
//			}
//			conn_mysql.close();
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		return dtoList;
//		
//	}//SelectList EndEnd
	
	
	
	
//	public boolean InsertOrders() { // Orders Table에 장바구니에 있는 정보들 넣기 
// 
//		PreparedStatement ps = null;
//
//		try { // error확인
//			
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw_mysql); // database에 접근을 하겠다. (선언자, 실행 x)
//			Statement stmt_mysql = conn_mysql.createStatement(); // Connection conn_mysql 인스턴스를 이용해서 Statement 객체 생성
//
//			// 쿼리 문장 만들기 (preparestatement)
//			String query = "insert into orders(order_id,product_id,customer_id,shop_number,order_seqno,order_time,order_saleprice,order_quantity,order_delete_time,order_stamp) "; // relation) 여기 띄어쓰기 있어야지 에러 안걸림
//			String query1 = "values (?,?,?,?,?,now(),?,?,now(),?);";
//			// 위의 쿼리 문장대로 순서대로 쓴다.
//				ps = conn_mysql.prepareStatement(query + query1);
//				ps.setInt(1, 0); //order_id
//				ps.setInt(2, 3); // product_id 제품명 select p.product_name, c.cart_id from product p, cart c where p.product_id = c.product_id
//				ps.setInt(3, 0); //customer_id
//				ps.setInt(4, 123); // Shop Numer 나중에 받아오기
//				ps.setInt(5, 0);//order_seqno
//				ps.setInt(6, 0);//order_saleprice -->가격 받아오기 
//				ps.setInt(7, 0);//order_quantity --> 갯수 가져오기 
//				ps.setInt(8, 1);//order_stamp
//			
//				ps.executeUpdate(); // insert update method 이거 하나밖에 없다
//
//			conn_mysql.close(); // close 해야 다른 사람의 DB도 들어올 수 있다.
//
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			return  false;
//		}
//		return  true;
//	}
	
//  주현씨가 보내준 소스 
//	insert into orders (product_id, customer_id, shop_number, order_id, order_time, order_saleprice, order_quantity, order_stamp)
//	select c.product_id, c.customer_id, c.shop_number, '1', now(), p.product_price, c.cart_product_quantity, 1
//		from product p, cart c, customer u, shop s
//        where p.product_id = c.product_id and c.customer_id = u.customer_id and s.shop_number = c.shop_number and c.customer_id = 'ka';
////	

	public boolean InsertOrdersSQL() { // Orders Table에 장바구니에 있는 정보들 넣기 
		 
		PreparedStatement ps = null;

		try { // error확인
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw_mysql); // database에 접근을 하겠다. (선언자, 실행 x)
			Statement stmt_mysql = conn_mysql.createStatement(); // Connection conn_mysql 인스턴스를 이용해서 Statement 객체 생성

			// 쿼리 문장 만들기 (preparestatement)
				//---> 한별씨 sql에 cart에 shop_id가 없어서 기존꺼 주석처리 후 밑에 다시 넣음 
			String query = "insert into orders (product_id, customer_id, shop_number, order_seqno, order_time, order_saleprice, order_quantity, order_stamp) "; 
			String query1 = "select p.product_id, c.customer_id,"+Static_StoreLocation.shop_number+",300,now(), p.product_price, c.cart_product_quantity,c.cart_product_quantity ";
			String query2 = "from product p, cart c ";
			String query3 = "where p.product_id = c.product_id and c.customer_id=0 ";
			String query4 = "order by c.shop_number" ;

				// ====> 한별씨가 cart 에 shop_number 잊어먹었따고 해서 기존꺼 
//			String query = "insert into orders (product_id, customer_id, order_seqno, order_time, order_saleprice, order_quantity, order_stamp) "; 
//			String query1 = "select p.product_id, c.customer_id, 300 ,now(), p.product_price, c.cart_product_quantity,1 ";
//			String query2 = "from product p, cart c ";
//			String query3 = "where p.product_id = c.product_id ";//and c.customer_id=0 ";
		//	String query4 = "order by c.shop_number" ;
			
			
//			String query = "insert into orders (product_id, customer_id, shop_number,order_seqno, order_time, order_saleprice, order_quantity, order_stamp) "
//					+ "select p.product_id, c.customer_id, c.shop_number,132,now(), p.product_price, c.cart_product_quantity,1 from product p, cart c where p.product_id = c.product_id and c.customer_id=0 order by c.shop_number;" ;
			
			
			
			ps = conn_mysql.prepareStatement(query+query1+query2+query3);//+query4);
			ps.executeUpdate(); // insert update method 이거 하나밖에 없다

			conn_mysql.close(); // close 해야 다른 사람의 DB도 들어올 수 있다.

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return  false;
		}
		return  true;
	}
	
	
	
	
	
	
	
	//////////////// --KioskMain shop combobox-- ///////////////////
	
	public ArrayList<KioskDto> cbInsertShopid(){ // 매장이름 가져오기 
		
		ArrayList<KioskDto> dtoList = new ArrayList<KioskDto>();
		
		String whereStatement = "select shop_name from shop;";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql,DBConnect.id_mysql,DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement);
			
			while(rs.next()) {
				String wkshop_name = rs.getString(1);
				KioskDto dto = new KioskDto(wkshop_name);
				dtoList.add(dto);
			}
		
			conn_mysql.close();
			
		}catch(Exception e) {
			e.printStackTrace();
			}
		return dtoList;
	}
//////////////  KioskMain Shops Name Combo Box End //////////////
	

	
	
	
	
}//Class end
