package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppTodayMenu {

	private JFrame frmMelhor;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

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
		frmMelhor.setTitle("Melhor - 오늘의 메뉴");
		frmMelhor.setBounds(100, 100, 273, 469);
		frmMelhor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMelhor.getContentPane().setLayout(null);
		frmMelhor.getContentPane().add(getLblNewLabel());
		frmMelhor.getContentPane().add(getLblNewLabel_1());
		frmMelhor.getContentPane().add(getLblNewLabel_2());
		frmMelhor.getContentPane().add(getLblNewLabel_3());
		frmMelhor.getContentPane().add(getBtnNewButton());
		frmMelhor.getContentPane().add(getBtnNewButton_1());
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("제품 사진");
			lblNewLabel.setBounds(36, 25, 198, 173);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("가격:");
			lblNewLabel_1.setBounds(36, 219, 61, 16);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("New label");
			lblNewLabel_2.setBounds(109, 219, 128, 16);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("제품설명");
			lblNewLabel_3.setBounds(36, 260, 198, 109);
		}
		return lblNewLabel_3;
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
}
