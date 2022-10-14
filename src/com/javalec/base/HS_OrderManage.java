package com.javalec.base;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.dao.HS_OrderManageDao;
import com.javalec.dto.HS_OrderManageDto;
import com.javalec.util.DBConnect;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class HS_OrderManage {

	private JFrame frame;
	private JScrollPane scrollPane;
	private JTable Inner_Table;
	private final DefaultTableModel Outer_Table = new DefaultTableModel();
	private JButton btnBackpage;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HS_OrderManage window = new HS_OrderManage();
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
	public HS_OrderManage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("주문 관리");
		frame.getContentPane().setBackground(new Color(227, 147, 132));
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {

				tableInit();
				conditionQueryAction();

			}
		});
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getScrollPane());
		frame.getContentPane().add(getBtnBackpage());
		frame.getContentPane().add(getBtnNewButton());
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 31, 412, 149);
			scrollPane.setViewportView(getInner_Table());
		}
		return scrollPane;
	}
	
	
	// ------------------------------------Action Listener------------------------------------

	private JButton getBtnBackpage() {
		if (btnBackpage == null) {
			btnBackpage = new JButton("전체 메뉴로 돌아가기");
			btnBackpage.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					frame.setVisible(false);// 창 종료
					HS_StaffMenu.main(null);// 전체메뉴 창 열기
				}
			});
			btnBackpage.setFont(new Font("HY엽서M", Font.PLAIN, 15));
			btnBackpage.setBounds(12, 212, 190, 20);
		}
		return btnBackpage;
	}

	
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("이전 주문내역");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
					frame.setVisible(false);
					HS_OrderManagePast.main(null);
					
					
				}
			});
			btnNewButton.setBounds(265, 211, 159, 23);
		}
		return btnNewButton;
	}
	
	private JTable getInner_Table() {
		if (Inner_Table == null) {
			Inner_Table = new JTable();
			Inner_Table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					if (e.getButton() == 1) {
						tableClick();
					}
					
				}
			});
			Inner_Table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			Inner_Table.setModel(Outer_Table);
			
		}
		return Inner_Table;
	}
	
	
	
	
	
	
	
	// ------------------------------------function------------------------------------
	public void tableInit() {

		Outer_Table.addColumn("주문번호");
		Outer_Table.addColumn("고객id");
		Outer_Table.addColumn("메뉴명");
		Outer_Table.addColumn("수량");

		Outer_Table.setColumnCount(4);

		int i = Outer_Table.getRowCount();

		for (int j = 0; j < i; j++) {
			Outer_Table.removeRow(0);
		}

		Inner_Table.setAutoResizeMode(Inner_Table.AUTO_RESIZE_OFF);

		int vColIndex = 0;
		TableColumn col = Inner_Table.getColumnModel().getColumn(vColIndex);
		int width = 77;
		col.setPreferredWidth(width);

		vColIndex = 1;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 96;
		col.setPreferredWidth(width);

		vColIndex = 2;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 137;
		col.setPreferredWidth(width);

		vColIndex = 3;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 98;
		col.setPreferredWidth(width);

	}

	public void conditionQueryAction() {

		HS_OrderManageDao dao = new HS_OrderManageDao();

		ArrayList<HS_OrderManageDto> dtoList = dao.orderConditionList();

		int listCount = dtoList.size();

		for (int i = 0; i < listCount; i++) {

			String[] qTxt = { Integer.toString(dtoList.get(i).getOrder_id()),
					Integer.toString(dtoList.get(i).getCustomer_id()), dtoList.get(i).getProduct_name(),
					Integer.toString(dtoList.get(i).getOrder_quantity()) };
			Outer_Table.addRow(qTxt);

		}

	}

	private void tableClick() {

		int i = Inner_Table.getSelectedRow(); // 몇번째 줄 인지 알려줌

		String wkSequence = (String) Inner_Table.getValueAt(i, 0); // i번째 행의 0번째(Seqno) 값을 wkSequence에 넣어줌
		// 주문번호 즉 order id

		String wkQuantity = (String) Inner_Table.getValueAt(i, 3);

		HS_OrderManageDao dao = new HS_OrderManageDao(Integer.parseInt(wkSequence), Integer.parseInt(wkQuantity));

		dao.orderManufact();

		int result = JOptionPane.showConfirmDialog(null, "제조하시겠습니까?", "Confirm", JOptionPane.YES_NO_OPTION);
		if (result == JOptionPane.CLOSED_OPTION) {
			// 사용자가 '예', '아니오'를 선택하지 않고 창을 닫았을 경우
		} else if (result == JOptionPane.YES_OPTION) {
			// 사용자가 '예'를 선택하였을 경우
			JOptionPane.showMessageDialog(null, "제조 시작");
			HS_OrderManage.main(null);
			frame.setVisible(false);
			
			HS_OrderManageDao hs_ordermanagedao = new HS_OrderManageDao();
			
			hs_ordermanagedao.removeOrderlist(Integer.parseInt(wkSequence));
			// stamp를 넣어준 removeOrderlist 메소드 실행

		} else {
			// 사용자가 '아니오'를 선택하였을 경우
			HS_OrderManage.main(null);

		}

	}

}// end
