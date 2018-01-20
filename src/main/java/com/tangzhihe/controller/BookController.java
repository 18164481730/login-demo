package com.tangzhihe.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tangzhihe.domain.Book;
import com.tangzhihe.model.BookModel;
import com.tangzhihe.service.BookService;


/** 
 * 教程页面
 */
@Controller
@RequestMapping("/book")
public class BookController  extends AbstractController{
    @Autowired
    private BookService bookService;

    /**
     * 查询列表
     * @param map
     * @return
     */
    @RequestMapping("")
    public String book(ModelMap map){
        map.addAttribute("ctx", getContextPath()+"/");
        BookModel bookModel = new BookModel();
        List<Book> bookList = bookService.queryBookList(bookModel);
        map.addAttribute("books", bookList);
        return "bookList";
    }
    
    /**
     * 显示用户列表
     * @param map
     * @return
     */
    @RequestMapping(value = "/showAddPage" , method = RequestMethod.GET)
    public String createUserForm(ModelMap map) {
    	return "bookAdd";
    }
    
    
}

















