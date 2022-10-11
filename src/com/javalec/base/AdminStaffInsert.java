package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextField;

import com.javalec.dao.AdminStaffInsertDao;
import com.javalec.util.StaticClass;

import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminStaffInsert extends JFrame {

	private JFrame frame;
	private JLabel lblArrow;
	private JLabel lblNewLabel_3;
	private JLabel lblNew3333;
	private JLabel lblStore;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_1_2_2;
	private JLabel lblNewLabel_4;
	private JTextField tfStaffEmail;
	private JTextField tfStaffTelno;
	private JLabel lblNewLabel_3_1;
	private JTextField tfStaffName;
	private JLabel lblNewLabel_1_3;
	private JLabel lblEm;
	private JTextField textField;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminStaffInsert window = new AdminStaffInsert();
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
	public AdminStaffInsert() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(247, 243, 243));
		frame.setTitle("스태프 등록");
		frame.setBounds(100, 100, 600, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblEm());
		frame.getContentPane().add(getLblArrow());
		frame.getContentPane().add(getLblStore());
		
		JButton btnStaffInsert = new JButton("등록");
		btnStaffInsert.addActionListener(new ActionListener() {
			// 등록 버튼 이벤트***************************************
			public void actionPerformed(ActionEvent e) {
				insertAction();
			}
		});
		btnStaffInsert.setBounds(483, 382, 91, 23);
		frame.getContentPane().add(btnStaffInsert);
		
		JLabel lblNewLabel_1 = new JLabel("이름");
		lblNewLabel_1.setBounds(301, 137, 50, 15);
		frame.getContentPane().add(lblNewLabel_1);
		frame.getContentPane().add(getLblNewLabel_3());
		frame.getContentPane().add(getLblNew3333());
		frame.getContentPane().add(getBtnNewButton_1());
		frame.getContentPane().add(getLblNewLabel_1_2_2());
		frame.getContentPane().add(getLblNewLabel_4());
		frame.getContentPane().add(getTfStaffEmail());
		frame.getContentPane().add(getTfStaffTelno());
		frame.getContentPane().add(getLblNewLabel_3_1());
		frame.getContentPane().add(getTfStaffName());
		frame.getContentPane().add(getLblNewLabel_1_3());
		frame.getContentPane().add(getTextField());
		frame.getContentPane().add(getBtnNewButton());
	}
	private JLabel getLblArrow() {
		if (lblArrow == null) {
			lblArrow = new JLabel("");
			lblArrow.addMouseListener(new MouseAdapter() {
				//뒤로 가기 
				@Override
				public void mouseClicked(MouseEvent e) {
					frame.setVisible(false);
					AdminStaffMenu.main(null);
				}
			});
			
			lblArrow.setBounds(10, 2, 35, 35);
			ImageIcon icon = new ImageIcon(AdminStaffInsert.class.getResource("/com/javalec/image/leftarrow.png"));
			Image img = icon.getImage(); // ImageIcon을 Image로 변환.
			Image updateImg = img.getScaledInstance(20, 15, java.awt.Image.SCALE_SMOOTH);
			ImageIcon updateIcon = new ImageIcon(updateImg);
			lblArrow.setIcon(updateIcon);
		}
		return lblArrow;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("Melhor Coffee");
			lblNewLabel_3.setForeground(Color.WHITE);
			lblNewLabel_3.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 18));
			lblNewLabel_3.setBounds(182, 10, 142, 23);
		}
		return lblNewLabel_3;
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
	private JLabel getLblStore() {
		if (lblStore == null) {
			lblStore = new JLabel("지점");
			lblStore.setForeground(new Color(60, 143, 96));
			lblStore.setFont(new Font("굴림", Font.PLAIN, 15));
			lblStore.setBounds(355, 10, 50, 23);
		}
		return lblStore;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("로그아웃");
			btnNewButton_1.setBounds(483, 10, 91, 23);
		}
		return btnNewButton_1;
	}
	private JLabel getLblNewLabel_1_2_2() {
		if (lblNewLabel_1_2_2 == null) {
			lblNewLabel_1_2_2 = new JLabel("");
			lblNewLabel_1_2_2.setOpaque(true);
			lblNewLabel_1_2_2.setForeground(new Color(255, 204, 204));
			lblNewLabel_1_2_2.setBackground(new Color(235, 199, 189));
			lblNewLabel_1_2_2.setBounds(0, 374, 586, 40);
		}
		return lblNewLabel_1_2_2;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("이메일");
			lblNewLabel_4.setBounds(301, 246, 50, 15);
		}
		return lblNewLabel_4;
	}
	private JTextField getTfStaffEmail() {
		if (tfStaffEmail == null) {
			tfStaffEmail = new JTextField();
			tfStaffEmail.setColumns(10);
			tfStaffEmail.setBounds(391, 241, 136, 21);
		}
		return tfStaffEmail;
	}
	private JTextField getTfStaffTelno() {
		if (tfStaffTelno == null) {
			tfStaffTelno = new JTextField();
			tfStaffTelno.setColumns(10);
			tfStaffTelno.setBounds(391, 188, 136, 21);
		}
		return tfStaffTelno;
	}
	private JLabel getLblNewLabel_3_1() {
		if (lblNewLabel_3_1 == null) {
			lblNewLabel_3_1 = new JLabel("전화번호");
			lblNewLabel_3_1.setBounds(301, 191, 50, 15);
		}
		return lblNewLabel_3_1;
	}
	private JTextField getTfStaffName() {
		if (tfStaffName == null) {
			tfStaffName = new JTextField();
			tfStaffName.setColumns(10);
			tfStaffName.setBounds(391, 134, 96, 21);
		}
		return tfStaffName;
	}
	private JLabel getLblNewLabel_1_3() {
		if (lblNewLabel_1_3 == null) {
			lblNewLabel_1_3 = new JLabel("image");
			lblNewLabel_1_3.setBounds(53, 103, 100, 100);
		}
		return lblNewLabel_1_3;
	}
	private JLabel getLblEm() {
		if (lblEm == null) {
			lblEm = new JLabel("null님");
			lblEm.setForeground(new Color(60, 143, 96));
			lblEm.setFont(new Font("굴림", Font.BOLD, 15));
			lblEm.setBounds(53, 10, 81, 22);
			lblEm.setText(StaticClass.employee_name);
		}
		return lblEm;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setEditable(false);
			textField.setColumns(10);
			textField.setBounds(53, 229, 114, 21);
		}
		return textField;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("파일 경로");
			btnNewButton.setBounds(180, 228, 90, 23);
		}
		return btnNewButton;
	}
	
	// =====================================메소드======================================
	
	// ---------------insertAction-------------------
	private void insertAction() {

		String name = tfStaffName.getText();
		String telno = tfStaffTelno.getText();
		String email = tfStaffEmail.getText();

		AdminStaffInsertDao dao = new AdminStaffInsertDao(name, telno, email);

		int insert = dao.insertAction();
		
		if (insert == 1) {
			JOptionPane.showMessageDialog(null, tfStaffName.getText() + "님의 정보가 입력되었습니다.");
			JOptionPane.showMessageDialog(null, tfStaffName.getText() + "님의 사원 번호는 " +dao.staffId()+ "입니다.");
			frame.setVisible(false);
			AdminRegisterStaffManagement.main(null);
			
		} else {
			JOptionPane.showMessageDialog(null, "오류입니다.");
		}
	}
}//END
