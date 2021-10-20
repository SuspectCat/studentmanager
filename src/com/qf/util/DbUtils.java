package com.qf.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DbUtils {
	
	private static Properties p = new Properties();
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	
	
	static {
	
		try {
			//可以使用当前线程读取文件
			//获取当前线程的类加载器
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			
			InputStream is = loader.getResourceAsStream("db.properties");
			p.load(is);
			
			driver = p.getProperty("jdbc.driver");
			url = p.getProperty("jdbc.url");
			user = p.getProperty("jdbc.user");
			password = p.getProperty("jdbc.password");
			
			Class.forName(driver);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static Statement getStatement(Connection conn) {
		Statement stm = null;
		try {
			stm = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stm;
	}
	
	
	public static PreparedStatement getPreparedStatement(Connection conn, String sql) {
		PreparedStatement stm = null;
		try {
			stm = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stm;
	}
	
	public static void close(Connection conn, Statement stm, ResultSet rs) {
		try {
			if(rs != null) {
				rs.close();
			}
			if(stm != null) {
				stm.close();
			}
			if(conn != null) {
				conn.close();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
