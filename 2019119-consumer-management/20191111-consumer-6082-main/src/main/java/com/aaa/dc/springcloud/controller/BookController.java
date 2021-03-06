package com.aaa.dc.springcloud.controller;

import com.aaa.dc.springcloud.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class BookController {
    private static final String URL="http://BOOK-PROVIDER/";
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping("/all")
    public List<Book> selectAllBooks(){
       return  restTemplate.getForObject(URL+"all",List.class);
    }
    @RequestMapping("/allLB")
    public List<Book> selectUsersByLoadBalance(){
        // 1.通过loadBalancerClient对象获取到所有的服务提供者的信息(8081,8082,8083)
        // application.properties配置文件中book-provider.ribbon.listOfServers=localhost:8081,localhost:8082,localhost:8083
        // 通过8081，8082，8083中spring.application.name获取到
        // serviceId--->key(choose(Object key))
        // key--->spring.application.name的值
        // serviceInstance:每一个Server对象
        ServiceInstance serviceInstance = loadBalancerClient.choose("book-provider");
        //2.获取server的Ip地址
        String host = serviceInstance.getHost();
        System.out.println("host"+host);
        //3.获取server的port
        int port = serviceInstance.getPort();
        System.out.println("port"+port);
        return  restTemplate.getForObject("http://"+host+":"+port+"/all",List.class);
    }
}
