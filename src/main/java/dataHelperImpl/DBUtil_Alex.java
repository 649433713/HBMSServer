package dataHelperImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by alex on 12/4/16.
 */
public class DBUtil_Alex {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/hbmsdatabase?useUnicode=true&characterEncoding=utf-8&useSSL=true";
    private static final String NAME="root";
    private static final String PASSWORD="818818";
    private static Connection connection = null;
    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection(URL,NAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public static Connection getConnection() {
        return connection;
    }
    
}
