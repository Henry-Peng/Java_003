package com.peng.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * mysql连接与关闭资源
 * 		抽取公共代码,优化方法(方便调用)
 * @author pfh
 * @date 2020年6月4日
 */
public class DBUtil {

	public static Connection getConnection(String dataBaseName){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dataBaseName, "root", "root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	//关闭资源,先关resultSet->再关preparedStatement->Connection
	//关闭1:Connection
	public static void close(Connection connection) {
		try {
			if (connection != null) {
				connection.close();
				System.out.println("关闭connection成功");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//关闭2:PreparedStatement
	public static void close(PreparedStatement ps) {
		try {
			if (ps != null) {
				ps.close();
				System.out.println("关闭ps成功");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//关闭3:ResultSet
	public static void close(ResultSet resultSet) {
		try {
			if (resultSet != null) {
				resultSet.close();
				System.out.println("关闭resultSet成功");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
