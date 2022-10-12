package com.javalec.base;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.javalec.dao.HB_ManagerAppointDao;
import com.javalec.dao.HB_ShopInsertDao;
import com.javalec.util.HB_Static;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HB_ShopInsert {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JLabel lblSalesStatus;
	private JLabel lblStaffList;
	private JLabel lblNewLabel_1_1_2;
	private JLabel lblManagerList;
	private JLabel lblManagerInsert;
	private JLabel lblBestProductList;
	private JLabel lblStoreInsert;
	private JLabel lblNewLabel_1;
	private JTextField tfShopName;
	private JLabel lblNewLabel_1_1;
	private JTextField tfShopAddress;
	private JLabel lblNewLabel_1_1_1;
	private JTextField tfShopTelno;
	private JButton btnShopInsert;
	private JLabel lblNewLabel_1_2;
	private JTextField tfEmployeeId;
	private JButton btnRename;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HB_ShopInsert window = new HB_ShopInsert();
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
	public HB_ShopInsert() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("지점 등록하기");
		frame.setBounds(100, 100, 697, 541);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getLblSalesStatus());
		frame.getContentPane().add(getLblStaffList());
		frame.getContentPane().add(getLblNewLabel_1_1_2());
		frame.getContentPane().add(getLblManagerList());
		frame.getContentPane().add(getLblManagerInsert());
		frame.getContentPane().add(getLblBestProductList());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getTextField_1());
		frame.getContentPane().add(getLblNewLabel_1_1());
		frame.getContentPane().add(getTextField_1_1());
		frame.getContentPane().add(getLblNewLabel_1_1_1());
		frame.getContentPane().add(getTfShopTelno());
		frame.getContentPane().add(getBtnShopInsert());
		frame.getContentPane().add(getLblStoreInsert());
		frame.getContentPane().add(getLblNewLabel_1_2());
		frame.getContentPane().add(getTfEmployeeId());
		frame.getContentPane().add(getBtnRename());
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

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("지점명 :");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setBounds(260, 165, 88, 27);
		}
		return lblNewLabel_1;
	}
	private JTextField getTextField_1() {
		if (tfShopName == null) {
			tfShopName = new JTextField();
			tfShopName.setBounds(360, 165, 149, 27);
			tfShopName.setColumns(10);
		}
		return tfShopName;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("지점 주소 :");
			lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_1.setBounds(260, 198, 88, 27);
		}
		return lblNewLabel_1_1;
	}
	private JTextField getTextField_1_1() {
		if (tfShopAddress == null) {
			tfShopAddress = new JTextField();
			tfShopAddress.setColumns(10);
			tfShopAddress.setBounds(360, 198, 149, 27);
		}
		return tfShopAddress;
	}
	private JLabel getLblNewLabel_1_1_1() {
		if (lblNewLabel_1_1_1 == null) {
			lblNewLabel_1_1_1 = new JLabel("지점 전화번호 :");
			lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_1_1.setBounds(249, 237, 99, 27);
		}
		return lblNewLabel_1_1_1;
	}
	private JTextField getTfShopTelno() {
		if (tfShopTelno == null) {
			tfShopTelno = new JTextField();
			tfShopTelno.setColumns(10);
			tfShopTelno.setBounds(360, 237, 149, 27);
		}
		return tfShopTelno;
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
	private JLabel getLblNewLabel_1_2() {
		if (lblNewLabel_1_2 == null) {
			lblNewLabel_1_2 = new JLabel("점장 ID :");
			lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_2.setBounds(260, 128, 88, 27);
		}
		return lblNewLabel_1_2;
	}
	private JTextField getTfEmployeeId() {
		if (tfEmployeeId == null) {
			tfEmployeeId = new JTextField();
			tfEmployeeId.setColumns(10);
			tfEmployeeId.setBounds(360, 128, 149, 27);
		}
		return tfEmployeeId;
	}
	
	// --------------------------------- Action Listener -------------------------------------------
	
	private JButton getBtnRename() {
		if (btnRename == null) {
			btnRename = new JButton("ID 다시 입력하기");
			btnRename.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					tfEmployeeId.setEditable(true);
					tfEmployeeId.setText("");
					tfEmployeeId.requestFocus();
					
				}
			});
			btnRename.setBounds(523, 124, 128, 31);
		}
		return btnRename;
	}
	private JButton getBtnShopInsert() {
		if (btnShopInsert == null) {
			btnShopInsert = new JButton("등록하기");
			btnShopInsert.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					int tfcheck = insertFieldCheck();
					if(tfcheck == 0) {
						if(tfEmployeeId.isEditable() == true) {
							employeeIdCheck(); // 데이터 입력
							
						} else if(tfEmployeeId.isEditable() == false) {
							shopInsertCheck();
						}
					}
					
				}
			});
			btnShopInsert.setBounds(296, 309, 180, 27);
		}
		return btnShopInsert;
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
	
	// -----------------------------------------------------------------------------
	
	// 텍스트 필드 공백 확인하는 메소드
	private int insertFieldCheck() {
		
		int i = 0;
		String result = "";
		
		if(tfEmployeeId.getText().trim().length() == 0) {
			i++;
			result = "사원번호를 ";
			tfEmployeeId.requestFocus();
			
		} else if(tfShopName.getText().trim().length() == 0) {
			i++;
			result = "지점명을 ";
			tfShopName.requestFocus();
			
		} else if(tfShopAddress.getText().trim().length() == 0) {
			i++;
			result = "지점 주소를 ";
			tfShopAddress.requestFocus();
			
		} else if(tfShopTelno.getText().trim().length() == 0) {
			i++;
			result = "지점 전화번호를 ";
			tfShopTelno.requestFocus();
			
		}
		
		if(i > 0) {
			JOptionPane.showMessageDialog(null, result + "확인하세요!");
		}
		
		return i;
	}
	
	// 지점 등록하기 전 점장ID가 등록 되어있는지 확인하는 메소드
	private void employeeIdCheck() {
		
		int employee_id = Integer.parseInt(tfEmployeeId.getText().trim());
		
		HB_ShopInsertDao dao = new HB_ShopInsertDao(employee_id); // 텍스트 필드에 employee_id값을 dao로 전달
		int check = dao.employeeIdCheck();
		
		if(check == 1) { // 값이 1이면 등록되어 있는 ID이니 다음 메소드 실행
			shopInsertCheck(); // <<
			tfEmployeeId.setEditable(false); // 수정하지 못하게 막아줌
			
		} else { // 값이 0이면 MessageDialog창 띄워줌
			JOptionPane.showMessageDialog(null, employee_id + "는(은) 등록되어 있지 않은 점장 ID입니다.");
			tfEmployeeId.setText(""); // 텍스트 필드 초기화
			tfEmployeeId.requestFocus(); // 해당 텍스트 필드로 커서 이동
			
		}
		
	}
	
	// 작성한 텍스트 필드 값이 존재하는 지점인지 판단하는 메소드
	private void shopInsertCheck() {
		
		// 3개의 텍스트 필드 중 단 하나의 값이라도 DB에 저장 되어있으면 등록이 안 됨 (중복체크)
		String shop_name = tfShopName.getText().trim();
		String shop_address = tfShopAddress.getText().trim();
		String shop_telno = tfShopTelno.getText().trim();

		HB_ShopInsertDao dao = new HB_ShopInsertDao(shop_name, shop_address, shop_telno);
		
		int check = dao.shopDataCheck();
		
		if(check > 0) { // 0보다 크면 즉 1이상이면 MessageDialog창 띄워줌
			JOptionPane.showMessageDialog(null, "해당 Data가 존재합니다. \n 다른 Data를 입력하세요.");
			
		} else { // check가 0이면 텍스트 필드값을 다음 메소드로 전달해줌
			shopInsert(shop_name, shop_address, shop_telno);
		}
		
	}
	
	// 지점 등록 메소드
	private void shopInsert(String shop_name, String shop_address, String shop_telno) { // 텍스트 필드 값 받아옴
		
		int employee_id = Integer.parseInt(tfEmployeeId.getText().trim());
		
		HB_ShopInsertDao dao = new HB_ShopInsertDao(employee_id, shop_name, shop_address, shop_telno); // dao로 전달
		int check = dao.shopInsert();
		
		if(check == 1) { // 성공 후 MessageDialog창 띄워줌
			JOptionPane.showMessageDialog(null, "'" + shop_name + "' 지점이 등록 되었습니다.");
			HB_ShopSalesStatusPage.main(null);
			frame.setVisible(false);
			
		} else {
			JOptionPane.showMessageDialog(null, "Error");
			
		}
		
	}
	
} // End Line
