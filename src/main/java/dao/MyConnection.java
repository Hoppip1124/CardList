package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DB接続パラメータ設定、接続メソッドの設定
 */
public class MyConnection {
	
	private final static String URL = "MYSQL_JDBC_URL";
	
	private final static String NAME = "MYSQL_USER";
	
	private final static String PASSWORD = "MYSQL_PASSWORD";
	
	public static Connection getConnection() throws SQLException {
		
		return DriverManager.getConnection(URL, NAME, PASSWORD);
	
	}

}