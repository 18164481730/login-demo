package com.tangzhihe.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tangzhihe.domain.Book;
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
        Book book = new Book();
        List<Book> bookList = bookService.queryBookList(book);
        map.addAttribute("books", bookList);
        return "bookList";
    }
    
    /**
     * 显示用户列表
     * @param map
     * @return
     */
    @RequestMapping(value = "/showAddPage" , method = RequestMethod.GET)
    public String showAddPage() {
    	return "bookAdd";
    }
    
    /**
     * 显示用户更新页面
     * @return
     */
    @RequestMapping(value = "/showUpdatePage" , method = RequestMethod.GET)
    public String showUpdatePage(HttpServletRequest request, HttpServletResponse response) {
    	String id = request.getParameter("id"); 
    	Book book = new Book(); 
    	book.setId(Long.parseLong(id));
    	List<Book> bookList = bookService.queryBookList(book);
    	if(bookList.size() > 0) {
    		ModelMap map = new ModelMap();
    		map.addAttribute("book", bookList.get(0));
    	}
    	return "bookUpdate";
    }
    
    
    /**
     * 删除用户列表
     * @param id
     */
    @RequestMapping(value = "/deleteBook" , method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> deleteBook(@RequestBody Long id) {
    	Map<String,Object> map = new HashMap<String,Object>();
    	try {
    		bookService.delete(id);
		} catch (Exception e) {
			map.put("msg", "执行错误!");
		}
    	map.put("msg", "执行成功!");
    	return map;
    }
}

















