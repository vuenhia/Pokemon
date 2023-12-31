package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtility {
    public static final int TIMEOUT = 30;

    private static final String CONNECTION = "jdbc:sqlite:person.db";
    private static final String DRIVER_NAME = "org.sqlite.JDBC";

    public static Connection createConnection() throws ClassNotFoundException, SQLException {
        // register the driver
        // load class in
        Class.forName(DRIVER_NAME);

        return DriverManager.getConnection(CONNECTION);
    }

    public static void closeConnections(final Connection connection, final Statement statement) {
        try {
            if (null != connection) {
                connection.close();
            }
            if (null != statement) {
                statement.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}