 import javax.swing.*;
 import java.awt.event.*;
 import java.awt.*;
 import javax.swing.border.*;
 import java.sql.*;

 //問題領域層類別
 //CPD_front_Sale: Class ProblemDomain_front_Sale ((前台)銷售類別)

 class CPD_front_Sale{

    private String Stotal;   //屬性:點餐總金額
    private String Sday;     //屬性:點餐日期
    private String Stime;    //屬性:點餐時間
    
    public CPD_front_Sale(){
      Stotal = "";
      Sday = "";
      Stime = "";
    }
     //方法:設定點餐總金額
     public void setStotal(String aSale_Total){
        Stotal = aSale_Total;
    }

     //方法:設定點餐日期
     public void setSday(String aSale_day){
        Sday = aSale_day;
    }

     //方法:設定點餐時間
     public void setStime(String aSale_Time){
        Stime = aSale_Time;
    }

    //方法:取得點餐總金額
    public String getStotal(){
        return( Stotal );
    }

    //方法:取得點餐日期
    public String getSday(){
        return( Sday );
    }

    //方法:取得點餐時間
    public String getStime(){
        return( Stime );
    }

 }
