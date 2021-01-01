package com.peng.dao;
/**
 * 持久层:医生的接口类
 * @author pfh
 * @date 2020年6月9日
 */

import java.util.List;
import java.util.Map;

import com.peng.model.Doctor;

public interface DoctorDao {

	public List<Doctor> findAll();
	
	public Doctor getDoctorByPara();
	
	public Doctor getDoctorById(String doctorId);//void也可以,不加参数也可以,好像只有public和getDoctorById起作用
	
	public int saveDoctor(Doctor doctor);
	
	public int updateDoctor(Doctor doctor);
	
	public int deleteDoctorById(String doctorId);
	
	public List<Doctor> getDoctorPage(Map<String, Integer> pageMap);
	
}
