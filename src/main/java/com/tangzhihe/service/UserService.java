package com.tangzhihe.service;

import java.util.List;

import com.tangzhihe.domain.User;


public interface UserService {
	public List<User> queryUserList(User user);
	public int save(User user);
	public int update(User user);
}
