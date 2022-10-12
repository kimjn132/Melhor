package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

public class AdminStaffMenu extends JFrame {

	private JFrame frame;
	private JLabel lblArrow;
	private JLabel lblGoHome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminStaffMenu window = new AdminStaffMenu();
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
	public AdminStaffMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(247, 243, 243));
		frame.getContentPane().setForeground(new Color(247, 243, 243));
		frame.setTitle("스태프 관리 메뉴");
		frame.setBounds(100, 100, 600, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblArrow());
		frame.getContentPane().add(getLblGoHome());
		
		JLabel lblArrow = new JLabel("");
		lblArrow.setBounds(10, 3, 35, 35);
		frame.getContentPane().add(lblArrow);
		
		JLabel lblStore = new JLabel("지점");
		lblStore.setForeground(new Color(60, 143, 96));
		lblStore.setFont(new Font("굴림", Font.PLAIN, 15));
		lblStore.setBounds(355, 8, 50, 23);
		frame.getContentPane().add(lblStore);
		
		JLabel lblNewLabel_3 = new JLabel("Melhor Coffee");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_3.setBounds(182, 9, 142, 23);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblGoHome = new JLabel("");
		lblGoHome.setBounds(10, 2, 35, 35);
		frame.getContentPane().add(lblGoHome);
		
		JButton btnNewButton = new JButton("staff 등록");
		btnNewButton.addActionListener(new ActionListener() {
			// 등록 버튼 클릭 이벤트
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				AdminStaffInsert.main(null);
			}
		});
		btnNewButton.setBounds(113, 97, 123, 81);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("출퇴근 내역");
		btnNewButton_1.setBounds(336, 227, 123, 81);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("월급 내역");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1.setBounds(113, 227, 123, 81);
		frame.getContentPane().add(btnNewButton_1_1);
		
		JButton btnStaff = new JButton("staff 정보 관리");
		//-------------------------스태프 해제 버튼---------------------------------
		btnStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				AdminRegisterStaffManagement.main(null);
			}
		});
		btnStaff.setBounds(336, 97, 123, 81);
		frame.getContentPane().add(btnStaff);
		
		JLabel lblNew3333 = new JLabel("");
		lblNew3333.setOpaque(true);
		lblNew3333.setForeground(new Color(255, 204, 204));
		lblNew3333.setBackground(new Color(235, 199, 189));
		lblNew3333.setBounds(0, 0, 586, 40);
		frame.getContentPane().add(lblNew3333);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("");
		lblNewLabel_1_2_2.setOpaque(true);
		lblNewLabel_1_2_2.setForeground(new Color(255, 204, 204));
		lblNewLabel_1_2_2.setBackground(new Color(235, 199, 189));
		lblNewLabel_1_2_2.setBounds(0, 374, 586, 40);
		frame.getContentPane().add(lblNewLabel_1_2_2);
	}
	private JLabel getLblArrow() {
		if (lblArrow == null) {
			lblArrow = new JLabel("");
			lblArrow.addMouseListener(new MouseAdapter() {
				@Override
				// 뒤로 가기 라벨 클릭 이벤트
				public void mouseClicked(MouseEvent e) {
					AdminMainPage.main(null);
					frame.setVisible(false);
				}
			});
			lblArrow.setBounds(10, 3, 35, 35);
			ImageIcon icon = new ImageIcon(
					AdminMenuDetail.class.getResource("/com/javalec/image/leftarrow.png")
					);
			Image img = icon.getImage();  //ImageIcon을 Image로 변환.
			Image updateImg = img.getScaledInstance(20, 15, java.awt.Image.SCALE_SMOOTH);
			ImageIcon updateIcon = new ImageIcon(updateImg); 
			
			lblArrow.setIcon(updateIcon);
		}
		return lblArrow;
	}
	
	private JLabel getLblGoHome() {
		if (lblGoHome == null) {
			lblGoHome = new JLabel("");
			lblGoHome.addMouseListener(new MouseAdapter() {
				// 홈으로 가기 클릭
				@Override
				public void mouseClicked(MouseEvent e) {
					frame.setVisible(false);
					AdminMainPage.main(null);
				}
			});
			lblGoHome.setBounds(545, 2, 35, 35);
			ImageIcon icon = new ImageIcon(AdminStaffDetail.class.getResource("/com/javalec/image/home.png"));
			Image img = icon.getImage(); // ImageIcon을 Image로 변환.
			Image updateImg = img.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
			ImageIcon updateIcon = new ImageIcon(updateImg);

			lblGoHome.setIcon(updateIcon);
		}
		return lblGoHome;
	}

}
