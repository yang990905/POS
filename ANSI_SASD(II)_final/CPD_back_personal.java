import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.*;
import java.sql.*;

//���D���h���O
//CPD_back_add_Personal: Class ProblemDomain_back_add_Personal ((��x)�޲z���u�޲z�s�W)

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

     //��k:�]�w���uID
     public void setEid(String aId){
         Eid = aId;
     }

     //��k:�]�w���u�W�r
     public void setEname(String aName){
         Ename = aName;
     }
     //��k:�]�w���u���O
     public void setEclass(String aClass){
          Eclass = aClass;
     }
     //��k:�]�w���u���
     public void setEphone(String aPhone){
          Ephone = aPhone;
     }
     //��k:�]�w���u�H�c
     public void setEemail(String aEemail){
          Eemail = aEemail;
     }
     //��k:�]�w���u�K�X
     public void setEpassword(String aPassword){
          Epassword = aPassword;
     }

     //��k:���o���uID
     public String getEid(){
         return( Eid );
     }

     //��k:���o���u�W�r
     public String getEname(){
         return( Ename );
     }
     //��k:���o���u���O
     public String getEclass(){
         return( Eclass );
     }
     //��k:���o���u���
     public String getEphone(){
         return( Ephone );
     }
     //��k:���o���u�H�c
     public String getEemail(){
         return( Eemail );
     }
     //��k:���o���u�K�X
     public String getEpassword(){
         return( Epassword );
     }

 }