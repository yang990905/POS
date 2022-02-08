
 //匯入需要的各類套件
 import javax.swing.*;
 import java.awt.event.*;
 import java.awt.*;
 import javax.swing.border.*;
 import java.sql.*;
 import javax.swing.table.*;
 import java.text.DateFormat;//自定義日期時間格式
 import java.text.SimpleDateFormat;//自定義日期時間格式
 import java.util.Date;//自定義日期時間格式



 
 //人機互動層類別
 //CHCI_frame: Class HumanComputerInteraction_frame (人機介面-前台框架類別)

 class CHCI_front_frame extends JFrame{      //系統前台的視窗

     int w = 1280;
	 int h = 800;
	 
	 CDM_dbma myDBMA = new CDM_dbma();
    
     Font ft = new Font("微軟正黑體",Font.BOLD,21);
     Font font = new Font("細明體",Font.BOLD,20);
     int index = 0;
     int a = 0;
     
     JPanel p0 = new JPanel();		//使用者
     JPanel p1 = new JPanel();		//左邊
     JPanel p2 = new JPanel();		//右上
     JPanel p3 = new JPanel();		//左下
     JPanel p4 = new JPanel();		////右下
     JPanel [] p = new JPanel[3];	//JPanel陣列(有兩個容器: p[0],p[1],p[2] ,咖啡,甜點,折扣)
     JPanel [] s = new JPanel[1];	//計算機按鍵	
     JButton[][] btn1 = new JButton[5][4];	//咖啡
     JButton[][] btn2 = new JButton[5][4];	//甜點/麵包頁籤
     JButton[][] btn4 = new JButton[5][4];	//折扣
     JButton[][] btn3 = new JButton[6][3];	//計算機按鍵
     JTabbedPane tbp = new JTabbedPane();	//頁籤容器
     String[] title = {"品項","單價","數量","小計"};
     String[][] data = new String[100][4];
     JTable table = new JTable(data , title);
     JTableHeader head = table.getTableHeader();	//取得table的表頭
     JScrollPane sp = new JScrollPane(table,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                                         ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
     JLabel b0 = new JLabel("使用者：");
     JLabel b1 = new JLabel("總計:");
     JLabel b2 = new JLabel("收:");
     JLabel b3 = new JLabel("找零: ");
     JLabel b4 = new JLabel("銷貨編號");
     JLabel b5 = new JLabel("電話");
     JLabel b6 = new JLabel("客戶名稱");
     JLabel b7 = new JLabel("統編");
     JLabel b8 = new JLabel("發票");
     JLabel b9 = new JLabel("點數");
     JLabel b10 = new JLabel(" ");	//顯示使用者
     static JLabel b11 = new JLabel(" ");	//顯示年月日
	 static JLabel b12 = new JLabel(" ");	//顯示現在時間
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
 
     String[][] btnStr1 = {	{"美式咖啡(冰)","美式咖啡(熱)","拿鐵(冰)","拿鐵(熱)"},
                             {"濃縮咖啡(冰)","卡布奇諾(冰)","摩卡(冰)","摩卡(熱)"},
                              {"焦糖瑪奇朵(冰)","焦糖瑪奇朵(熱)","醜醜瑞揚特調","醜醜立翔特調"},
                              {"  ","  ","  ","  "},
                             {"  ","  ","  ","  "}};
 
     String[][] btnStr2 = {	{"純乳酪(單片)","黑森林(單片)","提拉米蘇(單片)","  "},
                             {"  ","  ","  ","  "},
                             {"  ","  ","  ","  "},
                             {"  ","  ","  ","  "},
                             {"  ","  ","  ","  "}};
     
     String[][] btnStr4 = {	{"折扣10元","折扣50元","折扣100元","折扣150元"},
                             {"折扣200元","折扣250元","折扣300元","折扣350元"},
                             {"折扣400元","折扣450元","折扣500元","折扣1000元"},
                             {"  ","  ","  ","  "},
                             {"★壽星優惠★","","  ","  "}};						
     
     String[][] btnStr3 = {	{"7","8","9"},
                             {"4","5","6"},
                             {"1","2","3"},
                             {"清除","0","新增"},
                             {"更正","","結帳"},
                             {"後台","交班","確認"}};
    
     //建構子:類別CHCI_login_frame
     public CHCI_front_frame(){

		p[0] = new JPanel();	//設定容器p[0] 咖啡
		p[1] = new JPanel();	//設定容器p[1] 甜點
		p[2] = new JPanel();	//設定容器p[2] 折扣
		s[0] = new JPanel();	//設定計算機容器

		Color LightSkyBlue = new Color(135,206,250); 
		Color CCback = new Color (244,164,96);
		Color checkout = new Color(152,224,173);

		p0.setBounds(0,0,(int)(0.5*w),39);
		p0.setBackground(c2);
		p0.setLayout(null);
		add(p0);
		//設定容器
		//左邊

		p1.setBounds(0,40,(int)(0.5*w),(int)(h));
		p1.setBackground(c1);
		p1.setLayout(null);
		add(p1);
		//右上
		
		p2.setBounds((int)(0.5*w),0,(int)(0.5*w),(int)(0.47*h));
		p2.setBackground(c2);
		p2.setLayout(null);
		add(p2);
		//左下
		
		p3.setBounds(0,(int)(0.6*h),(int)(0.5*w),(int)(0.4*h));
		p3.setBackground(c2);
		p3.setLayout(null);
		add(p3);
		//右下
		
		p4.setBounds((int)(0.5*w),(int)(0.47*h),(int)(0.5*w),(int)(0.53*h));
		p4.setBackground(c2);
		p4.setLayout(null);
		add(p4);

		//咖啡
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
		//設定咖啡熱飲文字顏色
		btn1[0][1].setForeground(Color.red);
		btn1[0][3].setForeground(Color.red);
		btn1[1][3].setForeground(Color.red);
		btn1[2][1].setForeground(Color.red);

		//甜點
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
		//折價券
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
		//設定折價券p[2]背景顏色
		for(int i=0;i<3;i++){
			for(int j=0;j<4;j++)
			{
				btn4[i][j].setBackground(Color.yellow);
			}
		}
		btn4[4][0].setBackground(Color.pink);
		
		
		//設定計算機按鈕
		s[0].setBackground(c2);
		s[0].setLayout(new GridLayout(6,3,2,3));
		s[0].setBounds(0,5,619,376);
		p4.add(s[0]);

		for(int i=0; i<btn3.length; i++) {
			for(int j=0; j<btn3[0].length;j++) {
				btn3[i][j] = new JButton(btnStr3[i][j]);	//新生按鈕
				btn3[i][j].setFont(ft);
				btn3[i][j].setBackground(c6);
				btn3[i][j].setBorder(BorderFactory.createRaisedBevelBorder());	//設定凸起邊框
				btn3[i][j].addActionListener(ClickBtn);
				s[0].add(btn3[i][j]);	//將按鈕加入p[0]容器，會自動一表格式佈局擺置
			}
		}
		//計算機按鍵背景色
		btn3[5][1].setBackground(Color.orange);
		btn3[3][2].setBackground(LightSkyBlue);
		btn3[3][0].setBackground(Color.pink);
		btn3[5][0].setBackground(CCback);
		btn3[5][2].setBackground(checkout);
		btn3[4][2].setBackground(Color.pink);
		btn3[4][0].setBackground(c7);
		btn3[4][1].setBackground(c8);

		//產生頁籤
		tbp.add("咖啡",p[0]);
		tbp.add("甜點/麵包",p[1]);
		tbp.add("折扣",p[2]);
		tbp.setFont(ft);
		tbp.setBounds(0,0,620,376);
		p2.add(tbp);

		table.setFont(font);
		table.setRowHeight(40);
		table.setEnabled(false);//設定表格只能顯示
		head.setFont(font);
		sp.setBounds(1,1,639,479);
		p1.add(sp);

		//使用者
		b0.setBounds(25,5,100,25);
		b0.setFont(ft);
		p0.add(b0);

		//總計 
		b1.setBounds(10,650,200,50);
		b1.setFont(ft);
		p1.add(b1);

		//收
		b2.setBounds(230,650,200,50);
		b2.setFont(ft);
		p1.add(b2);

		//找零
		b3.setBounds(420,650,200,50);
		b3.setFont(ft);
		p1.add(b3);

		//顯示使用者
		b10.setBounds(110,5,150,25);
		b10.setFont(ft);
		p0.add(b10);

		//顯示日期
		b11.setBounds(336,5,200,25);
		b11.setFont(ft);
		p0.add(b11);

		//顯示現在時間
		b12.setBounds(502,5,200,25);
		b12.setFont(ft);
		p0.add(b12);
		
		//總計
		tf1.setBounds(70,660,150,30);
		tf1.setFont(ft);
		tf1.setEditable(false);
		p1.add(tf1);

		//收
		tf2.setBounds(260,660,150,30);
		tf2.setFont(ft);
		p1.add(tf2);

		//找零
		tf3.setBounds(480,660,150,30);
		tf3.setFont(ft);
		p1.add(tf3);

		pic.setBounds(175,480,275,175);
		//pic.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));  //標線
		p1.add(pic);

        setLayout(null);
        setBounds(0,0,w,h);
        setTitle("童心咖啡館 Chindish Cafe 銷售系統");
        setVisible(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
								 
		addWindowListener(new WindowAdapter() { 
		    public void windowClosing(WindowEvent we) { 
			    int result = JOptionPane.showConfirmDialog(null,"是否關閉系統？","詢問",
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
			 JOptionPane.showMessageDialog(null, "[ " + Pname + " ]" + "　庫存量不足");
		 }
	 }

     public ActionListener ClickBtn = new ActionListener(){
		public void actionPerformed(ActionEvent e){ 
			int price,amount,total,sum = 0;
			String totalStr, sumStr;
			//Btn1 咖啡
			if(e.getSource() == btn1[0][0]){   //美式咖啡(冰)
				String Pname = btn1[0][0].getText();
				proudct_btn(Pname);
			}
			if(e.getSource() == btn1[0][1]){   //美式咖啡(熱)
				String Pname = btn1[0][1].getText();
				proudct_btn(Pname);
			}
			if(e.getSource() == btn1[0][2]){   //拿鐵(冰)
				String Pname = btn1[0][2].getText();
				proudct_btn(Pname);
			}
			if(e.getSource() == btn1[0][3]){   //拿鐵(熱)
				String Pname = btn1[0][3].getText();
				proudct_btn(Pname);
			}
			if(e.getSource() == btn1[1][0]){   //濃縮咖啡
				String Pname = btn1[1][0].getText();
				proudct_btn(Pname);
			}
			if(e.getSource() == btn1[1][1]){   //卡布奇諾
				String Pname = btn1[1][1].getText();
				proudct_btn(Pname);
			}
			if(e.getSource() == btn1[1][2]){   //摩卡(冰)
				String Pname = btn1[1][2].getText();
				proudct_btn(Pname);
			}
			if(e.getSource() == btn1[1][3]){   //摩卡(熱)
				String Pname = btn1[1][3].getText();
				proudct_btn(Pname);
			}
			if(e.getSource() == btn1[2][0]){   //焦糖瑪奇朵(冰)
				String Pname = btn1[2][0].getText();
				proudct_btn(Pname);
			}
			if(e.getSource() == btn1[2][1]){   //焦糖瑪奇朵(冰)
				String Pname = btn1[2][1].getText();
				proudct_btn(Pname);
			}
			if(e.getSource() == btn1[2][2]){   //醜醜瑞揚特調
				String Pname = btn1[2][2].getText();
				proudct_btn(Pname);
			}
			if(e.getSource() == btn1[2][3]){   //醜醜立翔特調
				String Pname = btn1[2][3].getText();
				proudct_btn(Pname);
			}
			//Btn2 甜點/麵包
			if(e.getSource() == btn2[0][0]){   //純乳酪(單)
				String Pname = btn2[0][0].getText();
				proudct_btn(Pname);
			}
			if(e.getSource() == btn2[0][1]){   //黑森林(單)
				String Pname = btn2[0][1].getText();
				proudct_btn(Pname);
			}
			if(e.getSource() == btn2[0][2]){   //提拉米蘇(單)
				String Pname = btn2[0][2].getText();
				proudct_btn(Pname);
			}
			//Btn4 折扣/折價卷
			if(e.getSource() == btn4[0][0]){   //折價10元
				String Pname = btn4[0][0].getText();
				proudct_btn(Pname);
			}
			if(e.getSource() == btn4[0][1]){   //折價50元
				String Pname = btn4[0][1].getText();
				proudct_btn(Pname);
			}
			if(e.getSource() == btn4[0][2]){   //折價100元
				String Pname = btn4[0][2].getText();
				proudct_btn(Pname);
			}
			if(e.getSource() == btn4[0][3]){   //折價150元
				String Pname = btn4[0][3].getText();
				proudct_btn(Pname);
			}
			if(e.getSource() == btn4[1][0]){   //折價200元
				String Pname = btn4[1][0].getText();
				proudct_btn(Pname);
			}
			if(e.getSource() == btn4[1][1]){   //折價250元
				String Pname = btn4[1][1].getText();
				proudct_btn(Pname);
			}
			if(e.getSource() == btn4[1][2]){   //折價300元
				String Pname = btn4[1][2].getText();
				proudct_btn(Pname);
			}
			if(e.getSource() == btn4[1][3]){   //折價350元
				String Pname = btn4[1][3].getText();
				proudct_btn(Pname);
			}
			if(e.getSource() == btn4[2][0]){   //折價400元
				String Pname = btn4[2][0].getText();
				proudct_btn(Pname);
			}
			if(e.getSource() == btn4[2][1]){   //折價450元
				String Pname = btn4[2][1].getText();
				proudct_btn(Pname);
			}
			if(e.getSource() == btn4[2][2]){   //折價500元
				String Pname = btn4[2][2].getText();
				proudct_btn(Pname);
			}
			if(e.getSource() == btn4[2][3]){   //折價1000元
				String Pname = btn4[2][3].getText();
				proudct_btn(Pname);
			}
			if(e.getSource() == btn4[4][0]){   //壽星優惠折價50元
				String Pname = btn4[4][0].getText();
				proudct_btn(Pname);
			}

			//Btn3數字鍵盤區
			if(e.getSource() == btn3[2][0]){ //數字1
				a = (a*10)+1;
                table.setValueAt(""+a,index,2);
                price = Integer.parseInt((String)table.getValueAt(index,1));
                amount =Integer.parseInt((String)table.getValueAt(index,2));
                total = price*amount;
                totalStr = String.valueOf(total);
                table.setValueAt(totalStr,index,3);
			}
			if(e.getSource() == btn3[2][1]){ //數字2
				a = (a*10)+2;
                table.setValueAt(""+a,index,2);
                price = Integer.parseInt((String)table.getValueAt(index,1));
                amount =Integer.parseInt((String)table.getValueAt(index,2));
                total = price*amount;
                totalStr = String.valueOf(total);
                table.setValueAt(totalStr,index,3);
			}
			if(e.getSource() == btn3[2][2]){ //數字3
				a = (a*10)+3;
                table.setValueAt(""+a,index,2);
                price = Integer.parseInt((String)table.getValueAt(index,1));
                amount =Integer.parseInt((String)table.getValueAt(index,2));
                total = price*amount;
                totalStr = String.valueOf(total);
                table.setValueAt(totalStr,index,3);
			}
			if(e.getSource() == btn3[1][0]){ //數字4
				a = (a*10)+4;
                table.setValueAt(""+a,index,2);
                price = Integer.parseInt((String)table.getValueAt(index,1));
                amount =Integer.parseInt((String)table.getValueAt(index,2));
                total = price*amount;
                totalStr = String.valueOf(total);
                table.setValueAt(totalStr,index,3);
			}
			if(e.getSource() == btn3[1][1]){ //數字5
				a = (a*10)+5;
                table.setValueAt(""+a,index,2);
                price = Integer.parseInt((String)table.getValueAt(index,1));
                amount =Integer.parseInt((String)table.getValueAt(index,2));
                total = price*amount;
                totalStr = String.valueOf(total);
                table.setValueAt(totalStr,index,3);
			}
			if(e.getSource() == btn3[1][2]){ //數字6
				a = (a*10)+6;
                table.setValueAt(""+a,index,2);
                price = Integer.parseInt((String)table.getValueAt(index,1));
                amount =Integer.parseInt((String)table.getValueAt(index,2));
                total = price*amount;
                totalStr = String.valueOf(total);
                table.setValueAt(totalStr,index,3);
			}
			if(e.getSource() == btn3[0][0]){ //數字7
				a = (a*10)+7;
                table.setValueAt(""+a,index,2);
                price = Integer.parseInt((String)table.getValueAt(index,1));
                amount =Integer.parseInt((String)table.getValueAt(index,2));
                total = price*amount;
                totalStr = String.valueOf(total);
                table.setValueAt(totalStr,index,3);
			}
			if(e.getSource() == btn3[0][1]){ //數字8
				a = (a*10)+8;
                table.setValueAt(""+a,index,2);
                price = Integer.parseInt((String)table.getValueAt(index,1));
                amount =Integer.parseInt((String)table.getValueAt(index,2));
                total = price*amount;
                totalStr = String.valueOf(total);
                table.setValueAt(totalStr,index,3);
			}
			if(e.getSource() == btn3[0][2]){ //數字9
				a = (a*10) + 9;
                table.setValueAt(""+a,index,2);
                price = Integer.parseInt((String)table.getValueAt(index,1));
                amount =Integer.parseInt((String)table.getValueAt(index,2));
                total = price*amount;
                totalStr = String.valueOf(total);
                table.setValueAt(totalStr,index,3);
			}
			if(e.getSource() == btn3[3][1]){ //數字0
				a = (a*10)+0;
                table.setValueAt(""+a,index,2);
                price = Integer.parseInt((String)table.getValueAt(index,1));
                amount =Integer.parseInt((String)table.getValueAt(index,2));
                total = price*amount;
                totalStr = String.valueOf(total);
                table.setValueAt(totalStr,index,3);
			}
			if(e.getSource() == btn3[3][0]){ //清除
				a = 0;
                for(int i=0;i<=index;i++){
                    for(int j=0;j<4;j++){
                        table.setValueAt(null,i,j);
                    }
                }
				index = 0;
				tf1.setText(null); //清除總金額
				tf2.setText(null);
				tf3.setText(null);
			}
			
			if(e.getSource() == btn3[4][0]){//更正
				a = 0;
				table.setValueAt(null,index,3);
				table.setValueAt(null,index,2);
				table.setValueAt(null,index,1);
				table.setValueAt(null,index,0);
				
			}
			
			if(e.getSource() == btn3[3][2]){ //新增
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
					 JOptionPane.showMessageDialog(null, "[ " + Pname + " ]" + "　庫存量不足本次銷售，庫存量剩餘" + Pinventory + "單位");
					 table.setValueAt(null,index,2);
				     table.setValueAt(null,index,3);
				}


			}
			if(e.getSource() == btn3[4][2]){ //結帳
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

					for(int i = 0; i<=index;i++){ //顯示總金額
						sum = sum + Integer.parseInt((String)table.getValueAt(i,3));
						if(sum<0){
							sum=0;
						}	
						sumStr = String.valueOf(sum);
						tf1.setText(sumStr);
					}	
				}
				else{
					JOptionPane.showMessageDialog(null, "[ " + Pname + " ]" + "　庫存量不足本次銷售，庫存量剩餘" + Pinventory + "單位");
					table.setValueAt(null,index,2);
					table.setValueAt(null,index,3);
			   }
            }
		}
	};
 } //end for: class CHCI_front_frame

 
 