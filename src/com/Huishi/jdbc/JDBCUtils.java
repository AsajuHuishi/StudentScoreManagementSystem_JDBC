package com.Huishi.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.print.DocFlavor.STRING;

import sun.security.util.Password;

/**
 * 功能：封装数据库的连接与关闭。
 * @author AsajuHuishi
 *
 */
public class JDBCUtils {
	private static String user;
	private static String password;
	private static String url;
	private static String driver;
	static{
		try { 
			Properties properties = new Properties();
			properties.load(new FileInputStream("src\\jdbc.properties"));
			user = properties.getProperty("user");
			password = properties.getProperty("password");
			url = properties.getProperty("url");
			driver = properties.getProperty("driver");
			Class.forName(driver);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 建立连接
	 * @return
	 * @throws Exception
	 */
	public static Connection getConnection() throws Exception {
		Connection connection = DriverManager.getConnection(url, user, password);
		return connection;
	}
	/**
	 * 关闭
	 * @param set
	 * @param preparedStatement
	 * @param connection
	 * @throws SQLException
	 */
	public static void close(ResultSet set, Statement statement, Connection connection){//通用
		try {
			if (set != null) {
				set.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			} 
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
}
