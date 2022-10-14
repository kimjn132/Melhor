package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.javalec.dao.AppMenuImageInsertDao;
import com.javalec.util.Static_CustomerId;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;

public class AppMenuImageInsert {

	private JFrame frmMelhor;
	private JButton btnimageinsert;
	private JTextField tfFilePath;
	private JTextField tfProductName;
	private JTextField tfProductPrice;
	private JLabel lblImage;
	private JButton btnInsert;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextPane tpRecipe;
	private JTextPane tpExplain;
	private JLabel lblNewLabel_4;
	private JTextField tfCategory;
	private JScrollBar scrollBar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMenuImageInsert window = new AppMenuImageInsert();
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
	public AppMenuImageInsert() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMelhor = new JFrame();
		frmMelhor.getContentPane().setBackground(new Color(254, 255, 255));
		frmMelhor.setTitle("Melhor- 제품입력");
		frmMelhor.setBounds(100, 100, 300, 500);
		frmMelhor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMelhor.getContentPane().setLayout(null);
		frmMelhor.getContentPane().add(getBtnimageinsert());
		frmMelhor.getContentPane().add(getTfFilePath());
		frmMelhor.getContentPane().add(getTfProductName());
		frmMelhor.getContentPane().add(getTfProductPrice());
		frmMelhor.getContentPane().add(getLblImage());
		frmMelhor.getContentPane().add(getBtnInsert());
		frmMelhor.getContentPane().add(getLblNewLabel());
		frmMelhor.getContentPane().add(getLblNewLabel_1());
		frmMelhor.getContentPane().add(getLblNewLabel_2());
		frmMelhor.getContentPane().add(getLblNewLabel_3());
		frmMelhor.getContentPane().add(getTpRecipe());
		frmMelhor.getContentPane().add(getTpExplain());
		frmMelhor.getContentPane().add(getLblNewLabel_4());
		frmMelhor.getContentPane().add(getTfCategory());
		frmMelhor.getContentPane().add(getScrollBar());
	}
	
	
	
	
	
	private JButton getBtnimageinsert() {
		if (btnimageinsert == null) {
			btnimageinsert = new JButton("파일insert");
			btnimageinsert.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					FilePath();
				}
			});
			btnimageinsert.setBounds(169, 333, 117, 29);
		}
		return btnimageinsert;
	}
	
	private JTextField getTfFilePath() {
		if (tfFilePath == null) {
			tfFilePath = new JTextField();
			tfFilePath.setBounds(30, 333, 130, 26);
			tfFilePath.setColumns(10);
		}
		return tfFilePath;
	}
	private JTextField getTfProductName() {
		if (tfProductName == null) {
			tfProductName = new JTextField();
			tfProductName.setBounds(119, 6, 130, 26);
			tfProductName.setColumns(10);
		}
		return tfProductName;
	}
	private JTextField getTfProductPrice() {
		if (tfProductPrice == null) {
			tfProductPrice = new JTextField();
			tfProductPrice.setBounds(119, 60, 130, 26);
			tfProductPrice.setColumns(10);
		}
		return tfProductPrice;
	}
	private JLabel getLblImage() {
		if (lblImage == null) {
			lblImage = new JLabel("New label");
			lblImage.setBounds(18, 371, 156, 95);
		}
		return lblImage;
	}
	private JButton getBtnInsert() {
		if (btnInsert == null) {
			btnInsert = new JButton("입력");
			btnInsert.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					insertImage();
				}
			});
			btnInsert.setBounds(169, 405, 117, 29);
		}
		return btnInsert;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("제품이름");
			lblNewLabel.setBounds(18, 11, 61, 16);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("제품가격");
			lblNewLabel_1.setBounds(18, 65, 61, 16);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("제품레시피");
			lblNewLabel_2.setBounds(18, 110, 61, 16);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("제품설명");
			lblNewLabel_3.setBounds(18, 222, 61, 16);
		}
		return lblNewLabel_3;
	}
	
	
	private void insertImage(){
		String product_name = tfProductName.getText();
		int product_price = Integer.parseInt(tfProductPrice.getText());
		String product_recipe = tpRecipe.getText();
		String product_explain = tpExplain.getText();
		String product_category = tfCategory.getText();
		
		
		// Image File
		FileInputStream input = null;
		File file = new File(tfFilePath.getText());
		try {
			input = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		AppMenuImageInsertDao dbaction = new AppMenuImageInsertDao(product_name, input, product_price, product_recipe, product_explain, product_category);
		boolean aaa = dbaction.insertImage();
                 
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
	private JTextPane getTpRecipe() {
		if (tpRecipe == null) {
			tpRecipe = new JTextPane();
			tpRecipe.setBounds(119, 98, 156, 81);
		}
		return tpRecipe;
	}
	private JTextPane getTpExplain() {
		if (tpExplain == null) {
			tpExplain = new JTextPane();
			tpExplain.setBounds(119, 185, 157, 98);
		}
		return tpExplain;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("카테고리");
			lblNewLabel_4.setBounds(18, 298, 61, 16);
		}
		return lblNewLabel_4;
	}
	private JTextField getTfCategory() {
		if (tfCategory == null) {
			tfCategory = new JTextField();
			tfCategory.setBounds(119, 295, 130, 26);
			tfCategory.setColumns(10);
		}
		return tfCategory;
	}
	private JScrollBar getScrollBar() {
		if (scrollBar == null) {
			scrollBar = new JScrollBar();
			scrollBar.setBounds(260, 187, 15, 96);
		}
		return scrollBar;
	}
}
