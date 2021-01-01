package com.peng.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 执行sql执行的是preparedStatement:预编译
 * 		增加占位符
 * @author pfh
 * @date 2020年6月4日
 */
public class Demo06 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/data_01","root","root");
		
		//3.创建PreparedStatement类
		//如果有传递的参数,点位符(用?占位)的sql
		String sql = "select * from user1 where id = ?;";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, 1);
		
		//执行方法
		/*boolean bool = ps.execute();
		System.out.println(bool);*/
		ResultSet resultSet = ps.executeQuery();
		/*System.out.println(resultSet.next());
		resultSet.last();
		System.out.println(resultSet.next());*/
		while(resultSet.next()){
			System.out.println("id=" + resultSet.getInt(1) + ",\tname=" + resultSet.getString("name"));
		}
		
		
	}

}
