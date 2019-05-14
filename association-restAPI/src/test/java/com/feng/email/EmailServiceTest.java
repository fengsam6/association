package com.feng.email;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 * Created by rf on 2019/4/9.
 */
@RunWith(SpringRunner.class)
@MapperScan("com.feng.dao")
@ComponentScan("com.feng.mail")
@SpringBootTest
public class EmailServiceTest {
    @Autowired
    private MailService mailService;
    @Autowired
    private TemplateEngine templateEngine;

    @Test
    public void sendEmailTest() {
        Context context = new Context();
        context.setVariable("email","111");
       String content = templateEngine.process("emailTemplate",context);
//        mailService.sendSimpleMail("激活邮箱", content, "18327853685@163.com");
    }
}
