package com.feng.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author rf
 * @since 2019-04-17
 */
public class Club implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 社团编号
     */
    @TableId(value = "num")
    private Integer num;
    /**
     * 社团名称
     */
    private String name;
    /**
     * 社团简介
     */
    private String introduce;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
    /**
     * 社团类型id
     */
    private Integer clubTypeId;
    /**
     * 社团状态
     */
    private Integer status;


    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getClubTypeId() {
        return clubTypeId;
    }

    public void setClubTypeId(Integer clubTypeId) {
        this.clubTypeId = clubTypeId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Club{" +
        "num=" + num +
        ", name=" + name +
        ", introduce=" + introduce +
        ", createTime=" + createTime +
        ", clubTypeId=" + clubTypeId +
        ", status=" + status +
        "}";
    }
}
