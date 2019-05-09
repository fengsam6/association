package com.feng.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author rf
 * @since 2019-05-05
 */
@Data
public class File implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 文件名称
     */
    private String fileName;
    /**
     * 文件路径
     */
    private String filePath;
    private Date createTime;
    private Integer fileTypeId;
    private Integer passageId;
    private Integer activityId;



    public File() {
    }

    public File(String fileName, String filePath, Integer fileTypeId) {
        this.fileName = fileName;
        this.filePath = filePath;
        this.fileTypeId = fileTypeId;
    }
}
