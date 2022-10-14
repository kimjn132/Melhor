package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.javalec.dao.AppCartDao;
import com.javalec.dao.AppMenuDetailDao;
import com.javalec.dao.AppTodayMenuDao;
import com.javalec.dto.AppCartDto;
import com.javalec.dto.AppMenuDetailDto;
import com.javalec.dto.AppTodayMenuDto;
import com.javalec.util.DBConnect;
import com.javalec.util.Static_CustomerId;
import com.javalec.util.Static_StoreLocation;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AppTodayMenu {

	private JFrame frmMelhor;
	private JLabel lblEmployee_image;
	private JLabel lblNewLabel_1;
	private JLabel lblPrice;
	private JButton btnNewButton;
	private JTextField tfFilePath;
	private JTextPane tfExplain;
	private JLabel lblName;
	private JLabel lblNewLabel_1_1;
	private JComboBox cbQuantity;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppTodayMenu window = new AppTodayMenu();
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
	public AppTodayMenu() {
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
				todayMenuSum();
			}
		});
		frmMelhor.setTitle("Melhor - 오늘의 메뉴");
		frmMelhor.setBounds(100, 100, 285, 469);
		frmMelhor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMelhor.getContentPane().setLayout(null);
		frmMelhor.getContentPane().add(getLblEmployee_image());
		frmMelhor.getContentPane().add(getLblNewLabel_1());
		frmMelhor.getContentPane().add(getLblPrice());
		frmMelhor.getContentPane().add(getBtnNewButton());
		frmMelhor.getContentPane().add(getTfFilePath());
		frmMelhor.getContentPane().add(getTfExplain());
		frmMelhor.getContentPane().add(getLblName());
		frmMelhor.getContentPane().add(getLblNewLabel_1_1());
		frmMelhor.getContentPane().add(getCbQuantity());
	}

	private JLabel getLblEmployee_image() {
		if (lblEmployee_image == null) {
			lblEmployee_image = new JLabel("");
			lblEmployee_image.setHorizontalAlignment(SwingConstants.CENTER);
			lblEmployee_image.setBounds(17, 6, 254, 170);
		}
		return lblEmployee_image;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("가격:");
			lblNewLabel_1.setBounds(38, 212, 61, 16);
		}
		return lblNewLabel_1;
	}

	private JLabel getLblPrice() {
		if (lblPrice == null) {
			lblPrice = new JLabel("New label");
			lblPrice.setBounds(111, 212, 128, 16);
		}
		return lblPrice;
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("장바구니");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// 장바구니로 이동
					insertCart();
					frmMelhor.setVisible(false);
					AppCart.main(null);
				}
			});
			btnNewButton.setBounds(154, 406, 117, 29);
		}
		return btnNewButton;
	}

	private JTextField getTfFilePath() {
		if (tfFilePath == null) {
			tfFilePath = new JTextField();
			tfFilePath.setBounds(26, 310, 96, 21);
			tfFilePath.setColumns(10);
			tfFilePath.setVisible(false);
		}
		return tfFilePath;
	}

	private JTextPane getTfExplain() {
		if (tfExplain == null) {
			tfExplain = new JTextPane();
			tfExplain.setEditable(false);
			tfExplain.setBounds(17, 276, 244, 128);
		}
		return tfExplain;
	}

	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("New label");
			lblName.setBounds(111, 188, 128, 16);
		}
		return lblName;
	}

	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("수량:");
			lblNewLabel_1_1.setBounds(38, 248, 61, 16);
		}
		return lblNewLabel_1_1;
	}

	private JComboBox getCbQuantity() {
		if (cbQuantity == null) {
			cbQuantity = new JComboBox();
			cbQuantity.setModel(
					new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
			cbQuantity.setBounds(121, 244, 52, 27);
		}
		return cbQuantity;
	}

	// ----------------------------------------------------------------------------

	// 인기메뉴 수량 가져오기
	public void todayMenuSum() {

		AppTodayMenuDao dao = new AppTodayMenuDao();
		ArrayList<AppTodayMenuDto> dtoList = dao.bestProductConditionList();

		// 수량을 해당 메소드로 보내줌
		todayMenuSearch(dtoList.get(0).getTodayMenu());

	}

	// 받은 수량으로 인기메뉴 출력
	public void todayMenuSearch(int sum) {

		AppTodayMenuDao dao = new AppTodayMenuDao(sum);
		AppTodayMenuDto dto = dao.todayMenuSearch();

		lblName.setText(dto.getName());
		lblPrice.setText(Integer.toString(dto.getPrice()));
		tfExplain.setText(dto.getExplain());
		

		String filePath = Integer.toString(DBConnect.filename);
		tfFilePath.setText(filePath);

		lblEmployee_image.setIcon(new ImageIcon(filePath));
		lblEmployee_image.setHorizontalAlignment(SwingConstants.CENTER);

		File file = new File(filePath);
		file.delete();

		tfFilePath.setText("");

		Static_CustomerId.setProduct_id(dto.getProduct_id());
	}

	// cart 테이블에 입력
	private void insertCart() {

		int cart_product_quantity = Integer.parseInt((String) cbQuantity.getSelectedItem());

		AppTodayMenuDao dao = new AppTodayMenuDao(Static_CustomerId.product_id, Static_CustomerId.customer_id,
				Static_StoreLocation.shop_number, cart_product_quantity);

		AppTodayMenuDto dto = dao.todayMenuSearch();

		int check = dao.insertCart();
System.out.println(check);
		frmMelhor.setVisible(false);
		AppCart.main(null);

	}

} // End Line
