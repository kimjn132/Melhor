package com.javalec.base;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.javalec.dao.AppJoinDao;
import com.javalec.dao.AppMenuDetailDao;
import com.javalec.dao.AppMenuListDao;
import com.javalec.dao.AppStoreLocationDao;
import com.javalec.dto.AppMenuDetailDto;
import com.javalec.dto.AppMenuListDto;
import com.javalec.util.DBConnect;
import com.javalec.util.Static_CustomerId;
import com.javalec.util.Static_StoreLocation;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.JTextArea;

public class AppMenuDetail extends JFrame {

	private JFrame frmMelhor;
	private JLabel lblImage;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_1_1;
	private JLabel lblNewLabel_1_1_1;
	private JButton btnCart;
	private JLabel lblNEwLabel;
	private JComboBox cbQuantity;
	private JLabel lblProductId;
	private JTextField tfPname;
	private JTextField tfPprice;
	private JTextArea taPdetail;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMenuDetail window = new AppMenuDetail();
					window.frmMelhor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */

	// 메뉴 리스트 창에서 클릭하면 여기 디테일 창이 실행됨 1
	public AppMenuDetail() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMelhor = new JFrame();
		frmMelhor.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				// 그 다음 해당 메소드 실행 2
				productOrderList();
			}
		});

		frmMelhor.setTitle("Melhor - 제품상세");
		frmMelhor.setBounds(100, 100, 300, 500);
		frmMelhor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMelhor.getContentPane().setLayout(null);
		frmMelhor.getContentPane().add(getLblImage());
		frmMelhor.getContentPane().add(getLblNewLabel_1());
		frmMelhor.getContentPane().add(getLblNewLabel_1_1());
		frmMelhor.getContentPane().add(getLblNewLabel_1_1_1());
		frmMelhor.getContentPane().add(getBtnCart());
		frmMelhor.getContentPane().add(getLblNEwLabel());
		frmMelhor.getContentPane().add(getCbQuantity());
		frmMelhor.getContentPane().add(getTfPname());
		frmMelhor.getContentPane().add(getTfPprice());
		frmMelhor.getContentPane().add(getTaPdetail());
		frmMelhor.getContentPane().add(getBtnBack());
	}

	private JLabel getLblImage() {
		if (lblImage == null) {
			lblImage = new JLabel("사진");
			lblImage.setBounds(53, 6, 178, 152);
		}
		return lblImage;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("제품: ");
			lblNewLabel_1.setBounds(30, 164, 61, 16);
		}
		return lblNewLabel_1;
	}

	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("가격: ");
			lblNewLabel_1_1.setBounds(30, 192, 61, 16);
		}
		return lblNewLabel_1_1;
	}

	private JLabel getLblNewLabel_1_1_1() {
		if (lblNewLabel_1_1_1 == null) {
			lblNewLabel_1_1_1 = new JLabel("제품 상세설명:");
			lblNewLabel_1_1_1.setBounds(30, 284, 95, 16);
		}
		return lblNewLabel_1_1_1;
	}

	private JButton getBtnCart() {
		if (btnCart == null) {
			btnCart = new JButton("장바구니담기");
			btnCart.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					insertCart();
					frmMelhor.setVisible(false);
					AppCart.main(null);
				}
			});
			btnCart.setBounds(162, 435, 117, 29);
		}
		return btnCart;
	}

	private JLabel getLblNEwLabel() {
		if (lblNEwLabel == null) {
			lblNEwLabel = new JLabel("수량");
			lblNEwLabel.setBounds(32, 404, 61, 16);
		}
		return lblNEwLabel;
	}

	private JComboBox getCbQuantity() {
		if (cbQuantity == null) {
			cbQuantity = new JComboBox();
			cbQuantity.setModel(
					new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
			cbQuantity.setBounds(202, 404, 66, 27);
		}
		return cbQuantity;
	}

	private JTextField getTfPname() {
		if (tfPname == null) {
			tfPname = new JTextField();
			tfPname.setEditable(false);
//			

			tfPname.setBounds(149, 159, 130, 26);
			tfPname.setColumns(10);
		}
		return tfPname;
	}

	private JTextField getTfPprice() {
		if (tfPprice == null) {
			tfPprice = new JTextField();
			tfPprice.setEditable(false);
			tfPprice.setColumns(10);
			tfPprice.setBounds(149, 187, 130, 26);
		}
		return tfPprice;
	}

	private JTextArea getTaPdetail() {
		if (taPdetail == null) {
			taPdetail = new JTextArea();
			taPdetail.setLineWrap(true);
			taPdetail.setBounds(30, 312, 236, 89);
		}
		return taPdetail;
	}

	private JButton getBtnBack() {
		if (btnBack == null) {
			btnBack = new JButton("뒤로가기");
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frmMelhor.setVisible(false);
					AppMenuList.main(null);
				}
			});
			btnBack.setBounds(19, 435, 117, 29);
		}
		return btnBack;
	}
	
//function------------

	// 선택한 상품을 구매하기 위한 구매 목록 출력
	public void productOrderList() {

		AppMenuDetailDao dao = new AppMenuDetailDao(Static_CustomerId.getProduct_id());
		AppMenuDetailDto dto = dao.tableClick();

		tfPname.setText(dto.getProduct_name());
		tfPprice.setText(Integer.toString(dto.getProduct_price()));
		taPdetail.setText(dto.getProduct_explain());
		
		// Image처리
        // File name이 틀려야 즉각 보여주기가 가능하여   
        // ShareVar에서 int값으로 정의하여 계속 증가하게 하여 file name으로 사용후 삭제
        
		String filePath = Integer.toString(DBConnect.filename);
		
		lblImage.setIcon(new ImageIcon(filePath));
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		
//		File file = new File(filePath);
//		file.delete();
		

	}

	// cart 테이블에 입력
	private void insertCart() {

		int cart_product_quantity = Integer.parseInt((String) cbQuantity.getSelectedItem());

		AppMenuDetailDao dao = new AppMenuDetailDao(Static_CustomerId.product_id, Static_CustomerId.customer_id, Static_StoreLocation.shop_number, cart_product_quantity);
		int check = dao.insertCart();

		frmMelhor.setVisible(false);
		AppCart.main(null);

	}

	
}
