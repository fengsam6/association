package com.feng.email;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;


import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Created by rf on 2019/3/30.
 */
@Component
@Slf4j
//@ImportResource("application.properties")
public class MailService {
    @Autowired
    private JavaMailSender mailSender; // 自动注入的Bean
    @Value("${spring.mail.username}")
    private String from;

    /**
     * 发送简易邮件
     */
    public void sendSimpleMail(String subject,String context,  String to) {
        log.info("发送邮件");
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        try {
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(context,true);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        mailSender.send(mimeMessage);
    }
}
