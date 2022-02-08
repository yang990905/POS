
 //�פJ�ݭn���U���M��
 import javax.swing.*;
 import java.awt.event.*;
 import java.awt.*;
 import javax.swing.border.*;
 import java.sql.*;


 
 //�H�����ʼh���O
 //CHCI_frame: Class HumanComputerInteraction_frame (�H������-�ج[���O)

 class CHCI_frame {      //�t�Ϊ�����    
     
     CHCI_login_frame Login = new CHCI_login_frame();
     CHCI_front_frame Front = new CHCI_front_frame();
     CHCI_back_frame Back = new CHCI_back_frame();
    
     //�غc�l:���OCHCI_frame
     public CHCI_frame(){

         Login.btn1.addActionListener(BtnPress); //����

         for(int i=0; i<Back.myMenu.btn.length; i++){  
             for(int j=0; j<Back.myMenu.btn[0].length; j++){
                 Back.myMenu.btn[i][j].addActionListener(ProcessFunSelection); //�W�[menu�ƥ��ť��
             }
         }

         Front.btn3[5][0].addActionListener(BtnPress); //�i��x
         Front.btn3[5][1].addActionListener(BtnPress); //��Z�^�n�J
         Back.myMenu.btn[5][0].addActionListener(BtnPress); //�^�e�x
         Back.myMenu.btn[6][0].addActionListener(BtnPress); //�^�n�J

     }

     //�ƥ��ť�{��: �B�z�D�\������
     public ActionListener ProcessFunSelection = new ActionListener(){
         public void actionPerformed(ActionEvent e){
 
             if( e.getSource() == Back.myMenu.btn[0][0]){
                 Back.myHome.setVisible(true);  //��ܫ�x�D��
                 Back.myInventory.setVisible(false); //���ë�x�w�s
                 Back.mySales.setVisible(false);  //���ë�x�P��
                 Back.myPersonnel.setVisible(false);  //���ë�x�H��
                 Back.myManagement.setVisible(false); //���ë�x�޲z

                 Back.myHome.DFMO.getDataVector().removeAllElements();
                 Back.myHome.findRD_in_TB_BBS();
             }

             if( e.getSource() == Back.myMenu.btn[1][0]){  
                 Back.myHome.setVisible(false);  //���ë�x�D��
                 Back.myInventory.setVisible(true); //��ܫ�x�w�s
                 Back.mySales.setVisible(false);  //���ë�x�P��
                 Back.myPersonnel.setVisible(false);  //���ë�x�H��
                 Back.myManagement.setVisible(false); //���ë�x�޲z

                 Back.myInventory.DFMO.getDataVector().removeAllElements();
                 Back.myInventory.ShowRD_in_TB_Product();
             }

             if( e.getSource() == Back.myMenu.btn[2][0]){  
                 Back.myHome.setVisible(false);  //���ë�x�D��
                 Back.myInventory.setVisible(false); //���ë�x�w�s
                 Back.mySales.setVisible(true);  //��ܫ�x�P��
                 Back.myPersonnel.setVisible(false);  //���ë�x�H��
                 Back.myManagement.setVisible(false); //���ë�x�޲z

                 Back.mySales.DFMO1.getDataVector().removeAllElements();
                 Back.mySales.DFMO2.getDataVector().removeAllElements();
                 Back.mySales.ShowRD_in_TB_sale();

                 Back.mySales.date_TxFd.setText(null);
                 Back.mySales.OrderID_TxFd.setText(null);

             }

             if( e.getSource() == Back.myMenu.btn[3][0]){  
                 Back.myHome.setVisible(false);  //���ë�x�D��
                 Back.myInventory.setVisible(false); //���ë�x�w�s
                 Back.mySales.setVisible(false);  //���ë�x�P��
                 Back.myPersonnel.setVisible(true);  //��ܫ�x�H��
                 Back.myManagement.setVisible(false); //���ë�x�޲z

                 Back.myPersonnel.DFMO1.getDataVector().removeAllElements();
                 Back.myPersonnel.ShowRD_in_TB_clockin();
                 Back.myPersonnel.DFMO2.getDataVector().removeAllElements();
                 Back.myPersonnel.ShowRD_in_TB_Employee();

                 Back.myPersonnel.UserNumber_TxFd.setText(null);
                 Back.myPersonnel.UserName_TxFd.setText(null);
                 Back.myPersonnel.WorkMode_TxFd.setText(null);
             }

             if( e.getSource() == Back.myMenu.btn[4][0]){
                 Back.myManagement.DFMO1.getDataVector().removeAllElements();
                 Back.myManagement.findRD_in_TB_BBS();
                 Back.myManagement.DFMO2.getDataVector().removeAllElements();
                 Back.myManagement.ShowRD_in_TB_Product();
                 Back.myManagement.DFMO3.getDataVector().removeAllElements();
                 Back.myManagement.ShowRD_in_TB_Employee();
                 Back.myManagement.DFMO4.getDataVector().removeAllElements();
                 Back.myManagement.ShowRD_in_TB_clockin();

                 Back.myManagement.theme_TxFd.setText(null);
                 Back.myManagement.staff_no_TxFd.setText(null);
                 Back.myManagement.name_TxFd.setText(null);
                 Back.myManagement.phone_TxFd.setText(null);
                 Back.myManagement.email_TxFd.setText(null);
                 Back.myManagement.password_TexFd.setText(null);
                 Back.myManagement.price_TxFd.setText(null);
                 Back.myManagement.stock_TxFd.setText(null);
                 Back.myManagement.purchase_TxFd.setText("0");
                 Back.myManagement.damage_TxFd.setText("0");
                 Back.myManagement.punch_date_TxFd.setText(null);
                 
             }

         }
     };

     public ActionListener BtnPress = new ActionListener(){
        public void actionPerformed(ActionEvent e){

            if( e.getSource() == Front.btn3[5][0]){ //�e�x�i��x
				Login.setVisible(false);   //���õn�J�e��
				Front.setVisible(false); //���ëe�x�e��
                Back.setVisible(true);  //��ܫ�x�e��
                
                Back.myHome.setVisible(true);
                Back.myInventory.setVisible(false);
                Back.mySales.setVisible(false);
                Back.myPersonnel.setVisible(false);
                Back.myManagement.setVisible(false);

                Back.myHome.DFMO.getDataVector().removeAllElements();
                Back.myHome.findRD_in_TB_BBS();

                Front.a = 0;
                for(int i=0;i<=Front.index;i++){
                    for(int j=0;j<4;j++){
                         Front.table.setValueAt(null,i,j);
                    }
                }
                Front.index = 0;
                Front.a = 0;
                Front.tf1.setText(null); //�M���`���B
                Front.tf2.setText(null);
                Front.tf3.setText(null);
            }

            if( e.getSource() == Front.btn3[5][1]){ //�e�x��Z(�^�n�J)
				Login.setVisible(true);   //��ܵn�J�e��
				Front.setVisible(false); //���ëe�x�e��
                Back.setVisible(false);  //���ë�x�e��

                Back.myHome.setVisible(true);
                Back.myInventory.setVisible(false);
                Back.mySales.setVisible(false);
                Back.myPersonnel.setVisible(false);
                Back.myManagement.setVisible(false);

                Login.b0.setText("");
                Login.tf1.setText("");
                Login.pwf.setText("");

                for(int i=0;i<=Front.index;i++){  //�M���I�\��
                    for(int j=0;j<4;j++){
                        Front.table.setValueAt("",i,j);
                    }
                }
                Front.index = 0;
                Front.a = 0;
                Front.tf1.setText(null); //�M���`���B
                Front.tf2.setText(null);
                Front.tf3.setText(null);
            }

            if( e.getSource() == Back.myMenu.btn[5][0]){ //��x�^�e�x
				Login.setVisible(false);   //���õn�J�e��
				Front.setVisible(true); //��ܫe�x�e��
                Back.setVisible(false);  //���ë�x�e��
                
                Back.myHome.setVisible(true);
                Back.myInventory.setVisible(false);
                Back.mySales.setVisible(false);
                Back.myPersonnel.setVisible(false);
                Back.myManagement.setVisible(false);
            }
            
            if( e.getSource() == Back.myMenu.btn[6][0]){ //�^�n�J
				Login.setVisible(true);   //��ܵn�J�e��
				Front.setVisible(false); //���ëe�x�e��
                Back.setVisible(false);  //���ë�x�e��

                Back.myHome.setVisible(true);
                Back.myInventory.setVisible(false);
                Back.mySales.setVisible(false);
                Back.myPersonnel.setVisible(false);
                Back.myManagement.setVisible(false);

                Login.b0.setText("");
                Login.tf1.setText("");
                Login.pwf.setText("");
            }
         }
     };

 } //end for: class CHCI_frame

 
 