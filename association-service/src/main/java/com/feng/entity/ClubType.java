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
 * @since 2019-04-14
 */
public class ClubType implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 文章类型
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 文章类型
     */
    @NotBlank(message = "社团类型不能为空")
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
        return "ClubType{" +
        "id=" + id +
        ", type=" + type +
        "}";
    }
}
