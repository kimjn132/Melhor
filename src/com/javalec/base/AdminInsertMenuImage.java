package com.javalec.base;

import java.awt.EventQueue;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.javalec.dao.AdminInsertMenuImageDao;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminInsertMenuImage {

	private JFrame frame;
	private JLabel lblImage;
	private JTextField tfFilePath;
	private JButton btnFilePath;
	private JButton btnNewButton;
	private JTextField tfFilename;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminInsertMenuImage window = new AdminInsertMenuImage();
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
	public AdminInsertMenuImage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblImage());
		frame.getContentPane().add(getTfFilePath());
		frame.getContentPane().add(getBtnFilePath());
		frame.getContentPane().add(getBtnNewButton());
		frame.getContentPane().add(getTfFilename());
	}

	private JLabel getLblImage() {
		if (lblImage == null) {
			lblImage = new JLabel("New label");
			lblImage.setBounds(50, 79, 80, 74);
		}
		return lblImage;
	}
	private JTextField getTfFilePath() {
		if (tfFilePath == null) {
			tfFilePath = new JTextField();
			tfFilePath.setEditable(false);
			tfFilePath.setBounds(47, 208, 96, 21);
			tfFilePath.setColumns(10);
		}
		return tfFilePath;
	}
	private JButton getBtnFilePath() {
		if (btnFilePath == null) {
			btnFilePath = new JButton("파일 경로");
			btnFilePath.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					FilePath();
				}
				
			});
			btnFilePath.setBounds(172, 207, 91, 23);
		}
		return btnFilePath;
	}
	
	// insert()
	//===============================================================
	
	private void UpdateAction(){
		
		// Image File
		FileInputStream input = null;
		File file = new File(tfFilePath.getText());
		try {
			input = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String filename = tfFilename.getText().trim();
		
		AdminInsertMenuImageDao dbaction = new AdminInsertMenuImageDao(input, filename);
		boolean aaa = dbaction.UpdateAction();
		if(aaa == true){
	          JOptionPane.showMessageDialog(null, "정보가 입력 되었습니다.");                    
		}else{
	          JOptionPane.showMessageDialog(null, "DB에 자료 입력중 에러가 발생했습니다! \n 시스템관리자에 문의하세요!");                    
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
	
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("입력");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					UpdateAction();
				}
			});
			btnNewButton.setBounds(172, 248, 91, 23);
		}
		return btnNewButton;
	}
	private JTextField getTfFilename() {
		if (tfFilename == null) {
			tfFilename = new JTextField();
			tfFilename.setBounds(47, 249, 96, 21);
			tfFilename.setColumns(10);
		}
		return tfFilename;
	}
}
