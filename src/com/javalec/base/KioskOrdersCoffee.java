package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.dao.KioskDao;
import com.javalec.dto.KioskDto;
import com.javalec.dto.KioskOrdersDto;
import com.javalec.util.DBConnect;
import com.javalec.util.Static_OrdersInfo;
import com.javalec.util.Static_ProductInfo;

import javax.swing.JPanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KioskOrdersCoffee {

	private JFrame frmMelhorCoffeeKioskOrders;
	private JLabel lblCoffee;
	private JLabel lblJuice;
	private JLabel lblTea;
	private JLabel lbldessert;
	private JLabel Orders_top_Ads;
	private JLabel lblOrder;
	private JLabel lblResultPrice;
//private static JTable mainMenuInnerTable;
	

	private final DefaultTableModel Outer_Table = new DefaultTableModel();
	private final DefaultTableModel Outer_Table2 = new DefaultTableModel();
	private JLabel bakcground440X766;
	private JScrollPane scrollPane;
	private JTable InnerTable;
	private JScrollPane scrollPane_1;
	private JTable InnerTable2;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KioskOrdersCoffee window = new KioskOrdersCoffee();
					window.frmMelhorCoffeeKioskOrders.setVisible(true);
					window.frmMelhorCoffeeKioskOrders.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public KioskOrdersCoffee() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMelhorCoffeeKioskOrders = new JFrame();
		
		frmMelhorCoffeeKioskOrders.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				tableInit();
				searchAction();
				bottomInit();
				AddKioskCartList();
			}
		});
		
		frmMelhorCoffeeKioskOrders.setTitle("Melhor Coffee Kiosk Orders - 4Team");
		frmMelhorCoffeeKioskOrders.setBounds(100, 100, 440, 800);
		frmMelhorCoffeeKioskOrders.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMelhorCoffeeKioskOrders.getContentPane().setLayout(null);
		frmMelhorCoffeeKioskOrders.getContentPane().add(lblCoffee());
		frmMelhorCoffeeKioskOrders.getContentPane().add(lblJuice());
		frmMelhorCoffeeKioskOrders.getContentPane().add(lblTea());
		frmMelhorCoffeeKioskOrders.getContentPane().add(lbldessert());
		frmMelhorCoffeeKioskOrders.getContentPane().add(kiosk_ads_small_width());
		frmMelhorCoffeeKioskOrders.getContentPane().add(getLblOrder());
		frmMelhorCoffeeKioskOrders.getContentPane().add(getLblResultPrice());
		frmMelhorCoffeeKioskOrders.getContentPane().add(getBakcground440X766());
		frmMelhorCoffeeKioskOrders.getContentPane().add(getScrollPane());
		frmMelhorCoffeeKioskOrders.getContentPane().add(getScrollPane_1());
		
	
	
	
	}
	
		
		
	///// ?????? ???????????? 2??? ????????? ?????????????????? ?????? ?????? ??? ?????? ???????????? 

//	public void backPage() {
//		Timer timer = new Timer();
//		TimerTask task = new TimerTask() {
//		}
//		KioskMain.main(null);
//		KioskOrdersCoffee.setVisible(false);
//			timer.schedule(task, 0, 500);
//	}

	private JLabel lblCoffee() {// ???????????? 
		if (lblCoffee == null) {
			lblCoffee = new JLabel("??????");
			lblCoffee.setBounds(0, 30, 110, 40);
			lblCoffee.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
				
				//?????? ????????? ?????? ?????? ???
				}
			});
			lblCoffee.setHorizontalAlignment(SwingConstants.CENTER);
			lblCoffee.setBackground(new Color(255, 125, 231));
			lblCoffee.setOpaque(true); 
			lblCoffee.setBackground(Color.pink);
		}
		return lblCoffee;
	}// ???????????? 


	private JLabel lblJuice() {// ?????? ?????? 
		if (lblJuice == null) {
			lblJuice = new JLabel("??????");
			lblJuice.setBounds(110, 30, 110, 40);
			lblJuice.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
				}
			});
			lblJuice.setHorizontalAlignment(SwingConstants.CENTER);
			lblJuice.setBackground(new Color(255, 125, 231));
			lblJuice.setOpaque(true); 
			lblJuice.setBackground(Color.orange);
		}
		return lblJuice;
	}// ???????????? 
	
	private JLabel lblTea() { // ??? ?????? 
		if (lblTea == null) {
			lblTea = new JLabel("???");
			lblTea.setBounds(220, 30, 110, 40);
			lblTea.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
				}
			});
			lblTea.setHorizontalAlignment(SwingConstants.CENTER);
			lblTea.setBackground(new Color(255, 125, 231));
			lblTea.setOpaque(true); 
			lblTea.setBackground(Color.BLUE);
		}
		return lblTea;
	}// ??? ?????? 
	
	private JLabel lbldessert() { // ????????? ?????? 
		if (lbldessert == null) {
			lbldessert = new JLabel("?????????");
			lbldessert.setBounds(330, 30, 110, 40);
			lbldessert.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
				}
			});
			lbldessert.setHorizontalAlignment(SwingConstants.CENTER);
			lbldessert.setBackground(new Color(255, 125, 231));
			lbldessert.setOpaque(true); 
			lbldessert.setBackground(Color.yellow);
		}
		return lbldessert;
	}//????????? ?????? 
	
	private JLabel kiosk_ads_small_width() {
		if (Orders_top_Ads == null) {
			Orders_top_Ads = new JLabel("?????? ????????? ????????? ??????");
			Orders_top_Ads.setBounds(0, 0, 440, 30);
			Orders_top_Ads.setIcon(new ImageIcon(KioskMain.class.getResource("/com/javalec/img/TopMelXBig.png")));
		}
		return Orders_top_Ads;
	}
	
	
	
	
	private JLabel getLblOrder() {
		if (lblOrder == null) {
			lblOrder = new JLabel("????????????");
			lblOrder.setBounds(335, 680, 80, 30);
			lblOrder.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {

					
					
					if(AddKioskCartList()) {
					frmMelhorCoffeeKioskOrders.setVisible(false);
					KioskPay.main(null);
					}else {
						JOptionPane.showMessageDialog(null,"????????? ???????????? ???????????? ????????????.");
					}
				}
			});
			lblOrder.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		}
		return lblOrder;
	}
	private JLabel getLblResultPrice() {
		if (lblResultPrice == null) {
			lblResultPrice = new JLabel("???????????????");
			lblResultPrice.setBounds(335, 720, 70, 20);
		}
		return lblResultPrice;
	}
	
	
	//
	

	private JLabel getBakcground440X766() {
		if (bakcground440X766 == null) {
			bakcground440X766 = new JLabel("New label");
			bakcground440X766.setBounds(0, 30, 440, 766);
			bakcground440X766.setIcon(new ImageIcon(KioskOrdersCoffee.class.getResource("/com/javalec/img/MelXBig.png")));
		}
		return bakcground440X766;
	}
	
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(40, 110, 365, 515);
			scrollPane.setViewportView(getInnerTable());
			
		}
		return scrollPane;
	}
	private JTable getInnerTable() {
		if (InnerTable == null) {
			InnerTable = new JTable();
			InnerTable.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					KioskOrdersOption.main(null);
					tableClick();
				}
			});
		}
		InnerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		InnerTable.setModel(Outer_Table);
		return InnerTable;
	}
	
	
	
	
	
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			
			scrollPane_1.setBounds(27, 681, 295, 59);
			scrollPane_1.setViewportView(getInnerTable2());
		}
		return scrollPane_1;
	}
	private JTable getInnerTable2() {
		if (InnerTable2 == null) {
			InnerTable2 = new JTable();
		}
		InnerTable2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				bottomTableClick();
			}
		});
		InnerTable2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		InnerTable2.setModel(Outer_Table2);
		return InnerTable2;
	}
	
	
	// --------------------------
	
	///////////	///////////	///////////	///////////	///////////	///////////	Function	///////////	///////////	///////////	///////////	///////////	///////////	///////////	///////////

	//--> ???????????? ??? ?????? ???????????? 
	//lblResultPrice.setText();
	
	
	/////
	private void tableClick() { // ?????? ????????? ???????????? ?????? ??????????????? ????????? ????????? ?????? ??? 
		
		KioskOrdersOption.main(null);
		
		
		int i = InnerTable.getSelectedRow(); // ????????? ??? ?????? ?????????
		String wkSequence = (String) InnerTable.getValueAt(i, 0); // i?????? ?????? 0??????(Seqno) ?????? wkSequence??? ?????????
		
		Static_ProductInfo.setProduct_id(Integer.parseInt(wkSequence)); //????????? ????????? ?????? ????????? 
		Static_ProductInfo.product_name=(String) InnerTable.getValueAt(i, 1); // ????????? ???????????? ?????????(i,1)??? ???????????? ?????? 
		
		bottomInit();
	//	AddKioskCartInsert();
		
	}
	
	
	private  void tableInit() {
		//Outer_Table.addColumn("????????????");
		Outer_Table.addColumn("??????");
		Outer_Table.addColumn("??????");
		Outer_Table.addColumn("??????");
		

		Outer_Table.setColumnCount(4);

		int i = Outer_Table.getRowCount();
		for (int j = 0; j < i; j++) {
			Outer_Table.removeRow(0);
		}

		InnerTable.setAutoResizeMode(InnerTable.AUTO_RESIZE_OFF);

		int vColIndex = 0;
		TableColumn col = InnerTable.getColumnModel().getColumn(vColIndex);
		int width = 40;
		col.setPreferredWidth(width);
		

		vColIndex = 1;
		col = InnerTable.getColumnModel().getColumn(vColIndex);
		width = 200;
		col.setPreferredWidth(width);
		
		vColIndex = 2;
		col = InnerTable.getColumnModel().getColumn(vColIndex);
		width = 190;
		col.setPreferredWidth(width);



	}
	
	
	

	private void searchAction() {

		KioskDao orderListDao = new KioskDao(); 
		ArrayList<KioskDto> dtoList = orderListDao.SelectList(); // 

		int listCount = dtoList.size(); // ???????????? ?????? ?????? ?????????

			for (int index = 0; index < listCount; index++) {

			String[] qTxt = {
					Integer.toString(dtoList.get(index).getProduct_id()), 
					dtoList.get(index).getProduct_name(), 
				//	Integer.toString(dtoList.get(index).getGetQuantityNum()),
					Integer.toString(dtoList.get(index).getProduct_price()) 
				}; // 1?????? ?????? ??????
			Outer_Table.addRow(qTxt); // ??????
		}

	}//searchAction End


	
	
	
	
	

	private void bottomInit() {
		
		Outer_Table2.addColumn("?????????");
		Outer_Table2.addColumn("????????????");
		Outer_Table2.addColumn("??????");
		Outer_Table2.setColumnCount(3);

		int i = Outer_Table2.getRowCount();
		for (int j = 0; j < i; j++) {
			Outer_Table2.removeRow(0);
		}

		InnerTable2.setAutoResizeMode(InnerTable2.AUTO_RESIZE_OFF);

		int vColIndex = 0;
		TableColumn col = InnerTable2.getColumnModel().getColumn(vColIndex);
		int width = 200;
		col.setPreferredWidth(width);
		

		vColIndex = 1;
		col = InnerTable2.getColumnModel().getColumn(vColIndex);
//		width = 0;
		col.setPreferredWidth(70);
		vColIndex = 2;
		col = InnerTable2.getColumnModel().getColumn(vColIndex);
//		width = 0;
		col.setPreferredWidth(100);
	}
	

	public void AddKioskCartInsert() { // bottom cart menu ???????????? ?????? ???????????? ???????????? ???, ?????? ???????????? ??? ?????? ????????? 
		
	//	KioskDao dao = new KioskDao(Static_ProductInfo.getProduct_id());
		KioskDao dao = new KioskDao();
		int count = dao.cartInsert();
		
		if(count == 1) {
			JOptionPane.showMessageDialog(null, "??????????????? ?????? ???????????????.");
			AddKioskCartList();
		}else {
			JOptionPane.showMessageDialog(null, "????????????, ??????????????? ????????? ?????????.");
			
		}
		
	}

	private boolean AddKioskCartList() {

		KioskDao dao = new KioskDao(); 
		ArrayList<KioskDto> dtoList = dao.cartSelectList(); // 

		
		int listCount = dtoList.size(); // ???????????? ?????? ?????? ?????????
		if(listCount>0) {
			for (int index = 0; index < listCount; index++) {

			String[] qTxt = {
					dtoList.get(index).getProduct_name(),
					Integer.toString(dtoList.get(index).getCart_id()),
					Integer.toString(dtoList.get(index).getGetQuantityNum())

				}; // 1?????? ?????? ??????
	
			Outer_Table2.addRow(qTxt); // ??????
			}
		}else {
			return false;
		}
		return true;

	}//searchAction End
	
	
	// ???????????? ?????? ????????? ?????????????????? ?????? ?????? Method
	
	private void bottomTableClick() { //???????????? ????????? ?????? 
		
		int i = InnerTable2.getSelectedRow(); // ????????? ??? ?????? ?????????
		String wkSequence = (String) InnerTable2.getValueAt(i, 1); // i?????? ?????? 0??????(Seqno) ?????? wkSequence??? ?????????
		
		Static_ProductInfo.setCart_id(Integer.parseInt(wkSequence)); //????????? ????????? ?????? ????????? 

		CartDelete();
		bottomInit();
		
	}
	private void CartDelete() { // bottom cart menu
		
		
		KioskDao deldao = new KioskDao(Static_ProductInfo.getCart_id());
		boolean a = deldao.deleteCart(); // ???????????? ??????id??? ????????? deleteCart
								//?????? ???????????? ???????????? ???????????? 
		if(a == true) {
			JOptionPane.showMessageDialog(null, "???????????? ????????? ?????????????????????.");
			deldao.deleteCart();
			AddKioskCartList();
		}else {
			JOptionPane.showMessageDialog(null, "????????????, ??????????????? ????????? ?????????.");
			
		}
		
	}//CartDelete End 
	
	
	

}// class end
