
 //�פJ�ݭn���U���M��
 import javax.swing.*;
 import java.awt.event.*;
 import java.awt.*;
 import javax.swing.border.*;
 import java.sql.*;
 import javax.swing.table.*;
 import java.text.DateFormat;//�۩w�q����ɶ��榡
 import java.text.SimpleDateFormat;//�۩w�q����ɶ��榡
 import java.util.Date;//�۩w�q����ɶ��榡



 
 //�H�����ʼh���O
 //CHCI_frame: Class HumanComputerInteraction_frame (�H������-�e�x�ج[���O)

 class CHCI_front_frame extends JFrame{      //�t�Ϋe�x������

     int w = 1280;
	 int h = 800;
	 
	 CDM_dbma myDBMA = new CDM_dbma();
    
     Font ft = new Font("�L�n������",Font.BOLD,21);
     Font font = new Font("�ө���",Font.BOLD,20);
     int index = 0;
     int a = 0;
     
     JPanel p0 = new JPanel();		//�ϥΪ�
     JPanel p1 = new JPanel();		//����
     JPanel p2 = new JPanel();		//�k�W
     JPanel p3 = new JPanel();		//���U
     JPanel p4 = new JPanel();		////�k�U
     JPanel [] p = new JPanel[3];	//JPanel�}�C(����Ӯe��: p[0],p[1],p[2] ,�@��,���I,�馩)
     JPanel [] s = new JPanel[1];	//�p�������	
     JButton[][] btn1 = new JButton[5][4];	//�@��
     JButton[][] btn2 = new JButton[5][4];	//���I/�ѥ]����
     JButton[][] btn4 = new JButton[5][4];	//�馩
     JButton[][] btn3 = new JButton[6][3];	//�p�������
     JTabbedPane tbp = new JTabbedPane();	//���Үe��
     String[] title = {"�~��","���","�ƶq","�p�p"};
     String[][] data = new String[100][4];
     JTable table = new JTable(data , title);
     JTableHeader head = table.getTableHeader();	//���otable�����Y
     JScrollPane sp = new JScrollPane(table,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                                         ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
     JLabel b0 = new JLabel("�ϥΪ̡G");
     JLabel b1 = new JLabel("�`�p:");
     JLabel b2 = new JLabel("��:");
     JLabel b3 = new JLabel("��s: ");
     JLabel b4 = new JLabel("�P�f�s��");
     JLabel b5 = new JLabel("�q��");
     JLabel b6 = new JLabel("�Ȥ�W��");
     JLabel b7 = new JLabel("�νs");
     JLabel b8 = new JLabel("�o��");
     JLabel b9 = new JLabel("�I��");
     JLabel b10 = new JLabel(" ");	//��ܨϥΪ�
     static JLabel b11 = new JLabel(" ");	//��ܦ~���
	 static JLabel b12 = new JLabel(" ");	//��ܲ{�b�ɶ�
	 JLabel b13 = new JLabel(" ");
	 ImageIcon logo = new ImageIcon("images\\logo_pic.png");
	 JLabel pic = new JLabel(logo);
     JTextField tf1 =new JTextField(" ");
     JTextField tf2 = new JTextField(" ");
     JTextField tf3 = new JTextField(" ");
     JTextField tf4 = new JTextField(" ");
     JTextField tf5 = new JTextField(" ");
     JTextField tf6 = new JTextField(" ");
     JTextField tf7 = new JTextField(" ");
     JTextField tf8 = new JTextField(" ");
	 JTextField tf9 = new JTextField(" ");
     Color c1 =  new Color(204, 179, 140);
     Color c2 = new Color(255,222,173);
     Color c3 = new Color(152,245,255);
     Color c4 = new Color(187,255,255);
     Color c5 = new Color(255, 235, 205);
     Color c6 = new Color(250, 240, 230);
     Color c7 = new Color(255, 99, 71);
     Color c8 = new Color(250, 128, 114);
 
     String[][] btnStr1 = {	{"�����@��(�B)","�����@��(��)","���K(�B)","���K(��)"},
                             {"�@�Y�@��(�B)","�d���_��(�B)","���d(�B)","���d(��)"},
                              {"�J�}���_��(�B)","�J�}���_��(��)","����紭�S��","����ߵ��S��"},
                              {"  ","  ","  ","  "},
                             {"  ","  ","  ","  "}};
 
     String[][] btnStr2 = {	{"�¨ŹT(���)","�´˪L(���)","���Ԧ�Ĭ(���)","  "},
                             {"  ","  ","  ","  "},
                             {"  ","  ","  ","  "},
                             {"  ","  ","  ","  "},
                             {"  ","  ","  ","  "}};
     
     String[][] btnStr4 = {	{"�馩10��","�馩50��","�馩100��","�馩150��"},
                             {"�馩200��","�馩250��","�馩300��","�馩350��"},
                             {"�馩400��","�馩450��","�馩500��","�馩1000��"},
                             {"  ","  ","  ","  "},
                             {"���جP�u�f��","","  ","  "}};						
     
     String[][] btnStr3 = {	{"7","8","9"},
                             {"4","5","6"},
                             {"1","2","3"},
                             {"�M��","0","�s�W"},
                             {"��","","���b"},
                             {"��x","��Z","�T�{"}};
    
     //�غc�l:���OCHCI_login_frame
     public CHCI_front_frame(){

		p[0] = new JPanel();	//�]�w�e��p[0] �@��
		p[1] = new JPanel();	//�]�w�e��p[1] ���I
		p[2] = new JPanel();	//�]�w�e��p[2] �馩
		s[0] = new JPanel();	//�]�w�p����e��

		Color LightSkyBlue = new Color(135,206,250); 
		Color CCback = new Color (244,164,96);
		Color checkout = new Color(152,224,173);

		p0.setBounds(0,0,(int)(0.5*w),39);
		p0.setBackground(c2);
		p0.setLayout(null);
		add(p0);
		//�]�w�e��
		//����

		p1.setBounds(0,40,(int)(0.5*w),(int)(h));
		p1.setBackground(c1);
		p1.setLayout(null);
		add(p1);
		//�k�W
		
		p2.setBounds((int)(0.5*w),0,(int)(0.5*w),(int)(0.47*h));
		p2.setBackground(c2);
		p2.setLayout(null);
		add(p2);
		//���U
		
		p3.setBounds(0,(int)(0.6*h),(int)(0.5*w),(int)(0.4*h));
		p3.setBackground(c2);
		p3.setLayout(null);
		add(p3);
		//�k�U
		
		p4.setBounds((int)(0.5*w),(int)(0.47*h),(int)(0.5*w),(int)(0.53*h));
		p4.setBackground(c2);
		p4.setLayout(null);
		add(p4);

		//�@��
		p[0].setLayout(new GridLayout(5,4,2,3));
		for(int i=0; i<btn1.length; i++){
			for(int j =0; j<btn1[0].length; j++){
				btn1[i][j] = new JButton(btnStr1[i][j]);
				btn1[i][j].setFont(ft);
				btn1[i][j].setBackground(c5);
				btn1[i][j].setBorder(BorderFactory.createRaisedBevelBorder());
				btn1[i][j].addActionListener(ClickBtn);
				p[0].add(btn1[i][j]);
			}
		}
		//�]�w�@�ؼ�����r�C��
		btn1[0][1].setForeground(Color.red);
		btn1[0][3].setForeground(Color.red);
		btn1[1][3].setForeground(Color.red);
		btn1[2][1].setForeground(Color.red);

		//���I
		p[1].setLayout(new GridLayout(5,4,2,3));
		for(int i=0; i<btn2.length; i++){
			for(int j =0; j<btn2[0].length; j++){
				btn2[i][j] = new JButton(btnStr2[i][j]);
				btn2[i][j].setFont(ft);
				btn2[i][j].setBackground(c5);
				btn2[i][j].setBorder(BorderFactory.createRaisedBevelBorder());
				btn2[i][j].addActionListener(ClickBtn);
				p[1].add(btn2[i][j]);
			}
		}
		//�����
		p[2].setLayout(new GridLayout(5,4,2,3));
		for(int i=0; i<btn4.length; i++){
			for(int j =0; j<btn2[0].length; j++){
				btn4[i][j] = new JButton(btnStr4[i][j]);
				btn4[i][j].setFont(ft);
				btn4[i][j].setBackground(c5);
				btn4[i][j].setBorder(BorderFactory.createRaisedBevelBorder());
				btn4[i][j].addActionListener(ClickBtn);
				p[2].add(btn4[i][j]);
			}
		}
		//�]�w�����p[2]�I���C��
		for(int i=0;i<3;i++){
			for(int j=0;j<4;j++)
			{
				btn4[i][j].setBackground(Color.yellow);
			}
		}
		btn4[4][0].setBackground(Color.pink);
		
		
		//�]�w�p������s
		s[0].setBackground(c2);
		s[0].setLayout(new GridLayout(6,3,2,3));
		s[0].setBounds(0,5,619,376);
		p4.add(s[0]);

		for(int i=0; i<btn3.length; i++) {
			for(int j=0; j<btn3[0].length;j++) {
				btn3[i][j] = new JButton(btnStr3[i][j]);	//�s�ͫ��s
				btn3[i][j].setFont(ft);
				btn3[i][j].setBackground(c6);
				btn3[i][j].setBorder(BorderFactory.createRaisedBevelBorder());	//�]�w�Y�_���
				btn3[i][j].addActionListener(ClickBtn);
				s[0].add(btn3[i][j]);	//�N���s�[�Jp[0]�e���A�|�۰ʤ@��榡�G���\�m
			}
		}
		//�p�������I����
		btn3[5][1].setBackground(Color.orange);
		btn3[3][2].setBackground(LightSkyBlue);
		btn3[3][0].setBackground(Color.pink);
		btn3[5][0].setBackground(CCback);
		btn3[5][2].setBackground(checkout);
		btn3[4][2].setBackground(Color.pink);
		btn3[4][0].setBackground(c7);
		btn3[4][1].setBackground(c8);

		//���ͭ���
		tbp.add("�@��",p[0]);
		tbp.add("���I/�ѥ]",p[1]);
		tbp.add("�馩",p[2]);
		tbp.setFont(ft);
		tbp.setBounds(0,0,620,376);
		p2.add(tbp);

		table.setFont(font);
		table.setRowHeight(40);
		table.setEnabled(false);//�]�w���u�����
		head.setFont(font);
		sp.setBounds(1,1,639,479);
		p1.add(sp);

		//�ϥΪ�
		b0.setBounds(25,5,100,25);
		b0.setFont(ft);
		p0.add(b0);

		//�`�p 
		b1.setBounds(10,650,200,50);
		b1.setFont(ft);
		p1.add(b1);

		//��
		b2.setBounds(230,650,200,50);
		b2.setFont(ft);
		p1.add(b2);

		//��s
		b3.setBounds(420,650,200,50);
		b3.setFont(ft);
		p1.add(b3);

		//��ܨϥΪ�
		b10.setBounds(110,5,150,25);
		b10.setFont(ft);
		p0.add(b10);

		//��ܤ��
		b11.setBounds(336,5,200,25);
		b11.setFont(ft);
		p0.add(b11);

		//��ܲ{�b�ɶ�
		b12.setBounds(502,5,200,25);
		b12.setFont(ft);
		p0.add(b12);
		
		//�`�p
		tf1.setBounds(70,660,150,30);
		tf1.setFont(ft);
		tf1.setEditable(false);
		p1.add(tf1);

		//��
		tf2.setBounds(260,660,150,30);
		tf2.setFont(ft);
		p1.add(tf2);

		//��s
		tf3.setBounds(480,660,150,30);
		tf3.setFont(ft);
		p1.add(tf3);

		pic.setBounds(175,480,275,175);
		//pic.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));  //�нu
		p1.add(pic);

        setLayout(null);
        setBounds(0,0,w,h);
        setTitle("���ߩ@���] Chindish Cafe �P��t��");
        setVisible(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
								 
		addWindowListener(new WindowAdapter() { 
		    public void windowClosing(WindowEvent we) { 
			    int result = JOptionPane.showConfirmDialog(null,"�O�_�����t�ΡH","�߰�",
						     JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		        if (result == JOptionPane.YES_OPTION){
				     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}
				if (result == JOptionPane.NO_OPTION){
					 setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}    
									 
			} 
		}); 
	 }
	 
	 public void proudct_btn(String myPname){
		 table.setValueAt(null,index,2);
		 table.setValueAt(null,index,3);
         String Pname = myPname;
		 String Price = myDBMA.findRD_Product_Price(Pname);
		 int Pinventory = myDBMA.findRD_Product_inventory(Pname);
		 if( Pinventory > 0){
			 table.setValueAt(Pname,index,0);
			 table.setValueAt(Price,index,1);
		 }
		 else{
			 JOptionPane.showMessageDialog(null, "[ " + Pname + " ]" + "�@�w�s�q����");
		 }
	 }

     public ActionListener ClickBtn = new ActionListener(){
		public void actionPerformed(ActionEvent e){ 
			int price,amount,total,sum = 0;
			String totalStr, sumStr;
			//Btn1 �@��
			if(e.getSource() == btn1[0][0]){   //�����@��(�B)
				String Pname = btn1[0][0].getText();
				proudct_btn(Pname);
			}
			if(e.getSource() == btn1[0][1]){   //�����@��(��)
				String Pname = btn1[0][1].getText();
				proudct_btn(Pname);
			}
			if(e.getSource() == btn1[0][2]){   //���K(�B)
				String Pname = btn1[0][2].getText();
				proudct_btn(Pname);
			}
			if(e.getSource() == btn1[0][3]){   //���K(��)
				String Pname = btn1[0][3].getText();
				proudct_btn(Pname);
			}
			if(e.getSource() == btn1[1][0]){   //�@�Y�@��
				String Pname = btn1[1][0].getText();
				proudct_btn(Pname);
			}
			if(e.getSource() == btn1[1][1]){   //�d���_��
				String Pname = btn1[1][1].getText();
				proudct_btn(Pname);
			}
			if(e.getSource() == btn1[1][2]){   //���d(�B)
				String Pname = btn1[1][2].getText();
				proudct_btn(Pname);
			}
			if(e.getSource() == btn1[1][3]){   //���d(��)
				String Pname = btn1[1][3].getText();
				proudct_btn(Pname);
			}
			if(e.getSource() == btn1[2][0]){   //�J�}���_��(�B)
				String Pname = btn1[2][0].getText();
				proudct_btn(Pname);
			}
			if(e.getSource() == btn1[2][1]){   //�J�}���_��(�B)
				String Pname = btn1[2][1].getText();
				proudct_btn(Pname);
			}
			if(e.getSource() == btn1[2][2]){   //����紭�S��
				String Pname = btn1[2][2].getText();
				proudct_btn(Pname);
			}
			if(e.getSource() == btn1[2][3]){   //����ߵ��S��
				String Pname = btn1[2][3].getText();
				proudct_btn(Pname);
			}
			//Btn2 ���I/�ѥ]
			if(e.getSource() == btn2[0][0]){   //�¨ŹT(��)
				String Pname = btn2[0][0].getText();
				proudct_btn(Pname);
			}
			if(e.getSource() == btn2[0][1]){   //�´˪L(��)
				String Pname = btn2[0][1].getText();
				proudct_btn(Pname);
			}
			if(e.getSource() == btn2[0][2]){   //���Ԧ�Ĭ(��)
				String Pname = btn2[0][2].getText();
				proudct_btn(Pname);
			}
			//Btn4 �馩/�����
			if(e.getSource() == btn4[0][0]){   //���10��
				String Pname = btn4[0][0].getText();
				proudct_btn(Pname);
			}
			if(e.getSource() == btn4[0][1]){   //���50��
				String Pname = btn4[0][1].getText();
				proudct_btn(Pname);
			}
			if(e.getSource() == btn4[0][2]){   //���100��
				String Pname = btn4[0][2].getText();
				proudct_btn(Pname);
			}
			if(e.getSource() == btn4[0][3]){   //���150��
				String Pname = btn4[0][3].getText();
				proudct_btn(Pname);
			}
			if(e.getSource() == btn4[1][0]){   //���200��
				String Pname = btn4[1][0].getText();
				proudct_btn(Pname);
			}
			if(e.getSource() == btn4[1][1]){   //���250��
				String Pname = btn4[1][1].getText();
				proudct_btn(Pname);
			}
			if(e.getSource() == btn4[1][2]){   //���300��
				String Pname = btn4[1][2].getText();
				proudct_btn(Pname);
			}
			if(e.getSource() == btn4[1][3]){   //���350��
				String Pname = btn4[1][3].getText();
				proudct_btn(Pname);
			}
			if(e.getSource() == btn4[2][0]){   //���400��
				String Pname = btn4[2][0].getText();
				proudct_btn(Pname);
			}
			if(e.getSource() == btn4[2][1]){   //���450��
				String Pname = btn4[2][1].getText();
				proudct_btn(Pname);
			}
			if(e.getSource() == btn4[2][2]){   //���500��
				String Pname = btn4[2][2].getText();
				proudct_btn(Pname);
			}
			if(e.getSource() == btn4[2][3]){   //���1000��
				String Pname = btn4[2][3].getText();
				proudct_btn(Pname);
			}
			if(e.getSource() == btn4[4][0]){   //�جP�u�f���50��
				String Pname = btn4[4][0].getText();
				proudct_btn(Pname);
			}

			//Btn3�Ʀr��L��
			if(e.getSource() == btn3[2][0]){ //�Ʀr1
				a = (a*10)+1;
                table.setValueAt(""+a,index,2);
                price = Integer.parseInt((String)table.getValueAt(index,1));
                amount =Integer.parseInt((String)table.getValueAt(index,2));
                total = price*amount;
                totalStr = String.valueOf(total);
                table.setValueAt(totalStr,index,3);
			}
			if(e.getSource() == btn3[2][1]){ //�Ʀr2
				a = (a*10)+2;
                table.setValueAt(""+a,index,2);
                price = Integer.parseInt((String)table.getValueAt(index,1));
                amount =Integer.parseInt((String)table.getValueAt(index,2));
                total = price*amount;
                totalStr = String.valueOf(total);
                table.setValueAt(totalStr,index,3);
			}
			if(e.getSource() == btn3[2][2]){ //�Ʀr3
				a = (a*10)+3;
                table.setValueAt(""+a,index,2);
                price = Integer.parseInt((String)table.getValueAt(index,1));
                amount =Integer.parseInt((String)table.getValueAt(index,2));
                total = price*amount;
                totalStr = String.valueOf(total);
                table.setValueAt(totalStr,index,3);
			}
			if(e.getSource() == btn3[1][0]){ //�Ʀr4
				a = (a*10)+4;
                table.setValueAt(""+a,index,2);
                price = Integer.parseInt((String)table.getValueAt(index,1));
                amount =Integer.parseInt((String)table.getValueAt(index,2));
                total = price*amount;
                totalStr = String.valueOf(total);
                table.setValueAt(totalStr,index,3);
			}
			if(e.getSource() == btn3[1][1]){ //�Ʀr5
				a = (a*10)+5;
                table.setValueAt(""+a,index,2);
                price = Integer.parseInt((String)table.getValueAt(index,1));
                amount =Integer.parseInt((String)table.getValueAt(index,2));
                total = price*amount;
                totalStr = String.valueOf(total);
                table.setValueAt(totalStr,index,3);
			}
			if(e.getSource() == btn3[1][2]){ //�Ʀr6
				a = (a*10)+6;
                table.setValueAt(""+a,index,2);
                price = Integer.parseInt((String)table.getValueAt(index,1));
                amount =Integer.parseInt((String)table.getValueAt(index,2));
                total = price*amount;
                totalStr = String.valueOf(total);
                table.setValueAt(totalStr,index,3);
			}
			if(e.getSource() == btn3[0][0]){ //�Ʀr7
				a = (a*10)+7;
                table.setValueAt(""+a,index,2);
                price = Integer.parseInt((String)table.getValueAt(index,1));
                amount =Integer.parseInt((String)table.getValueAt(index,2));
                total = price*amount;
                totalStr = String.valueOf(total);
                table.setValueAt(totalStr,index,3);
			}
			if(e.getSource() == btn3[0][1]){ //�Ʀr8
				a = (a*10)+8;
                table.setValueAt(""+a,index,2);
                price = Integer.parseInt((String)table.getValueAt(index,1));
                amount =Integer.parseInt((String)table.getValueAt(index,2));
                total = price*amount;
                totalStr = String.valueOf(total);
                table.setValueAt(totalStr,index,3);
			}
			if(e.getSource() == btn3[0][2]){ //�Ʀr9
				a = (a*10) + 9;
                table.setValueAt(""+a,index,2);
                price = Integer.parseInt((String)table.getValueAt(index,1));
                amount =Integer.parseInt((String)table.getValueAt(index,2));
                total = price*amount;
                totalStr = String.valueOf(total);
                table.setValueAt(totalStr,index,3);
			}
			if(e.getSource() == btn3[3][1]){ //�Ʀr0
				a = (a*10)+0;
                table.setValueAt(""+a,index,2);
                price = Integer.parseInt((String)table.getValueAt(index,1));
                amount =Integer.parseInt((String)table.getValueAt(index,2));
                total = price*amount;
                totalStr = String.valueOf(total);
                table.setValueAt(totalStr,index,3);
			}
			if(e.getSource() == btn3[3][0]){ //�M��
				a = 0;
                for(int i=0;i<=index;i++){
                    for(int j=0;j<4;j++){
                        table.setValueAt(null,i,j);
                    }
                }
				index = 0;
				tf1.setText(null); //�M���`���B
				tf2.setText(null);
				tf3.setText(null);
			}
			
			if(e.getSource() == btn3[4][0]){//��
				a = 0;
				table.setValueAt(null,index,3);
				table.setValueAt(null,index,2);
				table.setValueAt(null,index,1);
				table.setValueAt(null,index,0);
				
			}
			
			if(e.getSource() == btn3[3][2]){ //�s�W
				a = 0;

				if(table.getValueAt(index,0)== null & table.getValueAt(index,1) == null &
					table.getValueAt(index,2)== null & table.getValueAt(index,3) == null )
					{
						index--;
					}

				String Pname = (String)table.getValueAt(index,0);
				int Pinventory = myDBMA.findRD_Product_inventory(Pname);
				int num = Integer.parseInt((String)table.getValueAt(index,2));
                if( Pinventory >= num){

					if(table.getValueAt(index,0)!= null & table.getValueAt(index,1) != null &
					table.getValueAt(index,2)!= null & table.getValueAt(index,3) != null )
					{
						index++;
					}
				}
				else{
					 JOptionPane.showMessageDialog(null, "[ " + Pname + " ]" + "�@�w�s�q���������P��A�w�s�q�Ѿl" + Pinventory + "���");
					 table.setValueAt(null,index,2);
				     table.setValueAt(null,index,3);
				}


			}
			if(e.getSource() == btn3[4][2]){ //���b
				a=0;

				if(table.getValueAt(index,0)== null & table.getValueAt(index,1) == null &
					table.getValueAt(index,2)== null & table.getValueAt(index,3) == null )
					{
						index--;
					}

                String Pname = (String)table.getValueAt(index,0);
				int Pinventory = myDBMA.findRD_Product_inventory(Pname);
				int num = Integer.parseInt((String)table.getValueAt(index,2));

				if( Pinventory >= num){

					for(int i = 0; i<=index;i++){ //����`���B
						sum = sum + Integer.parseInt((String)table.getValueAt(i,3));
						if(sum<0){
							sum=0;
						}	
						sumStr = String.valueOf(sum);
						tf1.setText(sumStr);
					}	
				}
				else{
					JOptionPane.showMessageDialog(null, "[ " + Pname + " ]" + "�@�w�s�q���������P��A�w�s�q�Ѿl" + Pinventory + "���");
					table.setValueAt(null,index,2);
					table.setValueAt(null,index,3);
			   }
            }
		}
	};
 } //end for: class CHCI_front_frame

 
 