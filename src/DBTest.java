
import java.sql.Connection;
import java.sql.DriverManager;

public class DBTest {
    public static void main(String[] args) {
        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to MySQL
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/bhu_mess_management", // Your DB name
                "root",                                 // Your DB username
                "89321"                         // Your DB password
            );

            System.out.println("✅ Connected Successfully!");
            con.close();
        } catch (Exception e) {
            System.out.println("❌ Connection Failed:");
            e.printStackTrace();
        }
    }
}
