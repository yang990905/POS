
//�פJ�ݭn���U���M��
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.sql.*;
import java.util.*;


 //�H�����ʼh���O
 //CHCI_back_management_ForEmployee_panel: 

 class CHCI_back_management_ForEmployee_panel extends JPanel{
     
     int w = 1280;
     int h = 800;

     JTabbedPane tbp = new JTabbedPane();
     JPanel p = new JPanel();
     JLabel TitleLabel = new JLabel("�D�D��¾�L�k�d��!!!",JLabel.CENTER);
     Color c1 = new Color(255,222,173); //�s��
     Color c2 = new Color(237, 237, 237);
     Font font = new Font("�L�n������",Font.PLAIN,25);
     Font font2 = new Font("�L�n������",Font.PLAIN,40);


     
     //�غc�l:���OCHCI_back_management_ForEmployee_panel
     public CHCI_back_management_ForEmployee_panel(){

         TitleLabel.setBounds(395, 230, 375, 70);
         TitleLabel.setFont(font2);
         TitleLabel.setForeground(Color.RED);
         //TitleLabel.setBorder(BorderFactory.createLineBorder(Color.RED,2));  //�нu
         p.add(TitleLabel);
         
         p.setBackground(c1);
         p.setLayout(null);
         tbp.add("�޲z",p);

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

 
