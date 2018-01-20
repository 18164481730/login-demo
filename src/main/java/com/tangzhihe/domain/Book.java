package com.tangzhihe.domain;

public class Book {
	/**
	 * 主键ID
	 */
	private Long id;
	/**
	 * 书名
	 */
	private String bookName;
	/**
	 * 作者
	 */
	private String author;
	/**
	 * 描述
	 */
	private String title;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName == null ? null : bookName.trim();
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author == null ? null : author.trim();
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", bookName=" + bookName + ", author=" + author + ", title=" + title + "]";
	}
}



























