package com.feng;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.feng.dao")
@EnableCaching
public class AssociationRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(AssociationRestApplication.class, args);
    }

}
