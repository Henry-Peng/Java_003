package com.peng.model;
/**
 * 书籍类
 * @author pfh
 * @date 2020年6月10日
 */
public class Book {
	
	private int  id;
	private String name;
	private String author;
	private double price;
	private String publish;
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", price=" + price + ", publish=" + publish
				+ "]";
	}
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
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getPublish() {
		return publish;
	}
	public void setPublish(String publish) {
		this.publish = publish;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(int id, String name, String author, double price, String publish) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.price = price;
		this.publish = publish;
	}
	

}
