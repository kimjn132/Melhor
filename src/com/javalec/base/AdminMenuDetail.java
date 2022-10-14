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
import java.util.ArrayList;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;

public class AdminMenuDetail extends JFrame {

	private JFrame frame;
	private JLabel lblProductName;
	private JLabel lblNewLabel;
	private JLabel lblEm;
	private JLabel lblNewLabel_1_1_5;
	private JLabel lblStore;
	private JLabel lblNewLabel_1_2;
	private JLabel lblArrow;
	private JLabel lblImage;
	private JLabel lblGoHome;
	private JButton btnUnregister;
	private JScrollPane scrollPane;
	private JTextPane tpExplain;
	private JTextPane tpRecipe;
	private JTextField tfId;
	private JTextField tfCategory;
	private JTextField tfPrice;

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
		frame.setTitle("메뉴 등록");
		frame.setBounds(100, 100, 600, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getBtnUnregister());

		lblImage = new JLabel("");
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage.setBounds(53, 120, 189, 100);
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
		lblNewLabel_1_1_3.setBounds(319, 214, 64, 15);
		frame.getContentPane().add(lblNewLabel_1_1_3);

		lblProductName = new JLabel("New label");
		lblProductName.setForeground(new Color(60, 143, 96));
		lblProductName.setBackground(new Color(60, 143, 96));
		lblProductName.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductName.setFont(new Font("굴림", Font.BOLD, 15));
		lblProductName.setBounds(53, 67, 189, 30);
		frame.getContentPane().add(lblProductName);

		JLabel lblNewLabel_1_1_4 = new JLabel("카테고리");
		lblNewLabel_1_1_4.setBounds(55, 285, 50, 15);
		frame.getContentPane().add(lblNewLabel_1_1_4);
		frame.getContentPane().add(getLblNewLabel_1_2());
		frame.getContentPane().add(getScrollPane());
		frame.getContentPane().add(getTpRecipe());
		frame.getContentPane().add(getTfId());
		frame.getContentPane().add(getTfCategory());
		frame.getContentPane().add(getTfPrice());

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
			lblEm.setText(StaticClass.employee_name+ "님");
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
			lblStore.setText(StaticClass.shop_name);
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

	// 뒤로 가기 화살표 라벨
	private JLabel getLblArrow() {
		if (lblArrow == null) {
			
			AdminMenuDetailDao dao = new AdminMenuDetailDao();
			AdminMenuDetailDto dto = dao.menuRegisterCheck();

			int registerCheck = dto.getCount();
			
			if (registerCheck == 1) {
				lblArrow = new JLabel("");
				lblArrow.addMouseListener(new MouseAdapter() {
					@Override
					// 뒤로 가기 라벨 클릭 이벤트
					public void mouseClicked(MouseEvent e) {
						frame.setVisible(false);
						AdminRegisterMenuManagement.main(null);
					}
				});
				
			}else if (registerCheck == 0) {
				lblArrow = new JLabel("");
				// 뒤로 가기 라벨 클릭 이벤트
				lblArrow.addMouseListener(new MouseAdapter() {
					@Override
					// 뒤로 가기 라벨 클릭 이벤트
					public void mouseClicked(MouseEvent e) {
						frame.setVisible(false);
						AdminMenuList.main(null);
					}
				});
			}
		
			lblArrow.setBounds(10, 3, 35, 35);
			ImageIcon icon = new ImageIcon(AdminMenuDetail.class.getResource("/com/javalec/image/leftarrow.png"));
			Image img = icon.getImage(); // ImageIcon을 Image로 변환.
			Image updateImg = img.getScaledInstance(20, 15, java.awt.Image.SCALE_SMOOTH);
			ImageIcon updateIcon = new ImageIcon(updateImg);
			
			lblArrow.setIcon(updateIcon);
		}
		return lblArrow;
	}
	// 요기!!!!!!!!!!!!!!!!!
	// 등록된 메뉴면 해제 버튼으로 바뀌고 등록 안 된 메뉴면 등록 버튼으로 바뀜
	private JButton getBtnUnregister() {
		if (btnUnregister == null) {

			AdminMenuDetailDao dao = new AdminMenuDetailDao();
			AdminMenuDetailDto dto = dao.menuRegisterCheck();

			int registerCheck = dto.getCount();
			
			if (registerCheck == 1) {
				btnUnregister = new JButton("해제");
				btnUnregister.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						updateDeleteDate();
						frame.setVisible(false);
						AdminRegisterMenuManagement.main(null);
					}
				});
			} else if (registerCheck == 0) {
				btnUnregister = new JButton("등록");
				btnUnregister.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						menuInsertCountCheck();
						insertRegister();
						frame.setVisible(false);
						AdminMenuList.main(null);
					}
				});

			}

			btnUnregister.setBounds(500, 377, 80, 26);

		}
		return btnUnregister;
	}

	// ================================메소드=======================================

	// 메뉴 상세 정보 출력
	private void menuDetail() {

		AdminMenuDetailDao dao = new AdminMenuDetailDao(StaticClass.product_id);
		AdminMenuDetailDto dto = dao.settingInfo();

		tfId.setText(Integer.toString(dto.getProduct_id()));
		lblProductName.setText(dto.getProduct_name());
		tfCategory.setText(dto.getProduct_category());
		tfPrice.setText(Integer.toString(dto.getProduct_price()));
		tpRecipe.setText(dto.getProduct_recipe());
		tpExplain.setText(dto.getProduct_explain());

		// Image처리
		// File name이 틀려야 즉각 보여주기가 가능하여
		// ShareVar에서 int값으로 정의하여 계속 증가하게 하여 file name으로 사용후 삭제

		String filePath = Integer.toString(StaticClass.filename);

		lblImage.setIcon(new ImageIcon(filePath));
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);

		File file = new File(filePath);
		file.delete();

	}

	// register_id -> static

	// 1. 등록 버튼일 때 메소드 insertAction()---------------------------
	private void insertRegister() {

		AdminMenuDetailDao dao = new AdminMenuDetailDao();

		int check = dao.insertRegister();
		
		if (check == 1) {

		} else {
			JOptionPane.showMessageDialog(null, "작업중 문제발생했습니다.");

		}
	}

	// 6개 넘게 등록 못하도록
	private void menuInsertCountCheck() {

		AdminMenuDetailDao dao = new AdminMenuDetailDao();
		AdminMenuDetailDto dto = dao.menuCount();

		int count = dto.getCount();
		if (count < 6) {
			JOptionPane.showMessageDialog(null, "메뉴가 등록되었습니다.");
		} else {
			JOptionPane.showMessageDialog(null, "메뉴는 6개만 등록 가능합니다. \n등록된 메뉴의 개수를 확인하세요.");
		}

	}

	// 2. 해제 버튼일 때 메소드 update deletedate --------------------------------

	private void updateDeleteDate() {

		AdminMenuDetailDao dao = new AdminMenuDetailDao();
		Boolean ok = dao.updateDelDate();

		if (ok == true) {

			JOptionPane.showMessageDialog(null, "메뉴 등록이 해제되었습니다.");
		} else {
			JOptionPane.showMessageDialog(null, "작업중 문제발생했습니다.");

		}
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(319, 239, 236, 104);
			scrollPane.setViewportView(getTpExplain());
		}
		return scrollPane;
	}
	private JTextPane getTpExplain() {
		if (tpExplain == null) {
			tpExplain = new JTextPane();
			tpExplain.setEditable(false);
		}
		return tpExplain;
	}
	private JTextPane getTpRecipe() {
		if (tpRecipe == null) {
			tpRecipe = new JTextPane();
			tpRecipe.setEditable(false);
			tpRecipe.setBounds(319, 100, 236, 100);
		}
		return tpRecipe;
	}
	private JTextField getTfId() {
		if (tfId == null) {
			tfId = new JTextField();
			tfId.setEditable(false);
			tfId.setBounds(125, 247, 96, 21);
			tfId.setColumns(10);
		}
		return tfId;
	}
	private JTextField getTfCategory() {
		if (tfCategory == null) {
			tfCategory = new JTextField();
			tfCategory.setEditable(false);
			tfCategory.setColumns(10);
			tfCategory.setBounds(125, 282, 96, 21);
		}
		return tfCategory;
	}
	private JTextField getTfPrice() {
		if (tfPrice == null) {
			tfPrice = new JTextField();
			tfPrice.setEditable(false);
			tfPrice.setColumns(10);
			tfPrice.setBounds(125, 317, 96, 21);
		}
		return tfPrice;
	}
}// END
