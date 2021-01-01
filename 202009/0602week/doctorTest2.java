package com.peng.test;


import org.apache.ibatis.session.SqlSession;
import com.peng.model.Doctor;
import com.peng.utils.CommonDBUtil;

/**
 * 医生表查询测试
 * @author pfh
 * @date 2020年6月9日
 */
public class doctorTest2 {

	public static void main(String[] args) {
	SqlSession session = CommonDBUtil.getSqlSession();
	
	/*List<Doctor> doctors = session.selectList("com.peng.dao.DoctorDao.findAll");
	for (Doctor doctor : doctors) {
		System.out.println(doctor);
	}
	*/
/*	Doctor doctor = new Doctor();
	doctor.setDoctor("李医生");
	doctor.setLevel("普通医师");
	Doctor result = session.selectOne("com.peng.dao.DoctorDao.getDoctorByPara", doctor);
	System.out.println(result);*/
	
	
	Doctor result = session.selectOne("com.peng.dao.DoctorDao.getDoctorById", "SSD000113");//第二个参数是传递给映射文件sql语句的参数
	System.out.println(result);
	
	CommonDBUtil.close(session);

	}

}
