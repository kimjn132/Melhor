package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;

import com.javalec.dao.AdminStaffDetailDao;
import com.javalec.dto.AdminStaffDetailDto;
import com.javalec.util.StaticClass;

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminStaffDetail extends JFrame {

	private JFrame frame;
	private JLabel lblGoHome;
	private JLabel lblNew3333;
	private JLabel lblNewLabel;
	private JLabel lblStore;
	private JTextField tfStaffId;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField tfStaffName;
	private JLabel lblNewLabel_3;
	private JTextField tfStaffInDate;
	private JLabel lblNewLabel_4;
	private JTextField tfStaffTelno;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_1_2;
	private JTextField tfStaffEmail;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JLabel lblArrow;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminStaffDetail window = new AdminStaffDetail();
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
	public AdminStaffDetail() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("스태프 상세 ");
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				settingInfo();
			}
		});
		frame.getContentPane().setBackground(new Color(247, 243, 243));
		frame.setBounds(100, 100, 600, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblArrow());
		frame.getContentPane().add(getBtnNewButton_1());
		frame.getContentPane().add(getBtnNewButton());
		frame.getContentPane().add(getLblNewLabel_1_2());
		frame.getContentPane().add(getLblGoHome());
		frame.getContentPane().add(getLblStore());
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getLblNew3333());
		frame.getContentPane().add(getTfStaffId());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getLblNewLabel_2());
		frame.getContentPane().add(getTfStaffName());
		frame.getContentPane().add(getLblNewLabel_3());
		frame.getContentPane().add(getTfStaffInDate());
		frame.getContentPane().add(getLblNewLabel_4());
		frame.getContentPane().add(getTfStaffTelno());
		frame.getContentPane().add(getLblNewLabel_5());
		frame.getContentPane().add(getTfStaffEmail());
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
			lblNewLabel.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 18));
			lblNewLabel.setBounds(182, 9, 142, 23);
		}
		return lblNewLabel;
	}

	private JLabel getLblStore() {
		if (lblStore == null) {
			lblStore = new JLabel("지점");
			lblStore.setForeground(new Color(60, 143, 96));
			lblStore.setFont(new Font("굴림", Font.PLAIN, 15));
			lblStore.setBounds(355, 8, 50, 23);
			lblStore.setText(StaticClass.shop_name);
		}
		return lblStore;
	}

	private JTextField getTfStaffId() {
		if (tfStaffId == null) {
			tfStaffId = new JTextField();
			tfStaffId.setForeground(new Color(60, 143, 96));
			tfStaffId.setEditable(false);
			tfStaffId.setColumns(10);
			tfStaffId.setBounds(230, 79, 111, 21);
		}
		return tfStaffId;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("New label");
			lblNewLabel_1.setBounds(50, 93, 100, 100);
		}
		return lblNewLabel_1;
	}

	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("이름");
			lblNewLabel_2.setBounds(230, 135, 50, 15);
		}
		return lblNewLabel_2;
	}

	private JTextField getTfStaffName() {
		if (tfStaffName == null) {
			tfStaffName = new JTextField();
			tfStaffName.setColumns(10);
			tfStaffName.setBounds(320, 130, 96, 21);
		}
		return tfStaffName;
	}

	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("입사일");
			lblNewLabel_3.setBounds(230, 180, 50, 15);
		}
		return lblNewLabel_3;
	}

	private JTextField getTfStaffInDate() {
		if (tfStaffInDate == null) {
			tfStaffInDate = new JTextField();
			tfStaffInDate.setEditable(false);
			tfStaffInDate.setColumns(10);
			tfStaffInDate.setBounds(320, 175, 136, 21);
		}
		return tfStaffInDate;
	}

	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("전화번호");
			lblNewLabel_4.setBounds(230, 225, 60, 15);
		}
		return lblNewLabel_4;
	}

	private JTextField getTfStaffTelno() {
		if (tfStaffTelno == null) {
			tfStaffTelno = new JTextField();
			tfStaffTelno.setColumns(10);
			tfStaffTelno.setBounds(320, 220, 136, 21);
		}
		return tfStaffTelno;
	}

	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("이메일");
			lblNewLabel_5.setBounds(230, 270, 50, 15);
		}
		return lblNewLabel_5;
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

	private JTextField getTfStaffEmail() {
		if (tfStaffEmail == null) {
			tfStaffEmail = new JTextField();
			tfStaffEmail.setBounds(320, 267, 96, 21);
			tfStaffEmail.setColumns(10);
		}
		return tfStaffEmail;
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("수정하기");
			// 수정하기 버튼 
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					staffUpdate();
				}
			});
			btnNewButton.setBounds(483, 380, 91, 23);
		}
		return btnNewButton;
	}

	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("해제하기");
			// 스태프 등록 해제 버튼
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					staffUnRegister();
				}
			});
			btnNewButton_1.setBounds(378, 380, 91, 23);
		}
		return btnNewButton_1;
	}

	private JLabel getLblArrow() {
		if (lblArrow == null) {
			lblArrow = new JLabel("");
			lblArrow.addMouseListener(new MouseAdapter() {
				// 뒤로 가기 클릭 이벤트
				@Override
				public void mouseClicked(MouseEvent e) {
					frame.setVisible(false);
					AdminRegisterStaffManagement.main(null);
				}
			});
			lblArrow.setBounds(10, 2, 35, 35);
			ImageIcon icon = new ImageIcon(AdminStaffDetail.class.getResource("/com/javalec/image/leftarrow.png"));
			Image img = icon.getImage(); // ImageIcon을 Image로 변환.
			Image updateImg = img.getScaledInstance(25, 15, java.awt.Image.SCALE_SMOOTH);
			ImageIcon updateIcon = new ImageIcon(updateImg);

			lblArrow.setIcon(updateIcon);
		}
		return lblArrow;
	}

	// ============================메소드=================================

	private void settingInfo() {

		AdminStaffDetailDao dao = new AdminStaffDetailDao();
		AdminStaffDetailDto dto = dao.tableClick();

		tfStaffId.setText(Integer.toString(dto.getWkId()));
		tfStaffName.setText(dto.getWkName());
		tfStaffInDate.setText(dto.getWkInDate());
		tfStaffTelno.setText(dto.getWkTelno());
		tfStaffEmail.setText(dto.getWkEmail());
		
		StaticClass.staff_name = dto.getWkName();

	}

	public void staffUnRegister() {

		AdminStaffDetailDao dao = new AdminStaffDetailDao();

		Boolean ok = dao.staffUnRegister();
		if (ok == true) {

			JOptionPane.showMessageDialog(null, StaticClass.staff_name + "님이 등록 해제 되었습니다.");
			frame.setVisible(false);
			AdminRegisterStaffManagement.main(null);
			
		} else {
			
			JOptionPane.showMessageDialog(null, "작업중 문제발생했습니다.");

		}

	}
	
	public void staffUpdate() {
		
		String name = tfStaffName.getText();
		String telno = tfStaffTelno.getText();
		String address = tfStaffEmail.getText();

		AdminStaffDetailDao dao = new AdminStaffDetailDao(name, telno, address);

		Boolean ok = dao.updateAction();

		if (ok == true) {

			JOptionPane.showMessageDialog(null, StaticClass.staff_name + "님의 정보가 수정되었습니다.");
			frame.setVisible(false);
			AdminRegisterStaffManagement.main(null);
			
			
		} else {
			JOptionPane.showMessageDialog(null, "작업중 문제발생했습니다.");

		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}// END
