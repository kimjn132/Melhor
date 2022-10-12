package com.javalec.base;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.javalec.dao.HB_ManagerAppointDao;
import com.javalec.util.HB_Static;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class HB_ManagerAppoint {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JLabel lblSalesStatus;
	private JLabel lblStaffList;
	private JLabel lblNewLabel_1_1_2;
	private JLabel lblManagerList;
	private JLabel lblManagerInsert;
	private JLabel lblBestProductList;
	private JLabel lblStoreInsert;
	private JLabel lblNewLabel_2;
	private JTextField tfManagerName;
	private JButton btnappointment;
	private JLabel lblNewLabel_2_2;
	private JTextField tfManagerTelno;
	private JLabel lblNewLabel_2_3;
	private JTextField tfManagerEmail;
	private JLabel lblImage;
	private JButton btnFilePath;
	private JTextField tfFilePath;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HB_ManagerAppoint window = new HB_ManagerAppoint();
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
	public HB_ManagerAppoint() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("점장 등록");
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
		frame.getContentPane().add(getLblNewLabel_2());
		frame.getContentPane().add(getTfManagerName());
		frame.getContentPane().add(getBtnappointment());
		frame.getContentPane().add(getLblStoreInsert());
		frame.getContentPane().add(getLblNewLabel_2_2());
		frame.getContentPane().add(getTfManagerTelno());
		frame.getContentPane().add(getLblNewLabel_2_3());
		frame.getContentPane().add(getTfManagerEmail());
		frame.getContentPane().add(getLblImage());
		frame.getContentPane().add(getBtnFilePath());
		frame.getContentPane().add(getTfFilePath());
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

	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("이름");
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setBounds(229, 215, 92, 25);
		}
		return lblNewLabel_2;
	}
	private JTextField getTfManagerName() {
		if (tfManagerName == null) {
			tfManagerName = new JTextField();
			tfManagerName.setBounds(333, 212, 186, 30);
			tfManagerName.setColumns(10);
		}
		return tfManagerName;
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
	
	private JLabel getLblNewLabel_2_2() {
		if (lblNewLabel_2_2 == null) {
			lblNewLabel_2_2 = new JLabel("전화번호");
			lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2_2.setBounds(229, 253, 92, 25);
		}
		return lblNewLabel_2_2;
	}
	private JTextField getTfManagerTelno() {
		if (tfManagerTelno == null) {
			tfManagerTelno = new JTextField();
			tfManagerTelno.setColumns(10);
			tfManagerTelno.setBounds(333, 250, 186, 30);
		}
		return tfManagerTelno;
	}
	private JLabel getLblNewLabel_2_3() {
		if (lblNewLabel_2_3 == null) {
			lblNewLabel_2_3 = new JLabel("이메일");
			lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2_3.setBounds(229, 291, 92, 25);
		}
		return lblNewLabel_2_3;
	}
	private JTextField getTfManagerEmail() {
		if (tfManagerEmail == null) {
			tfManagerEmail = new JTextField();
			tfManagerEmail.setColumns(10);
			tfManagerEmail.setBounds(333, 288, 186, 30);
		}
		return tfManagerEmail;
	}
	private JLabel getLblImage() {
		if (lblImage == null) {
			lblImage = new JLabel("image");
			lblImage.setHorizontalAlignment(SwingConstants.CENTER);
			lblImage.setBounds(250, 79, 143, 127);
		}
		return lblImage;
	}
	private JTextField getTfFilePath() {
		if (tfFilePath == null) {
			tfFilePath = new JTextField();
			tfFilePath.setBounds(405, 117, 143, 25);
			tfFilePath.setColumns(10);
		}
		return tfFilePath;
	}
	
	// --------------------------------- Action Listener -------------------------------------------
	
	private JButton getBtnappointment() {
		if (btnappointment == null) {
			btnappointment = new JButton("등록하기");
			btnappointment.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
					int tfcheck = insertFieldCheck();
					if(tfcheck == 0) {
						managerIdInsert();
					}
					
					
				}
			});
			btnappointment.setBounds(306, 375, 174, 31);
		}
		return btnappointment;
	}
	
	private JButton getBtnFilePath() {
		if (btnFilePath == null) {
			btnFilePath = new JButton("이미지 추가");
			btnFilePath.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					FilePath();
				}
			});
			btnFilePath.setBounds(405, 79, 114, 30);
		}
		return btnFilePath;
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
	
	//----------------------------------------------------------------------------
	
	private int insertFieldCheck() {

		int i = 0;
		String result = "";

		if (tfManagerName.getText().trim().length() == 0) {
			i++;
			result = "이름을 ";
			tfManagerName.requestFocus();

		} else if (tfManagerEmail.getText().trim().length() == 0) {
			i++;
			result = "이메일를 ";
			tfManagerEmail.requestFocus();

		} else if (tfManagerTelno.getText().trim().length() == 0) {
			i++;
			result = "전화번호를 ";
			tfManagerTelno.requestFocus();

		} else if (tfFilePath.getText().trim().length() == 0) {
			i++;
			result = "이미지를 ";
			tfFilePath.requestFocus();

		}

		if (i > 0) {
			JOptionPane.showMessageDialog(null, result + "확인하세요!");
		}

		return i;
	}
	
	// 정보 등록하기
	private void managerIdInsert() {
		
		String name = tfManagerName.getText();
		String telno = tfManagerTelno.getText();
		String email = tfManagerEmail.getText();
		
		// Image File
		FileInputStream input = null;
		File file = new File(tfFilePath.getText());
		try {
			input = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HB_ManagerAppointDao dao = new HB_ManagerAppointDao(name, telno, email, input);
		int count = dao.managerAppointment();
		
		if(count == 1) {
			JOptionPane.showMessageDialog(null, "입력 성공");
			HB_ManagerList.main(null);
			frame.setVisible(false);
		
		} else {
			JOptionPane.showMessageDialog(null, "입력 실패");
		}
		
		
	}
	
	private void FilePath() {
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG, PNG, BMP", "jpg","png","bmp");
		chooser.setFileFilter(filter);
		
		int ret = chooser.showOpenDialog(null);
		if(ret != JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다!", "경고", JOptionPane.WARNING_MESSAGE);
			return;
		}
		String filePath = chooser.getSelectedFile().getPath();
		tfFilePath.setText(filePath);
		lblImage.setIcon(new ImageIcon(filePath));
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
	}
	
	
} // End Line
