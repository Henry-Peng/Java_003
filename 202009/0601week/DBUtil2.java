package com.peng.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * 公共类:连接mysql,关闭资源
 * @author pfh
 * @date 2020年6月5日
 */
import java.util.Properties;
public class DBUtil2 {
	static Properties properties;//db.properties 内容要注意空格,下面识别时会造成错误
	
	static{//只需要执行一次,查找配置文件db.properties
		properties = new Properties();
		try {
			//加载文件
			//properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
			//properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("com\\peng\\utils\\db.properties"));//在包名称底下搜寻
			//properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("com/peng/utils/db.properties"));//在包名称底下搜寻
			properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("com/peng/utils/db.properties"));//可以复制限定路径名,再删除前面部分
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection(){
		Connection connection = null;
		try {
			Class.forName(properties.getProperty("mysqlDriver"));
			connection = DriverManager.getConnection(properties.getProperty("mysqlUrl") + properties.getProperty("mysqlDatabase"),properties.getProperty("mysqlUserName"),properties.getProperty("mysqlUserPassWord"));
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("DBUtil2.java错误");
			e.printStackTrace();
		} 
		return connection;
	}
	
	//查询的关闭资源操作,三个关闭
	public static void close(Connection connection, PreparedStatement ps, ResultSet resultSet) {
		try {
			if (resultSet != null) {
				resultSet.close();
				System.out.println("关闭resultSet成功");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if (ps != null) {
				ps.close();
				System.out.println("关闭ps成功");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if (connection != null) {
				connection.close();
				System.out.println("关闭connection成功");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 不返回结果集的关闭资源操作,2个关闭
	public static void close(Connection connection, PreparedStatement ps) {

		try {
			if (ps != null) {
				ps.close();
				System.out.println("关闭ps成功");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			if (connection != null) {
				connection.close();
				System.out.println("关闭connection成功");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
