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
		 String location =search_location_csv(columns[columns.length-1]);//��ƪ�W�r
		 try
		 {
			 connection = DriverManager.getConnection("jdbc:mysql://localhost/cafedb"+
								"?user=root&password=mysql");

			 insert = "INSERT INTO "+columns[columns.length-1]+"("; //�զ��y�k

			 for(int i = 0; i < columns.length-1; i++)
			 {  
				 if(i == columns.length-2)//�̫�@���ݩ�
				 {
					 insert += columns[i];
					 insert += " )"+ "VALUES(";
				 }
				 else//��L�ݩ�
					 insert += columns[i]+",";
			 }

			 for(int i = 0; i < columns.length-1; i++)//��J��
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
			 //�ɮ�Ū���y�k
			 FileInputStream reader = new FileInputStream(location);
			 InputStreamReader r = new InputStreamReader(reader,"UTF-8");
			 BufferedReader bfr = new BufferedReader(r);
			 while( (data = bfr.readLine()) != null)
			 {
				 String[] temp =data.trim().split(",");//trim()�����r��}�Y�M�������Ҧ��ťզr�� split()�r���","����
				 for(int i = 0 ; i < temp.length; i++)
				 {
					 if( decide == 1)//���~��ƪ�
					 {
						 statement.setInt(1,Integer.parseInt(temp[0]));
						 statement.setString(2,temp[1]);
						 statement.setInt(3,Integer.parseInt(temp[2]));
						 statement.setInt(4,Integer.parseInt(temp[3]) );
						 statement.setString(5,temp[4]);
					 }
					 else if(decide == 2)//���u��ƪ�
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

     public String search_location_csv(String table_name)//�����ɮ�
     {	
	     String location = project_cafe.class.getProtectionDomain().getCodeSource().getLocation().getFile();
	     location += "\\csv\\" + table_name;
	     location += ".csv";
	     return location;
     }
 }