package com.aaa.dc.springcloud.controller;

import com.aaa.dc.springcloud.model.Book;
import com.aaa.dc.springcloud.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/all")
    public List<Book> selectAllBooks(){
        System.out.println("8082");
        List<Book> books = bookService.selectAll();
        return books;
    }

}

