package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.javalec.dao.AdminLogInDao;
import com.javalec.util.StaticClass;

import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminLogIn extends JFrame {

	private JFrame frame;
	private JTextField tfIdInput;
	private JPasswordField pfPwInput;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JButton btnNewButton;
	private JLabel lblNewLabel_1_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogIn window = new AdminLogIn();
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
	public AdminLogIn() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("로그인 페이지");
		frame.getContentPane().setBackground(new Color(247, 243, 243));
		frame.setBounds(100, 100, 600, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
				JLabel lblNewLabel = new JLabel("Melhor Coffee");
				lblNewLabel.setBackground(new Color(247, 243, 243));
				lblNewLabel.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 21));
				lblNewLabel.setForeground(new Color(247, 243, 243));
				lblNewLabel.setBounds(143, 10, 160, 50);
				frame.getContentPane().add(lblNewLabel);
		
				lblNewLabel_3 = new JLabel("Admin Log In");
				lblNewLabel_3.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 21));
				lblNewLabel_3.setForeground(new Color(60, 143, 96));
				lblNewLabel_3.setBounds(302, 10, 168, 50);
				frame.getContentPane().add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel("계정이 없다면...");
		lblNewLabel_4.setForeground(new Color(0, 0, 255));
		lblNewLabel_4.setBackground(new Color(0, 0, 255));
		lblNewLabel_4.setBounds(309, 290, 94, 15);
		frame.getContentPane().add(lblNewLabel_4);

		JLabel lblNewLabel_1 = new JLabel("아이디");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(101, 172, 50, 30);
		frame.getContentPane().add(lblNewLabel_1);

		tfIdInput = new JTextField();
		tfIdInput.setFont(new Font("굴림", Font.PLAIN, 13));
		tfIdInput.setBounds(193, 170, 195, 25);
		frame.getContentPane().add(tfIdInput);
		tfIdInput.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("비밀번호");
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setBounds(101, 210, 65, 30);
		frame.getContentPane().add(lblNewLabel_2);

		pfPwInput = new JPasswordField();
		pfPwInput.setFont(new Font("굴림", Font.PLAIN, 13));
		pfPwInput.setBounds(193, 210, 195, 25);
		frame.getContentPane().add(pfPwInput);

		JButton btnLogIn = new JButton("LOG\r\nIN\r\n");
		btnLogIn.setFont(new Font("굴림", Font.BOLD, 13));
		btnLogIn.addActionListener(new ActionListener() {
			// ********************************로그인 버튼 이벤트***************
			public void actionPerformed(ActionEvent e) {
				logInCheck();
			}
		});
		btnLogIn.setBounds(411, 170, 77, 65);
		frame.getContentPane().add(btnLogIn);

		btnNewButton = new JButton("회원 가입");
		btnNewButton.setBounds(401, 284, 87, 23);
		frame.getContentPane().add(btnNewButton);
		
		lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setOpaque(true);
		lblNewLabel_1_1.setForeground(new Color(255, 204, 204));
		lblNewLabel_1_1.setBackground(new Color(235, 199, 189));
		lblNewLabel_1_1.setBounds(0, 0, 586, 60);
		frame.getContentPane().add(lblNewLabel_1_1);
	}

	// =========================================메소드====================================
	
	// 로그인 시 체크하는 메소드
	public void logInCheck() {
		int employee_id = Integer.parseInt(tfIdInput.getText().trim());
		String employee_pw = pfPwInput.getText().trim();

		AdminLogInDao adminLogInDao = new AdminLogInDao(employee_id, employee_pw);

		int loginCheck = adminLogInDao.loginCheck();

		if (loginCheck == 1) {
			JOptionPane.showMessageDialog(null, "로그인되었습니다.");

			//static에 넣어주기!!
			StaticClass.employee_id = employee_id;
			StaticClass.employee_name = adminLogInDao.emName();
			StaticClass.shop_name = adminLogInDao.shopName();
			StaticClass.shop_number = Integer.parseInt(adminLogInDao.shopNum());
			StaticClass.shop_open_date = adminLogInDao.shopOpenDate();			
			frame.setVisible(false);
			AdminMainPage.main(null);

		} else {
			JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 확인하세요.");
		}
	}
}// END
