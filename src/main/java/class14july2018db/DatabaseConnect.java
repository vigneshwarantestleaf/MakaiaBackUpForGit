package class14july2018db;

// import from sql
import java.sql.*;

public class DatabaseConnect {

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://13.126.237.187:3306/opentaps";

	// Database credentials
	static final String USER = "dbuser";
	static final String PASS = "test@123";

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;

		try {

			// STEP 2: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// STEP 3: Open a connection
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			stmt = conn.createStatement();

			String sql = "SELECT FIRST_NAME, LAST_NAME FROM OPENTAPS.PERSON WHERE PARTY_ID = 10286";
			ResultSet rs = stmt.executeQuery(sql);

			// STEP 5: Extract data from result set
			while (rs.next()) {

				// Retrieve by column name
				// int leadID = rs.getInt("PARTY_ID");
				String fName = rs.getString("FIRST_NAME");
				String lName = rs.getString("LAST_NAME");

				// Display values
				System.out.print("First Name : " + fName + ", Last Name: " + lName + "\n");

			}
			// STEP 6: Clean-up environment
			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException se) {

			// Handle errors for JDBC
			se.printStackTrace();

		} catch (Exception e) {

			// Handle errors for Class.forName
			e.printStackTrace();

		} finally {

			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}

			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

	}
}