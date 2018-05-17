package com.neo.scan.authentication;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.neo.scan.dao.UserInfoDAO;
import com.neo.scan.model.UserInfo;

@Service
public class UserLoginAuthenticationService implements UserDetailsService {

	@Autowired
	private UserInfoDAO userInfoDAO;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserInfo userInfo = userInfoDAO.findUserInfo(username);
		System.out.println("UserInfo= " + userInfo);

		if (userInfo == null) {
			throw new UsernameNotFoundException("User " + username + " was not found in the database");
		}

		// [USER,ADMIN,..]
		List<String> roles = userInfoDAO.getUserRoles(username);
		//System.out.println("roles :" + roles);
		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		if (roles != null) {
			for (String role : roles) {
				// ROLE_USER, ROLE_ADMIN,..
				GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + role);
				grantList.add(authority);
			}
		}
		UserDetails userDetails = (UserDetails) new User(userInfo.getUserName(), userInfo.getPassword(), grantList);
		return userDetails;
	}

}