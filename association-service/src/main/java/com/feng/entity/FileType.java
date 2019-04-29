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
 * @since 2019-04-27
 */
public class FileType implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 社团类型
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 社团类型
     */
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
        return "FileType{" +
        "id=" + id +
        ", type=" + type +
        "}";
    }
}
