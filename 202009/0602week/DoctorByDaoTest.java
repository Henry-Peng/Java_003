package com.peng.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.peng.dao.DoctorDao;
import com.peng.model.Doctor;
import com.peng.utils.CommonDBUtil;

/**
 * 接口绑定:
 * 		以接口类写入名称,返回接口类,调用接口类的方法,让其一一对应映射文件XXmapper.XML的id的方法
 * @author pfh
 * @date 2020年6月10日
 */
public class DoctorByDaoTest {

	public static void main(String[] args) {
		SqlSession session = CommonDBUtil.getSqlSession();
		DoctorDao doctorDao = session.getMapper(DoctorDao.class);

		//调用分页
		getDoctorPage(doctorDao);
		
		//添加成员
		addDoctorMember(doctorDao);
		
		//查询成员
		findAllMember(doctorDao);
		
		session.commit();//添加,修改,删除都需要commit
		session.close();
		
	}
	
	private static void findAllMember(DoctorDao doctorDao) {
		List<Doctor> doctors = doctorDao.findAll();
		for (Doctor doctor : doctors) {
			System.out.println(doctor);
		}
	}

	public static void getDoctorPage(DoctorDao doctorDao) {
		Map<String, Integer> pageMap = new HashMap<>();
		int pageNum = 1;//当前页码
		int pageSize = 2;//每页传递的条数
		pageMap.put("pageStart", (pageNum-1) * pageSize);
		pageMap.put("pageSize", pageSize);
		List<Doctor> doctors = doctorDao.getDoctorPage(pageMap);//session.selectList("com.peng.dao.DoctorDao.getDoctorPage", pageMap);
		for (Doctor doctor : doctors) {
			System.out.println(doctor);
		}
	}
	
	public static void addDoctorMember(DoctorDao doctorDao) {
		Doctor doctor = new Doctor("SSD03753", "华升医生", "普通医师", "呼吸科各种疑难杂症", "DDSS6660001", 22, 12);
		int num = doctorDao.saveDoctor(doctor);
		System.out.println(num);
	}
	
}
