package com.feng;

import com.feng.service.PassageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AssociationRestApplicationTests {
	@Autowired
	private PassageService passageService;

//	@Test
	public void get() {
		passageService.getInfoById(1);

	}
	@Test
	public void contextLoads() {
	}

}
