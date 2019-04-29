package com.feng;

import com.feng.conf.FileUploadConf;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.feng.dao")
@EnableCaching
public class AssociationAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssociationAdminApplication.class, args);
	}

}
