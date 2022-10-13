package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.javalec.dao.AppStoreLocationDao;
import com.javalec.dao.AppTodayMenuDao;
import com.javalec.dto.AppTodayMenuDto;
import com.javalec.util.DBConnect;
import com.javalec.util.Static_CustomerId;
import com.javalec.util.Static_StoreLocation;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class AppHome extends JFrame {

	private JFrame frmMelhor;
	private JTextField tfStore;
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
		frmMelhor.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				todayMenuSum();
			}
		});
		frmMelhor.getContentPane().setBackground(new Color(235, 199, 189));
		frmMelhor.setTitle("Melhor 홈");
		frmMelhor.setBounds(100, 100, 273, 469);
		frmMelhor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMelhor.getContentPane().setLayout(null);
		frmMelhor.getContentPane().add(getTfStore());
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
	// 오늘의 메뉴 설명, 사진, 가격 나오는 페이지로 이동 
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("베스트 메뉴 주문하러가기");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frmMelhor.setVisible(false);
					AppTodayMenu.main(null);
				}
			});
			btnNewButton_1.setBounds(47, 270, 184, 29);
		}
		return btnNewButton_1;
	}
	private JLabel getLblBestMenuImage() {
		if (lblBestMenuImage == null) {
			lblBestMenuImage = new JLabel("사진 추가");
			lblBestMenuImage.setBounds(6, 89, 194, 122);
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
			btnNewButton_2.setBounds(83, 360, 117, 29);
		}
		return btnNewButton_2;
	}
	private JLabel getLblBestMenuName() {
		if (lblBestMenuName == null) {
			lblBestMenuName = new JLabel("사진");
			
			
			lblBestMenuName.setBounds(6, 242, 117, 16);
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
	
	
	
	//--------------
	
	// 인기메뉴 수량 가져오기
		public void todayMenuSum() {

			AppTodayMenuDao dao = new AppTodayMenuDao();
			ArrayList<AppTodayMenuDto> dtoList = dao.bestProductConditionList();

			// 수량을 해당 메소드로 보내줌
			todayMenuSearch(dtoList.get(0).getTodayMenu());
			
		}
		
		// 받은 수량으로 인기메뉴 출력
		public void todayMenuSearch(int sum) {
			
			AppTodayMenuDao dao = new AppTodayMenuDao(sum);
			AppTodayMenuDto dto = dao.todayMenuSearch();
			
			lblBestMenuName.setText(dto.getName());
			
			String filePath = Integer.toString(DBConnect.filename);
			
			
			lblBestMenuImage.setIcon(new ImageIcon(filePath));
			lblBestMenuImage.setHorizontalAlignment(SwingConstants.CENTER);
			
			
			File file = new File(filePath);
			file.delete();
			
			

			
			
			
		}
	
	
}