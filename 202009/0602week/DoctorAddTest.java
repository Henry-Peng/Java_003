package com.peng.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.peng.model.Doctor;
import com.peng.utils.CommonDBUtil;

/**
 * 测试添加,修改,删除
 * @author pfh
 * @date 2020年6月9日
 */
public class DoctorAddTest {
	private static Logger logger = Logger.getLogger(DoctorAddTest.class);

	public static void main(String[] args) {
		SqlSession session = CommonDBUtil.getSqlSession();
		logger.info("进入DoctorAddTest类方法...");
		
		//addDoctor(session);
		//deleteDoctorById(session);
		updateDoctor(session);
		findDoctorAll(session);
		//增加事务提交方式
		session.commit();
		
		/**
		 * 如果出现异常,使用session.rollback回滚事务,写在finally块里
		 */
		logger.info("方法执行完毕");

	}
	public static void deleteDoctorById(SqlSession session){
		int num = session.delete("com.peng.dao.DoctorDao.deleteDoctorById", "SSD228573");
		System.out.println((num>0)? "删除"+"SSD228573"+"成功":"删除"+"SSD228573"+"失败");
	}
	
	
	public static void findDoctorAll(SqlSession session){
		List<Doctor> doctors = session.selectList("com.peng.dao.DoctorDao.findAll");
		for (Doctor doctor : doctors) {
			System.out.println(doctor);
		}
	}
	
	public static void updateDoctor(SqlSession session){
		Doctor doctor = new Doctor();
		doctor.setBeGoodAt("呼吸科疑难杂症");
		doctor.setDoctor("王医生");
		doctor.setWorkAge(10);
		int num = session.update("com.peng.dao.DoctorDao.updateDoctor", doctor);
		System.out.println((num>0)? "修改"+doctor.getDoctor()+"成功":"修改"+doctor.getDoctor()+"失败");
	}
	
	public static void addDoctor(SqlSession session){
		//添加
		Doctor doctor = new Doctor("SSD0331287", "刘医生", "普通医师", "呼吸科各种疑难杂症", "DDSS6660001", 22, 12);
		int num = session.insert("com.peng.dao.DoctorDao.saveDoctor", doctor);
		System.out.println(num);
	}

}
