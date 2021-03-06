package com.peng.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 执行sql执行的是preparedStatement:预编译
 * 		占位符,安全性
 * @author pfh
 * @date 2020年6月4日
 */
public class Demo08 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping","root","root");
		
		//3.创建PreparedStatement类
		//如果有传递的参数,点位符(用?占位)的sql
		String sql = "insert into user1(name,dept,salary) values(?,?,?);";
		PreparedStatement ps = connection.prepareStatement(sql);
		
		//安全性能比较
		//ps.setInt(1, 1);
		ps.setString(1, "蒋");
		ps.setString(2, "C组");
		ps.setDouble(3, 8888);
		
		//执行方法
		int bool = ps.executeUpdate();
		System.out.println(bool);
		
	}

}
