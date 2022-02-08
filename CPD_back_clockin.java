import javax.swing.*;
 import java.awt.event.*;
 import java.awt.*;
 import javax.swing.border.*;
 import java.sql.*;

 //問題領域層類別
 //CPD_back_clockin: Class ProblemDomain_front_Sale ((前台)銷售類別)
class CPD_back_clockin {
    
    private String Eid;
    private String Cdate;
    private String Cin;
    private String Cout;

    public CPD_back_clockin(){
        Eid   = "";
        Cdate = "";
        Cin   = "";
        Cout  = "";
    }
    
    public void setEid(String aClockin_Eid ){
        Eid = aClockin_Eid;
    }

    public void setCdate(String aClockin_Cdate){
        Cdate = aClockin_Cdate;
    }

    public void setCin(String aClockin_Cin){
        Cin = aClockin_Cin;
    }

    public void setCout(String aClock_Cout){
        Cout = aClock_Cout;
    }

    public String getEid(){
        return( Eid );
    }

    public String getCdate(){
        return( Cdate );
    }

    public String getCin(){
        return ( Cin );
    }

    public String getCout(){
        return ( Cout );
    }
}
