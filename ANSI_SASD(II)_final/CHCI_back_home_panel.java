
//匯入需要的各類套件
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.sql.*;
import java.util.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;


 //人機互動層類別
 //CHCI_back_home_panel: Class HumanComputerInteraction_back_home_panel (人機介面-[後台主頁]操作畫面類別)

 class CHCI_back_home_panel extends JPanel{
     
     int w = 1280;
     int h = 800;

     JTabbedPane tbp = new JTabbedPane();
     JPanel p = new JPanel();
     JLabel TitleLabel = new JLabel("公告");
     Color c1 = new Color(255,222,173); //新的
     Color c2 = new Color(237, 237, 237);
     Font font = new Font("微軟正黑體",Font.PLAIN,25);
     Font font2 = new Font("微軟正黑體",Font.PLAIN,40);

     //下方表格
     //rowData用來存放行資料  
     //columnNames存放列名

     Vector rowData,columnNames;
     JTable table = null;
     JScrollPane sp=null;
     JTableHeader head = null;
     DefaultTableModel DFMO;

     TableColumnModel cModel = null; 
     //取得這個table某個欄位的資訊
     TableColumn columnDate = null; 
     TableColumn columnContent = null; 
     
     //建構子:類別CHIC_back_home_panel
     public CHCI_back_home_panel(){

         TitleLabel.setBounds(20, 0, 100, 100);
         TitleLabel.setFont(font2);
         p.add(TitleLabel);

         //設定列名 
         columnNames=new Vector(); 
         columnNames.add("發布時間");  
         columnNames.add("公告");

         DFMO = new DefaultTableModel(rowData, columnNames){
             public boolean isCellEditable(int row, int column){
                 return false;
             }
         };
         table = new JTable(DFMO);
         table.setFont(font);
         table.setRowHeight(40);
         table.setEnabled(false);//設定表格只能顯示
         head = table.getTableHeader();
         head.setFont(font);
         sp = new JScrollPane(table,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                             ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);  

         cModel = table.getColumnModel();
         //取得這個table某個欄位的資訊
         columnDate = cModel.getColumn(0);
         columnContent = cModel.getColumn(1);
         columnDate.setPreferredWidth(250);
         columnContent.setPreferredWidth(750);

         //初始化 sp  
         sp.setBounds(20,100,1065,545);
         p.add(sp);
         
         p.setBackground(c1);
         p.setLayout(null);
         tbp.add("主頁",p);

         tbp.setFont(font);
         tbp.setBounds(0,0,w-163,h-55);
         add(tbp);

         setBackground(c1);
         setLocation(160,55);
         setSize(w-163,h-55);
         setLayout(null);
         setVisible(true);

         findRD_in_TB_BBS();
     }

     /*******************查詢公告*************** */
     public void findRD_in_TB_BBS(){

         Connection connection;
         PreparedStatement statement;
         ResultSet result;
         String cmdData;
 
         rowData=new Vector();
            
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
                 DFMO.addRow(newRow);
		         DFMO.fireTableDataChanged();        
             }
              statement.close();  
         }
         catch(SQLException e){
             e.printStackTrace();
             JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!321");
             System.out.println(e.getMessage());
         }       
     } 
     /*******************查詢公告*************** */

 } //end for: class CHCI_back_home_panel

 
