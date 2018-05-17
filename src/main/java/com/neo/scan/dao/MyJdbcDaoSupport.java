package com.neo.scan.dao;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MyJdbcDaoSupport extends JdbcDaoSupport implements SpringJdbcDaoSupportSDAO  {

	@Autowired
	public MyJdbcDaoSupport(DataSource dataSource) {
		this.setDataSource(dataSource);
	}
	
	@Override
	public List<Map<String, Object>> execQuery(String methodFunction,Object[] arrayParams) {
		return getJdbcTemplate().queryForList(methodFunction,arrayParams);
	}

	@Override
	public String getValue(String methodFunction, Object[] arrayParams) {
		return (String)getJdbcTemplate().queryForObject(methodFunction,arrayParams, String.class);
	}

	@Override
	public int execUpdate(String methodFunction, Object[] arrayParams) {
		return 0;
	}

	@Override
	public List<Map<String, Object>> getRef(String methodFunction, Object[] arrayParams) {
		return getJdbcTemplate().queryForList(methodFunction,arrayParams);
	}
	
	@Override
	public String getValueInt(String methodFunction, Object[] arrayParams){
		List list = getJdbcTemplate().queryForList(methodFunction,arrayParams);
		Object map = list.get(0);
		System.out.println("map"+map);
		return getJdbcTemplate().queryForList(methodFunction,arrayParams).get(0).get("result").toString();
	}

}
