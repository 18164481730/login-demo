package com.tangzhihe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tangzhihe.dao.UserDao;
import com.tangzhihe.domain.User;
import com.tangzhihe.service.UserService;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public List<User> queryUserList(User user) {
		return userDao.queryUserList(user);
	}

	@Override
	public int save(User user) {
		return userDao.insertByUser(user);
	}

	@Override
	public int update(User user) {
		return userDao.updateByUser(user);
	}

}
