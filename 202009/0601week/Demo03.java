package com.peng.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 测试连接mysql:返回connecton接口,执行sql语句[通connection的对象名称获得声明类]
 * sql注入:引起不安全的因素 or 1=1;(永远成立)
 * @author pfh
 * @date 2020年6月2日
 */
public class Demo03 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 1.写入连接不同数据库的驱动包的包名称
		Class.forName("com.mysql.jdbc.Driver");//奇怪,注掉也能用,注掉之后连接使用时间会加长
		
		long startTime = System.currentTimeMillis();
		//System.out.println();
		
		
		//2.把三个参数发送给mysql
		Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.249.101:3306/data_01", "root", "root");//192.168.249.101
		//System.out.println("连接Connection:" + connection);
		
		//3.创建声明的接口类
		Statement statement = connection.createStatement();
		
		/**
		 * 4.执行sql
		 */
		/*//String sql = "select * from user1";
		//String sql = "insert into taobao values(10,'网卡','千兆');";
		String sql = " show index from user1;";
		//String sql = "update taobao set brand = '九州风神' where name = '散热器';";
		String sql1 = " show index from user1;";
		String sql2 = " update taobao set brand = '九州风神' where name = '散热器';";
		String sql3 = " update taobao set brand = '西部数据' where name = '硬盘2';";
		String sql4 = " update user1 set time_date = now();";
		
		boolean result = statement.execute(sql);//execute():执行语句返回resultSet的结果为true;
		System.out.println("执行execute结果:" + result);
		statement.execute(sql1);
		System.out.println("执行execute结果:" + statement.getResultSet());//返回上一次执行的resultSet
		System.out.println("执行execute结果:" + statement.getResultSet().next());//针对查询的ResultSet,如果有内容,则为true
		statement.execute(sql2);
		System.out.println("getUpdateCount:"+ statement.getUpdateCount() );//统计上一次execute(sql),增加,删除,修改数据的条数
		statement.execute(sql3);
		System.out.println("getUpdateCount:"+ statement.getUpdateCount() );//如果是修改语句,但是没有修改数据,就为0;如果不是变动语句,只是查询,返回一个ResultSet,结果为-1
		statement.execute(sql4);
		statement.execute(sql2);
		System.out.println("getUpdateCount:"+ statement.getUpdateCount() );
		statement.execute(sql4);
		System.out.println("getUpdateCount:"+ statement.getUpdateCount() );
		System.out.println("执行execute结果:" + statement.getResultSet());//返回上一次执行的resultSet,没有则为null,此时不可以.next();
		*/
		System.out.println("****************************");
		String s1 = "update test_id set name = 'sss' where id = 1";
		statement.execute(s1);
		System.out.println("getUpdateCount:"+ statement.getUpdateCount());
		String s2 = "delete from test_id where id = 1";
		statement.execute(s2);
		System.out.println("getUpdateCount:"+ statement.getUpdateCount());
		String s3 = s2 + " or 1=1;";//or 1=1永远成立,尽管id!=1 但仍然选中全部全部删除;,不安全
		statement.execute(s3);
		System.out.println("getUpdateCount:"+ statement.getUpdateCount());
		
		//5.返回
		
		long endTime = System.currentTimeMillis();
		System.out.println("连接使用时间:" + (endTime-startTime)/1000 + "s");
	}

}
