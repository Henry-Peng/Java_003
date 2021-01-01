package com.peng.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.peng.model.Doctor;
import com.peng.utils.CommonDBUtil;

/**
 * 分页类
 * @author pfh
 * @date 2020年6月10日
 */
public class DoctorPageTest {

	public static void main(String[] args) {
		SqlSession session = CommonDBUtil.getSqlSession();
		
		//分页,返回多条数据,接口类返回接收使用list<JavaBean类>
		Map<String, Integer> pageMap = new HashMap<>();
		//传递的当前页码
		int pageNum = 1;//当前页码
		int pageSize = 2;//每页传递的条数
		pageMap.put("pageStart", (pageNum-1) * pageSize);
		pageMap.put("pageSize", pageSize);
		
		List<Doctor> doctors = session.selectList("com.peng.dao.DoctorDao.getDoctorPage", pageMap);
		for (Doctor doctor : doctors) {
			System.out.println(doctor);
		}
		
	}

}
