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
import java.io.File;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
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

import com.javalec.dao.HB_BestProductListDao;
import com.javalec.dto.HB_BestProductListDto;
import com.javalec.util.HB_Static;

public class HB_BestProductList {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JLabel lblSalesStatus;
	private JLabel lblStaffList;
	private JScrollPane scrollPane;
	private JTable Inner_Table;
	private final DefaultTableModel Outer_Table = new DefaultTableModel();
	private JLabel lblBestProductTotalNumber;
	private JLabel lblNewLabel_1_1_2;
	private JComboBox cbBestProduct;
	private JTextField tfBestProduct;
	private JButton btnNewButton;
	private JLabel lblManagerList;
	private JLabel lblManagerInsert;
	private JLabel lblBestProductList;
	private JLabel lblStoreInsert;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HB_BestProductList window = new HB_BestProductList();
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
	public HB_BestProductList() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("인기메뉴 리스트");
		frame.addWindowListener(new WindowAdapter() {

			@Override
			public void windowOpened(WindowEvent e) {
				
				bestProductTableInit();
				bestProductSearchAction();
			
			}
			@Override
			public void windowClosing(WindowEvent e) {
				closingAction();       	// <--***************************************************
			}
		});
		frame.setBounds(100, 100, 697, 541);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getBtnNewButton_1());
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getLblSalesStatus());
		frame.getContentPane().add(getLblStaffList());
		frame.getContentPane().add(getScrollPane());
		frame.getContentPane().add(getLblBestProductTotalNumber());
		frame.getContentPane().add(getLblNewLabel_1_1_2());
		frame.getContentPane().add(getCbBestProduct());
		frame.getContentPane().add(getTfBestProduct());
		frame.getContentPane().add(getBtnNewButton());
		frame.getContentPane().add(getLblManagerList());
		frame.getContentPane().add(getLblManagerInsert());
		frame.getContentPane().add(getLblBestProductList());
		frame.getContentPane().add(getLblStoreInsert());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("MelHor Coffee");
			lblNewLabel.setBackground(new Color(235, 199, 189));
			lblNewLabel.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 19));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(0, 0, 683, 69);
			lblNewLabel.setOpaque(true);
		}
		return lblNewLabel;
	}
	private JLabel getLblBestProductTotalNumber() {
		if (lblBestProductTotalNumber == null) {
			lblBestProductTotalNumber = new JLabel("인기메뉴 개수");
			lblBestProductTotalNumber.setBounds(520, 479, 163, 25);
		}
		return lblBestProductTotalNumber;
	}
	
	private JComboBox getCbBestProduct() {
		if (cbBestProduct == null) {
			cbBestProduct = new JComboBox();
			cbBestProduct.setModel(new DefaultComboBoxModel(new String[] {"메뉴"}));
			cbBestProduct.setBounds(115, 69, 125, 39);
		}
		return cbBestProduct;
	}
	private JTextField getTfBestProduct() {
		if (tfBestProduct == null) {
			tfBestProduct = new JTextField();
			tfBestProduct.setBounds(241, 69, 346, 39);
			tfBestProduct.setColumns(10);
		}
		return tfBestProduct;
	}
	private JLabel getLblSalesStatus() {
		if (lblSalesStatus == null) {
			lblSalesStatus = new JLabel("지점 리스트");
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
			lblStaffList = new JLabel("알바생 리스트");
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
	
	private JLabel getLblNewLabel_1_1_2() {
		if (lblNewLabel_1_1_2 == null) {
			lblNewLabel_1_1_2 = new JLabel("고객 만족도");
			lblNewLabel_1_1_2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
				}
			});
			lblNewLabel_1_1_2.setOpaque(true);
			lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_1_2.setForeground(Color.BLACK);
			lblNewLabel_1_1_2.setBackground(new Color(227, 147, 132));
			lblNewLabel_1_1_2.setBounds(0, 147, 114, 39);
		}
		return lblNewLabel_1_1_2;
	}
	private JLabel getLblManagerList() {
		if (lblManagerList == null) {
			lblManagerList = new JLabel("점장 리스트");
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
			lblManagerInsert = new JLabel("점장 등록");
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
			lblManagerInsert.setBounds(0, 225, 114, 39);
		}
		return lblManagerInsert;
	}
	private JLabel getLblBestProductList() {
		if (lblBestProductList == null) {
			lblBestProductList = new JLabel("인기메뉴 리스트");
			lblBestProductList.setOpaque(true);
			lblBestProductList.setHorizontalAlignment(SwingConstants.CENTER);
			lblBestProductList.setBackground(new Color(235, 199, 189));
			lblBestProductList.setBounds(0, 264, 114, 39);
		}
		return lblBestProductList;
	}
	
	private JLabel getLblStoreInsert() {
		if (lblStoreInsert == null) {
			lblStoreInsert = new JLabel("지점 등록");
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
			lblStoreInsert.setBounds(0, 303, 114, 39);
		}
		return lblStoreInsert;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(115, 106, 568, 372);
			scrollPane.setViewportView(getInner_Table());
		}
		return scrollPane;
	}
	
	// --------------------------------- Action Listener -------------------------------------------
	
	private JTable getInner_Table() {
		if (Inner_Table == null) {
			Inner_Table = new JTable() {
				public Class getColumnClass(int column) { 				// <--****************
			        return (column == 0) ? Icon.class : Object.class; 	// <--****************
			      }
			};
			Inner_Table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			Inner_Table.setModel(Outer_Table);  // <--***************************************************
			Inner_Table.setRowHeight(75); 		// <--***************************************************
		}
		return Inner_Table;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("로그아웃");
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
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("검색");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					bestProductTableInit();
					bestProductSearchAction();

				}
			});
			btnNewButton.setBounds(586, 69, 97, 39);
		}
		return btnNewButton;
	}
	
	// --------------------------------- Action Listener -------------------------------------------
	
	
	// ------------------------------------------------------------------------------
	
	private void bestProductTableInit() {
		
		Outer_Table.addColumn("메뉴 이미지");
		Outer_Table.addColumn("메뉴 이름");
		Outer_Table.addColumn("메뉴 가격");
		Outer_Table.addColumn("금일 총 판매량");
		
		Outer_Table.setColumnCount(4);
		
		int i = Outer_Table.getRowCount();
		
		for(int j = 0; j < i; j++) {
			Outer_Table.removeRow(0);
		}
		
			Inner_Table.setAutoResizeMode(Inner_Table.AUTO_RESIZE_OFF);
			
			int vColIndex = 0;
			TableColumn col = Inner_Table.getColumnModel().getColumn(vColIndex);
			int width = 100;
			col.setPreferredWidth(width);
	
			vColIndex = 1;
			col = Inner_Table.getColumnModel().getColumn(vColIndex);
			width = 141;
			col.setPreferredWidth(width);
	
			vColIndex = 2;
			col = Inner_Table.getColumnModel().getColumn(vColIndex);
			width = 141;
			col.setPreferredWidth(width);
	
			vColIndex = 3;
			col = Inner_Table.getColumnModel().getColumn(vColIndex);
			width = 141;
			col.setPreferredWidth(width);
			
	}
	
	ArrayList<HB_BestProductListDto> dtoList = null;
	
	
	// 총 인기메뉴 리스트 출력 메소드
	public void bestProductSearchAction() {
		/*
		 * 콤보 박스에서 SelectedItem으로 가져온 값을 result 값으로 변환하여 MySQL like문 작성
		 */

		String result = "";
		if ((String) cbBestProduct.getSelectedItem() == "메뉴") {
			result = "p.product_name"; // employee Table 컬럼명

		}

		String bestProduct = tfBestProduct.getText();

		HB_BestProductListDao dao = new HB_BestProductListDao(result, bestProduct); // 콤보박스, 텍스트필드 값 Dao로 전달
		dtoList = dao.bestProductConditionList();

		int listCount = dtoList.size();

		for (int i = 0; i < listCount; i++) {
			
			ImageIcon icon = new ImageIcon("./"+dtoList.get(i).getImage());
			
			Object[] qTxt = {icon, dtoList.get(i).getProduct_name(), Integer.toString(dtoList.get(i).getProduct_price()),
							Integer.toString(dtoList.get(i).getOrder_quantity()) };
			Outer_Table.addRow(qTxt);
		}
		
		// 총 인기메뉴 리스트 개수를 listCount의 개수로 출력
		lblBestProductTotalNumber.setText("인기메뉴 총 개수: " + Integer.toString(listCount) + "개");

	}
	
	
	private void closingAction() {

		for (int index = 0; index < dtoList.size(); index++) {
			File file = new File("./" + dtoList.get(index).getImage());
			file.delete();

		}

	}
	
} // End Line
