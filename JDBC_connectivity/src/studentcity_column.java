import java.sql.*;
public class studentcity_column {
	
	  
	    static final String URL = "jdbc:mysql://localhost:3306/python";
	    static final String USER = "root";
	    static final String PASS = "root";

	    public static void main(String[] args) {
	        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Statement st = con.createStatement();
	            

	            // Create tables
	            st.execute("CREATE TABLE IF NOT EXISTS students_temp (roll INT PRIMARY KEY, name VARCHAR(30), per INT, city VARCHAR(30), email VARCHAR(50))");
	            st.execute("CREATE TABLE IF NOT EXISTS institute (roll INT, college VARCHAR(50))");
	            
	            
	            Statement st2 = con.createStatement();

	         /*   st2.executeUpdate("CREATE TABLE IF NOT EXISTS students_temp (" +
	                             "roll INT, " +
	                             "name VARCHAR(50), " +
	                             "per INT, " +
	                             "city VARCHAR(50), " +
	                             "email VARCHAR(50))");*/

	            // Insert records
	    //       st2.execute("INSERT INTO students_temp VALUES (1,'Alice',95,'Delhi','a@gmail.com')," +
	            st2.executeUpdate("INSERT IGNORE INTO students_temp VALUES (1, 'Alice', 95, 'Delhi', 'a@gmail.com'),"

	                                                                      + " (2,'Bob',87,'Mumbai','b@gmail.com')," +
	                                                                        "(3,'Cara',91,'Delhi','c@gmail.com')");
	   //         st2.execute("INSERT INTO institute VALUES (1,'ABC College'),(3,'XYZ College')");
	            
	         

	            // Print table
	            print("SELECT * FROM students_temp", con);
	            
	           

	            // Update table
	            st2.executeUpdate("UPDATE students_temp SET per=90 WHERE roll=2");

	            // Highest percentage student
	            print("SELECT * FROM students_temp WHERE per=(SELECT MAX(per) FROM students_temp)", con);

	            // Ascending order
	            print("SELECT * FROM students_temp ORDER BY name ASC", con);

	            // Same city
	            print("SELECT * FROM students_temp WHERE city='Delhi'", con);
	            
	            

	            // Add new column
	            st2.execute("ALTER TABLE students_temp ADD contact VARCHAR(15)");

	            // Modify column
	            st2.execute("ALTER TABLE students_temp MODIFY contact VARCHAR(20)");

	            // Rename table
	            st2.execute("RENAME TABLE students_temp TO students_backup");
	            st2.execute("RENAME TABLE students_backup TO students_temp"); // Restore

	            // Delete column
	            st2.execute("ALTER TABLE students_temp DROP contact");

	            // Delete one row
	            st2.execute("DELETE FROM students_temp WHERE roll=2");

	            // Delete all rows (keep table)
	            st2.execute("DELETE FROM students_temp");

	            // Drop table
	            st2.execute("DROP TABLE IF EXISTS students_temp");

	            // Inner Join (common records)
	            print("SELECT * FROM students_temp INNER JOIN institute USING(roll)", con);

	            // Left Join
	            print("SELECT * FROM students_temp LEFT JOIN institute USING(roll)", con);

	            // Right Join
	            print("SELECT * FROM students_temp RIGHT JOIN institute USING(roll)", con);

	            // Full Join (simulated)
	            print("(SELECT * FROM students_temp LEFT JOIN institute USING(roll)) " +
	                  "UNION " +
	                  "(SELECT * FROM students_temp RIGHT JOIN institute USING(roll))", con);

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    static void print(String query, Connection con) throws SQLException {
	        ResultSet rs = con.createStatement().executeQuery(query);
	        ResultSetMetaData rsmd = rs.getMetaData();
	        int cols = rsmd.getColumnCount();
	        System.out.println("\n" + query);
	        while (rs.next()) {
	            for (int i = 1; i <= cols; i++) {
	                System.out.print(rs.getString(i) + "\t");
	            }
	            System.out.println();
	        }
	        rs.close();
	        
	    }
	}

