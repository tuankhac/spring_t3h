package com.neo.util;

public class DataSourceContext {

	private static final ThreadLocal<DataSourceCategory> contextHolder = new ThreadLocal<DataSourceCategory>();

	public static void setDataSource(DataSourceCategory dataSource) {
		if (dataSource == null) {
			contextHolder.set(DataSourceCategory.FJL);
		} else {
			contextHolder.set(dataSource);
		}
	}

	public static DataSourceCategory getDataSource() {
		return contextHolder.get();
	}

	public static void clearDataSource() {
		contextHolder.remove();
	}

}