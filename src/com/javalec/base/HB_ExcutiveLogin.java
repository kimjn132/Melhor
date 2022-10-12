package com.javalec.base;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.javalec.dao.HB_ExcutiveLoginDao;

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

//-------------------------------------
class ImagePanel extends JPanel {
	private Image img;
	
	public ImagePanel(Image img) {
		this.img = img;
		setSize(new Dimension(img.getWidth(null), img.getHeight(null)));
		setPreferredSize(new Dimension(img.getWidth(null), img.getHeight(null)));
		setLayout(null);
		setSize(532,367);
		
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);
	}
}
//-------------------------------------

public class HB_ExcutiveLogin {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField tfExcutiveId;
	private JPasswordField tfExcutivePw;
	private JButton btnNewButton;
	private JButton btnExcutiveLogin;
	private static JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		panel = new ImagePanel(new ImageIcon("C:\\image\\123.png").getImage());
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HB_ExcutiveLogin window = new HB_ExcutiveLogin();
					window.frame.setVisible(true);
					window.frame.setLocationRelativeTo(null);
					window.frame.setSize(532,367);
					window.frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HB_ExcutiveLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("임원 로그인");
		frame.setBounds(100, 100, 546, 404);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getTfExcutiveId());
		frame.getContentPane().add(getTfExcutivePw());
		frame.getContentPane().add(getBtnNewButton());
		frame.getContentPane().add(getBtnExcutiveLogin());
		frame.getContentPane().add(getPanel());
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("아이디 :");
			lblNewLabel.setForeground(new Color(0, 0, 0));
			lblNewLabel.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 19));
			lblNewLabel.setBounds(125, 111, 94, 36);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("비밀번호 :");
			lblNewLabel_1.setForeground(new Color(0, 0, 0));
			lblNewLabel_1.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 19));
			lblNewLabel_1.setBounds(125, 157, 94, 36);
		}
		return lblNewLabel_1;
	}
	private JTextField getTfExcutiveId() {
		if (tfExcutiveId == null) {
			tfExcutiveId = new JTextField();
			tfExcutiveId.setBounds(231, 112, 154, 36);
			tfExcutiveId.setColumns(10);
		}
		return tfExcutiveId;
	}
	private JPasswordField getTfExcutivePw() {
		if (tfExcutivePw == null) {
			tfExcutivePw = new JPasswordField();
			tfExcutivePw.setBounds(231, 158, 154, 36);
		}
		return tfExcutivePw;
	}
	
	
	// --------------------------------- Action Listener -------------------------------------------
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("회원가입");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					HB_ExcutiveSignUp.main(null);
					frame.setVisible(false);
					
				}
			});
			btnNewButton.setBounds(125, 253, 116, 47);
		}
		return btnNewButton;
	}
	private JButton getBtnExcutiveLogin() {
		if (btnExcutiveLogin == null) {
			btnExcutiveLogin = new JButton("로그인");
			btnExcutiveLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					int tfcheck = insertFieldCheck();
					if(tfcheck == 0) {
						excutiveLoginCheck();
						
					}
					
					
				}
			});
			btnExcutiveLogin.setBounds(269, 253, 116, 47);
		}
		return btnExcutiveLogin;
	}
	// --------------------------------- Action Listener -------------------------------------------
	
	// -------------------------------------------------------------------------------------
	
	// 빈칸 입력 못하게 막아주는 메소드
	private int insertFieldCheck() {
		
		int i = 0;
		String result = "";
		
		if(tfExcutiveId.getText().trim().length() == 0) {
			i++;
			result = "ID를 ";
			tfExcutiveId.requestFocus();
			
		} else if(tfExcutivePw.getText().trim().length() == 0) {
			i++;
			result = "PW를 ";
			tfExcutivePw.requestFocus();
			
		}
		
		if(i > 0) {
			JOptionPane.showMessageDialog(null, result + "확인하세요!");
		}
		
		return i;
	}
		
	// login check (임원 아이디만 로그인 가능)
	private void excutiveLoginCheck() {
		
		String excutiveId = tfExcutiveId.getText().trim();
		String excutivePw = tfExcutivePw.getText().trim();
		
		// id, pw 값을 dao로 전달
		HB_ExcutiveLoginDao dao = new HB_ExcutiveLoginDao(excutiveId, excutivePw);
		int[] check = dao.excutiveLoginCheck();
		// return 값 check 배열로 받기
		
		if(check[0] == 1 && check[1] == 0) { // count가 1이고 employee_role이 0 (임원) 이면 로그인 성공
			
			int result = JOptionPane.showConfirmDialog(null, "로그인 하시겠습니까?", "Confirm", JOptionPane.YES_NO_OPTION);
			if(result == JOptionPane.CLOSED_OPTION) {
				// 사용자가 '예', '아니오'를 선택하지 않고 창을 닫았을 경우
			} else if(result == JOptionPane.YES_OPTION){
				// 사용자가 '예'를 선택하였을 경우
				HB_ShopSalesStatusPage.main(null);
				frame.setVisible(false);
				
			} else {
				// 사용자가 '아니오'를 선택하였을 경우
				
			}
			

		} else {
			JOptionPane.showMessageDialog(null, "로그인 실패");			
		}
		
	}
	
	
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(0, 0, 532, 367);
		}
		return panel;
	}
} // End Line