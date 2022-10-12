package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.javalec.dao.AppLoginDao;
import com.javalec.util.Static_CustomerId;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppLogin extends JFrame {

	private JFrame frmMelhor;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField tfId;
	private JTextField tfPw;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppLogin window = new AppLogin();
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
	public AppLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMelhor = new JFrame();
		frmMelhor.setTitle("Melhor-로그인");
		frmMelhor.setBounds(100, 100, 273, 469);
		frmMelhor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMelhor.getContentPane().setLayout(null);
		frmMelhor.getContentPane().add(getLblNewLabel());
		frmMelhor.getContentPane().add(getLblNewLabel_1());
		frmMelhor.getContentPane().add(getTfId());
		frmMelhor.getContentPane().add(getTfPw());
		frmMelhor.getContentPane().add(getBtnNewButton());
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("아이디: ");
			lblNewLabel.setBounds(38, 102, 61, 16);
		}
		return lblNewLabel;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("패스워드: ");
			lblNewLabel_1.setBounds(38, 158, 61, 16);
		}
		return lblNewLabel_1;
	}

	private JTextField getTfId() {
		if (tfId == null) {
			tfId = new JTextField();
			tfId.setBounds(111, 97, 130, 26);
			tfId.setColumns(10);
		}
		return tfId;
	}

	private JTextField getTfPw() {
		if (tfPw == null) {
			tfPw = new JTextField();
			tfPw.setBounds(111, 153, 130, 26);
			tfPw.setColumns(10);
		}
		return tfPw;
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("로그인할게요");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// 버튼 클릭하면 아이디 비밀번호 체크 후 둘다 맞으면 AppHome 으로 넘어가기 
					loginCheck();
				}
			});
			btnNewButton.setBounds(76, 249, 117, 29);
		}
		return btnNewButton;
	}

	// --------------------------function--------------------------

	public void loginCheck() {
		String custId = tfId.getText().trim();
		String custPw = tfPw.getText().trim();

		AppLoginDao appLoginDao = new AppLoginDao(custId, custPw);

		int loginCheck = appLoginDao.loginCheck();

		if (loginCheck == 1) {
			JOptionPane.showMessageDialog(null, "로그인되었습니다.");

			Static_CustomerId.setCustomer_id(custId);
			Static_CustomerId.customer_nickname = appLoginDao.bringNickname();
			

			frmMelhor.setVisible(false);
			AppHome.main(null);

		} else {
			JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 확인하세요.");
			
		}

	}


}
