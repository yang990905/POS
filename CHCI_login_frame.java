
 //匯入需要的各類套件
 import javax.swing.*;
 import java.awt.event.*;
 import java.awt.*;
 import javax.swing.border.*;
 import java.sql.*;


 
 //人機互動層類別
 //CHCI_frame: Class HumanComputerInteraction_frame (人機介面-登入框架類別)

 class CHCI_login_frame extends JFrame{      //系統登入的視窗

     int w = 1280;
     int h = 800;
     
    JPanel p = new JPanel();
    JLabel b0 = new JLabel("");
	 JLabel b1 = new JLabel("帳號:");
	 JLabel b2 = new JLabel("密碼:");
	 JTextField tf1 = new JTextField("");
	 JPasswordField pwf = new JPasswordField();
	 JButton btn1 = new JButton("提交");
    JButton btn2 = new JButton("清空");
    Font font1 = new Font("微軟正黑體",Font.BOLD,38);
    Color loginbackground = new Color(138,86,71);
    ImageIcon logo = new ImageIcon("images\\login_logo.png");//500
    
     JLabel b3 =  new JLabel(logo);
    
     //建構子:類別CHCI_login_frame
     public CHCI_login_frame(){

        b3.setBounds(128,100,500,500);//LOGO位置
        p.setBounds(128,70,500,500);
        p.setBackground(loginbackground);
        p.add(b3);
        add(p);

        b0.setBounds(918,170,200,70); //顯示登入結果用
        b0.setFont(font1);
        b0.setForeground(Color.yellow);
        add(b0);
	      
        b1.setBounds(770,230,100,100); //帳號標籤
        b1.setFont(font1);
        b1.setForeground(Color.white);
	     add(b1);

        tf1.setBounds(860,255,320,53); //帳號文字欄位
        tf1.setBackground(loginbackground);
        tf1.setFont(font1);
        tf1.setForeground(Color.white);
        add(tf1);

        b2.setBounds(770,330,100,100); //密碼標籤
        b2.setFont(font1);
        b2.setForeground(Color.white);
        add(b2);

        pwf.setBounds(860,355,320,53);//密碼欄位
        pwf.setBackground(loginbackground);
        pwf.setForeground(Color.white);
        pwf.setFont(font1);
        add(pwf);  
	      
        btn1.setBounds(830,445,130,70); //提交按鈕
        btn1.setFont(font1);
        btn1.setBackground(loginbackground);
        btn1.setForeground(Color.white);
	     add(btn1);

        btn2.setBounds(1020,445,130,70); //清空按鈕
        btn2.setFont(font1);
        btn2.setBackground(loginbackground);
        btn2.addActionListener(BtnPress);
        btn2.setForeground(Color.white);
	     add(btn2);

        setLayout(null);
        setBounds(0,0,1280,800);
        getContentPane().setBackground(loginbackground);////視窗加背景顏色
        setTitle("童心咖啡館 Chindish Cafe 登入系統");
        setVisible(true);
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

     public ActionListener BtnPress = new ActionListener(){
	     public void actionPerformed(ActionEvent e){	
		     if( e.getSource() == btn2){
		        tf1.setText("");
		        pwf.setText("");
		        b0.setText("");
		     }
	     }
     };

 } //end for: class CHCI_login_frame

 
 