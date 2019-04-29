package com.feng.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author rf
 * @since 2019-04-08
 */
public class OneColumn implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 社团名称
     */
    private String clubName;
    /**
     * 社团概况
     */
    private String clubSummary;
    /**
     * 社团简介
     */
    private String introduce;
    /**
     * 社团快讯
     */
    private String notice;
    /**
     * 社团活动风采
     */
    private String show;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getClubSummary() {
        return clubSummary;
    }

    public void setClubSummary(String clubSummary) {
        this.clubSummary = clubSummary;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getShow() {
        return show;
    }

    public void setShow(String show) {
        this.show = show;
    }

    @Override
    public String toString() {
        return "OneColumn{" +
        "id=" + id +
        ", clubName=" + clubName +
        ", clubSummary=" + clubSummary +
        ", introduce=" + introduce +
        ", notice=" + notice +
        ", show=" + show +
        "}";
    }
}
