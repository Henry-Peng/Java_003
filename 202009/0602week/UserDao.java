package com.peng.dao;

import java.util.List;
import java.util.Map;

import com.peng.model.User;

/**
 * 用户类的接口类
 * @author pfh
 * @date 2020年6月8日
 */
public interface UserDao {
	/**
	 * 功能:查询所有的商品
	 */
	public List<User> findUserAll() ;

	/**
	 * 根据id查询一条信息,用User对象接收,javaBean方式
	 */
	public User findUserById() ;
	
	/**
	 * 统计信息条数
	 * @return
	 */
	public int getCount() ;
	
	/**
	 * 根据id查询一条信息,用Map集合接收
	 * 这一条信息座位Value值
	 */
	public Map<Integer, Object> findMap();
	
	/**
	 * 调入map集合,返回user对象
	 * @param map
	 * @return
	 */
	public User getUserByMap(Map<Integer, Object> map);
}
