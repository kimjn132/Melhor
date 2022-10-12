package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.dao.AdminRegisterStaffManagementDao;
import com.javalec.dao.AdminStaffDetailDao;
import com.javalec.dto.AdminRegisterStaffManagementDto;
import com.javalec.util.StaticClass;

import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

public class AdminRegisterStaffManagement extends JFrame {

	private JFrame frame;
	private JLabel lblEm;
	private JLabel lblArrow;
	private JLabel lblNewLabel_1_1_5;
	private JLabel lblNewLabel;
	private JLabel lblStore;
	private JButton btnMyPage;
	private JComboBox cbCategory;
	private JTextField textField;
	private JScrollPane scrollPane_1;
	private JButton btnSearch;
	private JLabel lblNewLabel_1_2;
	private JButton btnGoToHome;

	// ******************* Table definition ************************************
	private final DefaultTableModel Outer_Table = new DefaultTableModel();
	private JTable Inner_Table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminRegisterStaffManagement window = new AdminRegisterStaffManagement();
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
	public AdminRegisterStaffManagement() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(247, 243, 243));
		frame.addWindowListener(new WindowAdapter() {
			// **************** 윈도우 이벤트 (테이블 세팅) ********************
			@Override
			public void windowActivated(WindowEvent e) {
				tableInit();
				searchAction();
			}
		});
		frame.setTitle("스태프 관리");
		frame.setBounds(100, 100, 600, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblEm());
		frame.getContentPane().add(getLblStore());
		frame.getContentPane().add(getBtnGoToHome());
		frame.getContentPane().add(getBtnMyPage());
		frame.getContentPane().add(getLblArrow());
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getLblNewLabel_1_1_5());
		frame.getContentPane().add(getCbCategory());
		frame.getContentPane().add(getTextField());
		frame.getContentPane().add(getScrollPane_1());
		frame.getContentPane().add(getBtnSearch());
		frame.getContentPane().add(getLblNewLabel_1_2());
	}

	private JLabel getLblEm() {
		if (lblEm == null) {
			lblEm = new JLabel("null님");
			lblEm.setForeground(new Color(60, 143, 96));
			lblEm.setFont(new Font("굴림", Font.BOLD, 15));
			lblEm.setBounds(43, 10, 81, 22);
			lblEm.setText(StaticClass.employee_name + "님");
		}
		return lblEm;
	}

	private JLabel getLblArrow() {
		if (lblArrow == null) {
			lblArrow = new JLabel("");
			lblArrow.addMouseListener(new MouseAdapter() {
				// 뒤로 가기 라벨 클릭 이벤트
				@Override
				public void mouseClicked(MouseEvent e) {
					frame.setVisible(false);
					AdminStaffMenu.main(null);
				}
			});
			lblArrow.setBounds(10, 3, 35, 35);

			ImageIcon icon = new ImageIcon(
					AdminRegisterStaffManagement.class.getResource("/com/javalec/image/leftarrow.png"));
			Image img = icon.getImage(); // ImageIcon을 Image로 변환.
			Image updateImg = img.getScaledInstance(20, 15, java.awt.Image.SCALE_SMOOTH);
			ImageIcon updateIcon = new ImageIcon(updateImg);
			lblArrow.setIcon(updateIcon);
		}
		return lblArrow;
	}

	private JLabel getLblNewLabel_1_1_5() {
		if (lblNewLabel_1_1_5 == null) {
			lblNewLabel_1_1_5 = new JLabel("");
			lblNewLabel_1_1_5.setOpaque(true);
			lblNewLabel_1_1_5.setForeground(new Color(255, 204, 204));
			lblNewLabel_1_1_5.setBackground(new Color(235, 199, 189));
			lblNewLabel_1_1_5.setBounds(0, 0, 586, 40);
		}
		return lblNewLabel_1_1_5;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Melhor Coffee");
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 18));
			lblNewLabel.setBounds(169, 10, 142, 23);
		}
		return lblNewLabel;
	}

	private JLabel getLblStore() {
		if (lblStore == null) {
			lblStore = new JLabel((String) null);
			lblStore.setForeground(new Color(60, 143, 96));
			lblStore.setFont(new Font("굴림", Font.PLAIN, 15));
			lblStore.setBounds(336, 10, 50, 23);
			lblStore.setText(StaticClass.shop_name);
		}
		return lblStore;
	}

	private JButton getBtnMyPage() {
		if (btnMyPage == null) {
			btnMyPage = new JButton("My Page");
			btnMyPage.setBounds(483, 10, 91, 23);
		}
		return btnMyPage;
	}

	private JComboBox getCbCategory() {
		if (cbCategory == null) {
			cbCategory = new JComboBox();
			cbCategory.setModel(new DefaultComboBoxModel(new String[] {"전체", "사원번호", "이름", "입사일"}));
			cbCategory.setBounds(32, 60, 85, 30);
		}
		return cbCategory;
	}

	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setColumns(10);
			textField.setBounds(156, 62, 300, 27);
		}
		return textField;
	}

	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(32, 98, 522, 251);
			scrollPane_1.setViewportView(getInner_Table());
		}
		return scrollPane_1;
	}

	private JButton getBtnSearch() {
		if (btnSearch == null) {
			btnSearch = new JButton("검색");
			btnSearch.setBounds(494, 60, 60, 30);
		}
		return btnSearch;
	}

	private JLabel getLblNewLabel_1_2() {
		if (lblNewLabel_1_2 == null) {
			lblNewLabel_1_2 = new JLabel("");
			lblNewLabel_1_2.setOpaque(true);
			lblNewLabel_1_2.setForeground(new Color(255, 204, 204));
			lblNewLabel_1_2.setBackground(new Color(235, 199, 189));
			lblNewLabel_1_2.setBounds(0, 374, 586, 40);
		}
		return lblNewLabel_1_2;
	}

	private JButton getBtnGoToHome() {
		if (btnGoToHome == null) {
			btnGoToHome = new JButton("홈화면으로 가기");
			btnGoToHome.setBounds(445, 382, 129, 23);
		}
		return btnGoToHome;
	}

	private JTable getInner_Table() {
		if (Inner_Table == null) {
			Inner_Table = new JTable();
			//********************테이블 클릭 이벤트*******************
			Inner_Table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (e.getButton() == 1) {
						staffId();
						frame.setVisible(false);
						AdminStaffDetail.main(null);
					}
				}
			});
			// **************************** 테이블 세팅 **************************
			Inner_Table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			Inner_Table.setModel(Outer_Table);
		}
		return Inner_Table;
	}

	// ==================================메소드==============================================
	// 1. 테이블 초기화 tableInit() ------------
	private void tableInit() {
		// each column 만들
		Outer_Table.addColumn("사원 번호"); // 1
		Outer_Table.addColumn("이름"); // 2
		Outer_Table.addColumn("입사일");// 3

		Outer_Table.setColumnCount(3);

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
		width = 150;
		col.setPreferredWidth(width);

	}

	// 2. DB to Table db에서 테이블로 정보 가져오기 searchAction()--------------
	// Dao의 selectList 메소드 실행시켜 arrayList로 만든 후, dtoList에 저장
	private void searchAction() {

		AdminRegisterStaffManagementDao dao = new AdminRegisterStaffManagementDao(); // 연결
		ArrayList<AdminRegisterStaffManagementDto> dtoList = dao.selectList();
		// Dao의 selectList 메소드 실행시켜 arrayList로 만든 후, dtoList에 저장

		int listCount = dtoList.size(); // 데이터의 열의 수를 나타냄

		// 위의 데이터 행의 수만큼 정보 출력
		for (int index = 0; index < listCount; index++) {
			String temp = Integer.toString(dtoList.get(index).getId()); // temp: seqno 할당
			String[] qTxt = { temp, dtoList.get(index).getName(), dtoList.get(index).getInDate() }; // 1행의 박스 할당
			Outer_Table.addRow(qTxt); // 출력
		}

	}
	
	private void staffId() {

		// getSelectedRow: 클릭한(선택한) row의 인덱스를 리턴
		// 화면의 테이블에서 해당 행(row)의 번호 (primary key) 가져오기
		int i = Inner_Table.getSelectedRow(); 

		//getValueAt(int row, int column): DB에서 해당 row의 colum의 cell값을 반환 
		// i 행(row)을 가져오고, 0은 primary key(순서)만 알면 되니까 0번
		String wkStaffId = (String) Inner_Table.getValueAt(i, 0);

		StaticClass.staff_id = Integer.parseInt(wkStaffId);
		System.out.println("staffId: " + wkStaffId);
	}

	
	
	
	
	
	
	
	
	
	
	
	

}// END
