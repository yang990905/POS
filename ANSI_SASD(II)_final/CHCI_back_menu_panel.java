
 //匯入需要的各類套件
 import javax.swing.*;
 import java.awt.event.*;
 import java.awt.*;
 import javax.swing.border.*;
 import java.sql.*;


 //人機互動層類別
 //CHCI_back_menu: Class HumanComputerInteraction_back_menu_panel (人機介面-後台功能選單類別)

 class CHCI_back_menu_panel extends JPanel{
     
     int w = 1280;
     int h = 800;

     JPanel p = new JPanel();
     JButton[][] btn = new JButton[7][1];
     Color c = new Color(244,164,96);
     Color c1 = new Color(245,222,179);
     Font font = new Font("微軟正黑體",Font.PLAIN,25);
    
     //建構子:類別CHIC_back_menu_panel
     public CHCI_back_menu_panel(){
         
         String[][] btnStr = {{"主頁"},{"庫存"},{"銷售"},{"人事"},{"管理"},{"回點餐"},{"登出"}};

         for(int i=0; i<btn.length; i++){
             for(int j=0; j<btn[0].length; j++){
                 btn[i][j] = new JButton(btnStr[i][j]);
                 btn[i][j].setFont(font);
                 btn[i][j].setBackground(c1);
                 btn[i][j].setBorder(BorderFactory.createLineBorder(Color.white,1));
                 btn[i][j].setBorder(BorderFactory.createRaisedBevelBorder());
                 p.add(btn[i][j]);
             }
         }

         //容器中的容器(p,美觀用)
         p.setBounds(6,10,144,h-55);
         p.setBackground(c);
         p.setLayout(new GridLayout(8,1,1,20));
         //p.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));  //標線
         add(p);

         setBackground(c);
         setLocation(0,55);
         setSize(160,h-50);
         setLayout(null);
         setVisible(true);

     }

 } //end for: class CHCI_back_menu_panel

 
