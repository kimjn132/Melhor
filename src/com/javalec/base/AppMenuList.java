package com.javalec.base;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.dao.AppMenuDetailDao;
import com.javalec.dao.AppMenuListDao;
import com.javalec.dao.AppStoreLocationDao;
import com.javalec.dto.AppMenuDetailDto;
import com.javalec.dto.AppMenuListDto;
import com.javalec.util.Static_CustomerId;
import com.javalec.util.Static_StoreLocation;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMenuList extends JFrame {

	private JFrame frmMelhor;
	private JScrollPane scrollPane;
	private JTable Inner_Table;
	private final DefaultTableModel Outer_Table = new DefaultTableModel();
	private JLabel lblCustomerNickName;
	private JLabel lblhomebutton;
	private JLabel lblStoreLocatioin;
	private JButton btnCart;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMenuList window = new AppMenuList();
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
	public AppMenuList() {
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
		frmMelhor.setTitle("Melhor - 메뉴");
		frmMelhor.setBounds(100, 100, 300, 500);
		frmMelhor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMelhor.getContentPane().setLayout(null);
		frmMelhor.getContentPane().add(getScrollPane());
		frmMelhor.getContentPane().add(getLblCustomerNickName());
		frmMelhor.getContentPane().add(getLblhomebutton());
		frmMelhor.getContentPane().add(getLblStoreLocatioin());
		frmMelhor.getContentPane().add(getBtnCart());
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(20, 51, 262, 302);
			scrollPane.setColumnHeaderView(getInner_Table());
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
						int i = Inner_Table.getSelectedRow(); // 몇번째 줄 인지 알려줌
						String wkSequence = (String) Inner_Table.getValueAt(i, 0); // i번째 행의 0번째(Seqno) 값을 wkSequence에 넣어줌
						
						Static_CustomerId.setProduct_id(Integer.parseInt(wkSequence));
						
						AppMenuDetail.main(null);
						frmMelhor.setVisible(false);
						
//						AppMenuDetailDao dao2 = new AppMenuDetailDao(Integer.parseInt(wkSequence));
//						AppMenuDetailDto dtoList = dao2.tableClick();

					}

				}
			});
			Inner_Table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			Inner_Table.setModel(Outer_Table);
		}
		return Inner_Table;
	}

	private JLabel getLblCustomerNickName() {
		if (lblCustomerNickName == null) {
			lblCustomerNickName = new JLabel("New label");
			lblCustomerNickName.setText(Static_CustomerId.customer_nickname);

			lblCustomerNickName.setBounds(20, 28, 219, 16);
		}
		return lblCustomerNickName;
	}

	private JLabel getLblhomebutton() {
		if (lblhomebutton == null) {
			lblhomebutton = new JLabel("");
			lblhomebutton.addMouseListener(new MouseAdapter() {
				// ---------- home으로 이동
				@Override
				public void mouseClicked(MouseEvent e) {
					frmMelhor.setVisible(false);
					AppHome.main(null);
				}
			});
			lblhomebutton.setBounds(20, 416, 50, 50);

			// ---------- homebutton 이미지 추가

			ImageIcon icon = new ImageIcon(AppStoreLocation.class.getResource("/com/javalec/util/homebutton.png"));
			Image img = icon.getImage(); // ImageIcon을 Image로 변환.
			Image updateImg = img.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
			ImageIcon updateIcon = new ImageIcon(updateImg);

			lblhomebutton.setIcon(updateIcon);
		}
		return lblhomebutton;
	}

	private JLabel getLblStoreLocatioin() {
		if (lblStoreLocatioin == null) {
			lblStoreLocatioin = new JLabel("New label");
			AppStoreLocationDao dao = new AppStoreLocationDao(getName().toString());
			lblStoreLocatioin.setText(Static_StoreLocation.shop_name);
			lblStoreLocatioin.setBounds(210, 23, 61, 16);
		}
		return lblStoreLocatioin;
	}

	// function------

	public void tableInit() {

		Outer_Table.addColumn("순서");
		Outer_Table.addColumn("제품");
		Outer_Table.addColumn("가격");

		Outer_Table.setColumnCount(3);

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
		width = 100;
		col.setPreferredWidth(width);

		vColIndex = 2;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 80;
		col.setPreferredWidth(width);

	}

	// DB to Table db에서 테이블로 정보 가져오기
	private void searchAction() {
		// Dao연결
		AppMenuListDao dao = new AppMenuListDao(); // 연결
		ArrayList<AppMenuListDto> dtoList = dao.menuList(); // 타입 = 실행 메소드 4. arraylist 형식으로 가져와서, 해당 Dao method 실행

		int listCount = dtoList.size(); // 데이터의 열의 수를 나타냄

		for (int index = 0; index < listCount; index++) {
			String id = Integer.toString(dtoList.get(index).getProduct_id()); // temp: seqno 할당
			String price = Integer.toString(dtoList.get(index).getProduct_price());
			String[] qTxt = { id, dtoList.get(index).getProduct_name(), price }; // 1행의 박스 할당
			Outer_Table.addRow(qTxt); // 출력
		}

	}

	// table Click
	private void tableClick() {

		int i = Inner_Table.getSelectedRow(); // 몇번째 줄 인지 알려줌
		String wkSequence = (String) Inner_Table.getValueAt(i, 0); // i번째 행의 0번째(Seqno) 값을 wkSequence에 넣어줌
//		AppMenuListDao dao = new AppMenuListDao(Integer.parseInt(wkSequence));
		
		
//			AppMenuListDto dto = dao.tableClick();

//			AppMenuDetailDto dto = new AppMenuDetailDto();

//		AppMenuDetail detail = new AppMenuDetail();
//		detail.productOrderList(Integer.parseInt(wkSequence));
//		detail.main(null);
//		frmMelhor.setVisible(false);

	}

	private JButton getBtnCart() {
		if (btnCart == null) {
			btnCart = new JButton("장바구니");
			btnCart.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					frmMelhor.setVisible(false);
					AppCart.main(null);
				}
			});
			btnCart.setBounds(165, 437, 117, 29);
		}
		return btnCart;
	}
}
