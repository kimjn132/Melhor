package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.javalec.dao.AppTodayMenuDao;
import com.javalec.dto.AppTodayMenuDto;
import com.javalec.util.DBConnect;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class AppTodayMenu {

	private JFrame frmMelhor;
	private JLabel lblEmployee_image;
	private JLabel lblNewLabel_1;
	private JLabel lblPrice;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JTextField tfFilePath;
	private JTextPane tfExplain;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppTodayMenu window = new AppTodayMenu();
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
	public AppTodayMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMelhor = new JFrame();
		frmMelhor.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				todayMenuSum();
			}
		});
		frmMelhor.setTitle("Melhor - 오늘의 메뉴");
		frmMelhor.setBounds(100, 100, 285, 469);
		frmMelhor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMelhor.getContentPane().setLayout(null);
		frmMelhor.getContentPane().add(getLblEmployee_image());
		frmMelhor.getContentPane().add(getLblNewLabel_1());
		frmMelhor.getContentPane().add(getLblPrice());
		frmMelhor.getContentPane().add(getBtnNewButton());
		frmMelhor.getContentPane().add(getBtnNewButton_1());
		frmMelhor.getContentPane().add(getTfFilePath());
		frmMelhor.getContentPane().add(getTfExplain());
	}

	private JLabel getLblEmployee_image() {
		if (lblEmployee_image == null) {
			lblEmployee_image = new JLabel("");
			lblEmployee_image.setHorizontalAlignment(SwingConstants.CENTER);
			lblEmployee_image.setBounds(12, 0, 247, 153);
		}
		return lblEmployee_image;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("가격:");
			lblNewLabel_1.setBounds(36, 175, 61, 16);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblPrice() {
		if (lblPrice == null) {
			lblPrice = new JLabel("New label");
			lblPrice.setBounds(109, 175, 128, 16);
		}
		return lblPrice;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("장바구니");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// 장바구니로 이동 
					frmMelhor.setVisible(false);
//					AppCart.main(null);
				}
			});
			btnNewButton.setBounds(24, 384, 117, 29);
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("바로주문");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frmMelhor.setVisible(false);
//					AppOrderListCheck.main(null);
				}
			});
			btnNewButton_1.setBounds(150, 384, 117, 29);
		}
		return btnNewButton_1;
	}
	private JTextField getTfFilePath() {
		if (tfFilePath == null) {
			tfFilePath = new JTextField();
			tfFilePath.setBounds(36, 245, 96, 21);
			tfFilePath.setColumns(10);
			tfFilePath.setVisible(false);
		}
		return tfFilePath;
	}
	private JTextPane getTfExplain() {
		if (tfExplain == null) {
			tfExplain = new JTextPane();
			tfExplain.setEditable(false);
			tfExplain.setBounds(0, 201, 271, 178);
		}
		return tfExplain;
	}
	// ----------------------------------------------------------------------------
	
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
		
		lblPrice.setText(Integer.toString(dto.getPrice()));
		tfExplain.setText(dto.getExplain());
		
		String filePath = Integer.toString(DBConnect.filename);
		tfFilePath.setText(filePath);
		
		lblEmployee_image.setIcon(new ImageIcon(filePath));
		lblEmployee_image.setHorizontalAlignment(SwingConstants.CENTER);
		
		File file = new File(filePath);
		file.delete();
		
		tfFilePath.setText("");
		
	}
	
	
	
} // End Line
