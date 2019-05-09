package com.feng.dto;

import com.feng.entity.File;
import com.feng.entity.Passage;
import com.feng.entity.PassageType;
import lombok.Data;

import java.util.List;

/**
 * Created by rf on 2019/4/28.
 */
@Data
public class PassageFileDto extends Passage{
    private List<File> fileList;
}
