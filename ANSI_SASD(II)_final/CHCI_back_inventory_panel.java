
 //�פJ�ݭn���U���M��
 import javax.swing.*;
 import java.awt.event.*;
 import java.awt.*;
 import javax.swing.border.*;
 import javax.swing.table.*;
 import java.util.*;
 import javax.swing.table.AbstractTableModel;
 import javax.swing.table.DefaultTableModel;
 import java.sql.*;


 //�H�����ʼh���O
 //CHCI_back_inventory_panel: Class HumanComputerInteraction_back_inventory_panel (�H������-[��x�w�s]�ާ@�e�����O)

 class CHCI_back_inventory_panel extends JPanel{
     
     int w = 1280;
     int h = 800;

     JTabbedPane tbp = new JTabbedPane();
     JPanel p = new JPanel();

     JLabel TitleLabel = new JLabel("���~���O");
     JLabel ProductLabel = new JLabel("�~��");

     JButton queryBtn = new JButton("�~���d��");
     JButton Total_querylBtn = new JButton("�����~��");
     Color c1 = new Color(255,222,173);
     Color c2 = new Color(237, 237, 237);
     Color c3 = new Color(152,251,152);  //�s��
     Color c4 = new Color(175,238,238);
     Color c5 = new Color(255,160,122);
     Color c6 = new Color(255,222,173);
     Font font = new Font("�L�n������",Font.PLAIN,25);
     Font font2 = new Font("�L�n������",Font.PLAIN,40);
     Font font3 = new Font("�L�n������",Font.PLAIN,30);

     String[] curstr = new String[3]; //JComboBox���W���x�s�A�d�ߤU�@��JComboBox
     Boolean flag = true;
     String search;

     int index = 0;

     JComboBox[] cbox = new JComboBox[2];
     String[] CB = {"pclass","pname","product"};

     Vector rowData,columnNames;
     JTable table = null;
     JTableHeader head = null;
     DefaultTableModel DFMO;

     //�غc�l:���OCHCI_back_inventory_panel
     public CHCI_back_inventory_panel(){

         for(int i = 0; i < cbox.length; i++)//combobox
	     {
             cbox[i] = new JComboBox(createCB(CB,i));
             cbox[i].addActionListener(combobox);
             curstr[i] = cbox[i].getSelectedItem().toString();
             cbox[i].setFont(font2);
             cbox[i].setBackground(Color.white);
             p.add(cbox[i]);
	     }

         TitleLabel.setBounds(15, 2, 150, 100);
         TitleLabel.setFont(font3);
         p.add(TitleLabel);

         cbox[0].setBounds(150, 27, 180, 50);
         cbox[0].setFont(font);
         p.add(cbox[0]);

        
         //�~��
         ProductLabel.setBounds(350, 2, 100, 100);
         ProductLabel.setFont(font3);
         p.add(ProductLabel);

         cbox[1].setBounds(425, 27, 220, 50);
         cbox[1].setFont(font);
         p.add(cbox[1]);

        
         //�~���d�߫��s
         queryBtn.setBounds(690, 27, 165, 50);
         queryBtn.setBackground(c3);
         queryBtn.setFont(font3);
         queryBtn.addActionListener(ProcessSubmitProductQuery);
         queryBtn.setBorder(BorderFactory.createRaisedBevelBorder());
         p.add(queryBtn);

         //�����~�����s
         Total_querylBtn.setBounds(890, 27, 165, 50);
         Total_querylBtn.setBackground(c4);
         Total_querylBtn.setFont(font3);
         Total_querylBtn.addActionListener(ProcessSubmitProductQuery);
         Total_querylBtn.setBorder(BorderFactory.createRaisedBevelBorder());
         p.add(Total_querylBtn);

         columnNames=new Vector();   
         columnNames.add("�s��");  
         columnNames.add("���~���O");  
         columnNames.add("�~��");  
         columnNames.add("���");  
         columnNames.add("�s�q"); 

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
         JScrollPane sp = new JScrollPane(table,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                                       ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
       
         sp.setBounds(20,100,1065,545);
         p.add(sp);

         p.setBackground(c1);
         p.setLayout(null);
         tbp.add("�w�s",p);

         tbp.setFont(font);
         tbp.setBounds(0,0,w-163,h-55);
         add(tbp);

         setBackground(c6);
         setLocation(160,55);
         setSize(w-163,h-55);
         setLayout(null);
         setVisible(true);

         ShowRD_in_TB_Product();

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
             JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!123");
             System.out.println(e.getMessage());

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
         catch (SQLException e)
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
         rowData = new Vector();    
        
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
                 DFMO.addRow(newRow);
                 DFMO.fireTableDataChanged();
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
                 DFMO.getDataVector().removeAllElements();
                 String product=new String();
                 product=(String)cbox[1].getSelectedItem();
                 Search_Product(product);
             }
             if(e.getSource() == Total_querylBtn)//�����~��
             {
                 DFMO.getDataVector().removeAllElements();
                 ShowRD_in_TB_Product();	
             }
         }
     };

     public void Search_Product(String pname)//�d�߸����ܦb���
     {
         Connection connection;
         PreparedStatement statement;
         ResultSet result;
         String cmdData;
         rowData = new Vector();    
        
         try
         {
             cmdData = "SELECT * FROM  product WHERE pname=?";
             connection = DriverManager.getConnection("jdbc:mysql://localhost/cafedb"+"?user=root&password=mysql");
             statement = connection.prepareStatement(cmdData);
             statement.setString(1,pname);
             result = statement.executeQuery();
             while(result.next())
             {
             Vector<String> newRow = new Vector<>();
             newRow.addElement(String.valueOf(result.getInt("Pid")));
             newRow.addElement(result.getString("Pclass"));
             newRow.addElement(result.getString("Pname"));
             newRow.addElement(String.valueOf(result.getInt("Pprice")));
             newRow.addElement(String.valueOf(result.getInt("Pinventory")));
             DFMO.addRow(newRow);
             DFMO.fireTableDataChanged();
             }
             statement.close();
         }
         catch(SQLException e)
         {
             e.printStackTrace();
             JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
         }
     }
 } //end for: class CHCI_back_inventory_panel

 
