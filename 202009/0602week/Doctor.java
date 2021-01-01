package com.peng.model;
/**
 * 医生类
 * @author pfh
 * @date 2020年6月9日
 */
public class Doctor {

	private String doctorId;
	private String doctor;
	private String level;
	private String beGoodAt;
	private String hospital_id;
	private int workAge;
	private int office_id;
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Doctor(String doctorId, String doctor, String level, String beGoodAt, String hospital_id, int workAge,
			int office_id) {
		super();
		this.doctorId = doctorId;
		this.doctor = doctor;
		this.level = level;
		this.beGoodAt = beGoodAt;
		this.hospital_id = hospital_id;
		this.workAge = workAge;
		this.office_id = office_id;
	}
	public String getdoctorId() {
		return doctorId;
	}
	public void setdoctorId(String doctorId) {
		this.doctorId = doctorId;
	}
	public String getDoctor() {
		return doctor;
	}
	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getBeGoodAt() {
		return beGoodAt;
	}
	public void setBeGoodAt(String beGoodAt) {
		this.beGoodAt = beGoodAt;
	}
	public String getHospital_id() {
		return hospital_id;
	}
	public void setHospital_id(String hospital_id) {
		this.hospital_id = hospital_id;
	}
	public int getWorkAge() {
		return workAge;
	}
	public void setWorkAge(int workAge) {
		this.workAge = workAge;
	}
	public int getOffice_id() {
		return office_id;
	}
	public void setOffice_id(int office_id) {
		this.office_id = office_id;
	}
	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", doctor=" + doctor + ", level=" + level + ", beGoodAt=" + beGoodAt
				+ ", hospital_id=" + hospital_id + ", workAge=" + workAge + ", office_id=" + office_id + "]";
	}
	
	
	
}
