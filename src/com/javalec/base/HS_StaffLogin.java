package com.javalec.base;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextField;

import com.javalec.dao.HS_StaffLoginDao;
import com.javalec.dto.HS_StaffLoginDto;
import com.javalec.dto.HS_StaffMypageDto;
import com.javalec.util.DBConnect;
import com.javalec.util.HS_Static_StaffId;
import com.javalec.util.Static_CustomerId;

import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class HS_StaffLogin {

	private JFrame frame;
	private JTextField tfId;
	private JPasswordField tfPassword;
	private JLabel lblId;
	private JLabel lblPw;
	private JButton btnLogin;
	private JButton btnSignup;
	private JComboBox cbShopname;
	private JComboBox comboBox;
	private JLabel lblNewLabel;

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
		addComboShopName();
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
		frame.getContentPane().add(getCbShopname());
		frame.getContentPane().add(getLblNewLabel());
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

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("지점 선택");
			lblNewLabel.setBounds(121, 66, 83, 23);
		}
		return lblNewLabel;
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

	private JComboBox getCbShopname() {
		if (cbShopname == null) {
			cbShopname = new JComboBox();
			cbShopname.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					saveShopNumber();

				}
			});
			cbShopname.setModel(new DefaultComboBoxModel(new String[] { "지점 선택하기" }));
			cbShopname.setBounds(216, 66, 138, 23);

		}

		return cbShopname;

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
			JOptionPane.showMessageDialog(null, "다시 시도해주세요.");

		}

	}

	// 여기부터 콤보박스 소스

	private void addComboShopName() {

		HS_StaffLoginDao dao = new HS_StaffLoginDao();

		ArrayList<HS_StaffLoginDto> dtoList = dao.cbInsertShopname();

		int i = 0;

		while (dtoList.size() > i) {

			cbShopname.addItem(dtoList.get(i).getShop_name());

			i++;
		}
	}// addComboShopName End

	// shopnumber를 static에 저장하는 메소드

	private void saveShopNumber() {

		HS_StaffLoginDao dao = new HS_StaffLoginDao(cbShopname.getSelectedItem().toString());

		dao.gotshopNumber();
		
	}

}// end
