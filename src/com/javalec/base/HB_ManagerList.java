package com.javalec.base;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.dao.HB_ManagerListDao;
import com.javalec.dto.HB_ManagerListDto;
import com.javalec.util.HB_Static;

public class HB_ManagerList {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JLabel lblSalesStatus;
	private JLabel lblStaffList;
	private JScrollPane scrollPane;
	private JTable Inner_Table;
	private final DefaultTableModel Outer_Table = new DefaultTableModel();
	private JLabel lblTotalManagerNumber;
	private JComboBox cbManagerInfo;
	private JTextField tfManagerText;
	private JButton btnNewButton;
	private JLabel lblManagerList;
	private JLabel lblManagerInsert;
	private JLabel lblStoreInsert;
	private JButton btnNewButton_1;
	private JLabel lblAttendManage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HB_ManagerList window = new HB_ManagerList();
					window.frame.setVisible(true);
					window.frame.setLocationRelativeTo(null);
					window.frame.setSize(697,542);
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
	public HB_ManagerList() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("?????? ?????????");
		frame.addWindowListener(new WindowAdapter() {

			@Override
			public void windowActivated(WindowEvent e) {
				managerTableInit();
				managerSearchAction();
			}
		});
		frame.setBounds(100, 100, 697, 541);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getLblSalesStatus());
		frame.getContentPane().add(getLblStaffList());
		frame.getContentPane().add(getScrollPane());
		frame.getContentPane().add(getLblTotalManagerNumber());
		frame.getContentPane().add(getCbManagerInfo());
		frame.getContentPane().add(getTfManagerText());
		frame.getContentPane().add(getBtnNewButton());
		frame.getContentPane().add(getLblManagerList());
		frame.getContentPane().add(getLblManagerInsert());
		frame.getContentPane().add(getLblStoreInsert());
		frame.getContentPane().add(getBtnNewButton_1());
		frame.getContentPane().add(getLblAttendManage());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("MelHor Coffee");
			lblNewLabel.setBackground(new Color(235, 199, 189));
			lblNewLabel.setFont(new Font("??????", Font.ITALIC, 19));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(0, 0, 683, 69);
			lblNewLabel.setOpaque(true);
		}
		return lblNewLabel;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(115, 106, 568, 372);
			scrollPane.setViewportView(getInner_Table());
		}
		return scrollPane;
	}
	private JLabel getLblTotalManagerNumber() {
		if (lblTotalManagerNumber == null) {
			lblTotalManagerNumber = new JLabel("??? ?????? ???");
			lblTotalManagerNumber.setBounds(520, 479, 163, 25);
		}
		return lblTotalManagerNumber;
	}
	
	private JComboBox getCbManagerInfo() {
		if (cbManagerInfo == null) {
			cbManagerInfo = new JComboBox();
			cbManagerInfo.setModel(new DefaultComboBoxModel(new String[] {"?????? ??????", "?????????", "?????? ??????"}));
			cbManagerInfo.setBounds(115, 69, 125, 39);
		}
		return cbManagerInfo;
	}
	private JTextField getTfManagerText() {
		if (tfManagerText == null) {
			tfManagerText = new JTextField();
			tfManagerText.setBounds(241, 69, 346, 39);
			tfManagerText.setColumns(10);
		}
		return tfManagerText;
	}
	private JLabel getLblSalesStatus() {
		if (lblSalesStatus == null) {
			lblSalesStatus = new JLabel("?????? ?????????");
			lblSalesStatus.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					HB_ShopSalesStatusPage.main(null);
					frame.setVisible(false);
					
				}
			});
			lblSalesStatus.setForeground(new Color(0, 0, 0));
			lblSalesStatus.setBackground(new Color(227, 147, 132));
			lblSalesStatus.setHorizontalAlignment(SwingConstants.CENTER);
			lblSalesStatus.setBounds(0, 69, 114, 39);
			lblSalesStatus.setOpaque(true);

		}
		return lblSalesStatus;
	}
	private JLabel getLblStaffList() {
		if (lblStaffList == null) {
			lblStaffList = new JLabel("????????? ?????????");
			lblStaffList.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					HB_StaffManageList.main(null);
					frame.setVisible(false);
					
				}
			});
			lblStaffList.setBackground(new Color(235, 199, 189));
			lblStaffList.setHorizontalAlignment(SwingConstants.CENTER);
			lblStaffList.setBounds(0, 108, 114, 39);
			lblStaffList.setOpaque(true);
		}
		return lblStaffList;
	}
	private JLabel getLblManagerList() {
		if (lblManagerList == null) {
			lblManagerList = new JLabel("?????? ?????????");
			lblManagerList.setOpaque(true);
			lblManagerList.setHorizontalAlignment(SwingConstants.CENTER);
			lblManagerList.setBackground(new Color(235, 199, 189));
			lblManagerList.setBounds(0, 186, 114, 39);
		}
		return lblManagerList;
	}
	private JLabel getLblManagerInsert() {
		if (lblManagerInsert == null) {
			lblManagerInsert = new JLabel("?????? ??????");
			lblManagerInsert.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					HB_ManagerAppoint.main(null);
					frame.setVisible(false);
					
				}
			});
			lblManagerInsert.setOpaque(true);
			lblManagerInsert.setHorizontalAlignment(SwingConstants.CENTER);
			lblManagerInsert.setForeground(Color.BLACK);
			lblManagerInsert.setBackground(new Color(227, 147, 132));
			lblManagerInsert.setBounds(0, 147, 114, 39);
		}
		return lblManagerInsert;
	}
	private JLabel getLblStoreInsert() {
		if (lblStoreInsert == null) {
			lblStoreInsert = new JLabel("?????? ??????");
			lblStoreInsert.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					HB_ShopInsert.main(null);
					frame.setVisible(false);
					
				}
			});
			lblStoreInsert.setOpaque(true);
			lblStoreInsert.setHorizontalAlignment(SwingConstants.CENTER);
			lblStoreInsert.setForeground(Color.BLACK);
			lblStoreInsert.setBackground(new Color(227, 147, 132));
			lblStoreInsert.setBounds(0, 225, 114, 39);
		}
		return lblStoreInsert;
	}
	private JLabel getLblAttendManage() {
		if (lblAttendManage == null) {
			lblAttendManage = new JLabel("?????? ??????");
			lblAttendManage.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					HB_AttendManage.main(null);
					frame.setVisible(false);
					
				}
			});
			lblAttendManage.setOpaque(true);
			lblAttendManage.setHorizontalAlignment(SwingConstants.CENTER);
			lblAttendManage.setBackground(new Color(235, 199, 189));
			lblAttendManage.setBounds(0, 264, 114, 39);
		}
		return lblAttendManage;
	}
	// --------------------------------- Action Listener -------------------------------------------
	
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("??????");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					managerTableInit();
					managerSearchAction();
					
				}
			});
			btnNewButton.setBounds(586, 69, 97, 39);
		}
		return btnNewButton;
	}
	
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("????????????");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					HB_ExcutiveLogin.main(null);
					frame.setVisible(false);
					HB_Static.setEmployee_id(0);
					
				}
			});
			btnNewButton_1.setBounds(563, 24, 108, 25);
		}
		return btnNewButton_1;
	}
	
	private JTable getInner_Table() {
		if (Inner_Table == null) {
			Inner_Table = new JTable();
			Inner_Table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (e.getButton() == 1) { // ????????? ?????????

						int i = Inner_Table.getSelectedRow(); // ????????? ???????????? ????????? ??? ?????? ?????????
						String managerId = (String) Inner_Table.getValueAt(i, 1); // ???????????? ?????? i?????? ???????????? ??? 1????????? ?????? ???????????? wkSequence ????????? ?????? 
						String shopNumber = (String) Inner_Table.getValueAt(i, 6);
//						wkSequence?????? employee_id ?????? ??????
						
						HB_Static.setEmployee_id(Integer.parseInt(managerId)); // static?????? Shop_number ?????? ?????? ??? ????????? ??? ???????????? ??????
						HB_Static.setShop_number(Integer.parseInt(shopNumber));
						HB_ManagerSalesStatus.main(null); // ?????? ??? ?????? ?????? ?????????
						frame.setVisible(false);
						
					}
				}
			});
			
			Inner_Table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			Inner_Table.setModel(Outer_Table);
		}
		return Inner_Table;
	}
	
	// --------------------------------- Action Listener -------------------------------------------
	
	// -----------------------------------------------------------------------------------
	
	private void managerTableInit() {
		
		Outer_Table.addColumn("?????? ??????");
		Outer_Table.addColumn("?????? ??????");
		Outer_Table.addColumn("?????????");
		Outer_Table.addColumn("?????? ??????");
		Outer_Table.addColumn("????????????");
		Outer_Table.addColumn("????????????");
		Outer_Table.addColumn("????????????");
		
		Outer_Table.setColumnCount(7);
		
		int i = Outer_Table.getRowCount();
		
		for(int j = 0; j < i; j++) {
			Outer_Table.removeRow(0);
		}
		
			Inner_Table.setAutoResizeMode(Inner_Table.AUTO_RESIZE_OFF);
			
			int vColIndex = 0;
			TableColumn col = Inner_Table.getColumnModel().getColumn(vColIndex);
			int width = 80;
			col.setPreferredWidth(width);

			vColIndex = 1;
			col = Inner_Table.getColumnModel().getColumn(vColIndex);
			width = 70;
			col.setPreferredWidth(width);
			
			vColIndex = 2;
			col = Inner_Table.getColumnModel().getColumn(vColIndex);
			width = 60;
			col.setPreferredWidth(width);
	
			vColIndex = 3;
			col = Inner_Table.getColumnModel().getColumn(vColIndex);
			width = 164;
			col.setPreferredWidth(width);
			
			vColIndex = 4;
			col = Inner_Table.getColumnModel().getColumn(vColIndex);
			width = 100;
			col.setPreferredWidth(width);
	
			vColIndex = 5;
			col = Inner_Table.getColumnModel().getColumn(vColIndex);
			width = 94;
			col.setPreferredWidth(width);
			
			vColIndex = 6;
			col = Inner_Table.getColumnModel().getColumn(vColIndex);
			width = 94;
			col.setPreferredWidth(width);

	}

	// ??? ?????? ????????? ?????? ?????????
	public void managerSearchAction() {
		/*
		 * ?????? ???????????? SelectedItem?????? ????????? ?????? result ????????? ???????????? MySQL like??? ??????
		 */

		String result = "";

		if ((String) cbManagerInfo.getSelectedItem() == "?????? ??????") {
			result = "e.employee_name"; // employee Table ?????????

		} else if((String) cbManagerInfo.getSelectedItem() == "?????????") {
			result = "s.shop_name"; // shop Table ?????????

		} else {
			result = "s.shop_address"; // shop Table ?????????

		}

		String managerText = tfManagerText.getText();

		
		HB_ManagerListDao dao = new HB_ManagerListDao(result, managerText); // ????????????, ??????????????? ??? Dao??? ??????
		ArrayList<HB_ManagerListDto> dtoList = dao.managerConditionList();

		int listCount = dtoList.size();

		for (int i = 0; i < listCount; i++) {
			String[] qTxt = { dtoList.get(i).getEmployee_name(), Integer.toString(dtoList.get(i).getEmployee_id()), dtoList.get(i).getShop_name(), dtoList.get(i).getShop_address(),
					dtoList.get(i).getEmployee_telno(), dtoList.get(i).getEmployee_in_date(), Integer.toString(dtoList.get(i).getEmployee_shop_number())};
			Outer_Table.addRow(qTxt);
		}
		// ??? ?????? ?????? listCount??? ????????? ??????
		lblTotalManagerNumber.setText("??? ?????? ???: " + Integer.toString(listCount) + "???");

	}



} // End Line
