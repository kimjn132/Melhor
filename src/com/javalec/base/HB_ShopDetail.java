package com.javalec.base;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.javalec.dao.HB_ShopSalesListDao;
import com.javalec.dto.HB_shopListDto;
import com.javalec.util.HB_Static;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HB_ShopDetail {

	private JFrame frame;
	private JLabel lblNewLabel;
	private final DefaultTableModel Outer_Table = new DefaultTableModel();
	private JLabel lblNewLabel_1;
	private JTextField tfShopNumber;
	private JLabel lblNewLabel_1_1;
	private JTextField tfShopEmployeeId;
	private JLabel lblNewLabel_1_2;
	private JTextField tfShopName;
	private JLabel lblNewLabel_1_3;
	private JTextField tfShopAddress;
	private JLabel lblNewLabel_1_4;
	private JTextField tfShopTelno;
	private JLabel lblDay;
	private JTextField tfShopDaySales;
	private JLabel lblMonth;
	private JTextField tfShopMonthSales;
	private JLabel lblNewLabel_1_4_3;
	private JTextField tfShopTotalSales;
	private JButton btnOk;
	private JRadioButton rbUpdate;
	private JComboBox cbDayDate;
	private JLabel lblNewLabel_2;
	private JComboBox cbMonthDate;
	private JLabel lblNewLabel_2_1;
	private JLabel lblMonthDay;
	private JTextField tfMonthDay;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HB_ShopDetail window = new HB_ShopDetail();
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
	public HB_ShopDetail() {
		initialize();
		ScreenPartition();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("지점 세부사항");
		frame.addWindowListener(new WindowAdapter() {

			@Override
			public void windowActivated(WindowEvent e) {
				
				
				shopDetail();
//				shopDetailSearchAction();
				
			}
		});
		frame.setBounds(100, 100, 697, 541);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getTfShopNumber());
		frame.getContentPane().add(getLblNewLabel_1_1());
		frame.getContentPane().add(getTfShopEmployeeId());
		frame.getContentPane().add(getLblNewLabel_1_2());
		frame.getContentPane().add(getTfShopName());
		frame.getContentPane().add(getLblNewLabel_1_3());
		frame.getContentPane().add(getTfShopAddress());
		frame.getContentPane().add(getLblNewLabel_1_4());
		frame.getContentPane().add(getTfShopTelno());
		frame.getContentPane().add(getLblDay());
		frame.getContentPane().add(getTfShopDaySales());
		frame.getContentPane().add(getLblMonth());
		frame.getContentPane().add(getTfShopMonthSales());
		frame.getContentPane().add(getLblNewLabel_1_4_3());
		frame.getContentPane().add(getTfShopTotalSales());
		frame.getContentPane().add(getBtnOk());
		frame.getContentPane().add(getRbUpdate());
		frame.getContentPane().add(getCbDayDate());
		frame.getContentPane().add(getLblNewLabel_2());
		frame.getContentPane().add(getCbMonthDate());
		frame.getContentPane().add(getLblNewLabel_2_1());
		frame.getContentPane().add(getLblMonthDay());
		frame.getContentPane().add(getTfMonthDay());
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
	private JLabel getLblMonthDay() {
		if (lblMonthDay == null) {
			lblMonthDay = new JLabel("");
			lblMonthDay.setHorizontalAlignment(SwingConstants.CENTER);
			lblMonthDay.setBounds(152, 372, 131, 24);
		}
		return lblMonthDay;
	}
	private JTextField getTfMonthDay() {
		if (tfMonthDay == null) {
			tfMonthDay = new JTextField();
			tfMonthDay.setColumns(10);
			tfMonthDay.setBounds(295, 373, 195, 24);
		}
		return tfMonthDay;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("일");
			lblNewLabel_2.setBounds(555, 338, 28, 24);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_2_1() {
		if (lblNewLabel_2_1 == null) {
			lblNewLabel_2_1 = new JLabel("월");
			lblNewLabel_2_1.setBounds(555, 303, 28, 24);
		}
		return lblNewLabel_2_1;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("지점 번호 ");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setBounds(195, 114, 88, 24);
		}
		return lblNewLabel_1;
	}
	private JTextField getTfShopNumber() {
		if (tfShopNumber == null) {
			tfShopNumber = new JTextField();
			tfShopNumber.setBounds(295, 115, 195, 24);
			tfShopNumber.setColumns(10);
		}
		return tfShopNumber;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("지점장 사원번호 ");
			lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_1.setBounds(163, 148, 120, 24);
		}
		return lblNewLabel_1_1;
	}
	private JTextField getTfShopEmployeeId() {
		if (tfShopEmployeeId == null) {
			tfShopEmployeeId = new JTextField();
			tfShopEmployeeId.setColumns(10);
			tfShopEmployeeId.setBounds(295, 149, 195, 24);
		}
		return tfShopEmployeeId;
	}
	private JLabel getLblNewLabel_1_2() {
		if (lblNewLabel_1_2 == null) {
			lblNewLabel_1_2 = new JLabel("지점명  ");
			lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_2.setBounds(195, 182, 88, 24);
		}
		return lblNewLabel_1_2;
	}
	private JTextField getTfShopName() {
		if (tfShopName == null) {
			tfShopName = new JTextField();
			tfShopName.setColumns(10);
			tfShopName.setBounds(295, 183, 195, 24);
		}
		return tfShopName;
	}
	private JLabel getLblNewLabel_1_3() {
		if (lblNewLabel_1_3 == null) {
			lblNewLabel_1_3 = new JLabel("지점 주소 ");
			lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_3.setBounds(179, 216, 104, 24);
		}
		return lblNewLabel_1_3;
	}
	private JTextField getTfShopAddress() {
		if (tfShopAddress == null) {
			tfShopAddress = new JTextField();
			tfShopAddress.setColumns(10);
			tfShopAddress.setBounds(295, 217, 195, 24);
		}
		return tfShopAddress;
	}
	private JLabel getLblNewLabel_1_4() {
		if (lblNewLabel_1_4 == null) {
			lblNewLabel_1_4 = new JLabel("지점 전화번호");
			lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_4.setBounds(179, 250, 104, 24);
		}
		return lblNewLabel_1_4;
	}
	private JTextField getTfShopTelno() {
		if (tfShopTelno == null) {
			tfShopTelno = new JTextField();
			tfShopTelno.setColumns(10);
			tfShopTelno.setBounds(295, 251, 195, 24);
		}
		return tfShopTelno;
	}
	private JLabel getLblDay() {
		if (lblDay == null) {
			lblDay = new JLabel("일 매출액");
			lblDay.setHorizontalAlignment(SwingConstants.CENTER);
			lblDay.setBounds(152, 338, 131, 24);
		}
		return lblDay;
	}
	private JTextField getTfShopDaySales() {
		if (tfShopDaySales == null) {
			tfShopDaySales = new JTextField();
			tfShopDaySales.setColumns(10);
			tfShopDaySales.setBounds(295, 339, 195, 24);
		}
		return tfShopDaySales;
	}
	private JLabel getLblMonth() {
		if (lblMonth == null) {
			lblMonth = new JLabel("이번달 매출액");
			lblMonth.setHorizontalAlignment(SwingConstants.CENTER);
			lblMonth.setBounds(179, 303, 104, 24);
		}
		return lblMonth;
	}
	private JTextField getTfShopMonthSales() {
		if (tfShopMonthSales == null) {
			tfShopMonthSales = new JTextField();
			tfShopMonthSales.setColumns(10);
			tfShopMonthSales.setBounds(295, 304, 195, 24);
		}
		return tfShopMonthSales;
	}
	private JLabel getLblNewLabel_1_4_3() {
		if (lblNewLabel_1_4_3 == null) {
			lblNewLabel_1_4_3 = new JLabel("총 매출액");
			lblNewLabel_1_4_3.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_4_3.setBounds(179, 406, 104, 24);
		}
		return lblNewLabel_1_4_3;
	}
	private JTextField getTfShopTotalSales() {
		if (tfShopTotalSales == null) {
			tfShopTotalSales = new JTextField();
			tfShopTotalSales.setColumns(10);
			tfShopTotalSales.setBounds(295, 407, 195, 24);
		}
		return tfShopTotalSales;
	}
	
	// --------------------------------- Action Listener -------------------------------------------
	
	private JButton getBtnOk() {
		if (btnOk == null) {
			btnOk = new JButton("확인");
			btnOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
						if(rbUpdate.isSelected() == true) {
							shopDetailListUpdate();
							
						} else {
							HB_ShopSalesStatusPage.main(null);
							frame.setVisible(false);
							
						}
					
				}
			});
			btnOk.setBounds(269, 456, 170, 38);
		}
		return btnOk;
	}
	private JRadioButton getRbUpdate() {
		if (rbUpdate == null) {
			rbUpdate = new JRadioButton("수정하기");
			rbUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ScreenPartition();
				}
			});
			rbUpdate.setBounds(295, 75, 113, 23);
		}
		return rbUpdate;
	}
	private JComboBox getCbDayDate() {
		if (cbDayDate == null) {
			cbDayDate = new JComboBox();
			cbDayDate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					HB_Static.setDay(Integer.parseInt((String)cbDayDate.getSelectedItem()));
					lblDay.setText("이번달 " + Integer.toString(HB_Static.getDay()) + "일 매출액");
					lblMonthDay.setText(HB_Static.getMonth() + "월 " + HB_Static.getDay() + "일");
					shopDetail();
					
				}
			});
			cbDayDate.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
			cbDayDate.setBounds(513, 339, 40, 23);
		}
		return cbDayDate;
	}
	private JComboBox getCbMonthDate() {
		if (cbMonthDate == null) {
			cbMonthDate = new JComboBox();
			cbMonthDate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					HB_Static.setMonth(Integer.parseInt((String)cbMonthDate.getSelectedItem()));
					lblMonth.setText("올해 " + Integer.toString(HB_Static.getMonth()) + "월 매출액");
					lblMonthDay.setText(HB_Static.getMonth() + "월 " + HB_Static.getDay() + "일");
					shopDetail();
				}
			});
			cbMonthDate.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
			cbMonthDate.setBounds(513, 304, 40, 23);
		}
		return cbMonthDate;
	}
	
	// --------------------------------- Action Listener -------------------------------------------
	
	// -------------------------------------------------------------------------------
	
	private void ScreenPartition() {
		if(rbUpdate.isSelected() == true) {
			tfShopNumber.setEditable(false);
			tfShopDaySales.setEditable(false);
			tfShopMonthSales.setEditable(false);
			tfShopTotalSales.setEditable(false);
			tfMonthDay.setEditable(false);
			
			tfShopEmployeeId.setEditable(true);
			tfShopName.setEditable(true);
			tfShopAddress.setEditable(true);
			tfShopTelno.setEditable(true);
			
		}
		
		if(rbUpdate.isSelected() == false) {
			tfShopNumber.setEditable(false);
			tfShopEmployeeId.setEditable(false);
			tfShopName.setEditable(false);
			tfShopAddress.setEditable(false);
			tfShopTelno.setEditable(false);
			tfShopDaySales.setEditable(false);
			tfShopMonthSales.setEditable(false);
			tfShopTotalSales.setEditable(false);
			tfMonthDay.setEditable(false);
			
		}
	}
	
	// 지점 총 리스트 출력
	private void shopDetail() {
		
		HB_ShopSalesListDao dao = new HB_ShopSalesListDao(HB_Static.shop_number);
		HB_shopListDto dtoList = dao.shopDetailList();
		
		tfShopNumber.setText(Integer.toString(dtoList.getShop_number()));
		tfShopEmployeeId.setText(Integer.toString(dtoList.getEmployee_id()));
		tfShopName.setText(dtoList.getShop_name());
		tfShopAddress.setText(dtoList.getShop_address());
		tfShopTelno.setText(dtoList.getShop_telno());
		
		int daySales = dao.shopDaySales(HB_Static.getDay());
		tfShopDaySales.setText(Integer.toString(daySales) + "원");
		
		int monthSales = dao.shopMonthSales(HB_Static.getMonth());
		tfShopMonthSales.setText(Integer.toString(monthSales) + "원");
		
		int monthDaySales = dao.shopMonthDaySales(HB_Static.getMonth(), HB_Static.getDay());
		tfMonthDay.setText(Integer.toString(monthDaySales) + "원");
		
		int totalSales = dao.shopTotalSales();
		tfShopTotalSales.setText(Integer.toString(totalSales) + "원");
		
	}
	
	// 지점 상세정보 수정
	private void shopDetailListUpdate() {
		
		int shop_number = Integer.parseInt(tfShopNumber.getText());
		int shop_employee_id = Integer.parseInt(tfShopEmployeeId.getText());
		String shop_name = tfShopName.getText();
		String shop_address = tfShopAddress.getText();
		String shop_telno = tfShopTelno.getText();
		
		HB_ShopSalesListDao dao = new HB_ShopSalesListDao(shop_number, shop_employee_id, shop_name, shop_address ,shop_telno);
		boolean TF = dao.shopDetailListUpdate();
		
		if(TF == true) {
			JOptionPane.showMessageDialog(null, "수정 되었습니다.");
			HB_ShopSalesStatusPage.main(null);
			frame.setVisible(false);
			
		} else {
			JOptionPane.showMessageDialog(null, "Error");			
		}
		
	}
	
} // End Line
