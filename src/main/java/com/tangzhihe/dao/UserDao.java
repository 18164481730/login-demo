package com.tangzhihe.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tangzhihe.domain.User;


public interface UserDao {
	/**
	 * 查询用户
	 * @param user
	 * @return
	 */
	public List<User> queryUserList(@Param("entity")User user);
	/**
	 * 插入数据
	 * @param learnResource
	 * @return
	 */
	public int insertByUser(@Param("entity")User user);
	
	/**
	 * 更新数据
	 * @param learnResource
	 * @return
	 */
	public int updateByUser(@Param("entity")User user);
}
