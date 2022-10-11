package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

public class AdminStaffOnOffDate {

	private JFrame frame;
	private JLabel lblArrow;
	private JLabel lblEm;
	private JLabel lblNewLabel_1_1_5;
	private JLabel lblNewLabel;
	private JLabel lblStore;
	private JLabel lblGoHome;
	private JLabel lblNewLabel_1_2;
	private JComboBox cbSelection;
	private JTextField textField;
	private JButton btnSearch;
	private JScrollPane scrollPane_1;
	private JTable Inner_Table;
//******************* Table definition ************************************
	private final DefaultTableModel Outer_Table = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminStaffOnOffDate window = new AdminStaffOnOffDate();
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
	public AdminStaffOnOffDate() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("출퇴근 내역");
		frame.getContentPane().setBackground(new Color(247, 243, 243));
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblGoHome());
		frame.getContentPane().add(getLblStore());
		frame.getContentPane().add(getLblEm());
		frame.getContentPane().add(getLblArrow());
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getLblNewLabel_1_1_5());
		frame.getContentPane().add(getLblNewLabel_1_2());
		frame.getContentPane().add(getCbSelection());
		frame.getContentPane().add(getTextField());
		frame.getContentPane().add(getBtnSearch());
		frame.getContentPane().add(getScrollPane_1());
		frame.setBounds(100, 100, 600, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private JLabel getLblArrow() {
		if (lblArrow == null) {
			lblArrow = new JLabel("");
			lblArrow.setBounds(10, 3, 35, 35);

			ImageIcon icon = new ImageIcon(AdminMenuList.class.getResource("/com/javalec/image/leftarrow.png"));
			Image img = icon.getImage(); // ImageIcon을 Image로 변환.
			Image updateImg = img.getScaledInstance(20, 15, java.awt.Image.SCALE_SMOOTH);
			ImageIcon updateIcon = new ImageIcon(updateImg);

			lblArrow.setIcon(updateIcon);
			frame.getContentPane().add(lblArrow);
		}
		return lblArrow;
	}

	private JLabel getLblEm() {
		if (lblEm == null) {
			lblEm = new JLabel("null님");
			lblEm.setForeground(new Color(60, 143, 96));
			lblEm.setFont(new Font("굴림", Font.PLAIN, 14));
			lblEm.setBounds(40, 10, 80, 20);
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

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Melhor Coffee");
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 18));
			lblNewLabel.setBounds(200, 10, 140, 23);
		}
		return lblNewLabel;
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

	private JLabel getLblGoHome() {
		if (lblGoHome == null) {
			lblGoHome = new JLabel("");
			lblGoHome.setBounds(545, 2, 35, 35);

			ImageIcon icon = new ImageIcon(AdminStaffDetail.class.getResource("/com/javalec/image/home.png"));
			Image img = icon.getImage(); // ImageIcon을 Image로 변환.
			Image updateImg = img.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
			ImageIcon updateIcon = new ImageIcon(updateImg);

			lblGoHome.setIcon(updateIcon);

		}
		return lblGoHome;
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

	private JComboBox getCbSelection() {
		if (cbSelection == null) {
			cbSelection = new JComboBox();
			cbSelection.setBounds(40, 61, 65, 30);
		}
		return cbSelection;
	}

	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setColumns(10);
			textField.setBounds(121, 63, 327, 28);
		}
		return textField;
	}

	private JButton getBtnSearch() {
		if (btnSearch == null) {
			btnSearch = new JButton("검색");
			btnSearch.setBounds(465, 61, 65, 30);
		}
		return btnSearch;
	}

	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(41, 106, 496, 248);
			scrollPane_1.setViewportView(getInner_Table());
		}
		return scrollPane_1;
	}

	private JTable getInner_Table() {
		if (Inner_Table == null) {
			Inner_Table = new JTable();
			// **************************** 테이블 세팅 **************************
			Inner_Table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			Inner_Table.setModel(Outer_Table);
		}
		return Inner_Table;
	}
}
