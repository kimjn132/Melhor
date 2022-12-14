package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.dao.HB_ShopSalesListDao;
import com.javalec.dto.HB_shopListDto;
import com.javalec.util.HB_Static;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;

public class HB_ShopSalesStatusPage extends JFrame {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JLabel lblSalesStatus;
	private JLabel lblStaffList;
	private JScrollPane scrollPane;
	private JTable Inner_Table;
	private JLabel lblTotalSales;
	private JComboBox cbShop;
	private JTextField tfShopText;
	private JButton btnNewButton;
	private JLabel lblManagerList;
	private JLabel lblManagerInsert;
	private JLabel lblStoreInsert;
	private JButton btnNewButton_1;
	
	private final DefaultTableModel Outer_Table = new DefaultTableModel();
	
	private JLabel lblTotalShopNumber;
	private JLabel lblTodaySales;
	private JLabel lblListCount;
	private JLabel lblAttendManage;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HB_ShopSalesStatusPage window = new HB_ShopSalesStatusPage();
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
	public HB_ShopSalesStatusPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("?????? ????????? ??? ??? ?????? ??????");
		frame.addWindowListener(new WindowAdapter() {

			@Override
			public void windowActivated(WindowEvent e) {
				shopSalesTableInit();
				shopSearchAction();
				allShopTotalSales();
			}
		});
		frame.setBounds(100, 100, 697, 542);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getLblSalesStatus());
		frame.getContentPane().add(getLblStaffList());
		frame.getContentPane().add(getScrollPane());
		frame.getContentPane().add(getLblTotalSales());
		frame.getContentPane().add(getCbShop());
		frame.getContentPane().add(getTfShopText());
		frame.getContentPane().add(getBtnNewButton());
		frame.getContentPane().add(getLblManagerList());
		frame.getContentPane().add(getLblManagerInsert());
		frame.getContentPane().add(getLblStoreInsert());
		frame.getContentPane().add(getLblTotalShopNumber());
		frame.getContentPane().add(getBtnNewButton_1());
		frame.getContentPane().add(getLblTodaySales());
		frame.getContentPane().add(getLblListCount());
		frame.getContentPane().add(getLblAttendManage());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("                MelHor Coffee");
			lblNewLabel.setBackground(new Color(235, 199, 189));
			lblNewLabel.setFont(new Font("??????", Font.ITALIC, 19));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(0, 0, 585, 69);
			lblNewLabel.setOpaque(true);
		}
		return lblNewLabel;
	}
	private JLabel getLblTotalShopNumber() {
		if (lblTotalShopNumber == null) {
			lblTotalShopNumber = new JLabel("");
			lblTotalShopNumber.setBackground(new Color(235, 199, 189));
			lblTotalShopNumber.setHorizontalAlignment(SwingConstants.CENTER);
			lblTotalShopNumber.setVerticalAlignment(SwingConstants.BOTTOM);
			lblTotalShopNumber.setBounds(584, 0, 99, 69);
			lblTotalShopNumber.setOpaque(true);
		}
		return lblTotalShopNumber;
	}
	
	
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(115, 108, 568, 235);
			scrollPane.setViewportView(getInner_Table());
		}
		return scrollPane;
	}
	
	
	private JLabel getLblTotalSales() {
		if (lblTotalSales == null) {
			lblTotalSales = new JLabel("");
			lblTotalSales.setBounds(115, 385, 556, 25);
		}
		return lblTotalSales;
	}
	private JComboBox getCbShop() {
		if (cbShop == null) {
			cbShop = new JComboBox();
			cbShop.setModel(new DefaultComboBoxModel(new String[] {"?????????", "????????????"}));
			cbShop.setBounds(115, 69, 125, 39);
		}
		return cbShop;
	}
	private JTextField getTfShopText() {
		if (tfShopText == null) {
			tfShopText = new JTextField();
			tfShopText.setBounds(241, 69, 346, 39);
			tfShopText.setColumns(10);
		}
		return tfShopText;
	}
	private JLabel getLblSalesStatus() {
		if (lblSalesStatus == null) {
			lblSalesStatus = new JLabel("?????? ?????????");
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
	private JLabel getLblTodaySales() {
		if (lblTodaySales == null) {
			lblTodaySales = new JLabel("");
			lblTodaySales.setBounds(115, 420, 556, 25);
		}
		return lblTodaySales;
	}
	
	private JLabel getLblListCount() {
		if (lblListCount == null) {
			lblListCount = new JLabel("");
			lblListCount.setBounds(115, 350, 151, 25);
		}
		return lblListCount;
	}
	
	
	// --------------------------------- Action Listener -------------------------------------------
	
	private JTable getInner_Table() {
		if (Inner_Table == null) {
			Inner_Table = new JTable();
			Inner_Table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (e.getButton() == 1) { // ????????? ?????????

						int i = Inner_Table.getSelectedRow(); // ????????? ???????????? ????????? ??? ?????? ?????????
						String wkSequence = (String) Inner_Table.getValueAt(i, 0); // ???????????? ?????? i?????? ???????????? ??? 1????????? ?????? ???????????? wkSequence ????????? ?????? 
//						wkSequence?????? employee_id ?????? ??????
						
						HB_Static.setShop_number(Integer.parseInt(wkSequence)); // static?????? Shop_number ?????? ?????? ??? ????????? ??? ???????????? ??????
						
						HB_ShopDetail.main(null); // ?????? ??? ?????? ?????? ?????????
						frame.setVisible(false);
						
					}
				}
			});
			
			Inner_Table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			Inner_Table.setModel(Outer_Table);
		}
		return Inner_Table;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("??????");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					shopSalesTableInit();
					shopSearchAction();
					
				}
			});
			btnNewButton.setBounds(586, 69, 97, 39);
			Inner_Table.setModel(Outer_Table);
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
	
	// --------------------------------- Action Listener -------------------------------------------
	
	// -----------------------------------------------------------------------------------------
	
	private void shopSalesTableInit() {
		
		Outer_Table.addColumn("??????");
		Outer_Table.addColumn("????????? ????????????");
		Outer_Table.addColumn("?????????");
		Outer_Table.addColumn("?????? ??????");
		Outer_Table.addColumn("?????? ????????????");
		
		
		Outer_Table.setColumnCount(5);
		
		int i = Outer_Table.getRowCount();
		
		for(int j = 0; j < i; j++) {
			Outer_Table.removeRow(0);
		}
		
			Inner_Table.setAutoResizeMode(Inner_Table.AUTO_RESIZE_OFF);
			
			int vColIndex = 0;
			int width = 0;
			TableColumn col = Inner_Table.getColumnModel().getColumn(vColIndex);
			width = 30;
			col.setPreferredWidth(width);
	
			vColIndex = 1;
			col = Inner_Table.getColumnModel().getColumn(vColIndex);
			width = 100;
			col.setPreferredWidth(width);
	
			vColIndex = 2;
			col = Inner_Table.getColumnModel().getColumn(vColIndex);
			width = 100;
			col.setPreferredWidth(width);
	
			vColIndex = 3;
			col = Inner_Table.getColumnModel().getColumn(vColIndex);
			width = 235;
			col.setPreferredWidth(width);

			vColIndex = 4;
			col = Inner_Table.getColumnModel().getColumn(vColIndex);
			width = 100;
			col.setPreferredWidth(width);
			
	}
	
	public void shopSearchAction() {
		
		String result = "";
		
		// ?????????????????? ????????? ???????????? result????????? ???????????? ??????
		if((String)cbShop.getSelectedItem() == "?????????") {
			result = "shop_name"; // shop ????????? ?????????
			
		} else {
			result = "shop_address"; // shop ????????? ?????????
			
		} // ??? result?????? sql??? where like????????? ??????

		String ShopText = tfShopText.getText(); // << ???????????? sql where like????????? ??????
		
		HB_ShopSalesListDao dao = new HB_ShopSalesListDao(result, ShopText); // dao??? ??? ??????
		ArrayList<HB_shopListDto> dtoList = dao.shopConditionList();
		
		int listCount = dtoList.size();
		
		for(int i = 0; i < listCount; i++) {
			
			String[] qTxt = {Integer.toString(dtoList.get(i).getShop_number()), Integer.toString(dtoList.get(i).getEmployee_id()), 
					dtoList.get(i).getShop_name(), dtoList.get(i).getShop_address(), dtoList.get(i).getShop_telno()};
			
			Outer_Table.addRow(qTxt);
		}
		
		lblListCount.setText("??? " + listCount + "?????? ????????? ????????????.");
		
	}
	
	
	
	private void allShopTotalSales() {
		
		HB_shopListDto dto = null;
		
		HB_ShopSalesListDao dao = new HB_ShopSalesListDao();

		dto = dao.allShopTotalSales();
		lblTotalSales.setText("?????? ????????? ?????? ????????? ?????? ?????? ????????? " + dto.getShop_name() + "??????, ??? ???????????? " + dto.getOrder_saleprice() + "??? ?????????.");
		
		dto = dao.allShopTodaySales();
		lblTodaySales.setText("?????? ?????? ????????? ?????? ?????? ????????? " + dto.getShop_name() + "??????, ?????? ???????????? " + dto.getOrder_saleprice() + "??? ?????????.");
		
		
	}
	
	
	
	
	
	
	
	
	
}// End Line