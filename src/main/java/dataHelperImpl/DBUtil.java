package dataHelperImpl;

import java.sql.*;

public class DBUtil {
	
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/hbmsdatabase?useUnicode=true&characterEncoding=utf-8&useSSL=false";
	private static final String USER = "admin";
	private static final String PASSWORD = "admin";
	
	
	private static Connection connection = null;
	static{
		//1.加载驱动程序
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection= DriverManager.getConnection(URL,USER, PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//2.获得数据库连接
		
		
	}
	
	public static Connection getConnection() {
		return connection;
	}
	
	
}
