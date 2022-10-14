package com.javalec.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.dto.HB_BestProductListDto;
import com.javalec.util.DBConnect;

public class HB_BestProductListDao {

	String result;
	String bestProduct;
	
	
	public HB_BestProductListDao() {
		// TODO Auto-generated constructor stub
	}

	
	public HB_BestProductListDao(String result, String bestProduct) {
		super();
		this.result = result;
		this.bestProduct = bestProduct;
	}
	
	
	public ArrayList<HB_BestProductListDto> bestProductConditionList() {
		ArrayList<HB_BestProductListDto> bestProductList = new ArrayList<HB_BestProductListDto>();
		
		String whereStatement = "select p.product_image, p.product_image_filename, p.product_name, p.product_price, sum(o.order_quantity) from product p, orders o ";
		String whereStatement2 = "where o.product_id = p.product_id and " + result + " like + '%" + bestProduct + "%' and DATE(o.order_time) = DATE(NOW()) ";	
							                                             // WHERE절의 like 조건으로 검색기능 추가				금일 베스트메뉴만 출력	 
		String whereStatement3 = "group by p.product_id having sum(o.order_quantity) > 30";	
//		                                                           판매 수량의 총 합이 30보다 큰 데이터만 출력
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2 + whereStatement3);
			
			while(rs.next()) {

				String product_filename = rs.getString(2);
				String product_name = rs.getString(3);
				int product_price = rs.getInt(4);
				int order_quantity = rs.getInt(5);
				
				// File
            	File file = new File("./" + product_filename);
            	FileOutputStream output = new FileOutputStream(file);
            	InputStream input = rs.getBinaryStream(1);
                byte[] buffer = new byte[1024];
                while (input.read(buffer) > 0) {
                    output.write(buffer);
                }
				
				HB_BestProductListDto dto = new HB_BestProductListDto(product_filename, product_name, product_price, order_quantity);
//				HB_BestProductListDto dto = new HB_BestProductListDto(product_name, product_price, order_quantity);
				bestProductList.add(dto);
				
			}
			
			conn_mysql.close();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	
		return bestProductList;
	}
	
}
