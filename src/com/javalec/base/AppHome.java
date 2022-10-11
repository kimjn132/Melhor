package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.javalec.dao.AppStoreLocationDao;
import com.javalec.util.Static_CustomerId;
import com.javalec.util.Static_StoreLocation;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppHome extends JFrame {

	private JFrame frmMelhor;
	private JTextField tfStore;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JLabel lblBestMenuImage;
	private JButton btnNewButton_2;
	private JLabel lblBestMenuName;
	private JButton btnNewButton_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppHome window = new AppHome();
					window.frmMelhor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppHome() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMelhor =  new JFrame();
		frmMelhor.getContentPane().setBackground(new Color(235, 199, 189));
		frmMelhor.setTitle("Melhor 홈");
		frmMelhor.setBounds(100, 100, 273, 469);
		frmMelhor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMelhor.getContentPane().setLayout(null);
		frmMelhor.getContentPane().add(getTfStore());
		frmMelhor.getContentPane().add(getBtnNewButton());
		frmMelhor.getContentPane().add(getBtnNewButton_1());
		frmMelhor.getContentPane().add(getLblBestMenuImage());
		frmMelhor.getContentPane().add(getBtnNewButton_2());
		frmMelhor.getContentPane().add(getLblBestMenuName());
		frmMelhor.getContentPane().add(getBtnNewButton_3());
	}
	// 지점 추가 텍스트필드 누르면 위치 선정 페이지 
	private JTextField getTfStore() {
		if (tfStore == null) {
			tfStore = new JTextField();
			tfStore.setEditable(false);
			AppStoreLocationDao dao = new AppStoreLocationDao(getName().toString());
			tfStore.setText(Static_StoreLocation.shop_name);
			
			tfStore.setBounds(133, 30, 130, 26);
			tfStore.setColumns(10);
		}
		return tfStore;
	}
	// 포인트 확인하는 페이지 이동 
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("스탬프 확인하기");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frmMelhor.setVisible(false);
					AppMenuImageInsert.main(null);
				}
			});
			btnNewButton.setBounds(17, 279, 117, 29);
		}
		return btnNewButton;
	}
	// 오늘의 메뉴 설명, 사진, 가격 나오는 페이지로 이동 
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("베스트 메뉴");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frmMelhor.setVisible(false);
					AppTodayMenu.main(null);
				}
			});
			btnNewButton_1.setBounds(17, 119, 117, 29);
		}
		return btnNewButton_1;
	}
	private JLabel getLblBestMenuImage() {
		if (lblBestMenuImage == null) {
			lblBestMenuImage = new JLabel("사진 추가");
			lblBestMenuImage.setBounds(146, 84, 117, 96);
		}
		return lblBestMenuImage;
	}
	// 메뉴 페이지로 이동 
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("주문하러가기");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frmMelhor.setVisible(false);
					AppMenuList.main(null);
				}
			});
			btnNewButton_2.setBounds(83, 381, 117, 29);
		}
		return btnNewButton_2;
	}
	private JLabel getLblBestMenuName() {
		if (lblBestMenuName == null) {
			lblBestMenuName = new JLabel("ex) 아메리카노");
			
			
			
			lblBestMenuName.setBounds(146, 192, 117, 16);
		}
		return lblBestMenuName;
	}
	private JButton getBtnNewButton_3() {
		if (btnNewButton_3 == null) {
			btnNewButton_3 = new JButton("지점추가");
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frmMelhor.setVisible(false);
					AppStoreLocation.main(null);
				}
			});
			btnNewButton_3.setBounds(0, 30, 117, 29);
		}
		return btnNewButton_3;
	}



// function -------------

	// DB to Table db에서 테이블로 정보 가져오기 
//	private void bestMenu() {
//		// Dao연결 
//		AppStoreLocationDao dao = new AppStoreLocationDao();			//연결 
//		ArrayList<AppStoreLocationDto> dtoList = dao.shopList();		// 타입 = 실행 메소드 4. arraylist 형식으로 가져와서, 해당 Dao method 실행 
//		
//		int listCount = dtoList.size();				//	 데이터의 열의 수를 나타냄 
//		
//		//위의 데이터 행의 수만큼 정보 출력  
//		for(int index = 0; index < listCount; index++) {
//			String temp = Integer.toString(dtoList.get(index).getShop_number());		//  temp: seqno 할당 
//			String[] qTxt = {temp, dtoList.get(index).getShop_name(), dtoList.get(index).getShop_address(), dtoList.get(index).getShop_telno()};	//1행의 박스 할당  
//			Outer_Table.addRow(qTxt);	//출력  
//		}
//		
//		
//	}





}