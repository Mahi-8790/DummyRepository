import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc_conn {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String url="jdbc:mysql://localhost:3306/python";
        String user= "root";
        String password="root";
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        Connection con=DriverManager.getConnection(url,user,password);
        System.out.println("Connection created");
        
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery("Select * from customer ");
        System.out.println("custumid\t custname\t city");
        while(rs.next()) {
        	int id =rs.getInt("custumid");
        	String name=rs.getString("custname");
        	String city=rs.getString("city");
        	System.out.println(id+" "+ name+" "+city);
        }
        rs.close();
        stmt.close();
        con.close();
       
	}

}
