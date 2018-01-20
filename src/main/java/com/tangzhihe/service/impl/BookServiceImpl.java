package com.tangzhihe.service.impl;

import java.util.Arrays;
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
    private BookDao  BookDao;

    @Override
    public List<Book> queryBookList(BookModel bookModel) {
        return BookDao.queryBookList(bookModel);
    }

	@Override
	public int save(Book Book) {
		return BookDao.insertByBook(Book);
	}

	@Override
	public int update(Book Book) {
		return BookDao.updateByBook(Book);
	}

	@Override
	public void delete(Long[] ids) {
		 Arrays.stream(ids).forEach(id->BookDao.deleteByBook(id));
	}
}
