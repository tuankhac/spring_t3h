package com.neo.scan.dao;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neo.scan.mapper.UserInfoMapper;
import com.neo.scan.model.UserInfo;

@Service
@Transactional
public class UserInfoDAOImpl extends JdbcDaoSupport implements UserInfoDAO {

	@Autowired
	public UserInfoDAOImpl(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	public UserInfo findUserInfo(String userName) {
		String sql = "select ID USERNAME,PASSWORD from user_info where id =? ";

		Object[] params = new Object[] { userName };
		UserInfoMapper mapper = new UserInfoMapper();
		try {
			UserInfo userInfo = this.getJdbcTemplate().queryForObject(sql, params, mapper);
			return userInfo;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public List<String> getUserRoles(String userName) {
		String sql = "select ROLE_ID from user_role where USER_ID =? ";

		Object[] params = new Object[] { userName };
		List<String> roles = this.getJdbcTemplate().queryForList(sql, params, String.class);
		//this.queryForList
		List<Map<String, Object>> result = storeProcedureOneParameter(new Object[]{userName});
		//System.out.println("gia trị "+ result.get(0).get("ROLE_NAME"));
		return roles;
	}

	public List<Map<String, Object>> storeProcedureOneParameter(Object[] departId) {
		String storeProcedureName = "call list_role(?)";
		return getJdbcTemplate().queryForList(storeProcedureName,departId);
	}
}