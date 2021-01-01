package com.peng.utils;
/**
 * 用户类
 * @author pfh
 * @date 2020年6月8日
 */

import java.sql.Blob;
import java.util.Date;

public class User {
	private  int id;
	private  String name;
	private  int age;
	private  Date createTime;
	private  Date updateTime;
	private  Date lastTime;
	private  Blob pic;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	public Date getLastTime() {
		return lastTime;
	}
	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}
	public Blob getPic() {
		return pic;
	}
	public void setPic(Blob pic) {
		this.pic = pic;
	}
	public User() {
	}
	public User(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public User(int id, String name, int age, Date createTime, Date updateTime, Date lastTime, Blob pic) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.lastTime = lastTime;
		this.pic = pic;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + ", createTime=" + createTime + ", updateTime="
				+ updateTime + ", lastTime=" + lastTime + ", pic=" + pic + "]";
	}
}
