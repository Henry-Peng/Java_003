package com.peng.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 执行sql执行的是preparedStatement:预编译
 * 		关闭资源,从里往外的关闭
 * @author pfh
 * @date 2020年6月4日
 */
public class Demo10_close {
	private static Connection connection = null;
	private static PreparedStatement ps = null;
	private static ResultSet resultSet = null;
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/data_01","root","root");
			
			//3.创建PreparedStatement类
			//如果有传递的参数,点位符(用?占位)的sql
			String sql = "select * from user1 u inner join role r on u.roleId = r.id_role;";
			ps = connection.prepareStatement(sql);
			
			
			//执行方法
			resultSet = ps.executeQuery( );
			
			while(resultSet.next()){
				System.out.println("name=" + resultSet.getString("name") + ",\tdept=" + resultSet.getString("dept") + ",\troleName=" + resultSet.getString("roleName") + ",\troleId=" + resultSet.getInt("roleId") + ",\troleId1=" + resultSet.getInt("roleId") );
			}
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {//关闭资源,先关resultSet->再关preparedStatement->Connection
			/*
			 * 不能将关闭资源放在一个代码块里,因为当statement出问题,connection也不会执行
			 */
			/*try {
				resultSet.close();//结果集可以不关闭,因为其随着statement自动关闭
				System.out.println("关闭resultSet成功");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			*/
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

}
