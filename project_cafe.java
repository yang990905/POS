 //匯入需要的各類套件
 import javax.swing.*;
 import java.awt.event.*;
 import java.awt.*;
 import javax.swing.border.*;
 import java.sql.*;


 //主程式: project_cafe.java

 public class project_cafe{
    public static void main(String[] args){

       if( args.length == 2 && args[0].equals("-p") && args[1].equals("setupcafedb") ){

          CDM_dbma myDBMA = new CDM_dbma();
          load_data load = new load_data();
          myDBMA.createDB();             
          myDBMA.createTB_Product();     
          myDBMA.createTB_Sale();
          myDBMA.createTB_BBS();
          myDBMA.createTB_OrderProduct();
          myDBMA.createTB_ClockIn();
          myDBMA.createTB_Employee();
	       String[] product={"Pid","Pname","Pprice","Pinventory","Pclass","product"};
          load.load_file(product,1);
          String[] employee={"Eid","Ename","Eclass","Ephone","Eemail","Epassword","employee"};
          load.load_file(employee,2);
       }

       CCMS myCMS = new CCMS();  //CSMS: Class Cafe Management System 咖啡店管理系統類別 
            
    }
 }
             

     