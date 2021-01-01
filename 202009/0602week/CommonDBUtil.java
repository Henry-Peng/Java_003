package com.peng.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class CommonDBUtil {

	public static SqlSession getSqlSession() {
		SqlSession session = null;
		try {
			//1.查找mybatis源配置文件
			InputStream config= Resources.getResourceAsStream("mybatis_config.xml");
			//2.工厂设计类构建
			SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(config);
			//3.打开会话
			session = ssf.openSession();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return session;
	}
	
	//关闭session
	public static void close(SqlSession session) {
		if (session != null) {
			session.close();
		}
	}
	
	

}
