package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    
    private static String URL = "localhost:5432";
    private static String USER = "postgres";
    private static String PASS = "12321";

    public static Connection conectar() throws SQLException{
        return DriverManager.getConnection(URL, USER, PASS);
    }

}
