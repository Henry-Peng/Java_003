package com.peng.simple;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;

import com.peng.utils.DBUtil;
import com.peng.utils.DBUtil2;

/**
 * 从mysql数据库中获得列表信息:优化代码
 * @author pfh
 * @date 2020年6月5日
 */
public class UserTest_time {
	public static Connection connection;//成员变量拥有默认值;相同类型的实例变量与static变量默认值是相同的。
	public static PreparedStatement ps;
	public static ResultSet resultSet;
	
	public static void main(String[] args) {
		/*String addUserName = "李浩然";
		System.out.println(addUser(addUserName) > 0 ? "添加 " + addUserName + " 成功":"添加 " + addUserName + " 失败");
		*/
		//addUserTime();
		//showUserList();
		getPicContext();
	}
	
	public static void getPicContext(){
		connection = DBUtil.getConnection("data86");
		InputStream iStream = null;
		OutputStream oStream = null;
		String sql = "select * from user where id = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, 30);
			resultSet = ps.executeQuery();
			while(resultSet.next()){
				Blob blob = resultSet.getBlob("pic");
				iStream = blob.getBinaryStream();
				
				oStream = new FileOutputStream("D:\\\\360用户文件\\\\img\\" + System.currentTimeMillis() + ".jpg");
				int buf = 0;
				while((buf = iStream.read()) != -1){
					oStream.write(buf);
				}
				oStream.close();
				iStream.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil2.close(connection, ps, resultSet);
		}
	}
	
	public static void addUserTime() {
		connection = DBUtil.getConnection("data86");
		String sql = "insert into user(name,age,createTime,updateTime,lastTime,pic) values(?,?,now(),?,?,?);";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, "小图片");
			ps.setInt(2, 18);
			ps.setTime(3, new Time(System.currentTimeMillis()));//此处的3指的是第三个问号
			ps.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
			try {
				ps.setBlob(5, new FileInputStream("D:\\360用户文件\\img/3.jpg"));
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();//使用try,catch,调用之后不必再添加抛出异常的语句
			}
			int addCount = ps.executeUpdate();
			System.out.println((addCount>0)? "添加成功":"添加失败");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil2.close(connection, ps);
		}
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
				System.out.println("id=" + resultSet.getInt(1) + ",name=" + resultSet.getString("name")
				+ ",creatTime=" + resultSet.getString("createTime")
				 + ",pic=" + resultSet.getBlob("pic"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil2.close(connection, ps, resultSet);
		}
		
	}

}
