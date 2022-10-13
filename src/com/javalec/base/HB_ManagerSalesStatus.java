package com.javalec.base;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.javalec.dao.HB_StaffManageListDao;
import com.javalec.dto.HB_staffManageListDto;
import com.javalec.util.DBConnect;
import com.javalec.util.HB_Static;

public class HB_ManagerSalesStatus {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_2_1;
	private JLabel lblNewLabel_2_2;
	private JLabel lblNewLabel_2_3;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_3_1;
	private JLabel lblNewLabel_2_5;
	private JTextField tfEmployee_id;
	private JTextField tfEmployee_name;
	private JTextField tfEmployee_telno;
	private JTextField tfEmployee_in_date;
	private JTextField tfEmployee_email;
	private JLabel lblEmployee_image;
	private JTextField tfFilePath;
	private JLabel lblWage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HB_ManagerSalesStatus window = new HB_ManagerSalesStatus();
					window.frame.setVisible(true);
					window.frame.setLocationRelativeTo(null);
					window.frame.setSize(630,540);
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
	public HB_ManagerSalesStatus() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {

			@Override
			public void windowActivated(WindowEvent e) {
				tableClick();
			}
		});
		frame.setBounds(100, 100, 630, 540);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getLblNewLabel_2());
		frame.getContentPane().add(getLblNewLabel_2_1());
		frame.getContentPane().add(getLblNewLabel_2_2());
		frame.getContentPane().add(getLblNewLabel_2_3());
		frame.getContentPane().add(getBtnNewButton_1());
		frame.getContentPane().add(getLblNewLabel_3_1());
		frame.getContentPane().add(getLblNewLabel_2_5());
		frame.getContentPane().add(getTfEmployee_id());
		frame.getContentPane().add(getTfEmployee_name());
		frame.getContentPane().add(getTfEmployee_telno());
		frame.getContentPane().add(getTfEmployee_in_date());
		frame.getContentPane().add(getTfEmployee_email());
		frame.getContentPane().add(getLblEmployee_image());
		frame.getContentPane().add(getTextField());
		frame.getContentPane().add(getLblWage());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("MelHor Coffee");
			lblNewLabel.setBackground(new Color(235, 199, 189));
			lblNewLabel.setFont(new Font("굴림", Font.ITALIC, 19));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(0, 0, 621, 69);
			lblNewLabel.setOpaque(true);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("이름 :");
			lblNewLabel_2.setBounds(333, 133, 86, 27);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_2_1() {
		if (lblNewLabel_2_1 == null) {
			lblNewLabel_2_1 = new JLabel("전화번호 :");
			lblNewLabel_2_1.setBounds(333, 170, 86, 27);
		}
		return lblNewLabel_2_1;
	}
	private JLabel getLblNewLabel_2_2() {
		if (lblNewLabel_2_2 == null) {
			lblNewLabel_2_2 = new JLabel("입사일자 :");
			lblNewLabel_2_2.setBounds(333, 208, 86, 27);
		}
		return lblNewLabel_2_2;
	}
	private JLabel getLblNewLabel_2_3() {
		if (lblNewLabel_2_3 == null) {
			lblNewLabel_2_3 = new JLabel("이메일 :");
			lblNewLabel_2_3.setBounds(333, 245, 86, 27);
		}
		return lblNewLabel_2_3;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("확인");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					HB_ManagerList.main(null);
					frame.setVisible(false);
					
				}
			});
			btnNewButton_1.setBounds(246, 415, 126, 39);
		}
		return btnNewButton_1;
	}
	private JLabel getLblNewLabel_3_1() {
		if (lblNewLabel_3_1 == null) {
			lblNewLabel_3_1 = new JLabel("이번달 월급 :");
			lblNewLabel_3_1.setBounds(333, 282, 88, 27);
		}
		return lblNewLabel_3_1;
	}
	private JLabel getLblNewLabel_2_5() {
		if (lblNewLabel_2_5 == null) {
			lblNewLabel_2_5 = new JLabel("사원번호 :");
			lblNewLabel_2_5.setBounds(333, 96, 86, 27);
		}
		return lblNewLabel_2_5;
	}
	private JTextField getTfEmployee_id() {
		if (tfEmployee_id == null) {
			tfEmployee_id = new JTextField();
			tfEmployee_id.setEditable(false);
			tfEmployee_id.setBounds(398, 96, 141, 27);
			tfEmployee_id.setColumns(10);
		}
		return tfEmployee_id;
	}
	private JTextField getTfEmployee_name() {
		if (tfEmployee_name == null) {
			tfEmployee_name = new JTextField();
			tfEmployee_name.setEditable(false);
			tfEmployee_name.setColumns(10);
			tfEmployee_name.setBounds(398, 136, 141, 27);
		}
		return tfEmployee_name;
	}
	private JTextField getTfEmployee_telno() {
		if (tfEmployee_telno == null) {
			tfEmployee_telno = new JTextField();
			tfEmployee_telno.setEditable(false);
			tfEmployee_telno.setColumns(10);
			tfEmployee_telno.setBounds(398, 170, 141, 27);
		}
		return tfEmployee_telno;
	}
	private JTextField getTfEmployee_in_date() {
		if (tfEmployee_in_date == null) {
			tfEmployee_in_date = new JTextField();
			tfEmployee_in_date.setEditable(false);
			tfEmployee_in_date.setColumns(10);
			tfEmployee_in_date.setBounds(398, 207, 141, 27);
		}
		return tfEmployee_in_date;
	}
	private JTextField getTfEmployee_email() {
		if (tfEmployee_email == null) {
			tfEmployee_email = new JTextField();
			tfEmployee_email.setEditable(false);
			tfEmployee_email.setColumns(10);
			tfEmployee_email.setBounds(398, 245, 141, 27);
		}
		return tfEmployee_email;
	}
	private JLabel getLblEmployee_image() {
		if (lblEmployee_image == null) {
			lblEmployee_image = new JLabel("");
			lblEmployee_image.setHorizontalAlignment(SwingConstants.CENTER);
			lblEmployee_image.setBounds(143, 96, 162, 164);
		}
		return lblEmployee_image;
	}
	
	private JTextField getTextField() {
		if (tfFilePath == null) {
			tfFilePath = new JTextField();
			tfFilePath.setBounds(344, 319, 214, 15);
			tfFilePath.setColumns(10);
			tfFilePath.setVisible(false);
		}
		return tfFilePath;
	}
	private JLabel getLblWage() {
		if (lblWage == null) {
			lblWage = new JLabel("New label");
			lblWage.setBounds(433, 282, 106, 27);
		}
		return lblWage;
	}
	
	// ----------------------------------------------------------------------
	
	private void tableClick() {

		
		HB_StaffManageListDao dao = new HB_StaffManageListDao();

		String[] monthCalc = dao.monthCalc();

		HB_staffManageListDto dto = dao.tableClick();
		
		int staffWage = dao.staffPaymentManage(monthCalc);
		lblWage.setText(Integer.toString(staffWage) + "원"); // 월급 계산
		
		
		tfEmployee_id.setText(Integer.toString(dto.getEmployee_id()));
		tfEmployee_name.setText(dto.getEmployee_name());
		tfEmployee_telno.setText(dto.getEmployee_telno());
		tfEmployee_in_date.setText(dto.getEmployee_in_date());
		tfEmployee_email.setText(dto.getEmployee_email());
		
		HB_staffManageListDto dto2 = dao.manufactQuantity(monthCalc);
		
		// 이미지 처리
		String filePath = Integer.toString(DBConnect.filename);
		tfFilePath.setText(filePath);
		
		lblEmployee_image.setIcon(new ImageIcon(filePath));
		lblEmployee_image.setHorizontalAlignment(SwingConstants.CENTER);
		
		File file = new File(filePath);
		file.delete();
		
		tfFilePath.setText("");
		
		
	}
	
	
	
	
	
	
	
} // End Line
