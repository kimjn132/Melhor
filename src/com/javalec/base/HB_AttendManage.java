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

import com.javalec.dao.HB_AttendManageDao;
import com.javalec.dao.HB_StaffManageListDao;
import com.javalec.dto.HB_AttendManageDto;
import com.javalec.dto.HB_staffManageListDto;
import com.javalec.util.HB_Static;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class HB_AttendManage {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JLabel lblSalesStatus;
	private JLabel lblStaffList;
	private JScrollPane scrollPane;
	private JTable Inner_Table;
	private final DefaultTableModel Outer_Table = new DefaultTableModel();
	private JComboBox cbStaffInfo;
	private JTextField tfSearchText;
	private JButton btnNewButton;
	private JLabel lblManagerList;
	private JLabel lblManagerInsert;
	private JLabel lblStoreInsert;
	private JLabel lblAttendManage;
	private JRadioButton rbManager;
	private JRadioButton rbStaff;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JComboBox cbMonth;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HB_AttendManage window = new HB_AttendManage();
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
	public HB_AttendManage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("?????? ?????? ?????????");
		frame.addWindowListener(new WindowAdapter() {

			@Override
			public void windowActivated(WindowEvent e) {
				attendTableInit();
				attendManageList();
			}
		});
		frame.setBounds(100, 100, 697, 541);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getLblSalesStatus());
		frame.getContentPane().add(getLblStaffList());
		frame.getContentPane().add(getCbStaffInfo());
		frame.getContentPane().add(getTfSearchText());
		frame.getContentPane().add(getLblManagerList());
		frame.getContentPane().add(getLblManagerInsert());
		frame.getContentPane().add(getLblStoreInsert());
		frame.getContentPane().add(getLblAttendManage());
		frame.getContentPane().add(getBtnNewButton());
		frame.getContentPane().add(getScrollPane());
		frame.getContentPane().add(getRbManager());
		frame.getContentPane().add(getRbStaff());
		frame.getContentPane().add(getCbMonth());
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
	
	private JComboBox getCbStaffInfo() {
		if (cbStaffInfo == null) {
			cbStaffInfo = new JComboBox();
			cbStaffInfo.setModel(new DefaultComboBoxModel(new String[] {"??????"}));
			cbStaffInfo.setBounds(115, 69, 125, 39);
		}
		return cbStaffInfo;
	}
	private JTextField getTfSearchText() {
		if (tfSearchText == null) {
			tfSearchText = new JTextField();
			tfSearchText.setBounds(241, 69, 346, 39);
			tfSearchText.setColumns(10);
		}
		return tfSearchText;
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
			lblManagerList.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					HB_ManagerList.main(null);
					frame.setVisible(false);
					
				}
			});
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
			lblAttendManage.setOpaque(true);
			lblAttendManage.setHorizontalAlignment(SwingConstants.CENTER);
			lblAttendManage.setBackground(new Color(235, 199, 189));
			lblAttendManage.setBounds(0, 264, 114, 39);
		}
		return lblAttendManage;
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("??????");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					

				}
			});
			btnNewButton.setBounds(586, 69, 97, 39);
		}
		return btnNewButton;
	}
	
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(115, 133, 556, 296);
			scrollPane.setViewportView(getInner_Table());
		}
		return scrollPane;
	}
	private JTable getInner_Table() {
		if (Inner_Table == null) {
			Inner_Table = new JTable();
			Inner_Table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {

					// Table ????????? ?????? ????????? ??????
					if(e.getButton() == 1) { // ????????? ?????????
						
						
					}
					

				}
			});
			Inner_Table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			Inner_Table.setModel(Outer_Table);
		}
		return Inner_Table;
	}
	private JRadioButton getRbManager() {
		if (rbManager == null) {
			rbManager = new JRadioButton("??????");
			rbManager.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					attendTableInit();
					attendManageList();
					
				}
			});
			buttonGroup.add(rbManager);
			rbManager.setSelected(true);
			rbManager.setBounds(612, 108, 59, 23);
		}
		return rbManager;
	}
	private JRadioButton getRbStaff() {
		if (rbStaff == null) {
			rbStaff = new JRadioButton("?????????");
			rbStaff.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					attendTableInit();
					attendManageList();
					
				}
			});
			buttonGroup.add(rbStaff);
			rbStaff.setSelected(true);
			rbStaff.setBounds(531, 108, 77, 23);
		}
		return rbStaff;
	}
	private JComboBox getCbMonth() {
		if (cbMonth == null) {
			cbMonth = new JComboBox();
			cbMonth.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if(cbMonth.getSelectedItem() == "1???") {
						HB_Static.setMonth(0);
					} else if(cbMonth.getSelectedItem() == "2???") {
						HB_Static.setMonth(2);
					} else if(cbMonth.getSelectedItem() == "3???") {
						HB_Static.setMonth(3);
					} else if(cbMonth.getSelectedItem() == "4???") {
						HB_Static.setMonth(4);
					} else if(cbMonth.getSelectedItem() == "5???") {
						HB_Static.setMonth(5);
					} else if(cbMonth.getSelectedItem() == "6???") {
						HB_Static.setMonth(6);
					} else if(cbMonth.getSelectedItem() == "7???") {
						HB_Static.setMonth(7);
					} else if(cbMonth.getSelectedItem() == "8???") {
						HB_Static.setMonth(8);
					} else if(cbMonth.getSelectedItem() == "9???") {
						HB_Static.setMonth(9);
					} else if(cbMonth.getSelectedItem() == "10???") {
						HB_Static.setMonth(10);
					} else if(cbMonth.getSelectedItem() == "11???") {
						HB_Static.setMonth(11);
					} else if(cbMonth.getSelectedItem() == "12???") {
						HB_Static.setMonth(12);
					}
					
					attendTableInit();
					attendManageList();
					
				}
			});
			cbMonth.setModel(new DefaultComboBoxModel(new String[] {"1???", "2???", "3???", "4???", "5???", "6???", "7???", "8???", "9???", "10???", "11???", "12???"}));
			cbMonth.setBounds(436, 108, 87, 23);
		}
		return cbMonth;
	}
	
	
	
	// -------------------------------------------------------------------------------------------------

	private void attendTableInit() {

		Outer_Table.addColumn("????????????");
		Outer_Table.addColumn("??????");
		Outer_Table.addColumn("??????");
		Outer_Table.addColumn("????????????");

		Outer_Table.setColumnCount(4);

		int i = Outer_Table.getRowCount();

		for (int j = 0; j < i; j++) {
			Outer_Table.removeRow(0);
		}

		Inner_Table.setAutoResizeMode(Inner_Table.AUTO_RESIZE_OFF);

		int vColIndex = 0;
		TableColumn col = Inner_Table.getColumnModel().getColumn(vColIndex);
		int width = 100;
		col.setPreferredWidth(width);

		vColIndex = 1;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 120;
		col.setPreferredWidth(width);

		vColIndex = 2;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 110;
		col.setPreferredWidth(width);

		vColIndex = 3;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 100;
		col.setPreferredWidth(width);

	}
	
	
	public void attendManageList() {
		
		/*
		 * ?????? ???????????? SelectedItem?????? ????????? ?????? result ????????? ???????????? MySQL like??? ??????
		 */
		String result = "";
		String searchText = tfSearchText.getText();
		int rbEmployee = 0;

		if ((String) cbStaffInfo.getSelectedItem() == "??????") {
			result = "e.employee_name"; // employee Table ?????????
		}

		if(rbManager.isSelected() == true) {
			rbEmployee = 1;
		} else if(rbStaff.isSelected() == true) {
			rbEmployee = 2;
		}
		
		
		
		HB_AttendManageDao dao = new HB_AttendManageDao(result, searchText);

		ArrayList<HB_AttendManageDto> dtoList = dao.attendManageList(rbEmployee);
		int listCount = dtoList.size();

		for (int i = 0; i < listCount; i++) {
			String[] qTxt = {Integer.toString(dtoList.get(i).getEmployee_id()), dtoList.get(i).getEmployee_name(), 
					dtoList.get(i).getShop_name(), Integer.toString(dtoList.get(i).getAteend_count())};

			Outer_Table.addRow(qTxt);
		}

	}
	
	
	
} // End Line
