package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

import com.javalec.dao.AdminLogInDao;
import com.javalec.dao.AdminMyPageDao;
import com.javalec.dto.AdminMyPageDto;
import com.javalec.util.StaticClass;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminMyPage extends JFrame {

	private JFrame frame;
	private JLabel lblNew3333;
	private JLabel lblNewLabel;
	private JLabel lblStore;
	private JLabel lblNewLabel_1_2;
	private JButton btnNewButton;
	private JTextField tfEmId;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JTextField tfEmName;
	private JTextField tfEmTelno;
	private JTextField tfEmEmail;
	private JButton btnNewButton_1;
	private JLabel lblGoHome;
	private JLabel lblPwCheck;
	private JPasswordField pfPw;
	private JPasswordField pfPwCheck;
	private JLabel lblNewLabel_2_1;
	private JTextField tfAddress;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminMyPage window = new AdminMyPage();
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
	public AdminMyPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			// ????????? ?????? ???
			@Override
			public void windowActivated(WindowEvent e) {
				searchAction();
				address();
			}
		});
		frame.getContentPane().setBackground(new Color(247, 243, 243));
		frame.getContentPane().setForeground(new Color(247, 243, 243));
		frame.setBounds(100, 100, 600, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblGoHome());
		frame.getContentPane().add(getBtnNewButton_1());
		frame.getContentPane().add(getBtnNewButton());
		frame.getContentPane().add(getLblStore());
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getLblNew3333());
		frame.getContentPane().add(getLblNewLabel_1_2());
		frame.getContentPane().add(getTfEmId());
		frame.getContentPane().add(getLblNewLabel_2());
		frame.getContentPane().add(getLblNewLabel_3());
		frame.getContentPane().add(getLblNewLabel_4());
		frame.getContentPane().add(getLblNewLabel_5());
		frame.getContentPane().add(getLblNewLabel_6());
		frame.getContentPane().add(getTfEmName());
		frame.getContentPane().add(getTfEmTelno());
		frame.getContentPane().add(getTfEmEmail());
		frame.getContentPane().add(getLblPwCheck());
		frame.getContentPane().add(getPfPw());
		frame.getContentPane().add(getPfPwCheck());
		frame.getContentPane().add(getLblNewLabel_2_1());
		frame.getContentPane().add(getTfAddress());
	}
	private JLabel getLblNew3333() {
		if (lblNew3333 == null) {
			lblNew3333 = new JLabel("");
			lblNew3333.setOpaque(true);
			lblNew3333.setForeground(new Color(255, 204, 204));
			lblNew3333.setBackground(new Color(235, 199, 189));
			lblNew3333.setBounds(0, 0, 586, 40);
		}
		return lblNew3333;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Melhor Coffee");
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("??????", Font.BOLD | Font.ITALIC, 18));
			lblNewLabel.setBounds(182, 9, 142, 23);
		}
		return lblNewLabel;
	}
	private JLabel getLblStore() {
		if (lblStore == null) {
			lblStore = new JLabel("??????");
			lblStore.setForeground(new Color(60, 143, 96));
			lblStore.setFont(new Font("??????", Font.PLAIN, 15));
			lblStore.setBounds(355, 8, 50, 23);
			lblStore.setText(StaticClass.shop_name);
		}
		return lblStore;
	}
	private JLabel getLblNewLabel_1_2() {
		if (lblNewLabel_1_2 == null) {
			lblNewLabel_1_2 = new JLabel("");
			lblNewLabel_1_2.setOpaque(true);
			lblNewLabel_1_2.setForeground(new Color(255, 204, 204));
			lblNewLabel_1_2.setBackground(new Color(235, 199, 189));
			lblNewLabel_1_2.setBounds(0, 374, 586, 40);
		}
		return lblNewLabel_1_2;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("????????????");
			// ???????????? ?????? ?????? ?????????
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					updateAction();
				}
			});
			btnNewButton.setBounds(483, 383, 91, 23);
		}
		return btnNewButton;
	}
	private JTextField getTfEmId() {
		if (tfEmId == null) {
			tfEmId = new JTextField();
			tfEmId.setEditable(false);
			tfEmId.setForeground(new Color(60, 143, 96));
			tfEmId.setBounds(231, 65, 111, 21);
			tfEmId.setColumns(10);
		}
		return tfEmId;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("??????");
			lblNewLabel_2.setToolTipText("");
			lblNewLabel_2.setBounds(182, 151, 50, 15);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("????????????");
			lblNewLabel_3.setBounds(182, 192, 50, 15);
		}
		return lblNewLabel_3;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("?????????");
			lblNewLabel_4.setBounds(179, 234, 50, 15);
		}
		return lblNewLabel_4;
	}
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("????????????");
			lblNewLabel_5.setBounds(182, 277, 50, 15);
		}
		return lblNewLabel_5;
	}
	private JLabel getLblNewLabel_6() {
		if (lblNewLabel_6 == null) {
			lblNewLabel_6 = new JLabel("???????????? ??????");
			lblNewLabel_6.setBounds(182, 315, 79, 15);
		}
		return lblNewLabel_6;
	}
	private JTextField getTfEmName() {
		if (tfEmName == null) {
			tfEmName = new JTextField();
			tfEmName.addMouseListener(new MouseAdapter() {
				// ?????? ????????? ?????? ?????? ?????????
				@Override
				public void mouseClicked(MouseEvent e) {
					tfEmName.setText("");
				}
			});
			tfEmName.setBounds(272, 146, 96, 21);
			tfEmName.setColumns(10);
		}
		return tfEmName;
	}
	private JTextField getTfEmTelno() {
		if (tfEmTelno == null) {
			tfEmTelno = new JTextField();
			tfEmTelno.addMouseListener(new MouseAdapter() {
				// ???????????? ????????? ?????? ?????? ?????????
				@Override
				public void mouseClicked(MouseEvent e) {
					tfEmTelno.setText("");
				}
			});
			tfEmTelno.setBounds(272, 187, 136, 21);
			tfEmTelno.setColumns(10);
		}
		return tfEmTelno;
	}
	private JTextField getTfEmEmail() {
		if (tfEmEmail == null) {
			tfEmEmail = new JTextField();
			tfEmEmail.addMouseListener(new MouseAdapter() {
				// ????????? ????????? ?????? ?????? ?????????
				@Override
				public void mouseClicked(MouseEvent e) {
					tfEmEmail.setText("");
				}
			});
			tfEmEmail.setBounds(269, 229, 136, 21);
			tfEmEmail.setColumns(10);
		}
		return tfEmEmail;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("????????????");
			// ???????????? ?????? ?????? ?????????
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.setVisible(false);
					staticInit();
				}
			});
			btnNewButton_1.setBounds(483, 10, 91, 23);
		}
		return btnNewButton_1;
	}
	private JLabel getLblGoHome() {
		if (lblGoHome == null) {
			lblGoHome = new JLabel("");
			lblGoHome.addMouseListener(new MouseAdapter() {
				// ????????? ?????? ?????? ?????? ?????????
				@Override
				public void mouseClicked(MouseEvent e) {
					frame.setVisible(false);
					AdminMainPage.main(null);
				}
			});
			lblGoHome.setBounds(10, 2, 35, 35);
			ImageIcon icon = new ImageIcon(
					AdminMyPage.class.getResource("/com/javalec/image/home.png")
					);
			Image img = icon.getImage();  //ImageIcon??? Image??? ??????.
			Image updateImg = img.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
			ImageIcon updateIcon = new ImageIcon(updateImg); 
			
			lblGoHome.setIcon(updateIcon);
		}
		return lblGoHome;
	}
	private JLabel getLblPwCheck() {
		if (lblPwCheck == null) {
			lblPwCheck = new JLabel("??????????????? ???????????????.");
			lblPwCheck.setForeground(new Color(255, 0, 0));
			lblPwCheck.setFont(new Font("??????", Font.PLAIN, 8));
			lblPwCheck.setBounds(272, 333, 118, 13);
		}
		return lblPwCheck;
	}
	private JPasswordField getPfPw() {
		if (pfPw == null) {
			pfPw = new JPasswordField();
			pfPw.setBounds(272, 272, 118, 21);
		}
		return pfPw;
	}
	private JPasswordField getPfPwCheck() {
		if (pfPwCheck == null) {
			pfPwCheck = new JPasswordField();
			// ???????????? ?????? ????????? ?????????*****************
			pfPwCheck.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					pwCheck();
				}
			});
			pfPwCheck.setBounds(272, 310, 118, 21);
		}
		return pfPwCheck;
	}
	
	//==========================================?????????======================================
	
	
	private void searchAction() {

		AdminMyPageDao dao = new AdminMyPageDao(); // ??????
		ArrayList<AdminMyPageDto> dtoList = dao.selectList(); 
		
		tfEmId.setText(Integer.toString(StaticClass.employee_id));
		tfEmName.setText(dtoList.get(0).getEmployeeName());
		tfEmTelno.setText(dtoList.get(0).getEmployeeTelno());
		tfEmEmail.setText(dtoList.get(0).getEmployeeEmail());
		
	}
	private void address() {
		
		AdminMyPageDao dao = new AdminMyPageDao(); // ??????
		ArrayList<AdminMyPageDto> dtoList = dao.address(); 
		
		tfAddress.setText(dtoList.get(0).getEmployeeName());
		
	}
	
	private void pwCheck() {
		if (pfPw.getText().equals(pfPwCheck.getText())){
			lblPwCheck.setText("??????????????? ???????????????.");
			lblPwCheck.setForeground(new Color(29, 190, 33));
		}else {
			lblPwCheck.setText("??????????????? ???????????????.");
			lblPwCheck.setForeground(new Color(255, 0, 0));
		}
	}
	
	// ---------- update ????????? ----------------
	private void updateAction() {

		String name = tfEmName.getText();
		String telno = tfEmTelno.getText();
		String email = tfEmEmail.getText();
		String pw = pfPwCheck.getText();

		AdminMyPageDao dao = new AdminMyPageDao(name, telno, email, pw);

		Boolean ok = dao.updateAction();

		if (ok == true) {

			JOptionPane.showMessageDialog(null, StaticClass.employee_name + "?????? ????????? ?????????????????????.");
		} else {
			JOptionPane.showMessageDialog(null, "????????? ????????????????????????.");

		}
	}
	
	private void staticInit() {
		
		StaticClass.employee_id = 0;
		StaticClass.employee_name = null;
		StaticClass.filename = 0;
		StaticClass.product_id = 0;
		StaticClass.shop_name = null;
		StaticClass.shop_number = 0;
		StaticClass.shop_open_date = null;
		StaticClass.staff_id = 0;
		StaticClass.staff_name = null;
		
	}
	private JLabel getLblNewLabel_2_1() {
		if (lblNewLabel_2_1 == null) {
			lblNewLabel_2_1 = new JLabel("?????? ??????");
			lblNewLabel_2_1.setToolTipText("");
			lblNewLabel_2_1.setBounds(182, 115, 65, 15);
		}
		return lblNewLabel_2_1;
	}
	private JTextField getTfAddress() {
		if (tfAddress == null) {
			tfAddress = new JTextField();
			tfAddress.setColumns(10);
			tfAddress.setBounds(272, 112, 271, 21);
		}
		return tfAddress;
	}
}// END
