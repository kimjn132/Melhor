package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
//import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;

import com.javalec.dao.KioskDao;
import com.javalec.dto.KioskDto;
import com.javalec.util.DBConnect;
import com.javalec.util.Static_ProductInfo;
import com.javalec.util.Static_StoreLocation;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class KioskMain {
//	private JFrame frame;
	private JFrame frmMelhorCoffeeKiosk;
	private JLabel lblTake;
	private JLabel lblShop;
	private JLabel background;
	private int count = 0;
	
	String[] backImg = new String[]{"/com/javalec/img/MelXCard.png","/com/javalec/img/MelXBig.png"};
	private JComboBox cbShop;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KioskMain window = new KioskMain();
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
	public KioskMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMelhorCoffeeKiosk = new JFrame();
		frmMelhorCoffeeKiosk.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				addComboShopName();
				Timer timer = new Timer();
				TimerTask task = new TimerTask() {
					
					@Override
					public void run() { // 일정 시간마다 Kiosk Main의 광고화면이 바뀌도록, 스위치로 이미지 변환 
						count++;
						switch(count%3) {
						case 1 : background.setIcon(new ImageIcon(KioskMain.class.getResource(backImg[0])));	break;
						case 2 : background.setIcon(new ImageIcon(KioskMain.class.getResource(backImg[1])));	break;
	
						}
						
					}
				};
				
				timer.schedule(task, 0, 1900);

			}
		});
		
		frmMelhorCoffeeKiosk.setTitle("Melhor Coffee Kiosk Main - 4Team");
		frmMelhorCoffeeKiosk.setBounds(100, 100, 440, 800);
		frmMelhorCoffeeKiosk.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMelhorCoffeeKiosk.getContentPane().setLayout(null);
		frmMelhorCoffeeKiosk.getContentPane().add(getCbShop());
		frmMelhorCoffeeKiosk.getContentPane().add(getLblTake());
		frmMelhorCoffeeKiosk.getContentPane().add(getLblShop());
		frmMelhorCoffeeKiosk.getContentPane().add(getBackground());
	
		
	}
	
	private JLabel getLblTake() {
		if (lblTake == null) {
			lblTake = new JLabel("포장");
			lblTake.setIcon(new ImageIcon(KioskMain.class.getResource("/com/javalec/img/takeout.png")));
			lblTake.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					//포장 마우스 클릭 , product 에서 포장정보 저장 
					frmMelhorCoffeeKiosk.setVisible(false);
					KioskOrdersCoffee.main(null);
					Static_ProductInfo.InOut=false;
					Static_StoreLocation.shop_name=(String) cbShop.getSelectedItem();
					findShopNumber();
					
				}
			});
			lblTake.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
			lblTake.setBounds(114, 635, 75, 50);
		}
		return lblTake;
	}
	private JLabel getLblShop() {
		if (lblShop == null) {
			lblShop = new JLabel("매장");
			lblShop.setIcon(new ImageIcon(KioskMain.class.getResource("/com/javalec/img/takein.png")));
			lblShop.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					//매장 마우스 클릭  product 에서 매장 정보 저장 
					frmMelhorCoffeeKiosk.setVisible(false);
					KioskOrdersCoffee.main(null);
					findShopNumber();
					Static_ProductInfo.InOut=true;
					Static_StoreLocation.shop_name=(String) cbShop.getSelectedItem();
				}
			});
			lblShop.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
			lblShop.setBounds(253, 635, 75, 50);
		}
		return lblShop;
	}
	
	
	private JLabel getBackground() {
		if (background == null) {
			background = new JLabel("");
			background.setIcon(new ImageIcon(KioskMain.class.getResource("/com/javalec/img/MelXBig.png")));
			background.setBounds(0, 0, 440, 766);
		}
		return background;
	}//getBackground End
	
	
	
	
	
	
	private JComboBox getCbShop() {  // 콤보박스 지점 
		if (cbShop == null) {
			cbShop = new JComboBox();
			cbShop.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					// 지점을 셀렉트 할떄 샾 넘버가 구해져야 함 
					System.out.println("itemStateChanged = "+cbShop.getSelectedItem());
				}
			});
			cbShop.setModel(
					new DefaultComboBoxModel(new String[] {}));
			cbShop.setBounds(307, 39, 127, 27);
		}
		return cbShop;
	}// JComboBox End
	
	
	
	////////////////////////////// 진형씨한테 받은 콤보박스 DB에서 shop_id 불러오기 코드 /////////////////


	
	private void addComboShopName() {
		
		KioskDao dao = new KioskDao();
		ArrayList<KioskDto> dtoList = dao.cbInsertShopid();
		int i=0;
		
		while(dtoList.size() > i) {
		cbShop.addItem(dtoList.get(i).getProduct_name());
			i++;
		}
		
	}//addComboShopName End
	
	
	
	
	
// KioskMain에 상단 지점을 고를때 DB에서 지점명 가져오는 문  // Dao에 있음, 지워도 되는거 
//
//	public ArrayList<KioskDto> cbInsertShopid(){ // 매장이름 가져오기 
//		
//		ArrayList<KioskDto> dtoList = new ArrayList<KioskDto>();
//		
//		String whereStatement = "select shop_name from shop;";
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql,DBConnect.id_mysql,DBConnect.pw_mysql);
//			Statement stmt_mysql = conn_mysql.createStatement();
//
//			ResultSet rs = stmt_mysql.executeQuery(whereStatement);
//			
//			while(rs.next()) {
//				String wkshop_name = rs.getString(1);
//				KioskDto dto = new KioskDto(wkshop_name);
//				dtoList.add(dto);
//			}
//		
//			conn_mysql.close();
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//			}
//		return dtoList;
//	}
	

	//매장, 포장 누를때 지점의 셀렉트아이템 값으로 shop_number 구하는거
	
	private void findShopNumber(){
		
		String whereStatement = "select shop_number from shop where shop_address = ";
		String whereStatement1 = "'"+cbShop.getSelectedItem()+"'";
		System.out.println(cbShop.getSelectedItem());
		System.out.println(whereStatement+whereStatement1);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql,DBConnect.id_mysql,DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			ResultSet rs = stmt_mysql.executeQuery(whereStatement+whereStatement1);
			System.out.println(rs);
			if(rs.next()) {
				int wkshop_number = rs.getInt(1);
				//KioskDto dto = new KioskDto(wkshop_number);
				Static_StoreLocation.shop_number = wkshop_number;
				System.out.println("스태틱 스토어 샾 넘버 "+Static_StoreLocation.shop_number);
			}
		
			conn_mysql.close();
			
		}catch(Exception e) {
			e.printStackTrace();
			}
	}//cbInsertShopid End
	
	
	
	
	
}// Class End
