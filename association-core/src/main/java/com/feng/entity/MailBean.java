package com.feng.entity;

import lombok.Data;
import org.springframework.core.io.FileSystemResource;

/**
 * Created by rf on 2019/3/30.
 */
@Data
public class MailBean {
    /**
     * 邮件主题
     */
    private String subject;

    /**
     * 邮件内容
     */
    private String text;

    /**
     * 附件
     */
    private FileSystemResource file;

    /**
     * 附件名称
     */
    private String attachmentFilename;

    /**
     * 内容ID，用于发送静态资源邮件时使用
     */
    private String contentId;
}
