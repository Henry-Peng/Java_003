package com.peng.simple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.peng.utils.DBUtil2;

/**
 * 抓取表格信息放入数组
 * @author pfh
 * @date 2020年6月8日
 */
public class GetInfoToArray {
	static Connection connection = null;
	static PreparedStatement ps;
	static ResultSet resultSet;

	public static void main(String[] args) {
		String sql = "select * from user";
		List<Object[]> list = setArrayOut(sql);//每一个行数据放入一个数组中,多个数组放入list集合中
		/*System.out.println(list.get(0)[0]);
		System.out.println(list.get(0)[1]);*/
		for (Object[] objects : list) {
			System.out.println(objects[0] + "," + objects[1]);
		}
	}
	
	public static List<Object[]> setArrayOut(String sql) {
		List<Object[]> array = new ArrayList<>();
		connection = DBUtil2.getConnection();
		try {
			ps = connection.prepareStatement(sql);
			resultSet = ps.executeQuery();
			while(resultSet.next()){//每次得到一条行数据
				Object[] objects = new Object[5];
				objects[0] = resultSet.getObject("id");
				objects[1] = resultSet.getObject("name");
				array.add(objects);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil2.close(connection, ps, resultSet);
		}
		return array;
	}

}
