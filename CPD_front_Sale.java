 import javax.swing.*;
 import java.awt.event.*;
 import java.awt.*;
 import javax.swing.border.*;
 import java.sql.*;

 //���D���h���O
 //CPD_front_Sale: Class ProblemDomain_front_Sale ((�e�x)�P�����O)

 class CPD_front_Sale{

    private String Stotal;   //�ݩ�:�I�\�`���B
    private String Sday;     //�ݩ�:�I�\���
    private String Stime;    //�ݩ�:�I�\�ɶ�
    
    public CPD_front_Sale(){
      Stotal = "";
      Sday = "";
      Stime = "";
    }
     //��k:�]�w�I�\�`���B
     public void setStotal(String aSale_Total){
        Stotal = aSale_Total;
    }

     //��k:�]�w�I�\���
     public void setSday(String aSale_day){
        Sday = aSale_day;
    }

     //��k:�]�w�I�\�ɶ�
     public void setStime(String aSale_Time){
        Stime = aSale_Time;
    }

    //��k:���o�I�\�`���B
    public String getStotal(){
        return( Stotal );
    }

    //��k:���o�I�\���
    public String getSday(){
        return( Sday );
    }

    //��k:���o�I�\�ɶ�
    public String getStime(){
        return( Stime );
    }

 }
