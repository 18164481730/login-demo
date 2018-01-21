package com.tangzhihe.service;

import java.util.List;

import com.tangzhihe.domain.Book;

public interface BookService {
	public List<Book> queryBookList(Book book);
	
	public int save(Book Book);
	
	public int update(Book Book);
	
	public void delete(Long id);
}
