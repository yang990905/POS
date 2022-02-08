
 //匯入需要的各類套件
 import javax.swing.*;
 import java.awt.event.*;
 import java.awt.*;
 import javax.swing.border.*;
 import java.sql.*;


 
 //人機互動層類別
 //CHCI_frame: Class HumanComputerInteraction_frame (人機介面-框架類別)

 class CHCI_frame {      //系統的視窗    
     
     CHCI_login_frame Login = new CHCI_login_frame();
     CHCI_front_frame Front = new CHCI_front_frame();
     CHCI_back_frame Back = new CHCI_back_frame();
    
     //建構子:類別CHCI_frame
     public CHCI_frame(){

         Login.btn1.addActionListener(BtnPress); //提交

         for(int i=0; i<Back.myMenu.btn.length; i++){  
             for(int j=0; j<Back.myMenu.btn[0].length; j++){
                 Back.myMenu.btn[i][j].addActionListener(ProcessFunSelection); //增加menu事件請聽器
             }
         }

         Front.btn3[5][0].addActionListener(BtnPress); //進後台
         Front.btn3[5][1].addActionListener(BtnPress); //交班回登入
         Back.myMenu.btn[5][0].addActionListener(BtnPress); //回前台
         Back.myMenu.btn[6][0].addActionListener(BtnPress); //回登入

     }

     //事件傾聽程式: 處理主功能選單選按
     public ActionListener ProcessFunSelection = new ActionListener(){
         public void actionPerformed(ActionEvent e){
 
             if( e.getSource() == Back.myMenu.btn[0][0]){
                 Back.myHome.setVisible(true);  //顯示後台主頁
                 Back.myInventory.setVisible(false); //隱藏後台庫存
                 Back.mySales.setVisible(false);  //隱藏後台銷售
                 Back.myPersonnel.setVisible(false);  //隱藏後台人事
                 Back.myManagement.setVisible(false); //隱藏後台管理

                 Back.myHome.DFMO.getDataVector().removeAllElements();
                 Back.myHome.findRD_in_TB_BBS();
             }

             if( e.getSource() == Back.myMenu.btn[1][0]){  
                 Back.myHome.setVisible(false);  //隱藏後台主頁
                 Back.myInventory.setVisible(true); //顯示後台庫存
                 Back.mySales.setVisible(false);  //隱藏後台銷售
                 Back.myPersonnel.setVisible(false);  //隱藏後台人事
                 Back.myManagement.setVisible(false); //隱藏後台管理

                 Back.myInventory.DFMO.getDataVector().removeAllElements();
                 Back.myInventory.ShowRD_in_TB_Product();
             }

             if( e.getSource() == Back.myMenu.btn[2][0]){  
                 Back.myHome.setVisible(false);  //隱藏後台主頁
                 Back.myInventory.setVisible(false); //隱藏後台庫存
                 Back.mySales.setVisible(true);  //顯示後台銷售
                 Back.myPersonnel.setVisible(false);  //隱藏後台人事
                 Back.myManagement.setVisible(false); //隱藏後台管理

                 Back.mySales.DFMO1.getDataVector().removeAllElements();
                 Back.mySales.DFMO2.getDataVector().removeAllElements();
                 Back.mySales.ShowRD_in_TB_sale();

                 Back.mySales.date_TxFd.setText(null);
                 Back.mySales.OrderID_TxFd.setText(null);

             }

             if( e.getSource() == Back.myMenu.btn[3][0]){  
                 Back.myHome.setVisible(false);  //隱藏後台主頁
                 Back.myInventory.setVisible(false); //隱藏後台庫存
                 Back.mySales.setVisible(false);  //隱藏後台銷售
                 Back.myPersonnel.setVisible(true);  //顯示後台人事
                 Back.myManagement.setVisible(false); //隱藏後台管理

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

            if( e.getSource() == Front.btn3[5][0]){ //前台進後台
				Login.setVisible(false);   //隱藏登入畫面
				Front.setVisible(false); //隱藏前台畫面
                Back.setVisible(true);  //顯示後台畫面
                
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
                Front.tf1.setText(null); //清除總金額
                Front.tf2.setText(null);
                Front.tf3.setText(null);
            }

            if( e.getSource() == Front.btn3[5][1]){ //前台交班(回登入)
				Login.setVisible(true);   //顯示登入畫面
				Front.setVisible(false); //隱藏前台畫面
                Back.setVisible(false);  //隱藏後台畫面

                Back.myHome.setVisible(true);
                Back.myInventory.setVisible(false);
                Back.mySales.setVisible(false);
                Back.myPersonnel.setVisible(false);
                Back.myManagement.setVisible(false);

                Login.b0.setText("");
                Login.tf1.setText("");
                Login.pwf.setText("");

                for(int i=0;i<=Front.index;i++){  //清除點餐欄
                    for(int j=0;j<4;j++){
                        Front.table.setValueAt("",i,j);
                    }
                }
                Front.index = 0;
                Front.a = 0;
                Front.tf1.setText(null); //清除總金額
                Front.tf2.setText(null);
                Front.tf3.setText(null);
            }

            if( e.getSource() == Back.myMenu.btn[5][0]){ //後台回前台
				Login.setVisible(false);   //隱藏登入畫面
				Front.setVisible(true); //顯示前台畫面
                Back.setVisible(false);  //隱藏後台畫面
                
                Back.myHome.setVisible(true);
                Back.myInventory.setVisible(false);
                Back.mySales.setVisible(false);
                Back.myPersonnel.setVisible(false);
                Back.myManagement.setVisible(false);
            }
            
            if( e.getSource() == Back.myMenu.btn[6][0]){ //回登入
				Login.setVisible(true);   //顯示登入畫面
				Front.setVisible(false); //隱藏前台畫面
                Back.setVisible(false);  //隱藏後台畫面

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

 
 