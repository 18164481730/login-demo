package com.tangzhihe;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tangzhihe.domain.Book;
import com.tangzhihe.service.BookService;
import com.tangzhihe.util.Page;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootLoginDemoApplicationTests {
	@Autowired
	private BookService bookService;
	@Test
	public void testQueryByPage() {
		Book book = new Book();
		Page<Book> page = new Page<Book>();
		page.setPageNum(1);
		page.setNumPerPage(5);
		Page<Book> pages = bookService.queryBookListByPage(page, book);
		System.out.println(pages);
	}

}
