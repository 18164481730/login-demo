package com.tangzhihe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tangzhihe.dao.BookDao;
import com.tangzhihe.domain.Book;
import com.tangzhihe.model.BookModel;
import com.tangzhihe.service.BookService;


@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao  bookDao;

    @Override
    public List<Book> queryBookList(BookModel bookModel) {
        return bookDao.queryBookList(bookModel);
    }

	@Override
	public int save(Book Book) {
		return bookDao.insertByBook(Book);
	}

	@Override
	public int update(Book Book) {
		return bookDao.updateByBook(Book);
	}

	@Override
	public void delete(Long id) {
		bookDao.deleteByBook(id);
	}
}
