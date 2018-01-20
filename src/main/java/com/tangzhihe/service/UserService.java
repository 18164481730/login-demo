package com.tangzhihe.service;

import java.util.List;
import com.tangzhihe.domain.User;
import org.apache.ibatis.annotations.Param;


public interface UserService {
	public List<User> queryUserList(@Param("entity")User user);
	public void deleteBatch(Long[] ids);
}
