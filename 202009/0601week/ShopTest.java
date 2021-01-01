package com.peng.simple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.peng.utils.DBUtil2;

/**
 * 从mysql数据库中获得列表信息:优化代码
 * @author pfh
 * @date 2020年6月5日
 */
public class ShopTest {
	public static Connection connection;//成员变量拥有默认值;相同类型的实例变量与static变量默认值是相同的。
	public static PreparedStatement ps;
	public static ResultSet resultSet;
	
	public static void main(String[] args) {
		String addUserName = "李浩然";
		System.out.println(addUser(addUserName) > 0 ? "添加 " + addUserName + " 成功":"添加 " + addUserName + " 失败");
		showUserList();
	}
	
	public static int addUser(String addUserName) {
		int addNum = 0;
		connection = DBUtil2.getConnection();
		String sql = "insert into user(name) values(?);";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, addUserName);
			addNum = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil2.close(connection, ps);
		}
		return addNum;
	}
	
	public static void showUserList() {
		connection = DBUtil2.getConnection();
		String sql = "select * from user;";
		
		try {
			ps = connection.prepareStatement(sql);
			resultSet = ps.executeQuery();
			while(resultSet.next()){
				System.out.println("id=" + resultSet.getInt(1) + ",name=" + resultSet.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil2.close(connection, ps, resultSet);
		}
		
	}

}
