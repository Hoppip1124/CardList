package dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * DB接続パラメータ設定、接続メソッドの設定
 */
public class MyConnection {
	
	public static Connection getConnection() throws SQLException {
		
		Connection connection = null;
		
		try (InputStream input = MyConnection.class.getClassLoader().getResourceAsStream("connection.properties")) {
			
			Properties prop = new Properties();
			
			if (input == null) {
				System.out.println("NO FIND connection.properties");
				return null;
			}
			
			prop.load(input);
			
			//接続設定の読み込み
			String url = prop.getProperty("URL");
			String name = prop.getProperty("NAME");
			String password = prop.getProperty("PASSWORD");
			
			connection = DriverManager.getConnection(url, name, password);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return connection;
	
	}

}