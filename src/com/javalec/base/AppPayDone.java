package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.javalec.util.Static_CustomerId;
import com.javalec.util.Static_StoreLocation;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppPayDone {

	private JFrame frmMelhor;
	private JLabel lblNewLabel;
	private JLabel lblOrderId;
	private JLabel lblStore;
	private JLabel lblCustomer;
	private JButton btnMenuList;
	private JButton btnBackHome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppPayDone window = new AppPayDone();
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
	public AppPayDone() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMelhor = new JFrame();
		frmMelhor.setTitle("Melhor - 결제완료");
		frmMelhor.setBounds(100, 100, 300, 500);
		frmMelhor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMelhor.getContentPane().setLayout(null);
		frmMelhor.getContentPane().add(getLblNewLabel());
		frmMelhor.getContentPane().add(getLblOrderId());
		frmMelhor.getContentPane().add(getLblStore());
		frmMelhor.getContentPane().add(getLblCustomer());
		frmMelhor.getContentPane().add(getBtnMenuList());
		frmMelhor.getContentPane().add(getBtnBackHome());
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("결제가 완료되었습니다.");
			lblNewLabel.setBounds(93, 51, 118, 102);
		}
		return lblNewLabel;
	}

	private JLabel getLblOrderId() {
		if (lblOrderId == null) {
			lblOrderId = new JLabel("New label");
			lblOrderId.setBounds(64, 177, 173, 33);
		}
		return lblOrderId;
	}

	private JLabel getLblStore() {
		if (lblStore == null) {
			lblStore = new JLabel("New label");
			lblStore.setBounds(33, 31, 61, 16);
			lblStore.setText(Static_StoreLocation.shop_name);
		}
		return lblStore;
	}

	private JLabel getLblCustomer() {
		if (lblCustomer == null) {
			lblCustomer = new JLabel("New label");
			lblCustomer.setBounds(195, 31, 61, 16);
			lblCustomer.setText(Static_CustomerId.customer_nickname);
		}
		return lblCustomer;
	}

	private JButton getBtnMenuList() {
		if (btnMenuList == null) {
			btnMenuList = new JButton("다시 주문하기");
			btnMenuList.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frmMelhor.setVisible(false);
					AppMenuList.main(null);

				}
			});
			btnMenuList.setBounds(19, 261, 117, 29);
		}
		return btnMenuList;
	}

	private JButton getBtnBackHome() {
		if (btnBackHome == null) {
			btnBackHome = new JButton("홈으로 가기");
			btnBackHome.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frmMelhor.setVisible(false);
					AppHome.main(null);

				}
			});
			btnBackHome.setBounds(163, 261, 117, 29);
		}
		return btnBackHome;
	}
}
