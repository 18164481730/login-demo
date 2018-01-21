package com.tangzhihe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tangzhihe.dao.BookDao;
import com.tangzhihe.domain.Book;
import com.tangzhihe.service.BookService;
import com.tangzhihe.util.Page;


@Service
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao  bookDao;

    @Override
    public List<Book> queryBookList(Book book) {
        return bookDao.queryBookList(book);
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

	@Override
	public Page<Book> queryBookListByPage(Page<Book> page, Book book) {
		int start = (page.getNumPerPage() - 1) * page.getPageNum();
		page.setPageNum(start);
		List<Book> list = bookDao.queryBookListByPage(page, book);
		Page<Book> bookPage = new Page<Book>();
		bookPage.setNumPerPage(page.getPageNum());
		bookPage.setPageList(list);
		return bookPage;
	}
}

















