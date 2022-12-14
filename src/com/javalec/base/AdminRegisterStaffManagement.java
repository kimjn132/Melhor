package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.dao.AdminRegisterStaffManagementDao;
import com.javalec.dao.AdminStaffDetailDao;
import com.javalec.dto.AdminRegisterStaffManagementDto;
import com.javalec.util.StaticClass;

import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

public class AdminRegisterStaffManagement extends JFrame {

	private JFrame frame;
	private JLabel lblEm;
	private JLabel lblArrow;
	private JLabel lblNewLabel_1_1_5;
	private JLabel lblNewLabel;
	private JLabel lblStore;
	private JButton btnMyPage;
	private JComboBox cbCategory;
	private JTextField textField;
	private JScrollPane scrollPane_1;
	private JButton btnSearch;
	private JLabel lblNewLabel_1_2;
	private JButton btnGoToHome;

	// ******************* Table definition ************************************
	private final DefaultTableModel Outer_Table = new DefaultTableModel();
	private JTable Inner_Table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminRegisterStaffManagement window = new AdminRegisterStaffManagement();
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
	public AdminRegisterStaffManagement() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(247, 243, 243));
		frame.addWindowListener(new WindowAdapter() {
			// **************** ????????? ????????? (????????? ??????) ********************
			@Override
			public void windowActivated(WindowEvent e) {
				tableInit();
				searchAction();
			}
		});
		frame.setTitle("????????? ??????");
		frame.setBounds(100, 100, 600, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblEm());
		frame.getContentPane().add(getLblStore());
		frame.getContentPane().add(getBtnGoToHome());
		frame.getContentPane().add(getBtnMyPage());
		frame.getContentPane().add(getLblArrow());
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getLblNewLabel_1_1_5());
		frame.getContentPane().add(getCbCategory());
		frame.getContentPane().add(getTextField());
		frame.getContentPane().add(getScrollPane_1());
		frame.getContentPane().add(getBtnSearch());
		frame.getContentPane().add(getLblNewLabel_1_2());
	}

	private JLabel getLblEm() {
		if (lblEm == null) {
			lblEm = new JLabel("null???");
			lblEm.setForeground(new Color(60, 143, 96));
			lblEm.setFont(new Font("??????", Font.PLAIN, 15));
			lblEm.setBounds(43, 10, 81, 22);
			lblEm.setText(StaticClass.employee_name + "???");
		}
		return lblEm;
	}

	private JLabel getLblArrow() {
		if (lblArrow == null) {
			lblArrow = new JLabel("");
			lblArrow.addMouseListener(new MouseAdapter() {
				// ?????? ?????? ?????? ?????? ?????????
				@Override
				public void mouseClicked(MouseEvent e) {
					frame.setVisible(false);
					AdminStaffMenu.main(null);
				}
			});
			lblArrow.setBounds(10, 3, 35, 35);

			ImageIcon icon = new ImageIcon(
					AdminRegisterStaffManagement.class.getResource("/com/javalec/image/leftarrow.png"));
			Image img = icon.getImage(); // ImageIcon??? Image??? ??????.
			Image updateImg = img.getScaledInstance(20, 15, java.awt.Image.SCALE_SMOOTH);
			ImageIcon updateIcon = new ImageIcon(updateImg);
			lblArrow.setIcon(updateIcon);
		}
		return lblArrow;
	}

	private JLabel getLblNewLabel_1_1_5() {
		if (lblNewLabel_1_1_5 == null) {
			lblNewLabel_1_1_5 = new JLabel("");
			lblNewLabel_1_1_5.setOpaque(true);
			lblNewLabel_1_1_5.setForeground(new Color(255, 204, 204));
			lblNewLabel_1_1_5.setBackground(new Color(235, 199, 189));
			lblNewLabel_1_1_5.setBounds(0, 0, 586, 40);
		}
		return lblNewLabel_1_1_5;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Melhor Coffee");
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("??????", Font.BOLD | Font.ITALIC, 18));
			lblNewLabel.setBounds(169, 10, 142, 23);
		}
		return lblNewLabel;
	}

	private JLabel getLblStore() {
		if (lblStore == null) {
			lblStore = new JLabel((String) null);
			lblStore.setForeground(new Color(60, 143, 96));
			lblStore.setFont(new Font("??????", Font.PLAIN, 15));
			lblStore.setBounds(336, 10, 50, 23);
			lblStore.setText(StaticClass.shop_name);
		}
		return lblStore;
	}

	private JButton getBtnMyPage() {
		if (btnMyPage == null) {
			btnMyPage = new JButton("My Page");
			btnMyPage.setBounds(483, 10, 91, 23);
		}
		return btnMyPage;
	}

	private JComboBox getCbCategory() {
		if (cbCategory == null) {
			cbCategory = new JComboBox();
			cbCategory.setModel(new DefaultComboBoxModel(new String[] {"??????", "????????????", "??????", "?????????"}));
			cbCategory.setBounds(32, 60, 85, 30);
		}
		return cbCategory;
	}

	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setColumns(10);
			textField.setBounds(156, 62, 300, 27);
		}
		return textField;
	}

	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(32, 98, 522, 251);
			scrollPane_1.setViewportView(getInner_Table());
		}
		return scrollPane_1;
	}

	private JButton getBtnSearch() {
		if (btnSearch == null) {
			btnSearch = new JButton("??????");
			btnSearch.setBounds(494, 60, 60, 30);
		}
		return btnSearch;
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

	private JButton getBtnGoToHome() {
		if (btnGoToHome == null) {
			btnGoToHome = new JButton("??????????????? ??????");
			btnGoToHome.setBounds(445, 382, 129, 23);
		}
		return btnGoToHome;
	}

	private JTable getInner_Table() {
		if (Inner_Table == null) {
			Inner_Table = new JTable();
			//********************????????? ?????? ?????????*******************
			Inner_Table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (e.getButton() == 1) {
						staffId();
						frame.setVisible(false);
						AdminStaffDetail.main(null);
					}
				}
			});
			// **************************** ????????? ?????? **************************
			Inner_Table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			Inner_Table.setModel(Outer_Table);
		}
		return Inner_Table;
	}

	// ==================================?????????==============================================
	// 1. ????????? ????????? tableInit() ------------
	private void tableInit() {
		// each column ??????
		Outer_Table.addColumn("?????? ??????"); // 1
		Outer_Table.addColumn("??????"); // 2
		Outer_Table.addColumn("?????????");// 3

		Outer_Table.setColumnCount(3);

		// ?????? ????????? ??? ?????????
		int i = Outer_Table.getRowCount();
		for (int j = 0; j < i; j++) {
			Outer_Table.removeRow(0); // ??? 0??????? ArrayList??????...
		}

		// ?????? ????????? ????????? ?????? width ???????????? ?????? ????????? ??????. (autoresizemode??? off)
		Inner_Table.setAutoResizeMode(Inner_Table.AUTO_RESIZE_OFF);

		// ?????? ?????? ??? ????????? ??????
		int vColIndex = 0;
		TableColumn col = Inner_Table.getColumnModel().getColumn(vColIndex);
		int width = 100;
		col.setPreferredWidth(width);

		vColIndex = 1;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 100;
		col.setPreferredWidth(width);

		vColIndex = 2;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 150;
		col.setPreferredWidth(width);

	}

	// 2. DB to Table db?????? ???????????? ?????? ???????????? searchAction()--------------
	// Dao??? selectList ????????? ???????????? arrayList??? ?????? ???, dtoList??? ??????
	private void searchAction() {

		AdminRegisterStaffManagementDao dao = new AdminRegisterStaffManagementDao(); // ??????
		ArrayList<AdminRegisterStaffManagementDto> dtoList = dao.selectList();
		// Dao??? selectList ????????? ???????????? arrayList??? ?????? ???, dtoList??? ??????

		int listCount = dtoList.size(); // ???????????? ?????? ?????? ?????????

		// ?????? ????????? ?????? ????????? ?????? ??????
		for (int index = 0; index < listCount; index++) {
			String temp = Integer.toString(dtoList.get(index).getId()); // temp: seqno ??????
			String[] qTxt = { temp, dtoList.get(index).getName(), dtoList.get(index).getInDate() }; // 1?????? ?????? ??????
			Outer_Table.addRow(qTxt); // ??????
		}

	}
	
	private void staffId() {

		// getSelectedRow: ?????????(?????????) row??? ???????????? ??????
		// ????????? ??????????????? ?????? ???(row)??? ?????? (primary key) ????????????
		int i = Inner_Table.getSelectedRow(); 

		//getValueAt(int row, int column): DB?????? ?????? row??? colum??? cell?????? ?????? 
		// i ???(row)??? ????????????, 0??? primary key(??????)??? ?????? ????????? 0???
		String wkStaffId = (String) Inner_Table.getValueAt(i, 0);

		StaticClass.staff_id = Integer.parseInt(wkStaffId);
		System.out.println("staffId: " + wkStaffId);
	}

	
	
	
	
	
	
	
	
	
	
	
	

}// END
