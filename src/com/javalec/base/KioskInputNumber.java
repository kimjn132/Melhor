package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class KioskInputNumber {

	private JFrame frmMelhorCoffeeKiosk;
	private JLabel topAds;
	private JLabel middleAds;
	private JPanel panel;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KioskInputNumber window = new KioskInputNumber();
					window.frmMelhorCoffeeKiosk.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public KioskInputNumber() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMelhorCoffeeKiosk = new JFrame();
		frmMelhorCoffeeKiosk.setTitle("Melhor Coffee Kiosk InputNumber - 4Team");
		frmMelhorCoffeeKiosk.setBounds(100, 100, 440, 800);
		frmMelhorCoffeeKiosk.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMelhorCoffeeKiosk.getContentPane().setLayout(null);
		frmMelhorCoffeeKiosk.getContentPane().add(getPanel());
		frmMelhorCoffeeKiosk.getContentPane().add(getTopAds());
		frmMelhorCoffeeKiosk.getContentPane().add(getMiddleAds());
	}
	private JLabel getTopAds() {
		if (topAds == null) {
			topAds = new JLabel("New label");
			topAds.setIcon(new ImageIcon(KioskInputNumber.class.getResource("/com/javalec/img/TopMelXBig.png")));
			topAds.setBounds(0, 0, 440, 30);
		}
		return topAds;
	}
	private JLabel getMiddleAds() {
		if (middleAds == null) {
			middleAds = new JLabel("New label");
			middleAds.setIcon(new ImageIcon(KioskInputNumber.class.getResource("/com/javalec/img/MelXCard.png")));
			middleAds.setBounds(0, 30, 440, 766);
		}
		return middleAds;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(36, 110, 365, 515);
			panel.setLayout(null);
			panel.add(getLblNewLabel());
		}
		return panel;
	}
	
	/*
	
	키오스크 메뉴 다 정하고 주문완료 할 때 회원이면은 핸드폰 번호 입력해서 
	핸드폰 번호로 customer_id값을 불러 와서 쿠폰 적립 할 수 있게끔 하려고 했는데 시간부족으로 하지 못함
	
	
	
	*/
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("키오스크 메뉴 다 정하고 주문완료 할 때 회원이면은 핸드폰 번호 입력해서 핸드폰 번호로 customer_id값을 불러 와서 쿠폰 적립 할 수 있게끔 하려고 했는데 시간부족으로 하지 못함");
			lblNewLabel.setBounds(27, 111, 302, 139);
		}
		return lblNewLabel;
	}
}// End
