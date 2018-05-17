//package com.neo.scan.dao;
//
//import java.util.List;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.support.JdbcDaoSupport;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public class QueryForListReturnListDAO extends JdbcDaoSupport {
//
//	@Autowired
//	public QueryForListReturnListDAO(DataSource dataSource) {
//		this.setDataSource(dataSource);
//	}
//
//	public List<String> getDeptNames() {
//
//		String sql = "Select first_name from user_info ";
//
//		// queryForList(String sql, Class<T> elementType)
//		List<String> list = this.getJdbcTemplate().queryForList(sql, String.class);
//
//		return list;
//	}
//
//	public List<String> getDeptNames(String searchName) {
//
//		String sql = "Select first_name from user_info "//
//				+ " Where first_name like ? ";
//
//		// queryForList(String sql, Class<T> elementType, Object... args)
//		List<String> list = this.getJdbcTemplate().queryForList(sql, String.class, //
//				"%" + searchName + "%");
//
//		return list;
//	}
//
//}