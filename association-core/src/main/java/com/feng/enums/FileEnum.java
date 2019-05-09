package com.feng.enums;

import lombok.Data;

/**
 * Created by rf on 2019/4/27.
 */

public enum FileEnum {
    COMMON_IMG(1, "普通图片"),
    COMMON_FILE(2, "常用文档"),
    CLUB_FILE(3, "社团文件"),
    CAROUSEL_IMG(4, "常用文档"),
    PASSAGE_IMG(5, "普通图片"),
    ACTIVITY_IMG(6, "普通图片");
    private int fileId;
    private String fileType;

    FileEnum(int fileId, String fileType) {
        this.fileId = fileId;
        this.fileType = fileType;
    }

    public int getFileId() {
        return fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
}
