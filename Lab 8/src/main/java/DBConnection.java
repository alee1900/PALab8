import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class DBConnection that manages the connection to the database
 */
public class DBConnection {
    private static DBConnection dbConnection = null;
    private static Connection connection;

    /**
     * Private constructor
     */
    private DBConnection() {
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String user = "student";
        String pass = "student";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to create instance of DBConnection
     * @return the connection
     */
    public static Connection getConnection() {
        if (dbConnection == null) {
            dbConnection = new DBConnection();
        }
        return connection;
    }
}
