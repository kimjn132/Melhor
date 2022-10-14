package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.javalec.dao.HS_StaffMenuDao;
import com.javalec.dao.HS_StaffMenuDao2;
import com.javalec.dto.HS_StaffMypageDto;
import com.javalec.util.HS_Static_StaffId;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HS_StaffMenu {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HS_StaffMenu window = new HS_StaffMenu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HS_StaffMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(227, 147, 132));
		frame.setTitle("전체 메뉴 페이지");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getBtnNewButton());
		frame.getContentPane().add(getBtnNewButton_1());
		frame.getContentPane().add(getBtnNewButton_2());
		frame.getContentPane().add(getBtnNewButton_3());
		frame.getContentPane().add(getBtnNewButton_4());
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {

			lblNewLabel = new JLabel("환영합니다");
			lblNewLabel.setFont(new Font("HY엽서M", Font.PLAIN, 15));
			lblNewLabel.setBounds(50, 30, 219, 25);
		}
		return lblNewLabel;
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("출근");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					HS_StaffMenuDao hs_StaffMenuDao = new HS_StaffMenuDao();

					hs_StaffMenuDao.inworkAction();
					

					JOptionPane.showMessageDialog(null, "Ok");
				}
			});
			btnNewButton.setFont(new Font("HY엽서M", Font.PLAIN, 20));
			btnNewButton.setBounds(50, 65, 146, 82);
		}
		return btnNewButton;
	}

	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("퇴근");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					HS_StaffMenuDao2 hs_StaffMenuDao2 = new HS_StaffMenuDao2();

					hs_StaffMenuDao2.outworkAction();

					JOptionPane.showMessageDialog(null, "Ok");

				}
			});
			btnNewButton_1.setFont(new Font("HY엽서M", Font.PLAIN, 20));
			btnNewButton_1.setBounds(245, 65, 146, 82);
		}
		return btnNewButton_1;
	}

	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("주문관리");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					frame.setVisible(false);// 창 종료

					HS_OrderManage.main(null);// 다음 창 열기

				}
			});
			btnNewButton_2.setFont(new Font("HY엽서M", Font.PLAIN, 20));
			btnNewButton_2.setBounds(50, 171, 146, 82);
		}
		return btnNewButton_2;
	}

	private JButton getBtnNewButton_3() {
		if (btnNewButton_3 == null) {
			btnNewButton_3 = new JButton("내 정보");
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					frame.setVisible(false);// 창 종료
					HS_StaffMypage.main(null);// 다음 창 열기

				}
			});
			btnNewButton_3.setFont(new Font("HY엽서M", Font.PLAIN, 20));
			btnNewButton_3.setBounds(245, 171, 146, 82);
		}
		return btnNewButton_3;
	}

	private JButton getBtnNewButton_4() {
		if (btnNewButton_4 == null) {
			btnNewButton_4 = new JButton("로그아웃");
			btnNewButton_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					frame.setVisible(false);// 창 종료
					HS_StaffLogin.main(null);// 전체메뉴 창 열기

				}
			});
			btnNewButton_4.setBounds(275, 10, 91, 23);
		}
		return btnNewButton_4;
	}

	// ---------------------------------------------function----------------------------------

}// end
