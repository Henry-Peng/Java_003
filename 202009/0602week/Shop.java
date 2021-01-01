package com.peng.model;
/**
 * 商品类
 * @author pfh
 * @date 2020年6月10日
 */
public class Shop {
	
	private int id;
	private String name;
	private String brand;
	private double price;
	private String series;
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getSeries() {
		return series;
	}
	public void setSeries(String series) {
		this.series = series;
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
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Shop() {
	}
	public Shop(int id, String name, String brand, double price, String series) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.series = series;
	}
	@Override
	public String toString() {
		return "Shop [id=" + id + ", name=" + name + ", brand=" + brand + ", price=" + price + ", series=" + series
				+ "]";
	}
	

}
