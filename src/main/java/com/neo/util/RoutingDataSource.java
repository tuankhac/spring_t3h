package com.neo.util;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class RoutingDataSource extends AbstractRoutingDataSource {
	
	@Override
	protected Object determineCurrentLookupKey() {
		if(DataSourceContext.getDataSource() == null){
			DataSourceContext.setDataSource(DataSourceCategory.FJL);
		}
		
		return DataSourceContext.getDataSource();
	}
}
