package com.javalec.base;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.javalec.dao.HB_StaffManageListDao;
import com.javalec.dto.HB_staffManageListDto;
import com.javalec.util.DBConnect;
import com.javalec.util.HB_Static;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HB_StaffSalesStatus {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_2_1;
	private JLabel lblNewLabel_2_2;
	private JLabel lblNewLabel_2_3;
	private JLabel lblNewLabel_2_4;
	private JLabel lblNewLabel_3;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_3_1;
	private JLabel lblNewLabel_3_2;
	private JLabel lblNewLabel_2_5;
	private JTextField tfEmployee_id;
	private JTextField tfEmployee_name;
	private JTextField tfEmployee_telno;
	private JTextField tfEmployee_in_date;
	private JTextField tfEmployee_email;
	private JLabel lblEmployeeTodaySales;
	private JLabel lblEmployee_image;
	private JTextField tfFilePath;
	private JLabel lblIncentive;
	private JLabel lblWage;
	private JLabel lblTotalPayment;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HB_StaffSalesStatus window = new HB_StaffSalesStatus();
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
	public HB_StaffSalesStatus() {
		initialize();
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("알바생 금일 판매 건수 및 총 급여");
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
		frame.getContentPane().add(getLblNewLabel_2_4());
		frame.getContentPane().add(getLblNewLabel_3());
		frame.getContentPane().add(getBtnNewButton_1());
		frame.getContentPane().add(getLblNewLabel_3_1());
		frame.getContentPane().add(getLblNewLabel_3_2());
		frame.getContentPane().add(getLblNewLabel_2_5());
		frame.getContentPane().add(getTfEmployee_id());
		frame.getContentPane().add(getTfEmployee_name());
		frame.getContentPane().add(getTfEmployee_telno());
		frame.getContentPane().add(getTfEmployee_in_date());
		frame.getContentPane().add(getTfEmployee_email());
		frame.getContentPane().add(getLblEmployeeTodaySales());
		frame.getContentPane().add(getLblEmployee_image());
		frame.getContentPane().add(getTextField());
		frame.getContentPane().add(getLblIncentive());
		frame.getContentPane().add(getLblWage());
		frame.getContentPane().add(getLblTotalPayment());
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
	private JLabel getLblNewLabel_2_4() {
		if (lblNewLabel_2_4 == null) {
			lblNewLabel_2_4 = new JLabel("금일 판매 건수 :");
			lblNewLabel_2_4.setBounds(333, 282, 98, 27);
		}
		return lblNewLabel_2_4;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("금일 인센티브 :");
			lblNewLabel_3.setBounds(80, 282, 98, 27);
		}
		return lblNewLabel_3;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("확인");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					HB_StaffManageList.main(null);
					frame.setVisible(false);
					
				}
			});
			btnNewButton_1.setBounds(245, 405, 126, 39);
		}
		return btnNewButton_1;
	}
	private JLabel getLblNewLabel_3_1() {
		if (lblNewLabel_3_1 == null) {
			lblNewLabel_3_1 = new JLabel("이번달 월급 :");
			lblNewLabel_3_1.setBounds(90, 319, 88, 27);
		}
		return lblNewLabel_3_1;
	}
	private JLabel getLblNewLabel_3_2() {
		if (lblNewLabel_3_2 == null) {
			lblNewLabel_3_2 = new JLabel("이번달 총 급여 :");
			lblNewLabel_3_2.setBounds(76, 357, 113, 27);
		}
		return lblNewLabel_3_2;
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
	private JLabel getLblEmployeeTodaySales() {
		if (lblEmployeeTodaySales == null) {
			lblEmployeeTodaySales = new JLabel("");
			lblEmployeeTodaySales.setBounds(428, 288, 50, 15);
		}
		return lblEmployeeTodaySales;
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
			tfFilePath.setBounds(333, 319, 214, 15);
			tfFilePath.setColumns(10);
			tfFilePath.setVisible(false);
		}
		return tfFilePath;
	}
	private JLabel getLblIncentive() {
		if (lblIncentive == null) {
			lblIncentive = new JLabel("New label");
			lblIncentive.setBounds(190, 282, 106, 27);
		}
		return lblIncentive;
	}
	private JLabel getLblWage() {
		if (lblWage == null) {
			lblWage = new JLabel("New label");
			lblWage.setBounds(190, 319, 106, 27);
		}
		return lblWage;
	}
	private JLabel getLblTotalPayment() {
		if (lblTotalPayment == null) {
			lblTotalPayment = new JLabel("New label");
			lblTotalPayment.setBounds(190, 357, 106, 27);
		}
		return lblTotalPayment;
	}
	
	// ----------------------------------------------------------------------
	
	private void tableClick() {

		
		HB_StaffManageListDao dao = new HB_StaffManageListDao(); // table 클릭 한 i번째 행의 id값을 불러와서 dao로 전달

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
		
		lblEmployeeTodaySales.setText(Integer.toString(dto2.getManufact_quantity())); // 금일 판매량
		
		lblIncentive.setText(Integer.toString(dto2.getManufact_quantity() * HB_Static.incentive) + "원"); // 인센티브
		lblTotalPayment.setText(Integer.toString(dto2.getManufact_quantity() * HB_Static.incentive + staffWage) + "원");  // 이번달 총 급여
		
		
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
