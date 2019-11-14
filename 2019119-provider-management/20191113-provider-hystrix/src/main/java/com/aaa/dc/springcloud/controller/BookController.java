package com.aaa.dc.springcloud.controller;

import com.aaa.dc.springcloud.model.Book;
import com.aaa.dc.springcloud.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**consumer的controller调用service接口
 *      --->service接口映射provider中controller
 *      --->但是provider中的controller抛出异常
 *      --->调用selectAllBooks()备用方法
 *      @HystrixCommand指向后备的方法
 */
@RestController
public class BookController {
    @Autowired
    private BookService bookService;
    @RequestMapping("/all")
    //@HystrixCommand(fallbackMethod = "selectAllBooksFallBack")
    public List<Book> selectAllBooks() throws Exception {
        List<Book> books = bookService.selectAll();
        if(books.size()>0){
            throw new Exception("测试熔断。抛异常");
        }
        return books;
    }
    /*public List<Book> selectAllBooksFallBack() {
        List<Book> bookList = new ArrayList<Book>();
        Book book = new Book();
        book.setId(100000000L);
        book.setBookName("测试熔断-->图书名称");
        book.setBookPrice(123.23);
        bookList.add(book);
        return bookList;
    }*/
}

