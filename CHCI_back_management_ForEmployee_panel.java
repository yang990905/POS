
//匯入需要的各類套件
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.sql.*;
import java.util.*;


 //人機互動層類別
 //CHCI_back_management_ForEmployee_panel: 

 class CHCI_back_management_ForEmployee_panel extends JPanel{
     
     int w = 1280;
     int h = 800;

     JTabbedPane tbp = new JTabbedPane();
     JPanel p = new JPanel();
     JLabel TitleLabel = new JLabel("非主管職無法查看!!!",JLabel.CENTER);
     Color c1 = new Color(255,222,173); //新的
     Color c2 = new Color(237, 237, 237);
     Font font = new Font("微軟正黑體",Font.PLAIN,25);
     Font font2 = new Font("微軟正黑體",Font.PLAIN,40);


     
     //建構子:類別CHCI_back_management_ForEmployee_panel
     public CHCI_back_management_ForEmployee_panel(){

         TitleLabel.setBounds(395, 230, 375, 70);
         TitleLabel.setFont(font2);
         TitleLabel.setForeground(Color.RED);
         //TitleLabel.setBorder(BorderFactory.createLineBorder(Color.RED,2));  //標線
         p.add(TitleLabel);
         
         p.setBackground(c1);
         p.setLayout(null);
         tbp.add("管理",p);

         tbp.setFont(font);
         tbp.setBounds(0,0,w-163,h-55);
         add(tbp);

         setBackground(c1);
         setLocation(160,55);
         setSize(w-163,h-55);
         setLayout(null);
         setVisible(true);

     }

 } //end for: class CHCI_back_management_ForEmployee_panel

 
