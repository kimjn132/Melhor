package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.dao.AdminMenuDetailDao;
import com.javalec.dao.AdminRegisterMenuManagementDao;
import com.javalec.dto.AdminMenuDetailDto;
import com.javalec.dto.AdminRegisterMenuManagementDto;
import com.javalec.util.StaticClass;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminRegisterMenuManagement extends JFrame {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JLabel lblStore;
	private JLabel lblEm;
	private JLabel lblNewLabel_1_2;
	private JLabel lblNewLabel_8;
	private JLabel lblGoHome;
	private JScrollPane scrollPane_1;
	private JTable InnerTable;

	// --- Table
	private final DefaultTableModel OuterTable = new DefaultTableModel();

	// -- file 정리
	ArrayList<AdminRegisterMenuManagementDto> beanList = null;
	private JComboBox cbSelection;
	private JTextField tfSearch;
	private JButton btnSearch;
	private JLabel lblCount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminRegisterMenuManagement window = new AdminRegisterMenuManagement();
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
	public AdminRegisterMenuManagement() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			// *********************윈도우 이벤트************************
			@Override
			public void windowOpened(WindowEvent e) {
				tableInit();
				queryAction();
				getLblCount();
			}

			public void windowClosing(WindowEvent e) {
				closingAction(); // <--***************************************************
			}
		});
		frame.setTitle("등록 메뉴 관리");
		frame.getContentPane().setBackground(new Color(247, 243, 243));
		frame.setBounds(100, 100, 600, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblGoHome());
		frame.getContentPane().add(getLblStore());
		frame.getContentPane().add(getLblNewLabel_8());
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getLblEm());
		frame.getContentPane().add(getLblNewLabel_1_2());
		frame.getContentPane().add(getScrollPane_1());
		frame.getContentPane().add(getCbSelection());
		frame.getContentPane().add(getTfSearch());
		frame.getContentPane().add(getBtnSearch());
		frame.getContentPane().add(getLblCount());
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Melhor Coffee");
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 18));
			lblNewLabel.setBounds(200, 10, 140, 23);
		}
		return lblNewLabel;
	}

	private JLabel getLblStore() {
		if (lblStore == null) {
			lblStore = new JLabel("지점");
			lblStore.setFont(new Font("굴림", Font.PLAIN, 15));
			lblStore.setForeground(new Color(60, 143, 96));
			lblStore.setBounds(340, 10, 80, 22);
			lblStore.setText(StaticClass.shop_name);
		}
		return lblStore;
	}

	private JLabel getLblEm() {
		if (lblEm == null) {
			lblEm = new JLabel("OO님");
			lblEm.setFont(new Font("굴림", Font.PLAIN, 14));
			lblEm.setForeground(new Color(60, 143, 96));
			lblEm.setBackground(new Color(60, 143, 96));
			lblEm.setBounds(40, 10, 80, 20);
			// ********************************** 이름 넣어주기 *************************
			lblEm.setText(StaticClass.employee_name + "님");
		}
		return lblEm;
	}

	private JLabel getLblNewLabel_1_2() {
		if (lblNewLabel_1_2 == null) {
			lblNewLabel_1_2 = new JLabel("");
			lblNewLabel_1_2.setOpaque(true);
			lblNewLabel_1_2.setForeground(new Color(255, 204, 204));
			lblNewLabel_1_2.setBackground(new Color(235, 199, 189));
			lblNewLabel_1_2.setBounds(0, 0, 586, 40);
		}
		return lblNewLabel_1_2;
	}

	private JLabel getLblNewLabel_8() {
		if (lblNewLabel_8 == null) {
			lblNewLabel_8 = new JLabel("");
			lblNewLabel_8.addMouseListener(new MouseAdapter() {
				// 뒤로 가기
				@Override
				public void mouseClicked(MouseEvent e) {
					frame.setVisible(false);
					AdminMenuManagement.main(null);
				}
			});
			lblNewLabel_8.setBounds(10, 2, 35, 35);
			ImageIcon icon = new ImageIcon(
					AdminRegisterMenuManagement.class.getResource("/com/javalec/image/leftarrow.png"));
			Image img = icon.getImage(); // ImageIcon을 Image로 변환.
			Image updateImg = img.getScaledInstance(20, 15, java.awt.Image.SCALE_SMOOTH);
			ImageIcon updateIcon = new ImageIcon(updateImg);

			lblNewLabel_8.setIcon(updateIcon);
		}
		return lblNewLabel_8;
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

	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(40, 120, 496, 248);
			scrollPane_1.setViewportView(getInnerTable());
		}
		return scrollPane_1;
	}

	private JTable getInnerTable() {
		if (InnerTable == null) {
			InnerTable = new JTable() { // <--****************
				public Class getColumnClass(int column) { // <--****************
					return (column == 0) ? Icon.class : Object.class; // <--****************
				}
			};
			InnerTable.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					System.out.println("클릭");
					System.out.println(StaticClass.product_id);
						tableClick();
						registerId();
						frame.setVisible(false);
						AdminMenuDetail.main(null);
					
				}
			});
			InnerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			InnerTable.setRowHeight(150); // <--***************************************************
			InnerTable.setModel(OuterTable);
		}
		return InnerTable;
	}

	private JComboBox getCbSelection() {
		if (cbSelection == null) {
			cbSelection = new JComboBox();
			cbSelection.setModel(new DefaultComboBoxModel(new String[] { "카테고리", "제품 번호", "제품 이름" }));
			cbSelection.setBounds(39, 60, 65, 30);
		}
		return cbSelection;
	}

	private JTextField getTfSearch() {
		if (tfSearch == null) {
			tfSearch = new JTextField();
			tfSearch.setBounds(120, 62, 327, 28);
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
			btnSearch.setBounds(470, 60, 65, 30);
		}
		return btnSearch;
	}

	// 개수 출력 라벨
	private JLabel getLblCount() {
		if (lblCount == null) {
			lblCount = new JLabel("개수");
			lblCount.setFont(new Font("굴림", Font.BOLD, 12));
			lblCount.setLabelFor(frame);
			lblCount.setHorizontalAlignment(SwingConstants.RIGHT);
			lblCount.setForeground(new Color(60, 143, 96));
			lblCount.setBounds(486, 100, 50, 17);

			AdminRegisterMenuManagementDao dao = new AdminRegisterMenuManagementDao();
			AdminRegisterMenuManagementDto dto = dao.menuCount();

			String count = Integer.toString(dto.getWkId());
			
			System.out.println("count: " +count);
			
			lblCount.setText("총" +count+ "개");

		}
		return lblCount;
	}
	// ==========================================메소드======================================

	private void tableInit() {
		int i = OuterTable.getRowCount();

		OuterTable.addColumn("사진");
		OuterTable.addColumn("제품 번호");
		OuterTable.addColumn("카테고리");
		OuterTable.addColumn("제품 이름");
		OuterTable.addColumn("가격");
		// OuterTable.setColumnCount(2);

		for (int j = 0; j < i; j++) {
			OuterTable.removeRow(0);
		}

		InnerTable.setAutoResizeMode(InnerTable.AUTO_RESIZE_OFF);

		int vColIndex = 0;
		TableColumn col = InnerTable.getColumnModel().getColumn(vColIndex);
		int width = 100;
		col.setPreferredWidth(width);

		vColIndex = 1;
		col = InnerTable.getColumnModel().getColumn(vColIndex);
		width = 80;
		col.setPreferredWidth(width);
		vColIndex = 2;
		col = InnerTable.getColumnModel().getColumn(vColIndex);
		width = 80;
		col.setPreferredWidth(width);
		vColIndex = 3;
		col = InnerTable.getColumnModel().getColumn(vColIndex);
		width = 80;
		col.setPreferredWidth(width);
		vColIndex = 4;
		col = InnerTable.getColumnModel().getColumn(vColIndex);
		width = 80;
		col.setPreferredWidth(width);

	}

	private void queryAction() {
		AdminRegisterMenuManagementDao dbAction = new AdminRegisterMenuManagementDao();
		beanList = dbAction.SelectList();

		int listCount = beanList.size();

		for (int index = 0; index < listCount; index++) {
			ImageIcon icon = new ImageIcon("./" + beanList.get(index).getWkFilename());
			Object[] tempData = { icon, beanList.get(index).getWkId(), beanList.get(index).getWkCategory(),
					beanList.get(index).getWkName(), beanList.get(index).getWkPrice() };
			OuterTable.addRow(tempData);
		}
	}

	private void closingAction() {

		for (int index = 0; index < beanList.size(); index++) {
			File file = new File("./" + beanList.get(index).getWkFilename());
			file.delete();

		}

	}

	// ========================== 콤보 박스 검색 ========================================
	private void conditionQuery() {

		int i = cbSelection.getSelectedIndex();
		String conditionQueryColumn = "";

		switch (i) {
		case 0:
			conditionQueryColumn = "product_category";
			break;
		case 1:
			conditionQueryColumn = "product_id";
			break;
		case 2:
			conditionQueryColumn = "product_name";
			break;
		default:
			break;
		}

		// 0번째면, 이름으로 검색한다는 뜻

		tableInit();
		conditionQueryAction(conditionQueryColumn); // 여기서 0번째 이름 일부 검색 >> conditionQueryAction으로 간다.

	}

	// 조건 검색 % conditionQueryAction() ----------
	// 콤보박스에서 conditionQueryColumn 가져옴
	private void conditionQueryAction(String conditionQueryColumn) {

		AdminRegisterMenuManagementDao dao = new AdminRegisterMenuManagementDao(conditionQueryColumn,
				tfSearch.getText());
		ArrayList<AdminRegisterMenuManagementDto> dtoList = dao.conditionList();

		int listCount = dtoList.size();
		System.out.println("l: " +listCount);
		// 데이터의 행의 수를 나타냄

		// 위의 데이터 행의 수만큼 정보 출력
		for (int index = 0; index < listCount; index++) {
			ImageIcon icon = new ImageIcon("./" + beanList.get(index).getWkFilename());
			Object[] tempData = { icon, beanList.get(index).getWkId(), beanList.get(index).getWkCategory(),
					beanList.get(index).getWkName(), beanList.get(index).getWkPrice() };
			OuterTable.addRow(tempData);
		}

	}

	// 테이블 클릭해서 스태틱에 product_id 넘겨주기
	private void tableClick() {

		int i = InnerTable.getSelectedRow();

		String wkSequence = InnerTable.getValueAt(i, 1).toString();

		StaticClass.product_id = Integer.parseInt(wkSequence);
		
	}
	
	// 테이블 클릭시 register_id 넘기기 
	
	private void registerId() {
		
		AdminRegisterMenuManagementDao dao = new AdminRegisterMenuManagementDao();
		AdminRegisterMenuManagementDto registerId = dao.registerId();
		
		int changeRegisterId = registerId.getWkId();
		
		StaticClass.register_id = changeRegisterId;
		
	}
	
	
	
	
	
	
	
	
	
	
	

}// END
