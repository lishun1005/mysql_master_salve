package com.lishun.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author lishun
 * @Description:动态数据源, 继承AbstractRoutingDataSource
 * @date 2018/2/9
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
	public static final Logger log = LoggerFactory.getLogger(DynamicDataSource.class);

	/**
	 * 默认数据源
	 */
	public static final String DEFAULT_DS = "read_ds";
	private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();
	public static void setDB(String dbType) {// 设置数据源名
		log.info("切换到{}数据源", dbType);
		contextHolder.set(dbType);
	}

	public static void clearDB() {
		contextHolder.remove();
	}// 清除数据源名
	@Override
	protected Object determineCurrentLookupKey() {
		return contextHolder.get();
	}
}
