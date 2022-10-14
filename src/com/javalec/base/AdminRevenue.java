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
	private final ButtonGroup buttonGroup = new ButtonGroup();

	// ******************* Table definition ************************************
	private final DefaultTableModel Outer_Table = new DefaultTableModel();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JComboBox cbPeriod;
	private JLabel lblGoHome;

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
		frame.getContentPane().add(getLblGoHome());

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
		frame.getContentPane().add(getCbPeriod());
	}

	private JComboBox getCbCategory() {
		if (cbCategory == null) {
			cbCategory = new JComboBox();
			cbCategory.setModel(new DefaultComboBoxModel(new String[] { "제품 이름", "제품 번호", "카테고리" }));
			cbCategory.setBounds(30, 78, 80, 30);
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
			tfSearch.setBounds(215, 83, 240, 21);
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
			btnSearch.setBounds(469, 80, 80, 26);
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

	private JComboBox getCbPeriod() {
		if (cbPeriod == null) {
			cbPeriod = new JComboBox();
			cbPeriod.setModel(new DefaultComboBoxModel(new String[] { "최근 한달", "3개월 ", "6개월" }));
			cbPeriod.setBounds(120, 78, 80, 30);
		}
		return cbPeriod;
	}
	private JLabel getLblGoHome() {
		if (lblGoHome == null) {
			lblGoHome = new JLabel("");
			lblGoHome.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					frame.setVisible(false);
					AdminMainPage.main(null);
					
				}
			});
			lblGoHome.setBounds(551, 9, 35, 35);
			lblGoHome.setBounds(545, 2, 35, 35);
			ImageIcon icon = new ImageIcon(AdminStaffDetail.class.getResource("/com/javalec/image/home.png"));
			Image img = icon.getImage(); // ImageIcon을 Image로 변환.
			Image updateImg = img.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
			ImageIcon updateIcon = new ImageIcon(updateImg);
			
			lblGoHome.setIcon(updateIcon);
		}
		return lblGoHome;
	}

	// ===================================메소드==================================
	private void tableInit() {

		// 1. 테이블 초기화 tableInit() ------------
		// each column 만들
		Outer_Table.addColumn("제품 번호"); // 1
		Outer_Table.addColumn("제품 이름"); // 2
		Outer_Table.addColumn("카테고리");// 3
		Outer_Table.addColumn("하루 평균 주문 수량"); // 4
		Outer_Table.addColumn("하루 평균 매출"); // 5
		Outer_Table.addColumn("달 평균 주문 수량"); // 6
		Outer_Table.addColumn("달 평균 매출"); // 7

		Outer_Table.setColumnCount(7);

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
		int width = 50;
		col.setPreferredWidth(width);

		vColIndex = 1;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 60;
		col.setPreferredWidth(width);

		vColIndex = 2;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 70;
		col.setPreferredWidth(width);

		vColIndex = 3;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 100;
		col.setPreferredWidth(width);

		vColIndex = 4;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 100;
		col.setPreferredWidth(width);
		
		vColIndex = 5;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 100;
		col.setPreferredWidth(width);
		
		vColIndex = 6;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 100;
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
			String[] qTxt = { temp, dtoList.get(index).getName(), dtoList.get(index).getCategory(),
					Double.toString(dtoList.get(index).getWkAvgQuantity()),
					Double.toString(dtoList.get(index).getWkAvgSales()),
					Double.toString(dtoList.get(index).getWkAvgMonthQuantity()),
					Double.toString(dtoList.get(index).getWkAvgMonthSales())
					
			}; // 1행의 박스 할당
			Outer_Table.addRow(qTxt); // 출력
		}

	}

	// -----------------tableClick -> productId 추출 -------------------------
	private void productId() {

		// getSelectedRow: 클릭한(선택한) row의 인덱스를 리턴
		int i = Inner_Table.getSelectedRow();

		String wkSequence = (String) Inner_Table.getValueAt(i, 0);

		// 숫자 프라이머리 키를 정수로 바꿔서 static으로 만들기
		StaticClass.product_id = Integer.parseInt(wkSequence);

	}

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
		
	}

	private void conditionQueryAction(String categoryColumn, int periodColumn) {

		AdminRevenueDao dao = new AdminRevenueDao(categoryColumn, periodColumn, tfSearch.getText().trim());
		ArrayList<AdminRevenueDto> dtoList = dao.conditionList();

		int listCount = dtoList.size();
		// 데이터의 행의 수를 나타냄

		String temp = null;

		// 위의 데이터 행의 수만큼 정보 출력
		for (int index = 0; index < listCount; index++) {
			// 박스 풀기 ( seqno 의 데이터 행에 있는 데이터만)
			temp = Integer.toString(dtoList.get(index).getId());
			String[] qTxt = { temp, dtoList.get(index).getName(), dtoList.get(index).getCategory(),
					Double.toString(dtoList.get(index).getWkAvgQuantity()),
					Double.toString(dtoList.get(index).getWkAvgSales()),
					Double.toString(dtoList.get(index).getWkAvgMonthQuantity()),
					Double.toString(dtoList.get(index).getWkAvgMonthSales())
			};
			Outer_Table.addRow(qTxt);

		}
	}

}// END
