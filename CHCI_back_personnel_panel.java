
//匯入需要的各類套件
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.text.DateFormat;//自定義日期時間格式
import java.text.SimpleDateFormat;//自定義日期時間格式
import java.util.Date;//自定義日期時間格式
import java.util.*;
import java.sql.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;


 //人機互動層類別
 //CHCI_back_personnel_panel: Class HumanComputerInteraction_back_personnel_panel (人機介面-[後台人事]操作畫面類別)

 class CHCI_back_personnel_panel extends JPanel{
     
     int w = 1280;
     int h = 800;

     day dayr = new day();//建立日期執行緒
     time timer = new time();//建立時間執行緒
     Date dated = new Date();//建立日期變數
     Date datet = new Date();//建立時間變數

     JPanel p = new JPanel(); //打卡
     JPanel p2 = new JPanel(); //員工
     JPanel Punch_Panel = new JPanel(); //打卡操作
     JTabbedPane tbp = new JTabbedPane();
     Color c1 = new Color(255,222,173);
     Color c2 = new Color(237,237,237);
     Color c3 = new Color(255,222,173);
     Color c4 = new Color(141,238,238);
     Font font = new Font("微軟正黑體",Font.PLAIN,25);
     Font font2 = new Font("微軟正黑體",Font.PLAIN,40);
     Font font3 = new Font("微軟正黑體",Font.PLAIN,30);

     JLabel Today_Label = new JLabel("今日日期");
     JLabel Time_Label = new JLabel("現在時間");
     JLabel UserNumber_Label = new JLabel("員工編號");
     JLabel UserName_Label = new JLabel("員工姓名");
     JLabel WorkMode_Label = new JLabel("工作狀態");

     JTextField Today_TxFd = new JTextField();
     JTextField Time_TxFd = new JTextField();
     JTextField UserNumber_TxFd = new JTextField("");
     JTextField UserName_TxFd = new JTextField("");
     JTextField WorkMode_TxFd = new JTextField("");

     JButton Staff_no_query_Btn = new JButton("查詢");
     JButton Punch_Btn = new JButton("打卡");
     JButton PunchOut_Btn = new JButton("下班");
     JButton PunchIn_Btn = new JButton("上班");

     //下方表格
     //rowData用來存放行資料  
     //columnNames存放列名

     Vector rowData1,columnNames1,rowData2,columnNames2;
     JTable table1,table2 = null;
     JScrollPane sp1,sp2=null;
     JTableHeader head1,head2 = null;
     DefaultTableModel DFMO1,DFMO2;
     
     //建構子:類別CHCI_back_personnel_panel
     public CHCI_back_personnel_panel(){

         dayr.start();//呼叫日期執行緒start()方法
         timer.start();//呼叫時間執行緒start()方法

         columnNames1 = new Vector(); 
         columnNames1.add("員工編號");  
         columnNames1.add("職稱");
         columnNames1.add("姓名");  
         columnNames1.add("上班時間");
         columnNames1.add("下班時間");  

         DFMO1 = new DefaultTableModel(rowData1, columnNames1){
             public boolean isCellEditable(int row, int column){
                 return false;
            }
         };
         table1 = new JTable(DFMO1);
         table1.setFont(font);
         table1.setRowHeight(40);
         table1.setEnabled(false);//設定表格只能顯示
         head1 = table1.getTableHeader();
         head1.setFont(font);
         sp1 = new JScrollPane(table1,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                             ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

         sp1.setBounds(20,15,740,630);
         p.add(sp1);

         //今日日期
         Today_Label.setBounds(8,3,120,70);
         Today_Label.setFont(font);
         //Today_Label.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));  //標線
         Punch_Panel.add(Today_Label);

         //今日日期欄位
         Today_TxFd.setBounds(120, 13, 190, 45);
         Today_TxFd.setFont(font);
         Today_TxFd.setEditable(false);
         //Today_TxFd.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
         Today_TxFd.setBackground(Color.white);
         Punch_Panel.add(Today_TxFd);

         //現在時間
         Time_Label.setBounds(8,73,120,70); 
         Time_Label.setFont(font);
         Punch_Panel.add(Time_Label);
         
         //現在時間欄位
         Time_TxFd.setBounds(120, 83, 190, 45);
         Time_TxFd.setFont(font);
         Time_TxFd.setEditable(false);
         //Time_TxFd.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
         Time_TxFd.setBackground(Color.white);
         Punch_Panel.add(Time_TxFd);

         
         columnNames2 = new Vector(); 
         columnNames2.add("員工編號");  
         columnNames2.add("職稱");
         columnNames2.add("姓名");  
         columnNames2.add("電話");
         columnNames2.add("E-mail");  
         
         DFMO2 = new DefaultTableModel(rowData2, columnNames2){
             public boolean isCellEditable(int row, int column){
                 return false;
            }
         };
         table2 = new JTable(DFMO2){
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component component = super.prepareRenderer(renderer, row, column);
                int rendererWidth = component.getPreferredSize().width;
                TableColumn tableColumn = getColumnModel().getColumn(column);
                tableColumn.setPreferredWidth(Math.max(rendererWidth + getIntercellSpacing().width, tableColumn.getPreferredWidth()));
                return component;
             }
         };
         table2.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
         table2.setFont(font);
         table2.setRowHeight(40);
         table2.setEnabled(false);//設定表格只能顯示
         head2 = table2.getTableHeader();
         head2.setFont(font);
         sp2 = new JScrollPane(table2,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                             ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

         sp2.setBounds(20,15,1065,630);
         p2.add(sp2);

         //員工編號
         UserNumber_Label.setBounds(8,161,120,70); 
         UserNumber_Label.setFont(font);
         Punch_Panel.add(UserNumber_Label);

         //員工編號欄位
         UserNumber_TxFd.setBounds(123, 173, 100, 45);
         UserNumber_TxFd.setFont(font);
         UserNumber_TxFd.setEditable(true);
         UserNumber_TxFd.setBackground(Color.white);
         Punch_Panel.add(UserNumber_TxFd);

         //員工編號查詢鈕
         Staff_no_query_Btn.setBounds(230, 173, 84, 45);
         Staff_no_query_Btn.setBackground(c4);
         Staff_no_query_Btn.setBorder(BorderFactory.createRaisedBevelBorder());
         Staff_no_query_Btn.setFont(font);
         Punch_Panel.add(Staff_no_query_Btn);

         //員工姓名
         UserName_Label.setBounds(8,240,120,70);
         UserName_Label.setFont(font);
         Punch_Panel.add(UserName_Label);
         
         //員工姓名欄位
         UserName_TxFd.setBounds(120, 253, 190, 45);
         UserName_TxFd.setFont(font);
         UserName_TxFd.setEditable(false);
         UserName_TxFd.setBackground(Color.white);
         Punch_Panel.add(UserName_TxFd); 

         //工作狀態
         WorkMode_Label.setBounds(8,320,120,70); 
         WorkMode_Label.setFont(font);
         Punch_Panel.add(WorkMode_Label);

         //工作狀態欄位
         WorkMode_TxFd.setBounds(120, 330, 190, 45);
         WorkMode_TxFd.setFont(font);
         WorkMode_TxFd.setEditable(false);
         WorkMode_TxFd.setBackground(Color.white);
         Punch_Panel.add(WorkMode_TxFd);

         //上班鈕
         PunchIn_Btn.setBounds(45, 403, 100, 45);
         PunchIn_Btn.setFont(font);
         PunchIn_Btn.setBackground(Color.pink);
         PunchIn_Btn.setBorder(BorderFactory.createRaisedBevelBorder());
         PunchIn_Btn.addActionListener(WorkMode);
         Punch_Panel.add(PunchIn_Btn);

         //下班鈕
         PunchOut_Btn.setBounds(170, 403, 100, 45);
         PunchOut_Btn.setFont(font);
         Color LightSkyBlue = new Color(135,206,250);
         PunchOut_Btn.setBackground(LightSkyBlue);
         PunchOut_Btn.setBorder(BorderFactory.createRaisedBevelBorder());
         PunchOut_Btn.addActionListener(WorkMode);
         Punch_Panel.add(PunchOut_Btn);

         //打卡鈕
         Punch_Btn.setBounds(30, 475, 260, 45);
         Punch_Btn.setFont(font);
         Color lightGreen = new Color(152,224,173);
         Punch_Btn.setBorder(BorderFactory.createRaisedBevelBorder());
         Punch_Btn.setBackground(lightGreen);
         Punch_Btn.addActionListener(RemoveAllElements);
         Punch_Panel.add(Punch_Btn);

         //打卡介面
         Punch_Panel.setBounds(775,15,320,630);
         Punch_Panel.setBackground(c1);
         Punch_Panel.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));  //標線
         Punch_Panel.setLayout(null);
         p.add(Punch_Panel);

         p.setBackground(c1);
         p.setLayout(null);
         tbp.add("打卡",p);

         p2.setBackground(c1);
         p2.setLayout(null);
         tbp.add("員工",p2);

         tbp.setFont(font);
         tbp.setBounds(0,0,w-163,h-55);
         add(tbp);

         setBackground(c1);
         setLocation(160,55);
         setSize(w-163,h-55);
         setLayout(null);
         setVisible(true);

         ShowRD_in_TB_Employee();
         ShowRD_in_TB_clockin();
     }

     public void ShowRD_in_TB_Employee(){
        Connection connection;
        PreparedStatement statement;
        ResultSet result;
        String cmdData;

        rowData2=new Vector();

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
                  DFMO2.addRow(newRow);
                  DFMO2.fireTableDataChanged();
             }
             statement.close();
             
        } catch(SQLException e){
             e.printStackTrace();
             JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
        }        
    }

     public void ShowRD_in_TB_clockin(){
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
             cmdData = "SELECT clockin.Eid, employee.Eclass, employee.Ename, clockin.Cin, clockin.Cout "+
                       "FROM clockin INNER JOIN employee ON clockin.Eid = employee.Eid " +
                       "WHERE  Cdate = ?"+
                       "ORDER BY clockin.Cid DESC";
             connection = DriverManager.getConnection("jdbc:mysql://localhost/cafedb" + "?user=root&password=mysql");
             statement = connection.prepareStatement(cmdData);
             statement.setString(1, CHCI_front_frame.b11.getText().trim());
             result = statement.executeQuery();
  
             while( result.next() ){
                 Vector<String> newRow = new Vector<>();
                  newRow.addElement(result.getString("Eid"));
                  newRow.addElement(result.getString("Eclass"));
                  newRow.addElement(result.getString("Ename"));
                  newRow.addElement(result.getString("Cin"));
                  newRow.addElement(result.getString("Cout"));
                  DFMO1.addRow(newRow);
                  DFMO1.fireTableDataChanged();
             }
             statement.close();
             
         } catch(SQLException e){
             e.printStackTrace();
             JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!0000");
         }        
     }
    
     public ActionListener WorkMode = new ActionListener(){
         public void actionPerformed(ActionEvent e){

             if( e.getSource() == PunchIn_Btn){
                 WorkMode_TxFd.setText("上班");
             }

             if( e.getSource() == PunchOut_Btn){
                 WorkMode_TxFd.setText("下班");
            }

         }
     };

     //即時顯示
     public ActionListener RemoveAllElements = new ActionListener(){
         public void actionPerformed(ActionEvent e){
            if( e.getSource() == Punch_Btn){
                DFMO1.getDataVector().removeAllElements();
                ShowRD_in_TB_clockin();
            }

         }
     };
     
     //日期執行緒
     public class day extends Thread{
         public void run(){
             SimpleDateFormat day = new SimpleDateFormat("yyyy/MM/dd");
             while(true){
                 Date dated = new Date();
                 Today_TxFd.setText(day.format(dated));
                 CHCI_front_frame.b11.setText(day.format(dated));
             }
         }
     }
     //時間執行緒
     public class time extends Thread{
         public void run(){
             SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss");
             while(true){
                 Date datet = new Date();
                 Time_TxFd.setText(time.format(datet));
                 CHCI_front_frame.b12.setText(time.format(datet));
             }
         }
     }

 } //end for: class CHCI_back_personnel_panel

 
