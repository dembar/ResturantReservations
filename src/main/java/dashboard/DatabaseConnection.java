package dashboard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // Database URL, Username, and Password
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/single_restaurant_booking";
    private static final String JDBC_USER = "root";  // replace with your MySQL username
    private static final String JDBC_PASSWORD = "password";  // replace with your MySQL password

    // Method to establish and return the database connection
    public static Connection getConnection() throws SQLException {
        try {
            // Register the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Return the connection
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }
}
