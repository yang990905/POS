
 //�פJ�ݭn���U���M��
 import javax.swing.*;
 import java.awt.event.*;
 import java.awt.*;
 import javax.swing.border.*;
 import java.sql.*;


 
 //�H�����ʼh���O
 //CHCI_frame: Class HumanComputerInteraction_frame (�H������-��x�ج[���O)

 class CHCI_back_frame extends JFrame{      //�t�Ϋ�x������

     int w = 1280;
     int h = 800;
     
     CHCI_back_menu_panel myMenu = new CHCI_back_menu_panel(); //��x��檫��(JPanel,���t7�ӫ��s)
     CHCI_back_header_panel myHeader = new CHCI_back_header_panel(); //��x���Y����(JPanel)
     CHCI_back_home_panel myHome = new CHCI_back_home_panel(); //��x�D���e������(JPanel)
     CHCI_back_inventory_panel myInventory = new CHCI_back_inventory_panel(); //��x�w�s�e������(JPanel)
     CHCI_back_sales_panel mySales = new CHCI_back_sales_panel(); //��x�P��e������(JPanel)
     CHCI_back_personnel_panel myPersonnel = new CHCI_back_personnel_panel(); //��x�H�Ƶe������(JPanel)
     CHCI_back_management_panel myManagement = new CHCI_back_management_panel(); //��x�޲z�e������(JPanel)
     CHCI_back_management_ForEmployee_panel myManagement_ForEmployee = new CHCI_back_management_ForEmployee_panel();
    
     //�غc�l:���OCHCI_frame
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

         //�t�ε������򥻳]�w
         setTitle("���ߩ@���] Chindish Cafe ���Ⱥ޲z�t��");
         setLocation(0,0);
         setSize(w,h);
         setLayout(null);
         setVisible(false);
         //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

         addWindowListener(new WindowAdapter() { 
		     public void windowClosing(WindowEvent we) { 
			     int result = JOptionPane.showConfirmDialog(null,"�O�_�����t�ΡH","�߰�",
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

 
 