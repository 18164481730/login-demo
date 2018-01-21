package com.tangzhihe.service;

import java.util.List;

import com.tangzhihe.domain.Book;
import com.tangzhihe.util.Page;

public interface BookService {
	public Page<Book> queryBookListByPage(Page<Book> page,Book book);
	
	public List<Book> queryBookList(Book book);
	
	public int save(Book Book);
	
	public int update(Book Book);
	
	public void delete(Long id);
}
