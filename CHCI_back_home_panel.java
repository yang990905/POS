
//�פJ�ݭn���U���M��
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.sql.*;
import java.util.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;


 //�H�����ʼh���O
 //CHCI_back_home_panel: Class HumanComputerInteraction_back_home_panel (�H������-[��x�D��]�ާ@�e�����O)

 class CHCI_back_home_panel extends JPanel{
     
     int w = 1280;
     int h = 800;

     JTabbedPane tbp = new JTabbedPane();
     JPanel p = new JPanel();
     JLabel TitleLabel = new JLabel("���i");
     Color c1 = new Color(255,222,173); //�s��
     Color c2 = new Color(237, 237, 237);
     Font font = new Font("�L�n������",Font.PLAIN,25);
     Font font2 = new Font("�L�n������",Font.PLAIN,40);

     //�U����
     //rowData�ΨӦs�����  
     //columnNames�s��C�W

     Vector rowData,columnNames;
     JTable table = null;
     JScrollPane sp=null;
     JTableHeader head = null;
     DefaultTableModel DFMO;

     TableColumnModel cModel = null; 
     //���o�o��table�Y����쪺��T
     TableColumn columnDate = null; 
     TableColumn columnContent = null; 
     
     //�غc�l:���OCHIC_back_home_panel
     public CHCI_back_home_panel(){

         TitleLabel.setBounds(20, 0, 100, 100);
         TitleLabel.setFont(font2);
         p.add(TitleLabel);

         //�]�w�C�W 
         columnNames=new Vector(); 
         columnNames.add("�o���ɶ�");  
         columnNames.add("���i");

         DFMO = new DefaultTableModel(rowData, columnNames){
             public boolean isCellEditable(int row, int column){
                 return false;
             }
         };
         table = new JTable(DFMO);
         table.setFont(font);
         table.setRowHeight(40);
         table.setEnabled(false);//�]�w���u�����
         head = table.getTableHeader();
         head.setFont(font);
         sp = new JScrollPane(table,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                             ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);  

         cModel = table.getColumnModel();
         //���o�o��table�Y����쪺��T
         columnDate = cModel.getColumn(0);
         columnContent = cModel.getColumn(1);
         columnDate.setPreferredWidth(250);
         columnContent.setPreferredWidth(750);

         //��l�� sp  
         sp.setBounds(20,100,1065,545);
         p.add(sp);
         
         p.setBackground(c1);
         p.setLayout(null);
         tbp.add("�D��",p);

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

     /*******************�d�ߤ��i*************** */
     public void findRD_in_TB_BBS(){

         Connection connection;
         PreparedStatement statement;
         ResultSet result;
         String cmdData;
 
         rowData=new Vector();
            
         //��Ʈw�e�m�@�~
         try{
             Class.forName("com.mysql.jdbc.Driver");
         } 
         catch(Exception e){
             JOptionPane.showMessageDialog(null,"MySQL�X�ʵ{���w�˥���!"); 
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
             JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!321");
             System.out.println(e.getMessage());
         }       
     } 
     /*******************�d�ߤ��i*************** */

 } //end for: class CHCI_back_home_panel

 
