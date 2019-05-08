package com.feng.vo;

import com.feng.entity.File;
import com.feng.entity.Passage;
import com.feng.entity.PassageType;
import lombok.Data;

import java.util.List;

/**
 * Created by rf on 2019/5/3.
 */
@Data
public class PassageInfoVo extends Passage {
    private PassageType PassageType;
    private List<File> fileList;
}
