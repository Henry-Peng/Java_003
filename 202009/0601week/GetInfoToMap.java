package com.peng.simple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.peng.utils.DBUtil2;

/**
 * 抓取表格信息放入map
 * @author pfh
 * @date 2020年6月9日
 */
public class GetInfoToMap {
	static Connection connection = null;
	static PreparedStatement ps;
	static ResultSet resultSet;
	
	static List<Map<String, Object>> list = new ArrayList<>();

	public static void main(String[] args) {
		String sql = "select * from user";//select * from user where id = ? 
		list = setMapOut(sql);// 每一个行数据放入一个数组中,多个数组放入list集合中
		System.out.println("数据的长度:" + list.size());
		for (Map<String, Object> user : list) {
			System.out.println(user);
		}
	}

	public static List<Map<String, Object>> setMapOut(String sql) {
		connection = DBUtil2.getConnection();
		try {
			ps = connection.prepareStatement(sql);
			//ps.setInt(1, 1);;
			resultSet = ps.executeQuery();
			while (resultSet.next()) {// 每次得到一条行数据
				Map<String, Object> user = new HashMap<>();
				user.put("id", resultSet.getObject("id"));
				user.put("name", resultSet.getObject("name"));
				user.put("age", resultSet.getObject("age"));
				list.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil2.close(connection, ps, resultSet);
		}
		return list;
	}

}
