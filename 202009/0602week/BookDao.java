package com.peng.dao;

import java.util.List;

import com.peng.model.Book;

/**
 * 书籍类的接口类
 * @author pfh
 * @date 2020年6月10日
 */
public interface BookDao {
	
	public List<Book> getListById(Book book);
	
	public List<Book> getListByName(Book book);
	
	public List<Book> getListByAuthor(Book book);
	
	public List<Book> getChooseOne(Book book);
	
	public List<Book> getListByForeach(List<String> list);
	
	public int insertNewBook(Book book);
	
	public int updateBookPrice(Book book);
}
