
 //匯入需要的各類套件
 import javax.swing.*;
 import java.awt.event.*;
 import java.awt.*;
 import javax.swing.border.*;
 import javax.swing.table.*;
 import java.text.DateFormat;//自定義日期時間格式
 import java.text.SimpleDateFormat;//自定義日期時間格式
 import java.util.Date;//自定義日期時間格式
 import java.sql.*;
 import java.util.*;

 //人機互動層類別
 //CHCI_back_management_panel: Class HumanComputerInteraction_back_management_panel (人機介面-[後台管理]操作畫面類別)

 class CHCI_back_management_panel extends JPanel{
     
     int w = 1280;
     int h = 800;

     day dayr = new day();//建立日期執行緒
     Date dated = new Date();//建立日期變數
     Date datet = new Date();//建立時間變數

     JPanel p = new JPanel(); //主頁管理
     JPanel p2 = new JPanel(); //庫存管理
     JPanel p3 = new JPanel(); //員工管理
     JPanel p4 = new JPanel(); //打卡紀錄
     JPanel Staff_Panel = new JPanel(); //員工操作
     JTabbedPane tbp = new JTabbedPane();

     Color c1 = new Color(255,222,173);
     Color c2 = new Color(237, 237, 237);
     Color c3 = new Color(193,255,193);    //new
     Color c4 = new Color(255,160,122);
     Color c5 = new Color(250,128,114);
     Color c6 = new Color(175,238,238);
     Color c7 = new Color(255,165,79);
     Color c8 = new Color(255,106,106);
     Color c9 = new Color(202,225,255);
     Color c10 = new Color(255,192,203);
     Color c11 = new Color(154,255,154);
     Color c12 = new Color(255,222,173);
     Color c13 = new Color(174,238,238);
     Color c14 = new Color(152,251,152);  //新的
     Color c15 = new Color(175,238,238);

     Font font = new Font("微軟正黑體",Font.PLAIN,25);
     Font font2 = new Font("微軟正黑體",Font.PLAIN,40);
     Font font3 = new Font("微軟正黑體",Font.PLAIN,30);
     Font font4 = new Font("微軟正黑體",Font.PLAIN,30);

     JLabel New_news_Label = new JLabel("新增公告"); //主頁
     JLabel date_Label = new JLabel("日期");  //主頁
     JLabel theme_Label = new JLabel("公告"); //主頁
     JLabel ProductClassLabel = new JLabel("產品類別");
     JLabel ProductLabel = new JLabel("品項");
     JLabel price_Label = new JLabel("售　　價");  //庫存
     JLabel stock_Label = new JLabel("存　　量");  //庫存
     JLabel purchase_Label = new JLabel("進貨增加"); //庫存
     JLabel damage_Label = new JLabel("損壞減少");  //庫存
     JLabel staff_no_Label = new JLabel("員工編號"); //員工管理
     JLabel job_title_Label = new JLabel("職　　稱"); //員工管理
     JLabel name_Label = new JLabel("姓　　名");  //員工管理
     JLabel phone_Label = new JLabel("電　　話"); //員工管理
     JLabel email_Label = new JLabel("Email");  //員工管理
     JLabel password_Label =new JLabel("密　　碼"); //員工管理
     JLabel punch_date_Label = new JLabel("日期");  //打卡

     JTextField date_TxFd = new JTextField(""); //主頁_日期
     JTextField theme_TxFd = new JTextField(""); //主頁_主題
     JTextField price_TxFd = new JTextField(""); //庫存_售價
     JTextField stock_TxFd = new JTextField(""); //庫存_存量
     JTextField purchase_TxFd = new JTextField("0"); //庫存_進貨增加
     JTextField damage_TxFd = new JTextField("0"); //庫存_損壞減少
     JTextField staff_no_TxFd = new JTextField(""); //員工管理_員工編號
     JTextField name_TxFd = new JTextField(""); //員工管理_姓名
     JTextField phone_TxFd = new JTextField(""); //員工管理_電話
     JTextField email_TxFd = new JTextField("@Chindish_Cafe.com"); //員工管理_Email
     JPasswordField password_TexFd =new JPasswordField(""); //員工管理_密碼
     JTextField punch_date_TxFd = new JTextField(""); //打卡_日期

     JButton home_insert_Btn = new JButton("新增"); //主頁_新增
     JButton queryBtn = new JButton("品項查詢");
     JButton Total_querylBtn = new JButton("全部品項");
     JButton stock_updata_Btn = new JButton("更新");  //庫存_更新
     JButton staff_no_query_Btn = new JButton("查詢");  //員工管理_編號查詢
     JButton staff_insert_Btn = new JButton("新增");  //員工管理_新增
     JButton staff_updata_Btn = new JButton("更新");  //員工管理_更新
     JButton punch_query_Btn = new JButton("日期");  //打卡紀錄_日期
     JButton punch_Enter_Btn = new JButton("查詢"); //打卡紀錄_查詢

     String[] curstr = new String[3]; //JComboBox的名稱儲存，查詢下一個JComboBox
     Boolean flag = true;
     String search;

     int index = 0;

     JComboBox[] cbox = new JComboBox[2];
     String[] CB = {"pclass","pname","product"};

     String[] job_itms= {"員工","主管"};
     JComboBox job_title_cbox = new JComboBox(job_itms);

     TableColumnModel cModel = null; 
     //取得這個table某個欄位的資訊
     TableColumn columnDate = null; 
     TableColumn columnContent = null; 
     
     Vector rowData1,columnNames1,rowData2,columnNames2,rowData3,columnNames3,rowData4,columnNames4;
     JTable table1,table2,table3,table4 = null;
     JScrollPane sp1,sp2,sp3,sp4 =null;
     JTableHeader head1,head2,head3,head4 = null;
     DefaultTableModel DFMO1,DFMO2,DFMO3,DFMO4;

     //建構子:類別CHCI_back_management_panel
     public CHCI_back_management_panel(){

         dayr.start();//呼叫日期執行緒start()方法

         /*-------------↓↓↓↓--主頁管理--↓↓↓↓---------------*/
         //新增公告{
         New_news_Label.setBounds(10, 0, 200, 100);
         New_news_Label.setFont(font3);
         p.add(New_news_Label);

         //日期
         date_Label.setBounds(40, 85, 300, 45);
         date_Label.setFont(font4);
         p.add(date_Label);

         //日期欄位
         date_TxFd.setBounds(120, 90, 300, 45);
         date_TxFd.setFont(font);
         date_TxFd.setEditable(false);
         date_TxFd.setBackground(Color.white);
         p.add(date_TxFd);

         //主題
         theme_Label.setBounds(40, 160, 300, 45);
         theme_Label.setFont(font4);
         p.add(theme_Label);

         //主題欄位
         theme_TxFd.setBounds(120, 160, 750, 45);
         theme_TxFd.setFont(font);
         theme_TxFd.setBackground(Color.white);
         p.add(theme_TxFd);

         //新增鈕
         home_insert_Btn.setBounds(900, 160, 140, 45);
         home_insert_Btn.setBackground(c3);
         home_insert_Btn.setFont(font);
         home_insert_Btn.addActionListener(RemoveAllElements);
         home_insert_Btn.setBorder(BorderFactory.createRaisedBevelBorder());
         p.add(home_insert_Btn);
        
         //新增公告表格}
         columnNames1=new Vector(); 
         columnNames1.add("發布時間");  
         columnNames1.add("公告");

         DFMO1 = new DefaultTableModel(rowData1, columnNames1){
             public boolean isCellEditable(int row, int column){
                 return false;
            }
         };
         table1 = new JTable(DFMO1);
         table1.setFont(font);
         table1.setRowHeight(40);
         head1 = table1.getTableHeader();
         head1.setFont(font);
         sp1 = new JScrollPane(table1,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                             ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);  

         cModel = table1.getColumnModel();
         //取得這個table某個欄位的資訊
         columnDate = cModel.getColumn(0);
         columnContent = cModel.getColumn(1);
         columnDate.setPreferredWidth(250);
         columnContent.setPreferredWidth(750);
		 table1.setEnabled(false);//設定表格只能顯示
		 head1.setFont(font);
         sp1.setBounds(20,230,1065,425);
         p.add(sp1);

         findRD_in_TB_BBS();
         /*-------------↑↑↑↑--主頁管理--↑↑↑↑--------------*/
         

         /*-------------↓↓↓↓--庫存管理--↓↓↓↓---------------*/ 
         for(int i = 0; i < cbox.length; i++)//combobox
	     {
             cbox[i] = new JComboBox(createCB(CB,i));
             cbox[i].addActionListener(combobox);
             curstr[i] = cbox[i].getSelectedItem().toString();
             cbox[i].setFont(font4);
             cbox[i].setBackground(Color.white);
             p2.add(cbox[i]);
         }
         
         ProductClassLabel.setBounds(20, 0, 150, 100);
         ProductClassLabel.setFont(font4);
         p2.add(ProductClassLabel);

         cbox[0].setBounds(150, 27, 175, 50);
         cbox[0].setFont(font);
         p2.add(cbox[0]);

         //品項
         ProductLabel.setBounds(370, 2, 100, 100);
         ProductLabel.setFont(font4);
         p2.add(ProductLabel);

         cbox[1].setBounds(435, 27, 220, 50);
         cbox[1].setFont(font);
         p2.add(cbox[1]);

         //品項查詢按鈕
         queryBtn.setBounds(710, 27, 145, 50);
         queryBtn.setBackground(c14);
         queryBtn.setFont(font);
         queryBtn.setBorder(BorderFactory.createRaisedBevelBorder());
         queryBtn.addActionListener(ProcessSubmitProductQuery);
         p2.add(queryBtn);

         Total_querylBtn.setBounds(890, 27, 145, 50);
         Total_querylBtn.setFont(font);
         Total_querylBtn.setBackground(c15);
         Total_querylBtn.setBorder(BorderFactory.createRaisedBevelBorder());
         Total_querylBtn.addActionListener(ProcessSubmitProductQuery);
         p2.add(Total_querylBtn);
         
         //售價
         price_Label.setBounds(20, 70, 150, 100);
         price_Label.setFont(font4);
         p2.add(price_Label);

         //售價欄位
         price_TxFd.setBounds(150, 100, 175, 45);
         price_TxFd.setFont(font4);
         p2.add(price_TxFd);

         //存量
         stock_Label.setBounds(20, 140, 150, 100);
         stock_Label.setFont(font4);
         p2.add(stock_Label);

         //存量欄位
         stock_TxFd.setBounds(150, 170, 175, 45);
         stock_TxFd.setFont(font4);
         stock_TxFd.setEditable(false);
         p2.add(stock_TxFd);

         //進貨增加
         purchase_Label.setBounds(370, 68, 150, 100);
         purchase_Label.setFont(font4);
         p2.add(purchase_Label);

         //進貨增加欄位
         purchase_TxFd.setBounds(510, 100, 147, 45);
         purchase_TxFd.setFont(font4);
         p2.add(purchase_TxFd);
         
         //損壞減少
         damage_Label.setBounds(370, 140, 140, 100);
         damage_Label.setFont(font4);
         p2.add(damage_Label);

         //損壞減少欄位
         damage_TxFd.setBounds(510, 170, 147, 45);
         damage_TxFd.setFont(font4);
         p2.add(damage_TxFd);

         //庫存更新鈕
         stock_updata_Btn.setBounds(710, 135, 100, 45);
         stock_updata_Btn.setBackground(c5);
         stock_updata_Btn.setBorder(BorderFactory.createRaisedBevelBorder());
         stock_updata_Btn.setFont(font4);
         stock_updata_Btn.addActionListener(RemoveAllElements);
         p2.add(stock_updata_Btn);

         //庫存

         columnNames2=new Vector();   
         columnNames2.add("編號");  
         columnNames2.add("產品類別");  
         columnNames2.add("品項");  
         columnNames2.add("單價");  
         columnNames2.add("存量"); 

         DFMO2 = new DefaultTableModel(rowData2, columnNames2){
             public boolean isCellEditable(int row, int column){
                 return false;
            }
         };
         table2 = new JTable(DFMO2);
         table2.setFont(font);		
         table2.setRowHeight(40);
         table2.setEnabled(false);//設定表格只能顯示
         head2 = table2.getTableHeader();
         head2.setFont(font);		
         JScrollPane sp2 = new JScrollPane(table2,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                                       ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
         sp2.setBounds(20,230,1065,425);
         p2.add(sp2);

         ShowRD_in_TB_Product();
         /*-------------↑↑↑↑--庫存管理--↑↑↑↑--------------*/


         /*-------------↓↓↓↓--員工管理--↓↓↓↓---------------*/
         //員工管理{       
         staff_no_Label.setBounds(8,3,120,70); //員工編號
         staff_no_Label.setFont(font);
         //staff_no_Label.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));  //標線
         Staff_Panel.add(staff_no_Label);

         //員工編號欄位
         staff_no_TxFd.setBounds(120, 13, 100, 45);
         staff_no_TxFd.setFont(font);
         staff_no_TxFd.setBackground(Color.white);
         Staff_Panel.add(staff_no_TxFd);

         //員工編號查詢鈕
         staff_no_query_Btn.setBounds(225, 13, 85, 45);
         staff_no_query_Btn.setBackground(c6);
         staff_no_query_Btn.setBorder(BorderFactory.createRaisedBevelBorder());
         staff_no_query_Btn.setFont(font);
         Staff_Panel.add(staff_no_query_Btn);

         //職稱
         job_title_Label.setBounds(8,73,120,70); 
         job_title_Label.setFont(font);
         Staff_Panel.add(job_title_Label);

         //職稱欄位
         job_title_cbox.setBounds(120, 83, 190, 45);
         job_title_cbox.setFont(font);
         job_title_cbox.setBackground(Color.white);
         Staff_Panel.add(job_title_cbox);

         //姓名
         name_Label.setBounds(8,148,120,70); 
         name_Label.setFont(font);
         Staff_Panel.add(name_Label);

         //姓名欄位
         name_TxFd.setBounds(120, 161, 190, 45);
         name_TxFd.setFont(font);
         name_TxFd.setBackground(Color.white);
         Staff_Panel.add(name_TxFd);

         //電話
         phone_Label.setBounds(8,225,120,70); 
         phone_Label.setFont(font);
         Staff_Panel.add(phone_Label);

         //電話欄位
         phone_TxFd.setBounds(120, 240, 190, 45);
         phone_TxFd.setFont(font);
         phone_TxFd.setBackground(Color.white);
         Staff_Panel.add(phone_TxFd);

         //Email
         email_Label.setBounds(25,300,120,70); 
         email_Label.setFont(font);
         Staff_Panel.add(email_Label);

         //Email欄位
         email_TxFd.setBounds(120, 310, 190, 45);
         email_TxFd.setFont(font);
         email_TxFd.setBackground(Color.white);
         Staff_Panel.add(email_TxFd);

         //Password
         password_Label.setBounds(8, 368, 120, 70);
         password_Label.setFont(font);
         Staff_Panel.add(password_Label);

         //Password欄位
         password_TexFd.setBounds(120, 380, 190, 45);
         password_TexFd.setFont(font);
         password_TexFd.setBackground(Color.white);
         Staff_Panel.add(password_TexFd);

         //新增鈕
         staff_insert_Btn.setBounds(45, 450, 100, 45);
         staff_insert_Btn.setBackground(c7);
         staff_insert_Btn.setFont(font);
         staff_insert_Btn.setBorder(BorderFactory.createRaisedBevelBorder());
         staff_insert_Btn.addActionListener(RemoveAllElements);
         Staff_Panel.add(staff_insert_Btn);

         //更新鈕
         staff_updata_Btn.setBounds(180, 450, 100, 45);
         staff_updata_Btn.setBackground(c8);
         staff_updata_Btn.setFont(font);
         staff_updata_Btn.setBorder(BorderFactory.createRaisedBevelBorder());
         staff_updata_Btn.addActionListener(RemoveAllElements);
         Staff_Panel.add(staff_updata_Btn);

         //查詢界面
         Staff_Panel.setBounds(775,15,320,630);
         Staff_Panel.setBackground(c12);
         Staff_Panel.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));  //標線
         Staff_Panel.setLayout(null);
         p3.add(Staff_Panel);

         //員工管理

         columnNames3 = new Vector(); 
         columnNames3.add("編號");  
         columnNames3.add("職稱");
         columnNames3.add("姓名");  
         columnNames3.add("電話");
         columnNames3.add("E-mail");  
         
         DFMO3 = new DefaultTableModel(rowData3, columnNames3){
             public boolean isCellEditable(int row, int column){
                 return false;
            }
         };
         table3 = new JTable(DFMO3){
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component component = super.prepareRenderer(renderer, row, column);
                int rendererWidth = component.getPreferredSize().width;
                TableColumn tableColumn = getColumnModel().getColumn(column);
                tableColumn.setPreferredWidth(Math.max(rendererWidth + getIntercellSpacing().width, tableColumn.getPreferredWidth()));
                return component;
             }
         };
         table3.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
         table3.setFont(font);//員工表
         table3.setRowHeight(40);
         table3.setEnabled(false);//設定表格只能顯示
         
         head3 = table3.getTableHeader();
         head3.setFont(font);
         sp3 = new JScrollPane(table3,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                             ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

         sp3.setBounds(20,15,740,630);
         p3.add(sp3);

         ShowRD_in_TB_Employee();
         /*-------------↑↑↑↑--員工管理--↑↑↑↑--------------*/


         /*-------------↓↓↓↓--打卡紀錄--↓↓↓↓---------------*/
         //打卡紀錄{
         punch_date_Label.setBounds(15, 2, 100, 100); //日期
         punch_date_Label.setFont(font4);
         p4.add(punch_date_Label);

         //日期欄位
         punch_date_TxFd.setBounds(90, 27, 300, 50);
         punch_date_TxFd.setEditable(false);
         punch_date_TxFd.setHorizontalAlignment(JTextField.CENTER);
         punch_date_TxFd.setBackground(Color.WHITE);
         punch_date_TxFd.setFont(font4);
         p4.add(punch_date_TxFd);

         //查詢按鈕
         punch_query_Btn.setBounds(425, 27, 100, 50);
         punch_query_Btn.setBackground(c9);
         punch_query_Btn.setBorder(BorderFactory.createRaisedBevelBorder());
         punch_query_Btn.addActionListener(SelectDate);
         punch_query_Btn.setFont(font4);
         p4.add(punch_query_Btn);

         //查詢確定按鈕
         punch_Enter_Btn.setBounds(545,27,100,50);
         punch_Enter_Btn.setBackground(c10);
         punch_Enter_Btn.setBorder(BorderFactory.createRaisedBevelBorder());
         punch_Enter_Btn.setFont(font4);
         punch_Enter_Btn.addActionListener(ProcessSubmitdateQuery);
         p4.add(punch_Enter_Btn);

         //打卡紀錄}

         columnNames4 = new Vector(); 
         columnNames4.add("員工編號");  
         columnNames4.add("職稱");
         columnNames4.add("姓名");
         columnNames4.add("打卡日期");
         columnNames4.add("上班時間");
         columnNames4.add("下班時間");  

         DFMO4 = new DefaultTableModel(rowData4, columnNames4){
             public boolean isCellEditable(int row, int column){
                 return false;
             }
         };
         table4 = new JTable(DFMO4);
         table4.setFont(font);
         table4.setRowHeight(40);
         table4.setEnabled(false);
         head4 = table4.getTableHeader();
         head4.setFont(font);
         sp4 = new JScrollPane(table4,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                             ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

         sp4.setBounds(20,100,1065,545);
         p4.add(sp4);

         ShowRD_in_TB_clockin();
         /*-------------↑↑↑↑--打卡紀錄--↑↑↑↑--------------*/

         p.setBackground(c1);
         p.setLayout(null);
         tbp.add("主頁管理",p);

         p2.setBackground(c1);
         p2.setLayout(null);
         tbp.add("庫存管理",p2);

         p3.setBackground(c1);
         p3.setLayout(null);
         tbp.add("員工管理",p3);

         p4.setBackground(c1);
         p4.setLayout(null);
         tbp.add("打卡紀錄",p4);

         tbp.setFont(font);
         tbp.setBounds(0,0,w-163,h-55);
         add(tbp);

         setBackground(c1);
         setLocation(160,55);
         setSize(w-163,h-55);
         setLayout(null);
         setVisible(true);
        
     }

     public void findRD_in_TB_BBS(){

        Connection connection;
        PreparedStatement statement;
        ResultSet result;
        String cmdData;

        rowData1 =new Vector();
           
        //資料庫前置作業
        try{
            Class.forName("com.mysql.jdbc.Driver");
        } 
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"MySQL驅動程式安裝失敗!"); 
        }

        try{
            cmdData = "SELECT * FROM BBS "+
                      "ORDER BY Bid DESC ";

            connection = DriverManager.getConnection("jdbc:mysql://localhost/cafedb" + "?user=root&password=mysql");
            statement = connection.prepareStatement(cmdData);
            result = statement.executeQuery();
  
            while( result.next() ){
                Vector<String> newRow = new Vector<>();
                newRow.addElement(result.getString("Bdate"));
                newRow.addElement(result.getString("Bnews"));
                DFMO1.addRow(newRow);
                DFMO1.fireTableDataChanged();        
            }
             statement.close();  
        }
        catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
        }       
    } 

     public void ShowRD_in_TB_Employee(){
        Connection connection;
        PreparedStatement statement;
        ResultSet result;
        String cmdData;

        rowData3 =new Vector();

        //資料庫前置作業
          try{
                Class.forName("com.mysql.jdbc.Driver");
          } catch(Exception e){
                JOptionPane.showMessageDialog(null,"MySQL驅動程式安裝失敗!"); 
          }

          try{
            cmdData = "SELECT * FROM employee";
            connection = DriverManager.getConnection("jdbc:mysql://localhost/cafedb" + "?user=root&password=mysql");
            statement = connection.prepareStatement(cmdData);
            result = statement.executeQuery();
  
            while( result.next() ){
                 Vector<String> newRow = new Vector<>();
                  newRow.addElement(result.getString("Eid"));
                  newRow.addElement(result.getString("Eclass"));
                  newRow.addElement(result.getString("Ename"));
                  newRow.addElement(result.getString("Ephone"));
                  newRow.addElement(result.getString("Eemail"));
                  DFMO3.addRow(newRow);
                  DFMO3.fireTableDataChanged();
             }
             statement.close();
             
        } catch(SQLException e){
             e.printStackTrace();
             JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
        }        
    }

     //建立ComboBox
     public String[] createCB(String[] name,int num)
     {
         Connection connection;
         Statement statement;
         ResultSet result;
   
         ArrayList myList = new ArrayList();
            String CB;
            try
            {
                connection = DriverManager.getConnection("jdbc:mysql://localhost/cafedb" + "?user=root&password=mysql");
                statement=connection.createStatement();
                if(num == 0){
                    CB = "SELECT * FROM "+name[name.length-1]+" GROUP BY "+name[0]+ " ORDER BY 1 ASC";
                }
                else{
                    CB = "SELECT * FROM "+name[name.length-1]+" WHERE "+name[0]+"='"+curstr[0]+"'"+" GROUP BY "+name[1]+ " ORDER BY 1 ASC";
                }
                result=statement.executeQuery(CB);
                while(result.next()){
                    myList.add(result.getString(name[num])); //num=0->pclass名稱
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
            }
            Object list[] = myList.toArray();
            String[] stringArray = Arrays.copyOf(list,list.length,String[].class);
            return stringArray;
        }
   
        public ActionListener combobox = new ActionListener(){
            public void actionPerformed(ActionEvent a){
                if(a.getSource() == cbox[0]) {
                    if(flag){
                        curstr[0] = cbox[0].getSelectedItem().toString();
                        flag = false;
                        if(a.getSource() == cbox[0]){
                            selectCB(0,curstr,CB,cbox[1]);
                        }
                        curstr[1] = cbox[1].getSelectedItem().toString();
                    }
                }
            }
        };
   
        //選擇ComboBox更換下一個ComboBox 
        public void selectCB(int num,String[] name, String[] type, JComboBox cb){
            Connection connection;
            Statement statement;
            ResultSet result;
   
            ArrayList myList = new ArrayList();
            String CB;
            try
            {
                connection = DriverManager.getConnection("jdbc:mysql://localhost/cafedb" + "?user=root&password=mysql");
                statement=connection.createStatement();
                if(num == 0){
                    CB = "SELECT * FROM "+type[type.length-1]+" WHERE "+type[num]+"='"+name[num]+"'"+" GROUP BY "+type[num+1]+ " ORDER BY 1 ASC";
                }
                else{
                    CB = "SELECT * FROM "+type[type.length-1]+" WHERE "+type[num-1]+"='"+name[num-1]+"'"+" AND "+type[num]+"='"+name[num]+"'"+" GROUP BY "+type[num+1]+ " ORDER BY 1 ASC";
                }
                result=statement.executeQuery(CB);
                while(result.next()){
                    myList.add(result.getString(type[num+1]));
                }
                result.close();
                Object list[] = myList.toArray();
                String[] stringArray = Arrays.copyOf(list,list.length,String[].class);
                for(int i= 0; i <stringArray.length; i++){
                    cb.addItem(stringArray[i]);
                }
                int a = cb.getItemCount();
                for(int i=0;i < a-list.length;i++){
                    cb.removeItemAt(0);
                }
                flag =true;
            } 
            catch (Exception e)
            {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
            }
        }
   
        public void ShowRD_in_TB_Product() //表格所有資料
        {
            Connection connection;
            PreparedStatement statement;
            ResultSet result;
            String cmdData;
            rowData2 = new Vector();    
           
            try
            {
                cmdData = "SELECT * FROM  product ";
                connection = DriverManager.getConnection("jdbc:mysql://localhost/cafedb"+"?user=root&password=mysql");
                statement = connection.prepareStatement(cmdData);
                result = statement.executeQuery();
                while(result.next())
                {
                    Vector<String> newRow = new Vector<>();
                    newRow.addElement(String.valueOf(result.getInt("Pid")));
                    newRow.addElement(result.getString("Pclass"));
                    newRow.addElement(result.getString("Pname"));
                    newRow.addElement(String.valueOf(result.getInt("Pprice")));
                    newRow.addElement(String.valueOf(result.getInt("Pinventory")));
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
   
        public ActionListener ProcessSubmitProductQuery = new ActionListener(){  //按鈕
            public void actionPerformed(ActionEvent e){
                if(e.getSource() == queryBtn)//品項查詢
                {
                     DFMO2.getDataVector().removeAllElements();
                     String product=new String();
                     product=(String)cbox[1].getSelectedItem();
                     Search_Product(product);
                }
                
                if(e.getSource() == Total_querylBtn)//全部品項
                {
                     DFMO2.getDataVector().removeAllElements();
                     ShowRD_in_TB_Product();
                }
                
            }
        };
   
     public void Search_Product(String myProduct)//查詢資料顯示在表格
     {
            Connection connection;
            PreparedStatement statement;
            ResultSet result;
            String cmdData;
            rowData2 = new Vector();    
           
            try
            {
                cmdData = "SELECT * FROM  product WHERE pname=?";
                connection = DriverManager.getConnection("jdbc:mysql://localhost/cafedb"+"?user=root&password=mysql");
                statement = connection.prepareStatement(cmdData);
                statement.setString(1,myProduct);
                result = statement.executeQuery();
                while(result.next())
                {
                Vector<String> newRow = new Vector<>();
                newRow.addElement(String.valueOf(result.getInt("Pid")));
                newRow.addElement(result.getString("Pclass"));
                newRow.addElement(result.getString("Pname"));
                newRow.addElement(String.valueOf(result.getInt("Pprice")));
                newRow.addElement(String.valueOf(result.getInt("Pinventory")));
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

     public void ShowRD_in_TB_clockin(){
        Connection connection;
        PreparedStatement statement;
        ResultSet result;
        String cmdData;

        rowData4=new Vector();

        //資料庫前置作業
        try{
            Class.forName("com.mysql.jdbc.Driver");
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,"MySQL驅動程式安裝失敗!"); 
        }

        try{
            cmdData = "SELECT clockin.Eid, employee.Eclass, employee.Ename, clockin.Cdate, clockin.Cin, clockin.Cout "+
                      "FROM clockin INNER JOIN employee ON clockin.Eid = employee.Eid " +
                      "ORDER BY clockin.Cid DESC";
            connection = DriverManager.getConnection("jdbc:mysql://localhost/cafedb" + "?user=root&password=mysql");
            statement = connection.prepareStatement(cmdData);
            result = statement.executeQuery();
 
            while( result.next() ){
                Vector<String> newRow = new Vector<>();
                 newRow.addElement(result.getString("Eid"));
                 newRow.addElement(result.getString("Eclass"));
                 newRow.addElement(result.getString("Ename"));
                 newRow.addElement(result.getString("Cdate"));
                 newRow.addElement(result.getString("Cin"));
                 newRow.addElement(result.getString("Cout"));
                 DFMO4.addRow(newRow);
                 DFMO4.fireTableDataChanged();
            }
            statement.close();
            
        } catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!0000");
        }        
     }

     public ActionListener ProcessSubmitdateQuery = new ActionListener(){  //按鈕
        public void actionPerformed(ActionEvent e){

             DFMO4.getDataVector().removeAllElements();
             String date = punch_date_TxFd.getText().trim();

             boolean flag = findRD_date(date);
             if(  date.length() > 0 ){
                 if(flag == false){
                     JOptionPane.showMessageDialog(null,"[日期：" + date + "]，查無打卡紀錄");
                     punch_date_TxFd.setText(null);
                     DFMO4.getDataVector().removeAllElements();
                     ShowRD_in_TB_clockin();
                 }
                 else{
                     Search_date(date);
                 }    
             }
             else {
                 JOptionPane.showMessageDialog(null,"[日期] 未輸入資料，請選擇後再查詢！","操作警訊",JOptionPane.ERROR_MESSAGE);
             }
         }
     };

     public boolean findRD_date(String mydate){
         Connection connection;
         PreparedStatement statement;
         ResultSet result;
         String cmdData;

         boolean myResult = true;

         try{
             cmdData = "SELECT * FROM clockin WHERE Cdate = ?";
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

     public void Search_date(String myDate){
        Connection connection;
        PreparedStatement statement;
        ResultSet result;
        String cmdData;

        rowData4=new Vector();

        //資料庫前置作業
        try{
            Class.forName("com.mysql.jdbc.Driver");
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,"MySQL驅動程式安裝失敗!"); 
        }

        try{
            cmdData = "SELECT clockin.Eid, employee.Eclass, employee.Ename, clockin.Cdate, clockin.Cin, clockin.Cout "+
                      "FROM clockin INNER JOIN employee ON clockin.Eid = employee.Eid " +
                      "WHERE  Cdate = ?"+
                      "ORDER BY clockin.Cid DESC";
            connection = DriverManager.getConnection("jdbc:mysql://localhost/cafedb" + "?user=root&password=mysql");
            statement = connection.prepareStatement(cmdData);
            statement.setString(1,myDate);
            result = statement.executeQuery();
 
            while( result.next() ){
                Vector<String> newRow = new Vector<>();
                 newRow.addElement(result.getString("Eid"));
                 newRow.addElement(result.getString("Eclass"));
                 newRow.addElement(result.getString("Ename"));
                 newRow.addElement(result.getString("Cdate"));
                 newRow.addElement(result.getString("Cin"));
                 newRow.addElement(result.getString("Cout"));
                 DFMO4.addRow(newRow);
                 DFMO4.fireTableDataChanged();
            }
            statement.close();
            
        } catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!0000");
        }        
     }
     
     //即時顯示
     public ActionListener RemoveAllElements = new ActionListener(){
         public void actionPerformed(ActionEvent e){
             if( e.getSource() == home_insert_Btn){
                 DFMO1.getDataVector().removeAllElements();
                 findRD_in_TB_BBS();

                 theme_TxFd.setText(null);
             }

             if( e.getSource() == stock_updata_Btn){
                 DFMO2.getDataVector().removeAllElements();
                 String product=new String();
                 product=(String)cbox[1].getSelectedItem();
                 Search_Product(product);

                 purchase_TxFd.setText("0");
                 damage_TxFd.setText("0");
            }

             if( e.getSource() == staff_insert_Btn){
                 DFMO3.getDataVector().removeAllElements();
                 ShowRD_in_TB_Employee();
                 
                 staff_no_TxFd.setText(null);
                 name_TxFd.setText(null);
                 phone_TxFd.setText(null);
                 email_TxFd.setText(null);
                 password_TexFd.setText(null);
            }

             if( e.getSource() == staff_updata_Btn){
                 DFMO3.getDataVector().removeAllElements();
                 ShowRD_in_TB_Employee();
                 
                 staff_no_TxFd.setText(null);
                 name_TxFd.setText(null);
                 phone_TxFd.setText(null);
                 email_TxFd.setText(null);
                 password_TexFd.setText(null);
             }
            
         }
     };


     //事件傾聽程式: 處理點按[日期選擇]按鈕
     public ActionListener SelectDate = new ActionListener(){
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == punch_query_Btn){
                DatePopup dp1 = new DatePopup(punch_date_TxFd);
                dp1.showDialog();
            }
        }
     };

     //日期執行緒
     public class day extends Thread{
         public void run(){
             SimpleDateFormat day = new SimpleDateFormat("yyyy/MM/dd");
             while(true){
                 Date dated = new Date();
                 date_TxFd.setText(day.format(dated));
             }
         }
     }
 } //end for: class CHCI_back_management_panel

 
