package com.javalec.base;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.dao.AppStoreLocationDao;
import com.javalec.dto.AppStoreLocationDto;
import com.javalec.util.Static_CustomerId;
import com.javalec.util.Static_StoreLocation;

import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JTextField;

public class AppStoreLocation extends JFrame {

	private JFrame frmMelhor;
	private JScrollPane scrollPane;
	private JTable Inner_Table;
	private JLabel lblNewLabel;
	private JLabel lblhomebutton;
    private final DefaultTableModel Outer_Table = new DefaultTableModel(); 
    private JLabel lblShopName;
    private JButton btnGoToMenu;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppStoreLocation window = new AppStoreLocation();
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
	public AppStoreLocation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMelhor = new JFrame();
		frmMelhor.addWindowListener(new WindowAdapter() {
	          
	          @Override
	          public void windowActivated(WindowEvent e) {
	             tableInit();
	             searchAction();
	          }
	       });
		frmMelhor.getContentPane().setBackground(new Color(247, 243, 243));
		frmMelhor.setTitle("Mehlor 매장정보");
		frmMelhor.setBounds(100, 100, 300, 500);
		frmMelhor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMelhor.getContentPane().setLayout(null);
		frmMelhor.getContentPane().add(getLblhomebutton());
		frmMelhor.getContentPane().add(getScrollPane());
		frmMelhor.getContentPane().add(getLblNewLabel());
		frmMelhor.getContentPane().add(getLblShopName());
		frmMelhor.getContentPane().add(getBtnGoToMenu());
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(6, 32, 288, 382);
			scrollPane.setViewportView(getInner_Table());
		}
		return scrollPane;
	}

	private JTable getInner_Table() {
		if (Inner_Table == null) {
			Inner_Table = new JTable();
			Inner_Table.addMouseListener(new MouseAdapter() {
	         	@Override
	         	public void mouseClicked(MouseEvent e) {
	         		if(e.getButton() == 1) {
	         			tableClick();
	         		}
	         		
	         	}
	         });
	         Inner_Table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	         Inner_Table.setModel(Outer_Table);
		}
		return Inner_Table;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("매장 리스트");
			lblNewLabel.setBounds(23, 6, 110, 32);
		}
		return lblNewLabel;
	}

	protected static void setIcon(ImageIcon updateIcon) {
		// TODO Auto-generated method stub

	}

	private JLabel getLblhomebutton() {
		if (lblhomebutton == null) {
			lblhomebutton = new JLabel("");
			lblhomebutton.addMouseListener(new MouseAdapter() {
				// ---------- home으로 이동
				@Override
				public void mouseClicked(MouseEvent e) {
					frmMelhor.setVisible(false);
					AppHome.main(null);
				}
			});
			lblhomebutton.setBounds(6, 416, 50, 50);

			// ---------- homebutton 이미지 추가

			ImageIcon icon = new ImageIcon(AppStoreLocation.class.getResource("/com/javalec/util/homebutton.png"));
			Image img = icon.getImage(); // ImageIcon을 Image로 변환.
			Image updateImg = img.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
			ImageIcon updateIcon = new ImageIcon(updateImg);

			lblhomebutton.setIcon(updateIcon);
		}
		return lblhomebutton;
	}
	
	private JLabel getLblShopName() {
		if (lblShopName == null) {
			lblShopName = new JLabel("New label");
			lblShopName.setBounds(192, 4, 88, 16);
		}
		return lblShopName;
	}
	private JButton getBtnGoToMenu() {
		if (btnGoToMenu == null) {
			btnGoToMenu = new JButton("주문하러가기");
			btnGoToMenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					frmMelhor.setVisible(false);
					AppMenuList.main(null);
				}
			});
			btnGoToMenu.setBounds(163, 426, 117, 29);
		}
		return btnGoToMenu;
	}

	// function-------------------------
	
	//테이블 칼럼 만들기 
	public void tableInit() {
		//테이블 칼럼 이름 
		Outer_Table.addColumn("순서");
		Outer_Table.addColumn("지점명");
		Outer_Table.addColumn("주소");
		Outer_Table.addColumn("번호");
		// 테이블 칼럼 수 
		Outer_Table.setColumnCount(4);

		int i = Outer_Table.getRowCount();

		for (int j = 0; j < i; j++) {
			Outer_Table.removeRow(0);
		}

		Inner_Table.setAutoResizeMode(Inner_Table.AUTO_RESIZE_OFF);

		int vColIndex = 0;
		TableColumn col = Inner_Table.getColumnModel().getColumn(vColIndex);
		int width = 30;
		col.setPreferredWidth(width);

		vColIndex = 1;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 50;
		col.setPreferredWidth(width);

		vColIndex = 2;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 100;
		col.setPreferredWidth(width);
		
		vColIndex = 3;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 90;
		col.setPreferredWidth(width);

	}
	
	// DB to Table db에서 테이블로 정보 가져오기 
		private void searchAction() {
			// Dao연결 
			AppStoreLocationDao dao = new AppStoreLocationDao();			//연결 
			ArrayList<AppStoreLocationDto> dtoList = dao.shopList();		// 타입 = 실행 메소드 4. arraylist 형식으로 가져와서, 해당 Dao method 실행 
			
			int listCount = dtoList.size();				//	 데이터의 열의 수를 나타냄 
			
			//위의 데이터 행의 수만큼 정보 출력  
			for(int index = 0; index < listCount; index++) {
				String temp = Integer.toString(dtoList.get(index).getShop_number());		//  temp: seqno 할당 
				String[] qTxt = {temp, dtoList.get(index).getShop_name(), dtoList.get(index).getShop_address(), dtoList.get(index).getShop_telno()};	//1행의 박스 할당  
				Outer_Table.addRow(qTxt);	//출력  
			}
			
			
		}
		
		
		// 선택한 지점 상단 텍스트라벨에 나타내기 
		private void tableClick() {
			
			int i = Inner_Table.getSelectedRow();							// 출력 원하는 정보 클릭 메소드  
			
			//DB에서 해당 행의 번호 (primary key) 가져오기 
			String wkSequence = (String) Inner_Table.getValueAt(i, 0);		//i 행 을 가져오고, 0은 primary key(순서)만 알면 되니까 0번 
			AppStoreLocationDao dao = new AppStoreLocationDao(Integer.parseInt(wkSequence));				//숫자 프라이머리 키 를 정수로 바꿈  
			
			AppStoreLocationDto dto = dao.tableClick();										//data가 dto로 넘어오고 넘어온 데이터를 dto타입으로  받는 역할  
			
			lblShopName.setText(dto.getShop_name());		
			
			Static_StoreLocation.setShop_name(dto.getShop_name());
			Static_StoreLocation.setShop_number(dto.getShop_number());

		}
	
}

	
	