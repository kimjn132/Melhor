package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.dao.HB_ShopSalesListDao;
import com.javalec.dto.HB_shopListDto;
import com.javalec.util.HB_Static;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;

public class HB_ShopSalesStatusPage extends JFrame {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JLabel lblSalesStatus;
	private JLabel lblStaffList;
	private JScrollPane scrollPane;
	private JTable Inner_Table;
	private JLabel lblTotalSales;
	private JComboBox cbShop;
	private JTextField tfShopText;
	private JButton btnNewButton;
	private JLabel lblManagerList;
	private JLabel lblManagerInsert;
	private JLabel lblStoreInsert;
	private JButton btnNewButton_1;
	
	private final DefaultTableModel Outer_Table = new DefaultTableModel();
	
	private JLabel lblTotalShopNumber;
	private JLabel lblTodaySales;
	private JLabel lblListCount;
	private JLabel lblAttendManage;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HB_ShopSalesStatusPage window = new HB_ShopSalesStatusPage();
					window.frame.setVisible(true);
					window.frame.setLocationRelativeTo(null);
					window.frame.setSize(697,542);
					window.frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HB_ShopSalesStatusPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("지점 리스트 및 총 판매 현황");
		frame.addWindowListener(new WindowAdapter() {

			@Override
			public void windowActivated(WindowEvent e) {
				shopSalesTableInit();
				shopSearchAction();
				allShopTotalSales();
			}
		});
		frame.setBounds(100, 100, 697, 542);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getLblSalesStatus());
		frame.getContentPane().add(getLblStaffList());
		frame.getContentPane().add(getScrollPane());
		frame.getContentPane().add(getLblTotalSales());
		frame.getContentPane().add(getCbShop());
		frame.getContentPane().add(getTfShopText());
		frame.getContentPane().add(getBtnNewButton());
		frame.getContentPane().add(getLblManagerList());
		frame.getContentPane().add(getLblManagerInsert());
		frame.getContentPane().add(getLblStoreInsert());
		frame.getContentPane().add(getLblTotalShopNumber());
		frame.getContentPane().add(getBtnNewButton_1());
		frame.getContentPane().add(getLblTodaySales());
		frame.getContentPane().add(getLblListCount());
		frame.getContentPane().add(getLblAttendManage());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("                MelHor Coffee");
			lblNewLabel.setBackground(new Color(235, 199, 189));
			lblNewLabel.setFont(new Font("굴림", Font.ITALIC, 19));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(0, 0, 585, 69);
			lblNewLabel.setOpaque(true);
		}
		return lblNewLabel;
	}
	private JLabel getLblTotalShopNumber() {
		if (lblTotalShopNumber == null) {
			lblTotalShopNumber = new JLabel("");
			lblTotalShopNumber.setBackground(new Color(235, 199, 189));
			lblTotalShopNumber.setHorizontalAlignment(SwingConstants.CENTER);
			lblTotalShopNumber.setVerticalAlignment(SwingConstants.BOTTOM);
			lblTotalShopNumber.setBounds(584, 0, 99, 69);
			lblTotalShopNumber.setOpaque(true);
		}
		return lblTotalShopNumber;
	}
	
	
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(115, 108, 568, 235);
			scrollPane.setViewportView(getInner_Table());
		}
		return scrollPane;
	}
	
	
	private JLabel getLblTotalSales() {
		if (lblTotalSales == null) {
			lblTotalSales = new JLabel("");
			lblTotalSales.setBounds(115, 385, 556, 25);
		}
		return lblTotalSales;
	}
	private JComboBox getCbShop() {
		if (cbShop == null) {
			cbShop = new JComboBox();
			cbShop.setModel(new DefaultComboBoxModel(new String[] {"지점명", "지점위치"}));
			cbShop.setBounds(115, 69, 125, 39);
		}
		return cbShop;
	}
	private JTextField getTfShopText() {
		if (tfShopText == null) {
			tfShopText = new JTextField();
			tfShopText.setBounds(241, 69, 346, 39);
			tfShopText.setColumns(10);
		}
		return tfShopText;
	}
	private JLabel getLblSalesStatus() {
		if (lblSalesStatus == null) {
			lblSalesStatus = new JLabel("지점 리스트");
			lblSalesStatus.setForeground(new Color(0, 0, 0));
			lblSalesStatus.setBackground(new Color(227, 147, 132));
			lblSalesStatus.setHorizontalAlignment(SwingConstants.CENTER);
			lblSalesStatus.setBounds(0, 69, 114, 39);
			lblSalesStatus.setOpaque(true);

		}
		return lblSalesStatus;
	}
	private JLabel getLblStaffList() {
		if (lblStaffList == null) {
			lblStaffList = new JLabel("알바생 리스트");
			lblStaffList.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					HB_StaffManageList.main(null);
					frame.setVisible(false);
					
				}
			});
			lblStaffList.setBackground(new Color(235, 199, 189));
			lblStaffList.setHorizontalAlignment(SwingConstants.CENTER);
			lblStaffList.setBounds(0, 108, 114, 39);
			lblStaffList.setOpaque(true);
		}
		return lblStaffList;
	}
	private JLabel getLblManagerList() {
		if (lblManagerList == null) {
			lblManagerList = new JLabel("점장 리스트");
			lblManagerList.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					HB_ManagerList.main(null);
					frame.setVisible(false);
					
				}
			});
			lblManagerList.setOpaque(true);
			lblManagerList.setHorizontalAlignment(SwingConstants.CENTER);
			lblManagerList.setBackground(new Color(235, 199, 189));
			lblManagerList.setBounds(0, 186, 114, 39);
		}
		return lblManagerList;
	}
	private JLabel getLblManagerInsert() {
		if (lblManagerInsert == null) {
			lblManagerInsert = new JLabel("점장 등록");
			lblManagerInsert.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					HB_ManagerAppoint.main(null);
					frame.setVisible(false);
					
				}
			});
			lblManagerInsert.setOpaque(true);
			lblManagerInsert.setHorizontalAlignment(SwingConstants.CENTER);
			lblManagerInsert.setForeground(Color.BLACK);
			lblManagerInsert.setBackground(new Color(227, 147, 132));
			lblManagerInsert.setBounds(0, 147, 114, 39);
		}
		return lblManagerInsert;
	}
	private JLabel getLblStoreInsert() {
		if (lblStoreInsert == null) {
			lblStoreInsert = new JLabel("지점 등록");
			lblStoreInsert.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					HB_ShopInsert.main(null);
					frame.setVisible(false);
					
				}
			});
			lblStoreInsert.setOpaque(true);
			lblStoreInsert.setHorizontalAlignment(SwingConstants.CENTER);
			lblStoreInsert.setForeground(Color.BLACK);
			lblStoreInsert.setBackground(new Color(227, 147, 132));
			lblStoreInsert.setBounds(0, 225, 114, 39);
		}
		return lblStoreInsert;
	}
	private JLabel getLblAttendManage() {
		if (lblAttendManage == null) {
			lblAttendManage = new JLabel("출근 관리");
			lblAttendManage.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					HB_AttendManage.main(null);
					frame.setVisible(false);
					
				}
			});
			lblAttendManage.setOpaque(true);
			lblAttendManage.setHorizontalAlignment(SwingConstants.CENTER);
			lblAttendManage.setBackground(new Color(235, 199, 189));
			lblAttendManage.setBounds(0, 264, 114, 39);
		}
		return lblAttendManage;
	}
	private JLabel getLblTodaySales() {
		if (lblTodaySales == null) {
			lblTodaySales = new JLabel("");
			lblTodaySales.setBounds(115, 420, 556, 25);
		}
		return lblTodaySales;
	}
	
	private JLabel getLblListCount() {
		if (lblListCount == null) {
			lblListCount = new JLabel("");
			lblListCount.setBounds(115, 350, 151, 25);
		}
		return lblListCount;
	}
	
	// --------------------------------- Action Listener -------------------------------------------
	
	private JTable getInner_Table() {
		if (Inner_Table == null) {
			Inner_Table = new JTable();
			Inner_Table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (e.getButton() == 1) { // 버튼이 눌리면

						int i = Inner_Table.getSelectedRow(); // 클릭한 데이터가 몇번째 줄 인지 알려줌
						String wkSequence = (String) Inner_Table.getValueAt(i, 0); // 해당하는 행의 i번째 데이터행 중 1번째에 있는 데이터를 wkSequence 변수에 저장 
//						wkSequence에는 employee_id 값이 저장
						
						HB_Static.setShop_number(Integer.parseInt(wkSequence)); // static으로 Shop_number 값을 저장 후 필요할 때 가져와서 사용
						
						HB_ShopDetail.main(null); // 저장 후 다른 화면 띄워줌
						frame.setVisible(false);
						
					}
				}
			});
			
			Inner_Table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			Inner_Table.setModel(Outer_Table);
		}
		return Inner_Table;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("검색");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					shopSalesTableInit();
					shopSearchAction();
					
				}
			});
			btnNewButton.setBounds(586, 69, 97, 39);
			Inner_Table.setModel(Outer_Table);
		}
		return btnNewButton;
	}
	
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("로그아웃");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					HB_ExcutiveLogin.main(null);
					frame.setVisible(false);
					HB_Static.setEmployee_id(0);
					
				}
			});
			btnNewButton_1.setBounds(563, 24, 108, 25);
		}
		return btnNewButton_1;
	}
	
	// --------------------------------- Action Listener -------------------------------------------
	
	// -----------------------------------------------------------------------------------------
	
	private void shopSalesTableInit() {
		
		Outer_Table.addColumn("순번");
		Outer_Table.addColumn("지점장 사원번호");
		Outer_Table.addColumn("지점명");
		Outer_Table.addColumn("지점 주소");
		Outer_Table.addColumn("지점 전화번호");
		
		
		Outer_Table.setColumnCount(5);
		
		int i = Outer_Table.getRowCount();
		
		for(int j = 0; j < i; j++) {
			Outer_Table.removeRow(0);
		}
		
			Inner_Table.setAutoResizeMode(Inner_Table.AUTO_RESIZE_OFF);
			
			int vColIndex = 0;
			int width = 0;
			TableColumn col = Inner_Table.getColumnModel().getColumn(vColIndex);
			width = 30;
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
			width = 235;
			col.setPreferredWidth(width);

			vColIndex = 4;
			col = Inner_Table.getColumnModel().getColumn(vColIndex);
			width = 100;
			col.setPreferredWidth(width);
			
	}
	
	public void shopSearchAction() {
		
		String result = "";
		
		// 콤보박으에서 가져온 문자별로 result변수에 지정문자 대입
		if((String)cbShop.getSelectedItem() == "지점명") {
			result = "shop_name"; // shop 테이블 컬럼명
			
		} else {
			result = "shop_address"; // shop 테이블 컬럼명
			
		} // 두 result값은 sql문 where like절에서 사용

		String ShopText = tfShopText.getText(); // << 이친구도 sql where like절에서 사용
		
		HB_ShopSalesListDao dao = new HB_ShopSalesListDao(result, ShopText); // dao에 값 전달
		ArrayList<HB_shopListDto> dtoList = dao.shopConditionList();
		
		int listCount = dtoList.size();
		
		for(int i = 0; i < listCount; i++) {
			
			String[] qTxt = {Integer.toString(dtoList.get(i).getShop_number()), Integer.toString(dtoList.get(i).getEmployee_id()), 
					dtoList.get(i).getShop_name(), dtoList.get(i).getShop_address(), dtoList.get(i).getShop_telno()};
			
			Outer_Table.addRow(qTxt);
		}
		
		lblListCount.setText("총 " + listCount + "개의 지점이 있습니다.");
		
	}
	
	
	
	private void allShopTotalSales() {
		
		HB_shopListDto dto = null;
		
		HB_ShopSalesListDao dao = new HB_ShopSalesListDao();

		dto = dao.allShopTotalSales();
		lblTotalSales.setText("오픈 일부터 판매 실적이 가장 높은 지점은 " + dto.getShop_name() + "이고, 총 매출액은 " + dto.getOrder_saleprice() + "원 입니다.");
		
		dto = dao.allShopTodaySales();
		lblTodaySales.setText("금일 판매 실적이 가장 높은 지점은 " + dto.getShop_name() + "이고, 금일 매출액은 " + dto.getOrder_saleprice() + "원 입니다.");
		
		
	}
	
	
	
	
	
	
	
	
	
}// End Line