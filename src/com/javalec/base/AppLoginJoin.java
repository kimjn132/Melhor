package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppLoginJoin {

	private JFrame frmMelhorCoffee;
	private JButton btnJoin;
	private JTextPane txtpnMelhorCoffee;
	private JTextPane txtpnMelhorCoffee_1;
	private JTextArea textArea;
	private JLabel lblImage;
	private JButton btnJoin_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppLoginJoin window = new AppLoginJoin();
					window.frmMelhorCoffee.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppLoginJoin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMelhorCoffee = new JFrame();
		frmMelhorCoffee.setFont(new Font("Copperplate", Font.PLAIN, 12));
		frmMelhorCoffee.setForeground(new Color(235, 199, 189));
		frmMelhorCoffee.setTitle("Melhor Coffee");
		frmMelhorCoffee.getContentPane().setBackground(new Color(235, 199, 189));
		frmMelhorCoffee.setBackground(new Color(235, 199, 189));
		frmMelhorCoffee.setBounds(100, 100, 273, 469);
		frmMelhorCoffee.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMelhorCoffee.getContentPane().setLayout(null);
		frmMelhorCoffee.getContentPane().add(getBtnJoin());
		frmMelhorCoffee.getContentPane().add(getTxtpnMelhorCoffee());
		frmMelhorCoffee.getContentPane().add(getTxtpnMelhorCoffee_1());
		frmMelhorCoffee.getContentPane().add(getTextArea());
		frmMelhorCoffee.getContentPane().add(getLblImage());
		frmMelhorCoffee.getContentPane().add(getBtnJoin_1());
	}
	private JButton getBtnJoin() {
		if (btnJoin == null) {
			btnJoin = new JButton("로그인");
			btnJoin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// 로그인 페이지로 이동 
					AppLogin.main(null);
					frmMelhorCoffee.setVisible(false);
					
					
				}
			});
			btnJoin.setForeground(new Color(0, 0, 0));	//font
			btnJoin.setBackground(new Color(235, 199, 189));
			btnJoin.setBounds(26, 383, 103, 29);
		}
		return btnJoin;
	}
	
	private JTextPane getTxtpnMelhorCoffee() {
		if (txtpnMelhorCoffee == null) {
			txtpnMelhorCoffee = new JTextPane();
			txtpnMelhorCoffee.setBackground(new Color(235, 199, 189));
			txtpnMelhorCoffee.setFont(new Font("Copperplate", Font.BOLD, 15));
			txtpnMelhorCoffee.setText("Melhor Coffee");
			txtpnMelhorCoffee.setBounds(26, 18, 123, 16);
		}
		return txtpnMelhorCoffee;
	}
	private JTextPane getTxtpnMelhorCoffee_1() {
		if (txtpnMelhorCoffee_1 == null) {
			txtpnMelhorCoffee_1 = new JTextPane();
			txtpnMelhorCoffee_1.setBackground(new Color(235, 199, 189));
			txtpnMelhorCoffee_1.setFont(new Font("Courier New", Font.PLAIN, 9));
			txtpnMelhorCoffee_1.setText("커피가 필요한 지금,\n때와 장소에 상관 없이 \n필요할 때 바로주문 하세요.");
			txtpnMelhorCoffee_1.setBounds(34, 88, 123, 43);
		}
		return txtpnMelhorCoffee_1;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setBackground(new Color(235, 199, 189));
			textArea.setText("어플에서 기다리지 말고 \n바로 주문하세요.");
			textArea.setBounds(24, 42, 140, 43);
		}
		return textArea;
	}
	private JLabel getLblImage() {
		if (lblImage == null) {
			lblImage = new JLabel("");
			lblImage.setIcon(new ImageIcon("/Users/annakim/Downloads/np_Cup of coffee and pound cake_0LO6rb_free.jpg"));
			lblImage.setBounds(18, 143, 232, 156);
		}
		return lblImage;
	}
	private JButton getBtnJoin_1() {
		if (btnJoin_1 == null) {
			btnJoin_1 = new JButton("회원가입");
			btnJoin_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// 회원가입 페이지로 이동 
					AppJoin.main(null);
					frmMelhorCoffee.setVisible(false);
				}
			});
			btnJoin_1.setForeground(Color.BLACK);
			btnJoin_1.setBackground(new Color(235, 199, 189));
			btnJoin_1.setBounds(141, 383, 103, 29);
		}
		return btnJoin_1;
	}
	
	
	
	//function
	
	
}
