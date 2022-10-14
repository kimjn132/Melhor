package com.javalec.base;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;

import com.javalec.dao.KioskDao;
import com.javalec.dto.KioskDto;
import com.javalec.util.DBConnect;
import com.javalec.util.Static_Kiosk;
import com.javalec.util.Static_OrdersInfo;
import com.javalec.util.Static_ProductInfo;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class KioskOrdersOption {

	private JFrame frmMelhorCoffeeKiosk;
	private JLabel lblBackGround;
	private JLabel lblTopAds;
	private JPanel panel;
	private JLabel lblMenuName;
	private JLabel lblQuantity;
	private JLabel lblLeftArrow;
	private JLabel lblRightArrow;
	private JButton btnNewButton;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblDanga;
	private JLabel lblCoffeeMuch;
	String product_p = null;
	String product_name = null;
	int product_price = 0;
	int cart_product_quantity = 1;
	int quanNum=1;
	int sum = 0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KioskOrdersOption window = new KioskOrdersOption();
					window.frmMelhorCoffeeKiosk.setVisible(true);
					window.frmMelhorCoffeeKiosk.setLocationRelativeTo(null);
			
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public KioskOrdersOption() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMelhorCoffeeKiosk = new JFrame();
		frmMelhorCoffeeKiosk.setTitle("Melhor Coffee Kiosk Orders Option- 4Team");
		frmMelhorCoffeeKiosk.setBounds(100, 100, 440, 800);
		frmMelhorCoffeeKiosk.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMelhorCoffeeKiosk.getContentPane().setLayout(null);
		frmMelhorCoffeeKiosk.getContentPane().add(getBtnNewButton());
		frmMelhorCoffeeKiosk.getContentPane().add(getPanel());
		frmMelhorCoffeeKiosk.getContentPane().add(getLblBackGround());
		frmMelhorCoffeeKiosk.getContentPane().add(getLblTopAds());
		frmMelhorCoffeeKiosk.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				preGetStatic();
				resultPriceSum();
				
			}
		});
	}
	private JLabel getLblBackGround() {
		if (lblBackGround == null) {
			lblBackGround = new JLabel("New label");
			lblBackGround.setIcon(new ImageIcon(KioskOrdersOption.class.getResource("/com/javalec/img/MelXCard.png")));
			lblBackGround.setBounds(0, 30, 440, 766);
		}
		return lblBackGround;
	}
	private JLabel getLblTopAds() {
		if (lblTopAds == null) {
			lblTopAds = new JLabel("New label");
			lblTopAds.setIcon(new ImageIcon(KioskOrdersOption.class.getResource("/com/javalec/img/TopMelXBig.png")));
			lblTopAds.setBounds(0, 0, 440, 29);
		}
		return lblTopAds;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(40, 110, 365, 515);
			panel.setLayout(null);
			panel.add(getLblMenuName());
			panel.add(getLblQuantity());
			panel.add(getLblLeftArrow());
			panel.add(getLblRightArrow());
			panel.add(getLblNewLabel());
			panel.add(getLblNewLabel_1());
			panel.add(getLblDanga());
			panel.add(getLblCoffeeMuch());
		}
		return panel;
	}
	private JLabel getLblMenuName() {
		if (lblMenuName == null) {
			lblMenuName = new JLabel("New label");
			lblMenuName.setBounds(170, 45, 167, 47);
		}
		return lblMenuName;
	}
	
	
	
	

	
	private JLabel getLblQuantity() {
		if (lblQuantity == null) {
			lblQuantity = new JLabel();
			lblQuantity.setText("1");
			lblQuantity.setFont(new Font("Lucida Grande", Font.PLAIN, 43));
			lblQuantity.setHorizontalAlignment(SwingConstants.CENTER);
			lblQuantity.setBounds(227, 137, 54, 40);
		}
		return lblQuantity;
	}
	private JLabel getLblLeftArrow() {
		if (lblLeftArrow == null) {
			lblLeftArrow = new JLabel("New label");
			lblLeftArrow.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					//숫자 줄이기, 1미만으로는 못가게 
					quanNum = Integer.parseInt(lblQuantity.getText());
						quanNum--;
					if(quanNum==0) {
						quanNum=1;
					}
					lblQuantity.setText(Integer.toString(quanNum));
					resultPriceSum();
					//////////////////////////////////////////////////////////////////////////
				}
			});
			lblLeftArrow.setIcon(new ImageIcon(KioskOrdersOption.class.getResource("/com/javalec/img/leftArrow.png")));
			lblLeftArrow.setBounds(155, 127, 60, 60);
		}
		return lblLeftArrow;
	}
	private JLabel getLblRightArrow() {
		if (lblRightArrow == null) {
			lblRightArrow = new JLabel("New label");
			lblRightArrow.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					// 숫자 올리기 50이상은 못가게 
						quanNum = Integer.parseInt(lblQuantity.getText());
						quanNum++;
							lblQuantity.setText(Integer.toString(quanNum));
						if(quanNum==51) {
							quanNum=50;
							JOptionPane.showMessageDialog(null, "50잔 이상 주문은 직원에게 문의해 주세요");
							lblQuantity.setText(Integer.toString(quanNum));
						}// if end 
						resultPriceSum();
				}
			});
			lblRightArrow.setIcon(new ImageIcon(KioskOrdersOption.class.getResource("/com/javalec/img/rightArrow.png")));
			lblRightArrow.setBounds(299, 127, 60, 60);
		}
		return lblRightArrow;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("담기");
			btnNewButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					// 옵션 선택 후 담기 
					product_name=lblMenuName.getText();
					Static_OrdersInfo.QuantityNum=Integer.parseInt(lblQuantity.getText());
					Static_ProductInfo.product_name=lblMenuName.getText();
					KioskOrdersCoffee order = new KioskOrdersCoffee();
					order.AddKioskCartInsert();
					
					frmMelhorCoffeeKiosk.setVisible(false);
					KioskOrdersCoffee.main(null);
					
				}
			});
			btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
			btnNewButton.setBounds(135, 637, 180, 50);
		}
		return btnNewButton;
	}


		private JLabel getLblNewLabel() {
			if (lblNewLabel == null) {
				lblNewLabel = new JLabel("단가 : ");
				lblNewLabel.setBounds(170, 233, 48, 27);
			}
			return lblNewLabel;
		}
		private JLabel getLblNewLabel_1() {
			if (lblNewLabel_1 == null) {
				lblNewLabel_1 = new JLabel("총 금액 : ");
				lblNewLabel_1.setBounds(155, 272, 51, 27);
			}
			return lblNewLabel_1;
		}
		private JLabel getLblDanga() {
			if (lblDanga == null) {
				lblDanga = new JLabel("New label");
				lblDanga.setBounds(208, 238, 109, 22);
			}
			return lblDanga;
		}
		private JLabel getLblCoffeeMuch() {
			if (lblCoffeeMuch == null) {
				lblCoffeeMuch = new JLabel("New label");
				lblCoffeeMuch.setBounds(208, 272, 109, 27);
			}
			return lblCoffeeMuch;
		}
	
	////////////////////////////////////////////////////////////////////////////////////
	

	private void preGetStatic() {

	//	KioskDao orderListDao = new KioskDao(); 
		//ArrayList<KioskDto> dtoList = orderListDao.SelectList(); 
	System.out.println(Static_ProductInfo.product_name);
	String whereStatement = "select product_price ";
	String whereStatement1 = "from product where product_name = '"+Static_ProductInfo.product_name+"'";


		//String whereStatement = "product_price from product where product_name='"+Static_ProductInfo.getProduct_name()+"'";
	try { 
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,DBConnect.pw_mysql);// DB linkStart 
		Statement stmt_mysql = conn_mysql.createStatement();
		
		ResultSet rs = stmt_mysql.executeQuery(whereStatement+whereStatement1);
		while (rs.next()) { 
			
//			 Static_ProductInfo.product_name = rs.getString(1); // 나중에 이미지도 같이 불러와서 키오스크처럼 보이게끔 할꺼에요 
//			 Static_OrdersInfo.product_price = rs.getInt(2);
			 
			 //product_name = rs.getString(1);
			 product_price = rs.getInt(1);
			// cart_product_quantity = rs.getInt(3);
//			KioskDto KioskOrderDto = new KioskDto(wkName,wkCart_id); // KioskOrderDto이름으로 제품 이름만 받아와서 kisosktoLis에 반복해서 추가 
//			dtoList.add(KioskOrderDto); 
		}
		product_price = Static_OrdersInfo.product_price;
			
			conn_mysql.close();
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	
}//SelectList End


//	private void getOrders() {
//
//	//	KioskDao orderListDao = new KioskDao(); 
//		//ArrayList<KioskDto> dtoList = orderListDao.SelectList(); 
//	
////	String whereStatement = "select p.product_price ";
////	String whereStatement1 = "from , product p where c.product_id = p.product_id ;";
//		
//
//		String whereStatement = "product_price from product where product_name='"+Static_ProductInfo.getProduct_name()+"'";
//	try { 
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,DBConnect.pw_mysql);// DB linkStart 
//		Statement stmt_mysql = conn_mysql.createStatement();
//		
//		ResultSet rs = stmt_mysql.executeQuery(whereStatement);
//		System.out.println(whereStatement);
//		while (rs.next()) { 
//			
////			 Static_ProductInfo.product_name = rs.getString(1); // 나중에 이미지도 같이 불러와서 키오스크처럼 보이게끔 할꺼에요 
//			 Static_OrdersInfo.product_price = rs.getInt(1);
////			 cart_product_quantity = rs.getInt(3);
////			KioskDto KioskOrderDto = new KioskDto(wkName,wkCart_id); // KioskOrderDto이름으로 제품 이름만 받아와서 kisosktoLis에 반복해서 추가 
//			
////			dtoList.add(KioskOrderDto); 
//		}
//			
//			conn_mysql.close();
//		
//	} catch (Exception e) {
//		// TODO: handle exception
//		e.printStackTrace();
//	}
//	
//}//SelectList End
	
	
	
		
		private void resultPriceSum() {
//			product_p = Integer.toString(product_price);
			
			sum=quanNum*(Static_OrdersInfo.product_price);
	
			lblMenuName.setText(Static_ProductInfo.product_name);
			lblDanga.setText(Integer.toString( Static_OrdersInfo.product_price)); //제품 단가 나와야 댐 
			lblCoffeeMuch.setText(Integer.toString(sum)); // 갯수에 따른 금액 나와야 댐 

	}
		public void resultPriceAllSum() {
			sum=quanNum*(Static_OrdersInfo.product_price);
		}
	
	
	
}//End
