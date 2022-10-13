package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.dao.AppCartDao;
import com.javalec.dao.AppMenuDetailDao;
import com.javalec.dao.AppStoreLocationDao;
import com.javalec.dto.AppCartDto;
import com.javalec.dto.AppStoreLocationDto;
import com.javalec.util.Static_CustomerId;
import com.javalec.util.Static_StoreLocation;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class AppCart {

	private JFrame frame;
	private JLabel lblSetLocation;
	private JButton btnChangeLoca;
	private JScrollPane scrollPane;
	private JTable Inner_Table;
	private final DefaultTableModel Outer_Table = new DefaultTableModel();
	private JLabel lblnew;
	private JLabel lblResultPrice;
	private JButton btnPay;
	private JButton btnDelete;
	private JButton btnAdd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppCart window = new AppCart();
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
	public AppCart() {
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
				searchAction();
			}
		});
		frame.setTitle("장바구니");
		frame.setBounds(100, 100, 300, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblSetLocation());
		frame.getContentPane().add(getBtnChangeLoca());
		frame.getContentPane().add(getScrollPane());
		frame.getContentPane().add(getLblnew());
		frame.getContentPane().add(getLblResultPrice());
		frame.getContentPane().add(getBtnPay());
		frame.getContentPane().add(getBtnDelete());
		frame.getContentPane().add(getBtnAdd());
	}

	private JLabel getLblSetLocation() {
		if (lblSetLocation == null) {
			lblSetLocation = new JLabel("New label");
			// 지점변경버튼 누르면 다시 AppStoreLocation 페이지로 이동 후 변경된 지점 이름 띄우기
			AppStoreLocationDao dao = new AppStoreLocationDao();
			lblSetLocation.setText(Static_StoreLocation.shop_name);
			lblSetLocation.setBounds(29, 33, 92, 38);
		}
		return lblSetLocation;
	}

	private JButton getBtnChangeLoca() {
		if (btnChangeLoca == null) {
			btnChangeLoca = new JButton("지점 변경");
			btnChangeLoca.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.setVisible(false);
					AppStoreLocation.main(null);
				}
			});
			btnChangeLoca.setBounds(162, 39, 117, 29);
		}
		return btnChangeLoca;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(29, 101, 240, 240);
			scrollPane.setColumnHeaderView(getInner_Table());
		}
		return scrollPane;
	}

	private JTable getInner_Table() {
		if (Inner_Table == null) {
			Inner_Table = new JTable();
			Inner_Table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			Inner_Table.setModel(Outer_Table);
		}
		return Inner_Table;
	}

	private JLabel getLblnew() {
		if (lblnew == null) {
			lblnew = new JLabel("총 결제가격: ");
			lblnew.setBounds(29, 353, 79, 16);
		}
		return lblnew;
	}

	private JLabel getLblResultPrice() {
		if (lblResultPrice == null) {
			lblResultPrice = new JLabel("New label");

			lblResultPrice.setBounds(208, 353, 61, 16);
		}
		return lblResultPrice;
	}

	private JButton getBtnPay() {
		if (btnPay == null) {
			btnPay = new JButton("주문하기");
			btnPay.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					frame.setVisible(false);
					AppOrderListCheck.main(null);
				}
			});
			btnPay.setBounds(162, 437, 117, 29);
		}
		return btnPay;
	}

	private JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("삭제하기");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					deleteAction();
					tableInit();
					searchAction();
				}
			});
			btnDelete.setBounds(162, 396, 117, 29);
		}
		return btnDelete;
	}

	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("제품추가");
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.setVisible(false);
					AppMenuList.main(null);
				}
			});
			btnAdd.setBounds(16, 437, 117, 29);
		}
		return btnAdd;
	}

	// function----------

	// 테이블 칼럼 만들기
	public void tableInit() {
		// 테이블 칼럼 이름

//		Outer_Table.addColumn("번호");
		Outer_Table.addColumn("제품명");
		Outer_Table.addColumn("가격");
		Outer_Table.addColumn("수량");
		// 테이블 칼럼 수
		Outer_Table.setColumnCount(4);

		int i = Outer_Table.getRowCount();

		for (int j = 0; j < i; j++) {
			Outer_Table.removeRow(0);
		}

		Inner_Table.setAutoResizeMode(Inner_Table.AUTO_RESIZE_OFF);

		int vColIndex = 0;
		TableColumn col = Inner_Table.getColumnModel().getColumn(vColIndex);
		int width = 0;
		col.setPreferredWidth(width);

		vColIndex = 1;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 100;
		col.setPreferredWidth(width);

		vColIndex = 2;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 80;
		col.setPreferredWidth(width);

		vColIndex = 3;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 80;
		col.setPreferredWidth(width);

	}

	// DB to Table db에서 cart 테이블 정보 가져오기
	private void searchAction() {
		// Dao연결
		AppCartDao dao = new AppCartDao(); // 연결
		ArrayList<AppCartDto> dtoList = dao.cartList(); // 타입 = 실행 메소드 4. arraylist 형식으로 가져와서, 해당 Dao method 실행

		int listCount = dtoList.size(); // 데이터의 열의 수를 나타냄
		int result = 0;
		// 위의 데이터 행의 수만큼 정보 출력
		for (int index = 0; index < listCount; index++) {
			String temp = Integer.toString(dtoList.get(index).getCart_id()); // temp: seqno 할당
			String temp2 = Integer.toString(dtoList.get(index).getProduct_price());
			String temp3 = Integer.toString(dtoList.get(index).getCart_product_quantity());
			int price = Integer.parseInt(temp2);
			int quantity = Integer.parseInt(temp3);

			String[] qTxt = {temp, dtoList.get(index).getProduct_name(), temp2, temp3 }; // 1행의 박스 할당
			int[] qTxt1 = { price };
			Outer_Table.addRow(qTxt); // 출력
			result += (price * quantity);

		}
		lblResultPrice.setText(Integer.toString(result));

	}

	private void deleteAction() {

		int i = Inner_Table.getSelectedRow(); // 출력 원하는 정보 클릭 메소드

		// DB에서 해당 행의 번호 (primary key) 가져오기
		String wkCartId = (String) Inner_Table.getValueAt(i, 0); // i 행 을 가져오고, 0은 primary key(순서)만 알면 되니까 0번
		AppCartDao dao = new AppCartDao(Integer.parseInt(wkCartId));

		
		Boolean ok = dao.deleteAction(); // 리턴값
		

	}

}
