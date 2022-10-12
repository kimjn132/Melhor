package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.javalec.util.StaticClass;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminMenuManagement extends JFrame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminMenuManagement window = new AdminMenuManagement();
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
	public AdminMenuManagement() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(247, 243, 243));
		frame.setTitle("메뉴 관리");
		frame.setBounds(100, 100, 600, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnMenuInsert = new JButton("메뉴 등록");
		btnMenuInsert.setFont(new Font("굴림", Font.BOLD, 20));
		// ***************메뉴 등록 버튼 이벤트***************************
		btnMenuInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				AdminMenuList.main(null);
			}
		});
		
		JLabel lblArrow = new JLabel("");
		lblArrow.addMouseListener(new MouseAdapter() {
			// 뒤로 가기 라벨 클릭 이벤트 
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				AdminMainPage.main(null);
			}
		});
		lblArrow.setBounds(5, 2, 35, 35);
		frame.getContentPane().add(lblArrow);
		// arrow
		ImageIcon icon = new ImageIcon(
				AdminMenuList.class.getResource("/com/javalec/image/leftarrow.png")
				);
		Image img = icon.getImage();  //ImageIcon을 Image로 변환.
		Image updateImg = img.getScaledInstance(20, 15, java.awt.Image.SCALE_SMOOTH);
		ImageIcon updateIcon = new ImageIcon(updateImg); 
		lblArrow.setIcon(updateIcon);
		
		JButton btnGoToHome = new JButton("홈화면으로 가기");
		btnGoToHome.setBounds(445, 382, 129, 23);
		frame.getContentPane().add(btnGoToHome);
		
		JLabel lblStore = new JLabel("지점");
		lblStore.setForeground(new Color(60, 143, 96));
		lblStore.setFont(new Font("굴림", Font.PLAIN, 15));
		lblStore.setBounds(340, 10, 50, 23);
		frame.getContentPane().add(lblStore);
		
		JLabel lblNewLabel = new JLabel("Melhor Coffee");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(200, 10, 140, 23);
		frame.getContentPane().add(lblNewLabel);
		btnMenuInsert.setBounds(88, 123, 150, 150);
		frame.getContentPane().add(btnMenuInsert);

		JButton btnMenuManagement = new JButton("메뉴 관리");
		btnMenuManagement.setFont(new Font("굴림", Font.BOLD, 20));
		// *******************************메뉴 관리 이벤트*******************************
		btnMenuManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				AdminRegisterMenuManagement.main(null);
			}
		});
		btnMenuManagement.setBounds(340, 123, 150, 150);
		frame.getContentPane().add(btnMenuManagement);
		
		JLabel lblEm = new JLabel("null님");
		lblEm.setForeground(new Color(60, 143, 96));
		lblEm.setFont(new Font("굴림", Font.BOLD, 15));
		lblEm.setBounds(43, 10, 81, 22);
		frame.getContentPane().add(lblEm);
		lblEm.setText(StaticClass.employee_name + "님");
		
		JLabel lblNewLabel_1_1_5 = new JLabel("");
		lblNewLabel_1_1_5.setOpaque(true);
		lblNewLabel_1_1_5.setForeground(new Color(255, 204, 204));
		lblNewLabel_1_1_5.setBackground(new Color(235, 199, 189));
		lblNewLabel_1_1_5.setBounds(0, 0, 586, 40);
		frame.getContentPane().add(lblNewLabel_1_1_5);
		
		JLabel lblNewLabel_1_2 = new JLabel("");
		lblNewLabel_1_2.setOpaque(true);
		lblNewLabel_1_2.setForeground(new Color(255, 204, 204));
		lblNewLabel_1_2.setBackground(new Color(235, 199, 189));
		lblNewLabel_1_2.setBounds(0, 374, 586, 40);
		frame.getContentPane().add(lblNewLabel_1_2);
	}
}
