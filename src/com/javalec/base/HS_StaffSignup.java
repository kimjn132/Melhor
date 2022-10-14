package com.javalec.base;

import java.awt.EventQueue;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.javalec.dao.HS_StaffSignupDao;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class HS_StaffSignup {

	private JFrame frame;
	private JLabel lblImage;
	private JButton btnFilePath;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_1_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_2_1;
	private JLabel lblNewLabel_2_1_1;
	private JTextField tfId;
	private JTextField tfName;
	private JTextField tfTelno;
	private JTextField tfEmail;
	private JTextField tfEmail2;
	private JComboBox comboBox;
	private JPasswordField pfPw;
	private JPasswordField pfPw2;
	private JLabel lblNewLabel_3;
	private JButton btnSignOk;
	private JButton btnBackPage;
	private JButton btnNewButton;
	private JTextField tfFilepath;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HS_StaffSignup window = new HS_StaffSignup();
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
	public HS_StaffSignup() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(227, 147, 132));
		frame.setTitle("회원가입");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblImage());
		frame.getContentPane().add(getBtnFilePath());
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getLblNewLabel_1_1());
		frame.getContentPane().add(getLblNewLabel_2());
		frame.getContentPane().add(getLblNewLabel_2_1());
		frame.getContentPane().add(getLblNewLabel_2_1_1());
		frame.getContentPane().add(getTfId());
		frame.getContentPane().add(getTfName());
		frame.getContentPane().add(getTfTelno());
		frame.getContentPane().add(getTfEmail());
		frame.getContentPane().add(getTfEmail2());
		frame.getContentPane().add(getComboBox());
		frame.getContentPane().add(getPfPw());
		frame.getContentPane().add(getPfPw2());
		frame.getContentPane().add(getLblNewLabel_3());
		frame.getContentPane().add(getBtnSignOk());
		frame.getContentPane().add(getBtnBackPage());
		frame.getContentPane().add(getBtnNewButton());
		frame.getContentPane().add(getTfFilepath());
	}
	private JLabel getLblImage() {
		if (lblImage == null) {
			lblImage = new JLabel("image");
			lblImage.setHorizontalAlignment(SwingConstants.CENTER);
			lblImage.setBounds(290, 21, 123, 90);
		}
		return lblImage;
	}
	private JButton getBtnFilePath() {
		if (btnFilePath == null) {
			btnFilePath = new JButton("업로드");
			btnFilePath.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					FilePath();
					
				}
			});
			btnFilePath.setBounds(314, 121, 80, 21);
		}
		return btnFilePath;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("아이디");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(31, 14, 61, 34);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("비밀번호");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setBounds(31, 49, 61, 34);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("비밀번호 확인");
			lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_1.setBounds(12, 77, 91, 34);
		}
		return lblNewLabel_1_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("이름");
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setBounds(31, 114, 61, 34);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_2_1() {
		if (lblNewLabel_2_1 == null) {
			lblNewLabel_2_1 = new JLabel("전화번호");
			lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2_1.setBounds(31, 146, 61, 34);
		}
		return lblNewLabel_2_1;
	}
	private JLabel getLblNewLabel_2_1_1() {
		if (lblNewLabel_2_1_1 == null) {
			lblNewLabel_2_1_1 = new JLabel("이메일");
			lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2_1_1.setBounds(31, 169, 61, 34);
		}
		return lblNewLabel_2_1_1;
	}
	private JTextField getTfId() {
		if (tfId == null) {
			tfId = new JTextField();
			tfId.setToolTipText("");
			tfId.setColumns(10);
			tfId.setBounds(101, 21, 123, 21);
		}
		return tfId;
	}
	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setToolTipText("");
			tfName.setColumns(10);
			tfName.setBounds(101, 121, 123, 21);
		}
		return tfName;
	}
	private JTextField getTfTelno() {
		if (tfTelno == null) {
			tfTelno = new JTextField();
			tfTelno.setToolTipText("");
			tfTelno.setColumns(10);
			tfTelno.setBounds(101, 153, 123, 21);
		}
		return tfTelno;
	}
	private JTextField getTfEmail() {
		if (tfEmail == null) {
			tfEmail = new JTextField();
			tfEmail.setToolTipText("");
			tfEmail.setColumns(10);
			tfEmail.setBounds(91, 176, 73, 21);
		}
		return tfEmail;
	}
	private JTextField getTfEmail2() {
		if (tfEmail2 == null) {
			tfEmail2 = new JTextField();
			tfEmail2.setToolTipText("");
			tfEmail2.setColumns(10);
			tfEmail2.setBounds(188, 176, 123, 21);
		}
		return tfEmail2;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setBounds(321, 176, 73, 21);
		}
		return comboBox;
	}
	private JPasswordField getPfPw() {
		if (pfPw == null) {
			pfPw = new JPasswordField();
			pfPw.setBounds(101, 56, 123, 21);
		}
		return pfPw;
	}
	private JPasswordField getPfPw2() {
		if (pfPw2 == null) {
			pfPw2 = new JPasswordField();
			pfPw2.setBounds(101, 84, 123, 21);
		}
		return pfPw2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("@");
			lblNewLabel_3.setBounds(167, 179, 20, 15);
		}
		return lblNewLabel_3;
	}
	private JButton getBtnSignOk() {
		if (btnSignOk == null) {
			btnSignOk = new JButton("회원가입");
			btnSignOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
					staffSignUp();
					insertFieldCheck();
				}
			});
			btnSignOk.setBounds(230, 226, 92, 21);
		}
		return btnSignOk;
	}
	private JButton getBtnBackPage() {
		if (btnBackPage == null) {
			btnBackPage = new JButton("이전");
			btnBackPage.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					HS_StaffLogin.main(null);
					frame.setVisible(false);
					
					
				}
			});
			btnBackPage.setBounds(76, 225, 72, 23);
		}
		return btnBackPage;
	}
	
	
	
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("중복체크");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					staffIdCheck();
				}
			});
			btnNewButton.setBounds(230, 21, 80, 23);
		}
		return btnNewButton;
	}
	
	private JTextField getTfFilepath() {
		if (tfFilepath == null) {
			tfFilepath = new JTextField();
			tfFilepath.setEditable(false);
			tfFilepath.setBounds(303, 152, 91, 21);
			tfFilepath.setColumns(10);
		}
		return tfFilepath;
	}
	// --------------------- Function ----------------------

	
	
	private int insertFieldCheck() {
		
		int i = 0;
		String result = "";
		
		if(tfId.getText().trim().length() == 0) {
			i++;
			result = "ID를 ";
			tfId.requestFocus();
			
		} else if(pfPw.getText().trim().length() == 0) {
			i++;
			result = "PW를 ";
			pfPw.requestFocus();
			
		} else if(pfPw2.getText().trim().length() == 0) {
			i++;
			result = "PW확인을 ";
			pfPw2.requestFocus();
			
		} else if(tfName.getText().trim().length() == 0) {
			i++;
			result = "이름을";
			tfName.requestFocus();
			
		} else if(tfTelno.getText().trim().length() == 0) {
			i++;
			result = "전화번호를";
			tfTelno.requestFocus();
			
		}else if(tfEmail.getText().trim().length() == 0) {
			i++;
			result = "이메일을";
			tfEmail.requestFocus();
			
		}else if(tfEmail2.getText().trim().length() == 0) {
			i++;
			result = "이메일을";
			tfEmail2.requestFocus();
			
		}
		
		if(i > 0) {
			JOptionPane.showMessageDialog(null, result + "확인하세요!");
		}
		
		return i;
	}
	
	// Id 중복체크
	private void staffIdCheck() {
		
		int staff_id = Integer.parseInt(tfId.getText());
		
		HS_StaffSignupDao dao = new HS_StaffSignupDao(staff_id);
		int count = dao.staffIdCheck();
		
		
		if(count == 0) {
			JOptionPane.showMessageDialog(null, staff_id + "는(은) 사용 가능한 아이디입니다");
			pfPw.requestFocus();
			
		} else {
			JOptionPane.showMessageDialog(null, staff_id + "는(은) 중복된 아이디입니다.");
			tfId.requestFocus();
			tfId.setText("");
			
		}

		
	}
	
	
	
	
	
	//회원가입
	private void staffSignUp() {
		
		int staff_id = Integer.parseInt(tfId.getText());
		String staff_pw = pfPw.getText();
		String staff_name = tfName.getText();
		String staff_telno = tfTelno.getText();
		String staff_email = tfEmail.getText();
		String staff_email2 = tfEmail2.getText();
		
		String email = staff_email +"@"+ staff_email2;
		
		// Image File
		FileInputStream input = null;
		File file = new File(tfFilepath.getText());
		try {
			input = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HS_StaffSignupDao dao = new HS_StaffSignupDao(staff_id,staff_pw, staff_name, staff_telno, email, input);
		int count = dao.staffSignUp();
		
		if(count == 1) {
			JOptionPane.showMessageDialog(null, "회원가입 완료");
			HS_StaffLogin.main(null);
			frame.setVisible(false);
		} else {
			JOptionPane.showMessageDialog(null, "회원가입 실패");
			HS_StaffLogin.main(null);
			frame.setVisible(false);
		}
		
	}
	
	
	private void FilePath() {
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG, PNG, BMP", "jpg","png","bmp");
		chooser.setFileFilter(filter);
		
		int ret = chooser.showOpenDialog(null);
		if(ret != JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(null, "파일을 선택해주세요!", "오류", JOptionPane.WARNING_MESSAGE);
			return;
		}
		String filePath = chooser.getSelectedFile().getPath();
		tfFilepath.setText(filePath);
		lblImage.setIcon(new ImageIcon(filePath));
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}//end
