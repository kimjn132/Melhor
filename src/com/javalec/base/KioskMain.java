package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
//import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;

import com.javalec.dao.KioskDao;
import com.javalec.dto.KioskDto;
import com.javalec.util.Static_ProductInfo;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JComboBox;

public class KioskMain {
//	private JFrame frame;
	private JFrame frmMelhorCoffeeKiosk;
	private JLabel lblTake;
	private JLabel lblShop;
	private JLabel background;
	private int count = 0;
	
	String[] backImg = new String[]{"/com/javalec/img/MelXCard.png","/com/javalec/img/MelXBig.png"};
	private JComboBox cbShop;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KioskMain window = new KioskMain();
					window.frmMelhorCoffeeKiosk.setVisible(true);	
					window.frmMelhorCoffeeKiosk.setLocationRelativeTo(null);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public KioskMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMelhorCoffeeKiosk = new JFrame();
		frmMelhorCoffeeKiosk.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				Timer timer = new Timer();
				TimerTask task = new TimerTask() {
					
					@Override
					public void run() { // 일정 시간마다 Kiosk Main의 광고화면이 바뀌도록, 스위치로 이미지 변환 
						count++;
						switch(count%3) {
						case 1 : background.setIcon(new ImageIcon(KioskMain.class.getResource(backImg[0])));	break;
						case 2 : background.setIcon(new ImageIcon(KioskMain.class.getResource(backImg[1])));	break;
				
						}
						
					}
				};
				
				timer.schedule(task, 0, 1400);

			}
		});
		
		frmMelhorCoffeeKiosk.setTitle("Melhor Coffee Kiosk Main - 4Team");
		frmMelhorCoffeeKiosk.setBounds(100, 100, 440, 800);
		frmMelhorCoffeeKiosk.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMelhorCoffeeKiosk.getContentPane().setLayout(null);
		frmMelhorCoffeeKiosk.getContentPane().add(getCbShop());
		frmMelhorCoffeeKiosk.getContentPane().add(getLblTake());
		frmMelhorCoffeeKiosk.getContentPane().add(getLblShop());
		frmMelhorCoffeeKiosk.getContentPane().add(getBackground());
	
		
	}
	
	private JLabel getLblTake() {
		if (lblTake == null) {
			lblTake = new JLabel("포장");
			lblTake.setIcon(new ImageIcon(KioskMain.class.getResource("/com/javalec/img/takeout.png")));
			lblTake.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					//포장 마우스 클릭 , product 에서 포장정보 저장 
					frmMelhorCoffeeKiosk.setVisible(false);
					KioskOrdersCoffee.main(null);
					Static_ProductInfo.InOut=false;
					System.out.println();
					
				}
			});
			lblTake.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
			lblTake.setBounds(114, 635, 75, 50);
		}
		return lblTake;
	}
	private JLabel getLblShop() {
		if (lblShop == null) {
			lblShop = new JLabel("매장");
			lblShop.setIcon(new ImageIcon(KioskMain.class.getResource("/com/javalec/img/takein.png")));
			lblShop.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					//매장 마우스 클릭  product 에서 매장 정보 저장 
					frmMelhorCoffeeKiosk.setVisible(false);
					KioskOrdersCoffee.main(null);
					Static_ProductInfo.InOut=true;
				}
			});
			lblShop.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
			lblShop.setBounds(253, 635, 75, 50);
		}
		return lblShop;
	}
	
	
	private JLabel getBackground() {
		if (background == null) {
			background = new JLabel("");
			background.setIcon(new ImageIcon(KioskMain.class.getResource("/com/javalec/img/MelXBig.png")));
			background.setBounds(0, 0, 440, 766);
		}
		return background;
	}//getBackground End
	
	
	
	
	
	
	private JComboBox getCbShop() {  // 콤보박스 지점 
		if (cbShop == null) {
			cbShop = new JComboBox();
			cbShop.setBounds(321, 39, 113, 27);
		}
		return cbShop;
	}
	
	
	
	
	
	
	//////////////////////////////
	
	cbInsertShopid combo<KioskDto> = new cbInsert
	
	
}// Class End
