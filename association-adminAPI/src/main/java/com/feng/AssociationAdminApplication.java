package com.feng;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@MapperScan("com.feng.dao")
@EnableCaching
@RestController
public class AssociationAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssociationAdminApplication.class, args);
	}

}
