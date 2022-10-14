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
		frame.setTitle("메뉴 검색");
		frame.setBackground(Color.WHITE);
		frame.getContentPane().setBackground(new Color(247, 243, 243));
		frame.addWindowListener(new WindowAdapter() {
			// **************** 윈도우 이벤트 (테이블 세팅) ********************
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

		JLabel lblStore = new JLabel("지점");
		lblStore.setForeground(new Color(60, 143, 96));
		lblStore.setFont(new Font("굴림", Font.PLAIN, 15));
		lblStore.setBounds(340, 10, 50, 23);
		frame.getContentPane().add(lblStore);
		lblStore.setText(StaticClass.shop_name);

		JLabel lblArrow = new JLabel("");
		// 뒤로 가기 라벨 클릭 이벤트
		lblArrow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminMenuManagement.main(null);
				frame.setVisible(false);
			}
		});
		lblArrow.setBounds(10, 3, 35, 35);
		ImageIcon icon = new ImageIcon(AdminMenuList.class.getResource("/com/javalec/image/leftarrow.png"));
		Image img = icon.getImage(); // ImageIcon을 Image로 변환.
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

		JButton btnSearch = new JButton("검색");
		// ******************************검색 버튼 이벤트***********************
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conditionQuery();
			}
		});
		btnSearch.setBounds(494, 85, 60, 30);
		frame.getContentPane().add(btnSearch);

		cbCategory = new JComboBox();
		cbCategory.setModel(new DefaultComboBoxModel(new String[] {"카테고리", "제품명"}));
		cbCategory.setBounds(32, 85, 85, 30);
		frame.getContentPane().add(cbCategory);

		JLabel lblEm = new JLabel("null님");
		lblEm.setForeground(new Color(60, 143, 96));
		lblEm.setFont(new Font("굴림", Font.PLAIN, 14));
		lblEm.setBounds(40, 10, 80, 20);
		frame.getContentPane().add(lblEm);
		lblEm.setText(StaticClass.employee_name + "님");

		JLabel lblNewLabel = new JLabel("Melhor Coffee");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 18));
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
				// ***********************테이블 클릭 이벤트(페이지 넘기기)******************
				@Override
				public void mouseClicked(MouseEvent e) {
					if (e.getButton() == 1) {
						// static으로 상품 아이디 보내주기
						System.out.println("리스트 클릭");
						productId();
						frame.setVisible(false);
						AdminMenuDetail.main(null);
					}
				}
			});
			scrollPane.setViewportView(Inner_Table);
			
			// **************************** 테이블 세팅 **************************
			Inner_Table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			Inner_Table.setModel(Outer_Table);
		}
		return Inner_Table;
	}
	
	private JLabel getLblGoHome() {
		if (lblGoHome == null) {
			lblGoHome = new JLabel("");
			lblGoHome.addMouseListener(new MouseAdapter() {
				// 홈으로 가기 클릭
				@Override
				public void mouseClicked(MouseEvent e) {
					frame.setVisible(false);
					AdminMainPage.main(null);
				}
			});
			lblGoHome.setBounds(545, 2, 35, 35);
			ImageIcon icon = new ImageIcon(AdminStaffDetail.class.getResource("/com/javalec/image/home.png"));
			Image img = icon.getImage(); // ImageIcon을 Image로 변환.
			Image updateImg = img.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
			ImageIcon updateIcon = new ImageIcon(updateImg);

			lblGoHome.setIcon(updateIcon);
		}
		return lblGoHome;
	}

	private JRadioButton getRdBest() {
		if (rdBest == null) {
			rdBest = new JRadioButton("베스트 (전체)");
			buttonGroup_1.add(rdBest);
			// 베스트 버튼 정렬 
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
			rdbtnNewRadioButton_1 = new JRadioButton("베스트 (한 달)");
			// 한 달 베스트 정렬
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
			rdbtnNewRadioButton_2 = new JRadioButton("전체");
			// 전체 정렬
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
	// ===============================메소드========================================

	// -----------------------테이블 초기화 tableInit-----------------------------
	private void tableInit() {
		// each column 만들
		Outer_Table.addColumn("상품 번호"); // 1
		Outer_Table.addColumn("카테고리"); // 2
		Outer_Table.addColumn("상품 이름");// 3
		Outer_Table.addColumn("가격"); // 4

		Outer_Table.setColumnCount(4);

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
		width = 140;
		col.setPreferredWidth(width);

		vColIndex = 3;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 140;
		col.setPreferredWidth(width);

	}
	

	// --------------------- select * 테이블에 출력 searchAction()----------------------
	private void searchAction() {

		AdminMenuInsertDao adminMenuInsertDao = new AdminMenuInsertDao();
		ArrayList<AdminMenuInsertDto> dtoList = adminMenuInsertDao.selectList();
		// Dao의 selectList 메소드 실행시켜 arrayList로 만든 후, dtoList에 저장

		int listCount = dtoList.size(); // 데이터의 열의 수를 나타냄

		// 위의 데이터 행의 수만큼 정보 출력
		for (int index = 0; index < listCount; index++) {
			String temp = Integer.toString(dtoList.get(index).getProduct_id()); // temp: seqno 할당
			String[] qTxt = { temp, dtoList.get(index).getProduct_category(), dtoList.get(index).getProduct_name(),
					Integer.toString(dtoList.get(index).getProduct_price()) }; // 1행의 박스 할당
			Outer_Table.addRow(qTxt); // 출력
		}

	}

	// 일부만 검색해서 나오게 하기 %

	// 일부 데이터 검색 해서 데이터 나오게 하기

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

		// 0번째면, 이름으로 검색한다는 뜻

		tableInit();
		conditionQueryAction(conditionQueryColumn); // 여기서 0번째 이름 일부 검색 >> conditionQueryAction으로 간다.

	}

	private void conditionQueryAction(String conditionQueryColumn) {

		AdminMenuInsertDao dao = new AdminMenuInsertDao(conditionQueryColumn, tfSearch.getText());
		ArrayList<AdminMenuInsertDto> dtoList = dao.conditionList();

		int listCount = dtoList.size(); // 데이터의 행의 수를 나타

		// 위의 데이터 행의 수만큼 정보 출력
		for (int index = 0; index < listCount; index++) {
			String temp = Integer.toString(dtoList.get(index).getProduct_id()); // 박스 풀기 ( seqno 의 데이터 행에 있는 데이터만)
			String[] qTxt = { temp, dtoList.get(index).getProduct_category(), dtoList.get(index).getProduct_name(),
					Integer.toString(dtoList.get(index).getProduct_price()) }; // 1행의 박스 하
			Outer_Table.addRow(qTxt);
		}

	}

	// Table Click
	private void productId() {
		
		int i = Inner_Table.getSelectedRow();

		String wkSequence = Inner_Table.getValueAt(i, 0).toString();

		StaticClass.product_id = Integer.parseInt(wkSequence);
		
	}
	
	// 콤보박스 전체로 두고 검색 시 전체 나오게 
	
	// 라디오 버튼 베스트 정렬 (전체)
	private void ascendingBest() {
		
		AdminMenuInsertDao dao = new AdminMenuInsertDao(); // 연결
		ArrayList<AdminMenuInsertDto> dtoList = dao.ascendingBest(); 
		// Dao의 selectList 메소드 실행시켜 arrayList로 만든 후, dtoList에 저장
		
		int listCount = dtoList.size(); // 데이터의 열의 수를 나타냄

		// 위의 데이터 행의 수만큼 정보 출력
		for (int index = 0; index < listCount; index++) {
			String temp = Integer.toString(dtoList.get(index).getProduct_id()); // temp: seqno 할당
			String[] qTxt = { temp, dtoList.get(index).getProduct_category(), dtoList.get(index).getProduct_name(),
					Integer.toString(dtoList.get(index).getProduct_price()) }; // 1행의 박스 할당
			Outer_Table.addRow(qTxt); // 출력
		}
		
	}
	
	// 라디오 버튼 베스트 정렬 (한달)
	private void monthBestAscending() {
		
		AdminMenuInsertDao dao = new AdminMenuInsertDao(); // 연결
		ArrayList<AdminMenuInsertDto> dtoList = dao.monthBestAscending(); 
		// Dao의 selectList 메소드 실행시켜 arrayList로 만든 후, dtoList에 저장
		
		int listCount = dtoList.size(); // 데이터의 열의 수를 나타냄
		
		// 위의 데이터 행의 수만큼 정보 출력
		for (int index = 0; index < listCount; index++) {
			String temp = Integer.toString(dtoList.get(index).getProduct_id()); // temp: seqno 할당
			String[] qTxt = { temp, dtoList.get(index).getProduct_category(), dtoList.get(index).getProduct_name(),
					Integer.toString(dtoList.get(index).getProduct_price()) }; // 1행의 박스 할당
			Outer_Table.addRow(qTxt); // 출력
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
} // END
