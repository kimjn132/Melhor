package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.javalec.dao.HS_StaffMypageDao;
import com.javalec.dto.HS_StaffMypageDto;
import com.javalec.util.DBConnect;
import com.javalec.util.HS_Static_StaffId;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.DefaultComboBoxModel;

public class HS_StaffMypage {

	private JFrame frame;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField tfIdupdate;
	private JTextField tfNameupdate;
	private JTextField tfTelnoupdate;
	private JTextField tfEmailupdate;
	private JLabel lblNewLabel_5;
	private JTextField tfEmailupdate2;
	private JComboBox cbEmailupdate;
	private JTextField tfPwupdate;
	private JButton btnUpdate;
//	private JButton btnImageupdate;
	private JButton btnBackpage;

	/**
	 * Launch the application.
	 */

	ArrayList<HS_StaffMypageDto> beanList = null;
//	private JTextField tfFilepath;
	private JLabel lblImage;
	private JButton btnNewButton;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HS_StaffMypage window = new HS_StaffMypage();
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
	public HS_StaffMypage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				staffVisibleAction();

			}

			@Override
			public void windowClosed(WindowEvent e) {

				closingAction();
			}
		});
		frame.getContentPane().setBackground(new Color(227, 147, 132));
		frame.setTitle("내 정보");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblNewLabel_4());
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getLblNewLabel_2());
		frame.getContentPane().add(getLblNewLabel_3());
		frame.getContentPane().add(getTfIdupdate());
		frame.getContentPane().add(getTfNameupdate());
		frame.getContentPane().add(getTfTelnoupdate());
		frame.getContentPane().add(getTfEmailupdate());
		frame.getContentPane().add(getLblNewLabel_5());
		frame.getContentPane().add(getTfEmailupdate2());
		frame.getContentPane().add(getCbEmailupdate());
		frame.getContentPane().add(getTfPwupdate());
		frame.getContentPane().add(getBtnUpdate());
//		frame.getContentPane().add(getBtnImageupdate());
		frame.getContentPane().add(getBtnBackpage());
//		frame.getContentPane().add(getTfFilepath());
		frame.getContentPane().add(getLblImage());
		frame.getContentPane().add(getBtnNewButton());
	}

	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("ID");
			lblNewLabel_4.setBounds(52, 48, 50, 15);
		}
		return lblNewLabel_4;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("이름");
			lblNewLabel.setBounds(52, 70, 50, 15);
		}
		return lblNewLabel;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("전화번호");
			lblNewLabel_1.setBounds(52, 107, 50, 15);
		}
		return lblNewLabel_1;
	}

	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("이메일");
			lblNewLabel_2.setBounds(52, 142, 50, 15);
		}
		return lblNewLabel_2;
	}

	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("비밀번호");
			lblNewLabel_3.setBounds(51, 185, 82, 15);
		}
		return lblNewLabel_3;
	}

	private JTextField getTfIdupdate() {
		if (tfIdupdate == null) {
			tfIdupdate = new JTextField();
			tfIdupdate.setText((String) null);
			tfIdupdate.setEditable(false);
			tfIdupdate.setColumns(10);
			tfIdupdate.setBounds(99, 45, 96, 21);
		}
		return tfIdupdate;
	}

	private JTextField getTfNameupdate() {
		if (tfNameupdate == null) {
			tfNameupdate = new JTextField();
			tfNameupdate.setText((String) null);
			tfNameupdate.setColumns(10);
			tfNameupdate.setBounds(99, 67, 96, 21);
		}
		return tfNameupdate;
	}

	private JTextField getTfTelnoupdate() {
		if (tfTelnoupdate == null) {
			tfTelnoupdate = new JTextField();
			tfTelnoupdate.setText((String) null);
			tfTelnoupdate.setColumns(10);
			tfTelnoupdate.setBounds(109, 104, 96, 21);
		}
		return tfTelnoupdate;
	}

	private JTextField getTfEmailupdate() {
		if (tfEmailupdate == null) {
			tfEmailupdate = new JTextField();
			tfEmailupdate.setText((String) null);
			tfEmailupdate.setColumns(10);
			tfEmailupdate.setBounds(114, 139, 50, 21);
		}
		return tfEmailupdate;
	}

	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("@");
			lblNewLabel_5.setFont(new Font("굴림", Font.PLAIN, 14));
			lblNewLabel_5.setBounds(165, 142, 18, 15);
		}
		return lblNewLabel_5;
	}

	private JTextField getTfEmailupdate2() {
		if (tfEmailupdate2 == null) {
			tfEmailupdate2 = new JTextField();
			tfEmailupdate2.setColumns(10);
			tfEmailupdate2.setBounds(176, 139, 66, 21);
		}
		return tfEmailupdate2;
	}

	private JComboBox getCbEmailupdate() {
		if (cbEmailupdate == null) {
			cbEmailupdate = new JComboBox();
			cbEmailupdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					cbEmailAction();
				}
			});
			cbEmailupdate.setModel(new DefaultComboBoxModel(new String[] {"직접입력", "naver.com", "hanmail.net", "google.com"}));
			cbEmailupdate.setBounds(249, 138, 85, 23);
		}
		return cbEmailupdate;
	}

	private JTextField getTfPwupdate() {
		if (tfPwupdate == null) {
			tfPwupdate = new JTextField();
			tfPwupdate.setText((String) null);
			tfPwupdate.setColumns(10);
			tfPwupdate.setBounds(109, 182, 96, 21);
		}
		return tfPwupdate;
	}

	private JButton getBtnUpdate() {
		if (btnUpdate == null) {
			btnUpdate = new JButton("수정");
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					staffUpdateAction();
					
					frame.setVisible(false);// 창 종료
					HS_StaffMenu.main(null);// 전체메뉴 창 열기
				}
			});
			btnUpdate.setBounds(114, 217, 66, 23);
		}
		return btnUpdate;
	}

//	private JButton getBtnImageupdate() {
//		if (btnImageupdate == null) {
//			btnImageupdate = new JButton("이미지 변경");
//			btnImageupdate.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//
//					FilePath();// 이미지 수정 버튼
//
//				}
//			});
//			btnImageupdate.setBounds(312, 171, 114, 23);
//		}
//		return btnImageupdate;
//	}

	private JButton getBtnBackpage() {
		if (btnBackpage == null) {
			btnBackpage = new JButton("전체 메뉴로 돌아가기");
			btnBackpage.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					frame.setVisible(false);// 창 종료
					HS_StaffMenu.main(null);// 전체메뉴 창 열기

				}
			});
			btnBackpage.setFont(new Font("HY엽서M", Font.PLAIN, 15));
			btnBackpage.setBounds(234, 233, 190, 20);
		}
		return btnBackpage;
	}

//	private JTextField getTfFilepath() {
//		if (tfFilepath == null) {
//			tfFilepath = new JTextField();
//			tfFilepath.setBounds(330, 139, 96, 21);
//			tfFilepath.setColumns(10);
//		}
//		return tfFilepath;
//	}

	private JLabel getLblImage() {
		if (lblImage == null) {
			lblImage = new JLabel("");
			lblImage.setBounds(245, 10, 181, 112);
		}
		return lblImage;
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("스케줄 확인");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					//스케줄 달력 켜지게 함
					HS_StaffCalender.main(null);
					
					
				}
			});
			btnNewButton.setBounds(273, 200, 114, 23);
		}
		return btnNewButton;
	}
	// ---------------------------------------------------function----------------

	private void staffUpdateAction() {// 이름, 번호, 이메일, 패스워드 입력 후 수정버튼 누르면 update 되는 메소드

		String employee_name = tfNameupdate.getText().trim();
		String employee_telno = tfTelnoupdate.getText().trim();
		String employee_email = tfEmailupdate.getText().trim();

		String employee_email2 = cbEmailupdate.getSelectedItem().toString();

		String employee_pw = tfPwupdate.getText().trim();

		// Image File
		FileInputStream input = null;
//		File file = new File(tfFilepath.getText());
//		try {
//			input = new FileInputStream(file);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		HS_StaffMypageDao hs_staffmypagedao = new HS_StaffMypageDao(employee_name, employee_telno, employee_email,
				employee_email2, employee_pw, input);

		Boolean ok = hs_staffmypagedao.updateAction();

		if (ok == true) {

			JOptionPane.showMessageDialog(null, tfNameupdate.getText() + "님의 정보가 수정되었습니다.");

		} else {

			JOptionPane.showMessageDialog(null, "작업중 문제발생했습니다.");

		}

	}

	private void staffVisibleAction() {

		HS_StaffMypageDao dao = new HS_StaffMypageDao();

		HS_StaffMypageDto dtoList = dao.staffInfoSave();

		tfIdupdate.setText(Integer.toString(HS_Static_StaffId.staff_Id));
		tfNameupdate.setText(dtoList.getTfNameupdate());
		tfTelnoupdate.setText(dtoList.getTfTelnoupdate());
		tfEmailupdate.setText(dtoList.getTfemailupdate());
		tfPwupdate.setText(dtoList.getTfpwupdate());

		
		
		// 이미지 처리
		String filepath = Integer.toString(DBConnect.filename);

		lblImage.setIcon(new ImageIcon(filepath));

		lblImage.setHorizontalAlignment(SwingConstants.CENTER);

		File file = new File(filepath);
		file.delete();

	}

//	private void FilePath() {
//
//		JFileChooser chooser = new JFileChooser();
//		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG, PNG, BMP", "jpg", "png", "bmp");
//		chooser.setFileFilter(filter);
//
//		int ret = chooser.showOpenDialog(null);
//
//		if (ret != JFileChooser.APPROVE_OPTION) {
//			JOptionPane.showMessageDialog(null, "파일을 선택해주세요!", "오류", JOptionPane.WARNING_MESSAGE);
//			return;
//		}
//
//		String filePath = chooser.getSelectedFile().getPath();
//
//		tfFilepath.setText(filePath);
//		tfFilepath.setText(filePath);
//
//		lblImage.setIcon(new ImageIcon(filePath));
//
//		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
//	}

	private void closingAction() {

		for (int index = 0; index < beanList.size(); index++) {
			File file = new File("./" + beanList.get(index).getTfFilename());
			file.delete();

		}

	}
	
	private void cbEmailAction() {

		if (cbEmailupdate.getSelectedItem() == "직접입력") {

			tfEmailupdate2.setText("");
			tfEmailupdate2.setEditable(true);
		} else {

			tfEmailupdate2.setText(cbEmailupdate.getSelectedItem().toString());
			tfEmailupdate2.setEditable(false);
		}

	}
	
}// end
