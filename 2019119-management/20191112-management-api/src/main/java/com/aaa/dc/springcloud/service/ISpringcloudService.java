package com.aaa.dc.springcloud.service;

import com.aaa.dc.springcloud.model.Book;
import com.aaa.dc.springcloud.service.fallback.ISpringcloudFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 *
 * 注解中的值是eureka中 application.name的值
 * 映射的主要配置就是在service接口上加注解@FeignClient(“eureka中application的值”),因为在provider中定义了application.name在e
 * ureka中的值是大写的BOOK-PROVIDER所以可以直接映射provider中的controller中的方法
 */
@FeignClient(value = "BOOK-PROVIDER",fallbackFactory = ISpringcloudFallbackFactory.class)
public interface ISpringcloudService {

    @RequestMapping("/all")
    List<Book> selectAllBooks();


}
