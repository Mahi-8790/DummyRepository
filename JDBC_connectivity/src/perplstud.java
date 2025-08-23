import java.sql.*;
public class perplstud {

	
		        // Update these constants with your MySQL info
		        final String url = "jdbc:mysql://localhost:3306/java";
		        final String user = "root";
		        final String password = "password";{
		        
		        try (Connection conn = DriverManager.getConnection(url, user, password);
		             Statement stmt = conn.createStatement()) {

		            // 1. Create Student table
		            stmt.executeUpdate("DROP TABLE IF EXISTS Student3");
		            stmt.executeUpdate("CREATE TABLE Student3 (id INT PRIMARY KEY, name VARCHAR(100), city VARCHAR(50), percentage FLOAT, institute_id INT)");

		            // 2. Insert records
		            stmt.executeUpdate("INSERT INTO Student3 VALUES (1, 'Alice', 'Delhi', 85.3, 101)");
		            stmt.executeUpdate("INSERT INTO Student3 VALUES (2, 'Bob', 'Mumbai', 92.0, 102)");
		            stmt.executeUpdate("INSERT INTO Student3 VALUES (3, 'Charlie', 'Delhi', 92.0, 101)");
		            stmt.executeUpdate("INSERT INTO Student3 VALUES (4, 'David', 'Kolkata', 77.5, 103)");
		            stmt.executeUpdate("INSERT INTO Student3 VALUES (5, 'Eva', 'Mumbai', 66.5, NULL)");

		            // 3. Print table
		            System.out.println("-- All Students --");
		            ResultSet rs = stmt.executeQuery("SELECT * FROM Student3");
		            while (rs.next())
		                System.out.println(rs.getInt("id") + ", " + rs.getString("name") + ", " + rs.getString("city") + ", " + rs.getFloat("percentage") + ", " + rs.getInt("institute_id"));
		            rs.close();

		            // 4. Update table
		            stmt.executeUpdate("UPDATE Student3 SET percentage=88.8 WHERE name='David'");

		            // 5. Highest percentage student(s)
		            System.out.println("-- Highest Percentage Students --");
		            rs = stmt.executeQuery("SELECT * FROM Student3 WHERE percentage = (SELECT MAX(percentage) FROM Student)");
		            while (rs.next())
		                System.out.println(rs.getString("name") + ": " + rs.getFloat("percentage"));
		            rs.close();

		            // 6. Arrange records in ascending order
		            System.out.println("-- Sorted by Percentage ASC --");
		            rs = stmt.executeQuery("SELECT * FROM Student3 ORDER BY percentage ASC");
		            while (rs.next())
		                System.out.println(rs.getString("name") + ": " + rs.getFloat("percentage"));
		            rs.close();

		            // 7. Students from same city
		            System.out.println("-- Students From The Same City --");
		            rs = stmt.executeQuery("SELECT city, GROUP_CONCAT(name) AS students FROM Student3 GROUP BY city HAVING COUNT(*) > 1");
		            while (rs.next())
		                System.out.println(rs.getString("city") + ": " + rs.getString("students"));
		            rs.close();

		            // 8. Add new column
		            stmt.executeUpdate("ALTER TABLE Student3 ADD COLUMN email VARCHAR(100)");

		            // 9. Modify column datatype
		            stmt.executeUpdate("ALTER TABLE Student3 MODIFY COLUMN percentage DOUBLE");

		            // 10. Change the name of table
		            stmt.executeUpdate("ALTER TABLE Student3 RENAME TO Students");

		            // 11. Delete column
		            stmt.executeUpdate("ALTER TABLE Students DROP COLUMN email");

		            // 12. Delete a single row
		            stmt.executeUpdate("DELETE FROM Students WHERE id = 5");

		            // 13. Delete all records without affecting table
		            stmt.executeUpdate("DELETE FROM Students");

		            // (Re-insert students for join operations)
		            stmt.executeUpdate("INSERT INTO Students VALUES (1, 'Alice', 'Delhi', 85.3, 101)");
		            stmt.executeUpdate("INSERT INTO Students VALUES (2, 'Bob', 'Mumbai', 92.0, 102)");
		            stmt.executeUpdate("INSERT INTO Students VALUES (3, 'Charlie', 'Delhi', 92.0, 101)");
		            stmt.executeUpdate("INSERT INTO Students VALUES (4, 'David', 'Kolkata', 88.8, 103)");

		            // 14. Delete entire table
		            // stmt.executeUpdate("DROP TABLE Students"); // Uncomment to delete the table at the end

		            // Create Institute table for join operations
		            stmt.executeUpdate("DROP TABLE IF EXISTS Institute");
		            stmt.executeUpdate("CREATE TABLE Institute (institute_id INT PRIMARY KEY, name VARCHAR(100), city VARCHAR(100))");
		            stmt.executeUpdate("INSERT INTO Institute VALUES (101, 'IIT Delhi', 'Delhi')");
		            stmt.executeUpdate("INSERT INTO Institute VALUES (102, 'IIT Mumbai', 'Mumbai')");
		            stmt.executeUpdate("INSERT INTO Institute VALUES (104, 'IIT Hyderabad', 'Hyderabad')");

		            System.out.println("-- INNER JOIN (Only common records) --");
		            rs = stmt.executeQuery("SELECT s.*, i.name AS institute_name FROM Students s INNER JOIN Institute i ON s.institute_id = i.institute_id");
		            while (rs.next())
		                System.out.println(rs.getString("name") + " | " + rs.getString("institute_name"));
		            rs.close();

		            System.out.println("-- LEFT JOIN (All students) --");
		            rs = stmt.executeQuery("SELECT s.*, i.name AS institute_name FROM Students s LEFT JOIN Institute i ON s.institute_id = i.institute_id");
		            while (rs.next())
		                System.out.println(rs.getString("name") + " | " + rs.getString("institute_name"));
		            rs.close();

		            System.out.println("-- RIGHT JOIN (All institutes) --");
		            rs = stmt.executeQuery("SELECT s.name, i.name AS institute_name FROM Students s RIGHT JOIN Institute i ON s.institute_id = i.institute_id");
		            while (rs.next())
		                System.out.println(rs.getString("name") + " | " + rs.getString("institute_name"));
		            rs.close();

		            System.out.println("-- FULL OUTER JOIN (All records) --");
		            // Since MySQL doesn't support FULL OUTER JOIN, use UNION
		            rs = stmt.executeQuery(
		                "SELECT s.id, s.name AS student3_name, i.name AS institute_name " +
		                "FROM Students s LEFT JOIN Institute i ON s.institute_id = i.institute_id " +
		                "UNION " +
		                "SELECT s.id, s.name AS student3_name, i.name AS institute_name " +
		                "FROM Students s RIGHT JOIN Institute i ON s.institute_id = i.institute_id"
		            );
		            while (rs.next())
		                System.out.println(rs.getString("student3_name") + " | " + rs.getString("institute_name"));
		            rs.close();

		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		


	}


