package com.tangzhihe.model;

import com.tangzhihe.domain.Book;

public class BookModel extends Book{
	/**
	 * 书名
	 */
    private String bookName;
    /**
     * 作者
     */
    private String author;
    
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
    
}
