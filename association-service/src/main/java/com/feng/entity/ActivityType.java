package com.feng.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author rf
 * @since 2019-04-17
 */
public class ActivityType implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 活动类型
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 活动类型
     */
    @NotBlank(message = "活动类型名称不能为空")
    private String type;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ActivityType{" +
        "id=" + id +
        ", type=" + type +
        "}";
    }
}
