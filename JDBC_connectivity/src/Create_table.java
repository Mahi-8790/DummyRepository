import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

public class Create_table {

	public static void main(String[] args) throws ClassNotFoundException,SQLException {
		// TODO Auto-generated method stub
		
		String url="jdbc:mysql://localhost:3306/python";
        String user= "root";
        String password="root";
        
        
        String sql="create table students1(rollno int,"
        		+ "name varchar(50),"
        		+ "per int,"
        		+ "email varchar(50))";
        
        
        
        String insertSQL="insert into students1 values(101, 'neeva', 98,'abc@gmail.com')";
        
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	Connection con = DriverManager.getConnection(url,user,password);
        	System.out.println("connection created");
        	
        	Statement stmt=con.createStatement();
        	stmt.executeUpdate(sql);
        	System.out.println("student table created");
        	int rowInserted=stmt.executeUpdate(insertSQL);
        	if (rowInserted>0) {
        		System.out.println("new student recors inserted");
        	}
        	ResultSet rs=stmt.executeQuery("select * from students");
        	System.out.println("rollno\t name\t percentage\t Email");
        	while(rs.next())
        	{
        		int rollno=rs.getInt("rollno");
        		String name=rs.getString("name");
        		int per = rs.getInt("per");
        		String email=rs.getString("email");
        		System.out.println(rollno+" "+name+" "+ per+" "+email);
        				}
        	stmt.close();
        	con.close();
        	
        	
        }
        catch(SQLException e) {
        	System.out.println(e);
        }
        catch(ClassNotFoundException e) {
        	System.out.println(e);
        	
        }
        

	}

}
