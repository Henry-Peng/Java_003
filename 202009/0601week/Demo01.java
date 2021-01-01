package com.peng.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 测试连接mysql:返回connecton接口
 * @author pfh
 * @date 2020年6月2日
 */
public class Demo01 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 1.写入连接不同数据库的驱动包的包名称
		Class.forName("com.mysql.jdbc.Driver");//奇怪,注掉也能用,注掉之后连接使用时间会加长
		
		long startTime = System.currentTimeMillis();
		System.out.println();
		
		
		//2.把三个参数发送给mysql
		Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.249.101:3306/data_01", "root", "root");//192.168.249.101
		System.out.println("连接Connection:" + connection);
		
		
		
		long endTime = System.currentTimeMillis();
		System.out.println("连接使用时间:" + (endTime-startTime)/1000 + "s");
	}

}
