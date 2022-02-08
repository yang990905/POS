
 //匯入需要的各類套件
 import javax.swing.*;
 import java.awt.event.*;
 import java.awt.*;
 import javax.swing.border.*;
 import javax.swing.table.*;
 import java.util.*;
 import javax.swing.table.AbstractTableModel;
 import javax.swing.table.DefaultTableModel;
 import java.sql.*;


 //人機互動層類別
 //CHCI_back_sales_panel: Class HumanComputerInteraction_back_sales_panel (人機介面-[後台銷售]操作畫面類別)

 class CHCI_back_sales_panel extends JPanel{
     
     int w = 1280;
     int h = 800;

     JPanel p = new JPanel();
     JTabbedPane tbp = new JTabbedPane();
     Color c1 = new Color(255,222,173); //新的
     Color c2 = new Color(237, 237, 237);
     Color c3 = new Color(255,193,193); //新的
     Color c4 = new Color(176,226,255);
     Color c5 = new Color(141,238,238);
     Font font = new Font("微軟正黑體",Font.PLAIN,25);
     Font font2 = new Font("微軟正黑體",Font.PLAIN,40);
     Font font3 = new Font("微軟正黑體",Font.PLAIN,30);
     Font font4 = new Font("微軟正黑體",Font.PLAIN,20);

     JLabel date_Label = new JLabel("日期");
     JLabel OrderID_Label = new JLabel("銷售編號");

     JTextField date_TxFd = new JTextField("");
     JTextField OrderID_TxFd = new JTextField("");

     JButton date_Btn = new JButton("日期");
     JButton date_Enter_Btn = new JButton("查詢");
     JButton OrderID_query_Btn = new JButton("查詢");

     Vector rowData1,columnNames1,rowData2,columnNames2;
     JTable table1,table2 = null;
     JScrollPane sp1,sp2=null;
     JTableHeader head1,head2 = null;
     DefaultTableModel DFMO1,DFMO2;

     //建構子:類別CHCI_back_sales_panel
     public CHCI_back_sales_panel(){

         date_Label.setBounds(15, 10, 125, 50);
         date_Label.setFont(font3);
         p.add(date_Label);

         date_TxFd.setBounds(85, 18, 190, 40);
         date_TxFd.setEditable(false);
         date_TxFd.setHorizontalAlignment(JTextField.CENTER);
         date_TxFd.setBackground(Color.WHITE);
         date_TxFd.setFont(font);
         p.add(date_TxFd);

         date_Btn.setBounds(292, 18, 85, 40);
         date_Btn.setBackground(c3);
         date_Btn.setBorder(BorderFactory.createRaisedBevelBorder());
         date_Btn.addActionListener(SelectDate);
         date_Btn.setFont(font);
         p.add(date_Btn);

         date_Enter_Btn.setBounds(400, 18, 85, 40);
         date_Enter_Btn.setBackground(c4);
         date_Enter_Btn.setBorder(BorderFactory.createRaisedBevelBorder());
         date_Enter_Btn.setFont(font);
         date_Enter_Btn.addActionListener(ProcessSubmitdateQuery);
         p.add(date_Enter_Btn);

         OrderID_Label.setBounds(565, 10, 125, 50);
         OrderID_Label.setFont(font3);
         p.add(OrderID_Label);

         OrderID_TxFd.setBounds(695, 18, 190, 40);
         OrderID_TxFd.setFont(font);
         p.add(OrderID_TxFd);

         OrderID_query_Btn.setBounds(900, 18, 85, 40);
         OrderID_query_Btn.setBackground(c5);
         OrderID_query_Btn.setBorder(BorderFactory.createRaisedBevelBorder());
         OrderID_query_Btn.addActionListener(ProcessSubmitorderQuery);
         OrderID_query_Btn.setFont(font);
         p.add(OrderID_query_Btn);

         columnNames1 = new Vector(); 
         columnNames1.add("銷售編號");  
         columnNames1.add("銷售日期");
         columnNames1.add("總金額");  
        
         DFMO1 = new DefaultTableModel(rowData1, columnNames1){
             public boolean isCellEditable(int row, int column){
                 return false;
            }
         };
         table1 = new JTable(DFMO1);
         table1.addMouseListener(new MouseAddp());
         table1.setFont(font4);
         table1.setRowHeight(40);
         head1 = table1.getTableHeader();
         head1.setFont(font);
         sp1 = new JScrollPane(table1,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                               ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
         sp1.setBounds(20,80,467,550);
         p.add(sp1);

         columnNames2 = new Vector(); 
         columnNames2.add("產品名稱");  
         columnNames2.add("單價");
         columnNames2.add("數量");
         columnNames2.add("小計");  
        
         DFMO2 = new DefaultTableModel(rowData2, columnNames2){
             public boolean isCellEditable(int row, int column){
                 return false;
            }
         };
         table2 = new JTable(DFMO2);
         table2.setFont(font4);
         table2.setRowHeight(40);
         table2.setEnabled(false);//設定表格只能顯示
         head2 = table2.getTableHeader();
         head2.setFont(font);
         sp2 = new JScrollPane(table2,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                               ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
         sp2.setBounds(520,80,570,550);
         p.add(sp2);

         p.setBackground(c1);
         p.setLayout(null);
         tbp.add("銷售",p);

         tbp.setFont(font);
         tbp.setBounds(0,0,w-163,h-55);
         add(tbp);

         setBackground(c1);
         setLocation(160,55);
         setSize(w-163,h-55);
         setLayout(null);
         setVisible(true);

         ShowRD_in_TB_sale();

     }

     public void ShowRD_in_TB_sale(){
         Connection connection;
         PreparedStatement statement;
         ResultSet result;
         String cmdData;

         rowData1=new Vector();

        //資料庫前置作業
         try{
             Class.forName("com.mysql.jdbc.Driver");
          } catch(Exception e){
             JOptionPane.showMessageDialog(null,"MySQL驅動程式安裝失敗!"); 
          }

         try{
             cmdData = "SELECT * FROM sale ORDER BY Sid DESC";
             connection = DriverManager.getConnection("jdbc:mysql://localhost/cafedb" + "?user=root&password=mysql");
             statement = connection.prepareStatement(cmdData);
             result = statement.executeQuery();
  
             while( result.next() ){
                 Vector<String> newRow = new Vector<>();
                  newRow.addElement(result.getString("Sid"));
                  newRow.addElement(result.getString("Sday"));
                  newRow.addElement(result.getString("Stotal"));
                  DFMO1.addRow(newRow);
                  DFMO1.fireTableDataChanged();
             }
             statement.close();
             
         } catch(SQLException e){
             e.printStackTrace();
             JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
         }        
     } 

     public ActionListener ProcessSubmitdateQuery = new ActionListener(){  //日期按鈕
        public void actionPerformed(ActionEvent e){

             DFMO1.getDataVector().removeAllElements();
             String date = date_TxFd.getText().trim();

             boolean flag = findRD_date(date);
             if(  date.length() > 0 ){
                 if(flag == false){
                     JOptionPane.showMessageDialog(null,"[日期：" + date + "]，查無銷售紀錄");
                     date_TxFd.setText(null);
                     DFMO1.getDataVector().removeAllElements();
                     ShowRD_in_TB_sale();
                 }
                 else{
                     Search_date(date);
                 }    
             }
             else {
                 JOptionPane.showMessageDialog(null,"[日期] 未輸入資料，請選擇後再查詢！","操作警訊",JOptionPane.ERROR_MESSAGE);
             }  
             DFMO2.getDataVector().removeAllElements();

         }
     };

     public ActionListener ProcessSubmitorderQuery = new ActionListener(){  //編號按鈕
        public void actionPerformed(ActionEvent e){

            DFMO2.getDataVector().removeAllElements();
            String order_ID = OrderID_TxFd.getText().trim();

            boolean flag = findRD_order_ID(order_ID);

            if(  order_ID.length() > 0 ){
                if(flag == false){
                     JOptionPane.showMessageDialog(null,"[銷售編號：" + order_ID + "]，查無明細");
                     OrderID_TxFd.setText(null);
                }
                else{
                     Search_order_ID(order_ID);
                }    
                 
            }
            else {
                JOptionPane.showMessageDialog(null,"[銷售編號] 未輸入資料，請輸入後再查詢！","操作警訊",JOptionPane.ERROR_MESSAGE);
            }  

         }
     };

     public boolean findRD_order_ID(String myOrder_ID){
        Connection connection;
        PreparedStatement statement;
        ResultSet result;
        String cmdData;

        boolean myResult = true;

        try{
          cmdData = "SELECT * FROM orderproduct WHERE Sid = ?";
          connection = DriverManager.getConnection("jdbc:mysql://localhost/cafedb"+"?user=root&password=mysql");
          statement = connection.prepareStatement(cmdData);
          statement.setString(1, myOrder_ID);
          result = statement.executeQuery();

          if( result.next() == false){
              myResult = false;
          }
          statement.close();
         
       } catch(SQLException e){
           JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
       } 

       return( myResult );
     }

     public boolean findRD_date(String mydate){
          Connection connection;
          PreparedStatement statement;
          ResultSet result;
          String cmdData;

          boolean myResult = true;

          try{
            cmdData = "SELECT * FROM sale WHERE Sday = ?";
            connection = DriverManager.getConnection("jdbc:mysql://localhost/cafedb"+"?user=root&password=mysql");
            statement = connection.prepareStatement(cmdData);
            statement.setString(1, mydate);
            result = statement.executeQuery();
 
            if( result.next() == false){
                myResult = false;
            }
            statement.close();
           
         } catch(SQLException e){
             JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
         } 

         return( myResult );
     }

     public void Search_date(String myDate)//查詢資料顯示在表格
     {
         Connection connection;
         PreparedStatement statement;
         ResultSet result;
         String cmdData;
         rowData1 = new Vector();    
           
         try
         {
             cmdData = "SELECT * FROM  sale WHERE Sday = ? ORDER BY Sid DESC";
             connection = DriverManager.getConnection("jdbc:mysql://localhost/cafedb"+"?user=root&password=mysql");
             statement = connection.prepareStatement(cmdData);
             statement.setString(1,myDate);
             result = statement.executeQuery();

             while( result.next() )
             {
                 Vector<String> newRow = new Vector<>();
                 newRow.addElement(String.valueOf(result.getInt("Sid")));
                 newRow.addElement(result.getString("Sday"));
                 newRow.addElement(result.getString("Stotal"));
                 DFMO1.addRow(newRow);
                 DFMO1.fireTableDataChanged();
             }
             statement.close();
             
         }
         catch(Exception e)
         {
             e.printStackTrace();
             JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
         }
     }

     public void Search_order_ID(String myOrder)//查詢資料顯示在表格
     {
         Connection connection;
         PreparedStatement statement;
         ResultSet result;
         String cmdData;
         rowData2 = new Vector();    
           
         try
         {
             cmdData = "SELECT * FROM orderproduct WHERE Sid = ?";
             connection = DriverManager.getConnection("jdbc:mysql://localhost/cafedb"+"?user=root&password=mysql");
             statement = connection.prepareStatement(cmdData);
             statement.setString(1,myOrder);
             result = statement.executeQuery();
             while(result.next())
             {
                 Vector<String> newRow = new Vector<>();
                 newRow.addElement(result.getString("SPname"));
                 newRow.addElement(String.valueOf(result.getInt("SPprice")));
                 newRow.addElement(String.valueOf(result.getInt("SPamount")));
                 newRow.addElement(String.valueOf(result.getInt("SPtotal")));
                 DFMO2.addRow(newRow);
                 DFMO2.fireTableDataChanged();
             }
             statement.close();
         }
         catch(Exception e)
         {
             e.printStackTrace();
             JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
         }
     }

     public class MouseAddp extends java.awt.event.MouseAdapter{//表格點擊
         public void mouseClicked(java.awt.event.MouseEvent me){
             if(me.getClickCount()==2){ //<--- this is dobule click
                 int row=table1.getSelectedRow();
                 int column=0;
                 Object selectedValue = table1.getModel().getValueAt(row,column);
                 DFMO2.getDataVector().removeAllElements();
                 orderproduct(selectedValue.toString());
             }
         }
     };

     public void orderproduct(String myOrder)//查詢資料顯示在表格
     {
         Connection connection;
         PreparedStatement statement;
         ResultSet result;
         String cmdData;
         rowData2 = new Vector();    
           
         try
         {
             cmdData = "SELECT * FROM orderproduct WHERE Sid = ?";
             connection = DriverManager.getConnection("jdbc:mysql://localhost/cafedb"+"?user=root&password=mysql");
             statement = connection.prepareStatement(cmdData);
             statement.setInt(1,Integer.parseInt(myOrder));
             result = statement.executeQuery();
             while(result.next())
             {
                 Vector<String> newRow = new Vector<>();
                 newRow.addElement(result.getString("SPname"));
                 newRow.addElement(String.valueOf(result.getInt("SPprice")));
                 newRow.addElement(String.valueOf(result.getInt("SPamount")));
                 newRow.addElement(String.valueOf(result.getInt("SPtotal")));
                 DFMO2.addRow(newRow);
                 DFMO2.fireTableDataChanged();
             }
             statement.close();
         }
         catch(Exception e)
         {
             e.printStackTrace();
             JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
             System.out.println(e.getMessage());
         }
     }

     //事件傾聽程式: 處理點按[日期選擇]按鈕
     public ActionListener SelectDate = new ActionListener(){
         public void actionPerformed(ActionEvent e){
             if(e.getSource() == date_Btn){
                 DatePopup dp1 = new DatePopup(date_TxFd);
                 dp1.showDialog();
             }
         }
     };

 } //end for: class CHCI_back_sales_panel

 
