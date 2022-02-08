
//�פJ�ݭn���U���M��
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.*;
import java.sql.*;



//��ƺ޲z�h���O
//CDM_dbma: Class DatabaseManagement_database manipulation and acess (��Ʈw�ާ@�P�s�����O)

 class CDM_dbma{                    

      Connection connection;
      Statement statement;
   
      //�غc�l:���OCdbma
      public CDM_dbma(){
      
     }

     public boolean findRD_Employee_ID(String myID){
          Connection connection;
          PreparedStatement statement;
          ResultSet result;
          String cmdData;

          boolean myResult = true;

          try{
            cmdData = "SELECT * FROM employee WHERE Eid = ?";
            connection = DriverManager.getConnection("jdbc:mysql://localhost/cafedb"+"?user=root&password=mysql");
            statement = connection.prepareStatement(cmdData);
            statement.setString(1, myID);
            result = statement.executeQuery();
 
            if( result.next() == false){
                myResult = false;
            }
            statement.close();
           
         } catch(SQLException e){
             JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
         } 

         return( myResult );
     }

     public int findRD_Product_inventory(String myPname){

          Connection connection;
          PreparedStatement statement;
          ResultSet result;
          String cmdData;

          int myResult = 0;

         //��Ʈw�e�m�@�~
          try{
               Class.forName("com.mysql.jdbc.Driver");
          } catch(Exception e){
               JOptionPane.showMessageDialog(null,"MySQL�X�ʵ{���w�˥���!"); 
          }

          try{
               cmdData = "SELECT Pinventory FROM product " +
                         "WHERE Pname = ? ";
               connection = DriverManager.getConnection("jdbc:mysql://localhost/cafedb"+"?user=root&password=mysql");
               statement = connection.prepareStatement(cmdData);
               statement.setString(1, myPname);
               result = statement.executeQuery();
    
               while( result.next() ){
                   
                    myResult = result.getInt("Pinventory");
               }
               statement.close();
              
          } catch(SQLException e){
               JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
          } 

          //System.out.println(myResult);
          return( myResult );            
     }

     public String findRD_Product_Price(String myPname){

          Connection connection;
          PreparedStatement statement;
          ResultSet result;
          String cmdData;

          String myResult ="";

         //��Ʈw�e�m�@�~
          try{
               Class.forName("com.mysql.jdbc.Driver");
          } catch(Exception e){
               JOptionPane.showMessageDialog(null,"MySQL�X�ʵ{���w�˥���!"); 
          }

          try{
               cmdData = "SELECT Pprice FROM product " +
                         "WHERE Pname = ? ";
               connection = DriverManager.getConnection("jdbc:mysql://localhost/cafedb"+"?user=root&password=mysql");
               statement = connection.prepareStatement(cmdData);
               statement.setString(1, myPname);
               result = statement.executeQuery();
    
               while( result.next() ){
                   
                    myResult = result.getString("Pprice");
               }
               statement.close();
              
          } catch(SQLException e){
               JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
          } 

          return( myResult );            
     }

     public boolean findRD_Login_Management(String myID, String myPassword){

          Connection connection;
          PreparedStatement statement;
          ResultSet result;
          String cmdData;

          boolean myResult = false;
          String myEclass = "";

         //��Ʈw�e�m�@�~
          try{
               Class.forName("com.mysql.jdbc.Driver");
          } catch(Exception e){
               JOptionPane.showMessageDialog(null,"MySQL�X�ʵ{���w�˥���!"); 
          }

          try{
               cmdData = "SELECT * FROM employee " +
                         "WHERE Eid = ? AND Epassword = ? ";
               connection = DriverManager.getConnection("jdbc:mysql://localhost/cafedb"+"?user=root&password=mysql");
               statement = connection.prepareStatement(cmdData);
               statement.setString(1, myID);
               statement.setString(2, myPassword);
               result = statement.executeQuery();
    
               while( result.next() ){
                   
                    myEclass = result.getString("Eclass");
               }
               statement.close();

               if(myEclass.equals("�D��")){
                    myResult = true;
               }
              
          } catch(SQLException e){
               JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
          } 

          return( myResult );            
     }

     public String[] findRD_Login_Employee_Name(String myID, String myPassword){

          Connection connection;
          PreparedStatement statement;
          ResultSet result;
          String cmdData;

          String[] myResult = new String [2];

          String myEmployee_ID = "";
          String myEmployee_Name = "";

         //��Ʈw�e�m�@�~
          try{
               Class.forName("com.mysql.jdbc.Driver");
          } catch(Exception e){
               JOptionPane.showMessageDialog(null,"MySQL�X�ʵ{���w�˥���!"); 
          }

          try{
               cmdData = "SELECT * FROM employee " +
                         "WHERE Eid = ? AND Epassword = ? ";
               connection = DriverManager.getConnection("jdbc:mysql://localhost/cafedb"+"?user=root&password=mysql");
               statement = connection.prepareStatement(cmdData);
               statement.setString(1, myID);
               statement.setString(2, myPassword);
               result = statement.executeQuery();
    
               while( result.next() ){
                   
                    myEmployee_ID = result.getString("Eid");
                    myEmployee_Name = result.getString("Ename");
               }
               statement.close();
              
          } catch(SQLException e){
               JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
          } 

          myResult[0] = myEmployee_ID;
          myResult[1] = myEmployee_Name;

          return( myResult );            
     }

     public boolean findRD_Login_Employee(String myID, String myPassword){

          Connection connection;
          PreparedStatement statement;
          ResultSet result;
          String cmdData;

          boolean myResult = false;

         //��Ʈw�e�m�@�~
          try{
               Class.forName("com.mysql.jdbc.Driver");
          } catch(Exception e){
               JOptionPane.showMessageDialog(null,"MySQL�X�ʵ{���w�˥���!"); 
          }

          try{
               cmdData = "SELECT * FROM employee " +
                         "WHERE Eid = ? AND Epassword = ? ";
               connection = DriverManager.getConnection("jdbc:mysql://localhost/cafedb"+"?user=root&password=mysql");
               statement = connection.prepareStatement(cmdData);
               statement.setString(1, myID);
               statement.setString(2, myPassword);
               result = statement.executeQuery();
    
               if( result.next() == true){
                   
                   myResult = true;
               }
               statement.close();
              
          } catch(SQLException e){
               JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
          } 

          return( myResult );            
     }

      public int product_count(String order[] ,int mySid){
           Connection connection;
           PreparedStatement statement;
           ResultSet result;
           String cmdData;

           int total=0;
     
           //��Ʈw�e�m�@�~
           try{
                Class.forName("com.mysql.jdbc.Driver");
           } 
           catch(Exception e){
                JOptionPane.showMessageDialog(null,"MySQL�X�ʵ{���w�˥���!"); 
           }

           try{
                cmdData = "SELECT ( product.Pinventory - orderproduct.SPamount ) AS total "+
                          "FROM product INNER JOIN orderproduct ON product.Pname = orderproduct.SPname "+
                          "WHERE orderproduct.Sid= ? AND orderproduct.SPname= ?";

                connection = DriverManager.getConnection("jdbc:mysql://localhost/cafedb"+"?user=root&password=mysql");
                statement = connection.prepareStatement(cmdData);
                statement.setInt(1,mySid);
                statement.setString(2,order[0]);
                result = statement.executeQuery();

                while(result.next()){
                     total = result.getInt("total");
                }
                statement.close();            
           }
           catch(SQLException e){
                JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!123");
           } 
        
           return( total );            
      }

     public void updateRD_in_TB_Product_inventory(String[] order, int mySid){

          Connection connection;
          PreparedStatement statement;
          ResultSet result;
          String cmdData;

          int total=0;
          total= product_count(order,mySid);
        
          //��Ʈw�e�m�@�~
          try{
               Class.forName("com.mysql.jdbc.Driver");
          } 
          catch(Exception e){
               JOptionPane.showMessageDialog(null,"MySQL�X�ʵ{���w�˥���!"); 
          }

          try{  
               cmdData = "UPDATE product " +
                         "SET Pinventory= ? " +
                         "WHERE Pname= ? " ;
               connection = DriverManager.getConnection("jdbc:mysql://localhost/cafedb"+"?user=root&password=mysql");
               statement = connection.prepareStatement(cmdData);
               statement.setInt(1, total);
               statement.setString(2, order[0] );
               statement.executeUpdate();
               
               statement.close();
               //System.out.println(total);
          } 
          catch(SQLException e){
               JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!321");
               System.out.println(total);
               System.out.println(order[0]);
               System.out.println(e.getMessage());
               e.printStackTrace();
          }
     }

     public void insertRD_into_TB_orderproduct(String[] order, int mySid){

           Connection connection;
           PreparedStatement statement;
           String cmdData;

           //��Ʈw�e�m�@�~
           try{
                Class.forName("com.mysql.jdbc.Driver");
           } 
           catch(Exception e){
                JOptionPane.showMessageDialog(null,"MySQL�X�ʵ{���w�˥���!"); 
           }

           //�bcafedb��Ʈw��, �s�W�@���I�\��ƨ��ƪ�: OrderProduct   
           try{  
                 cmdData = "INSERT INTO OrderProduct(Sid, SPname, SPprice, SPamount, SPtotal)"+
                           "VALUES(?,?,?,?,?)";

                 connection = DriverManager.getConnection("jdbc:mysql://localhost/cafedb"+"?user=root&password=mysql");
                 statement = connection.prepareStatement(cmdData);
                 statement.setInt(1, mySid );
                 statement.setString(2, order[0] );
                 statement.setString(3, order[1] );
                 statement.setString(4, order[2] );
                 statement.setString(5, order[3] );
                 statement.executeUpdate();
                 //JOptionPane.showMessageDialog(null,"�bcafedb��Ʈw��, ���\�g�J�@��[order�O��]��orderproduct��ƪ�!");
                 statement.close();

           } 
           catch(SQLException e){
                JOptionPane.showMessageDialog(null,"�bcafedb��Ʈw��, �g�J�@��[order�O��]��orderproduct��ƪ��o�Ϳ��~!");
           }
      }

      public int find_Sid(){

           Connection connection;
           PreparedStatement statement;
           ResultSet result;
           String cmdData;
          
           int mySid=0;

           //��Ʈw�e�m�@�~
           try{
                Class.forName("com.mysql.jdbc.Driver");
           } catch(Exception e){
                JOptionPane.showMessageDialog(null,"MySQL�X�ʵ{���w�˥���!"); 
           }

           try{
                cmdData = "SELECT * FROM  sale "+
                          "order by Sid "+
                          "desc limit 1";
                connection = DriverManager.getConnection("jdbc:mysql://localhost/cafedb"+"?user=root&password=mysql");
                statement = connection.prepareStatement(cmdData);
                result = statement.executeQuery();
     
                while( result.next() ){
                    
                    mySid = result.getInt("Sid");
                }
                statement.close();
               
           } catch(SQLException e){
                JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
           } 
           return( mySid );            
      }

      public String[] updateRD_in_TB_Product(CPD_Product aProduct){

           Connection connection;
           PreparedStatement statement;
           ResultSet result;
           String cmdData;

           String myPprice="";
           String myPinventory="";
           String[] myResult = new String[2];
         
 
           //��Ʈw�e�m�@�~
           try{
                Class.forName("com.mysql.jdbc.Driver");
           } 
           catch(Exception e){
                JOptionPane.showMessageDialog(null,"MySQL�X�ʵ{���w�˥���!"); 
           }

           try{  
                cmdData = "UPDATE product " +
                          "SET Pprice= ?, Pinventory= ?" +
                          "WHERE Pname= ?" ;
                connection = DriverManager.getConnection("jdbc:mysql://localhost/cafedb"+"?user=root&password=mysql");
                statement = connection.prepareStatement(cmdData);
                statement.setString(1, aProduct.getPprice());
                statement.setString(2, aProduct.getPinventory());
                statement.setString(3, aProduct.getPname());
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null,"�w�����A[���~�G"+aProduct.getPname()+"]�A��Ƨ�s!");
                statement.close();
           } 
           catch(SQLException e){
                JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
           }
           
           try{
                cmdData = "SELECT * FROM product WHERE pname = ?";
                connection = DriverManager.getConnection("jdbc:mysql://localhost/cafedb"+"?user=root&password=mysql");
                statement = connection.prepareStatement(cmdData);
                statement.setString(1, aProduct.getPname());
                result = statement.executeQuery();
    
                while( result.next() ){
                   
                     myPprice = result.getString("Pprice");
                     myPinventory = result.getString("Pinventory");
                }
                statement.close();
              
           } catch(SQLException e){
                JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
           } 

           myResult[0] = myPprice;
           myResult[1] = myPinventory;

           return( myResult );            
      }

      public String[] findRD_in_TB_proudct(CPD_Product aProduct){

           Connection connection;
           PreparedStatement statement;
           ResultSet result;
           String cmdData;

           String myPprice="";
           String myPinventory="";
           String[] myResult = new String[2];

          //��Ʈw�e�m�@�~
           try{
                Class.forName("com.mysql.jdbc.Driver");
           } catch(Exception e){
                JOptionPane.showMessageDialog(null,"MySQL�X�ʵ{���w�˥���!"); 
           }

           try{
                cmdData = "SELECT * FROM product WHERE pname = ?";
                connection = DriverManager.getConnection("jdbc:mysql://localhost/cafedb"+"?user=root&password=mysql");
                statement = connection.prepareStatement(cmdData);
                statement.setString(1, aProduct.getPname());
                result = statement.executeQuery();
     
                while( result.next() ){
                    
                     myPprice = result.getString("Pprice");
                     myPinventory = result.getString("Pinventory");
                }
                statement.close();
               
           } catch(SQLException e){
                JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
           } 

           myResult[0] = myPprice;
           myResult[1] = myPinventory;

           return( myResult );            
      }
      
      //�ǤJ�@�����u�s��,��s���u���
      public void updateRD_in_TB_Employee(CPD_back_personal aEmployee){

           Connection connection;
           PreparedStatement statement;
           ResultSet result;
           String cmdData;
          
  
           //��Ʈw�e�m�@�~
           try{
                Class.forName("com.mysql.jdbc.Driver");
           } 
           catch(Exception e){
                JOptionPane.showMessageDialog(null,"MySQL�X�ʵ{���w�˥���!"); 
           }

           try{  
                cmdData = "UPDATE employee " +
                          "SET Ename= ?, Eclass= ?, Ephone= ?, Eemail= ?, Epassword= ?" +
                          "WHERE Eid= ?" ;
                connection = DriverManager.getConnection("jdbc:mysql://localhost/cafedb"+"?user=root&password=mysql");
                statement = connection.prepareStatement(cmdData);
                statement.setString(1, aEmployee.getEname());
                statement.setString(2, aEmployee.getEclass());
                statement.setString(3, aEmployee.getEphone());
                statement.setString(4, aEmployee.getEemail());
                statement.setString(5, aEmployee.getEpassword());
                statement.setString(6, aEmployee.getEid());
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null,"�w�����A[�s���G"+aEmployee.getEid()+"]�A���u��Ƨ�s!");
                statement.close();
           } 
           catch(SQLException e){
             JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
           }           
      }
      
     
      
      //�ǤJ���㪺�@��bbs������(aBBS),�M��N����Ʀs�J��Ʈw��bbs��ƪ�
      public void insertRD_into_TB_BBS(CPD_back_bbs aBBS){

            Connection connection;
            PreparedStatement statement;
            String cmdData;
  
            //��Ʈw�e�m�@�~
             try{
                  Class.forName("com.mysql.jdbc.Driver");
             } 
             catch(Exception e){
                  JOptionPane.showMessageDialog(null,"MySQL�X�ʵ{���w�˥���!"); 
             }
  
            //�bcafedb��Ʈw��, �s�W�@���U�ȸ�ƨ��ƪ�: BBS   
            try{  
                   cmdData = "INSERT INTO bbs(Bnews,Bdate)"+
                             "VALUES(?,?)";
  
                   connection = DriverManager.getConnection("jdbc:mysql://localhost/cafedb"+"?user=root&password=mysql");
                   statement = connection.prepareStatement(cmdData);
                   statement.setString(1, aBBS.getBnews() );
                   statement.setString(2, aBBS.getBdate() );
                   statement.executeUpdate();
                   JOptionPane.showMessageDialog(null,"�bcafedb��Ʈw��, ���\�g�J�@��[BBS�O��]��BBS��ƪ�!");
                   statement.close();
  
            } 
             catch(SQLException e){
                  JOptionPane.showMessageDialog(null,"�bcafedb��Ʈw��, �g�J�@��[BBS�O��]��BBS��ƪ��o�Ϳ��~!");
             }
       }
  
      //�ǤJ���㪺�@���P�⪫����(aSale),�M��N����Ʀs�J��Ʈw��Sale��ƪ�
      public void insertRD_into_TB_sale(CPD_front_Sale aSale){

          Connection connection;
          PreparedStatement statement;
          String cmdData;

          //��Ʈw�e�m�@�~
          try{
                Class.forName("com.mysql.jdbc.Driver");
          } catch(Exception e){
                JOptionPane.showMessageDialog(null,"MySQL�X�ʵ{���w�˥���!"); 
          }

          //�bcafedb��Ʈw��, �s�W�@���U�ȸ�ƨ��ƪ�: sale   
          try{  
                 cmdData = "INSERT INTO sale(Stotal,Sday,Stime)"+
                           "VALUES(?,?,?)";

                 connection = DriverManager.getConnection("jdbc:mysql://localhost/cafedb"+"?user=root&password=mysql");
                 statement = connection.prepareStatement(cmdData);
                 statement.setString(1, aSale.getStotal() );
                 statement.setString(2, aSale.getSday() );
                 statement.setString(3, aSale.getStime() );
                 statement.executeUpdate();
                 JOptionPane.showMessageDialog(null,"�bcafedb��Ʈw��, ���\�g�J�@��[�P��O��]��Sale��ƪ�!");
                 statement.close();

          } catch(SQLException e){
                 JOptionPane.showMessageDialog(null,"�bcafedb��Ʈw��, �g�J�@��[�P��O��]��Sale��ƪ��o�Ϳ��~!");
          }
       }
        
      public void insertRD_into_TB_Employee(CPD_back_personal aEmployee){
       
          Connection connection;
          PreparedStatement statement;
          String cmdData;

          //��Ʈw�e�m�@�~
          try{
                Class.forName("com.mysql.jdbc.Driver");
          } catch(Exception e){
                JOptionPane.showMessageDialog(null,"MySQL�X�ʵ{���w�˥���!"); 
          }

         //�bcafedb��Ʈw��, �s�W�@���U�ȸ�ƨ��ƪ�:employee   
         try{  
                cmdData = "INSERT INTO employee(Ename,Eclass,Ephone,Eemail,Epassword)"+
                          "VALUES(?,?,?,?,?)";

                connection = DriverManager.getConnection("jdbc:mysql://localhost/cafedb"+"?user=root&password=mysql");
                statement = connection.prepareStatement(cmdData);
                statement.setString(1, aEmployee.getEname() );
                statement.setString(2, aEmployee.getEclass() );
                statement.setString(3, aEmployee.getEphone() );
                statement.setString(4, aEmployee.getEemail() );
                statement.setString(5, aEmployee.getEpassword() );
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null,"�bcafedb��Ʈw��, ���\�g�J�@��[���u���]��Employee��ƪ�!");
                statement.close();

          } catch(SQLException e){
                JOptionPane.showMessageDialog(null,"�bcafedb��Ʈw��, �g�J�@��[���u���]��Employee��ƪ��o�Ϳ��~!");
          }    
       } 
      //�ǤJ���㪺�@��clockin������(aclock),�M��N����Ʀs�J��Ʈw��clockin��ƪ�
      public void insertRD_into_TB_clockin(CPD_back_clockin aClockin){

           Connection connection;
           PreparedStatement statement;
           ResultSet result;
           String cmdData;
     
           //��Ʈw�e�m�@�~
           try{
                Class.forName("com.mysql.jdbc.Driver");
           } 
           catch(Exception e){
                JOptionPane.showMessageDialog(null,"MySQL�X�ʵ{���w�˥���!"); 
           }
     
           try{
                cmdData = "SELECT * FROM clockin "+
                          "WHERE Eid = ? AND Cdate = ?";
                connection = DriverManager.getConnection("jdbc:mysql://localhost/cafedb"+"?user=root&password=mysql");
                statement = connection.prepareStatement(cmdData);
                statement.setString(1, aClockin.getEid());
                statement.setString(2, aClockin.getCdate());
                result = statement.executeQuery();
    
                if( result.next() == false){
                   
                    //�bcafedb��Ʈw��, �s�W�@�����d��ƨ��ƪ�: clockin  
                     try{  
                          cmdData = "INSERT INTO clockin(Eid,Cdate,Cin)"+
                                    "VALUES(?,?,?)";
          
                          connection = DriverManager.getConnection("jdbc:mysql://localhost/cafedb"+"?user=root&password=mysql");
                          statement = connection.prepareStatement(cmdData);
                          statement.setString(1, aClockin.getEid() );
                          statement.setString(2, aClockin.getCdate() );
                          statement.setString(3, aClockin.getCin() );
                          statement.executeUpdate();
                          JOptionPane.showMessageDialog(null,"[�s���G"+aClockin.getEid()+"���u]�A�W�Z���d���\!");
                          statement.close();
                     } 
                     catch(SQLException e){
                          JOptionPane.showMessageDialog(null,"�bcafedb��Ʈw��, �g�J�@��[Clockin�O��]��Clockin��ƪ��o�Ϳ��~!");
                     }
                }
                else{
                     JOptionPane.showMessageDialog(null,"[�s���G"+aClockin.getEid()+"���u]�A"+aClockin.getCdate()+"�w�g�����d�W�Z����");
                }
                statement.close();
              
           } catch(SQLException e){
                JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
           } 
      }

      public void updateRD_in_TB_clockin(CPD_back_clockin aClockin){

           Connection connection;
           PreparedStatement statement;
           ResultSet result;
           String cmdData;
         
 
           //��Ʈw�e�m�@�~
           try{
                Class.forName("com.mysql.jdbc.Driver");
           } 
           catch(Exception e){
                JOptionPane.showMessageDialog(null,"MySQL�X�ʵ{���w�˥���!"); 
           }

           
           try{               
                cmdData = "SELECT * FROM clockin " + 
                          "WHERE Eid = ? AND Cdate = ? ";
                
                connection = DriverManager.getConnection("jdbc:mysql://localhost/cafedb"+"?user=root&password=mysql");
                statement = connection.prepareStatement(cmdData);
                statement.setString(1, aClockin.getEid());
                statement.setString(2, aClockin.getCdate());
                result = statement.executeQuery();
                if(result.next()!=false)
                {
                    String Cout = result.getString("Cout");
                    if( Cout == null ){ //�S�����

                         try{  
                              cmdData = "UPDATE clockin " +
                                        "SET Cout=?" +
                                        "WHERE Eid= ? AND Cdate=?" ;
                              connection = DriverManager.getConnection("jdbc:mysql://localhost/cafedb"+"?user=root&password=mysql");
                              statement = connection.prepareStatement(cmdData);
                              statement.setString(1, aClockin.getCout());
                              statement.setString(2, aClockin.getEid());
                              statement.setString(3, aClockin.getCdate());
                              statement.executeUpdate();
                              JOptionPane.showMessageDialog(null,"[�s���G"+aClockin.getEid()+"���u]�A�U�Z���d���\!�A���W�p��!!!");
                              statement.close();
                          } 
                          catch(SQLException e){
                               JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!321");
                          }
                    }
                    else{
                          JOptionPane.showMessageDialog(null,"[�s���G"+aClockin.getEid()+"���u]�A"+aClockin.getCdate()+"�w�g�����d�U�Z����");
                    }
               }
                statement.close();
              
           } catch(SQLException e){
                JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~123!");
                System.out.println(e.getMessage());
           } 

      }

      //�ǤJ�@��[���uid],�d�ߥX�ӭ��u���m�W��ƨæ^�Ǩ�d�o[���u�m�W]�r�굲�G
      public String findRD_in_TB_employee(int aEid){

          Connection connection;
          PreparedStatement statement;
          ResultSet result;
          String cmdData;
          
          String myEname="";

          //��Ʈw�e�m�@�~
          try{
               Class.forName("com.mysql.jdbc.Driver");
          } catch(Exception e){
               JOptionPane.showMessageDialog(null,"MySQL�X�ʵ{���w�˥���!"); 
          }

          try{
               cmdData = "SELECT * FROM employee WHERE Eid = ?";
               connection = DriverManager.getConnection("jdbc:mysql://localhost/cafedb"+"?user=root&password=mysql");
               statement = connection.prepareStatement(cmdData);
               statement.setInt(1,aEid);
               result = statement.executeQuery();
     
               while( result.next() ){
                    
                    myEname = result.getString("Ename");
               }
               statement.close();
               
          } catch(SQLException e){
               JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
          } 
          return( myEname );            
     }

      //�ǤJ�@��[���uid],�d�ߥX�ӭ��u���m�W��ƨæ^�Ǩ�d�o[���u�m�W]�r�굲�G
      public String[] findRD_in_TB_employee(String ManaEid){  //�޲z�����u�s���d��

          Connection connection;
          PreparedStatement statement;
          ResultSet result;
          String cmdData;
          
          
          String myEclass="";
          String myEname="";
          String myEphone="";
          String myEemail="";
          String myEpassword="";
          String[] myResult = new String[5];


          //��Ʈw�e�m�@�~
          try{
               Class.forName("com.mysql.jdbc.Driver");
          } catch(Exception e){
               JOptionPane.showMessageDialog(null,"MySQL�X�ʵ{���w�˥���!"); 
          }

          try{
               cmdData = "SELECT * FROM employee WHERE Eid = ?";
               connection = DriverManager.getConnection("jdbc:mysql://localhost/cafedb" + "?user=root&password=mysql");
               statement = connection.prepareStatement(cmdData);
               statement.setString(1,ManaEid);
               result = statement.executeQuery();
     
               while( result.next() ){
                    myEname = result.getString("Ename");
                    myEclass = result.getString("Eclass");
                    myEphone = result.getString("Ephone");
                    myEemail = result.getString("Eemail");
                    myEpassword = result.getString("Epassword");
               }
               statement.close();
               
           } catch(SQLException e){
                JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
           } 
         
          myResult[0] = myEname;
          myResult[1] = myEclass;
          myResult[2] = myEphone;
          myResult[3] = myEemail;
          myResult[4] = myEpassword;

          return(myResult);


     }

 /*------------------��������--�إ߸�ƪ�--��������--------------------*/
    //�إ߸�Ʈwcafedb������ƪ�:Employee
    public void createTB_Employee(){

     try{
          connection = DriverManager.getConnection("jdbc:mysql://localhost/cafedb"+"?user=root&password=mysql");
          statement = connection.createStatement();

          String createTB = "CREATE TABLE Employee("+
                            "Eid              INT PRIMARY KEY AUTO_INCREMENT, "+   //�����s��  Eid    (Employee ID) 
                            "Ename            VARCHAR(30), "+         //�����m�W              Ename  (Employee Name)
                            "Eclass           VARCHAR(30), "+         //�������O                            
                            "Ephone           VARCHAR(30), "+         //�������              Ephone  (Employee phone)
                            "Eemail           VARCHAR(5000), "+       //�����H�c              Eemail   (Employee Email)
                            "Epassword        VARCHAR(20))";          //�����K�X              Epassword  (Employee password))                      

          statement.executeUpdate(createTB);
          JOptionPane.showMessageDialog(null,"Employee��ƪ�إߦ��\!");

          statement.close();

     } catch(SQLException e){
          if(statement != null) 
                JOptionPane.showMessageDialog(null,"Employee��ƪ�w�s�b,�i���`�ϥ�!"); 
          else
                JOptionPane.showMessageDialog(null,"MySQL�L�k�Ұ�!");
    } catch(Exception e){
       JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
    }  
 }

    //�إ߸�Ʈwcafedb������ƪ�:ClockIn
    public void createTB_ClockIn(){

     try{
          connection = DriverManager.getConnection("jdbc:mysql://localhost/cafedb"+"?user=root&password=mysql");
          statement = connection.createStatement();

          String createTB = "CREATE TABLE ClockIn("+
                            "Cid              INT PRIMARY KEY AUTO_INCREMENT, "+  //���d�s��            Cid    (ClockIn ID) 
                            "Eid              INT, "+              //�����s��            Eid    (Employee ID)
                            "Cdate            VARCHAR(50), "+              //���d���
                            "Cin              VARCHAR(50), "+      //�W�Z(���d)�ɶ�      Cin    (Clock in)
                            "Cout             VARCHAR(50))";               //�U�Z(���d)�ɶ�      Cout   (Clock out)      

          statement.executeUpdate(createTB);
          JOptionPane.showMessageDialog(null,"ClockIn��ƪ�إߦ��\!");
          statement.close();

     } catch(SQLException e){
          if(statement != null) 
                JOptionPane.showMessageDialog(null,"ClockIn��ƪ�w�s�b,�i���`�ϥ�!"); 
          else
                JOptionPane.showMessageDialog(null,"MySQL�L�k�Ұ�!");
    } catch(Exception e){
       JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
    }  
 }

    //�إ߸�Ʈwcafedb������ƪ�:OrderProduct
    public void createTB_OrderProduct(){

     try{
          connection = DriverManager.getConnection("jdbc:mysql://localhost/cafedb"+"?user=root&password=mysql");
          statement = connection.createStatement();

          String createTB = "CREATE TABLE OrderProduct("+
                            "Id              INT  AUTO_INCREMENT,   "+    //�y���s 
                            "Sid             INT ,                  "+    //�I�\�s��   Sid  (Sale ID)
                            "SPname          VARCHAR(50) ,          "+    //�P�ⲣ�~�W��  
                            "SPprice         INT ,                  "+    //�P�ⲣ�~����   
                            "SPamount        INT ,                  "+    //�P�ⲣ�~�ƶq   
                            "SPtotal         INT ,                  "+    //�P�ⲣ�~�p�p       
                            "PRIMARY KEY(Id))";                  

          statement.executeUpdate(createTB);
          JOptionPane.showMessageDialog(null,"OrderProduct��ƪ�إߦ��\!");
          statement.close();

     } catch(SQLException e){
          if(statement != null) 
                JOptionPane.showMessageDialog(null,"OrderProduct��ƪ�w�s�b,�i���`�ϥ�!"); 
          else
                JOptionPane.showMessageDialog(null,"MySQL�L�k�Ұ�!");
    } catch(Exception e){
       JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
    }  
 }

    //�إ߸�Ʈwcafedb������ƪ�:BBS
    public void createTB_BBS(){

      try{
           connection = DriverManager.getConnection("jdbc:mysql://localhost/cafedb"+"?user=root&password=mysql");
           statement = connection.createStatement();
 
           String createTB = "CREATE TABLE BBS("+
                             "Bid              INT PRIMARY KEY AUTO_INCREMENT, "+    //���i�s�� Bid (BBS ID) 
                             "Bnews            VARCHAR(5000), "+    //���i���e  Bnews  (BBS)       
                             "Bdate            VARCHAR(5000))"; //���i��� Bdate (BBS Time)            
 
           statement.executeUpdate(createTB);
           JOptionPane.showMessageDialog(null,"BBS��ƪ�إߦ��\!");
           statement.close();
 
           /*
            �۰ʪ�l�� �� �۰ʧ�s ����ɶ�
            TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
           */
 
      } catch(SQLException e){
           if(statement != null) 
                 JOptionPane.showMessageDialog(null,"BBS��ƪ�w�s�b,�i���`�ϥ�!"); 
           else
                 JOptionPane.showMessageDialog(null,"MySQL�L�k�Ұ�!");
     } catch(Exception e){
        JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
     }  
  }
 

    //�إ߸�Ʈwcafedb������ƪ�:Sale
    public void createTB_Sale(){

     try{
          connection = DriverManager.getConnection("jdbc:mysql://localhost/cafedb"+"?user=root&password=mysql");
          statement = connection.createStatement();

          String createTB = "CREATE TABLE Sale("+
                            "Sid              INT PRIMARY KEY AUTO_INCREMENT, "+  //�I�\�s��   Sid    (Sale ID) 
                            "Stotal           VARCHAR(20), "+              //�I�\�`���B Stotal (Sale Total Price)
                            "Sday             VARCHAR(50), "+              //�I�\���
                            "Stime            VARCHAR(50))";               //�I�\�ɶ�   Stime  (Sale Time)    datetime

          statement.executeUpdate(createTB);
          JOptionPane.showMessageDialog(null,"Sale��ƪ�إߦ��\!");
          statement.close();

     } catch(SQLException e){
          if(statement != null) 
                JOptionPane.showMessageDialog(null,"Sale��ƪ�w�s�b,�i���`�ϥ�!"); 
          else
                JOptionPane.showMessageDialog(null,"MySQL�L�k�Ұ�!");
    } catch(Exception e){
       JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
    }  
 }

    //�إ߸�Ʈwcafedb������ƪ�:Product
    public void createTB_Product(){

     try{
          connection = DriverManager.getConnection("jdbc:mysql://localhost/cafedb"+"?user=root&password=mysql");
          statement = connection.createStatement();

          String createTB = "CREATE TABLE Product("+
                            "Pid              INT PRIMARY KEY AUTO_INCREMENT, "+  //���~�s�� Pid(Product ID) 
                            "Pname            VARCHAR(30), "+                     //�~��     Pname(Product Name)
                            "Pprice           INT, "+                             //���     Pprice(Product price)
                            "Pinventory       INT, "+                             //�w�s     Pinventory (Product inventory)
                            "Pclass           VARCHAR(30))";        

          statement.executeUpdate(createTB);
          JOptionPane.showMessageDialog(null,"Product��ƪ�إߦ��\!");
          statement.close();

     } catch(SQLException e){
          if(statement != null) 
                JOptionPane.showMessageDialog(null,"Product��ƪ�w�s�b,�i���`�ϥ�!"); 
          else
                JOptionPane.showMessageDialog(null,"MySQL�L�k�Ұ�!");
    } catch(Exception e){
       JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
    }  
 }

/*------------------��������--�إ߸�ƪ�--��������--------------------*/

/*------------------��������--�إ߸�Ʈw--��������--------------------*/
    //��k:�إ߸�Ʈwcafedb
    public void createDB(){

        //�w��MySQL�X�ʵ{��, �P�إ߸�Ʈwcafedb
        try{
             Class.forName("com.mysql.jdbc.Driver");
        } catch(Exception e){
             JOptionPane.showMessageDialog(null,"MySQL�X�ʵ{���w�˥���!"); 
        }

        //�إ� cafedb��Ʈw
        try{
             connection = DriverManager.getConnection("jdbc:mysql://localhost/"+
                                                      "?user=root&password=mysql");
             statement = connection.createStatement();
             String createDB = "CREATE DATABASE cafedb";
             statement.executeUpdate(createDB);
             JOptionPane.showMessageDialog(null,"cafedb��Ʈw�إߦ��\!");
             statement.close();
             
        } catch(SQLException e){
             if(statement != null) 
                 JOptionPane.showMessageDialog(null,"cafedb��Ʈw�w�s�b,�i���`�ϥ�!");
             else
                 JOptionPane.showMessageDialog(null,"MySQL�L�k�Ұ�!");
        } catch(Exception e){
             JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
        }
      
    } //end for: public void createDB()
    /*------------------��������--�إ߸�Ʈw--��������-------------------*/
}