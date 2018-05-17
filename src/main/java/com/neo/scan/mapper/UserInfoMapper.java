package com.neo.scan.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.neo.scan.model.UserInfo;

public class UserInfoMapper implements RowMapper<UserInfo> {

	public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		String userName = rs.getString("USERNAME");
		String password = rs.getString("PASSWORD");
		return new UserInfo(userName, password);
	}

}