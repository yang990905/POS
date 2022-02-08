
 //匯入需要的各類套件
 import javax.swing.*;
 import java.awt.event.*;
 import java.awt.*;
 import javax.swing.border.*;
 import java.sql.*;


 //人機互動層類別
 //CHCI_back_header: Class HumanComputerInteraction_back_header_panel (人機介面-後台標頭類別)

 class CHCI_back_header_panel extends JPanel{
     
     int w = 1280;
     int h = 800;

     JLabel TitleLabel = new JLabel("童心咖啡館店務管理中心");
     JLabel UserLabel = new JLabel("使用者:",JLabel.RIGHT);
     JLabel UserNameLabel = new JLabel();
     Color c = new Color(210,105,30);
     Font font = new Font("微軟正黑體",Font.PLAIN,25);
    
     //建構子:類別CHIC_back_menu_panel
     public CHCI_back_header_panel(){

         TitleLabel.setFont(font);
         TitleLabel.setForeground(Color.white);
         TitleLabel.setBounds(25, 10, 280, 30);
         add(TitleLabel);

         UserLabel.setFont(font);
         UserLabel.setForeground(Color.white);
         UserLabel.setBounds(900, 6, 350, 45);
         //UserLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));  //標線
         add(UserLabel);
         
         setBackground(c);
         setLocation(0,0);
         setSize(w,55);
         setLayout(null);
         setVisible(true);

     }

 } //end for: class CHCI_back_header_panel

 
