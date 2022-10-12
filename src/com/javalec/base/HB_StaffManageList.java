package com.javalec.base;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.dao.HB_StaffManageListDao;
import com.javalec.dto.HB_staffManageListDto;
import com.javalec.util.HB_Static;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ListSelectionModel;

public class HB_StaffManageList {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JLabel lblSalesStatus;
	private JLabel lblStaffList;
	private JScrollPane scrollPane;
	private JTable Inner_Table;
	private final DefaultTableModel Outer_Table = new DefaultTableModel();
	private JLabel lblTotalStaffNumber;
	private JLabel lblNewLabel_1_1_2;
	private JComboBox cbStaffInfo;
	private JTextField tfStaffText;
	private JButton btnNewButton;
	private JLabel lblManagerList;
	private JLabel lblManagerInsert;
	private JLabel lblBestProductList;
	private JLabel lblStoreInsert;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HB_StaffManageList window = new HB_StaffManageList();
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
	public HB_StaffManageList() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("알바생 리스트");
		frame.addWindowListener(new WindowAdapter() {

			@Override
			public void windowActivated(WindowEvent e) {
				staffTableInit();
				staffSearchAction();
			}
		});
		frame.setBounds(100, 100, 697, 541);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getLblSalesStatus());
		frame.getContentPane().add(getLblStaffList());
		frame.getContentPane().add(getScrollPane());
		frame.getContentPane().add(getLblTotalStaffNumber());
		frame.getContentPane().add(getLblNewLabel_1_1_2());
		frame.getContentPane().add(getCbStaffInfo());
		frame.getContentPane().add(getTfStaffText());
		frame.getContentPane().add(getBtnNewButton());
		frame.getContentPane().add(getLblManagerList());
		frame.getContentPane().add(getLblManagerInsert());
		frame.getContentPane().add(getLblBestProductList());
		frame.getContentPane().add(getLblStoreInsert());
		frame.getContentPane().add(getBtnNewButton_1());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("MelHor Coffee");
			lblNewLabel.setBackground(new Color(235, 199, 189));
			lblNewLabel.setFont(new Font("굴림", Font.ITALIC, 19));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(0, 0, 683, 69);
			lblNewLabel.setOpaque(true);
		}
		return lblNewLabel;
	}
	
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(115, 106, 568, 372);
			scrollPane.setViewportView(getInner_Table());
		}
		return scrollPane;
	}
	private JLabel getLblTotalStaffNumber() {
		if (lblTotalStaffNumber == null) {
			lblTotalStaffNumber = new JLabel("총 직원 수");
			lblTotalStaffNumber.setBounds(520, 479, 163, 25);
		}
		return lblTotalStaffNumber;
	}
	
	private JComboBox getCbStaffInfo() {
		if (cbStaffInfo == null) {
			cbStaffInfo = new JComboBox();
			cbStaffInfo.setModel(new DefaultComboBoxModel(new String[] {"알바생 이름"}));
			cbStaffInfo.setBounds(115, 69, 125, 39);
		}
		return cbStaffInfo;
	}
	private JTextField getTfStaffText() {
		if (tfStaffText == null) {
			tfStaffText = new JTextField();
			tfStaffText.setBounds(241, 69, 346, 39);
			tfStaffText.setColumns(10);
		}
		return tfStaffText;
	}
	private JLabel getLblSalesStatus() {
		if (lblSalesStatus == null) {
			lblSalesStatus = new JLabel("지점 리스트");
			lblSalesStatus.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					HB_ShopSalesStatusPage.main(null);
					frame.setVisible(false);
					
				}
			});
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
			lblStaffList.setBackground(new Color(235, 199, 189));
			lblStaffList.setHorizontalAlignment(SwingConstants.CENTER);
			lblStaffList.setBounds(0, 108, 114, 39);
			lblStaffList.setOpaque(true);
		}
		return lblStaffList;
	}
	
	private JLabel getLblNewLabel_1_1_2() {
		if (lblNewLabel_1_1_2 == null) {
			lblNewLabel_1_1_2 = new JLabel("고객 만족도");
			lblNewLabel_1_1_2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
				}
			});
			lblNewLabel_1_1_2.setOpaque(true);
			lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_1_2.setForeground(Color.BLACK);
			lblNewLabel_1_1_2.setBackground(new Color(227, 147, 132));
			lblNewLabel_1_1_2.setBounds(0, 147, 114, 39);
		}
		return lblNewLabel_1_1_2;
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
			lblManagerInsert.setBounds(0, 225, 114, 39);
		}
		return lblManagerInsert;
	}
	private JLabel getLblBestProductList() {
		if (lblBestProductList == null) {
			lblBestProductList = new JLabel("인기메뉴 리스트");
			lblBestProductList.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					HB_BestProductList.main(null);
					frame.setVisible(false);
					
				}
			});
			lblBestProductList.setOpaque(true);
			lblBestProductList.setHorizontalAlignment(SwingConstants.CENTER);
			lblBestProductList.setBackground(new Color(235, 199, 189));
			lblBestProductList.setBounds(0, 264, 114, 39);
		}
		return lblBestProductList;
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
			lblStoreInsert.setBounds(0, 303, 114, 39);
		}
		return lblStoreInsert;
	}
	
	// --------------------------------- Action Listener -------------------------------------------
	
	private JTable getInner_Table() {
		if (Inner_Table == null) {
			Inner_Table = new JTable();
			Inner_Table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {

					// Table 데이터 클릭 하였을 경우
					if(e.getButton() == 1) { // 버튼이 눌리면
						
						int i = Inner_Table.getSelectedRow(); // 클릭한 데이터가 몇번째 줄 인지 알려줌
						String wkSequence = (String) Inner_Table.getValueAt(i, 1); // 해당하는 행의 i번째 데이터행 중 2번째에 있는 데이터를 wkSequence 변수에 저장 
//						wkSequence에는 employee_id 값이 저장

						HB_Static.setEmployee_id(Integer.parseInt(wkSequence)); // static으로 employee_id 값을 저장 후 필요할 때 가져와서 사용
						HB_StaffSalesStatus.main(null); // 저장 후 다른 화면 띄워줌
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

					staffTableInit();
					staffSearchAction();
					

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
	
	// -----------------------------------------------------------------------------------
	
	private void staffTableInit() {
		
		Outer_Table.addColumn("이름");
		Outer_Table.addColumn("사원번호");
		Outer_Table.addColumn("전화번호");
		Outer_Table.addColumn("입사날짜");
		
		Outer_Table.setColumnCount(4);
		
		int i = Outer_Table.getRowCount();
		
		for(int j = 0; j < i; j++) {
			Outer_Table.removeRow(0);
		}
		
			Inner_Table.setAutoResizeMode(Inner_Table.AUTO_RESIZE_OFF);
			
			int vColIndex = 0;
			TableColumn col = Inner_Table.getColumnModel().getColumn(vColIndex);
			int width = 141;
			col.setPreferredWidth(width);
	
			vColIndex = 1;
			col = Inner_Table.getColumnModel().getColumn(vColIndex);
			col.setPreferredWidth(width);
	
			vColIndex = 2;
			col = Inner_Table.getColumnModel().getColumn(vColIndex);
			col.setPreferredWidth(width);
	
			vColIndex = 3;
			col = Inner_Table.getColumnModel().getColumn(vColIndex);
			col.setPreferredWidth(width);


	}
	
	// 총 직원 리스트 출력 메소드
	public void staffSearchAction() {
		/* 
		 콤보 박스에서 SelectedItem으로 가져온 값을
		 result 값으로 변환하여 MySQL like문 작성
		*/
		
		String result = "";
		String staffText = tfStaffText.getText();
		
		if ((String) cbStaffInfo.getSelectedItem() == "알바생 이름") {
			result = "e.employee_name"; // employee Table 컬럼명

		}


		HB_StaffManageListDao dao = new HB_StaffManageListDao(result, staffText); // 콤보박스, 텍스트필드 값 Dao로 전달
		
		ArrayList<HB_staffManageListDto> dtoList1 = dao.employeeStaffList();
		
		int listCount = dtoList1.size();

		for (int i = 0; i < listCount; i++) {
			String[] qTxt = {dtoList1.get(i).getEmployee_name(), Integer.toString(dtoList1.get(i).getEmployee_id()), 
							 dtoList1.get(i).getEmployee_telno(), dtoList1.get(i).getEmployee_in_date()};
			
			Outer_Table.addRow(qTxt);
		}
		// 총 직원 수를 listCount의 개수로 출력
		lblTotalStaffNumber.setText("총 직원 수: " + Integer.toString(listCount) + "명");
		
	}

	
	
	
	
	
	
	
	
	
	
} // End Line