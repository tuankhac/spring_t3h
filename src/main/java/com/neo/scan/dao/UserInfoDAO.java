package com.neo.scan.dao;

import java.util.List;

import com.neo.scan.model.UserInfo;

 
public interface UserInfoDAO {
    public UserInfo findUserInfo(String userName);

    // [USER,AMIN,..]
    public List<String> getUserRoles(String userName);
     
}