
 //�פJ�ݭn���U���M��
 import javax.swing.*;
 import java.awt.event.*;
 import java.awt.*;
 import javax.swing.border.*;
 import java.sql.*;


 //�H�����ʼh���O
 //CHCI_back_header: Class HumanComputerInteraction_back_header_panel (�H������-��x���Y���O)

 class CHCI_back_header_panel extends JPanel{
     
     int w = 1280;
     int h = 800;

     JLabel TitleLabel = new JLabel("���ߩ@���]���Ⱥ޲z����");
     JLabel UserLabel = new JLabel("�ϥΪ�:",JLabel.RIGHT);
     JLabel UserNameLabel = new JLabel();
     Color c = new Color(210,105,30);
     Font font = new Font("�L�n������",Font.PLAIN,25);
    
     //�غc�l:���OCHIC_back_menu_panel
     public CHCI_back_header_panel(){

         TitleLabel.setFont(font);
         TitleLabel.setForeground(Color.white);
         TitleLabel.setBounds(25, 10, 280, 30);
         add(TitleLabel);

         UserLabel.setFont(font);
         UserLabel.setForeground(Color.white);
         UserLabel.setBounds(900, 6, 350, 45);
         //UserLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));  //�нu
         add(UserLabel);
         
         setBackground(c);
         setLocation(0,0);
         setSize(w,55);
         setLayout(null);
         setVisible(true);

     }

 } //end for: class CHCI_back_header_panel

 
