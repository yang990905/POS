import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.*;
import java.sql.*;

//問題領域層類別
//CPD_back_add_Personal: Class ProblemDomain_back_add_Personal ((後台)管理員工管理新增)

class CPD_back_personal{
     private String Eid;
     private String Ename;
     private String Eclass;
     private String Ephone;
     private String Eemail;
     private String Epassword;

     public CPD_back_personal(){
         Eid="";
         Ename = "";
         Eclass = "";
         Ephone = "";
         Eemail = "";
         Epassword = "";
     }

     //方法:設定員工ID
     public void setEid(String aId){
         Eid = aId;
     }

     //方法:設定員工名字
     public void setEname(String aName){
         Ename = aName;
     }
     //方法:設定員工類別
     public void setEclass(String aClass){
          Eclass = aClass;
     }
     //方法:設定員工手機
     public void setEphone(String aPhone){
          Ephone = aPhone;
     }
     //方法:設定員工信箱
     public void setEemail(String aEemail){
          Eemail = aEemail;
     }
     //方法:設定員工密碼
     public void setEpassword(String aPassword){
          Epassword = aPassword;
     }

     //方法:取得員工ID
     public String getEid(){
         return( Eid );
     }

     //方法:取得員工名字
     public String getEname(){
         return( Ename );
     }
     //方法:取得員工類別
     public String getEclass(){
         return( Eclass );
     }
     //方法:取得員工手機
     public String getEphone(){
         return( Ephone );
     }
     //方法:取得員工信箱
     public String getEemail(){
         return( Eemail );
     }
     //方法:取得員工密碼
     public String getEpassword(){
         return( Epassword );
     }

 }