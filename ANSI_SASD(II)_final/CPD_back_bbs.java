import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.*;
import java.sql.*;

//���D���h���O
//CPD_CPD_back_bbs: Class ProblemDomain_back_bbs ((�e�x)�P�����O)

class CPD_back_bbs{

      private String Bnews;   //�ݩ�:bbs���D
      private String Bdate;    //�ݩ�:bbs�o���ɶ�
   
      public CPD_back_bbs(){
           Bnews = "";
           Bdate = "";
      }

      //��k:�]�wbbs���D
      public void setBnews(String aBBS_Bnews){
           Bnews = aBBS_Bnews;
      }

      //��k:�]�wbbs�o���ɶ�
      public void setBdate(String aBBS_Time){
           Bdate = aBBS_Time;
      }

      //��k:���obbs���D
      public String getBnews(){
           return( Bnews );
      }

      //��k:���obbs�o���ɶ�
      public String getBdate(){
           return( Bdate );
      }

 }
