package com.peng.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.peng.model.User;

/**
 * 测试类:对用户表查询数据(使用mybatis框架)
 * @author pfh
 * @date 2020年6月8日
 */
public class UserTest {

	public static void main(String[] args) throws IOException {
		//1.通过resources查找全局mybatis配置文件,返回Inputstream
		InputStream is = Resources.getResourceAsStream("mappers\\mybatis.xml");
		//2.使用SqlSessionFactoryBuilder的工厂设计模式,返回SqlSessionFactory
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
		//3.生成SqlSession
		SqlSession ss = ssf.openSession();
		
		//4.找到mapper映射文件,找到sql方法,执行sql,相当于jdbc以前的PreparedStatement.executeQuery()
		List<User> lists = ss.selectList("com.peng.dao.UserDao.findUserAll");
		System.out.println("条数:" + lists.size());
		for (User user : lists) {
			System.out.println(user.toString());
		}
		//5.关闭资源
		ss.close();
	}

}
