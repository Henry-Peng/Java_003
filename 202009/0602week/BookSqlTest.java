package com.peng.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.peng.dao.BookDao;
import com.peng.model.Book;
import com.peng.utils.CommonDBUtil;

/**
 * 书籍SQl测试类
 * @author pfh
 * @date 2020年6月10日
 */
public class BookSqlTest {
	static List<Book> lists = new ArrayList<>();
	

	public static void main(String[] args) {
		SqlSession session = CommonDBUtil.getSqlSession();
		BookDao bookDao = session.getMapper(BookDao.class);
		Book book = new Book(18, "高考历年真题", "招生考试院", 888, "人民出版社");
		//getListById(bookDao, book);
		//getListByName(bookDao, book);
		//getListByAuthor(bookDao, book);
		//getChooseOne(bookDao, book);
		//getListByForeach(bookDao);
		insertNewBook(bookDao, book);
		updateBookPrice(bookDao, book);
		session.commit();
		session.close();
	}
	
	public static void getListById(BookDao bookDao, Book book) {
		lists = bookDao.getListById(book);
		for (Book list : lists) {
			System.out.println(list);
		}
	}

	public static void getListByName(BookDao bookDao, Book book) {
		lists = bookDao.getListByName(book);
		for (Book list : lists) {
			System.out.println(list);
		}
	}

	public static void getListByAuthor(BookDao bookDao, Book book) {
		lists = bookDao.getListByAuthor(book);
		for (Book list : lists) {
			System.out.println(list);
		}
	}

	public static void getChooseOne(BookDao bookDao, Book book) {
		lists = bookDao.getChooseOne(book);
		for (Book list : lists) {
			System.out.println(list);
		}
	}
	
	public static void getListByForeach(BookDao bookDao) {
		List<String> publish = new ArrayList<>();
		publish.add("海天出版社");
		publish.add("人民出版社");
		lists = bookDao.getListByForeach(publish);
		for (Book list : lists) {
			System.out.println(list);
		}
	}
	
	public static void insertNewBook(BookDao bookDao, Book book) {
		int resultNum = bookDao.insertNewBook(book);
		System.out.println((resultNum>0)? "添加" + book.getName() + "成功": "添加" + book.getName() + "失败");
	}
	
	public static void updateBookPrice(BookDao bookDao, Book book) {
		book.setPrice(666);
		int resultNum = bookDao.updateBookPrice(book);
		System.out.println((resultNum>0)? "修改" + book.getName() + "成功": "修改" + book.getName() + "失败");
	}
}
