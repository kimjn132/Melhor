package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.javalec.dao.AppJoinDao;
import com.javalec.dao.AppLoginDao;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AppJoin {

	private JFrame frmMelhor;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_1_1;
	private JTextField tfId;
	private JTextField tfPw;
	private JLabel lblNewLabel_1_1_1;
	private JTextField tfNickname;
	private JLabel lblNewLabel_1_1_2;
	private JTextField tfPwCheck;
	private JButton btnIdCheck;
	private JButton btnJoin;
	private JLabel lblIdCheckMs;
	private JLabel lblPwCheckMs;
	private JLabel lblTelNo;
	private JTextField tfTelno;
	private JLabel lblTelNo_1;
	private JComboBox<Integer> cbMonth;
	private JComboBox<Integer> cbDay;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_2_1;
	private JLabel lblNewLabel_2_2;
	private JComboBox<Integer> cbYear;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppJoin window = new AppJoin();
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
	public AppJoin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMelhor = new JFrame();
		frmMelhor.setTitle("Melhor 회원가입");
		frmMelhor.getContentPane().setBackground(new Color(254, 255, 255));
		frmMelhor.setBounds(100, 100, 273, 469);
		frmMelhor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMelhor.getContentPane().setLayout(null);
		frmMelhor.getContentPane().add(getLblNewLabel());
		frmMelhor.getContentPane().add(getLblNewLabel_1());
		frmMelhor.getContentPane().add(getLblNewLabel_1_1());
		frmMelhor.getContentPane().add(getTfId());
		frmMelhor.getContentPane().add(getTfPw());
		frmMelhor.getContentPane().add(getLblNewLabel_1_1_1());
		frmMelhor.getContentPane().add(getTfNickname());
		frmMelhor.getContentPane().add(getLblNewLabel_1_1_2());
		frmMelhor.getContentPane().add(getTfPwCheck());
		frmMelhor.getContentPane().add(getBtnIdCheck());
		frmMelhor.getContentPane().add(getBtnJoin());
		frmMelhor.getContentPane().add(getLblIdCheckMs());
		frmMelhor.getContentPane().add(getLblPwCheckMs());
		frmMelhor.getContentPane().add(getLblTelNo());
		frmMelhor.getContentPane().add(getTfTelno());
		frmMelhor.getContentPane().add(getLblTelNo_1());
		frmMelhor.getContentPane().add(getCbMonth());
		frmMelhor.getContentPane().add(getCbDay());
		frmMelhor.getContentPane().add(getLblNewLabel_2());
		frmMelhor.getContentPane().add(getLblNewLabel_2_1());
		frmMelhor.getContentPane().add(getLblNewLabel_2_2());
		frmMelhor.getContentPane().add(getCbYear());

	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("회원가입");
			lblNewLabel.setBounds(30, 6, 176, 29);
		}
		return lblNewLabel;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("아이디:");
			lblNewLabel_1.setBounds(7, 91, 37, 16);
		}
		return lblNewLabel_1;
	}

	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("패스워드:");
			lblNewLabel_1_1.setBounds(6, 133, 60, 21);
		}
		return lblNewLabel_1_1;
	}

	private JTextField getTfId() {
		if (tfId == null) {
			tfId = new JTextField();
			tfId.setBounds(88, 91, 130, 26);
			tfId.setColumns(10);
		}
		return tfId;
	}

	private JTextField getTfPw() {
		if (tfPw == null) {
			tfPw = new JTextField();
			tfPw.setBounds(87, 138, 130, 26);
			tfPw.setColumns(10);
		}
		return tfPw;
	}

	private JLabel getLblNewLabel_1_1_1() {
		if (lblNewLabel_1_1_1 == null) {
			lblNewLabel_1_1_1 = new JLabel("닉네임:");
			lblNewLabel_1_1_1.setBounds(8, 54, 37, 16);
		}
		return lblNewLabel_1_1_1;
	}

	private JTextField getTfNickname() {
		if (tfNickname == null) {
			tfNickname = new JTextField();
			tfNickname.setColumns(10);
			tfNickname.setBounds(88, 54, 130, 26);
		}
		return tfNickname;
	}

	private JLabel getLblNewLabel_1_1_2() {
		if (lblNewLabel_1_1_2 == null) {
			lblNewLabel_1_1_2 = new JLabel("패스워드확인:");
			lblNewLabel_1_1_2.setBounds(6, 169, 79, 21);
		}
		return lblNewLabel_1_1_2;
	}

	private JTextField getTfPwCheck() {
		if (tfPwCheck == null) {
			tfPwCheck = new JTextField();
			tfPwCheck.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					customer_pwCheck();
				}
			});
			
		
			tfPwCheck.setColumns(10);
			tfPwCheck.setBounds(87, 171, 130, 26);
		}
		return tfPwCheck;
	}

	private JButton getBtnIdCheck() {
		if (btnIdCheck == null) {
			btnIdCheck = new JButton("중복확인");
			btnIdCheck.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					customer_IdCheck();
				}
			});

			btnIdCheck.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
			btnIdCheck.setBounds(181, 118, 37, 16);
		}
		return btnIdCheck;
	}

	private JButton getBtnJoin() {
		if (btnJoin == null) {
			btnJoin = new JButton("가입할래요!");
			btnJoin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					int check = insertFieldCheck();
					if (check == 0) {
						insertAction();
					}

				}
			});
			btnJoin.setBackground(new Color(235, 199, 189));
			btnJoin.setBounds(80, 358, 117, 29);
		}
		return btnJoin;
	}

	private JLabel getLblIdCheckMs() {
		if (lblIdCheckMs == null) {
			lblIdCheckMs = new JLabel("");
			lblIdCheckMs.setFont(new Font("Lucida Grande", Font.PLAIN, 6));
			lblIdCheckMs.setBounds(88, 118, 93, 16);
		}
		return lblIdCheckMs;
	}

	private JLabel getLblPwCheckMs() {
		if (lblPwCheckMs == null) {
			lblPwCheckMs = new JLabel("");
			lblPwCheckMs.addKeyListener(new KeyAdapter() {
			
				@Override
				public void keyReleased(KeyEvent e) {
					customer_pwCheck();
				}
			});
		
			lblPwCheckMs.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
			lblPwCheckMs.setBounds(62, 194, 156, 16);
		}
		return lblPwCheckMs;
	}
	
	private JLabel getLblTelNo() {
		if (lblTelNo == null) {
			lblTelNo = new JLabel("전화번호");
			lblTelNo.setBounds(7, 214, 61, 16);
		}
		return lblTelNo;
	}

	private JTextField getTfTelno() {
		if (tfTelno == null) {
			tfTelno = new JTextField();
			tfTelno.setBounds(88, 211, 130, 26);
			tfTelno.setColumns(10);
		}
		return tfTelno;
	}

	private JLabel getLblTelNo_1() {
		if (lblTelNo_1 == null) {
			lblTelNo_1 = new JLabel("생년월일");
			lblTelNo_1.setBounds(7, 252, 61, 16);
		}
		return lblTelNo_1;
	}
	
	private JComboBox getCbYear() {
		if (cbYear == null) {

			cbYear = new JComboBox();
			for (int i = 2022; i >= 1990; i--) {
				cbYear.addItem(i);
			}
			cbYear.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
			cbYear.setBounds(80, 248, 75, 27);
		}
		return cbYear;
	}

	private JComboBox getCbMonth() {
		if (cbMonth == null) {
			cbMonth = new JComboBox();
			for (int j = 1; j < 13; j++) {
				cbMonth.addItem(j);
			}
			cbMonth.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
			cbMonth.setBounds(80, 290, 68, 27);
		}
		return cbMonth;
	}

	private JComboBox getCbDay() {
		if (cbDay == null) {
			cbDay = new JComboBox();
			for (int k = 1; k < 32; k++) {
				cbDay.addItem(k);
			}
			cbDay.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
			cbDay.setBounds(160, 290, 68, 27);
		}
		return cbDay;
	}

	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("월");
			lblNewLabel_2.setBounds(144, 293, 11, 16);
		}
		return lblNewLabel_2;
	}

	private JLabel getLblNewLabel_2_1() {
		if (lblNewLabel_2_1 == null) {
			lblNewLabel_2_1 = new JLabel("일");
			lblNewLabel_2_1.setBounds(226, 293, 11, 16);
		}
		return lblNewLabel_2_1;
	}

	private JLabel getLblNewLabel_2_2() {
		if (lblNewLabel_2_2 == null) {
			lblNewLabel_2_2 = new JLabel("년");
			lblNewLabel_2_2.setBounds(160, 252, 11, 16);
		}
		return lblNewLabel_2_2;
	}

	

	// -------------Function-------------

	// 닉네임, 아이디, 패스워드 입력
	private void insertAction() {

		String customer_nickname = tfNickname.getText();
		String customer_id = tfId.getText();
		String customer_pw = tfPw.getText();
		String customer_telno = tfPw.getText();
		
//		String customer_birthday = cbYear.getSelectedItem().toString() + " - " + cbMonth.getSelectedItem().toString() + " - " + cbDay.getSelectedItem().toString();


		AppJoinDao dao = new AppJoinDao(customer_nickname, customer_id, customer_pw, customer_telno);
		int insert = dao.insertAction();


		frmMelhor.setVisible(false);
		AppLogin.main(null);

	}

	// 닉네임, 아이디, 비밀번호 입력 확인
	private int insertFieldCheck() {
		int i = 0;
		String message = "";

		if (tfNickname.getText().trim().length() == 0) {
			i++;
			message = "닉네임을 ";
			tfNickname.requestFocus();

		} else if (tfId.getText().trim().length() == 0) {
			i++;
			message = "아이디를 ";
			tfId.requestFocus();
		} else if (tfPw.getText().trim().length() == 0) {
			i++;
			message = "비밀번호를 ";
			tfPw.requestFocus();
		} else if (tfPwCheck.getText().trim().length() == 0) {
			i++;
			message = "비밀번호를 ";
			tfPw.requestFocus();
		} else if (tfTelno.getText().trim().length() == 0) {
			i++;
			message = "전화번호를 ";
			tfTelno.requestFocus();
		} 

		if (i > 0) {
			JOptionPane.showMessageDialog(null, message + "확인하세요!");
		}
		return i;
	}
	

	// 아이디 중복체크
	private void customer_IdCheck() {
		String customer_Id = tfId.getText();

		AppJoinDao dao = new AppJoinDao(customer_Id);
		int check = dao.customer_idCheck(customer_Id);
		if (check == 0) {

			lblIdCheckMs.setText(customer_Id + "는 사용 가능합니다.");
		
		} else {
			lblIdCheckMs.setText(customer_Id + "는 사용 불가합니다.");
			
		}

	}

	// 패스워드 일치 여부 체크
	private void customer_pwCheck() {
		String customer_pw = tfPw.getText();
		String customer_pw1 = tfPwCheck.getText();
		// 패스워드 체크하여 1이 나오면 패스워드가 같다는 뜻이므로 하단 메시지를 띄운다.
		if (customer_pw1.equals(customer_pw)) {
			lblPwCheckMs.setText("패스워드가 일치합니다.");
		} else {
			lblPwCheckMs.setText("패스워드를 다시 입력하세요.");
		}

	}
	
	// 추가할 것: 아이디, 패스워드 체킹 후 둘다 중복없고, 패스워드 일치해야만 가입 가능하도록 하기 

	
}
