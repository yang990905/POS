 import javax.swing.*;
 import java.awt.event.*;
 import java.awt.*;
 import javax.swing.border.*;
 import java.sql.*;

 //���D���h���O
 //CPD_CPD_Product: Class ProblemDomain_Product (���~)

 class CPD_Product{

      private String Pid;   //�ݩ�:product ID
      private String Pname;    //�ݩ�:product �W��
      private String Pprice;   //�ݩ�:product ����
      private String Pinventory;   //�ݩ�:product �s�q
      private String Pclass;   //�ݩ�:product ���O
   
      public CPD_Product(){
           Pid = "";
           Pname = "";
           Pprice = "";
           Pinventory = "";
           Pclass = "";
      }

      //��k:�]�wproduct ID
      public void setPid(String aProduct_Pid){
           Pid = aProduct_Pid;
      }

      //��k:�]�wproduct�W��
      public void setPname(String aProduct_Pname){
           Pname = aProduct_Pname;
      }

      //��k:�]�wproduct����
      public void setPprice(String aProduct_Pprice){
          Pprice = aProduct_Pprice;
     }

     //��k:�]�wproduct�s�q
     public void setPinventory(String aProduct_Pinventory){
          Pinventory = aProduct_Pinventory;
     }

     //��k:�]�wproduct���O
     public void setPclass(String aProduct_Pclass){
          Pclass = aProduct_Pclass;
     }

      //��k:���oproduct ID
      public String getPid(){
           return( Pid );
      }

      //��k:���oproduct �W��
      public String getPname(){
           return( Pname );
      }

      //��k:���oproduct ����
      public String getPprice(){
          return( Pprice );
     }

     //��k:���oproduct �s�q
     public String getPinventory(){
          return( Pinventory );
     }

     //��k:���oproduct ���O
     public String getPclass(){
          return( Pclass );
     }

 }
