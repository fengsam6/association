package com.feng;

import com.feng.entity.File;
import com.feng.service.FileService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AssocoationAdminApplicationTests {
	@Autowired
private FileService fileService;
	@Test
	public void contextLoads() {
		File file = new File("test.txt","/test/",1);
	int fileId =	fileService.save(file);
	System.out.println(file.toString());
	}

}
