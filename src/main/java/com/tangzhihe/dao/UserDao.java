package com.tangzhihe.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.tangzhihe.domain.User;

public interface UserDao {
	public List<User> queryUserList(@Param("entity")User user);
}
