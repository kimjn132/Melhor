package com.javalec.base;
//package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.dao.AdminMenuInsertDao;
import com.javalec.dto.AdminMenuInsertDto;
import com.javalec.util.DBConnect;
import com.javalec.util.StaticClass;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class AdminMenuList extends JFrame {

	private JFrame frame;
	private JTable Inner_Table;
	private JTextField tfSearch;
	private JComboBox cbCategory;
	private JLabel lblGoHome;

	// ******************* Table definition ************************************
	private final DefaultTableModel Outer_Table = new DefaultTableModel();
	private JRadioButton rdBest;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnNewRadioButton_2;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminMenuList window = new AdminMenuList();
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
	public AdminMenuList() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("?????? ??????");
		frame.setBackground(Color.WHITE);
		frame.getContentPane().setBackground(new Color(247, 243, 243));
		frame.addWindowListener(new WindowAdapter() {
			// **************** ????????? ????????? (????????? ??????) ********************
			@Override
			public void windowActivated(WindowEvent e) {
				tableInit();
				searchAction();
			}
		});
		frame.setBounds(100, 100, 600, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblGoHome());
		frame.getContentPane().add(getScrollPane());

		JLabel lblStore = new JLabel("??????");
		lblStore.setForeground(new Color(60, 143, 96));
		lblStore.setFont(new Font("??????", Font.PLAIN, 15));
		lblStore.setBounds(340, 10, 50, 23);
		frame.getContentPane().add(lblStore);
		lblStore.setText(StaticClass.shop_name);

		JLabel lblArrow = new JLabel("");
		// ?????? ?????? ?????? ?????? ?????????
		lblArrow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminMenuManagement.main(null);
				frame.setVisible(false);
			}
		});
		lblArrow.setBounds(10, 3, 35, 35);
		ImageIcon icon = new ImageIcon(AdminMenuList.class.getResource("/com/javalec/image/leftarrow.png"));
		Image img = icon.getImage(); // ImageIcon??? Image??? ??????.
		Image updateImg = img.getScaledInstance(20, 15, java.awt.Image.SCALE_SMOOTH);
		ImageIcon updateIcon = new ImageIcon(updateImg);

		lblArrow.setIcon(updateIcon);
		frame.getContentPane().add(lblArrow);

		


		
		tfSearch = new JTextField();
		tfSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tfSearch.setText("");
			}
		});
		tfSearch.setBounds(156, 87, 300, 27);
		frame.getContentPane().add(tfSearch);
		tfSearch.setColumns(10);

		JButton btnSearch = new JButton("??????");
		// ******************************?????? ?????? ?????????***********************
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conditionQuery();
			}
		});
		btnSearch.setBounds(494, 85, 60, 30);
		frame.getContentPane().add(btnSearch);

		cbCategory = new JComboBox();
		cbCategory.setModel(new DefaultComboBoxModel(new String[] {"????????????", "?????????"}));
		cbCategory.setBounds(32, 85, 85, 30);
		frame.getContentPane().add(cbCategory);

		JLabel lblEm = new JLabel("null???");
		lblEm.setForeground(new Color(60, 143, 96));
		lblEm.setFont(new Font("??????", Font.PLAIN, 14));
		lblEm.setBounds(40, 10, 80, 20);
		frame.getContentPane().add(lblEm);
		lblEm.setText(StaticClass.employee_name + "???");

		JLabel lblNewLabel = new JLabel("Melhor Coffee");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("??????", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(200, 10, 140, 23);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1_1_5 = new JLabel("");
		lblNewLabel_1_1_5.setOpaque(true);
		lblNewLabel_1_1_5.setForeground(new Color(255, 204, 204));
		lblNewLabel_1_1_5.setBackground(new Color(235, 199, 189));
		lblNewLabel_1_1_5.setBounds(0, 0, 586, 40);
		frame.getContentPane().add(lblNewLabel_1_1_5);

		JLabel lblNewLabel_1_2 = new JLabel("");
		lblNewLabel_1_2.setOpaque(true);
		lblNewLabel_1_2.setForeground(new Color(255, 204, 204));
		lblNewLabel_1_2.setBackground(new Color(235, 199, 189));
		lblNewLabel_1_2.setBounds(0, 374, 586, 40);
		frame.getContentPane().add(lblNewLabel_1_2);
		frame.getContentPane().add(getRdBest());
		frame.getContentPane().add(getRdbtnNewRadioButton_1());
		frame.getContentPane().add(getRdbtnNewRadioButton_2());
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(32, 126, 522, 218);
			scrollPane.setViewportView(getInner_Table());
		}
		return scrollPane;
	}
	private JTable getInner_Table() {
		if (Inner_Table == null) {
			Inner_Table = new JTable();
			Inner_Table.setBackground(Color.WHITE);
			Inner_Table.addMouseListener(new MouseAdapter() {
				// ***********************????????? ?????? ?????????(????????? ?????????)******************
				@Override
				public void mouseClicked(MouseEvent e) {
					if (e.getButton() == 1) {
						// static?????? ?????? ????????? ????????????
						System.out.println("????????? ??????");
						productId();
						frame.setVisible(false);
						AdminMenuDetail.main(null);
					}
				}
			});
			scrollPane.setViewportView(Inner_Table);
			
			// **************************** ????????? ?????? **************************
			Inner_Table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			Inner_Table.setModel(Outer_Table);
		}
		return Inner_Table;
	}
	
	private JLabel getLblGoHome() {
		if (lblGoHome == null) {
			lblGoHome = new JLabel("");
			lblGoHome.addMouseListener(new MouseAdapter() {
				// ????????? ?????? ??????
				@Override
				public void mouseClicked(MouseEvent e) {
					frame.setVisible(false);
					AdminMainPage.main(null);
				}
			});
			lblGoHome.setBounds(545, 2, 35, 35);
			ImageIcon icon = new ImageIcon(AdminStaffDetail.class.getResource("/com/javalec/image/home.png"));
			Image img = icon.getImage(); // ImageIcon??? Image??? ??????.
			Image updateImg = img.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
			ImageIcon updateIcon = new ImageIcon(updateImg);

			lblGoHome.setIcon(updateIcon);
		}
		return lblGoHome;
	}

	private JRadioButton getRdBest() {
		if (rdBest == null) {
			rdBest = new JRadioButton("????????? (??????)");
			buttonGroup_1.add(rdBest);
			// ????????? ?????? ?????? 
			rdBest.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					tableInit();
					ascendingBest();
				}
			});
			rdBest.setBackground(new Color(247, 243, 243));
			rdBest.setBounds(233, 56, 121, 23);
		}
		return rdBest;
	}
	private JRadioButton getRdbtnNewRadioButton_1() {
		if (rdbtnNewRadioButton_1 == null) {
			rdbtnNewRadioButton_1 = new JRadioButton("????????? (??? ???)");
			// ??? ??? ????????? ??????
			rdbtnNewRadioButton_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					tableInit();
					monthBestAscending();
				}
			});
			buttonGroup_1.add(rdbtnNewRadioButton_1);
			rdbtnNewRadioButton_1.setBackground(new Color(247, 243, 243));
			rdbtnNewRadioButton_1.setBounds(106, 56, 109, 23);
		}
		return rdbtnNewRadioButton_1;
	}
	private JRadioButton getRdbtnNewRadioButton_2() {
		if (rdbtnNewRadioButton_2 == null) {
			rdbtnNewRadioButton_2 = new JRadioButton("??????");
			// ?????? ??????
			rdbtnNewRadioButton_2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					tableInit();
					searchAction();
				}
			});
			buttonGroup_1.add(rdbtnNewRadioButton_2);
			rdbtnNewRadioButton_2.setBackground(new Color(247, 243, 243));
			rdbtnNewRadioButton_2.setBounds(32, 56, 70, 23);
		}
		return rdbtnNewRadioButton_2;
	}
	// ===============================?????????========================================

	// -----------------------????????? ????????? tableInit-----------------------------
	private void tableInit() {
		// each column ??????
		Outer_Table.addColumn("?????? ??????"); // 1
		Outer_Table.addColumn("????????????"); // 2
		Outer_Table.addColumn("?????? ??????");// 3
		Outer_Table.addColumn("??????"); // 4

		Outer_Table.setColumnCount(4);

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
		width = 140;
		col.setPreferredWidth(width);

		vColIndex = 3;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 140;
		col.setPreferredWidth(width);

	}
	

	// --------------------- select * ???????????? ?????? searchAction()----------------------
	private void searchAction() {

		AdminMenuInsertDao adminMenuInsertDao = new AdminMenuInsertDao();
		ArrayList<AdminMenuInsertDto> dtoList = adminMenuInsertDao.selectList();
		// Dao??? selectList ????????? ???????????? arrayList??? ?????? ???, dtoList??? ??????

		int listCount = dtoList.size(); // ???????????? ?????? ?????? ?????????

		// ?????? ????????? ?????? ????????? ?????? ??????
		for (int index = 0; index < listCount; index++) {
			String temp = Integer.toString(dtoList.get(index).getProduct_id()); // temp: seqno ??????
			String[] qTxt = { temp, dtoList.get(index).getProduct_category(), dtoList.get(index).getProduct_name(),
					Integer.toString(dtoList.get(index).getProduct_price()) }; // 1?????? ?????? ??????
			Outer_Table.addRow(qTxt); // ??????
		}

	}

	// ????????? ???????????? ????????? ?????? %

	// ?????? ????????? ?????? ?????? ????????? ????????? ??????

	private void conditionQuery() {

		int i = cbCategory.getSelectedIndex();
		String conditionQueryColumn = "";

		switch (i) {
		case 0:
			conditionQueryColumn = "product_category";
			break;
		case 1:
			conditionQueryColumn = "product_name";
			break;
		default:
			break;
		}

		// 0?????????, ???????????? ??????????????? ???

		tableInit();
		conditionQueryAction(conditionQueryColumn); // ????????? 0?????? ?????? ?????? ?????? >> conditionQueryAction?????? ??????.

	}

	private void conditionQueryAction(String conditionQueryColumn) {

		AdminMenuInsertDao dao = new AdminMenuInsertDao(conditionQueryColumn, tfSearch.getText());
		ArrayList<AdminMenuInsertDto> dtoList = dao.conditionList();

		int listCount = dtoList.size(); // ???????????? ?????? ?????? ??????

		// ?????? ????????? ?????? ????????? ?????? ??????
		for (int index = 0; index < listCount; index++) {
			String temp = Integer.toString(dtoList.get(index).getProduct_id()); // ?????? ?????? ( seqno ??? ????????? ?????? ?????? ????????????)
			String[] qTxt = { temp, dtoList.get(index).getProduct_category(), dtoList.get(index).getProduct_name(),
					Integer.toString(dtoList.get(index).getProduct_price()) }; // 1?????? ?????? ???
			Outer_Table.addRow(qTxt);
		}

	}

	// Table Click
	private void productId() {
		
		int i = Inner_Table.getSelectedRow();

		String wkSequence = Inner_Table.getValueAt(i, 0).toString();

		StaticClass.product_id = Integer.parseInt(wkSequence);
		
	}
	
	// ???????????? ????????? ?????? ?????? ??? ?????? ????????? 
	
	// ????????? ?????? ????????? ?????? (??????)
	private void ascendingBest() {
		
		AdminMenuInsertDao dao = new AdminMenuInsertDao(); // ??????
		ArrayList<AdminMenuInsertDto> dtoList = dao.ascendingBest(); 
		// Dao??? selectList ????????? ???????????? arrayList??? ?????? ???, dtoList??? ??????
		
		int listCount = dtoList.size(); // ???????????? ?????? ?????? ?????????

		// ?????? ????????? ?????? ????????? ?????? ??????
		for (int index = 0; index < listCount; index++) {
			String temp = Integer.toString(dtoList.get(index).getProduct_id()); // temp: seqno ??????
			String[] qTxt = { temp, dtoList.get(index).getProduct_category(), dtoList.get(index).getProduct_name(),
					Integer.toString(dtoList.get(index).getProduct_price()) }; // 1?????? ?????? ??????
			Outer_Table.addRow(qTxt); // ??????
		}
		
	}
	
	// ????????? ?????? ????????? ?????? (??????)
	private void monthBestAscending() {
		
		AdminMenuInsertDao dao = new AdminMenuInsertDao(); // ??????
		ArrayList<AdminMenuInsertDto> dtoList = dao.monthBestAscending(); 
		// Dao??? selectList ????????? ???????????? arrayList??? ?????? ???, dtoList??? ??????
		
		int listCount = dtoList.size(); // ???????????? ?????? ?????? ?????????
		
		// ?????? ????????? ?????? ????????? ?????? ??????
		for (int index = 0; index < listCount; index++) {
			String temp = Integer.toString(dtoList.get(index).getProduct_id()); // temp: seqno ??????
			String[] qTxt = { temp, dtoList.get(index).getProduct_category(), dtoList.get(index).getProduct_name(),
					Integer.toString(dtoList.get(index).getProduct_price()) }; // 1?????? ?????? ??????
			Outer_Table.addRow(qTxt); // ??????
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
} // END
