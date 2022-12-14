package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.dao.AppCartDao;
import com.javalec.dao.AppLoginDao;
import com.javalec.dao.AppMenuDetailDao;
import com.javalec.dao.AppOrderListCheckDao;
import com.javalec.dao.AppStoreLocationDao;
import com.javalec.dto.AppCartDto;
import com.javalec.dto.AppOrderListCheckDto;
import com.javalec.dto.AppStoreLocationDto;
import com.javalec.util.Static_CustomerId;
import com.javalec.util.Static_StoreLocation;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppOrderListCheck {

	private JFrame frmMelhor;
	private JLabel lblShop;
	private JLabel lblCNickname;
	private JScrollPane scrollPane;
	private JTable Inner_Table;
	private JLabel lblNewLabel;
	private JTextField tfPayResult;
	private JButton btnPay;
	private JCheckBox chckbxNewCheckBox;
	private JLabel lblNewLabel_1;
	private final DefaultTableModel Outer_Table = new DefaultTableModel();
	private JLabel lblStoreLoca;
	private JLabel lblCustomerName;
	private JButton btnCancel;
	private JButton btnCartBack;
	private int count = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppOrderListCheck window = new AppOrderListCheck();
					window.frmMelhor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppOrderListCheck() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMelhor = new JFrame();
		frmMelhor.addWindowListener(new WindowAdapter() {

			@Override
			public void windowActivated(WindowEvent e) {
				tableInit();
				searchAction();
			}
		});
		frmMelhor.setTitle("Melhor-?????????");
		frmMelhor.setBounds(100, 100, 300, 500);
		frmMelhor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMelhor.getContentPane().setLayout(null);
		frmMelhor.getContentPane().add(getLblShop());
		frmMelhor.getContentPane().add(getLblCNickname());
		frmMelhor.getContentPane().add(getScrollPane());
		frmMelhor.getContentPane().add(getLblNewLabel());
		frmMelhor.getContentPane().add(getTfPayResult());
		frmMelhor.getContentPane().add(getBtnPay());
		frmMelhor.getContentPane().add(getChckbxNewCheckBox());
		frmMelhor.getContentPane().add(getLblNewLabel_1());
		frmMelhor.getContentPane().add(getLblStoreLoca());
		frmMelhor.getContentPane().add(getLblCustomerName());
		frmMelhor.getContentPane().add(getBtnCancel());
		frmMelhor.getContentPane().add(getBtnCartBack());
	}

	private JLabel getLblShop() {
		if (lblShop == null) {
			lblShop = new JLabel("?????????: ");
			lblShop.setBounds(26, 17, 41, 27);
		}
		return lblShop;
	}

	private JLabel getLblCNickname() {
		if (lblCNickname == null) {
			lblCNickname = new JLabel("????????????:");

			lblCNickname.setBounds(179, 17, 53, 27);
		}
		return lblCNickname;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(36, 56, 220, 150);
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
					if (e.getButton() == 1) {
//	         			tableInit();
//	         			searchAction();
					}

				}
			});
			Inner_Table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			Inner_Table.setModel(Outer_Table);
		}
		return Inner_Table;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("?????? ????????????");
			lblNewLabel.setBounds(52, 282, 88, 16);
		}
		return lblNewLabel;
	}

	private JTextField getTfPayResult() {
		if (tfPayResult == null) {
			tfPayResult = new JTextField();
			tfPayResult.setEditable(false);
			tfPayResult.setColumns(10);
			tfPayResult.setBounds(146, 277, 130, 26);
		}
		return tfPayResult;
	}

	private JButton getBtnPay() {
		if (btnPay == null) {
			btnPay = new JButton("?????? ????????????");
			btnPay.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					insertOrders();
					frmMelhor.setVisible(false);
					AppPayDone.main(null);
					deleteCart();
				}
			});
			btnPay.setBounds(160, 387, 117, 29);
		}
		return btnPay;
	}

	private JCheckBox getChckbxNewCheckBox() {
		if (chckbxNewCheckBox == null) {
			chckbxNewCheckBox = new JCheckBox("?????????????????????");
			chckbxNewCheckBox.setBounds(36, 227, 128, 23);
		}
		return chckbxNewCheckBox;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("???????????? ??????????????? ?????? ??????!");
			lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
			lblNewLabel_1.setBounds(154, 232, 123, 16);
		}
		return lblNewLabel_1;
	}

	private JLabel getLblStoreLoca() {
		if (lblStoreLoca == null) {
			lblStoreLoca = new JLabel("New label");
			AppStoreLocationDao dao = new AppStoreLocationDao();
			lblStoreLoca.setText(Static_StoreLocation.shop_name);
			lblStoreLoca.setBounds(79, 17, 88, 27);
		}
		return lblStoreLoca;
	}

	private JLabel getLblCustomerName() {
		if (lblCustomerName == null) {
			lblCustomerName = new JLabel("New label");
			AppLoginDao dao = new AppLoginDao();
			lblCustomerName.setText(Static_CustomerId.customer_nickname);
			lblCustomerName.setBounds(233, 22, 61, 16);
		}
		return lblCustomerName;
	}

	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("????????????");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					frmMelhor.setVisible(false);
					AppMenuList.main(null);
				}
			});
			btnCancel.setBounds(23, 387, 117, 29);
		}
		return btnCancel;
	}

	// function-------------------------

	// ????????? ?????? ?????????
	public void tableInit() {
		// ????????? ?????? ??????
		Outer_Table.addColumn("??????");
		Outer_Table.addColumn("?????????");
		Outer_Table.addColumn("??????");
		Outer_Table.addColumn("??????");
		// ????????? ?????? ???
		Outer_Table.setColumnCount(4);

		int i = Outer_Table.getRowCount();

		for (int j = 0; j < i; j++) {
			Outer_Table.removeRow(0);
		}

		Inner_Table.setAutoResizeMode(Inner_Table.AUTO_RESIZE_OFF);

		int vColIndex = 0;
		TableColumn col = Inner_Table.getColumnModel().getColumn(vColIndex);
		int width = 30;
		col.setPreferredWidth(width);

		vColIndex = 1;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 90;
		col.setPreferredWidth(width);

		vColIndex = 2;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 50;
		col.setPreferredWidth(width);

		vColIndex = 3;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 50;
		col.setPreferredWidth(width);

	}

	// DB to Table db?????? cart ????????? ?????? ???????????? ????????? ?????? ???????????? ??????
	private void searchAction() {
		// Dao??????
		AppOrderListCheckDao dao = new AppOrderListCheckDao(); // ??????
		ArrayList<AppOrderListCheckDto> dtoList = dao.cartList(); // ?????? = ?????? ????????? 4. arraylist ???????????? ????????????, ?????? Dao method
																	// ??????

		int listCount = dtoList.size(); // ???????????? ?????? ?????? ?????????
		int result = 0;
		// ?????? ????????? ?????? ????????? ?????? ??????
		for (int index = 0; index < listCount; index++) {
			String temp = Integer.toString(dtoList.get(index).getCart_id()); // temp: seqno ??????
			String temp2 = Integer.toString(dtoList.get(index).getProduct_price());
			String temp3 = Integer.toString(dtoList.get(index).getCart_product_quantity());
			int price = Integer.parseInt(temp2);
			int quantity = Integer.parseInt(temp3);

			String[] qTxt = { temp, dtoList.get(index).getProduct_name(), temp2, temp3 }; // 1?????? ?????? ??????
			int[] qTxt1 = { price };
			Outer_Table.addRow(qTxt); // ??????
			result += (price * quantity);

		}
		tfPayResult.setText(Integer.toString(result));
	}

	private JButton getBtnCartBack() {
		if (btnCartBack == null) {
			btnCartBack = new JButton("????????????");
			btnCartBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					frmMelhor.setVisible(false);
					AppCart.main(null);

				}
			});
			btnCartBack.setBounds(160, 346, 117, 29);
		}
		return btnCartBack;
	}

	
	
	// orders ???????????? ??????
	private void insertOrders() {

	
		int order_id = 1;
		int order_stamp = 1;
		int order_saleprice = 0;
		String order_payment = "??????";

		AppOrderListCheckDao dao = new AppOrderListCheckDao(Static_CustomerId.product_id, Static_CustomerId.customer_id,
				Static_StoreLocation.shop_number, order_id, order_saleprice, order_payment, order_stamp);

		int check = dao.insertOrder();
		System.out.println(check);

	}

	
	
	public void deleteCart() {

		AppOrderListCheckDao dao = new AppOrderListCheckDao(Static_CustomerId.customer_id,
				Static_StoreLocation.shop_number); // ??????

		Boolean ok = dao.deleteAction(); // ?????????

	}

}
