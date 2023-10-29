package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtil {
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	private JdbcUtil() {
		
	}
	public static Connection getJdbcConnection() throws SQLException, IOException { 
//		FileInputStream fis=new FileInputStream("src\\properties\\db.properties");
//		Properties properties=new Properties(); 
//		properties.load(fis);
//		String url=properties.getProperty("url");
//		String username=properties.getProperty("username");
//		String password=properties.getProperty("password");
//		System.out.println(url);
//		System.out.println(username);
//		System.out.println(password);
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/university","root","root123");
		return conn;

	}	
}


