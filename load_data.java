 import java.io.*;
 import java.io.IOException;
 import java.sql.*;
 
 class load_data
 { 
     load_data()
     {
     }
     public void load_file(String[] columns,int decide)
     { 
		 Connection connection;
		 PreparedStatement statement;
		 String insert, data;
		 String location =search_location_csv(columns[columns.length-1]);//資料表名字
		 try
		 {
			 connection = DriverManager.getConnection("jdbc:mysql://localhost/cafedb"+
								"?user=root&password=mysql");

			 insert = "INSERT INTO "+columns[columns.length-1]+"("; //組成語法

			 for(int i = 0; i < columns.length-1; i++)
			 {  
				 if(i == columns.length-2)//最後一個屬性
				 {
					 insert += columns[i];
					 insert += " )"+ "VALUES(";
				 }
				 else//其他屬性
					 insert += columns[i]+",";
			 }

			 for(int i = 0; i < columns.length-1; i++)//輸入值
			 {
				 if(i == columns.length-2)
				 {
					 insert += "?";
					 insert += " )";
				 }
				 else
					 insert += "?,";
			 }

			 statement = connection.prepareStatement(insert);
			 //檔案讀取語法
			 FileInputStream reader = new FileInputStream(location);
			 InputStreamReader r = new InputStreamReader(reader,"UTF-8");
			 BufferedReader bfr = new BufferedReader(r);
			 while( (data = bfr.readLine()) != null)
			 {
				 String[] temp =data.trim().split(",");//trim()移除字串開頭和結尾的所有空白字元 split()字串用","分割
				 for(int i = 0 ; i < temp.length; i++)
				 {
					 if( decide == 1)//產品資料表
					 {
						 statement.setInt(1,Integer.parseInt(temp[0]));
						 statement.setString(2,temp[1]);
						 statement.setInt(3,Integer.parseInt(temp[2]));
						 statement.setInt(4,Integer.parseInt(temp[3]) );
						 statement.setString(5,temp[4]);
					 }
					 else if(decide == 2)//員工資料表
					 {
						 statement.setInt(1,Integer.parseInt(temp[0]));
						 statement.setString(2,temp[1]);
						 statement.setString(3,temp[2]);
						 statement.setString(4, temp[3]);
						 statement.setString(5, temp[4]);
						 statement.setString(6, temp[5]);
					 }
								
				 }
				 statement.addBatch();
			 }
			 statement.executeBatch();
		 } 
		 catch (Exception e)
		 {
			 e.printStackTrace();
		 }
     }

     public String search_location_csv(String table_name)//找資料檔案
     {	
	     String location = project_cafe.class.getProtectionDomain().getCodeSource().getLocation().getFile();
	     location += "\\csv\\" + table_name;
	     location += ".csv";
	     return location;
     }
 }