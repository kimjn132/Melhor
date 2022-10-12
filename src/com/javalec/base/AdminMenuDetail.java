package com.javalec.base;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.javalec.dao.AdminMenuDetailDao;
import com.javalec.dao.AdminMenuInsertDao;
import com.javalec.dto.AdminMenuDetailDto;
import com.javalec.util.StaticClass;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class AdminMenuDetail extends JFrame {

	private JFrame frame;
	private JLabel lblProductName;
	private JLabel lblProductId;
	private JLabel lblProductPrice;
	private JLabel lblProductRecipe;
	private JLabel lblProductExplain;
	private JLabel lblProductCategory;
	private JLabel lblNewLabel;
	private JLabel lblEm;
	private JLabel lblNewLabel_1_1_5;
	private JLabel lblStore;
	private JLabel lblNewLabel_1_2;
	private JLabel lblArrow;
	private JLabel lblImage;
	private JLabel lblGoHome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminMenuDetail window = new AdminMenuDetail();
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
	public AdminMenuDetail() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			// ************************* 윈도우 이벤트*************************
			@Override
			public void windowActivated(WindowEvent e) {
				menuDetail();
			}
		});
		frame.getContentPane().setBackground(new Color(247, 243, 243));
		frame.setTitle("제품 등록");
		frame.setBounds(100, 100, 600, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblImage = new JLabel("image");
		lblImage.setBounds(99, 120, 90, 90);
		frame.getContentPane().add(lblImage);
		frame.getContentPane().add(getLblArrow());
		frame.getContentPane().add(getLblGoHome());
		frame.getContentPane().add(getLblEm());
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getLblStore());
		frame.getContentPane().add(getLblNewLabel_1_1_5());
		

		JLabel lblNewLabel_1_1 = new JLabel("제품번호");
		lblNewLabel_1_1.setBounds(55, 250, 50, 15);
		frame.getContentPane().add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("가격");
		lblNewLabel_1_1_1.setBounds(55, 320, 35, 15);
		frame.getContentPane().add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_2 = new JLabel("레시피");
		lblNewLabel_1_1_2.setBounds(319, 75, 64, 15);
		frame.getContentPane().add(lblNewLabel_1_1_2);

		JLabel lblNewLabel_1_1_3 = new JLabel("제품 설명");
		lblNewLabel_1_1_3.setBounds(319, 251, 64, 15);
		frame.getContentPane().add(lblNewLabel_1_1_3);

		JButton btnMenuInsert = new JButton("등록");
		// *****************************메뉴 등록 버튼 이벤트********************
		btnMenuInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuInsertAction();
			}
		});
		btnMenuInsert.setBounds(504, 378, 70, 30);
		frame.getContentPane().add(btnMenuInsert);

		lblProductName = new JLabel("New label");
		lblProductName.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductName.setFont(new Font("굴림", Font.BOLD, 15));
		lblProductName.setBounds(43, 73, 189, 30);
		frame.getContentPane().add(lblProductName);

		lblProductId = new JLabel("New label");
		lblProductId.setBounds(120, 250, 75, 15);
		frame.getContentPane().add(lblProductId);

		lblProductPrice = new JLabel("New label");
		lblProductPrice.setBounds(120, 320, 75, 15);
		frame.getContentPane().add(lblProductPrice);

		lblProductRecipe = new JLabel("New label");
		lblProductRecipe.setBounds(319, 113, 225, 121);
		frame.getContentPane().add(lblProductRecipe);

		lblProductExplain = new JLabel("New label");
		lblProductExplain.setBounds(319, 276, 225, 60);
		frame.getContentPane().add(lblProductExplain);

		JLabel lblNewLabel_1_1_4 = new JLabel("카테고리");
		lblNewLabel_1_1_4.setBounds(55, 285, 50, 15);
		frame.getContentPane().add(lblNewLabel_1_1_4);

		lblProductCategory = new JLabel("New label");
		lblProductCategory.setBounds(120, 285, 75, 15);
		frame.getContentPane().add(lblProductCategory);
		frame.getContentPane().add(getLblNewLabel_1_2());
		
		
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
	private JLabel getLblEm() {
		if (lblEm == null) {
			lblEm = new JLabel("null님");
			lblEm.setForeground(new Color(60, 143, 96));
			lblEm.setFont(new Font("굴림", Font.PLAIN, 13));
			lblEm.setBounds(40, 10, 80, 22);
		}
		return lblEm;
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
	private JLabel getLblStore() {
		if (lblStore == null) {
			lblStore = new JLabel("지점");
			lblStore.setForeground(new Color(60, 143, 96));
			lblStore.setFont(new Font("굴림", Font.PLAIN, 15));
			lblStore.setBounds(340, 10, 50, 23);
		}
		return lblStore;
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
	
	// 뒤로 가기 화살표 라벨 
	private JLabel getLblArrow() {
		if (lblArrow == null) {
			lblArrow = new JLabel("");
			lblArrow.addMouseListener(new MouseAdapter() {
				@Override
				// 뒤로 가기 라벨 클릭 이벤트
				public void mouseClicked(MouseEvent e) {
					AdminMenuList.main(null);
					frame.setVisible(false);
				}
			});
			lblArrow.setBounds(10, 3, 35, 35);
			ImageIcon icon = new ImageIcon(
					AdminMenuDetail.class.getResource("/com/javalec/image/leftarrow.png")
					);
			Image img = icon.getImage();  //ImageIcon을 Image로 변환.
			Image updateImg = img.getScaledInstance(20, 15, java.awt.Image.SCALE_SMOOTH);
			ImageIcon updateIcon = new ImageIcon(updateImg); 
			
			lblArrow.setIcon(updateIcon);
		}
		return lblArrow;
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
	// ================================메소드=======================================

	// 메뉴 상세 정보 출력 
	private void menuDetail() {

		AdminMenuDetailDao dao = new AdminMenuDetailDao(StaticClass.product_id);
		AdminMenuDetailDto dto = dao.settingInfo();

		lblProductId.setText(Integer.toString(dto.getProduct_id()));
		lblProductName.setText(dto.getProduct_name());
		lblProductCategory.setText(dto.getProduct_category());
		lblProductPrice.setText(Integer.toString(dto.getProduct_price()));
		lblProductRecipe.setText(dto.getProduct_recipe());
		lblProductExplain.setText(dto.getProduct_explain());
		
		// Image처리
        // File name이 틀려야 즉각 보여주기가 가능하여   
        // ShareVar에서 int값으로 정의하여 계속 증가하게 하여 file name으로 사용후 삭제
        
		String filePath = Integer.toString(StaticClass.filename);
		
		lblImage.setIcon(new ImageIcon(filePath));
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		
		File file = new File(filePath);
		file.delete();
		
	}

	// insertAction()---------------------------
	private void menuInsertAction() {

		AdminMenuDetailDao dao = new AdminMenuDetailDao();
		int check = dao.insertRegister();
		if (check == 0) {
			JOptionPane.showMessageDialog(null, StaticClass.product_id + "상품이 등록되었습니다.");
			AdminMenuList.main(null);
			frame.setVisible(false);
		} else {
			JOptionPane.showMessageDialog(null, "DB에 자료 입력중 에러가 발생했습니다! \n 시스템관리자에 문의하세요!");
		}
	}
	
	
}// END
