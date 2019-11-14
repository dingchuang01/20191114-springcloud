package com.aaa.dc.springcloud.controller;

import com.aaa.dc.springcloud.model.Book;
import com.aaa.dc.springcloud.service.ISpringcloudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private ISpringcloudService iSpringcloudService;

    @RequestMapping("/all")
    public List<Book> selectAllBooks(){
        return iSpringcloudService.selectAllBooks();
    }
}
