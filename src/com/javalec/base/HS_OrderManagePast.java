package com.javalec.base;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.dao.HS_OrderManageDao;
import com.javalec.dao.HS_OrderManagePastDao;
import com.javalec.dto.HS_OrderManageDto;
import com.javalec.dto.HS_OrderManagePastDto;

import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HS_OrderManagePast {

	private JFrame frame;
	private JScrollPane scrollPane;
	private JTable Inner_Table;
	private final DefaultTableModel Outer_Table = new DefaultTableModel();
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HS_OrderManagePast window = new HS_OrderManagePast();
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
	public HS_OrderManagePast() {
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
				tableInit();
				conditionQueryAction();

			}
		});
		frame.setTitle("이전 주문 내역");
		frame.getContentPane().setBackground(new Color(227, 147, 132));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getScrollPane());
		frame.getContentPane().add(getBtnNewButton());
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 21, 412, 198);
			scrollPane.setViewportView(getInner_Table());
		}
		return scrollPane;
	}

	private JTable getInner_Table() {
		if (Inner_Table == null) {
			Inner_Table = new JTable();

			Inner_Table.setModel(Outer_Table);
		}
		return Inner_Table;
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("주문 관리로 돌아가기");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					frame.setVisible(false);
					HS_OrderManage.main(null);

				}
			});
			btnNewButton.setBounds(110, 229, 213, 23);
		}
		return btnNewButton;
	}

	// ------------------------------------function----------------------------

	public void tableInit() {

		Outer_Table.addColumn("주문번호");
		Outer_Table.addColumn("고객id");
		Outer_Table.addColumn("메뉴명");
		Outer_Table.addColumn("수량");
		Outer_Table.addColumn("주문시간");

		Outer_Table.setColumnCount(5);

		int i = Outer_Table.getRowCount();

		for (int j = 0; j < i; j++) {
			Outer_Table.removeRow(0);
		}

		Inner_Table.setAutoResizeMode(Inner_Table.AUTO_RESIZE_OFF);

		int vColIndex = 0;
		TableColumn col = Inner_Table.getColumnModel().getColumn(vColIndex);
		int width = 40;
		col.setPreferredWidth(width);

		vColIndex = 1;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 50;
		col.setPreferredWidth(width);

		vColIndex = 2;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 137;
		col.setPreferredWidth(width);

		vColIndex = 3;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 40;
		col.setPreferredWidth(width);

		vColIndex = 4;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 120;
		col.setPreferredWidth(width);

	}

	public void conditionQueryAction() {

		HS_OrderManagePastDao dao = new HS_OrderManagePastDao();

		ArrayList<HS_OrderManagePastDto> dtoList = dao.orderPastConditionList();

		int listCount = dtoList.size();

		for (int i = 0; i < listCount; i++) {

			String[] qTxt = { Integer.toString(dtoList.get(i).getOrder_id()), dtoList.get(i).getCustomer_id(),
					dtoList.get(i).getProduct_name(), Integer.toString(dtoList.get(i).getOrder_quantity()),
					dtoList.get(i).getOrder_time() };

			Outer_Table.addRow(qTxt);

		}

	}

}// end
