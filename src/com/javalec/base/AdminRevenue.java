package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.dao.AdminRevenueDao;
import com.javalec.dto.AdminRevenueDto;
import com.javalec.util.StaticClass;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class AdminRevenue extends JFrame {

	private JFrame frame;
	private JComboBox cbCategory;
	private JScrollPane scrollPane;
	private JTextField tfSearch;
	private JButton btnSearch;
	private JTable Inner_Table;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnNewRadioButton_2;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	// ******************* Table definition ************************************
	private final DefaultTableModel Outer_Table = new DefaultTableModel();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JComboBox cbPeriod;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminRevenue window = new AdminRevenue();
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
	public AdminRevenue() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			// 윈도우 이벤트 + 테이블 세팅 *************************************
			@Override
			public void windowActivated(WindowEvent e) {
				tableInit();
				monthDayAvg();
			}
		});
		frame.getContentPane().setBackground(new Color(247, 243, 243));
		frame.setTitle("매출 현황");
		frame.setBounds(100, 100, 600, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnMyPage = new JButton("My Page");
		btnMyPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				AdminMyPage.main(null);
			}
		});
		btnMyPage.setBounds(483, 9, 91, 23);
		frame.getContentPane().add(btnMyPage);

		JLabel lblStore = new JLabel("지점");
		lblStore.setForeground(new Color(60, 143, 96));
		lblStore.setFont(new Font("굴림", Font.PLAIN, 15));
		lblStore.setBounds(326, 9, 50, 23);
		frame.getContentPane().add(lblStore);
		lblStore.setText(StaticClass.shop_name);

		JLabel lblNewLabel = new JLabel("Melhor Coffee");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(186, 10, 142, 23);
		frame.getContentPane().add(lblNewLabel);

		// 뒤로 가기 라벨
		JLabel lblArrow = new JLabel("");
		lblArrow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				AdminMainPage.main(null);
			}
		});
		lblArrow.setBounds(10, 2, 35, 35);
		frame.getContentPane().add(lblArrow);

		ImageIcon icon = new ImageIcon(AdminRevenue.class.getResource("/com/javalec/image/leftarrow.png"));
		Image img = icon.getImage(); // ImageIcon을 Image로 변환.
		Image updateImg = img.getScaledInstance(20, 15, java.awt.Image.SCALE_SMOOTH);
		ImageIcon updateIcon = new ImageIcon(updateImg);
		lblArrow.setIcon(updateIcon);

		JLabel lblEm = new JLabel("null님");
		lblEm.setForeground(new Color(60, 143, 96));
		lblEm.setFont(new Font("굴림", Font.BOLD, 15));
		lblEm.setBounds(50, 9, 81, 22);
		frame.getContentPane().add(lblEm);
		lblEm.setText(StaticClass.employee_name + "님");

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
		frame.getContentPane().add(getCbCategory());
		frame.getContentPane().add(getScrollPane());
		frame.getContentPane().add(getTfSearch());
		frame.getContentPane().add(getBtnSearch());
		frame.getContentPane().add(getRdbtnNewRadioButton());
		frame.getContentPane().add(getRdbtnNewRadioButton_1());
		frame.getContentPane().add(getRdbtnNewRadioButton_2());
		frame.getContentPane().add(getCbPeriod());
	}

	private JComboBox getCbCategory() {
		if (cbCategory == null) {
			cbCategory = new JComboBox();
			cbCategory.setModel(new DefaultComboBoxModel(new String[] { "제품 이름", "제품 번호", "카테고리" }));
			cbCategory.setBounds(30, 75, 80, 30);
		}
		return cbCategory;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(31, 120, 518, 235);
			scrollPane.setViewportView(getInner_Table());
		}
		return scrollPane;
	}

	private JTextField getTfSearch() {
		if (tfSearch == null) {
			tfSearch = new JTextField();
			tfSearch.setBounds(210, 80, 240, 21);
			tfSearch.setColumns(10);
		}
		return tfSearch;
	}

	private JButton getBtnSearch() {
		if (btnSearch == null) {
			btnSearch = new JButton("검색");
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					conditionQuery();
				}
			});
			btnSearch.setBounds(469, 77, 80, 26);
		}
		return btnSearch;
	}

	private JTable getInner_Table() {
		if (Inner_Table == null) {
			Inner_Table = new JTable();
			// 테이블 클릭 이벤트
			Inner_Table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					productId();
					frame.setVisible(false);
					AdminRevenueDetail.main(null);
				}
			});
			// **************************** 테이블 세팅 **************************
			Inner_Table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			Inner_Table.setModel(Outer_Table);
		}
		return Inner_Table;
	}

	private JRadioButton getRdbtnNewRadioButton() {
		if (rdbtnNewRadioButton == null) {
			rdbtnNewRadioButton = new JRadioButton("최근 한달 ");
			rdbtnNewRadioButton.addMouseListener(new MouseAdapter() {
				// 최근 한달 정렬
				@Override
				public void mouseClicked(MouseEvent e) {
					tableInit();
					monthDayAvg();
				}
			});
			buttonGroup_1.add(rdbtnNewRadioButton);
			rdbtnNewRadioButton.setBackground(new Color(247, 243, 243));
			rdbtnNewRadioButton.setBounds(30, 46, 81, 23);
		}
		return rdbtnNewRadioButton;
	}

	private JRadioButton getRdbtnNewRadioButton_1() {
		if (rdbtnNewRadioButton_1 == null) {
			rdbtnNewRadioButton_1 = new JRadioButton("작일");
			rdbtnNewRadioButton_1.addMouseListener(new MouseAdapter() {
				@Override
				// 작일 매출 수량으로 정렬
				public void mouseClicked(MouseEvent e) {
					yesterdayAvg();
				}
			});
			buttonGroup_1.add(rdbtnNewRadioButton_1);
			rdbtnNewRadioButton_1.setBackground(new Color(247, 243, 243));
			rdbtnNewRadioButton_1.setBounds(120, 46, 81, 23);
		}
		return rdbtnNewRadioButton_1;
	}

	private JRadioButton getRdbtnNewRadioButton_2() {
		if (rdbtnNewRadioButton_2 == null) {
			rdbtnNewRadioButton_2 = new JRadioButton("베스트");
			buttonGroup_1.add(rdbtnNewRadioButton_2);
			rdbtnNewRadioButton_2.setBackground(new Color(247, 243, 243));
			rdbtnNewRadioButton_2.setBounds(210, 46, 81, 23);
		}
		return rdbtnNewRadioButton_2;
	}

	private JComboBox getCbPeriod() {
		if (cbPeriod == null) {
			cbPeriod = new JComboBox();
			cbPeriod.setModel(new DefaultComboBoxModel(new String[] { "최근 한달", "3개월 ", "6개월" }));
			cbPeriod.setBounds(122, 75, 70, 30);
		}
		return cbPeriod;
	}

	// ===================================메소드==================================
	private void tableInit() {

		// 1. 테이블 초기화 tableInit() ------------
		// each column 만들
		Outer_Table.addColumn("제품 번호"); // 1
		Outer_Table.addColumn("제품 이름"); // 2
		Outer_Table.addColumn("카테고리");// 3
		Outer_Table.addColumn("주문 수량"); // 4
		Outer_Table.addColumn("매출"); // 5

		Outer_Table.setColumnCount(5);

		// 기존 데이터 다 지우기
		int i = Outer_Table.getRowCount();
		for (int j = 0; j < i; j++) {
			Outer_Table.removeRow(0); // 왜 0일까? ArrayList라서...
		}

		// 글씨 크기에 따라서 칼럼 width 사이즈가 조정 안되게 한다. (autoresizemode를 off)
		Inner_Table.setAutoResizeMode(Inner_Table.AUTO_RESIZE_OFF);

		// 만든 칼럼 폭 사이즈 조정
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
		width = 100;
		col.setPreferredWidth(width);

		vColIndex = 3;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 100;
		col.setPreferredWidth(width);

		vColIndex = 4;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 120;
		col.setPreferredWidth(width);

	}

	// ---------------------- 최근 한달간 일평균 매출-----------------------------
	private void monthDayAvg() {

		AdminRevenueDao dao = new AdminRevenueDao(); // 연결
		ArrayList<AdminRevenueDto> dtoList = dao.monthDayAvg();
		// Dao의 selectList 메소드 실행시켜 arrayList로 만든 후, dtoList에 저장

		int listCount = dtoList.size(); // 데이터의 열의 수를 나타냄

		// 위의 데이터 행의 수만큼 정보 출력
		for (int index = 0; index < listCount; index++) {
			String temp = Integer.toString(dtoList.get(index).getId()); // temp: seqno 할당
			String[] qTxt = { temp, dtoList.get(index).getName(), Integer.toString(dtoList.get(index).getPrice()),
					Double.toString(dtoList.get(index).getWkAvgQuantity()),
					Double.toString(dtoList.get(index).getWkAvgSales()) }; // 1행의 박스 할당
			Outer_Table.addRow(qTxt); // 출력
		}

	}

	// --------------------- 작일 매출 ------------------------------------

	private void yesterdayAvg() {

		AdminRevenueDao dao = new AdminRevenueDao(); // 연결
		ArrayList<AdminRevenueDto> dtoList = dao.yesterdayAvg();
		// Dao의 selectList 메소드 실행시켜 arrayList로 만든 후, dtoList에 저장

		int listCount = dtoList.size(); // 데이터의 열의 수를 나타냄

		// 위의 데이터 행의 수만큼 정보 출력
		for (int index = 0; index < listCount; index++) {
			String temp = Integer.toString(dtoList.get(index).getId()); // temp: seqno 할당
			String[] qTxt = { temp, dtoList.get(index).getName(), Integer.toString(dtoList.get(index).getPrice()),
					Double.toString(dtoList.get(index).getWkAvgQuantity()),
					Double.toString(dtoList.get(index).getWkAvgSales()) }; // 1행의 박스 할당
			Outer_Table.addRow(qTxt); // 출력
		}

	}

	// -----------------tableClick -> productId 추출 -------------------------
	private void productId() {

		// getSelectedRow: 클릭한(선택한) row의 인덱스를 리턴
		// 화면의 테이블에서 해당 행(row)의 번호 (primary key) 가져오기
		int i = Inner_Table.getSelectedRow();

		// getValueAt(int row, int column): DB에서 해당 row의 colum의 cell값을 반환
		// i 행(row)을 가져오고, 0은 primary key(순서)만 알면 되니까 0번
		String wkSequence = (String) Inner_Table.getValueAt(i, 0);

		// 숫자 프라이머리 키를 정수로 바꿔서 static으로 만들기
		StaticClass.product_id = Integer.parseInt(wkSequence);

	}

	// ========================= 기간 콤보박스로 정렬 ==================================
//	private void conditionQueryPeriod() {
//
//		int i = cbPeriod.getSelectedIndex();
//		int conditionQueryColumn = 0;
//
//		switch (i) {
//		case 0:
//			conditionQueryColumn = 1;
//			break;
//		case 1:
//			conditionQueryColumn = 3;
//			break;
//		case 2:
//			conditionQueryColumn = 6;
//			break;
//		default:
//			break;
//		}
//
//		// 0번째면, 이름으로 검색한다는 뜻
//
//		tableInit();
//		conditionQueryPeriodAction(conditionQueryColumn); // 여기서 0번째 이름 일부 검색 >> conditionQueryAction으로 간다.
//
//	}
//
//	// 조건 검색 % conditionQueryAction() ----------
//	// 콤보박스에서 conditionQueryColumn 가져옴
//	private void conditionQueryPeriodAction(int conditionQueryColumn) {
//
//		AdminRevenueDao dao = new AdminRevenueDao(conditionQueryColumn);
//		ArrayList<AdminRevenueDto> dtoList = dao.periodList();
//
//		int listCount = dtoList.size();
//		// 데이터의 행의 수를 나타냄
//
//		// 위의 데이터 행의 수만큼 정보 출력
//		for (int index = 0; index < listCount; index++) {
//			// 박스 풀기 ( seqno 의 데이터 행에 있는 데이터만)
//			String temp = Integer.toString(dtoList.get(index).getId());
//			String[] qTxt = { temp, dtoList.get(index).getName(), Integer.toString(dtoList.get(index).getPrice()),
//					Double.toString(dtoList.get(index).getWkAvgQuantity()),
//					Double.toString(dtoList.get(index).getWkAvgSales()) }; // 1행의 박스 하나
//			Outer_Table.addRow(qTxt);
//		}
//
//	}
//	
//	// ====================== 조건 검색 ===============================
//	private void conditionQuery() {
//		
//		int i = cbCategory.getSelectedIndex();
//		String conditionQueryColumn = "";
//		
//		switch (i) {
//		case 0:
//			conditionQueryColumn = "product_name";
//			break;
//		case 1:
//			conditionQueryColumn = "product_id";
//			break;
//		case 2:
//			conditionQueryColumn = "product_category";
//			break;
//		default:
//			break;
//		}
//		
//		// 0번째면, 이름으로 검색한다는 뜻
//		
//		tableInit();
//		conditionQueryAction(conditionQueryColumn); // 여기서 0번째 이름 일부 검색 >> conditionQueryAction으로 간다.
//		
//	}
//	
//	// 조건 검색 % conditionQueryAction() ----------
//	// 콤보박스에서 conditionQueryColumn 가져옴
//	private void conditionQueryAction(String conditionQueryColumn) {
//		
//		AdminRevenueDao dao = new AdminRevenueDao(conditionQueryColumn);
//		ArrayList<AdminRevenueDto> dtoList = dao.conditionList();
//		
//		int listCount = dtoList.size();
//		// 데이터의 행의 수를 나타냄
//		
//		// 위의 데이터 행의 수만큼 정보 출력
//		for (int index = 0; index < listCount; index++) {
//			// 박스 풀기 ( seqno 의 데이터 행에 있는 데이터만)
//			String temp = Integer.toString(dtoList.get(index).getId());
//			String[] qTxt = { temp, dtoList.get(index).getName(), Integer.toString(dtoList.get(index).getPrice()),
//					Double.toString(dtoList.get(index).getWkAvgQuantity()),
//					Double.toString(dtoList.get(index).getWkAvgSales()) }; // 1행의 박스 하나
//			Outer_Table.addRow(qTxt);
//		}
//		
//	}

	// ======================= 콤보박스 ============================================

	private void conditionQuery() {

		String categoryColumn = "";
		int periodColumn = 0;
		String[] categoryArray = { "product_name", "product_id", "product_category" };
		int[] periodArray = { 1, 3, 6 };

		int i = cbCategory.getSelectedIndex();
		int j = cbPeriod.getSelectedIndex();

		if (i == 0 && j == 0) {
			categoryColumn = categoryArray[i];
			periodColumn = periodArray[j];
		} else if (i == 0 && j == 1) {
			categoryColumn = categoryArray[i];
			periodColumn = periodArray[j];
		} else if (i == 0 && j == 2) {
			categoryColumn = categoryArray[i];
			periodColumn = periodArray[j];
		} else if (i == 1 && j == 0) {
			categoryColumn = categoryArray[i];
			periodColumn = periodArray[j];
		} else if (i == 1 && j == 1) {
			categoryColumn = categoryArray[i];
			periodColumn = periodArray[j];
		} else if (i == 1 && j == 2) {
			categoryColumn = categoryArray[i];
			periodColumn = periodArray[j];
		} else if (i == 2 && j == 0) {
			categoryColumn = categoryArray[i];
			periodColumn = periodArray[j];
		} else if (i == 2 && j == 1) {
			categoryColumn = categoryArray[i];
			periodColumn = periodArray[j];
		} else if (i == 2 && j == 2) {
			categoryColumn = categoryArray[i];
			periodColumn = periodArray[j];
		}

		tableInit();
		conditionQueryAction(categoryColumn, periodColumn); // 여기서 0번째 이름 일부 검색 >> conditionQueryAction으로 간다.
		System.out.println(".. 카테고리: " +categoryColumn);
		
	}

	private void conditionQueryAction(String categoryColumn, int periodColumn) {

		AdminRevenueDao dao = new AdminRevenueDao(categoryColumn, periodColumn, tfSearch.getText().trim());
		ArrayList<AdminRevenueDto> dtoList = dao.conditionList();

		int listCount = dtoList.size();
		// 데이터의 행의 수를 나타냄
		System.out.println("listCount: " +listCount);

		String temp = null;

		// 위의 데이터 행의 수만큼 정보 출력
		for (int index = 0; index < listCount; index++) {
			// 박스 풀기 ( seqno 의 데이터 행에 있는 데이터만)
			temp = Integer.toString(dtoList.get(index).getId());
			String[] qTxt = { temp, dtoList.get(index).getName(), dtoList.get(index).getCategory(),
					Double.toString(dtoList.get(index).getWkAvgQuantity()),
					Double.toString(dtoList.get(index).getWkAvgSales()) };
			System.out.println("temp: " + temp);
			Outer_Table.addRow(qTxt);

		}
	}

}// END
