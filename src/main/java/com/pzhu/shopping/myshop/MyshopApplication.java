package com.pzhu.shopping.myshop;

import com.pzhu.shopping.myshop.commons.redis.JedisClientPool;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages = "com.pzhu.shopping.myshop.mapper")
@ComponentScan("com.pzhu.*")
public class MyshopApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyshopApplication.class, args);
    }
}
