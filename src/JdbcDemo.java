import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcDemo {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/jdbc_1340?createIfNotExist=true";
        String username = System.getenv("DB_USER");
        String password = System.getenv("DB_PASSWORD");
        if (username == null || username.isBlank() || password == null || password.isBlank()) {
            throw new IllegalStateException("Set the DB_USER and DB_PASSWORD environment variables");
        }

        try {
            // Step 1: Establish database connection
            Connection con = DriverManager.getConnection(
                    url, username, password);

            System.out.println("MySQL Connected Successfully!");

            // Step 2: Create Statement
            Statement st = con.createStatement();

            // Step 3: Execute SQL query
            ResultSet rs = st.executeQuery(
                    "SELECT * FROM student");

            // Step 4: Process the result
            while (rs.next()) {

                int id = rs.getInt("id");
                String name = rs.getString("name");
                String city = rs.getString("city");

                System.out.println(
                        id + " | " + name + " | " + city);
            }

            // Step 5: Close resources
            rs.close();
            st.close();
            con.close();

            System.out.println("Connection Closed!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
