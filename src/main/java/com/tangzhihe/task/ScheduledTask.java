package com.tangzhihe.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.tangzhihe.domain.Book;
import com.tangzhihe.service.BookService;

@Component
@Configurable
@EnableScheduling
public class ScheduledTask {
	@Autowired
	private BookService bookService;
	
	@Scheduled(cron = "0 0/20 * * * ?")
	public void getTask1() {
		System.out.println("*****************定时任务开启******************");
		Book book = new Book();
		book.setBookName("算法");
		book.setAuthor("我杰");
		book.setTitle("超级屌");
		bookService.save(book);
		System.out.println("*****************定时任务结束******************");
	}
}





















