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
 * @since 2019-03-03
 */
public class UserRank implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 职称id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 职称名称
     */
    private String rankName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRankName() {
        return rankName;
    }

    public void setRankName(String rankName) {
        this.rankName = rankName;
    }

    @Override
    public String toString() {
        return "UserRank{" +
        "id=" + id +
        ", rankName=" + rankName +
        "}";
    }
}
