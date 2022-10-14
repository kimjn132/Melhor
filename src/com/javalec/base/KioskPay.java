package com.javalec.base;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.dao.KioskDao;
import com.javalec.dto.KioskDto;
import com.javalec.util.DBConnect;
import com.javalec.util.Static_ProductInfo;
import com.javalec.util.Static_StoreLocation;

import java.awt.Font;
import java.awt.Window;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class KioskPay {

	private JFrame frmMelhorCoffeeKioskPay;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JScrollPane scrollPane;
	private JTable InnerTable;
	private JLabel lblOrder;
	private JLabel lblCnlth;
	private final DefaultTableModel Outer_Table = new DefaultTableModel();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KioskPay window = new KioskPay();
					window.frmMelhorCoffeeKioskPay.setVisible(true);
					window.frmMelhorCoffeeKioskPay.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public KioskPay() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMelhorCoffeeKioskPay = new JFrame();
		
		
		frmMelhorCoffeeKioskPay.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				//tableInit();
				bottomInit();
				AddKioskCartList();
			}
		});
		
		
		frmMelhorCoffeeKioskPay.setTitle("Melhor Coffee Kiosk Pay - 4Team");
		frmMelhorCoffeeKioskPay.setBounds(100, 100, 440, 800);
		frmMelhorCoffeeKioskPay.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMelhorCoffeeKioskPay.getContentPane().setLayout(null);
		frmMelhorCoffeeKioskPay.getContentPane().add(getLblOrder());
		frmMelhorCoffeeKioskPay.getContentPane().add(getLblCnlth());
		frmMelhorCoffeeKioskPay.getContentPane().add(getLblNewLabel_1());
		frmMelhorCoffeeKioskPay.getContentPane().add(getLblNewLabel());
		frmMelhorCoffeeKioskPay.getContentPane().add(getScrollPane());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("New label");
			lblNewLabel.setIcon(new ImageIcon(KioskPay.class.getResource("/com/javalec/img/TopMelXCard.png")));
			lblNewLabel.setBounds(0, 0, 440, 30);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("New label");
			lblNewLabel_1.setIcon(new ImageIcon(KioskPay.class.getResource("/com/javalec/img/MelXBig.png")));
			lblNewLabel_1.setBounds(0, 30, 440, 766);
		}
		return lblNewLabel_1;
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
		}
		InnerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		InnerTable.setModel(Outer_Table);
		return InnerTable;
	}
		

	
	private JLabel getLblCnlth() {
		if (lblCnlth == null) {
			lblCnlth = new JLabel("취소하기");
			lblCnlth.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
						// 취소하기 

					deleteAllCart();
					frmMelhorCoffeeKioskPay.setVisible(false);
					KioskMain.main(null);
				}
			});
			lblCnlth.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
			lblCnlth.setBounds(113, 672, 80, 30);
		}
		return lblCnlth;
	}
	
	
///////////////////////////////////////////// -- Function -- ////////////////////////////////////////////////////////////

	


	private void bottomInit() {
		//Outer_Table.addColumn("상품번호");
		Outer_Table.addColumn("");
		//Outer_Table.addColumn("가격");

		Outer_Table.setColumnCount(1);

		int i = Outer_Table.getRowCount();
		for (int j = 0; j < i; j++) {
			Outer_Table.removeRow(0);
		}

		InnerTable.setAutoResizeMode(InnerTable.AUTO_RESIZE_OFF);

		int vColIndex = 0;
		TableColumn col = InnerTable.getColumnModel().getColumn(vColIndex);
		int width = 200;
		col.setPreferredWidth(width);
	}

	
	
	


	

	//////// 결제버튼 누른 뒤 order table에 DB넣기

	
	
//	private void InsertOrders() { // 주문하기 누르면 Orders DB에 입력 << 이거 일단 넘어가짐 여기서 넣어야 될거 들어가면 댐 
//		
//		
//		KioskDao insertOrders = new KioskDao();
//	
//		boolean a = insertOrders.InsertOrders();
//		
//		if(a == true) {
//			JOptionPane.showMessageDialog(null, "주문이 완료되었습니다.");
//			insertOrders.InsertOrders();
//
//		}else {
//			JOptionPane.showMessageDialog(null, "에러발생, 매장직원에 문의해 주세요.");
//			
//		}
//		
//	}

	
	
	
	
	// *** -> 밑에 AddKisokCartList 에 return 값으로 불린을 넣고 리턴값이 null=false일 경우 주문하기가 되지 않도록
	//			하려고 만들러 가기전에 내비둔 거 
	
//	private void AddKioskCartList() {
//		KioskDao dao = new KioskDao(); 
//		ArrayList<KioskDto> dtoList = dao.cartSelectList(); // 
//
//		int listCount = dtoList.size(); // 데이터의 열의 수를 나타냄
//
//			for (int index = 0; index < listCount; index++) {
//
//			String[] qTxt = {
//					//dtoList.get(index).,
//					dtoList.get(index).getProduct_name()
//				}; // 1행의 박스 할당
//			
//				String result =	dtoList.get(index).getProduct_name();
//				cometomyproductname(result);
//			
//			Outer_Table.addRow(qTxt); // 출력
//		}
//
//	}//searchAction End
	
	private boolean AddKioskCartList() { //장바구에 제품이 담기면 true값으로 리턴, 없으면 false 로 다음페이지 안넘어가게,
										// 장바구니에 내용이 있따면 size 로 값 가져와서 for Moon으로 리스트출력 
		
		KioskDao dao = new KioskDao(); 
		ArrayList<KioskDto> dtoList = dao.cartSelectList(); // 
		int listCount = dtoList.size(); // 데이터의 열의 수를 나타냄

		if(listCount>0) {
			for (int index = 0; index < listCount; index++) {
				//System.out.println("AddKioskCartList의 ListCount = "+listCount+ " index = "+index);
			String[] qTxt = {
					//dtoList.get(index).,
					dtoList.get(index).getProduct_name()
				}; // 1행의 박스 할당
			
//				String result =	dtoList.get(index).getProduct_name();
				
//				cometomyproductname(result);
			//	System.out.println("comtomyproductname's result = "+result);
			
			Outer_Table.addRow(qTxt); // 출력
			}
		}else {
			return  false;
		}
		return  true;
		

	}//AddKioskCartList End
	
	
	
	
//	private void cometomyproductname(String name) {
//		
////		KioskDao dao = new KioskDao(name);
////		dao.cometomyproductname();
//		
//	}
//	
	
	
	private JLabel getLblOrder() { // 결제하기 누르면 결제 됬다고 JPop나옴 
		if (lblOrder == null) {
			lblOrder = new JLabel("결제하기");
			lblOrder.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					// boolean 값으로 ordertable에 들어가면은 return으로 받은 다음에 잘 들어갔으면 JOption으로완료 안내 
					//	JOptionPane.showMessageDialog(null,"결제가 완료되었습니다.");
					
					if(AddKioskCartList()==true) {
						
						InsertOrders();
						deleteAllCart();
						JOptionPane.showMessageDialog(null, "주문이 완료되었습니다.");
						frmMelhorCoffeeKioskPay.setVisible(false);
						System.out.println(Static_StoreLocation.shop_name);
						
						// 요거 밑에껄로 속성옵션에다가 넣을꺼임 
						if(Static_ProductInfo.InOut) {
							System.out.println(Static_ProductInfo.InOut+"트루면 매장 ");
						}else {
							System.out.println(Static_ProductInfo.InOut+"거짓이면 포장 ");
						}
						KioskMain.main(null);
					}else {
						JOptionPane.showMessageDialog(null,"상품이 아무것도 담겨있지 않습니다.");
					}
				}
			});
			lblOrder.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
			lblOrder.setBounds(250, 672, 80, 30);
		}
		return lblOrder;
	}
	
	
	
	
	private void InsertOrders() { // 바구니에 있는 제품을 오더테이블에 넣어야 댐 
		KioskDao insertOrders = new KioskDao();
		ArrayList<KioskDto> dtoList = insertOrders.cartSelectList(); // 
			// cartList에 있는 제품을 KioskDto배열로 넣
				insertOrders.InsertOrdersSQL();
	}//InsertOrders End 
	
	
	
	public boolean deleteAllCart() { // 장바구니 상품에 delete date insert 하기
		
		PreparedStatement ps = null;
		try { // error확인

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw_mysql); // database에 접근을 하겠다. (선언자, 실행 x)
			Statement stmt_mysql = conn_mysql.createStatement(); // Connection conn_mysql 인스턴스를 이용해서 Statement 객체 생성

			String query = "delete from cart;";
			ps = conn_mysql.prepareStatement(query);
			ps.executeUpdate(); // insert update method 이거 하나밖에 없다
				
			conn_mysql.close(); // close 해야 다른 사람의 DB도 들어올 수 있다.

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "에러발생, 매장직원에 문의해 주세요.");
			return false;
		}
		return true;
	}
	
	
	
}//End
