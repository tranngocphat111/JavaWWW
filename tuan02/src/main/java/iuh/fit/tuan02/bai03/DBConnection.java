package iuh.fit.tuan02.bai03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String JDBC_URL =
            "jdbc:mariadb://localhost:3306/uploadfileservletdb";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "sapassword";
    static {
        try {

            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws
            SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER,
                JDBC_PASSWORD);
    }
}
