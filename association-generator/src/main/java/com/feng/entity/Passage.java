package com.feng.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author rf
 * @since 2019-05-08
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
    private Integer passageTypeId;
    /**
     * 发布文章的社团id
     */
    private Integer clubId;
    private Date publishTime;
    /**
     * 点击次数
     */
    private Integer clickNum;


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

    public Integer getPassageTypeId() {
        return passageTypeId;
    }

    public void setPassageTypeId(Integer passageTypeId) {
        this.passageTypeId = passageTypeId;
    }

    public Integer getClubId() {
        return clubId;
    }

    public void setClubId(Integer clubId) {
        this.clubId = clubId;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Integer getClickNum() {
        return clickNum;
    }

    public void setClickNum(Integer clickNum) {
        this.clickNum = clickNum;
    }

    @Override
    public String toString() {
        return "Passage{" +
        "id=" + id +
        ", title=" + title +
        ", content=" + content +
        ", publisher=" + publisher +
        ", source=" + source +
        ", passageTypeId=" + passageTypeId +
        ", clubId=" + clubId +
        ", publishTime=" + publishTime +
        ", clickNum=" + clickNum +
        "}";
    }
}
