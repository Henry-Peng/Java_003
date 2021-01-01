package com.peng.dao;
/**
 * 商品类的接口类
 * @author pfh
 * @date 2020年6月10日
 */

import java.util.List;
import java.util.Map;

import com.peng.model.Shop;

public interface ShopDao {
	
	public List<Shop> getList(Shop shop);
	
	public List<Shop> getListByWhereSql(Shop shop);
	
	public List<Shop> getChooseSql(Shop shop);
	
	public int updateBySetSql(Shop shop);
	
	public List<Shop> getListForeachSql(List<Integer> lists);
	
	public List<Shop> getListForArraySql(String[] arrays);
	
	public List<Map<String, Object>> getDoubleList();
	
}
