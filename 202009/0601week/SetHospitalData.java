package com.peng.implement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 从mysql数据库中读取hospital数据,并将读取到的数据写入另一个数据库中
 * @author pfh
 * @date 2020年6月3日
 */
public class SetHospitalData {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String dataBaseName = "hospital";//原有数据库名称
		String newDataBaseName = "hospitals";//新建数据库名称
		Map<String, List<Map<String, Object>>> dataBase = null;//暂存数据库所有表格数据的集合
		
		dataBase = connectDB(dataBaseName);//读取数据
		//System.out.println(dataBase);
		cresteNewDataBase(newDataBaseName, dataBase);
	}
	
	/**
	 * 根据已有数据,创建一个新的数据库
	 * @param newDataBaseName 新的数据库名称
	 * @param dataBase 存放数据的map集合
	 *  */
	private static void cresteNewDataBase(String newDataBaseName, Map<String, List<Map<String, Object>>> dataBase) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" , "root", "root");
		Statement statement = connection.createStatement();
		String sql = "create database " + newDataBaseName ;
		statement.execute(sql);//只能执行一次
		for (String tableName : dataBase.keySet()) {
			createNewTable(tableName, dataBase.get(tableName), statement);
		}
		
	}

	/**
	 * 根据已有数据,新建一个表格
	 * @param tableName 表格名称
	 * @param list 数据集合
	 * @param statement 与mysql数据库的连接接口
	 * @throws SQLException 
	 */
	private static void createNewTable(String tableName, List<Map<String, Object>> list, Statement statement) throws SQLException {
		String sqls = "create table " + tableName;
		statement.execute(sqls);
		for (Map<String, Object> rawData : list) {//划分到每一行,对应一个map集合
			for (String columnName : rawData.keySet()) {//每一行划分到每一列
				String sql = "alter table " + tableName  ;
				statement.execute(sql);
			}
		}
	
		
	}





	/**
	 * 指定一个数据库:自动输出该数据库内的所有表格内容
	 */
	public static Map<String, List<Map<String, Object>>> connectDB(String dataBaseName) throws ClassNotFoundException, SQLException{
		/*
		 * 利用给定的数据库名称,与mysql数据建立连接
		 */
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dataBaseName, "root", "root");
		
		/*
		 * 创建接口
		 */
		Statement statement = connection.createStatement();
		String sql = "show tables;" ;
		ResultSet resultSet = statement.executeQuery(sql);
		
		/*
		 * 先建立一个列表,用来存放数据库内的表格名称
		 */
		List<String> tables = new ArrayList<String>();//用来存放数据库里的表名称
		while (resultSet.next()) {
			tables.add(resultSet.getString(1)) ;
		}
		//System.out.println(dataBaseName + "包含的表格有:" + tables.toString());
		
		/*
		 * 循环读取每一个表格的数据,放入map集合中
		 */
		Map<String, List<Map<String, Object>>> dataBase = new HashMap<>();
		for (String table : tables) {
			//System.out.println("***********" + table + "*************");
			dataBase.put(table, queryTables(table,statement));
		}
		return dataBase;
		
	}
	
	/**
	 * 查询数据库里的指定表格的数据
	 */
	private static List<Map<String, Object>> queryTables(String table,Statement statement) throws SQLException {
		String sql = "select * from " + table;
		ResultSet resultSet = statement.executeQuery(sql);
		ResultSetMetaData rsmt = resultSet.getMetaData();//获得结果集结构信息,元数据
		int columnCount = rsmt.getColumnCount();//每一行的列数
		Map<String, Object> rawData = null;//用来存放每一行的数据
		List<Map<String, Object>> tableData = new ArrayList<>();//用来存放整个表格的数据
		/*
		 * 获取每一行数据
		 */
		while(resultSet.next()){
			rawData = new HashMap<String, Object>();//一行数据一个集合
			for (int i = 1; i <= columnCount; i++) {
				rawData.put(rsmt.getColumnName(i), resultSet.getObject(i));
			}
			//System.out.println(rawData);//输出每一行数据
			tableData.add(rawData);//将行数据存入list集合中
		}
		return tableData;
	}

}
