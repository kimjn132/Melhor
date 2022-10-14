package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.javalec.dao.AdminRevenueDetailDao;
import com.javalec.dto.AdminRevenueDetailDto;
import com.javalec.util.StaticClass;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;

public class AdminRevenueDetail {

	private JFrame frame;
	private JLabel lblArrow;
	private JLabel lblNewLabel;
	private JLabel lblStore;
	private JLabel lblNew3333;
	private JLabel lblNewLabel_1_2;
	private JLabel lblEm;
	private JLabel lblImage;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_2_1;
	private JLabel lblNewLabel_2_2;
	private JLabel lblNewLabel_2_3;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_3_1;
	private JTextField tfProductId;
	private JTextField tfProductName;
	private JTextField tfProductCategory;
	private JTextField tfProductPrice;
	private JTextField tfDayQuantity;
	private JTextField tfMonthQuantity;
	private JLabel lblUpDownMonth;
	private JLabel lblUpDown_1;
	private JLabel lblUpDown_2;
	private JLabel lblUpDown_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminRevenueDetail window = new AdminRevenueDetail();
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
	public AdminRevenueDetail() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			// 윈도우 켜질 때 세팅하기
			@Override
			public void windowActivated(WindowEvent e) {
				productDetail();
				dayQuatityAvg();
				monthQuantityAvg();
			}
		});
		frame.getContentPane().setBackground(new Color(247, 243, 243));
		frame.setTitle("제품별 매출 상세");
		frame.setBounds(100, 100, 600, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblEm());
		frame.getContentPane().add(getLblArrow());
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getLblStore());
		frame.getContentPane().add(getLblNew3333());
		frame.getContentPane().add(getLblNewLabel_1_2());
		frame.getContentPane().add(getLblImage());
		frame.getContentPane().add(getLblNewLabel_2());
		frame.getContentPane().add(getLblNewLabel_2_1());
		frame.getContentPane().add(getLblNewLabel_2_2());
		frame.getContentPane().add(getLblNewLabel_2_3());
		frame.getContentPane().add(getLblNewLabel_3());
		frame.getContentPane().add(getLblNewLabel_3_1());
		frame.getContentPane().add(getTfProductId());
		frame.getContentPane().add(getTfProductName());
		frame.getContentPane().add(getTfProductCategory());
		frame.getContentPane().add(getTfProductPrice());
		frame.getContentPane().add(getTfDayQuantity());
		frame.getContentPane().add(getTfMonthQuantity());
		frame.getContentPane().add(getLblUpDownMonth());
		frame.getContentPane().add(getLblUpDown_1());
		frame.getContentPane().add(getLblUpDown_2());
		frame.getContentPane().add(getLblUpDown_3());
	}

	private JLabel getLblArrow() {
		if (lblArrow == null) {
			lblArrow = new JLabel("");
			lblArrow.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					frame.setVisible(false);
					AdminRevenue.main(null);
				}
			});
			lblArrow.setBounds(10, 2, 35, 35);
			ImageIcon icon = new ImageIcon(AdminRevenueDetail.class.getResource("/com/javalec/image/leftarrow.png"));
			Image img = icon.getImage(); // ImageIcon을 Image로 변환.
			Image updateImg = img.getScaledInstance(25, 15, java.awt.Image.SCALE_SMOOTH);
			ImageIcon updateIcon = new ImageIcon(updateImg);

			lblArrow.setIcon(updateIcon);
		}
		return lblArrow;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Melhor Coffee");
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 18));
			lblNewLabel.setBounds(182, 10, 142, 23);
		}
		return lblNewLabel;
	}

	private JLabel getLblStore() {
		if (lblStore == null) {
			lblStore = new JLabel("지점");
			lblStore.setForeground(new Color(60, 143, 96));
			lblStore.setFont(new Font("굴림", Font.PLAIN, 15));
			lblStore.setBounds(355, 10, 50, 23);
			lblStore.setText(StaticClass.shop_name);
		}
		return lblStore;
	}

	private JLabel getLblNew3333() {
		if (lblNew3333 == null) {
			lblNew3333 = new JLabel("");
			lblNew3333.setOpaque(true);
			lblNew3333.setForeground(new Color(255, 204, 204));
			lblNew3333.setBackground(new Color(235, 199, 189));
			lblNew3333.setBounds(0, 0, 586, 40);
		}
		return lblNew3333;
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

	private JLabel getLblEm() {
		if (lblEm == null) {
			lblEm = new JLabel("null님");
			lblEm.setForeground(new Color(60, 143, 96));
			lblEm.setFont(new Font("굴림", Font.BOLD, 15));
			lblEm.setBounds(45, 10, 81, 22);
			lblEm.setText(StaticClass.employee_name+ "님");
		}
		return lblEm;
	}

	private JLabel getLblImage() {
		if (lblImage == null) {
			lblImage = new JLabel("");
			lblImage.setBounds(36, 80, 201, 123);
		}
		return lblImage;
	}

	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("제품 번호");
			lblNewLabel_2.setBounds(280, 75, 64, 15);
		}
		return lblNewLabel_2;
	}

	private JLabel getLblNewLabel_2_1() {
		if (lblNewLabel_2_1 == null) {
			lblNewLabel_2_1 = new JLabel("제품 이름");
			lblNewLabel_2_1.setBounds(280, 103, 64, 15);
		}
		return lblNewLabel_2_1;
	}

	private JLabel getLblNewLabel_2_2() {
		if (lblNewLabel_2_2 == null) {
			lblNewLabel_2_2 = new JLabel("카테고리");
			lblNewLabel_2_2.setBounds(280, 131, 64, 15);
		}
		return lblNewLabel_2_2;
	}

	private JLabel getLblNewLabel_2_3() {
		if (lblNewLabel_2_3 == null) {
			lblNewLabel_2_3 = new JLabel("가격");
			lblNewLabel_2_3.setBounds(280, 172, 64, 15);
		}
		return lblNewLabel_2_3;
	}

	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("작일 판매 수량");
			lblNewLabel_3.setBounds(280, 213, 110, 15);
		}
		return lblNewLabel_3;
	}

	private JLabel getLblNewLabel_3_1() {
		if (lblNewLabel_3_1 == null) {
			lblNewLabel_3_1 = new JLabel("전월 판매 수량");
			lblNewLabel_3_1.setBounds(280, 241, 110, 15);
		}
		return lblNewLabel_3_1;
	}

	private JTextField getTfProductId() {
		if (tfProductId == null) {
			tfProductId = new JTextField();
			tfProductId.setEditable(false);
			tfProductId.setBounds(409, 70, 96, 17);
			tfProductId.setColumns(10);
		}
		return tfProductId;
	}

	private JTextField getTfProductName() {
		if (tfProductName == null) {
			tfProductName = new JTextField();
			tfProductName.setEditable(false);
			tfProductName.setColumns(10);
			tfProductName.setBounds(409, 100, 96, 17);
		}
		return tfProductName;
	}

	private JTextField getTfProductCategory() {
		if (tfProductCategory == null) {
			tfProductCategory = new JTextField();
			tfProductCategory.setEditable(false);
			tfProductCategory.setColumns(10);
			tfProductCategory.setBounds(409, 128, 96, 17);
		}
		return tfProductCategory;
	}

	private JTextField getTfProductPrice() {
		if (tfProductPrice == null) {
			tfProductPrice = new JTextField();
			tfProductPrice.setEditable(false);
			tfProductPrice.setColumns(10);
			tfProductPrice.setBounds(409, 169, 96, 17);
		}
		return tfProductPrice;
	}

	private JTextField getTfDayQuantity() {
		if (tfDayQuantity == null) {
			tfDayQuantity = new JTextField();
			tfDayQuantity.setEditable(false);
			tfDayQuantity.setColumns(10);
			tfDayQuantity.setBounds(409, 210, 96, 17);
		}
		return tfDayQuantity;
	}

	private JTextField getTfMonthQuantity() {
		if (tfMonthQuantity == null) {
			tfMonthQuantity = new JTextField();
			tfMonthQuantity.setEditable(false);
			tfMonthQuantity.setColumns(10);
			tfMonthQuantity.setBounds(409, 238, 96, 17);
		}
		return tfMonthQuantity;
	}

	private JLabel getLblUpDownMonth() {
		if (lblUpDownMonth == null) {
			lblUpDownMonth = new JLabel("");
			lblUpDownMonth.setBounds(517, 238, 15, 15);
		}
		return lblUpDownMonth;
	}
	private JLabel getLblUpDown_1() {
		if (lblUpDown_1 == null) {
			lblUpDown_1 = new JLabel("");
			lblUpDown_1.setBounds(517, 277, 15, 15);
		}
		return lblUpDown_1;
	}
	private JLabel getLblUpDown_2() {
		if (lblUpDown_2 == null) {
			lblUpDown_2 = new JLabel("");
			lblUpDown_2.setBounds(517, 241, 15, 15);
		}
		return lblUpDown_2;
	}
	private JLabel getLblUpDown_3() {
		if (lblUpDown_3 == null) {
			lblUpDown_3 = new JLabel("");
			lblUpDown_3.setBounds(517, 311, 15, 15);
		}
		return lblUpDown_3;
	}
	// ======================================================= 메소드
	// ==================================================

	public void productDetail() {

		AdminRevenueDetailDao dao = new AdminRevenueDetailDao();
		AdminRevenueDetailDto dto = dao.productDetail();
		
		// tf에 가져온 데이터 세팅
		tfProductId.setText(Integer.toString(dto.getWkId()));
		tfProductName.setText(dto.getWkName());
		tfProductCategory.setText(dto.getWkCategory());
		tfProductPrice.setText(Integer.toString(dto.getWkPrice()));
		
		// Image처리
        // File name이 틀려야 즉각 보여주기가 가능하여   
        // ShareVar에서 int값으로 정의하여 계속 증가하게 하여 file name으로 사용후 삭제
        
		String filePath = Integer.toString(StaticClass.filename);
		
		lblImage.setIcon(new ImageIcon(filePath));
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		
		File file = new File(filePath);
		file.delete();
		
	}

	// 일 매출 수량 세팅
	public void dayQuatityAvg() {
		
		AdminRevenueDetailDao dao = new AdminRevenueDetailDao();
		AdminRevenueDetailDto dto = dao.dayQuatityAvg();
		
		tfDayQuantity.setText(Double.toString(dto.getWkAvg()));
		System.out.println("일 평균 " +Double.toString(dto.getWkAvg()));
		
	}
	
	// 월 매출 수량 세팅
	private void monthQuantityAvg() {

		AdminRevenueDetailDao dao = new AdminRevenueDetailDao(); // 연결
		ArrayList<AdminRevenueDetailDto> dtoList = dao.selectList(); 
		// Dao의 selectList 메소드 실행시켜 arrayList로 만든 후, dtoList에 저장
		
		//int listCount = dtoList.size(); // 데이터의 열의 수를 나타냄

		// 정보 tf에 넣기
		tfMonthQuantity.setText(Double.toString(dtoList.get(0).getWkAvg()));
		
		// 전월과 비교
		double lastMonth = dtoList.get(0).getWkAvg();
		double thisMonth = dtoList.get(1).getWkAvg();
		System.out.println("lastM: " + lastMonth+ " thisM: " +thisMonth);
		
		if(thisMonth > lastMonth) {
			ImageIcon icon = new ImageIcon(AdminRevenueDetail.class.getResource("/com/javalec/image/uparrow.png"));
			Image img = icon.getImage(); // ImageIcon을 Image로 변환.
			Image updateImg = img.getScaledInstance(10, 10, java.awt.Image.SCALE_SMOOTH);
			ImageIcon updateIcon = new ImageIcon(updateImg);
			lblUpDownMonth.setIcon(updateIcon);
		}else if(thisMonth < lastMonth) {
			ImageIcon icon = new ImageIcon(AdminRevenueDetail.class.getResource("/com/javalec/image/downarrow.png"));
			Image img = icon.getImage(); // ImageIcon을 Image로 변환.
			Image updateImg = img.getScaledInstance(10, 10, java.awt.Image.SCALE_SMOOTH);
			ImageIcon updateIcon = new ImageIcon(updateImg);
			lblUpDownMonth.setIcon(updateIcon);
		}

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}// END
