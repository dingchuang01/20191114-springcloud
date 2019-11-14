package com.aaa.dc.springcloud.service.fallback;

import com.aaa.dc.springcloud.model.Book;
import com.aaa.dc.springcloud.service.ISpringcloudService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ISpringcloudFallbackFactory implements FallbackFactory<ISpringcloudService> {

    @Override
    public ISpringcloudService create(Throwable throwable) {

        return new ISpringcloudService() {
            @Override
            public List<Book> selectAllBooks() {
                System.out.println("我是测试熔断方法");
                return null;
            }
        };
    }
}
