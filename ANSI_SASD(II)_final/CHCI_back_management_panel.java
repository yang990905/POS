
 //�פJ�ݭn���U���M��
 import javax.swing.*;
 import java.awt.event.*;
 import java.awt.*;
 import javax.swing.border.*;
 import javax.swing.table.*;
 import java.text.DateFormat;//�۩w�q����ɶ��榡
 import java.text.SimpleDateFormat;//�۩w�q����ɶ��榡
 import java.util.Date;//�۩w�q����ɶ��榡
 import java.sql.*;
 import java.util.*;

 //�H�����ʼh���O
 //CHCI_back_management_panel: Class HumanComputerInteraction_back_management_panel (�H������-[��x�޲z]�ާ@�e�����O)

 class CHCI_back_management_panel extends JPanel{
     
     int w = 1280;
     int h = 800;

     day dayr = new day();//�إߤ�������
     Date dated = new Date();//�إߤ���ܼ�
     Date datet = new Date();//�إ߮ɶ��ܼ�

     JPanel p = new JPanel(); //�D���޲z
     JPanel p2 = new JPanel(); //�w�s�޲z
     JPanel p3 = new JPanel(); //���u�޲z
     JPanel p4 = new JPanel(); //���d����
     JPanel Staff_Panel = new JPanel(); //���u�ާ@
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
     Color c14 = new Color(152,251,152);  //�s��
     Color c15 = new Color(175,238,238);

     Font font = new Font("�L�n������",Font.PLAIN,25);
     Font font2 = new Font("�L�n������",Font.PLAIN,40);
     Font font3 = new Font("�L�n������",Font.PLAIN,30);
     Font font4 = new Font("�L�n������",Font.PLAIN,30);

     JLabel New_news_Label = new JLabel("�s�W���i"); //�D��
     JLabel date_Label = new JLabel("���");  //�D��
     JLabel theme_Label = new JLabel("���i"); //�D��
     JLabel ProductClassLabel = new JLabel("���~���O");
     JLabel ProductLabel = new JLabel("�~��");
     JLabel price_Label = new JLabel("��@�@��");  //�w�s
     JLabel stock_Label = new JLabel("�s�@�@�q");  //�w�s
     JLabel purchase_Label = new JLabel("�i�f�W�["); //�w�s
     JLabel damage_Label = new JLabel("�l�a���");  //�w�s
     JLabel staff_no_Label = new JLabel("���u�s��"); //���u�޲z
     JLabel job_title_Label = new JLabel("¾�@�@��"); //���u�޲z
     JLabel name_Label = new JLabel("�m�@�@�W");  //���u�޲z
     JLabel phone_Label = new JLabel("�q�@�@��"); //���u�޲z
     JLabel email_Label = new JLabel("Email");  //���u�޲z
     JLabel password_Label =new JLabel("�K�@�@�X"); //���u�޲z
     JLabel punch_date_Label = new JLabel("���");  //���d

     JTextField date_TxFd = new JTextField(""); //�D��_���
     JTextField theme_TxFd = new JTextField(""); //�D��_�D�D
     JTextField price_TxFd = new JTextField(""); //�w�s_���
     JTextField stock_TxFd = new JTextField(""); //�w�s_�s�q
     JTextField purchase_TxFd = new JTextField("0"); //�w�s_�i�f�W�[
     JTextField damage_TxFd = new JTextField("0"); //�w�s_�l�a���
     JTextField staff_no_TxFd = new JTextField(""); //���u�޲z_���u�s��
     JTextField name_TxFd = new JTextField(""); //���u�޲z_�m�W
     JTextField phone_TxFd = new JTextField(""); //���u�޲z_�q��
     JTextField email_TxFd = new JTextField("@Chindish_Cafe.com"); //���u�޲z_Email
     JPasswordField password_TexFd =new JPasswordField(""); //���u�޲z_�K�X
     JTextField punch_date_TxFd = new JTextField(""); //���d_���

     JButton home_insert_Btn = new JButton("�s�W"); //�D��_�s�W
     JButton queryBtn = new JButton("�~���d��");
     JButton Total_querylBtn = new JButton("�����~��");
     JButton stock_updata_Btn = new JButton("��s");  //�w�s_��s
     JButton staff_no_query_Btn = new JButton("�d��");  //���u�޲z_�s���d��
     JButton staff_insert_Btn = new JButton("�s�W");  //���u�޲z_�s�W
     JButton staff_updata_Btn = new JButton("��s");  //���u�޲z_��s
     JButton punch_query_Btn = new JButton("���");  //���d����_���
     JButton punch_Enter_Btn = new JButton("�d��"); //���d����_�d��

     String[] curstr = new String[3]; //JComboBox���W���x�s�A�d�ߤU�@��JComboBox
     Boolean flag = true;
     String search;

     int index = 0;

     JComboBox[] cbox = new JComboBox[2];
     String[] CB = {"pclass","pname","product"};

     String[] job_itms= {"���u","�D��"};
     JComboBox job_title_cbox = new JComboBox(job_itms);

     TableColumnModel cModel = null; 
     //���o�o��table�Y����쪺��T
     TableColumn columnDate = null; 
     TableColumn columnContent = null; 
     
     Vector rowData1,columnNames1,rowData2,columnNames2,rowData3,columnNames3,rowData4,columnNames4;
     JTable table1,table2,table3,table4 = null;
     JScrollPane sp1,sp2,sp3,sp4 =null;
     JTableHeader head1,head2,head3,head4 = null;
     DefaultTableModel DFMO1,DFMO2,DFMO3,DFMO4;

     //�غc�l:���OCHCI_back_management_panel
     public CHCI_back_management_panel(){

         dayr.start();//�I�s��������start()��k

         /*-------------��������--�D���޲z--��������---------------*/
         //�s�W���i{
         New_news_Label.setBounds(10, 0, 200, 100);
         New_news_Label.setFont(font3);
         p.add(New_news_Label);

         //���
         date_Label.setBounds(40, 85, 300, 45);
         date_Label.setFont(font4);
         p.add(date_Label);

         //������
         date_TxFd.setBounds(120, 90, 300, 45);
         date_TxFd.setFont(font);
         date_TxFd.setEditable(false);
         date_TxFd.setBackground(Color.white);
         p.add(date_TxFd);

         //�D�D
         theme_Label.setBounds(40, 160, 300, 45);
         theme_Label.setFont(font4);
         p.add(theme_Label);

         //�D�D���
         theme_TxFd.setBounds(120, 160, 750, 45);
         theme_TxFd.setFont(font);
         theme_TxFd.setBackground(Color.white);
         p.add(theme_TxFd);

         //�s�W�s
         home_insert_Btn.setBounds(900, 160, 140, 45);
         home_insert_Btn.setBackground(c3);
         home_insert_Btn.setFont(font);
         home_insert_Btn.addActionListener(RemoveAllElements);
         home_insert_Btn.setBorder(BorderFactory.createRaisedBevelBorder());
         p.add(home_insert_Btn);
        
         //�s�W���i���}
         columnNames1=new Vector(); 
         columnNames1.add("�o���ɶ�");  
         columnNames1.add("���i");

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
         //���o�o��table�Y����쪺��T
         columnDate = cModel.getColumn(0);
         columnContent = cModel.getColumn(1);
         columnDate.setPreferredWidth(250);
         columnContent.setPreferredWidth(750);
		 table1.setEnabled(false);//�]�w���u�����
		 head1.setFont(font);
         sp1.setBounds(20,230,1065,425);
         p.add(sp1);

         findRD_in_TB_BBS();
         /*-------------��������--�D���޲z--��������--------------*/
         

         /*-------------��������--�w�s�޲z--��������---------------*/ 
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

         //�~��
         ProductLabel.setBounds(370, 2, 100, 100);
         ProductLabel.setFont(font4);
         p2.add(ProductLabel);

         cbox[1].setBounds(435, 27, 220, 50);
         cbox[1].setFont(font);
         p2.add(cbox[1]);

         //�~���d�߫��s
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
         
         //���
         price_Label.setBounds(20, 70, 150, 100);
         price_Label.setFont(font4);
         p2.add(price_Label);

         //������
         price_TxFd.setBounds(150, 100, 175, 45);
         price_TxFd.setFont(font4);
         p2.add(price_TxFd);

         //�s�q
         stock_Label.setBounds(20, 140, 150, 100);
         stock_Label.setFont(font4);
         p2.add(stock_Label);

         //�s�q���
         stock_TxFd.setBounds(150, 170, 175, 45);
         stock_TxFd.setFont(font4);
         stock_TxFd.setEditable(false);
         p2.add(stock_TxFd);

         //�i�f�W�[
         purchase_Label.setBounds(370, 68, 150, 100);
         purchase_Label.setFont(font4);
         p2.add(purchase_Label);

         //�i�f�W�[���
         purchase_TxFd.setBounds(510, 100, 147, 45);
         purchase_TxFd.setFont(font4);
         p2.add(purchase_TxFd);
         
         //�l�a���
         damage_Label.setBounds(370, 140, 140, 100);
         damage_Label.setFont(font4);
         p2.add(damage_Label);

         //�l�a������
         damage_TxFd.setBounds(510, 170, 147, 45);
         damage_TxFd.setFont(font4);
         p2.add(damage_TxFd);

         //�w�s��s�s
         stock_updata_Btn.setBounds(710, 135, 100, 45);
         stock_updata_Btn.setBackground(c5);
         stock_updata_Btn.setBorder(BorderFactory.createRaisedBevelBorder());
         stock_updata_Btn.setFont(font4);
         stock_updata_Btn.addActionListener(RemoveAllElements);
         p2.add(stock_updata_Btn);

         //�w�s

         columnNames2=new Vector();   
         columnNames2.add("�s��");  
         columnNames2.add("���~���O");  
         columnNames2.add("�~��");  
         columnNames2.add("���");  
         columnNames2.add("�s�q"); 

         DFMO2 = new DefaultTableModel(rowData2, columnNames2){
             public boolean isCellEditable(int row, int column){
                 return false;
            }
         };
         table2 = new JTable(DFMO2);
         table2.setFont(font);		
         table2.setRowHeight(40);
         table2.setEnabled(false);//�]�w���u�����
         head2 = table2.getTableHeader();
         head2.setFont(font);		
         JScrollPane sp2 = new JScrollPane(table2,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                                       ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
         sp2.setBounds(20,230,1065,425);
         p2.add(sp2);

         ShowRD_in_TB_Product();
         /*-------------��������--�w�s�޲z--��������--------------*/


         /*-------------��������--���u�޲z--��������---------------*/
         //���u�޲z{       
         staff_no_Label.setBounds(8,3,120,70); //���u�s��
         staff_no_Label.setFont(font);
         //staff_no_Label.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));  //�нu
         Staff_Panel.add(staff_no_Label);

         //���u�s�����
         staff_no_TxFd.setBounds(120, 13, 100, 45);
         staff_no_TxFd.setFont(font);
         staff_no_TxFd.setBackground(Color.white);
         Staff_Panel.add(staff_no_TxFd);

         //���u�s���d�߶s
         staff_no_query_Btn.setBounds(225, 13, 85, 45);
         staff_no_query_Btn.setBackground(c6);
         staff_no_query_Btn.setBorder(BorderFactory.createRaisedBevelBorder());
         staff_no_query_Btn.setFont(font);
         Staff_Panel.add(staff_no_query_Btn);

         //¾��
         job_title_Label.setBounds(8,73,120,70); 
         job_title_Label.setFont(font);
         Staff_Panel.add(job_title_Label);

         //¾�����
         job_title_cbox.setBounds(120, 83, 190, 45);
         job_title_cbox.setFont(font);
         job_title_cbox.setBackground(Color.white);
         Staff_Panel.add(job_title_cbox);

         //�m�W
         name_Label.setBounds(8,148,120,70); 
         name_Label.setFont(font);
         Staff_Panel.add(name_Label);

         //�m�W���
         name_TxFd.setBounds(120, 161, 190, 45);
         name_TxFd.setFont(font);
         name_TxFd.setBackground(Color.white);
         Staff_Panel.add(name_TxFd);

         //�q��
         phone_Label.setBounds(8,225,120,70); 
         phone_Label.setFont(font);
         Staff_Panel.add(phone_Label);

         //�q�����
         phone_TxFd.setBounds(120, 240, 190, 45);
         phone_TxFd.setFont(font);
         phone_TxFd.setBackground(Color.white);
         Staff_Panel.add(phone_TxFd);

         //Email
         email_Label.setBounds(25,300,120,70); 
         email_Label.setFont(font);
         Staff_Panel.add(email_Label);

         //Email���
         email_TxFd.setBounds(120, 310, 190, 45);
         email_TxFd.setFont(font);
         email_TxFd.setBackground(Color.white);
         Staff_Panel.add(email_TxFd);

         //Password
         password_Label.setBounds(8, 368, 120, 70);
         password_Label.setFont(font);
         Staff_Panel.add(password_Label);

         //Password���
         password_TexFd.setBounds(120, 380, 190, 45);
         password_TexFd.setFont(font);
         password_TexFd.setBackground(Color.white);
         Staff_Panel.add(password_TexFd);

         //�s�W�s
         staff_insert_Btn.setBounds(45, 450, 100, 45);
         staff_insert_Btn.setBackground(c7);
         staff_insert_Btn.setFont(font);
         staff_insert_Btn.setBorder(BorderFactory.createRaisedBevelBorder());
         staff_insert_Btn.addActionListener(RemoveAllElements);
         Staff_Panel.add(staff_insert_Btn);

         //��s�s
         staff_updata_Btn.setBounds(180, 450, 100, 45);
         staff_updata_Btn.setBackground(c8);
         staff_updata_Btn.setFont(font);
         staff_updata_Btn.setBorder(BorderFactory.createRaisedBevelBorder());
         staff_updata_Btn.addActionListener(RemoveAllElements);
         Staff_Panel.add(staff_updata_Btn);

         //�d�߬ɭ�
         Staff_Panel.setBounds(775,15,320,630);
         Staff_Panel.setBackground(c12);
         Staff_Panel.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));  //�нu
         Staff_Panel.setLayout(null);
         p3.add(Staff_Panel);

         //���u�޲z

         columnNames3 = new Vector(); 
         columnNames3.add("�s��");  
         columnNames3.add("¾��");
         columnNames3.add("�m�W");  
         columnNames3.add("�q��");
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
         table3.setFont(font);//���u��
         table3.setRowHeight(40);
         table3.setEnabled(false);//�]�w���u�����
         
         head3 = table3.getTableHeader();
         head3.setFont(font);
         sp3 = new JScrollPane(table3,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                             ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

         sp3.setBounds(20,15,740,630);
         p3.add(sp3);

         ShowRD_in_TB_Employee();
         /*-------------��������--���u�޲z--��������--------------*/


         /*-------------��������--���d����--��������---------------*/
         //���d����{
         punch_date_Label.setBounds(15, 2, 100, 100); //���
         punch_date_Label.setFont(font4);
         p4.add(punch_date_Label);

         //������
         punch_date_TxFd.setBounds(90, 27, 300, 50);
         punch_date_TxFd.setEditable(false);
         punch_date_TxFd.setHorizontalAlignment(JTextField.CENTER);
         punch_date_TxFd.setBackground(Color.WHITE);
         punch_date_TxFd.setFont(font4);
         p4.add(punch_date_TxFd);

         //�d�߫��s
         punch_query_Btn.setBounds(425, 27, 100, 50);
         punch_query_Btn.setBackground(c9);
         punch_query_Btn.setBorder(BorderFactory.createRaisedBevelBorder());
         punch_query_Btn.addActionListener(SelectDate);
         punch_query_Btn.setFont(font4);
         p4.add(punch_query_Btn);

         //�d�߽T�w���s
         punch_Enter_Btn.setBounds(545,27,100,50);
         punch_Enter_Btn.setBackground(c10);
         punch_Enter_Btn.setBorder(BorderFactory.createRaisedBevelBorder());
         punch_Enter_Btn.setFont(font4);
         punch_Enter_Btn.addActionListener(ProcessSubmitdateQuery);
         p4.add(punch_Enter_Btn);

         //���d����}

         columnNames4 = new Vector(); 
         columnNames4.add("���u�s��");  
         columnNames4.add("¾��");
         columnNames4.add("�m�W");
         columnNames4.add("���d���");
         columnNames4.add("�W�Z�ɶ�");
         columnNames4.add("�U�Z�ɶ�");  

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
         /*-------------��������--���d����--��������--------------*/

         p.setBackground(c1);
         p.setLayout(null);
         tbp.add("�D���޲z",p);

         p2.setBackground(c1);
         p2.setLayout(null);
         tbp.add("�w�s�޲z",p2);

         p3.setBackground(c1);
         p3.setLayout(null);
         tbp.add("���u�޲z",p3);

         p4.setBackground(c1);
         p4.setLayout(null);
         tbp.add("���d����",p4);

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
                DFMO1.addRow(newRow);
                DFMO1.fireTableDataChanged();        
            }
             statement.close();  
        }
        catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
        }       
    } 

     public void ShowRD_in_TB_Employee(){
        Connection connection;
        PreparedStatement statement;
        ResultSet result;
        String cmdData;

        rowData3 =new Vector();

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
                  DFMO3.addRow(newRow);
                  DFMO3.fireTableDataChanged();
             }
             statement.close();
             
        } catch(SQLException e){
             e.printStackTrace();
             JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
        }        
    }

     //�إ�ComboBox
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
                    myList.add(result.getString(name[num])); //num=0->pclass�W��
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
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
   
        //���ComboBox�󴫤U�@��ComboBox 
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
                JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
            }
        }
   
        public void ShowRD_in_TB_Product() //���Ҧ����
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
                JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
            }
        }
   
        public ActionListener ProcessSubmitProductQuery = new ActionListener(){  //���s
            public void actionPerformed(ActionEvent e){
                if(e.getSource() == queryBtn)//�~���d��
                {
                     DFMO2.getDataVector().removeAllElements();
                     String product=new String();
                     product=(String)cbox[1].getSelectedItem();
                     Search_Product(product);
                }
                
                if(e.getSource() == Total_querylBtn)//�����~��
                {
                     DFMO2.getDataVector().removeAllElements();
                     ShowRD_in_TB_Product();
                }
                
            }
        };
   
     public void Search_Product(String myProduct)//�d�߸����ܦb���
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
                JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
            }
     }

     public void ShowRD_in_TB_clockin(){
        Connection connection;
        PreparedStatement statement;
        ResultSet result;
        String cmdData;

        rowData4=new Vector();

        //��Ʈw�e�m�@�~
        try{
            Class.forName("com.mysql.jdbc.Driver");
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,"MySQL�X�ʵ{���w�˥���!"); 
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
            JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!0000");
        }        
     }

     public ActionListener ProcessSubmitdateQuery = new ActionListener(){  //���s
        public void actionPerformed(ActionEvent e){

             DFMO4.getDataVector().removeAllElements();
             String date = punch_date_TxFd.getText().trim();

             boolean flag = findRD_date(date);
             if(  date.length() > 0 ){
                 if(flag == false){
                     JOptionPane.showMessageDialog(null,"[����G" + date + "]�A�d�L���d����");
                     punch_date_TxFd.setText(null);
                     DFMO4.getDataVector().removeAllElements();
                     ShowRD_in_TB_clockin();
                 }
                 else{
                     Search_date(date);
                 }    
             }
             else {
                 JOptionPane.showMessageDialog(null,"[���] ����J��ơA�п�ܫ�A�d�ߡI","�ާ@ĵ�T",JOptionPane.ERROR_MESSAGE);
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
             JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
         } 

         return( myResult );
     }

     public void Search_date(String myDate){
        Connection connection;
        PreparedStatement statement;
        ResultSet result;
        String cmdData;

        rowData4=new Vector();

        //��Ʈw�e�m�@�~
        try{
            Class.forName("com.mysql.jdbc.Driver");
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,"MySQL�X�ʵ{���w�˥���!"); 
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
            JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!0000");
        }        
     }
     
     //�Y�����
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


     //�ƥ��ť�{��: �B�z�I��[������]���s
     public ActionListener SelectDate = new ActionListener(){
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == punch_query_Btn){
                DatePopup dp1 = new DatePopup(punch_date_TxFd);
                dp1.showDialog();
            }
        }
     };

     //��������
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

 
