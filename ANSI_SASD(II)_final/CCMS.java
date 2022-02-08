 //�פJ�ݭn���U���M��
 import javax.swing.*;
 import java.awt.event.*;
 import java.awt.*;
 import javax.swing.border.*;
 import java.sql.*;

 //�t�ΥD�����O
 //CSMS: Class CafeManagementSystem (�@�ة��޲z�t��-CMS)

 class CCMS{                    

     //�إߥ��t�Ωһݪ��U�Ӫ���
     CHCI_frame myFrame = new CHCI_frame(); //�H�����ʼh: �ϥΪ̤�������
     CPD_front_Sale myFrontSale = new CPD_front_Sale();//���D���h: �P�⪫��(myFrontSale)
     CPD_back_personal mybackPersonal = new CPD_back_personal(); 
     CPD_back_bbs myBackBBS = new CPD_back_bbs();
     CPD_back_clockin myBackClockIn = new CPD_back_clockin();
     CPD_Product myProduct = new CPD_Product();
     CDM_dbma myDBMA = new CDM_dbma();//��ƺ޲z�h: ��Ʈw�ާ@�s������(myDBMA)

     //CSMS���غc�l:
     CCMS(){
             
          //�]�w�t�Τ���������O�ѭ��@��[�ƥ��ť�{��]�t�d�B�z��ʧ@ 
         myFrame.Front.btn3[5][2].addActionListener(ProcessSaveSaleRecord);//[�s�W(�e�x)�P����]�ާ@�e����[�T�{]���s
         myFrame.Back.myManagement.staff_insert_Btn.addActionListener(ProcessInsertPersonalRecord);
         myFrame.Back.myManagement.home_insert_Btn.addActionListener(ProcessSaveBBSRecord); //[�s�W(��x�޲z)BBS���]�ާ@�e����[�s�W]���s
         myFrame.Back.myPersonnel.Punch_Btn.addActionListener(ProcessSaveClockinRecord); //�s�W���d�ɶ�
         myFrame.Back.myPersonnel.Staff_no_query_Btn.addActionListener(ProcessSubmitEmployeeQuery); //[�d�ߥ��d���u���]�d�ߵe����[�d��]���s
         myFrame.Back.myManagement.staff_no_query_Btn.addActionListener(ProcessSubmitManagementEmployeeQuery);//���u�޲z�����u�s���d��
         myFrame.Back.myManagement.staff_updata_Btn.addActionListener(ProcessUpdateManagementEmployee);
         myFrame.Back.myManagement.queryBtn.addActionListener(ProcessSubmitManagementProductQuery);
         myFrame.Back.myManagement.stock_updata_Btn.addActionListener(ProcessUpdateManagementProduct);
         myFrame.Login.btn1.addActionListener(ProcessFunSelection);
         myFrame.Back.myMenu.btn[4][0].addActionListener(ProcessFunSelection);
             
     }
     //�ƥ��ť�{��: �e�x���b
     public ActionListener ProcessSaveSaleRecord = new ActionListener(){
         public void actionPerformed(ActionEvent e){
             if(e.getSource() == myFrame.Front.btn3[5][2])	//�T�{
             {
                 String s1 = myFrame.Front.tf2.getText().trim(); //��
                 String s2 = myFrame.Front.tf1.getText().trim(); //�`�p

                 if( s1.length() > 0 ){

                    int x = Integer.parseInt(s1); //��
                    int y = Integer.parseInt(s2); //�`�p
                    int sum1 = x - y;
                    
                    
                    if(sum1>=0){
   
                        String s3 = String.valueOf(sum1);
                        myFrame.Front.tf3.setText(s3);
   
                        String StotalString = myFrame.Front.tf1.getText().trim();  //���o�`���B (��:trim()��k�|��r��᭱�ťհ���)
                        String SdayString = myFrame.Front.b11.getText().trim();    //���
                        String StimeString = myFrame.Front.b12.getText().trim();  //�ɶ�              
                          
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
          
                        //�إߤG���}�C
                        for(int i=0; i< index_num; i++){
                            for(int j=0; j<4; j++){
                                order[i][j]=(String)myFrame.Front.table.getValueAt(i,j);    
                            }
                        }
          
                        //�g�J���
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
                        myFrame.Front.tf1.setText(null); //�M���`���B
                        myFrame.Front.tf2.setText(null);
                        myFrame.Front.tf3.setText(null);
   
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"�������B�����A�Э��s����","ĵ�i",JOptionPane.WARNING_MESSAGE);
                        myFrame.Front.tf2.setText(null);
                    }

                 }
                 else{
                     JOptionPane.showMessageDialog(null,"�|���������B�A�Ц���","ĵ�i",JOptionPane.WARNING_MESSAGE);
                 }


             }
             
             
         }    
     }; 

     //�ƥ��ť�{��: �B�z���u��Ʒs�W(��x)
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
                     JOptionPane.showMessageDialog(null,"[���u���] �ťե���J�A�ж�g��A�s�W�I","�ާ@ĵ�T",JOptionPane.ERROR_MESSAGE);
             }
         }    
     };

     //�ƥ��ť�{��: �B�zBBS����x�s
     public ActionListener ProcessSaveBBSRecord = new ActionListener(){
         public void actionPerformed(ActionEvent e){
             String BnewsString = myFrame.Back.myManagement.theme_TxFd.getText().trim();;  //(��:trim()��k�|��r��᭱�ťհ���)
             String BTimeString = myFrame.Front.b11.getText().trim() + "  " + myFrame.Front.b12.getText().trim();
             if(  BnewsString.length() > 0 ){
                 myBackBBS.setBnews(BnewsString);
                 myBackBBS.setBdate(BTimeString);                   
                 myDBMA.insertRD_into_TB_BBS(myBackBBS);   //�N�ǥͪ���ǤJ[��Ʈw�ާ@�s������(myDBMA)]���x�s�ǥͬ�����k(insertRD_into_TB_student())�h�x�s�ǥͬ������Ʈw
             }
             else {
                 JOptionPane.showMessageDialog(null,"[���i] ����J��ơA�ж�g��A�s�W�I","�ާ@ĵ�T",JOptionPane.ERROR_MESSAGE);
             }  
         }    
     };

     //�ƥ��ť�{��: �B�zclockin����x�s
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
                 if(WorkMode_String.equals("�W�Z")){
                     myDBMA.insertRD_into_TB_clockin(myBackClockIn);
                 }
                 if(WorkMode_String.equals("�U�Z")){
                     myDBMA.updateRD_in_TB_clockin(myBackClockIn);
                 }
             }
             else {
                 JOptionPane.showMessageDialog(null,"[���u�s��] �ťե���J��ơA�ж�g��A�ާ@�I","�ާ@ĵ�T",JOptionPane.ERROR_MESSAGE);
             }
             

             myFrame.Back.myPersonnel.UserNumber_TxFd.setText(null);
             myFrame.Back.myPersonnel.UserName_TxFd.setText(null);
             myFrame.Back.myPersonnel.WorkMode_TxFd.setText(null);

         }    
     };

     //�ƥ��ť�{��: �B�z[�H��]���u��Ƭd��
     public ActionListener ProcessSubmitEmployeeQuery = new ActionListener(){
         public void actionPerformed(ActionEvent e){
    
             String Eid = myFrame.Back.myPersonnel.UserNumber_TxFd.getText().trim();
             boolean flag = myDBMA.findRD_Employee_ID(Eid);
            
             if(  Eid.length() > 0 ){    //�p�G[���uid]���פj��0,�Y����J�m�W���,�~�i�J�d�߳B�z
                if(flag == false){
                     JOptionPane.showMessageDialog(null,"[���u�s���G" + Eid + "]�A�d�L���H");
                     myFrame.Back.myPersonnel.UserNumber_TxFd.setText(null);
                }
                else{
                     int aEid = Integer.valueOf(Eid);

                     String findResult = myDBMA.findRD_in_TB_employee(aEid);
                     myFrame.Back.myPersonnel.UserName_TxFd.setText(findResult);       
                }
             } 
             else {
                 JOptionPane.showMessageDialog(null,"[���u�s��] �ťե���J��ơA�ж�g��A�d�ߡI","�ާ@ĵ�T",JOptionPane.ERROR_MESSAGE);
             }
         }    
     };

     //�ƥ��ť�{��: �B�z[�޲z]���u��Ƭd��
     public ActionListener ProcessSubmitManagementEmployeeQuery = new ActionListener(){
        public void actionPerformed(ActionEvent e){

             String ManaEid = myFrame.Back.myManagement.staff_no_TxFd.getText().trim();
             boolean flag = myDBMA.findRD_Employee_ID(ManaEid);
       
             if(  ManaEid.length() > 0 ){    //�p�G[���uid]���פj��0,�Y����J�m�W���,�~�i�J�d�߳B�z
                if(flag == false){
                    JOptionPane.showMessageDialog(null,"[���u�s���G" + ManaEid + "]�A�d�L���H");
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
                 JOptionPane.showMessageDialog(null,"[���u�s��] �ťե���J��ơA�ж�g��A�d��!","�ާ@ĵ�T",JOptionPane.ERROR_MESSAGE);
             }
         }    
     };

     //�ƥ��ť�{��: �B�z���u��Ƨ�s(��x�޲z)
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
                     JOptionPane.showMessageDialog(null,"[���u���] �ťե���J�A�ж�g��A��s�I","�ާ@ĵ�T",JOptionPane.ERROR_MESSAGE);
             }
            
         }    
     };

     //�w�s�~���d��
     public ActionListener ProcessSubmitManagementProductQuery = new ActionListener(){
         public void actionPerformed(ActionEvent e){

             String Product_NameString = (String)myFrame.Back.myManagement.cbox[1].getSelectedItem();

             myProduct.setPname(Product_NameString);

             String[] findResult = myDBMA.findRD_in_TB_proudct(myProduct);

             myFrame.Back.myManagement.price_TxFd.setText(findResult[0]);
             myFrame.Back.myManagement.stock_TxFd.setText(findResult[1]);


         }
     };

     //��s�w�s�޲z
     public ActionListener ProcessUpdateManagementProduct = new ActionListener(){
         public void actionPerformed(ActionEvent e){

             String Product_NameString = (String)myFrame.Back.myManagement.cbox[1].getSelectedItem();//���~
             String Product_PpriceString = myFrame.Back.myManagement.price_TxFd.getText().trim();//����
             String stockString = myFrame.Back.myManagement.stock_TxFd.getText().trim();//�ثe�s�q
             String Product_purchaseString = myFrame.Back.myManagement.purchase_TxFd.getText().trim();//�W�[
             String Product_damage = myFrame.Back.myManagement.damage_TxFd.getText().trim();//���

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
                 JOptionPane.showMessageDialog(null,"[���~���] �ťե���J�A�ж�g��A��s�I","�ާ@ĵ�T",JOptionPane.ERROR_MESSAGE);
                 
                 String[] findResult = myDBMA.findRD_in_TB_proudct(myProduct);
                 myFrame.Back.myManagement.price_TxFd.setText(findResult[0]);
             } 
             
           
         }    
     };

     //�n�J
     public ActionListener ProcessFunSelection = new ActionListener(){
         public void actionPerformed(ActionEvent e){
             if( e.getSource() == myFrame.Login.btn1){ //�i�J�e�x

                 String s1 = myFrame.Login.tf1.getText().trim();
                 String s2 = myFrame.Login.pwf.getText().trim();

                 
                 boolean flag = myDBMA.findRD_Login_Employee(s1,s2);
                 if(flag == true || s1.equals("admin") && s2.equals("admin") || s1.equals("user") && s2.equals("user")){
                     myFrame.Login.setVisible(false);  //���õn�J�e��
                     myFrame.Front.setVisible(true);  //��ܫe�x�e��
                     myFrame.Back.setVisible(false);

                     String[] findResult = myDBMA.findRD_Login_Employee_Name(s1,s2);
                     myFrame.Back.myHeader.UserLabel.setText("�ϥΪ̡G" + findResult[1] + "�@(" + findResult[0] + ")");
                     myFrame.Front.b10.setText(findResult[1] + "�@(" + findResult[0] + ")");

                 }
                 else if(s1.length() == 0){
                     myFrame.Login.b0.setText("����J�b�K");
                 }
                 else{
                     myFrame.Login.b0.setText("�b�K���~");
                 }

                 myFrame.Back.myHome.setVisible(true);
                 myFrame.Back.myInventory.setVisible(false);
                 myFrame.Back.mySales.setVisible(false);
                 myFrame.Back.myPersonnel.setVisible(false);
                 myFrame.Back.myManagement.setVisible(false);
             }

             if( e.getSource() == myFrame.Back.myMenu.btn[4][0]){ //�޲z

                 String s1 = myFrame.Login.tf1.getText().trim();
                 String s2 = myFrame.Login.pwf.getText().trim();

                 boolean flag = myDBMA.findRD_Login_Management(s1,s2); //true->�D��

                 if(flag == true){
                     myFrame.Back.myHome.setVisible(false);  //���ë�x�D��
                     myFrame.Back.myInventory.setVisible(false); //���ë�x�w�s
                     myFrame.Back.mySales.setVisible(false);  //���ë�x�P��
                     myFrame.Back.myPersonnel.setVisible(false);  //���ë�x�H��
                     myFrame.Back.myManagement.setVisible(true); //��ܫ�x�޲z
                 }
                 else{
                     myFrame.Back.myHome.setVisible(false);  //���ë�x�D��
                     myFrame.Back.myInventory.setVisible(false); //���ë�x�w�s
                     myFrame.Back.mySales.setVisible(false);  //���ë�x�P��
                     myFrame.Back.myPersonnel.setVisible(false);  //���ë�x�H��
                     myFrame.Back.myManagement.setVisible(false); //���ë�x�޲z
                     myFrame.Back.myManagement_ForEmployee.setVisible(true);
                 }
             }
         }
     };
            
 } //end for: class CSMS

 



 