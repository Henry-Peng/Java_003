package com.peng.simple;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.peng.utils.DBUtil2;
import com.peng.utils.User;

/**
 * 抓取表格信息放入map
 * @author pfh
 * @date 2020年6月9日
 */
public class GetInfoToJavaBean {
	static Connection connection = null;
	static PreparedStatement ps;
	static ResultSet resultSet;
	
	static List<User> list = new ArrayList<>();

	public static void main(String[] args) {
		String sql = "select * from user";//select * from user where id = ? 
		list = setUserOut(sql);// 每一个行数据放入一个数组中,多个数组放入list集合中
		System.out.println("数据的长度:" + list.size());
		for (User user : list) {
			System.out.println(user);
		}
	}
	
	public static List<User> setUserOut(String sql){
		User user = null;
		connection = DBUtil2.getConnection();
		try {
			ps = connection.prepareStatement(sql);
			resultSet = ps.executeQuery();
			while(resultSet.next()){
				/*user = new User(resultSet.getInt("id"),
						resultSet.getString("name"),
						resultSet.getInt("age"), 
						resultSet.getDate("createTime"),
						resultSet.getDate("updateTime"), 
						resultSet.getDate("lastTime"), 
						resultSet.getBlob("pic"));*/
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				int age = resultSet.getInt("age");
				Date createTime = resultSet.getDate("createTime");
				Date updateTime = resultSet.getDate("updateTime");
				Date lastTime = resultSet.getDate("lastTime");
				Blob pic = resultSet.getBlob("pic");
				
				user = new User(id, name, age, createTime, updateTime, lastTime, pic);
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
