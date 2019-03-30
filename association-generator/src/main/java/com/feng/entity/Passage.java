package com.feng.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author rf
 * @since 2019-03-11
 */
public class Passage implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 文章id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 文章标题
     */
    private String title;
    /**
     * 文章内容
     */
    private String content;
    /**
     * 文章发布者
     */
    private String publisher;
    /**
     * 文章来源
     */
    private String source;
    /**
     * 文章类型
     */
    private Integer passageType;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Integer getPassageType() {
        return passageType;
    }

    public void setPassageType(Integer passageType) {
        this.passageType = passageType;
    }

    @Override
    public String toString() {
        return "Passage{" +
        "id=" + id +
        ", title=" + title +
        ", content=" + content +
        ", publisher=" + publisher +
        ", source=" + source +
        ", passageType=" + passageType +
        "}";
    }
}
