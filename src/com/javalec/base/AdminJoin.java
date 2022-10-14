package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.JTextField;

import com.javalec.dao.AdminJoinDao;
import com.javalec.dao.AdminMyPageDao;
import com.javalec.util.StaticClass;

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminJoin extends JFrame {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JLabel lblNew3333;
	private JLabel lblNewLabel_5;
	private JPasswordField pfPw;
	private JLabel lblNewLabel_6;
	private JPasswordField pfPwCheck;
	private JLabel lblPwCheck;
	private JLabel lblNewLabel_1_2;
	private JButton btnJoin;
	private JLabel lblNewLabel_2_1;
	private JTextField tfEmId;
	private JLabel lblArrow;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminJoin window = new AdminJoin();
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
	public AdminJoin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("회원 가입");
		frame.getContentPane().setBackground(new Color(247, 243, 243));
		frame.setBounds(100, 100, 600, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblArrow());
		frame.getContentPane().add(getBtnJoin());
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getLblNew3333());
		frame.getContentPane().add(getLblNewLabel_5());
		frame.getContentPane().add(getPfPw());
		frame.getContentPane().add(getLblNewLabel_6());
		frame.getContentPane().add(getPfPwCheck());
		frame.getContentPane().add(getLblPwCheck());
		frame.getContentPane().add(getLblNewLabel_1_2());
		frame.getContentPane().add(getLblNewLabel_2_1());
		frame.getContentPane().add(getTfEmId());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Melhor Coffee");
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 18));
			lblNewLabel.setBounds(222, 9, 142, 23);
		}
		return lblNewLabel;
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
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("비밀번호");
			lblNewLabel_5.setBounds(190, 206, 50, 15);
		}
		return lblNewLabel_5;
	}
	private JPasswordField getPfPw() {
		if (pfPw == null) {
			pfPw = new JPasswordField();
			pfPw.setBounds(282, 203, 118, 21);
		}
		return pfPw;
	}
	private JLabel getLblNewLabel_6() {
		if (lblNewLabel_6 == null) {
			lblNewLabel_6 = new JLabel("비밀번호 확인");
			lblNewLabel_6.setBounds(190, 262, 79, 15);
		}
		return lblNewLabel_6;
	}
	private JPasswordField getPfPwCheck() {
		if (pfPwCheck == null) {
			pfPwCheck = new JPasswordField();
			pfPwCheck.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					pwCheck();
				}
			});
			pfPwCheck.setBounds(282, 259, 118, 21);
		}
		return pfPwCheck;
	}
	private JLabel getLblPwCheck() {
		if (lblPwCheck == null) {
			lblPwCheck = new JLabel("비밀번호를 확인하세요.");
			lblPwCheck.setForeground(Color.RED);
			lblPwCheck.setFont(new Font("굴림", Font.PLAIN, 8));
			lblPwCheck.setBounds(282, 281, 118, 13);
		}
		return lblPwCheck;
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
	private JButton getBtnJoin() {
		if (btnJoin == null) {
			btnJoin = new JButton("가입하기");
			btnJoin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					updateAction();
				}
			});
			btnJoin.setBounds(483, 383, 91, 23);
		}
		return btnJoin;
	}
	private JLabel getLblNewLabel_2_1() {
		if (lblNewLabel_2_1 == null) {
			lblNewLabel_2_1 = new JLabel("사원 번호");
			lblNewLabel_2_1.setToolTipText("");
			lblNewLabel_2_1.setBounds(190, 149, 62, 15);
		}
		return lblNewLabel_2_1;
	}
	private JTextField getTfEmId() {
		if (tfEmId == null) {
			tfEmId = new JTextField();
			tfEmId.setColumns(10);
			tfEmId.setBounds(282, 146, 96, 21);
		}
		return tfEmId;
	}
	private JLabel getLblArrow() {
		if (lblArrow == null) {
			lblArrow = new JLabel("");
			lblArrow.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					frame.setVisible(false);
					AdminLogIn.main(null);
				}
			});
			lblArrow.setBounds(10, 2, 35, 35);
			ImageIcon icon = new ImageIcon(AdminRevenueDetail.class.getResource("/com/javalec/image/leftarrow.png"));
			Image img = icon.getImage(); // ImageIcon을 Image로 변환.
			Image updateImg = img.getScaledInstance(25, 15, java.awt.Image.SCALE_SMOOTH);
			ImageIcon updateIcon = new ImageIcon(updateImg);

			lblArrow.setIcon(updateIcon);
		}
		return lblArrow;
	}
	
	//=======================메소드==================================
	private void pwCheck() {
		if (pfPw.getText().equals(pfPwCheck.getText())){
			lblPwCheck.setText("비밀번호가 일치합니다.");
			lblPwCheck.setForeground(new Color(29, 190, 33));
		}else {
			lblPwCheck.setText("비밀번호를 확인하세요.");
			lblPwCheck.setForeground(new Color(255, 0, 0));
		}
	}
	
	private void updateAction() {

		String id = tfEmId.getText();
		String pw = pfPwCheck.getText();

		AdminJoinDao dao = new AdminJoinDao(id, pw);

		Boolean ok = dao.updateAction();

		if (ok == true) {

			JOptionPane.showMessageDialog(null, "가입이 완료되었습니다.");
			frame.setVisible(false);
			AdminLogIn.main(null);
			
		} else {
			JOptionPane.showMessageDialog(null, "작업중 문제발생했습니다.");

		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}//END
