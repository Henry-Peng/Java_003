package com.peng.test;

import java.util.ArrayList;
import java.util.List;


import org.apache.ibatis.session.SqlSession;

import com.peng.dao.ShopDao;
import com.peng.model.Shop;
import com.peng.utils.CommonDBUtil;

/**
 * 动态Sql方法:
 * 		1). if
 * @author pfh
 * @date 2020年6月10日
 */
public class ShopSqlTest {

	public static void main(String[] args) {
		doIfSqlXml();
	}
	
	public static void doIfSqlXml() {
		SqlSession session = CommonDBUtil.getSqlSession();
		ShopDao shopDao = session.getMapper(ShopDao.class);
		
		//if,where,when,choose,otherwise
		Shop shop = new Shop(13, "硬盘", "希捷", 6, "存储器");
		shop.setName("硬盘");
		//shop.setName("%显%");
		//shop.setName("");
		/*List<Shop> shops = shopDao.getChooseSql(shop);
		for (Shop s : shops) {
			System.out.println(s);
		}*/
		
		//set,update
		/*int num = shopDao.updateBySetSql(shop);
		System.out.println(num);
		*/
		//in,foreach,list
		List<Integer> lists = new ArrayList<>();
		lists.add(1);
		lists.add(3);
		lists.add(5);
		//System.out.println(lists);
		/*List<Shop> shops2 = shopDao.getListForeachSql(lists);
		for (Shop shop2 : shops2) {
			System.out.println(shop2);
		}*/
		
		//array
		String[] arrays = {"硬盘","显示屏"};
		List<Shop> shops3 = shopDao.getListForArraySql(arrays);
		for (Shop shop3 : shops3) {
			System.out.println(shop3);
		}
		
		session.commit();
		session.close();
		
	}

}
