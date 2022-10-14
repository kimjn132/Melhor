package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

import com.javalec.util.StaticClass;

import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;

public class AdminMainPage extends JFrame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminMainPage window = new AdminMainPage();
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
	public AdminMainPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBackground(SystemColor.control);
		frame.setTitle("홈화면");
		frame.setBounds(100, 100, 600, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(247, 243, 243));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnMyPage = new JButton("My Page");
		// *****************************마이 페이지 버튼 이벤트 ***********************************8
		btnMyPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//페이지 넘기기
				frame.setVisible(false);
				AdminMyPage.main(null);
			}
		});
		
		JButton btnLogOut = new JButton("로그아웃");
		btnLogOut.setBackground(new Color(235, 199, 189));
		//********************************로그아웃 버튼****************************
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				logOut();
				AdminLogIn.main(null);
			}
		});
		ImageIcon icon = new ImageIcon(
				AdminMainPage.class.getResource("/com/javalec/image/leftarrow.png")
				);
		Image img = icon.getImage();  //ImageIcon을 Image로 변환.
		Image updateImg = img.getScaledInstance(20, 15, java.awt.Image.SCALE_SMOOTH);
		ImageIcon updateIcon = new ImageIcon(updateImg);
		
		JLabel lblStore = new JLabel("지점");
		lblStore.setFont(new Font("굴림", Font.PLAIN, 13));
		lblStore.setForeground(new Color(60, 143, 96));
		lblStore.setBounds(340, 10, 80, 22);
		lblStore.setText(StaticClass.shop_name);
		
		panel.add(lblStore);
		btnLogOut.setBounds(483, 382, 91, 23);
		panel.add(btnLogOut);
		btnMyPage.setBounds(483, 8, 91, 23);
		panel.add(btnMyPage);
		
		JLabel lblNewLabel = new JLabel("Melhor Coffee");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(200, 10, 140, 23);
		panel.add(lblNewLabel);
		//********************************* 지점 넣어 주기*****************************
		
		
		JLabel lblEm = new JLabel("OO님");
		lblEm.setFont(new Font("굴림", Font.PLAIN, 13));
		lblEm.setForeground(new Color(60, 143, 96));
		lblEm.setBounds(10, 10, 135, 22);
		panel.add(lblEm);
		// ********************************** 이름 넣어주기 *************************
		lblEm.setText(StaticClass.employee_name + "님, 환영합니다!");
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setOpaque(true);
		lblNewLabel_1_1.setForeground(new Color(255, 204, 204));
		lblNewLabel_1_1.setBackground(new Color(235, 199, 189));
		lblNewLabel_1_1.setBounds(0, 0, 586, 40);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("");
		lblNewLabel_1_2.setOpaque(true);
		lblNewLabel_1_2.setForeground(new Color(255, 204, 204));
		lblNewLabel_1_2.setBackground(new Color(235, 199, 189));
		lblNewLabel_1_2.setBounds(0, 374, 586, 40);
		panel.add(lblNewLabel_1_2);
		
		JButton btnProduct = new JButton("제품 관리");
		btnProduct.setFont(new Font("굴림", Font.PLAIN, 15));
		// ************************************8 메뉴 버튼 이벤트*****************************
		btnProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				AdminMenuManagement.main(null);
			}
		});
		btnProduct.setBounds(74, 149, 100, 100);
		panel.add(btnProduct);
		
		JButton btnRevenue = new JButton("매출 현황");
		btnRevenue.setFont(new Font("굴림", Font.PLAIN, 15));
		btnRevenue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				AdminRevenue.main(null);
			}
		});
		btnRevenue.setBounds(404, 149, 100, 100);
		panel.add(btnRevenue);
		
		JButton btnStaffManagement = new JButton("staff 관리");
		btnStaffManagement.setFont(new Font("굴림", Font.PLAIN, 15));
		//************************** 스태프 관리 버튼 이벤트 ************************8
		btnStaffManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				AdminStaffMenu.main(null);
			}
		});
		btnStaffManagement.setBounds(240, 149, 100, 100);
		panel.add(btnStaffManagement);
	}
	
	public void logOut() {
		JOptionPane.showMessageDialog(null, "로그아웃되었습니다.");
		StaticClass.employee_id = 0;
		StaticClass.employee_name = null;
		StaticClass.product_id = 0;
		StaticClass.shop_name = null;
		StaticClass.shop_number = 0;
		StaticClass.shop_open_date = null;
		StaticClass.staff_id = 0;
		StaticClass.staff_name = null;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}// END
