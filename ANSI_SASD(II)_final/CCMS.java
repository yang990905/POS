 //匯入需要的各類套件
 import javax.swing.*;
 import java.awt.event.*;
 import java.awt.*;
 import javax.swing.border.*;
 import java.sql.*;

 //系統主控類別
 //CSMS: Class CafeManagementSystem (咖啡店管理系統-CMS)

 class CCMS{                    

     //建立本系統所需的各個物件
     CHCI_frame myFrame = new CHCI_frame(); //人機互動層: 使用者介面物件
     CPD_front_Sale myFrontSale = new CPD_front_Sale();//問題領域層: 銷售物件(myFrontSale)
     CPD_back_personal mybackPersonal = new CPD_back_personal(); 
     CPD_back_bbs myBackBBS = new CPD_back_bbs();
     CPD_back_clockin myBackClockIn = new CPD_back_clockin();
     CPD_Product myProduct = new CPD_Product();
     CDM_dbma myDBMA = new CDM_dbma();//資料管理層: 資料庫操作存取物件(myDBMA)

     //CSMS的建構子:
     CCMS(){
             
          //設定系統中相關物件是由哪一個[事件傾聽程式]負責處理其動作 
         myFrame.Front.btn3[5][2].addActionListener(ProcessSaveSaleRecord);//[新增(前台)銷售資料]操作畫面的[確認]按鈕
         myFrame.Back.myManagement.staff_insert_Btn.addActionListener(ProcessInsertPersonalRecord);
         myFrame.Back.myManagement.home_insert_Btn.addActionListener(ProcessSaveBBSRecord); //[新增(後台管理)BBS資料]操作畫面的[新增]按鈕
         myFrame.Back.myPersonnel.Punch_Btn.addActionListener(ProcessSaveClockinRecord); //新增打卡時間
         myFrame.Back.myPersonnel.Staff_no_query_Btn.addActionListener(ProcessSubmitEmployeeQuery); //[查詢打卡員工資料]查詢畫面的[查詢]按鈕
         myFrame.Back.myManagement.staff_no_query_Btn.addActionListener(ProcessSubmitManagementEmployeeQuery);//員工管理的員工編號查詢
         myFrame.Back.myManagement.staff_updata_Btn.addActionListener(ProcessUpdateManagementEmployee);
         myFrame.Back.myManagement.queryBtn.addActionListener(ProcessSubmitManagementProductQuery);
         myFrame.Back.myManagement.stock_updata_Btn.addActionListener(ProcessUpdateManagementProduct);
         myFrame.Login.btn1.addActionListener(ProcessFunSelection);
         myFrame.Back.myMenu.btn[4][0].addActionListener(ProcessFunSelection);
             
     }
     //事件傾聽程式: 前台結帳
     public ActionListener ProcessSaveSaleRecord = new ActionListener(){
         public void actionPerformed(ActionEvent e){
             if(e.getSource() == myFrame.Front.btn3[5][2])	//確認
             {
                 String s1 = myFrame.Front.tf2.getText().trim(); //收
                 String s2 = myFrame.Front.tf1.getText().trim(); //總計

                 if( s1.length() > 0 ){

                    int x = Integer.parseInt(s1); //收
                    int y = Integer.parseInt(s2); //總計
                    int sum1 = x - y;
                    
                    
                    if(sum1>=0){
   
                        String s3 = String.valueOf(sum1);
                        myFrame.Front.tf3.setText(s3);
   
                        String StotalString = myFrame.Front.tf1.getText().trim();  //取得總金額 (註:trim()方法會把字串後面空白除掉)
                        String SdayString = myFrame.Front.b11.getText().trim();    //日期
                        String StimeString = myFrame.Front.b12.getText().trim();  //時間              
                          
                        myFrontSale.setStotal(StotalString);
                        myFrontSale.setSday(SdayString);    
                        myFrontSale.setStime(StimeString);
                        myDBMA.insertRD_into_TB_sale(myFrontSale);
          
                        int Sid = myDBMA.find_Sid();
          
                        int row= myFrame.Front.table.getRowCount();
                        String order[][] = new String [row][4];
          
                        int index_num = 0;
                        while(true){
                            if(myFrame.Front.table.getValueAt(index_num,0)!= null & 
                               myFrame.Front.table.getValueAt(index_num,1) != null &
                               myFrame.Front.table.getValueAt(index_num,2)!= null & 
                               myFrame.Front.table.getValueAt(index_num,3) != null ){
          
                                index_num++;
                            }
                            else{
                                break;
                            }
                        }
                        //System.out.println(index_num);
          
                        //建立二維陣列
                        for(int i=0; i< index_num; i++){
                            for(int j=0; j<4; j++){
                                order[i][j]=(String)myFrame.Front.table.getValueAt(i,j);    
                            }
                        }
          
                        //寫入資料
                        for(int i=0; i< index_num; i++){
                            myDBMA.insertRD_into_TB_orderproduct(order[i], Sid);
                            myDBMA.updateRD_in_TB_Product_inventory(order[i],Sid);
                        }
          
                       
                        myFrame.Front.a = 0;
                        for(int i=0;i<=myFrame.Front.index;i++){
                            for(int j=0;j<4;j++){
                                myFrame.Front.table.setValueAt(null,i,j);
                            }
                        }
                        myFrame.Front.index = 0;
                        myFrame.Front.tf1.setText(null); //清除總金額
                        myFrame.Front.tf2.setText(null);
                        myFrame.Front.tf3.setText(null);
   
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"收取金額不足，請重新收款","警告",JOptionPane.WARNING_MESSAGE);
                        myFrame.Front.tf2.setText(null);
                    }

                 }
                 else{
                     JOptionPane.showMessageDialog(null,"尚未收取金額，請收款","警告",JOptionPane.WARNING_MESSAGE);
                 }


             }
             
             
         }    
     }; 

     //事件傾聽程式: 處理員工資料新增(後台)
     public ActionListener ProcessInsertPersonalRecord = new ActionListener(){
         public void actionPerformed(ActionEvent e){

             String EclassString = (String)myFrame.Back.myManagement.job_title_cbox.getSelectedItem();
             String EnameString = myFrame.Back.myManagement.name_TxFd.getText().trim();    
             String EphoneString = myFrame.Back.myManagement.phone_TxFd.getText().trim();
             String EemailString = myFrame.Back.myManagement.email_TxFd.getText().trim();
             String EpasswordString = myFrame.Back.myManagement.password_TexFd.getText().trim();

             mybackPersonal.setEclass(EclassString);    
             mybackPersonal.setEname(EnameString);
             mybackPersonal.setEphone(EphoneString);
             mybackPersonal.setEemail(EemailString);
             mybackPersonal.setEpassword(EpasswordString);

             if(  EclassString.length() > 0 && EnameString.length() > 0 &&
                  EphoneString.length() > 0 && EemailString.length() > 0 && EpasswordString.length() > 0 ){
                    
                    myDBMA.insertRD_into_TB_Employee(mybackPersonal);
             }
             else {
                     JOptionPane.showMessageDialog(null,"[員工資料] 空白未輸入，請填寫後再新增！","操作警訊",JOptionPane.ERROR_MESSAGE);
             }
         }    
     };

     //事件傾聽程式: 處理BBS資料儲存
     public ActionListener ProcessSaveBBSRecord = new ActionListener(){
         public void actionPerformed(ActionEvent e){
             String BnewsString = myFrame.Back.myManagement.theme_TxFd.getText().trim();;  //(註:trim()方法會把字串後面空白除掉)
             String BTimeString = myFrame.Front.b11.getText().trim() + "  " + myFrame.Front.b12.getText().trim();
             if(  BnewsString.length() > 0 ){
                 myBackBBS.setBnews(BnewsString);
                 myBackBBS.setBdate(BTimeString);                   
                 myDBMA.insertRD_into_TB_BBS(myBackBBS);   //將學生物件傳入[資料庫操作存取物件(myDBMA)]的儲存學生紀錄方法(insertRD_into_TB_student())去儲存學生紀錄到資料庫
             }
             else {
                 JOptionPane.showMessageDialog(null,"[公告] 未輸入資料，請填寫後再新增！","操作警訊",JOptionPane.ERROR_MESSAGE);
             }  
         }    
     };

     //事件傾聽程式: 處理clockin資料儲存
     public ActionListener ProcessSaveClockinRecord = new ActionListener(){
         public void actionPerformed(ActionEvent e){
          
             String WorkMode_String = myFrame.Back.myPersonnel.WorkMode_TxFd.getText().trim();
             String Eid_String = myFrame.Back.myPersonnel.UserNumber_TxFd.getText().trim();
             String Today_String = myFrame.Front.b11.getText().trim();
             String Time_String = myFrame.Front.b12.getText().trim();

             myBackClockIn.setEid(Eid_String);
             myBackClockIn.setCdate(Today_String);
             myBackClockIn.setCin(Time_String);
             myBackClockIn.setCout(Time_String);

             if( Eid_String.length() > 0 ){
                 if(WorkMode_String.equals("上班")){
                     myDBMA.insertRD_into_TB_clockin(myBackClockIn);
                 }
                 if(WorkMode_String.equals("下班")){
                     myDBMA.updateRD_in_TB_clockin(myBackClockIn);
                 }
             }
             else {
                 JOptionPane.showMessageDialog(null,"[員工編號] 空白未輸入資料，請填寫後再操作！","操作警訊",JOptionPane.ERROR_MESSAGE);
             }
             

             myFrame.Back.myPersonnel.UserNumber_TxFd.setText(null);
             myFrame.Back.myPersonnel.UserName_TxFd.setText(null);
             myFrame.Back.myPersonnel.WorkMode_TxFd.setText(null);

         }    
     };

     //事件傾聽程式: 處理[人事]員工資料查詢
     public ActionListener ProcessSubmitEmployeeQuery = new ActionListener(){
         public void actionPerformed(ActionEvent e){
    
             String Eid = myFrame.Back.myPersonnel.UserNumber_TxFd.getText().trim();
             boolean flag = myDBMA.findRD_Employee_ID(Eid);
            
             if(  Eid.length() > 0 ){    //如果[員工id]長度大於0,即有輸入姓名資料,才進入查詢處理
                if(flag == false){
                     JOptionPane.showMessageDialog(null,"[員工編號：" + Eid + "]，查無此人");
                     myFrame.Back.myPersonnel.UserNumber_TxFd.setText(null);
                }
                else{
                     int aEid = Integer.valueOf(Eid);

                     String findResult = myDBMA.findRD_in_TB_employee(aEid);
                     myFrame.Back.myPersonnel.UserName_TxFd.setText(findResult);       
                }
             } 
             else {
                 JOptionPane.showMessageDialog(null,"[員工編號] 空白未輸入資料，請填寫後再查詢！","操作警訊",JOptionPane.ERROR_MESSAGE);
             }
         }    
     };

     //事件傾聽程式: 處理[管理]員工資料查詢
     public ActionListener ProcessSubmitManagementEmployeeQuery = new ActionListener(){
        public void actionPerformed(ActionEvent e){

             String ManaEid = myFrame.Back.myManagement.staff_no_TxFd.getText().trim();
             boolean flag = myDBMA.findRD_Employee_ID(ManaEid);
       
             if(  ManaEid.length() > 0 ){    //如果[員工id]長度大於0,即有輸入姓名資料,才進入查詢處理
                if(flag == false){
                    JOptionPane.showMessageDialog(null,"[員工編號：" + ManaEid + "]，查無此人");
                    myFrame.Back.myManagement.staff_no_TxFd.setText(null);
                }
                else{
                     String[] findResult = myDBMA.findRD_in_TB_employee(ManaEid);
                     myFrame.Back.myManagement.job_title_cbox.setSelectedItem(findResult[1]);
                     myFrame.Back.myManagement.name_TxFd.setText(findResult[0]);
                     myFrame.Back.myManagement.phone_TxFd.setText(findResult[2]);
                     myFrame.Back.myManagement.email_TxFd.setText(findResult[3]);
                     myFrame.Back.myManagement.password_TexFd.setText(findResult[4]);                             
                }    
             } 
             else {
                 JOptionPane.showMessageDialog(null,"[員工編號] 空白未輸入資料，請填寫後再查詢!","操作警訊",JOptionPane.ERROR_MESSAGE);
             }
         }    
     };

     //事件傾聽程式: 處理員工資料更新(後台管理)
     public ActionListener ProcessUpdateManagementEmployee = new ActionListener(){
         public void actionPerformed(ActionEvent e){

            String EidString = myFrame.Back.myManagement.staff_no_TxFd.getText().trim();
            String EclassString = (String)myFrame.Back.myManagement.job_title_cbox.getSelectedItem();
            String EnameString = myFrame.Back.myManagement.name_TxFd.getText().trim();    
            String EphoneString = myFrame.Back.myManagement.phone_TxFd.getText().trim();
            String EemailString = myFrame.Back.myManagement.email_TxFd.getText().trim();
            String EpasswordString = myFrame.Back.myManagement.password_TexFd.getText().trim();

            mybackPersonal.setEid(EidString);
            mybackPersonal.setEclass(EclassString);    
            mybackPersonal.setEname(EnameString);
            mybackPersonal.setEphone(EphoneString);
            mybackPersonal.setEemail(EemailString);
            mybackPersonal.setEpassword(EpasswordString);

             if(  EidString.length() > 0 && EclassString.length() > 0 && EnameString.length() > 0 &&
                  EphoneString.length() > 0 && EemailString.length() > 0 && EpasswordString.length() > 0 ){

                     myDBMA.updateRD_in_TB_Employee(mybackPersonal); 
                 }
            
             else {
                     JOptionPane.showMessageDialog(null,"[員工資料] 空白未輸入，請填寫後再更新！","操作警訊",JOptionPane.ERROR_MESSAGE);
             }
            
         }    
     };

     //庫存品項查詢
     public ActionListener ProcessSubmitManagementProductQuery = new ActionListener(){
         public void actionPerformed(ActionEvent e){

             String Product_NameString = (String)myFrame.Back.myManagement.cbox[1].getSelectedItem();

             myProduct.setPname(Product_NameString);

             String[] findResult = myDBMA.findRD_in_TB_proudct(myProduct);

             myFrame.Back.myManagement.price_TxFd.setText(findResult[0]);
             myFrame.Back.myManagement.stock_TxFd.setText(findResult[1]);


         }
     };

     //更新庫存管理
     public ActionListener ProcessUpdateManagementProduct = new ActionListener(){
         public void actionPerformed(ActionEvent e){

             String Product_NameString = (String)myFrame.Back.myManagement.cbox[1].getSelectedItem();//產品
             String Product_PpriceString = myFrame.Back.myManagement.price_TxFd.getText().trim();//價格
             String stockString = myFrame.Back.myManagement.stock_TxFd.getText().trim();//目前存量
             String Product_purchaseString = myFrame.Back.myManagement.purchase_TxFd.getText().trim();//增加
             String Product_damage = myFrame.Back.myManagement.damage_TxFd.getText().trim();//減少

             int x = Integer.parseInt(Product_purchaseString);
             int y = Integer.parseInt(Product_damage);
             int z = Integer.parseInt(stockString);
             int Pinventory_total = z + (x - y);
             String Product_stockString = String.valueOf(Pinventory_total);

             myProduct.setPname(Product_NameString);
             myProduct.setPprice(Product_PpriceString);
             myProduct.setPinventory(Product_stockString);

             if(  Product_PpriceString.length() > 0 ){

                 String[] findResult = myDBMA.updateRD_in_TB_Product(myProduct); 
             
                 myFrame.Back.myManagement.price_TxFd.setText(findResult[0]);
                 myFrame.Back.myManagement.stock_TxFd.setText(findResult[1]);
             }   
             else{
                 JOptionPane.showMessageDialog(null,"[產品售價] 空白未輸入，請填寫後再更新！","操作警訊",JOptionPane.ERROR_MESSAGE);
                 
                 String[] findResult = myDBMA.findRD_in_TB_proudct(myProduct);
                 myFrame.Back.myManagement.price_TxFd.setText(findResult[0]);
             } 
             
           
         }    
     };

     //登入
     public ActionListener ProcessFunSelection = new ActionListener(){
         public void actionPerformed(ActionEvent e){
             if( e.getSource() == myFrame.Login.btn1){ //進入前台

                 String s1 = myFrame.Login.tf1.getText().trim();
                 String s2 = myFrame.Login.pwf.getText().trim();

                 
                 boolean flag = myDBMA.findRD_Login_Employee(s1,s2);
                 if(flag == true || s1.equals("admin") && s2.equals("admin") || s1.equals("user") && s2.equals("user")){
                     myFrame.Login.setVisible(false);  //隱藏登入畫面
                     myFrame.Front.setVisible(true);  //顯示前台畫面
                     myFrame.Back.setVisible(false);

                     String[] findResult = myDBMA.findRD_Login_Employee_Name(s1,s2);
                     myFrame.Back.myHeader.UserLabel.setText("使用者：" + findResult[1] + "　(" + findResult[0] + ")");
                     myFrame.Front.b10.setText(findResult[1] + "　(" + findResult[0] + ")");

                 }
                 else if(s1.length() == 0){
                     myFrame.Login.b0.setText("未輸入帳密");
                 }
                 else{
                     myFrame.Login.b0.setText("帳密錯誤");
                 }

                 myFrame.Back.myHome.setVisible(true);
                 myFrame.Back.myInventory.setVisible(false);
                 myFrame.Back.mySales.setVisible(false);
                 myFrame.Back.myPersonnel.setVisible(false);
                 myFrame.Back.myManagement.setVisible(false);
             }

             if( e.getSource() == myFrame.Back.myMenu.btn[4][0]){ //管理

                 String s1 = myFrame.Login.tf1.getText().trim();
                 String s2 = myFrame.Login.pwf.getText().trim();

                 boolean flag = myDBMA.findRD_Login_Management(s1,s2); //true->主管

                 if(flag == true){
                     myFrame.Back.myHome.setVisible(false);  //隱藏後台主頁
                     myFrame.Back.myInventory.setVisible(false); //隱藏後台庫存
                     myFrame.Back.mySales.setVisible(false);  //隱藏後台銷售
                     myFrame.Back.myPersonnel.setVisible(false);  //隱藏後台人事
                     myFrame.Back.myManagement.setVisible(true); //顯示後台管理
                 }
                 else{
                     myFrame.Back.myHome.setVisible(false);  //隱藏後台主頁
                     myFrame.Back.myInventory.setVisible(false); //隱藏後台庫存
                     myFrame.Back.mySales.setVisible(false);  //隱藏後台銷售
                     myFrame.Back.myPersonnel.setVisible(false);  //隱藏後台人事
                     myFrame.Back.myManagement.setVisible(false); //隱藏後台管理
                     myFrame.Back.myManagement_ForEmployee.setVisible(true);
                 }
             }
         }
     };
            
 } //end for: class CSMS

 



 