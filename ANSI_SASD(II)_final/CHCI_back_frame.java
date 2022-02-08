
 //匯入需要的各類套件
 import javax.swing.*;
 import java.awt.event.*;
 import java.awt.*;
 import javax.swing.border.*;
 import java.sql.*;


 
 //人機互動層類別
 //CHCI_frame: Class HumanComputerInteraction_frame (人機介面-後台框架類別)

 class CHCI_back_frame extends JFrame{      //系統後台的視窗

     int w = 1280;
     int h = 800;
     
     CHCI_back_menu_panel myMenu = new CHCI_back_menu_panel(); //後台選單物件(JPanel,內含7個按鈕)
     CHCI_back_header_panel myHeader = new CHCI_back_header_panel(); //後台標頭物件(JPanel)
     CHCI_back_home_panel myHome = new CHCI_back_home_panel(); //後台主頁畫面物件(JPanel)
     CHCI_back_inventory_panel myInventory = new CHCI_back_inventory_panel(); //後台庫存畫面物件(JPanel)
     CHCI_back_sales_panel mySales = new CHCI_back_sales_panel(); //後台銷售畫面物件(JPanel)
     CHCI_back_personnel_panel myPersonnel = new CHCI_back_personnel_panel(); //後台人事畫面物件(JPanel)
     CHCI_back_management_panel myManagement = new CHCI_back_management_panel(); //後台管理畫面物件(JPanel)
     CHCI_back_management_ForEmployee_panel myManagement_ForEmployee = new CHCI_back_management_ForEmployee_panel();
    
     //建構子:類別CHCI_frame
     public CHCI_back_frame(){

         add(myMenu);
         add(myHeader);
         add(myHome);
         add(myInventory);
         add(mySales);
         add(myPersonnel);
         add(myManagement);
         add(myManagement_ForEmployee);

         myHome.setVisible(true);
         myInventory.setVisible(false);
         mySales.setVisible(false);
         myPersonnel.setVisible(false);
         myManagement.setVisible(false);
         myManagement_ForEmployee.setVisible(false);

         //系統視窗的基本設定
         setTitle("童心咖啡館 Chindish Cafe 店務管理系統");
         setLocation(0,0);
         setSize(w,h);
         setLayout(null);
         setVisible(false);
         //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

         addWindowListener(new WindowAdapter() { 
		     public void windowClosing(WindowEvent we) { 
			     int result = JOptionPane.showConfirmDialog(null,"是否關閉系統？","詢問",
						      JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		         if (result == JOptionPane.YES_OPTION){
				     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				 }
				 if (result == JOptionPane.NO_OPTION){
					 setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				 }    
									 
			 } 
		 }); 
     }

 } //end for: class CHCI_frame_back

 
 