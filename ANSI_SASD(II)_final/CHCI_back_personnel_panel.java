
//�פJ�ݭn���U���M��
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.text.DateFormat;//�۩w�q����ɶ��榡
import java.text.SimpleDateFormat;//�۩w�q����ɶ��榡
import java.util.Date;//�۩w�q����ɶ��榡
import java.util.*;
import java.sql.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;


 //�H�����ʼh���O
 //CHCI_back_personnel_panel: Class HumanComputerInteraction_back_personnel_panel (�H������-[��x�H��]�ާ@�e�����O)

 class CHCI_back_personnel_panel extends JPanel{
     
     int w = 1280;
     int h = 800;

     day dayr = new day();//�إߤ�������
     time timer = new time();//�إ߮ɶ������
     Date dated = new Date();//�إߤ���ܼ�
     Date datet = new Date();//�إ߮ɶ��ܼ�

     JPanel p = new JPanel(); //���d
     JPanel p2 = new JPanel(); //���u
     JPanel Punch_Panel = new JPanel(); //���d�ާ@
     JTabbedPane tbp = new JTabbedPane();
     Color c1 = new Color(255,222,173);
     Color c2 = new Color(237,237,237);
     Color c3 = new Color(255,222,173);
     Color c4 = new Color(141,238,238);
     Font font = new Font("�L�n������",Font.PLAIN,25);
     Font font2 = new Font("�L�n������",Font.PLAIN,40);
     Font font3 = new Font("�L�n������",Font.PLAIN,30);

     JLabel Today_Label = new JLabel("������");
     JLabel Time_Label = new JLabel("�{�b�ɶ�");
     JLabel UserNumber_Label = new JLabel("���u�s��");
     JLabel UserName_Label = new JLabel("���u�m�W");
     JLabel WorkMode_Label = new JLabel("�u�@���A");

     JTextField Today_TxFd = new JTextField();
     JTextField Time_TxFd = new JTextField();
     JTextField UserNumber_TxFd = new JTextField("");
     JTextField UserName_TxFd = new JTextField("");
     JTextField WorkMode_TxFd = new JTextField("");

     JButton Staff_no_query_Btn = new JButton("�d��");
     JButton Punch_Btn = new JButton("���d");
     JButton PunchOut_Btn = new JButton("�U�Z");
     JButton PunchIn_Btn = new JButton("�W�Z");

     //�U����
     //rowData�ΨӦs�����  
     //columnNames�s��C�W

     Vector rowData1,columnNames1,rowData2,columnNames2;
     JTable table1,table2 = null;
     JScrollPane sp1,sp2=null;
     JTableHeader head1,head2 = null;
     DefaultTableModel DFMO1,DFMO2;
     
     //�غc�l:���OCHCI_back_personnel_panel
     public CHCI_back_personnel_panel(){

         dayr.start();//�I�s��������start()��k
         timer.start();//�I�s�ɶ������start()��k

         columnNames1 = new Vector(); 
         columnNames1.add("���u�s��");  
         columnNames1.add("¾��");
         columnNames1.add("�m�W");  
         columnNames1.add("�W�Z�ɶ�");
         columnNames1.add("�U�Z�ɶ�");  

         DFMO1 = new DefaultTableModel(rowData1, columnNames1){
             public boolean isCellEditable(int row, int column){
                 return false;
            }
         };
         table1 = new JTable(DFMO1);
         table1.setFont(font);
         table1.setRowHeight(40);
         table1.setEnabled(false);//�]�w���u�����
         head1 = table1.getTableHeader();
         head1.setFont(font);
         sp1 = new JScrollPane(table1,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                             ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

         sp1.setBounds(20,15,740,630);
         p.add(sp1);

         //������
         Today_Label.setBounds(8,3,120,70);
         Today_Label.setFont(font);
         //Today_Label.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));  //�нu
         Punch_Panel.add(Today_Label);

         //���������
         Today_TxFd.setBounds(120, 13, 190, 45);
         Today_TxFd.setFont(font);
         Today_TxFd.setEditable(false);
         //Today_TxFd.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
         Today_TxFd.setBackground(Color.white);
         Punch_Panel.add(Today_TxFd);

         //�{�b�ɶ�
         Time_Label.setBounds(8,73,120,70); 
         Time_Label.setFont(font);
         Punch_Panel.add(Time_Label);
         
         //�{�b�ɶ����
         Time_TxFd.setBounds(120, 83, 190, 45);
         Time_TxFd.setFont(font);
         Time_TxFd.setEditable(false);
         //Time_TxFd.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
         Time_TxFd.setBackground(Color.white);
         Punch_Panel.add(Time_TxFd);

         
         columnNames2 = new Vector(); 
         columnNames2.add("���u�s��");  
         columnNames2.add("¾��");
         columnNames2.add("�m�W");  
         columnNames2.add("�q��");
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
         table2.setEnabled(false);//�]�w���u�����
         head2 = table2.getTableHeader();
         head2.setFont(font);
         sp2 = new JScrollPane(table2,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                             ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

         sp2.setBounds(20,15,1065,630);
         p2.add(sp2);

         //���u�s��
         UserNumber_Label.setBounds(8,161,120,70); 
         UserNumber_Label.setFont(font);
         Punch_Panel.add(UserNumber_Label);

         //���u�s�����
         UserNumber_TxFd.setBounds(123, 173, 100, 45);
         UserNumber_TxFd.setFont(font);
         UserNumber_TxFd.setEditable(true);
         UserNumber_TxFd.setBackground(Color.white);
         Punch_Panel.add(UserNumber_TxFd);

         //���u�s���d�߶s
         Staff_no_query_Btn.setBounds(230, 173, 84, 45);
         Staff_no_query_Btn.setBackground(c4);
         Staff_no_query_Btn.setBorder(BorderFactory.createRaisedBevelBorder());
         Staff_no_query_Btn.setFont(font);
         Punch_Panel.add(Staff_no_query_Btn);

         //���u�m�W
         UserName_Label.setBounds(8,240,120,70);
         UserName_Label.setFont(font);
         Punch_Panel.add(UserName_Label);
         
         //���u�m�W���
         UserName_TxFd.setBounds(120, 253, 190, 45);
         UserName_TxFd.setFont(font);
         UserName_TxFd.setEditable(false);
         UserName_TxFd.setBackground(Color.white);
         Punch_Panel.add(UserName_TxFd); 

         //�u�@���A
         WorkMode_Label.setBounds(8,320,120,70); 
         WorkMode_Label.setFont(font);
         Punch_Panel.add(WorkMode_Label);

         //�u�@���A���
         WorkMode_TxFd.setBounds(120, 330, 190, 45);
         WorkMode_TxFd.setFont(font);
         WorkMode_TxFd.setEditable(false);
         WorkMode_TxFd.setBackground(Color.white);
         Punch_Panel.add(WorkMode_TxFd);

         //�W�Z�s
         PunchIn_Btn.setBounds(45, 403, 100, 45);
         PunchIn_Btn.setFont(font);
         PunchIn_Btn.setBackground(Color.pink);
         PunchIn_Btn.setBorder(BorderFactory.createRaisedBevelBorder());
         PunchIn_Btn.addActionListener(WorkMode);
         Punch_Panel.add(PunchIn_Btn);

         //�U�Z�s
         PunchOut_Btn.setBounds(170, 403, 100, 45);
         PunchOut_Btn.setFont(font);
         Color LightSkyBlue = new Color(135,206,250);
         PunchOut_Btn.setBackground(LightSkyBlue);
         PunchOut_Btn.setBorder(BorderFactory.createRaisedBevelBorder());
         PunchOut_Btn.addActionListener(WorkMode);
         Punch_Panel.add(PunchOut_Btn);

         //���d�s
         Punch_Btn.setBounds(30, 475, 260, 45);
         Punch_Btn.setFont(font);
         Color lightGreen = new Color(152,224,173);
         Punch_Btn.setBorder(BorderFactory.createRaisedBevelBorder());
         Punch_Btn.setBackground(lightGreen);
         Punch_Btn.addActionListener(RemoveAllElements);
         Punch_Panel.add(Punch_Btn);

         //���d����
         Punch_Panel.setBounds(775,15,320,630);
         Punch_Panel.setBackground(c1);
         Punch_Panel.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));  //�нu
         Punch_Panel.setLayout(null);
         p.add(Punch_Panel);

         p.setBackground(c1);
         p.setLayout(null);
         tbp.add("���d",p);

         p2.setBackground(c1);
         p2.setLayout(null);
         tbp.add("���u",p2);

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

        //��Ʈw�e�m�@�~
          try{
                Class.forName("com.mysql.jdbc.Driver");
          } catch(Exception e){
                JOptionPane.showMessageDialog(null,"MySQL�X�ʵ{���w�˥���!"); 
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
             JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
        }        
    }

     public void ShowRD_in_TB_clockin(){
         Connection connection;
         PreparedStatement statement;
         ResultSet result;
         String cmdData;

         rowData1=new Vector();

         //��Ʈw�e�m�@�~
         try{
             Class.forName("com.mysql.jdbc.Driver");
         } catch(Exception e){
             JOptionPane.showMessageDialog(null,"MySQL�X�ʵ{���w�˥���!"); 
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
             JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!0000");
         }        
     }
    
     public ActionListener WorkMode = new ActionListener(){
         public void actionPerformed(ActionEvent e){

             if( e.getSource() == PunchIn_Btn){
                 WorkMode_TxFd.setText("�W�Z");
             }

             if( e.getSource() == PunchOut_Btn){
                 WorkMode_TxFd.setText("�U�Z");
            }

         }
     };

     //�Y�����
     public ActionListener RemoveAllElements = new ActionListener(){
         public void actionPerformed(ActionEvent e){
            if( e.getSource() == Punch_Btn){
                DFMO1.getDataVector().removeAllElements();
                ShowRD_in_TB_clockin();
            }

         }
     };
     
     //��������
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
     //�ɶ������
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

 
