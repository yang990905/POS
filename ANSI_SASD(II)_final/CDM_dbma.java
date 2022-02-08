
//匯入需要的各類套件
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.*;
import java.sql.*;



//資料管理層類別
//CDM_dbma: Class DatabaseManagement_database manipulation and acess (資料庫操作與存取類別)

 class CDM_dbma{                    

      Connection connection;
      Statement statement;
   
      //建構子:類別Cdbma
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
             JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
         } 

         return( myResult );
     }

     public int findRD_Product_inventory(String myPname){

          Connection connection;
          PreparedStatement statement;
          ResultSet result;
          String cmdData;

          int myResult = 0;

         //資料庫前置作業
          try{
               Class.forName("com.mysql.jdbc.Driver");
          } catch(Exception e){
               JOptionPane.showMessageDialog(null,"MySQL驅動程式安裝失敗!"); 
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
               JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
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

         //資料庫前置作業
          try{
               Class.forName("com.mysql.jdbc.Driver");
          } catch(Exception e){
               JOptionPane.showMessageDialog(null,"MySQL驅動程式安裝失敗!"); 
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
               JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
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

         //資料庫前置作業
          try{
               Class.forName("com.mysql.jdbc.Driver");
          } catch(Exception e){
               JOptionPane.showMessageDialog(null,"MySQL驅動程式安裝失敗!"); 
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

               if(myEclass.equals("主管")){
                    myResult = true;
               }
              
          } catch(SQLException e){
               JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
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

         //資料庫前置作業
          try{
               Class.forName("com.mysql.jdbc.Driver");
          } catch(Exception e){
               JOptionPane.showMessageDialog(null,"MySQL驅動程式安裝失敗!"); 
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
               JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
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

         //資料庫前置作業
          try{
               Class.forName("com.mysql.jdbc.Driver");
          } catch(Exception e){
               JOptionPane.showMessageDialog(null,"MySQL驅動程式安裝失敗!"); 
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
               JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
          } 

          return( myResult );            
     }

      public int product_count(String order[] ,int mySid){
           Connection connection;
           PreparedStatement statement;
           ResultSet result;
           String cmdData;

           int total=0;
     
           //資料庫前置作業
           try{
                Class.forName("com.mysql.jdbc.Driver");
           } 
           catch(Exception e){
                JOptionPane.showMessageDialog(null,"MySQL驅動程式安裝失敗!"); 
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
                JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!123");
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
        
          //資料庫前置作業
          try{
               Class.forName("com.mysql.jdbc.Driver");
          } 
          catch(Exception e){
               JOptionPane.showMessageDialog(null,"MySQL驅動程式安裝失敗!"); 
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
               JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!321");
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

           //資料庫前置作業
           try{
                Class.forName("com.mysql.jdbc.Driver");
           } 
           catch(Exception e){
                JOptionPane.showMessageDialog(null,"MySQL驅動程式安裝失敗!"); 
           }

           //在cafedb資料庫中, 新增一筆點餐資料到資料表: OrderProduct   
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
                 //JOptionPane.showMessageDialog(null,"在cafedb資料庫中, 成功寫入一筆[order記錄]到orderproduct資料表中!");
                 statement.close();

           } 
           catch(SQLException e){
                JOptionPane.showMessageDialog(null,"在cafedb資料庫中, 寫入一筆[order記錄]到orderproduct資料表中發生錯誤!");
           }
      }

      public int find_Sid(){

           Connection connection;
           PreparedStatement statement;
           ResultSet result;
           String cmdData;
          
           int mySid=0;

           //資料庫前置作業
           try{
                Class.forName("com.mysql.jdbc.Driver");
           } catch(Exception e){
                JOptionPane.showMessageDialog(null,"MySQL驅動程式安裝失敗!"); 
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
                JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
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
         
 
           //資料庫前置作業
           try{
                Class.forName("com.mysql.jdbc.Driver");
           } 
           catch(Exception e){
                JOptionPane.showMessageDialog(null,"MySQL驅動程式安裝失敗!"); 
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
                JOptionPane.showMessageDialog(null,"已完成，[產品："+aProduct.getPname()+"]，資料更新!");
                statement.close();
           } 
           catch(SQLException e){
                JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
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
                JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
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

          //資料庫前置作業
           try{
                Class.forName("com.mysql.jdbc.Driver");
           } catch(Exception e){
                JOptionPane.showMessageDialog(null,"MySQL驅動程式安裝失敗!"); 
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
                JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
           } 

           myResult[0] = myPprice;
           myResult[1] = myPinventory;

           return( myResult );            
      }
      
      //傳入一筆員工編號,更新員工資料
      public void updateRD_in_TB_Employee(CPD_back_personal aEmployee){

           Connection connection;
           PreparedStatement statement;
           ResultSet result;
           String cmdData;
          
  
           //資料庫前置作業
           try{
                Class.forName("com.mysql.jdbc.Driver");
           } 
           catch(Exception e){
                JOptionPane.showMessageDialog(null,"MySQL驅動程式安裝失敗!"); 
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
                JOptionPane.showMessageDialog(null,"已完成，[編號："+aEmployee.getEid()+"]，員工資料更新!");
                statement.close();
           } 
           catch(SQLException e){
             JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
           }           
      }
      
     
      
      //傳入完整的一筆bbs物件資料(aBBS),然後將此資料存入資料庫的bbs資料表中
      public void insertRD_into_TB_BBS(CPD_back_bbs aBBS){

            Connection connection;
            PreparedStatement statement;
            String cmdData;
  
            //資料庫前置作業
             try{
                  Class.forName("com.mysql.jdbc.Driver");
             } 
             catch(Exception e){
                  JOptionPane.showMessageDialog(null,"MySQL驅動程式安裝失敗!"); 
             }
  
            //在cafedb資料庫中, 新增一筆顧客資料到資料表: BBS   
            try{  
                   cmdData = "INSERT INTO bbs(Bnews,Bdate)"+
                             "VALUES(?,?)";
  
                   connection = DriverManager.getConnection("jdbc:mysql://localhost/cafedb"+"?user=root&password=mysql");
                   statement = connection.prepareStatement(cmdData);
                   statement.setString(1, aBBS.getBnews() );
                   statement.setString(2, aBBS.getBdate() );
                   statement.executeUpdate();
                   JOptionPane.showMessageDialog(null,"在cafedb資料庫中, 成功寫入一筆[BBS記錄]到BBS資料表中!");
                   statement.close();
  
            } 
             catch(SQLException e){
                  JOptionPane.showMessageDialog(null,"在cafedb資料庫中, 寫入一筆[BBS記錄]到BBS資料表中發生錯誤!");
             }
       }
  
      //傳入完整的一筆銷售物件資料(aSale),然後將此資料存入資料庫的Sale資料表中
      public void insertRD_into_TB_sale(CPD_front_Sale aSale){

          Connection connection;
          PreparedStatement statement;
          String cmdData;

          //資料庫前置作業
          try{
                Class.forName("com.mysql.jdbc.Driver");
          } catch(Exception e){
                JOptionPane.showMessageDialog(null,"MySQL驅動程式安裝失敗!"); 
          }

          //在cafedb資料庫中, 新增一筆顧客資料到資料表: sale   
          try{  
                 cmdData = "INSERT INTO sale(Stotal,Sday,Stime)"+
                           "VALUES(?,?,?)";

                 connection = DriverManager.getConnection("jdbc:mysql://localhost/cafedb"+"?user=root&password=mysql");
                 statement = connection.prepareStatement(cmdData);
                 statement.setString(1, aSale.getStotal() );
                 statement.setString(2, aSale.getSday() );
                 statement.setString(3, aSale.getStime() );
                 statement.executeUpdate();
                 JOptionPane.showMessageDialog(null,"在cafedb資料庫中, 成功寫入一筆[銷售記錄]到Sale資料表中!");
                 statement.close();

          } catch(SQLException e){
                 JOptionPane.showMessageDialog(null,"在cafedb資料庫中, 寫入一筆[銷售記錄]到Sale資料表中發生錯誤!");
          }
       }
        
      public void insertRD_into_TB_Employee(CPD_back_personal aEmployee){
       
          Connection connection;
          PreparedStatement statement;
          String cmdData;

          //資料庫前置作業
          try{
                Class.forName("com.mysql.jdbc.Driver");
          } catch(Exception e){
                JOptionPane.showMessageDialog(null,"MySQL驅動程式安裝失敗!"); 
          }

         //在cafedb資料庫中, 新增一筆顧客資料到資料表:employee   
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
                JOptionPane.showMessageDialog(null,"在cafedb資料庫中, 成功寫入一筆[員工資料]到Employee資料表中!");
                statement.close();

          } catch(SQLException e){
                JOptionPane.showMessageDialog(null,"在cafedb資料庫中, 寫入一筆[員工資料]到Employee資料表中發生錯誤!");
          }    
       } 
      //傳入完整的一筆clockin物件資料(aclock),然後將此資料存入資料庫的clockin資料表中
      public void insertRD_into_TB_clockin(CPD_back_clockin aClockin){

           Connection connection;
           PreparedStatement statement;
           ResultSet result;
           String cmdData;
     
           //資料庫前置作業
           try{
                Class.forName("com.mysql.jdbc.Driver");
           } 
           catch(Exception e){
                JOptionPane.showMessageDialog(null,"MySQL驅動程式安裝失敗!"); 
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
                   
                    //在cafedb資料庫中, 新增一筆打卡資料到資料表: clockin  
                     try{  
                          cmdData = "INSERT INTO clockin(Eid,Cdate,Cin)"+
                                    "VALUES(?,?,?)";
          
                          connection = DriverManager.getConnection("jdbc:mysql://localhost/cafedb"+"?user=root&password=mysql");
                          statement = connection.prepareStatement(cmdData);
                          statement.setString(1, aClockin.getEid() );
                          statement.setString(2, aClockin.getCdate() );
                          statement.setString(3, aClockin.getCin() );
                          statement.executeUpdate();
                          JOptionPane.showMessageDialog(null,"[編號："+aClockin.getEid()+"員工]，上班打卡成功!");
                          statement.close();
                     } 
                     catch(SQLException e){
                          JOptionPane.showMessageDialog(null,"在cafedb資料庫中, 寫入一筆[Clockin記錄]到Clockin資料表中發生錯誤!");
                     }
                }
                else{
                     JOptionPane.showMessageDialog(null,"[編號："+aClockin.getEid()+"員工]，"+aClockin.getCdate()+"已經有打卡上班紀錄");
                }
                statement.close();
              
           } catch(SQLException e){
                JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
           } 
      }

      public void updateRD_in_TB_clockin(CPD_back_clockin aClockin){

           Connection connection;
           PreparedStatement statement;
           ResultSet result;
           String cmdData;
         
 
           //資料庫前置作業
           try{
                Class.forName("com.mysql.jdbc.Driver");
           } 
           catch(Exception e){
                JOptionPane.showMessageDialog(null,"MySQL驅動程式安裝失敗!"); 
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
                    if( Cout == null ){ //沒有資料

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
                              JOptionPane.showMessageDialog(null,"[編號："+aClockin.getEid()+"員工]，下班打卡成功!，路上小心!!!");
                              statement.close();
                          } 
                          catch(SQLException e){
                               JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!321");
                          }
                    }
                    else{
                          JOptionPane.showMessageDialog(null,"[編號："+aClockin.getEid()+"員工]，"+aClockin.getCdate()+"已經有打卡下班紀錄");
                    }
               }
                statement.close();
              
           } catch(SQLException e){
                JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤123!");
                System.out.println(e.getMessage());
           } 

      }

      //傳入一筆[員工id],查詢出該員工的姓名資料並回傳其查得[員工姓名]字串結果
      public String findRD_in_TB_employee(int aEid){

          Connection connection;
          PreparedStatement statement;
          ResultSet result;
          String cmdData;
          
          String myEname="";

          //資料庫前置作業
          try{
               Class.forName("com.mysql.jdbc.Driver");
          } catch(Exception e){
               JOptionPane.showMessageDialog(null,"MySQL驅動程式安裝失敗!"); 
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
               JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
          } 
          return( myEname );            
     }

      //傳入一筆[員工id],查詢出該員工的姓名資料並回傳其查得[員工姓名]字串結果
      public String[] findRD_in_TB_employee(String ManaEid){  //管理內員工編號查詢

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


          //資料庫前置作業
          try{
               Class.forName("com.mysql.jdbc.Driver");
          } catch(Exception e){
               JOptionPane.showMessageDialog(null,"MySQL驅動程式安裝失敗!"); 
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
                JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
           } 
         
          myResult[0] = myEname;
          myResult[1] = myEclass;
          myResult[2] = myEphone;
          myResult[3] = myEemail;
          myResult[4] = myEpassword;

          return(myResult);


     }

 /*------------------↓↓↓↓--建立資料表--↓↓↓↓--------------------*/
    //建立資料庫cafedb中的資料表:Employee
    public void createTB_Employee(){

     try{
          connection = DriverManager.getConnection("jdbc:mysql://localhost/cafedb"+"?user=root&password=mysql");
          statement = connection.createStatement();

          String createTB = "CREATE TABLE Employee("+
                            "Eid              INT PRIMARY KEY AUTO_INCREMENT, "+   //成員編號  Eid    (Employee ID) 
                            "Ename            VARCHAR(30), "+         //成員姓名              Ename  (Employee Name)
                            "Eclass           VARCHAR(30), "+         //成員類別                            
                            "Ephone           VARCHAR(30), "+         //成員手機              Ephone  (Employee phone)
                            "Eemail           VARCHAR(5000), "+       //成員信箱              Eemail   (Employee Email)
                            "Epassword        VARCHAR(20))";          //成員密碼              Epassword  (Employee password))                      

          statement.executeUpdate(createTB);
          JOptionPane.showMessageDialog(null,"Employee資料表建立成功!");

          statement.close();

     } catch(SQLException e){
          if(statement != null) 
                JOptionPane.showMessageDialog(null,"Employee資料表已存在,可正常使用!"); 
          else
                JOptionPane.showMessageDialog(null,"MySQL無法啟動!");
    } catch(Exception e){
       JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
    }  
 }

    //建立資料庫cafedb中的資料表:ClockIn
    public void createTB_ClockIn(){

     try{
          connection = DriverManager.getConnection("jdbc:mysql://localhost/cafedb"+"?user=root&password=mysql");
          statement = connection.createStatement();

          String createTB = "CREATE TABLE ClockIn("+
                            "Cid              INT PRIMARY KEY AUTO_INCREMENT, "+  //打卡編號            Cid    (ClockIn ID) 
                            "Eid              INT, "+              //成員編號            Eid    (Employee ID)
                            "Cdate            VARCHAR(50), "+              //打卡日期
                            "Cin              VARCHAR(50), "+      //上班(打卡)時間      Cin    (Clock in)
                            "Cout             VARCHAR(50))";               //下班(打卡)時間      Cout   (Clock out)      

          statement.executeUpdate(createTB);
          JOptionPane.showMessageDialog(null,"ClockIn資料表建立成功!");
          statement.close();

     } catch(SQLException e){
          if(statement != null) 
                JOptionPane.showMessageDialog(null,"ClockIn資料表已存在,可正常使用!"); 
          else
                JOptionPane.showMessageDialog(null,"MySQL無法啟動!");
    } catch(Exception e){
       JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
    }  
 }

    //建立資料庫cafedb中的資料表:OrderProduct
    public void createTB_OrderProduct(){

     try{
          connection = DriverManager.getConnection("jdbc:mysql://localhost/cafedb"+"?user=root&password=mysql");
          statement = connection.createStatement();

          String createTB = "CREATE TABLE OrderProduct("+
                            "Id              INT  AUTO_INCREMENT,   "+    //流水編 
                            "Sid             INT ,                  "+    //點餐編號   Sid  (Sale ID)
                            "SPname          VARCHAR(50) ,          "+    //銷售產品名稱  
                            "SPprice         INT ,                  "+    //銷售產品價格   
                            "SPamount        INT ,                  "+    //銷售產品數量   
                            "SPtotal         INT ,                  "+    //銷售產品小計       
                            "PRIMARY KEY(Id))";                  

          statement.executeUpdate(createTB);
          JOptionPane.showMessageDialog(null,"OrderProduct資料表建立成功!");
          statement.close();

     } catch(SQLException e){
          if(statement != null) 
                JOptionPane.showMessageDialog(null,"OrderProduct資料表已存在,可正常使用!"); 
          else
                JOptionPane.showMessageDialog(null,"MySQL無法啟動!");
    } catch(Exception e){
       JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
    }  
 }

    //建立資料庫cafedb中的資料表:BBS
    public void createTB_BBS(){

      try{
           connection = DriverManager.getConnection("jdbc:mysql://localhost/cafedb"+"?user=root&password=mysql");
           statement = connection.createStatement();
 
           String createTB = "CREATE TABLE BBS("+
                             "Bid              INT PRIMARY KEY AUTO_INCREMENT, "+    //公告編號 Bid (BBS ID) 
                             "Bnews            VARCHAR(5000), "+    //公告內容  Bnews  (BBS)       
                             "Bdate            VARCHAR(5000))"; //公告日期 Bdate (BBS Time)            
 
           statement.executeUpdate(createTB);
           JOptionPane.showMessageDialog(null,"BBS資料表建立成功!");
           statement.close();
 
           /*
            自動初始化 及 自動更新 日期時間
            TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
           */
 
      } catch(SQLException e){
           if(statement != null) 
                 JOptionPane.showMessageDialog(null,"BBS資料表已存在,可正常使用!"); 
           else
                 JOptionPane.showMessageDialog(null,"MySQL無法啟動!");
     } catch(Exception e){
        JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
     }  
  }
 

    //建立資料庫cafedb中的資料表:Sale
    public void createTB_Sale(){

     try{
          connection = DriverManager.getConnection("jdbc:mysql://localhost/cafedb"+"?user=root&password=mysql");
          statement = connection.createStatement();

          String createTB = "CREATE TABLE Sale("+
                            "Sid              INT PRIMARY KEY AUTO_INCREMENT, "+  //點餐編號   Sid    (Sale ID) 
                            "Stotal           VARCHAR(20), "+              //點餐總金額 Stotal (Sale Total Price)
                            "Sday             VARCHAR(50), "+              //點餐日期
                            "Stime            VARCHAR(50))";               //點餐時間   Stime  (Sale Time)    datetime

          statement.executeUpdate(createTB);
          JOptionPane.showMessageDialog(null,"Sale資料表建立成功!");
          statement.close();

     } catch(SQLException e){
          if(statement != null) 
                JOptionPane.showMessageDialog(null,"Sale資料表已存在,可正常使用!"); 
          else
                JOptionPane.showMessageDialog(null,"MySQL無法啟動!");
    } catch(Exception e){
       JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
    }  
 }

    //建立資料庫cafedb中的資料表:Product
    public void createTB_Product(){

     try{
          connection = DriverManager.getConnection("jdbc:mysql://localhost/cafedb"+"?user=root&password=mysql");
          statement = connection.createStatement();

          String createTB = "CREATE TABLE Product("+
                            "Pid              INT PRIMARY KEY AUTO_INCREMENT, "+  //產品編號 Pid(Product ID) 
                            "Pname            VARCHAR(30), "+                     //品項     Pname(Product Name)
                            "Pprice           INT, "+                             //單價     Pprice(Product price)
                            "Pinventory       INT, "+                             //庫存     Pinventory (Product inventory)
                            "Pclass           VARCHAR(30))";        

          statement.executeUpdate(createTB);
          JOptionPane.showMessageDialog(null,"Product資料表建立成功!");
          statement.close();

     } catch(SQLException e){
          if(statement != null) 
                JOptionPane.showMessageDialog(null,"Product資料表已存在,可正常使用!"); 
          else
                JOptionPane.showMessageDialog(null,"MySQL無法啟動!");
    } catch(Exception e){
       JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
    }  
 }

/*------------------↑↑↑↑--建立資料表--↑↑↑↑--------------------*/

/*------------------↓↓↓↓--建立資料庫--↓↓↓↓--------------------*/
    //方法:建立資料庫cafedb
    public void createDB(){

        //安裝MySQL驅動程式, 與建立資料庫cafedb
        try{
             Class.forName("com.mysql.jdbc.Driver");
        } catch(Exception e){
             JOptionPane.showMessageDialog(null,"MySQL驅動程式安裝失敗!"); 
        }

        //建立 cafedb資料庫
        try{
             connection = DriverManager.getConnection("jdbc:mysql://localhost/"+
                                                      "?user=root&password=mysql");
             statement = connection.createStatement();
             String createDB = "CREATE DATABASE cafedb";
             statement.executeUpdate(createDB);
             JOptionPane.showMessageDialog(null,"cafedb資料庫建立成功!");
             statement.close();
             
        } catch(SQLException e){
             if(statement != null) 
                 JOptionPane.showMessageDialog(null,"cafedb資料庫已存在,可正常使用!");
             else
                 JOptionPane.showMessageDialog(null,"MySQL無法啟動!");
        } catch(Exception e){
             JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
        }
      
    } //end for: public void createDB()
    /*------------------↑↑↑↑--建立資料庫--↑↑↑↑-------------------*/
}