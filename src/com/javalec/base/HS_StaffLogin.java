package com.javalec.base;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextField;

import com.javalec.dao.HS_StaffLoginDao;
import com.javalec.dto.HS_StaffMypageDto;
import com.javalec.util.DBConnect;
import com.javalec.util.HS_Static_StaffId;

import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HS_StaffLogin {

	private JFrame frame;
	private JTextField tfId;
	private JPasswordField tfPassword;
	private JLabel lblId;
	private JLabel lblPw;
	private JButton btnLogin;
	private JButton btnSignup;
	private JButton btnFindidandpw;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HS_StaffLogin window = new HS_StaffLogin();
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
	public HS_StaffLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(227, 147, 132));
		frame.setTitle("로그인 페이지");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getTfId());
		frame.getContentPane().add(getTfPassword());
		frame.getContentPane().add(getLblId());
		frame.getContentPane().add(getLblPw());
		frame.getContentPane().add(getBtnLogin());
		frame.getContentPane().add(getBtnSignup());
		frame.getContentPane().add(getBtnFindidandpw());
	}

	private JTextField getTfId() {
		if (tfId == null) {
			tfId = new JTextField();
			tfId.setColumns(10);
			tfId.setBounds(216, 142, 96, 21);
		}
		return tfId;
	}

	private JPasswordField getTfPassword() {
		if (tfPassword == null) {
			tfPassword = new JPasswordField();
			tfPassword.setBounds(216, 186, 96, 21);
		}
		return tfPassword;
	}

	private JLabel getLblId() {
		if (lblId == null) {
			lblId = new JLabel("ID");
			lblId.setBounds(128, 145, 50, 15);
		}
		return lblId;
	}

	private JLabel getLblPw() {
		if (lblPw == null) {
			lblPw = new JLabel("PW");
			lblPw.setBounds(128, 186, 50, 15);
		}
		return lblPw;
	}

	private JButton getBtnLogin() {
		if (btnLogin == null) {
			btnLogin = new JButton("Login");
			btnLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					staffLoginCheck();
					

				}
			});
			btnLogin.setBounds(324, 185, 91, 23);
		}
		return btnLogin;
	}

	private JButton getBtnSignup() {
		if (btnSignup == null) {
			btnSignup = new JButton("회원가입");
			btnSignup.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
					HS_StaffSignup.main(null);
					frame.setVisible(false);
					
				}
			});
			btnSignup.setBounds(138, 217, 91, 23);
		}
		return btnSignup;
	}

	private JButton getBtnFindidandpw() {
		if (btnFindidandpw == null) {
			btnFindidandpw = new JButton("아이디,비번찾기");
			btnFindidandpw.setBounds(242, 217, 173, 23);
		}
		return btnFindidandpw;
	}

	// -------------------------------------------function--------------------------

	private void staffLoginCheck() {// 로그인 하는 메소드. Id,Pw 입력시 DB에 일치하는 값이 있으면 로그인 후 스태프 메뉴 불러옴

		String staffId = tfId.getText().trim();
		String staffPw = tfPassword.getText().trim();

		HS_StaffLoginDao hs_staffLoginDao = new HS_StaffLoginDao(staffId, staffPw);

		int loginCheck = hs_staffLoginDao.staffLoginCheck();

		if (loginCheck == 1) {
			JOptionPane.showMessageDialog(null, "로그인되었습니다.");

			HS_Static_StaffId.setStaff_Id(Integer.parseInt(staffId));

			// HS_Static_StaffId에 staffId를 저장해 주는 것
			// 이게 sql 상에서는 employeeId 입니다

			

		
			
			
			frame.setVisible(false);// 로그인 창 종료
			HS_StaffMenu.main(null);// 다음 창 열기

		} else {
			JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 확인하세요.");
			System.out.println(loginCheck);

		}

	}
	
	
}// end
