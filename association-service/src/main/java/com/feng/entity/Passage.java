package com.feng.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author rf
 * @since 2019-03-04
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
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
    @NotNull(message = "文章标题不能为空")
    private String title;
    /**
     * 文章内容
     */
    @NotNull(message = "文章内容不能为空")
    private String content;
    /**
     * 文章发布者
     */
    @NotNull(message = "文章发布者不能为空")
    private String publisher;
    /**
     * 文章来源
     */
    @NotNull(message = "文章来源不能为空")
    private String source;
    /**
     * 文章类型
     */
    @NotNull(message = "文章类型不能为空")
    private Integer passageType;

}
