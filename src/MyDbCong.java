
import java.sql.Connection;
import java.sql.DriverManager;

public class MyDbCong {

	public static Connection getMySQLDbConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/ipl_1340?createDatabaseIfNotExist=true";
			String userName = System.getenv("DB_USER");
			String pass = System.getenv("DB_PASSWORD");
			if (userName == null || userName.isBlank() || pass == null || pass.isBlank()) {
				throw new IllegalStateException("Set the DB_USER and DB_PASSWORD environment variables");
			}
			Connection con = DriverManager.getConnection(url, userName, pass);
			return con;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
