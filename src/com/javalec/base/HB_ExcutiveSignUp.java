package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.javalec.dao.HB_ExcutiveLoginDao;
import com.javalec.dao.HB_ExcutiveSignDao;
import com.javalec.dto.HB_ExcutiveSignDto;
import com.javalec.util.HB_Static;

import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class HB_ExcutiveSignUp {

	private JFrame frame;
	private JTextField tfEmployeeID;
	private JButton btnEmailCheck;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JPasswordField tfEmployeePw;
	private JPasswordField tfEmployeePwCheck;
	private JLabel lblNewLabel_1_1;
	private JLabel lblNewLabel_2;
	private JTextField tfEmployeeName;
	private JLabel lblNewLabel_2_1;
	private JTextField tfEmployeeTelno;
	private JLabel lblNewLabel_2_1_1;
	private JTextField tfEmployeeEmail;
	private JTextField tfEmployeeEmail2;
	private JComboBox comboBox;
	private JButton btnBackPage;
	private JButton btnSignOk;
	private JLabel lblPwCheck;
	private JButton btnFilePath;
	private JLabel lblImage;
	private JTextField tfFilePath;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HB_ExcutiveSignUp window = new HB_ExcutiveSignUp();
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
	public HB_ExcutiveSignUp() {
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
				
				getEmployeeId();
				
			}
		});
		frame.setTitle("임원 회원가입");
		frame.setBounds(100, 100, 716, 418);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getTfEmployeeID());
		frame.getContentPane().add(getBtnEmailCheck());
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getTfEmployeePw());
		frame.getContentPane().add(getTfEmployeePwCheck());
		frame.getContentPane().add(getLblNewLabel_1_1());
		frame.getContentPane().add(getLblNewLabel_2());
		frame.getContentPane().add(getTfEmployeeName());
		frame.getContentPane().add(getLblNewLabel_2_1());
		frame.getContentPane().add(getTfEmployeeTelno());
		frame.getContentPane().add(getLblNewLabel_2_1_1());
		frame.getContentPane().add(getTfEmployeeEmail());
		frame.getContentPane().add(getTfEmployeeEmail2());
		frame.getContentPane().add(getComboBox());
		frame.getContentPane().add(getBtnBackPage());
		frame.getContentPane().add(getBtnSignOk());
		frame.getContentPane().add(getLblPwCheck());
		frame.getContentPane().add(getBtnFilePath());
		frame.getContentPane().add(getLblImage());
		frame.getContentPane().add(getTfFilePath());
		frame.getContentPane().add(getBtnNewButton());
	}
	private JTextField getTfEmployeeID() {
		if (tfEmployeeID == null) {
			tfEmployeeID = new JTextField();
			tfEmployeeID.setEditable(false);
			tfEmployeeID.setToolTipText("");
			tfEmployeeID.setBounds(271, 23, 164, 34);
			tfEmployeeID.setColumns(10);
		}
		return tfEmployeeID;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("아이디");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(178, 23, 61, 34);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("비밀번호");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setBounds(178, 67, 61, 34);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("비밀번호 확인");
			lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_1.setBounds(168, 112, 91, 34);
		}
		return lblNewLabel_1_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("이름");
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setBounds(178, 154, 61, 34);
		}
		return lblNewLabel_2;
	}
	private JTextField getTfEmployeeName() {
		if (tfEmployeeName == null) {
			tfEmployeeName = new JTextField();
			tfEmployeeName.setToolTipText("");
			tfEmployeeName.setColumns(10);
			tfEmployeeName.setBounds(271, 154, 164, 34);
		}
		return tfEmployeeName;
	}
	private JLabel getLblNewLabel_2_1() {
		if (lblNewLabel_2_1 == null) {
			lblNewLabel_2_1 = new JLabel("전화번호");
			lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2_1.setBounds(178, 198, 61, 34);
		}
		return lblNewLabel_2_1;
	}
	private JTextField getTfEmployeeTelno() {
		if (tfEmployeeTelno == null) {
			tfEmployeeTelno = new JTextField();
			tfEmployeeTelno.setToolTipText("");
			tfEmployeeTelno.setColumns(10);
			tfEmployeeTelno.setBounds(271, 198, 164, 34);
		}
		return tfEmployeeTelno;
	}
	private JLabel getLblNewLabel_2_1_1() {
		if (lblNewLabel_2_1_1 == null) {
			lblNewLabel_2_1_1 = new JLabel("이메일");
			lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2_1_1.setBounds(106, 242, 61, 34);
		}
		return lblNewLabel_2_1_1;
	}
	private JTextField getTfEmployeeEmail() {
		if (tfEmployeeEmail == null) {
			tfEmployeeEmail = new JTextField();
			tfEmployeeEmail.setToolTipText("");
			tfEmployeeEmail.setColumns(10);
			tfEmployeeEmail.setBounds(178, 243, 164, 34);
		}
		return tfEmployeeEmail;
	}
	private JTextField getTfEmployeeEmail2() {
		if (tfEmployeeEmail2 == null) {
			tfEmployeeEmail2 = new JTextField();
			tfEmployeeEmail2.setBounds(354, 243, 119, 34);
			tfEmployeeEmail2.setColumns(10);
		}
		return tfEmployeeEmail2;
	}
	private JLabel getLblPwCheck() {
		if (lblPwCheck == null) {
			lblPwCheck = new JLabel("");
			lblPwCheck.setBounds(447, 123, 215, 21);
		}
		return lblPwCheck;
	}
	private JLabel getLblImage() {
		if (lblImage == null) {
			lblImage = new JLabel("image");
			lblImage.setHorizontalAlignment(SwingConstants.CENTER);
			lblImage.setBounds(12, 23, 155, 144);
		}
		return lblImage;
	}
	private JTextField getTfFilePath() {
		if (tfFilePath == null) {
			tfFilePath = new JTextField();
			tfFilePath.setEditable(false);
			tfFilePath.setVisible(false);
			tfFilePath.setBounds(12, 205, 154, 21);
			tfFilePath.setColumns(10);
		}
		return tfFilePath;
	}
	// --------------------- Action Listener -------------------------------------------------------------------------------------------------
	private JButton getBtnBackPage() {
		if (btnBackPage == null) {
			btnBackPage = new JButton("이전페이지");
			btnBackPage.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					HB_ExcutiveLogin.main(null);
					frame.setVisible(false);
				}
			});
			btnBackPage.setBounds(168, 317, 129, 42);
		}
		return btnBackPage;
	}
	private JButton getBtnEmailCheck() {
		if (btnEmailCheck == null) {
			btnEmailCheck = new JButton("중복체크");
			btnEmailCheck.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					employeeEmailCheck();
					
				}
			});
			btnEmailCheck.setBounds(587, 242, 90, 34);
		}
		return btnEmailCheck;
	}
	private JButton getBtnSignOk() {
		if (btnSignOk == null) {
			btnSignOk = new JButton("회원가입 완료");
			btnSignOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					int tfcheck = insertFieldCheck();
					if(tfcheck == 0) {
						
						if(HB_Static.signUpEmailCheck() == 1 && lblPwCheck.getText() == "PW가 동일합니다.") {
							employeeSignUp();

						} else if(HB_Static.signUpEmailCheck() == 0){
							JOptionPane.showMessageDialog(null, "Email 중복체크를 확인하세요.");
							
						} else if(lblPwCheck.getText() == "PW가 동일하지 않습니다.") {
							JOptionPane.showMessageDialog(null, "PW가 동일하지 않습니다.");
							tfEmployeePwCheck.requestFocus();
						}
					}
					
					
					
				}
			});
			btnSignOk.setBounds(333, 317, 129, 42);
		}
		return btnSignOk;
	}
	private JPasswordField getTfEmployeePw() {
		if (tfEmployeePw == null) {
			tfEmployeePw = new JPasswordField();
			tfEmployeePw.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					
					if(tfEmployeePw.getText().equals(tfEmployeePwCheck.getText().trim())) {
						lblPwCheck.setText("PW가 동일합니다.");

					} else {
						lblPwCheck.setText("PW가 동일하지 않습니다.");			
					}
				}
			});
			tfEmployeePw.setBounds(271, 67, 164, 34);
		}
		return tfEmployeePw;
	}
	private JPasswordField getTfEmployeePwCheck() {
		if (tfEmployeePwCheck == null) {
			tfEmployeePwCheck = new JPasswordField();
			tfEmployeePwCheck.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					
					if(tfEmployeePw.getText().equals(tfEmployeePwCheck.getText().trim())) {
						lblPwCheck.setText("PW가 동일합니다.");

					} else {
						lblPwCheck.setText("PW가 동일하지 않습니다.");			
					}
				}
			});
			tfEmployeePwCheck.setBounds(271, 110, 164, 34);
		}
		return tfEmployeePwCheck;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(comboBox.getSelectedItem() == "직접입력") {
						tfEmployeeEmail2.setEditable(true);
					} else if(comboBox.getSelectedItem() == "@naver.com") {
						tfEmployeeEmail2.setText("@naver.com");
						tfEmployeeEmail2.setEditable(false);
					
					} else if(comboBox.getSelectedItem() == "@daum.net") {
						tfEmployeeEmail2.setText("@daum.net");
						tfEmployeeEmail2.setEditable(false);
					
					} else if(comboBox.getSelectedItem() == "@nate.com") {
						tfEmployeeEmail2.setText("@nate.com");
						tfEmployeeEmail2.setEditable(false);
					}
				}
			});
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"직접입력", "@naver.com", "@daum.net", "@nate.com"}));
			comboBox.setBounds(477, 242, 98, 34);
		}
		return comboBox;
	}
	private JButton getBtnFilePath() {
		if (btnFilePath == null) {
			btnFilePath = new JButton("FIle");
			btnFilePath.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					FilePath();
				}
			});
			btnFilePath.setBounds(87, 176, 80, 21);
		}
		return btnFilePath;
	}
	
	// --------------------- Action Listener ----------------------

	
	
	private int insertFieldCheck() {
		
		int i = 0;
		String result = "";
		
		if(tfEmployeePw.getText().trim().length() == 0) {
			i++;
			result = "PW를 ";
			tfEmployeePw.requestFocus();
			
		} else if(tfEmployeePwCheck.getText().trim().length() == 0) {
			i++;
			result = "PW확인을 ";
			tfEmployeePwCheck.requestFocus();
			
		} else if(tfEmployeeName.getText().trim().length() == 0) {
			i++;
			result = "이름을 ";
			tfEmployeeName.requestFocus();
			
		} else if(tfEmployeeTelno.getText().trim().length() == 0) {
			i++;
			result = "전화번호를 ";
			tfEmployeeTelno.requestFocus();
			
		}else if(tfEmployeeEmail.getText().trim().length() == 0) {
			i++;
			result = "이메일을 ";
			tfEmployeeEmail.requestFocus();
			
		}else if(tfEmployeeEmail2.getText().trim().length() == 0) {
			i++;
			result = "이메일을 ";
			tfEmployeeEmail2.requestFocus();
			
		}
		
		if(i > 0) {
			JOptionPane.showMessageDialog(null, result + "확인하세요!");
		}
		
		return i;
	}
	
	String email = "";
	
	private void getEmployeeId() {
		HB_ExcutiveSignDao dao1 = new HB_ExcutiveSignDao();
		ArrayList<HB_ExcutiveSignDto> dto = dao1.getEmployeeId();
		
		tfEmployeeID.setText(Integer.toString(dto.get(0).getEmployeeId() + 1));
		
	}
	
	private void employeeSignUp() {
		
		int employee_id = Integer.parseInt(tfEmployeeID.getText());
		String employee_pw = tfEmployeePw.getText();
		String employee_name = tfEmployeeName.getText();
		String employee_telno = tfEmployeeTelno.getText();
		
		String employee_email = tfEmployeeEmail.getText();
		String employee_email2 = tfEmployeeEmail2.getText();
		email = employee_email + employee_email2;
		
		
		// Image File
		FileInputStream input = null;
		File file = new File(tfFilePath.getText());
		try {
			input = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		HB_ExcutiveSignDao dao2 = new HB_ExcutiveSignDao(employee_id,employee_pw, employee_name, employee_telno, email, input);
		int count = dao2.employeeSignUp();
		
		if(count == 1) {
			JOptionPane.showMessageDialog(null, "회원가입 완료");
			HB_ExcutiveLogin.main(null);
			frame.setVisible(false);
		} else {
			JOptionPane.showMessageDialog(null, "회원가입 실패");
		}
		
	}
	
	// email 중복체크
	private void employeeEmailCheck() {

		String employee_email = tfEmployeeEmail.getText() + tfEmployeeEmail2.getText();

		HB_ExcutiveSignDao dao = new HB_ExcutiveSignDao(employee_email);
		int count = dao.excutiveEmailCheck();
		int check = 0;

		if (count == 0) {
			JOptionPane.showMessageDialog(null, email + "는(은) 사용 가능한 이메일입니다");
			check = 1;
		} else {
			JOptionPane.showMessageDialog(null, email + "는(은) 중복된 이메일입니다.");
			tfEmployeeEmail.requestFocus();
			tfEmployeeEmail.setText("");

		}

		HB_Static.setSignUpIdCheck(check);

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
	
	
	
	// 이미지 업데이트
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("이지미 업데이트");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					update();
					
				}
			});
			btnNewButton.setBounds(12, 307, 91, 23);
		}
		return btnNewButton;
	}
	
	
	private void update() {
		
		// Image File
		FileInputStream input = null;
		File file = new File(tfFilePath.getText());
		try {
			input = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		HB_ExcutiveSignDao dao = new HB_ExcutiveSignDao(input);
		dao.update();
	}
	// 이미지 업데이트
	
	
	
	
	
	
} // End Line
