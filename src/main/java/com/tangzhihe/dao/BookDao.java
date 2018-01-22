package com.tangzhihe.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tangzhihe.domain.Book;

public interface BookDao {
	/**
	 * 查询全部数据
	 * @param map
	 * @return
	 */
	public List<Book> queryBookList(@Param("entity") Book book);
	
	/**
	 * 删除数据
	 * @param userId
	 * @return
	 */
	public int deleteByBook(Long id);
	
	/**
	 * 插入数据
	 * @param learnResource
	 * @return
	 */
	public int insertByBook(@Param("entity") Book book);
	
	/**
	 * 更新数据
	 * @param learnResource
	 * @return
	 */
	public int updateByBook(@Param("entity") Book book);
}























