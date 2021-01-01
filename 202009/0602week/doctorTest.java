package com.peng.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.peng.model.Doctor;

/**
 * 医生与病人测试
 * @author pfh
 * @date 2020年6月9日
 */
public class doctorTest {

	public static void main(String[] args) {
		
		try {
			//1.查找mybatis源配置文件
			InputStream config= Resources.getResourceAsStream("mybatis_config.xml");
			//2.工厂设计类构建
			SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(config);
			//3.打开会话
			SqlSession session = ssf.openSession();
			//4.调用方法,返回对象
			List<Doctor> doctors = session.selectList("com.peng.dao.DoctorDao.findAll");
			//5.关闭资源
			session.close();
			System.out.println(doctors);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
