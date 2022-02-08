 import javax.swing.*;
 import java.awt.event.*;
 import java.awt.*;
 import javax.swing.border.*;
 import java.sql.*;

 //問題領域層類別
 //CPD_CPD_Product: Class ProblemDomain_Product (產品)

 class CPD_Product{

      private String Pid;   //屬性:product ID
      private String Pname;    //屬性:product 名稱
      private String Pprice;   //屬性:product 價格
      private String Pinventory;   //屬性:product 存量
      private String Pclass;   //屬性:product 類別
   
      public CPD_Product(){
           Pid = "";
           Pname = "";
           Pprice = "";
           Pinventory = "";
           Pclass = "";
      }

      //方法:設定product ID
      public void setPid(String aProduct_Pid){
           Pid = aProduct_Pid;
      }

      //方法:設定product名稱
      public void setPname(String aProduct_Pname){
           Pname = aProduct_Pname;
      }

      //方法:設定product價格
      public void setPprice(String aProduct_Pprice){
          Pprice = aProduct_Pprice;
     }

     //方法:設定product存量
     public void setPinventory(String aProduct_Pinventory){
          Pinventory = aProduct_Pinventory;
     }

     //方法:設定product類別
     public void setPclass(String aProduct_Pclass){
          Pclass = aProduct_Pclass;
     }

      //方法:取得product ID
      public String getPid(){
           return( Pid );
      }

      //方法:取得product 名稱
      public String getPname(){
           return( Pname );
      }

      //方法:取得product 價格
      public String getPprice(){
          return( Pprice );
     }

     //方法:取得product 存量
     public String getPinventory(){
          return( Pinventory );
     }

     //方法:取得product 類別
     public String getPclass(){
          return( Pclass );
     }

 }
