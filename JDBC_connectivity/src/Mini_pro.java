import java.sql.*;
public class Mini_pro {

	public static void main(String[] args) {
		
		String url="jdbc:mysql://localhost:3306/python";
        String user= "root";
        String password="root";
        
        

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection(url, user, password);
                    System.out.println("Connection successful!");

                    findHighestPercentageStudents(con);
                    printStudentsAscendingOrder(con);

                    con.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            // ✅ 1. Find student(s) with highest percentage
            public static void findHighestPercentageStudents(Connection con) throws SQLException {
                String sql = "SELECT * FROM students WHERE per = (SELECT MAX(per) FROM students)";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                System.out.println("\nStudent(s) with Highest Percentage:");
                System.out.println("RollNo\tName\tPercentage\tEmail");
                while (rs.next()) {
                    int roll = rs.getInt("rollno");
                    String name = rs.getString("name");
                    int per = rs.getInt("per");
                    String email = rs.getString("email");
                    System.out.println(roll + "\t" + name + "\t" + per + "\t\t" + email);
                }

                rs.close();
                stmt.close();
            }

            // ✅ 2. Arrange and print students in ascending order (by name)
            public static void printStudentsAscendingOrder(Connection con) throws SQLException {
                String sql = "SELECT * FROM students ORDER BY name ASC";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                System.out.println("\nStudents in Ascending Order (by Name):");
                System.out.println("RollNo\tName\tPercentage\tEmail");
                while (rs.next()) {
                    int roll = rs.getInt("rollno");
                    String name = rs.getString("name");
                    int per = rs.getInt("per");
                    String email = rs.getString("email");
                    System.out.println(roll + "\t" + name + "\t" + per + "\t\t" + email);
                }

                rs.close();
                stmt.close();
            }
        

        
		
		


	}


