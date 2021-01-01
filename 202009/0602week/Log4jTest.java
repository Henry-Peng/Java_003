package com.peng.test;

import org.apache.log4j.Logger;

/**
 * 
 * @author pfh
 * @date 2020年6月8日
 */
public class Log4jTest {

	public static Logger logger = Logger.getLogger(Log4jTest.class);
	
	public static void main(String[] args) {
		logger.info("进入Log4jTest...");
		logger.debug("debug执行...");
		logger.info("info执行...");
		logger.warn("warn执行...");
		logger.error("error执行...");
		logger.fatal("fatal执行...");
	}

}
