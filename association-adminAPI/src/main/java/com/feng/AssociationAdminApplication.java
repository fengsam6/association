package com.feng;

import com.feng.util.ApplicationContextInfoUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@MapperScan("com.feng.dao")
@EnableCaching
@RestController
public class AssociationAdminApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext =SpringApplication.run(AssociationAdminApplication.class, args);
		//打印系统访问信息
		ApplicationContextInfoUtils.printSystemInfo(applicationContext);
	}

}
