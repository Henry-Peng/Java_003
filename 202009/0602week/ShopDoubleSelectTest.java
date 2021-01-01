package com.peng.test;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.peng.dao.ShopDao;
import com.peng.utils.CommonDBUtil;

/**
 * 商品类,两表查询
 * @author pfh
 * @date 2020年6月11日
 */
public class ShopDoubleSelectTest {

	public static void main(String[] args) {
		SqlSession session = CommonDBUtil.getSqlSession();
		ShopDao shopDao = session.getMapper(ShopDao.class);
		List<Map<String, Object>> shops = shopDao.getDoubleList();
		for (Map<String, Object> map : shops) {
			for (String key : map.keySet()) {
				System.out.print(key + ":" + map.get(key));
			}
			System.out.println();
		}
		CommonDBUtil.close(session);

	}

}
