package com.javalec.base;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.dao.HB_ManagerListDao;
import com.javalec.dao.HB_StaffManageListDao;
import com.javalec.dto.HB_ManagerListDto;
import com.javalec.dto.HB_staffManageListDto;
import com.javalec.util.DBConnect;
import javax.swing.JScrollPane;
import javax.swing.JTable;

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
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JTable Inner_Table1;
	private JTable Inner_Table2;
	private final DefaultTableModel Outer_Table1 = new DefaultTableModel();
	private final DefaultTableModel Outer_Table2 = new DefaultTableModel();

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
				tableInit1();
				tableInit2();
				monthSales1();
				monthSales2();
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
		frame.getContentPane().add(getScrollPane());
		frame.getContentPane().add(getScrollPane_1());
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
			lblNewLabel_2.setBounds(339, 116, 86, 27);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_2_1() {
		if (lblNewLabel_2_1 == null) {
			lblNewLabel_2_1 = new JLabel("전화번호 :");
			lblNewLabel_2_1.setBounds(339, 153, 86, 27);
		}
		return lblNewLabel_2_1;
	}
	private JLabel getLblNewLabel_2_2() {
		if (lblNewLabel_2_2 == null) {
			lblNewLabel_2_2 = new JLabel("입사일자 :");
			lblNewLabel_2_2.setBounds(339, 191, 86, 27);
		}
		return lblNewLabel_2_2;
	}
	private JLabel getLblNewLabel_2_3() {
		if (lblNewLabel_2_3 == null) {
			lblNewLabel_2_3 = new JLabel("이메일 :");
			lblNewLabel_2_3.setBounds(339, 228, 86, 27);
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
			btnNewButton_1.setBounds(245, 454, 126, 39);
		}
		return btnNewButton_1;
	}
	private JLabel getLblNewLabel_3_1() {
		if (lblNewLabel_3_1 == null) {
			lblNewLabel_3_1 = new JLabel("이번달 월급 :");
			lblNewLabel_3_1.setBounds(339, 265, 88, 27);
		}
		return lblNewLabel_3_1;
	}
	private JLabel getLblNewLabel_2_5() {
		if (lblNewLabel_2_5 == null) {
			lblNewLabel_2_5 = new JLabel("사원번호 :");
			lblNewLabel_2_5.setBounds(339, 79, 86, 27);
		}
		return lblNewLabel_2_5;
	}
	private JTextField getTfEmployee_id() {
		if (tfEmployee_id == null) {
			tfEmployee_id = new JTextField();
			tfEmployee_id.setEditable(false);
			tfEmployee_id.setBounds(404, 79, 141, 27);
			tfEmployee_id.setColumns(10);
		}
		return tfEmployee_id;
	}
	private JTextField getTfEmployee_name() {
		if (tfEmployee_name == null) {
			tfEmployee_name = new JTextField();
			tfEmployee_name.setEditable(false);
			tfEmployee_name.setColumns(10);
			tfEmployee_name.setBounds(404, 119, 141, 27);
		}
		return tfEmployee_name;
	}
	private JTextField getTfEmployee_telno() {
		if (tfEmployee_telno == null) {
			tfEmployee_telno = new JTextField();
			tfEmployee_telno.setEditable(false);
			tfEmployee_telno.setColumns(10);
			tfEmployee_telno.setBounds(404, 153, 141, 27);
		}
		return tfEmployee_telno;
	}
	private JTextField getTfEmployee_in_date() {
		if (tfEmployee_in_date == null) {
			tfEmployee_in_date = new JTextField();
			tfEmployee_in_date.setEditable(false);
			tfEmployee_in_date.setColumns(10);
			tfEmployee_in_date.setBounds(404, 190, 141, 27);
		}
		return tfEmployee_in_date;
	}
	private JTextField getTfEmployee_email() {
		if (tfEmployee_email == null) {
			tfEmployee_email = new JTextField();
			tfEmployee_email.setEditable(false);
			tfEmployee_email.setColumns(10);
			tfEmployee_email.setBounds(404, 228, 141, 27);
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
			tfFilePath.setBounds(350, 302, 214, 15);
			tfFilePath.setColumns(10);
			tfFilePath.setVisible(false);
		}
		return tfFilePath;
	}
	private JLabel getLblWage() {
		if (lblWage == null) {
			lblWage = new JLabel("New label");
			lblWage.setBounds(439, 265, 106, 27);
		}
		return lblWage;
	}
	
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(8, 326, 173, 120);
			scrollPane.setViewportView(getInner_Table1());
		}
		
		return scrollPane;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(195, 326, 173, 120);
			scrollPane_1.setViewportView(getInner_Table2());
		}
		return scrollPane_1;
	}
	private JTable getInner_Table1() {
		if (Inner_Table1 == null) {
			Inner_Table1 = new JTable();
			Inner_Table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			Inner_Table1.setModel(Outer_Table1);
		}
		return Inner_Table1;
	}
	private JTable getInner_Table2() {
		if (Inner_Table2 == null) {
			Inner_Table2 = new JTable();
			Inner_Table2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			Inner_Table2.setModel(Outer_Table2);
		}
		return Inner_Table2;
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
		
		
		// 이미지 처리
		String filePath = Integer.toString(DBConnect.filename);
		tfFilePath.setText(filePath);
		
		lblEmployee_image.setIcon(new ImageIcon(filePath));
		lblEmployee_image.setHorizontalAlignment(SwingConstants.CENTER);
		
		File file = new File(filePath);
		file.delete();
		
		tfFilePath.setText("");
		
	}
	
	private void tableInit1() {

		Outer_Table1.addColumn("월");
		Outer_Table1.addColumn("금액");

		Outer_Table1.setColumnCount(2);

		int i = Outer_Table1.getRowCount();

		for (int j = 0; j < i; j++) {
			Outer_Table1.removeRow(0);
		}

		Inner_Table1.setAutoResizeMode(Inner_Table1.AUTO_RESIZE_OFF);

		int vColIndex = 0;
		int width = 80;
		TableColumn col = Inner_Table1.getColumnModel().getColumn(vColIndex);
		col.setPreferredWidth(width);

		vColIndex = 1;
		width = 90;
		col = Inner_Table1.getColumnModel().getColumn(vColIndex);
		col.setPreferredWidth(width);

	}
	
	private void monthSales1() {
		
		HB_ManagerListDao dao = new HB_ManagerListDao();
		ArrayList<HB_ManagerListDto> dtoList = dao.managerMonthSalesStatus1();

		int listCount = dtoList.size();

		for (int i = 0; i < listCount; i++) {
			
			String month = Integer.toString(i + 1);
			System.out.println("month: " + month);
			
			String[] qTxt = {month + "월", Integer.toString(dtoList.get(i).getOrder_salePrice()) + "원"};
			System.out.println("dtoList: " + dtoList.get(i).getOrder_salePrice());

			Outer_Table1.addRow(qTxt);
		}
	}
	
	private void tableInit2() {

		Outer_Table2.addColumn("월");
		Outer_Table2.addColumn("금액");

		Outer_Table2.setColumnCount(2);

		int i = Outer_Table2.getRowCount();

		for (int j = 0; j < i; j++) {
			Outer_Table2.removeRow(0);
		}

		Inner_Table2.setAutoResizeMode(Inner_Table2.AUTO_RESIZE_OFF);

		int vColIndex = 0;
		int width = 80;
		TableColumn col = Inner_Table2.getColumnModel().getColumn(vColIndex);
		col.setPreferredWidth(width);

		vColIndex = 1;
		width = 90;
		col = Inner_Table2.getColumnModel().getColumn(vColIndex);
		col.setPreferredWidth(width);

	}
	
	private void monthSales2() {
		
		HB_ManagerListDao dao = new HB_ManagerListDao();
		ArrayList<HB_ManagerListDto> dtoList = dao.managerMonthSalesStatus2();
		
		int listCount = dtoList.size();
		
		for (int i = 0; i < listCount; i++) {
			
			String month = Integer.toString(i + 7);
			System.out.println("month: " + month);
			
			String[] qTxt = {month + "월", Integer.toString(dtoList.get(i).getOrder_salePrice()) + "원"};
			System.out.println("dtoList: " + dtoList.get(i).getOrder_salePrice());
			
			Outer_Table2.addRow(qTxt);
		}
	}
		
	
	
	
	
	
	
	
} // End Line
