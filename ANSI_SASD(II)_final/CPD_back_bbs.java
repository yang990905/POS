import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.*;
import java.sql.*;

//問題領域層類別
//CPD_CPD_back_bbs: Class ProblemDomain_back_bbs ((前台)銷售類別)

class CPD_back_bbs{

      private String Bnews;   //屬性:bbs標題
      private String Bdate;    //屬性:bbs發布時間
   
      public CPD_back_bbs(){
           Bnews = "";
           Bdate = "";
      }

      //方法:設定bbs標題
      public void setBnews(String aBBS_Bnews){
           Bnews = aBBS_Bnews;
      }

      //方法:設定bbs發布時間
      public void setBdate(String aBBS_Time){
           Bdate = aBBS_Time;
      }

      //方法:取得bbs標題
      public String getBnews(){
           return( Bnews );
      }

      //方法:取得bbs發布時間
      public String getBdate(){
           return( Bdate );
      }

 }
