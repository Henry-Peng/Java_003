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
public class Demo09_innerjoin {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping","root","root");
		
		//3.创建PreparedStatement类
		//如果有传递的参数,点位符(用?占位)的sql
		String sql = "select *, r.roleId rId  from user1 u inner join role r on u.roleId = r.id_role;";
		PreparedStatement ps = connection.prepareStatement(sql);
		//执行方法
		ResultSet resultSet = ps.executeQuery();
		while(resultSet.next()){
			System.out.println("name=" + resultSet.getString("name") + ",\tdept=" + resultSet.getString("dept") + ",\troleName=" + resultSet.getString("roleName") + ",\troleId=" + resultSet.getInt("roleId") + ",\troleId1=" + resultSet.getInt("rId") );
		}
		
		
	}

}
