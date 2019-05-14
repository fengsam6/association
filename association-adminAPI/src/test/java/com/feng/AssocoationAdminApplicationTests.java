package com.feng;

import com.feng.dao.PassageMapper;
import com.feng.entity.File;
import com.feng.entity.Passage;
import com.feng.service.FileService;
import com.feng.service.PassageService;
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
	@Autowired
	private PassageService passageService;
	@Test
	public void contextLoads() {
		File file = new File("test.txt","/test/",1);
//	int result =	fileService.save(file);
//	System.out.println(result);
	System.out.println(file.toString());
	}

	@Test
	public void testAddPassage(){
		Passage passage =new Passage("test","content",3);
//	passageService.add(passage);
//		System.out.println(result);
		System.out.println(passage.toString());
	}
}
