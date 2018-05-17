package com.neo.scan.dao;

import java.util.List;
import java.util.Map;

public interface SpringJdbcDaoSupportSDAO {
	public List<Map<String, Object>> execQuery(String methodFunction, Object[] arrayParams);

	public String getValue(String methodFunction, Object[] arrayParams);
	
	public String getValueInt(String methodFunction, Object[] arrayParams);

	public int execUpdate(String methodFunction, Object[] arrayParams);
	
	//hoan toan co the goi function, procedure, query
	public List<Map<String, Object>> getRef(String methodFunction, Object[] arrayParams);
}
